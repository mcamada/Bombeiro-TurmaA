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
import javafx.scene.control.TextField;
import javafx.stage.Modality;

public class App extends Application {

    ArrayList<Bombeiro> bombeiros = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        Bombeiro bombeiro1 = new Bombeiro("Murilo Zeferino", "Soldado", "Afastado");
        Bombeiro bombeiro2 = new Bombeiro("Rian Rescarolli", "Soldado", "Ativo");
        Bombeiro bombeiro3 = new Bombeiro("Filipe Teske", "Soldado", "Ativo");
        Bombeiro bombeiro4 = new Bombeiro("João Peixe", "Soldado", "Ativo");

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

                VBox rootCadastrar = new VBox();

                VBox cabecalho = new VBox(5);
                Label titulo = new Label("Sistema de Gerenciamento de Bombeiros");
                titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
                Label subtitulo = new Label("Corpo de Bombeiros - Gestão de Equipes");
                cabecalho.setPadding(new Insets(15));
                cabecalho.getChildren().addAll(titulo, subtitulo);
                rootCadastrar.getChildren().add(cabecalho);

                Scene cenarioCadastro = new Scene(rootCadastrar, 1050, 600);

                cadastrar.setScene(cenarioCadastro);

                cadastrar.showAndWait();
            }
        };
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
