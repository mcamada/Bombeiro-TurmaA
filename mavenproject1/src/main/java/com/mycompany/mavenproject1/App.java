package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.SystemInfo.javafxVersion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        
        //1 tela
        
        VBox vbox = new VBox(10);

        Label lblNome = new Label("nome:");
        TextField txtNome = new TextField();

        Label lblCPF = new Label("CPF :");
        TextField txtCPF = new TextField();

        Label lblDataNascimento = new Label("Data de Nascimento :");
        TextField txtData = new TextField();

        Label lblGenero = new Label("sexo :");
        TextField txtGenero = new TextField();
        String javafxVersion;

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        vbox.getChildren().addAll(lblNome, lblCPF, lblDataNascimento, lblGenero);

    }

    public static void main(String[] args) {
        launch();
    }

}
