package com.mycompany.despachocomunicacao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ocorrencias {
    public void abrir() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        
        BorderPane root = new BorderPane();
        
        ObservableList<String> listaOcorrencias = FXCollections.observableArrayList("Nenhuma ocorrência");
        ListView<String> lista = new ListView<String>(listaOcorrencias);
        root.setCenter(lista);
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Ocorrências");
        stage.setScene(scene);
        stage.showAndWait();
    }
}