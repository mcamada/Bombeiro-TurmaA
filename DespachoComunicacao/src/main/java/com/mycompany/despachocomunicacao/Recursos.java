package com.mycompany.despachocomunicacao;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Recursos {
    public void abrir() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        
        BorderPane root = new BorderPane();
        VBox centro = new VBox();

        centro.getChildren().add(new Label("Viaturas: 0"));
        centro.getChildren().add(new Label("Equipes: 0"));
        centro.getChildren().add(new Label("Bombeiros: 0"));
        root.setCenter(centro);
        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add("/resources/css/style.css");
        stage.setTitle("Recursos");
        stage.setScene(scene);
        stage.showAndWait();
    }
}