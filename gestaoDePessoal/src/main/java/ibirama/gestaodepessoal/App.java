package ibirama.gestaodepessoal;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        VBox topo = new VBox();

        Label titulo = new Label("Sistema de Gerenciamento de Bombeiros");
        titulo.setStyle("-fx-font-size: 22px; -fx-text-fill: white; -fx-font-weight: bold;");

        Label subtitulo = new Label("Corpo de Bombeiros - Gestão de Equipes");
        subtitulo.setStyle("-fx-text-fill: white;");

        VBox cabecalho = new VBox(5, titulo, subtitulo);
        cabecalho.setPadding(new Insets(15));
        cabecalho.setBackground(new Background(
                new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));

        HBox menu = new HBox(10);
        menu.setPadding(new Insets(10));

        Button btnInicio = new Button("Página Principal");
        Button btnCadastrar = new Button("Cadastrar Bombeiro");
        Button btnConsultar = new Button("Consultar Bombeiro");

        menu.getChildren().addAll(btnInicio, btnCadastrar, btnConsultar);

        topo.getChildren().addAll(cabecalho, menu);

        root.setTop(topo);

        VBox centro = new VBox(20);
        centro.setPadding(new Insets(20));

        HBox cards = new HBox(20);

        cards.getChildren().addAll(
                criarCard("Total de Bombeiros", "4"),
                criarCard("Bombeiros Ativos", "3"),
                criarCard("Bombeiros Afastados", "1"),
                criarCard("Bombeiros Inativos", "0")
        );

        Label lblRecentes = new Label("Cadastros Recentes");
        lblRecentes.setStyle("-fx-font-size:18px; -fx-font-weight:bold;");

        ListView<String> lista = new ListView<>();

        lista.getItems().addAll(
                "Murilo Zeferino - Soldado - Afastado",
                "Rian Rescarolli - Soldado - Ativo",
                "Filipe Teske - Soldado - Ativo",
                "João Peixe - Soldado - Ativo"
        );

        centro.getChildren().addAll(cards, lblRecentes, lista);

        root.setCenter(centro);

        Scene scene = new Scene(root, 1050, 600);

        stage.setTitle("Sistema de Bombeiros");
        stage.setScene(scene);
        stage.show();
    }

    private VBox criarCard(String titulo, String valor) {

        Label lblTitulo = new Label(titulo);
        lblTitulo.setStyle("-fx-font-size:16px;");

        Label lblValor = new Label(valor);
        lblValor.setStyle("-fx-font-size:30px; -fx-font-weight:bold;");

        VBox card = new VBox(15, lblTitulo, lblValor);
        card.setPadding(new Insets(15));
        card.setPrefSize(220, 120);

        card.setStyle(
                "-fx-background-color:white;" +
                "-fx-border-color:lightgray;" +
                "-fx-border-radius:5;" +
                "-fx-background-radius:5;"
        );

        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}