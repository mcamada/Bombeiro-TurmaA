package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        Label titulo = new Label("Consultar Bombeiros");

        TextField nome = new TextField();
        nome.setText("nome:");
        TextField patente = new TextField();
        patente.setText("patente:");
        TextField especialidade = new TextField();
        patente.setText("especialidade:");
        TextField status = new TextField();
        patente.setText("status:");


        HBox campos1 = new HBox();
        campos1.getChildren().add(nome);
        campos1.getChildren().add(patente);

        HBox campos2 = new HBox();
        campos2.getChildren().add(especialidade);
        campos2.getChildren().add(status);
        
        Label listaTitulo = new Label("bombeiros");

        ListView<String> lista = new ListView<String>(
        FXCollections.observableArrayList( "Julia Kawano")
        );

        Label dadosTitulo = new Label("dados");

        Label nomeDados = new Label("nome:");
        Label patenteDados = new Label("patente:");
        Label especialidadeDados = new Label("especialidade:");
        Label statusDados = new Label("status:");
        
        HBox dados = new HBox();
        dados.getChildren().add(nomeDados);
        dados.getChildren().add(patenteDados);
        dados.getChildren().add(especialidadeDados);
        dados.getChildren().add(statusDados);
        
        root.getChildren().add(titulo);
        root.getChildren().add(campos1);
        root.getChildren().add(campos2);
        root.getChildren().add(listaTitulo);
        root.getChildren().add(lista);
        root.getChildren().add(dadosTitulo);
        root.getChildren().add(dados);
        
        Scene scene = new Scene(root, 740, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
