package ibirama.gestaodepessoal;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

public class App extends Application {

    ArrayList<Bombeiro> bombeiros = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        Bombeiro bombeiro1 = new Bombeiro("Murilo Zeferino", "Soldado", "Combate de Incêndio", "Afastado");
        Bombeiro bombeiro2 = new Bombeiro("Rian Rescarolli", "Soldado", "Operações Especiais", "Ativo");
        Bombeiro bombeiro3 = new Bombeiro("Filipe Teske", "Soldado", "Operações Especiais", "Ativo");
        Bombeiro bombeiro4 = new Bombeiro("João Peixe", "Soldado", "Mergulho", "Ativo");

        bombeiros.add(bombeiro1);
        bombeiros.add(bombeiro2);
        bombeiros.add(bombeiro3);
        bombeiros.add(bombeiro4);

        VBox root = new VBox();

        VBox cabecalho = new VBox(5);
        Label titulo = new Label("Sistema de Gerenciamento de Bombeiros");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        Label subtitulo = new Label("Corpo de Bombeiros - Gestão de Equipes");
        cabecalho.setPadding(new Insets(15));
        cabecalho.getChildren().addAll(titulo, subtitulo);
        root.getChildren().add(cabecalho);

        HBox menu = new HBox(10);
        menu.setPadding(new Insets(10));
        Button btnCadastrar = new Button("Cadastrar Bombeiro");
        Button btnConsultar = new Button("Consultar Bombeiro");
        menu.getChildren().addAll(btnCadastrar, btnConsultar);
        root.getChildren().add(menu);

        VBox topo = new VBox();
        topo.getChildren().addAll(cabecalho, menu);
        root.getChildren().add(topo);

        HBox cards = new HBox(20);
        cards.setPadding(new Insets(10));
        Label total = new Label("Total de Bombeiros: " + bombeiros.size());
        Label ativos = new Label("Bombeiros Ativos: 3");
        Label afastados = new Label("Bombeiros Afastados: 1");
        Label inativos = new Label("Bombeiros Inativos: 0");
        cards.getChildren().addAll(total, ativos, afastados, inativos);
        root.getChildren().add(cards);

        VBox centro = new VBox(15);
        centro.setPadding(new Insets(20));
        ListView<Bombeiro> lista = new ListView<>();
        Label recentes = new Label("Cadastros Recentes");
        recentes.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        lista.getItems().addAll(bombeiros);
        centro.getChildren().addAll(cards, recentes, lista);
        root.getChildren().add(centro);

        BorderPane tela = new BorderPane();
        tela.setTop(topo);
        tela.setCenter(centro);

        Scene scene = new Scene(tela, 1050, 600);

        stage.setTitle("Sistema de Bombeiros");
        stage.setScene(scene);

        EventHandler<MouseEvent> telaCadastro = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Stage cadastrar = new Stage();

                cadastrar.initModality(Modality.APPLICATION_MODAL);

                VBox cabecalho = new VBox(5);
                cabecalho.setPadding(new Insets(20, 20, 20, 20));
                               
                Label titulo = new Label( "Cadastrar Bombeiro");
                titulo.setStyle("-fx-font-size: 22px;" + "-fx-font-weight: bold;");
                Label subtitulo = new Label("Preencha todos os campos obrigatórios para cadastrar um novo bombeiro");

                cabecalho.getChildren().addAll(titulo, subtitulo);
               
                VBox formulario = new VBox(15);
                formulario.setPadding(new Insets(15, 20, 20, 20));
                formulario.setMaxWidth(620);
               
                VBox nomeBox = new VBox(5);
               
                Label labelNome = new Label("Nome completo *");
                TextField campoNome = new TextField();
                campoNome.setPromptText("Digite o nome completo");
               
                nomeBox.getChildren().addAll(labelNome, campoNome);                

                HBox linhaCpfData = new HBox(40);
               
                VBox cpfBox = new VBox(5);
     
                Label labelCpf = new Label("CPF *");
                TextField campoCpf = new TextField();
                campoCpf.setPromptText("Digite o CPF");

                cpfBox.getChildren().addAll(labelCpf, campoCpf);
               
                VBox dataBox = new VBox(5);
               
                Label labelData = new Label("Data de Nascimento *");
                DatePicker campoData = new DatePicker();
                campoData.setPromptText("Selecione a data");

                dataBox.getChildren().addAll(labelData, campoData);

                linhaCpfData.getChildren().addAll(cpfBox, dataBox);
               
                HBox linhaPatenteStatus = new HBox(40);
               
                VBox patenteBox = new VBox(5);
               
                Label labelPatente = new Label("Patente *");
                ComboBox<String> comboPatente = new ComboBox<>();
                comboPatente.getItems().addAll("Soldado", "Cabo", "Sargento", "Capitao");
                comboPatente.setPromptText("Selecione a patente");
               
                patenteBox.getChildren().addAll(labelPatente, comboPatente);

                VBox statusBox = new VBox(5);
               
                Label labelStatus = new Label("Status *");
                ComboBox<String> comboStatus = new ComboBox<>();
                comboStatus.getItems().addAll("Ativo", "Afastado", "Inativo");
                comboStatus.setPromptText("Selecione o status");

                statusBox.getChildren().addAll(labelStatus,comboStatus);

                linhaPatenteStatus.getChildren().addAll(patenteBox, statusBox);
               
                HBox linhaContatoEspecialidade = new HBox(40);
               
                VBox contatoBox = new VBox(5);
               
                Label labelContato = new Label("Contato *");
                TextField campoContato = new TextField();
                campoContato.setPromptText("Digite o telefone");

                contatoBox.getChildren().addAll(labelContato, campoContato);
               
                VBox especialidadeBox = new VBox(5);
               
                Label labelEspecialidade = new Label("Especialidade *");
                ComboBox<String> comboEspecialidade = new ComboBox<>();
                comboEspecialidade.getItems().addAll("Combate a incêndio", "Operações especiais", "Mergulho");
                comboEspecialidade.setPromptText("Selecione a especialidade");

                especialidadeBox.getChildren().addAll(labelEspecialidade,comboEspecialidade);
               
                linhaContatoEspecialidade.getChildren().addAll(contatoBox, especialidadeBox);
               
                formulario.setStyle("-fx-background-color: white;" + "-fx-background-radius: 8;" + "-fx-border-color: #D5D5D5;" + "-fx-border-radius: 8;" + "-fx-border-width: 1;");

                formulario.getChildren().addAll(titulo, subtitulo, nomeBox, linhaCpfData, linhaPatenteStatus, linhaContatoEspecialidade);

                BorderPane tela = new BorderPane();

                tela.setTop(cabecalho);
                tela.setCenter(formulario);
               
                Scene cenarioCadastro = new Scene(tela, 1050, 600);
                cadastrar.setTitle("Cadastrar Bombeiros");
                cadastrar.setScene(cenarioCadastro);
               
                cadastrar.showAndWait();
            }
        };

        btnCadastrar.addEventHandler(
                MouseEvent.MOUSE_CLICKED,
                telaCadastro
        );
       
        btnCadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, telaCadastro);

        EventHandler<MouseEvent> telaConsulta = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Stage consultar = new Stage();
                consultar.initModality(Modality.APPLICATION_MODAL);

                VBox rootConsultar = new VBox(15);

                VBox nomeBox = new VBox(5);

                Label titulo = new Label("Consultar Bombeiros");
                titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
                Label subtitulo = new Label("Pesquise e gerencie os bombeiros cadastrados no sistema");
                Label labelNome = new Label("Nome");
                TextField campoNome = new TextField();
                campoNome.setPromptText("Buscar por nome...");

                nomeBox.getChildren().addAll(labelNome, campoNome);

                HBox filtros = new HBox(15);
                rootConsultar.setPadding(new Insets(20));

                VBox patenteBox = new VBox(5);

                Label labelPatente = new Label("Patente");
                ComboBox<String> comboPatente = new ComboBox<>();
                comboPatente.getItems().addAll("Todas", "Soldado", "Cabo", "Sargento", "Capitao");
                comboPatente.setValue("Todas");

                patenteBox.getChildren().addAll(labelPatente, comboPatente);

                VBox statusBox = new VBox(5);

                Label labelStatus = new Label("Status");

                ComboBox<String> comboStatus = new ComboBox<>();
                comboStatus.getItems().addAll("Todos", "Ativo", "Afastado", "Inativo");
                comboStatus.setValue("Todos");

                statusBox.getChildren().addAll(labelStatus, comboStatus);

                filtros.getChildren().addAll(nomeBox, patenteBox, statusBox);

                ListView<Bombeiro> lista = new ListView<>();

                lista.getItems().addAll(bombeiros);

                HBox botoes = new HBox(10);

                Button btnPesquisar = new Button("Pesquisar");
                Button btnLimpar = new Button("Limpar");
                Button btnFechar = new Button("Fechar");

                botoes.getChildren().addAll(btnPesquisar, btnLimpar, btnFechar);

                rootConsultar.getChildren().addAll(titulo, subtitulo, filtros, botoes, lista);

                Scene cenarioConsulta = new Scene(rootConsultar, 1050, 600);
                consultar.setTitle("Consultar Bombeiros");
                consultar.setScene(cenarioConsulta);

                consultar.showAndWait();
            }
        };

        btnConsultar.addEventHandler(MouseEvent.MOUSE_CLICKED, telaConsulta);

        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}