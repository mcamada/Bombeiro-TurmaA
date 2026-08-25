package com.mycompany.despachocomunicacao;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        BorderPane topBar = new BorderPane();
        Label title = new Label("Sistema CAD - Corpo de Bombeiros");
        Button btnNovaOcorrencia = new Button("+ Nova Ocorrencia");

//        btnNovaOcorrencia.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                NovaOcorrencia nova = new NovaOcorrencia();
//                nova.abrir();
//            }
//        });

        topBar.setLeft(title);
        topBar.setRight(btnNovaOcorrencia);

        VBox mainContainer = new VBox();

        ButtonBar navBar = new ButtonBar();
        Button btnDashboard = new Button("Dashboard");
        Button btnOcorrencia = new Button("Ocorrencia");
        Button btnRecursos = new Button("Recursos");
        Button btnComunicacoes = new Button("Comunicações");

//        btnOcorrencia.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Ocorrencias janela = new Ocorrencias();
//                janela.abrir();
//            }
//        });

//        btnRecursos.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Recursos janela = new Recursos();
//                janela.abrir();
//            }
//        });

//        btnComunicacoes.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Comunicacoes janela = new Comunicacoes();
//                janela.abrir();
//            }
//        });

        navBar.getButtons().addAll(btnDashboard, btnOcorrencia, btnRecursos, btnComunicacoes);

        VBox dashboardView = new VBox();
        dashboardView.setAlignment(Pos.CENTER); 
        dashboardView.setSpacing(20); 

        HBox statsTop = new HBox();
        statsTop.setAlignment(Pos.CENTER);
        statsTop.getChildren().add(new Label("Total: 0    "));
        statsTop.getChildren().add(new Label("Abertas: 0    "));
        statsTop.getChildren().add(new Label("Despachadas: 0    "));
        statsTop.getChildren().add(new Label("Em Atendimento: 0    "));
        statsTop.getChildren().add(new Label("Finalizadas: 0    "));
        statsTop.getChildren().add(new Label("Alta Prioridade: 0    "));

        HBox statsBottom = new HBox();
        statsBottom.setAlignment(Pos.CENTER); 
        statsBottom.getChildren().add(new Label("Incêndios: 0    "));
        statsBottom.getChildren().add(new Label("Resgates: 0    "));
        statsBottom.getChildren().add(new Label("Pré-Hospitalar: 0    "));
        statsBottom.getChildren().add(new Label("Ações Comunitárias: 0    "));

        dashboardView.getChildren().add(statsTop);
        dashboardView.getChildren().add(statsBottom);

        mainContainer.getChildren().add(navBar);
        mainContainer.getChildren().add(dashboardView);

        root.setTop(topBar);
        root.setCenter(mainContainer);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Sistema CAD - Corpo de Bombeiros");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
