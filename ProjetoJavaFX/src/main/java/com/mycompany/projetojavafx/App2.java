package com.mycompany.projetojavafx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App2 extends Application {

    private Stage primaryStage;
    private Scene cenaSelecao;
    private Scene cenaEdicao;
    private Scene cenaSucesso;

    private TextField txtSelecionarBombeiro;
    private List<TextField> camposEdicao = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        this.cenaSelecao = criarTelaSelecao();
        this.cenaEdicao = criarTelaEdicao();
        this.cenaSucesso = criarTelaSucesso();

        stage.setTitle("Atualização de Bombeiro");
        stage.setScene(cenaSelecao);
        stage.show();
    }

    private Scene criarTelaSelecao() {
        VBox layoutPrincipal = new VBox(15);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);

        Label labelTitulo = new Label("Atualizaçao De Bombeiro");
        labelTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        labelTitulo.setTextFill(Color.BLACK);

        Label labelSelecionar = new Label("Selecionar Bombeiro");
        labelSelecionar.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        labelSelecionar.setTextFill(Color.BLACK);

        txtSelecionarBombeiro = new TextField();
        txtSelecionarBombeiro.setMaxWidth(250);
        txtSelecionarBombeiro.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

        Label labelDadosAtuais = new Label("Dados Atuais do Bombeiro");
        labelDadosAtuais.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        labelDadosAtuais.setTextFill(Color.BLACK);

        VBox tabelaEmBranco = new VBox();
        tabelaEmBranco.setStyle("-fx-background-color: white; -fx-border-color: #A0A0A0; -fx-border-width: 1;");
        tabelaEmBranco.setMaxWidth(250);
        tabelaEmBranco.setPrefHeight(120);

        for (int i = 0; i < 5; i++) {
            Region linha = new Region();
            linha.setPrefHeight(24);
            if (i < 4) {
                linha.setStyle("-fx-border-color: transparent transparent #D0D0D0 transparent; -fx-border-width: 1;");
            }
            tabelaEmBranco.getChildren().add(linha);
        }

        Button btnAvançar = criarBotaoEstilizado("Avançar", "#FFFFFF", "#000000");
        Button btnCancelar = criarBotaoEstilizado("Cancelar", "#FFFFFF", "#CC0000");

        btnAvançar.setOnAction(e -> {
            if (!txtSelecionarBombeiro.getText().trim().isEmpty()) {
                primaryStage.setScene(cenaEdicao);
            } else {
            }
        });

        btnCancelar.setOnAction(e -> txtSelecionarBombeiro.clear());

        HBox layoutBotoes = new HBox(20, btnAvançar, btnCancelar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(labelTitulo, labelSelecionar, txtSelecionarBombeiro, labelDadosAtuais, tabelaEmBranco, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private Scene criarTelaEdicao() {
        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);

        Label labelTitulo = new Label("Atualização de bombeiro:");
        labelTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        labelTitulo.setTextFill(Color.BLACK);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);

        String[] campos = {
            "Especialidade:", "Patente:", "Status:", "Contato:"
        };

        for (int i = 0; i < campos.length; i++) {
            Label lbl = new Label(campos[i]);
            lbl.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            lbl.setTextFill(Color.BLACK);

            TextField txtField = new TextField();
            txtField.setPrefWidth(220);
            txtField.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

            grid.add(lbl, 0, i);
            grid.add(txtField, 1, i);

            camposEdicao.add(txtField);
        }

        Button btnAtualizar = criarBotaoEstilizado("Atualizar\nbombeiro", "#FFFFFF", "#000000");
        Button btnCancelar = criarBotaoEstilizado("Cancelar", "#FFFFFF", "#CC0000");

        btnAtualizar.setOnAction(e -> {
            if (validarCamposEdicao()) {
                primaryStage.setScene(cenaSucesso);
            } else {
            }
        });

        btnCancelar.setOnAction(e -> primaryStage.setScene(cenaSelecao));

        HBox layoutBotoes = new HBox(20, btnAtualizar, btnCancelar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(labelTitulo, grid, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private Scene criarTelaSucesso() {
        VBox layoutPrincipal = new VBox(30);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);

        VBox cardMensagem = new VBox();
        cardMensagem.setStyle("-fx-background-color: white; -fx-background-radius: 15;");
        cardMensagem.setPrefSize(350, 120);
        cardMensagem.setMaxSize(350, 120);
        cardMensagem.setAlignment(Pos.CENTER);

        Label labelSucesso = new Label("Atualização de bombeiro Bem\nsucedida");
        labelSucesso.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        labelSucesso.setTextFill(Color.BLACK);
        labelSucesso.setStyle("-fx-text-alignment: center;");
        cardMensagem.getChildren().add(labelSucesso);

        Button btnVoltar = criarBotaoEstilizado("Voltar", "#FFFFFF", "#CC0000");
        Button btnContinuar = criarBotaoEstilizado("Continuar", "#FFFFFF", "#000000");

        btnVoltar.setOnAction(e -> primaryStage.setScene(cenaEdicao));

        HBox layoutBotoes = new HBox(20, btnVoltar, btnContinuar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(cardMensagem, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private boolean validarCamposEdicao() {
        for (TextField tf : camposEdicao) {
            if (tf.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private Button criarBotaoEstilizado(String texto, String corFundo, String corTexto) {
        Button btn = new Button(texto);
        btn.setPrefSize(130, 40);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        btn.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: %s; -fx-background-radius: 15; -fx-cursor: hand; -fx-text-alignment: center;", corFundo, corTexto));
        return btn;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

