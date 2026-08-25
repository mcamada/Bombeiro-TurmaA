package com.mycompany.despachocomunicacao;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NovaOcorrencia {
    public void abrir() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        
        BorderPane root = new BorderPane();        
        Label title = new Label("Nova Ocorrência");
        root.setTop(title);
        VBox centro = new VBox();
        
        GridPane grid = new GridPane();
        grid.add(new Label("Tipo de Ocorrência"), 0, 0);
        grid.add(new TextField(), 0, 1);
        grid.add(new Label("Prioridade"), 1, 0);
        grid.add(new TextField(), 1, 1);
        grid.add(new Label("Data"), 0, 2);
        grid.add(new TextField(), 0, 3);
        grid.add(new Label("Hora"), 1, 2);
        grid.add(new TextField(), 1, 3);
        grid.add(new Label("Local"), 0, 4);
        grid.add(new TextField(), 0, 5);
        grid.add(new Label("Status"), 1, 4);
        grid.add(new TextField(), 1, 5);

        HBox textAreas = new HBox();        
        VBox descBox = new VBox();
        descBox.getChildren().add(new Label("Descrição"));
        descBox.getChildren().add(new TextArea());
        VBox sinBox = new VBox();
        sinBox.getChildren().add(new Label("Sinistro (Opcional)"));
        sinBox.getChildren().add(new TextArea());
        textAreas.getChildren().add(descBox);
        textAreas.getChildren().add(sinBox);        
        centro.getChildren().add(grid);
        centro.getChildren().add(textAreas);        
        root.setCenter(centro);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.close();
            }
        });       
        root.setBottom(btnSalvar);
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add("/resources/css/style.css");
        stage.setTitle("Nova Ocorrência");
        stage.setScene(scene);
        stage.showAndWait();
    }
}