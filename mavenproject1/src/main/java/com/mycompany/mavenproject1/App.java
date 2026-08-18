package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    // Classe POO dentro do próprio App.java
    class Ocorrencia {
        String tipo, status, data, hora, local, descricao;
        String equipe, viatura, prioridade;

        Ocorrencia(String tipo, String status, String data, String hora,
                   String local, String descricao, String equipe,
                   String viatura, String prioridade) {

            this.tipo = tipo;
            this.status = status;
            this.data = data;
            this.hora = hora;
            this.local = local;
            this.descricao = descricao;
            this.equipe = equipe;
            this.viatura = viatura;
            this.prioridade = prioridade;
        }
    }

    @Override
    public void start(Stage stage) {

        Label titulo = new Label("Cadastrar Ocorrência");

        Label l1 = new Label("Tipo:");
        ComboBox<String> tipo = new ComboBox<>();
        tipo.getItems().addAll("Incêndio", "Acidente", "Resgate");

        Label l2 = new Label("Status:");
        ComboBox<String> status = new ComboBox<>();
        status.getItems().addAll("Aberta", "Em andamento", "Finalizada");

        Label l3 = new Label("Data:");
        TextField data = new TextField();

        Label l4 = new Label("Hora:");
        TextField hora = new TextField();

        Label l5 = new Label("Local:");
        TextField local = new TextField();

        Label l6 = new Label("Descrição:");
        TextField descricao = new TextField();

        Label l7 = new Label("Equipe:");
        ComboBox<String> equipe = new ComboBox<>();
        equipe.getItems().addAll("1ª Cia - Alpha", "1ª Cia - Bravo");

        Label l8 = new Label("Viatura:");
        ComboBox<String> viatura = new ComboBox<>();
        viatura.getItems().addAll("ABT-04", "ABT-05");

        Label l9 = new Label("Prioridade:");
        ComboBox<String> prioridade = new ComboBox<>();
        prioridade.getItems().addAll("Baixa", "Média", "Alta");

        Button salvar = new Button("Salvar");     
        
         VBox tela = new VBox(10);
        Scene cena = new Scene(tela, 600, 600);

        stage.setTitle("Cadastrar Ocorrência");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}