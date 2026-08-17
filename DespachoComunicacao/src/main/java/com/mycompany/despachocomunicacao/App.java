package com.mycompany.despachocomunicacao;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        HBox topBar = new HBox();
        topBar.setPadding(new Insets(15));
        topBar.setSpacing(20);
        topBar.setAlignment(Pos.CENTER_LEFT);

        Label title = new Label("Sistema CAD - Corpo de Bombeiros\nDespacho e Comunicação");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button btnNovaOcorrencia = new Button("+ Nova Ocorrencia");
        
        btnNovaOcorrencia.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            }
        });

        topBar.getChildren().addAll(title, spacer, btnNovaOcorrencia);

        VBox mainContainer = new VBox();
        mainContainer.setPadding(new Insets(20));
        mainContainer.setSpacing(20);

        HBox navBar = new HBox();
        navBar.setSpacing(15);

        Button btnDashboard = new Button("Dashboard");
        Button btnOcorrencia = new Button("Ocorrencia");
        Button btnRecursos = new Button("Recursos");
        Button btnComunicacoes = new Button("Comunicações");

        navBar.getChildren().addAll(btnDashboard, btnOcorrencia, btnRecursos, btnComunicacoes);

        VBox dashboardView = new VBox(30);
        dashboardView.setPadding(new Insets(20, 0, 0, 0));

        HBox statsTop = new HBox(15);
        statsTop.getChildren().addAll(
                createStatCard("Total:", "0"),
                createStatCard("Abertas:", "0"),
                createStatCard("Despachadas:", "0"),
                createStatCard("Em Atendimento:", "0"),
                createStatCard("Finalizadas:", "0"),
                createStatCard("Alta Prioridade:", "0")
        );

        HBox statsBottom = new HBox(15);
        statsBottom.getChildren().addAll(
                createStatCard("Incêndios:", "0"),
                createStatCard("Resgates:", "0"),
                createStatCard("Pré-Hospitalar:", "0"),
                createStatCard("Ações Comunitárias:", "0")
        );

        dashboardView.getChildren().addAll(statsTop, statsBottom);

        mainContainer.getChildren().addAll(navBar, dashboardView);

        root.setTop(topBar);
        root.setCenter(mainContainer);

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Sistema CAD - Corpo de Bombeiros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createStatCard(String title, String value) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-border-color: black;");
        card.setPrefWidth(150);
        card.setPrefHeight(80);
        
        Label lblTitle = new Label(title);
        Label lblValue = new Label(value);
        
        card.getChildren().addAll(lblTitle, lblValue);
        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}