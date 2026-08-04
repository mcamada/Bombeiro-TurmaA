package com.mycompany.almoxarifado;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();    
        root.setAlignment(Pos.TOP_CENTER);
        Label titulo = new Label("Tela Inicial");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
        
        root.getChildren().add(titulo);
        
        VBox campos = new VBox(10);
        Button cadastrar = new Button("Cadrastar Item");
        Button consultar = new Button("Consultar Item");
        Button atualizar = new Button("Atualizar Item");
        Button excluir = new Button("Excluir Item");
        
        campos.setAlignment(Pos.CENTER);
        
        
        campos.getChildren().addAll(cadastrar, consultar, atualizar, excluir);
        
        root.getChildren().add(campos);
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}