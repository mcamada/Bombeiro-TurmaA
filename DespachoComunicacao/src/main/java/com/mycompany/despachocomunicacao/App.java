package com.mycompany.DespachoComunicacao;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {

    private StackPane contentArea;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #FAFAFA;");

        HBox topBar = new HBox();
        topBar.setPadding(new Insets(15));
        topBar.setSpacing(20);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-border-color: transparent transparent black transparent; -fx-border-width: 1; -fx-background-color: white;");

        Label title = new Label("Sistema CAD - Corpo de Bombeiros\nDespacho e Comunicação");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button btnNovaOcorrencia = new Button("+ Nova Ocorrencia");
        btnNovaOcorrencia.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 15; -fx-background-radius: 5;");
        
        btnNovaOcorrencia.setOnMouseClicked(event -> showNovaOcorrenciaDialog(primaryStage));

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

        String activeStyle = "-fx-background-color: black; -fx-text-fill: white; -fx-border-color: black; -fx-background-radius: 5; -fx-border-radius: 5; -fx-padding: 5 20; -fx-font-size: 14px;";
        String inactiveStyle = "-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-background-radius: 5; -fx-border-radius: 5; -fx-padding: 5 20; -fx-font-size: 14px;";

        btnDashboard.setStyle(activeStyle);
        btnOcorrencia.setStyle(inactiveStyle);
        btnRecursos.setStyle(inactiveStyle);
        btnComunicacoes.setStyle(inactiveStyle);

        navBar.getChildren().addAll(btnDashboard, btnOcorrencia, btnRecursos, btnComunicacoes);

        contentArea = new StackPane();
        contentArea.getChildren().add(createDashboardView());

        btnDashboard.setOnMouseClicked(event -> {
            updateNavStyles(activeStyle, inactiveStyle, btnDashboard, btnOcorrencia, btnRecursos, btnComunicacoes);
            contentArea.getChildren().setAll(createDashboardView());
        });

        btnOcorrencia.setOnMouseClicked(event -> {
            updateNavStyles(activeStyle, inactiveStyle, btnOcorrencia, btnDashboard, btnRecursos, btnComunicacoes);
            contentArea.getChildren().setAll(createOcorrenciaView());
        });

        btnRecursos.setOnMouseClicked(event -> {
            updateNavStyles(activeStyle, inactiveStyle, btnRecursos, btnDashboard, btnOcorrencia, btnComunicacoes);
            contentArea.getChildren().setAll(createRecursosView());
        });

        btnComunicacoes.setOnMouseClicked(event -> {
            updateNavStyles(activeStyle, inactiveStyle, btnComunicacoes, btnDashboard, btnOcorrencia, btnRecursos);
            contentArea.getChildren().setAll(createComunicacoesView());
        });

        mainContainer.getChildren().addAll(navBar, contentArea);

        root.setTop(topBar);
        root.setCenter(mainContainer);

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Sistema CAD - Corpo de Bombeiros");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateNavStyles(String active, String inactive, Button activeBtn, Button... inactiveBtns) {
        activeBtn.setStyle(active);
        for (Button btn : inactiveBtns) {
            btn.setStyle(inactive);
        }
    }

    private VBox createDashboardView() {
        VBox view = new VBox(30);

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

        view.getChildren().addAll(statsTop, statsBottom);
        return view;
    }

    private VBox createStatCard(String title, String value) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5; -fx-background-color: white; -fx-background-radius: 5;");
        card.setPrefWidth(150);
        card.setPrefHeight(80);
        
        Label lblTitle = new Label(title);
        lblTitle.setStyle("-fx-font-size: 12px;");
        Label lblValue = new Label(value);
        lblValue.setStyle("-fx-font-size: 14px;");
        
        card.getChildren().addAll(lblTitle, lblValue);
        return card;
    }

    private VBox createOcorrenciaView() {
        VBox view = new VBox(10);

        HBox topArea = new HBox();
        topArea.setAlignment(Pos.CENTER_RIGHT);
        Button btnFiltros = new Button("Filtros");
        btnFiltros.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-background-radius: 5; -fx-border-radius: 5; -fx-padding: 5 15;");
        topArea.getChildren().add(btnFiltros);

        TableView<String> table = new TableView<>();
        table.getColumns().add(new TableColumn<>("ID"));
        table.getColumns().add(new TableColumn<>("Tipo"));
        table.getColumns().add(new TableColumn<>("Local Data/Hora"));
        table.getColumns().add(new TableColumn<>("Status"));
        table.getColumns().add(new TableColumn<>("Prioridade"));
        table.getColumns().add(new TableColumn<>("Ações"));
        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPrefHeight(400);

        view.getChildren().addAll(topArea, table);
        return view;
    }

    private VBox createRecursosView() {
        VBox view = new VBox(20);
        Label lblTitle = new Label("Gestão de Recursos");
        lblTitle.setStyle("-fx-font-size: 14px;");
        
        HBox buttonsBox = new HBox(30);
        Button btnViaturas = new Button("Viaturas(0)");
        Button btnEquipes = new Button("Equipes(0)");
        Button btnBombeiros = new Button("Bombeiros(0)");

        String btnStyle = "-fx-background-color: white; -fx-border-color: black; -fx-background-radius: 5; -fx-border-radius: 5; -fx-padding: 5 20; -fx-font-size: 14px;";
        btnViaturas.setStyle(btnStyle);
        btnEquipes.setStyle(btnStyle);
        btnBombeiros.setStyle(btnStyle);

        buttonsBox.getChildren().addAll(btnViaturas, btnEquipes, btnBombeiros);
        view.getChildren().addAll(lblTitle, buttonsBox);
        return view;
    }

    private VBox createComunicacoesView() {
        VBox view = new VBox(10);
        Label lblTitle = new Label("Comunicações");
        lblTitle.setStyle("-fx-font-size: 14px;");

        TextArea messageHistory = new TextArea();
        messageHistory.setEditable(false);
        messageHistory.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-background-radius: 5; -fx-border-radius: 5;");
        messageHistory.setPrefSize(500, 250);
        VBox.setVgrow(messageHistory, Priority.ALWAYS);

        HBox inputArea = new HBox(10);
        TextField txtMessage = new TextField();
        txtMessage.setPromptText("Digite sua mensagem...");
        txtMessage.setStyle("-fx-border-color: gray; -fx-border-radius: 5; -fx-background-radius: 5;");
        HBox.setHgrow(txtMessage, Priority.ALWAYS);

        Button btnEnviar = new Button("Enviar");
        btnEnviar.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5;");
        
        btnEnviar.setOnMouseClicked(event -> {
            String text = txtMessage.getText();
            if (!text.trim().isEmpty()) {
                messageHistory.appendText("Você: " + text + "\n");
                txtMessage.clear();
            }
        });

        inputArea.getChildren().addAll(txtMessage, btnEnviar);

        view.getChildren().addAll(lblTitle, messageHistory, inputArea);
        return view;
    }

    private void showNovaOcorrenciaDialog(Stage owner) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
        dialog.setTitle("Nova Ocorrência");

        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #FAFAFA;");

        HBox header = new HBox();
        Label title = new Label("Nova Ocorrência");
        title.setStyle("-fx-font-size: 16px;");
        header.getChildren().add(title);
        header.setStyle("-fx-border-color: transparent transparent black transparent; -fx-border-width: 1; -fx-padding: 0 0 10 0;");

        GridPane grid = new GridPane();
        grid.setHgap(30);
        grid.setVgap(15);

        grid.add(new Label("Tipo de Ocorrência *"), 0, 0);
        TextField txtTipo = new TextField();
        txtTipo.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: gray;");
        grid.add(txtTipo, 0, 1);

        grid.add(new Label("Prioridade *"), 1, 0);
        TextField txtPrio = new TextField();
        txtPrio.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: gray;");
        grid.add(txtPrio, 1, 1);

        grid.add(new Label("Data *"), 0, 2);
        TextField txtData = new TextField();
        txtData.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: gray;");
        grid.add(txtData, 0, 3);

        grid.add(new Label("Hora *"), 1, 2);
        TextField txtHora = new TextField();
        txtHora.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: gray;");
        grid.add(txtHora, 1, 3);

        grid.add(new Label("Local *"), 0, 4);
        TextField txtLocal = new TextField();
        txtLocal.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: gray;");
        grid.add(txtLocal, 0, 5);

        grid.add(new Label("Status *"), 1, 4);
        TextField txtStatus = new TextField();
        txtStatus.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: gray;");
        grid.add(txtStatus, 1, 5);

        HBox textAreas = new HBox(30);
        VBox descBox = new VBox(5);
        TextArea txtDesc = new TextArea();
        txtDesc.setPrefRowCount(3);
        txtDesc.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: black; -fx-border-width: 2;");
        descBox.getChildren().addAll(new Label("Descrição *"), txtDesc);
        
        VBox sinBox = new VBox(5);
        TextArea txtSinistro = new TextArea();
        txtSinistro.setPrefRowCount(3);
        txtSinistro.setStyle("-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: black; -fx-border-width: 2;");
        sinBox.getChildren().addAll(new Label("Sinistro (Opcional)"), txtSinistro);

        textAreas.getChildren().addAll(descBox, sinBox);

        HBox bottomActionBox = new HBox();
        bottomActionBox.setAlignment(Pos.CENTER_RIGHT);
        Button btnSalvar = new Button("Salvar");
        btnSalvar.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 20; -fx-background-radius: 5;");
        
        btnSalvar.setOnMouseClicked(event -> {
            System.out.println("Ocorrência Salva!");
            dialog.close();
        });
        
        bottomActionBox.getChildren().add(btnSalvar);

        root.getChildren().addAll(header, grid, textAreas, bottomActionBox);

        Scene scene = new Scene(root, 600, 500);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}