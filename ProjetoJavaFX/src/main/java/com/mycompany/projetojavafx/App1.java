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

public class App1 extends Application {

    private Stage primaryStage;
    private Scene cenaConsulta;
    private Scene cenaResultado;

    private List<TextField> camposTexto = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        this.cenaConsulta = criarTelaConsulta();
        this.cenaResultado = criarTelaResultado();

        stage.setTitle("Consultar Bombeiros");
        stage.setScene(cenaConsulta);
        stage.show();
    }

    private Scene criarTelaConsulta() {
        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);

        Label labelTitulo = new Label("Consultar Bombeiros:");
        labelTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        labelTitulo.setTextFill(Color.BLACK);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);

        String[] campos = {
            "Especialidade:", "Patente:", "Status:", "Nome:"
        };

        for (int i = 0; i < campos.length; i++) {
            Label lbl = new Label(campos[i]);
            lbl.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            lbl.setTextFill(Color.BLACK);

            TextField txtField = new TextField();
            txtField.setPrefWidth(200);
            txtField.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

            grid.add(lbl, 0, i);
            grid.add(txtField, 1, i);

            camposTexto.add(txtField);
        }

        Button btnConsultar = criarBotaoEstilizado("Consultar\nbombeiro", "#FFFFFF", "#000000");
        Button btnCancelar = criarBotaoEstilizado("Cancelar", "#FFFFFF", "#CC0000");

        btnConsultar.setOnAction(e -> {
            if (validarCampos()) {
                primaryStage.setScene(cenaResultado);
            } else {
            }
        });

        btnCancelar.setOnAction(e -> limparCampos());

        HBox layoutBotoes = new HBox(20, btnConsultar, btnCancelar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(labelTitulo, grid, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private Scene criarTelaResultado() {
        VBox layoutPrincipal = new VBox(20);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);

        Label labelTitulo = new Label("Consultar Bombeiros:");
        labelTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        labelTitulo.setTextFill(Color.BLACK);

        GridPane gridBlocos = new GridPane();
        gridBlocos.setHgap(20);
        gridBlocos.setVgap(20);
        gridBlocos.setAlignment(Pos.CENTER);

        gridBlocos.add(criarBlocoInformacao("Dados Pessoais"), 0, 0);
        gridBlocos.add(criarBlocoInformacao("Histórico Funcional"), 1, 0);
        gridBlocos.add(criarBlocoInformacao("Equipe atual"), 2, 0);

        VBox blocoDisponibilidade = criarBlocoInformacao("Disponibilidade");

        Button btnVoltar = criarBotaoEstilizado("Voltar", "#FFFFFF", "#000000");
        Button btnCancelar = criarBotaoEstilizado("Cancelar", "#FFFFFF", "#CC0000");

        btnVoltar.setOnAction(e -> primaryStage.setScene(cenaConsulta));

        HBox layoutBotoes = new HBox(20, btnVoltar, btnCancelar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(labelTitulo, gridBlocos, blocoDisponibilidade, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private VBox criarBlocoInformacao(String titulo) {
        VBox container = new VBox(5);
        container.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label(titulo);
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        lblTitulo.setTextFill(Color.BLACK);

        VBox tabelaEmBranco = new VBox();
        tabelaEmBranco.setStyle("-fx-background-color: white; -fx-border-color: #A0A0A0; -fx-border-width: 1;");
        tabelaEmBranco.setPrefSize(160, 100);

        for (int i = 0; i < 4; i++) {
            Region linha = new Region();
            linha.setPrefHeight(25);
            if (i < 3) {
                linha.setStyle("-fx-border-color: transparent transparent #D0D0D0 transparent; -fx-border-width: 1;");
            }
            tabelaEmBranco.getChildren().add(linha);
        }

        container.getChildren().addAll(lblTitulo, tabelaEmBranco);
        return container;
    }

    private boolean validarCampos() {
        for (TextField tf : camposTexto) {
            if (tf.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void limparCampos() {
        for (TextField tf : camposTexto) {
            tf.clear();
        }
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
