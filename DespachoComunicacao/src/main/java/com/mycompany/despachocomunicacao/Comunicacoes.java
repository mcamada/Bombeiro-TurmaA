package com.mycompany.despachocomunicacao;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Comunicacoes {
    public void abrir() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        
        BorderPane root = new BorderPane();
        VBox centro = new VBox();

        Label lblTitle = new Label("Comunicações");
        TextArea history = new TextArea();
        TextField txtMessage = new TextField();
        Button btnEnviar = new Button("Enviar");

        btnEnviar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                txtMessage.setText(""); 
            }
        });
        root.setTop(lblTitle);  
        centro.getChildren().add(history);
        centro.getChildren().add(txtMessage);
        root.setCenter(centro);
        root.setBottom(btnEnviar);
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Comunicações");
        stage.setScene(scene);
        stage.showAndWait();
    }
}