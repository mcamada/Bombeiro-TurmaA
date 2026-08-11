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

public class App extends Application {

    ArrayList<Bombeiro> bombeiros = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        // Criando objetos Bombeiro
        Bombeiro bombeiro1 = new Bombeiro(
                "Murilo Zeferino",
                "Soldado",
                "Afastado"
        );

        Bombeiro bombeiro2 = new Bombeiro(
                "Rian Rescarolli",
                "Soldado",
                "Ativo"
        );

        Bombeiro bombeiro3 = new Bombeiro(
                "Filipe Teske",
                "Soldado",
                "Ativo"
        );

        Bombeiro bombeiro4 = new Bombeiro(
                "João Peixe",
                "Soldado",
                "Ativo"
        );

        // Adicionando os objetos na lista
        bombeiros.add(bombeiro1);
        bombeiros.add(bombeiro2);
        bombeiros.add(bombeiro3);
        bombeiros.add(bombeiro4);

        Label titulo = new Label(
                "Sistema de Gerenciamento de Bombeiros"
        );

        titulo.setStyle(
                "-fx-font-size: 22px; -fx-font-weight: bold;"
        );

        Label subtitulo = new Label(
                "Corpo de Bombeiros - Gestão de Equipes"
        );

        VBox cabecalho = new VBox(5);
        cabecalho.setPadding(new Insets(15));
        cabecalho.getChildren().addAll(
                titulo,
                subtitulo
        );

        Button btnInicio = new Button(
                "Página Principal"
        );

        Button btnCadastrar = new Button(
                "Cadastrar Bombeiro"
        );

        Button btnConsultar = new Button(
                "Consultar Bombeiro"
        );

        HBox menu = new HBox(10);
        menu.setPadding(new Insets(10));
        menu.getChildren().addAll(
                btnInicio,
                btnCadastrar,
                btnConsultar
        );

        VBox topo = new VBox();
        topo.getChildren().addAll(
                cabecalho,
                menu
        );

        Label total = new Label(
                "Total de Bombeiros: " + bombeiros.size()
        );

        Label ativos = new Label(
                "Bombeiros Ativos: 3"
        );

        Label afastados = new Label(
                "Bombeiros Afastados: 1"
        );

        Label inativos = new Label(
                "Bombeiros Inativos: 0"
        );

        HBox cards = new HBox(20);
        cards.setPadding(new Insets(10));
        cards.getChildren().addAll(
                total,
                ativos,
                afastados,
                inativos
        );

        Label recentes = new Label(
                "Cadastros Recentes"
        );

        recentes.setStyle(
                "-fx-font-size: 18px; -fx-font-weight: bold;"
        );

        // Agora a ListView trabalha com objetos Bombeiro
        ListView<Bombeiro> lista = new ListView<>();

        lista.getItems().addAll(bombeiros);

        VBox centro = new VBox(15);
        centro.setPadding(new Insets(20));
        centro.getChildren().addAll(
                cards,
                recentes,
                lista
        );

        BorderPane tela = new BorderPane();

        tela.setTop(topo);
        tela.setCenter(centro);

        Scene scene = new Scene(
                tela,
                1050,
                600
        );

        stage.setTitle(
                "Sistema de Bombeiros"
        );

        stage.setScene(scene);

        EventHandler<MouseEvent> eh =
                new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Stage cadastro = new Stage();

                VBox rootCadastro = new VBox();

                rootCadastro.setPadding(
                        new Insets(20)
                );

                rootCadastro.getChildren().add(
                        new Label("Cadastro de Bombeiro")
                );

                Scene cenarioCadastro =
                        new Scene(
                                rootCadastro,
                                300,
                                200
                        );

                cadastro.setTitle(
                        "Cadastrar Bombeiro"
                );

                cadastro.setScene(
                        cenarioCadastro
                );

                cadastro.show();
            }
        };

        btnCadastrar.addEventHandler(
                MouseEvent.MOUSE_CLICKED,
                eh
        );

        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
