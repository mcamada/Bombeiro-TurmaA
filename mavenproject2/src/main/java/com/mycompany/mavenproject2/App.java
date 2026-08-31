package com.mycompany.mavenproject2;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox; 
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox();

        Label titulo = new Label("Consultar Bombeiros");

        Label nomeLabel = new Label("Nome");
        TextField nome = new TextField();

        Label patenteLabel = new Label("Patente");
        TextField patente = new TextField();

        Label especialidadeLabel = new Label("Especialidade");
        TextField especialidade = new TextField();

        Label statusLabel = new Label("Status");
        TextField status = new TextField();

        VBox campoNome = new VBox();
        campoNome.getChildren().add(nomeLabel);
        campoNome.getChildren().add(nome);

        VBox campoPatente = new VBox();
        campoPatente.getChildren().add(patenteLabel);
        campoPatente.getChildren().add(patente);

        VBox campoEspecialidade = new VBox();
        campoEspecialidade.getChildren().add(especialidadeLabel);
        campoEspecialidade.getChildren().add(especialidade);

        VBox campoStatus = new VBox();
        campoStatus.getChildren().add(statusLabel);
        campoStatus.getChildren().add(status);

        HBox primeiraLinha = new HBox();
        primeiraLinha.getChildren().add(campoNome);
        primeiraLinha.getChildren().add(campoPatente);

        HBox segundaLinha = new HBox();
        segundaLinha.getChildren().add(campoEspecialidade);
        segundaLinha.getChildren().add(campoStatus);

        Label bombeiros = new Label("Bombeiros");

        ListView<String> lista = new ListView<String>(
            FXCollections.observableArrayList()
        );

        Label dados = new Label("Dados");
        VBox informacoes = new VBox();
        Button adicionar = new Button("Adicionar Bombeiro");

        root.getChildren().add(titulo);
        root.getChildren().add(primeiraLinha);
        root.getChildren().add(segundaLinha);
        root.getChildren().add(bombeiros);
        root.getChildren().add(lista);
        root.getChildren().add(dados);
        root.getChildren().add(informacoes);
        root.getChildren().add(adicionar);


        EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                Stage tela2 = new Stage();
                adicionarBombeiros adicionar = new adicionarBombeiros();
                adicionar.start(tela2);
            }
        };
        adicionar.addEventHandler(ActionEvent.ACTION, evento);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Consultar Bombeiros");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
