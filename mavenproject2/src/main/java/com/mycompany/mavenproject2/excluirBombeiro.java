package com.mycompany.mavenproject2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class excluirBombeiro extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox();
        root.setSpacing(20);

        Label titulo = new Label("Bombeiros Exclusivos");

        Label numero1 = new Label("1.");
        Label bombeiro1 = new Label("bombeiro 1");
        Label excluir1 = new Label("Excluir?");
        Button sim1 = new Button("Sim");
        Button nao1 = new Button("Não");

        HBox botoes1 = new HBox();
        botoes1.setSpacing(20);
        botoes1.getChildren().add(sim1);
        botoes1.getChildren().add(nao1);

        VBox informacoes1 = new VBox();
        informacoes1.setSpacing(10);
        informacoes1.getChildren().add(bombeiro1);
        informacoes1.getChildren().add(excluir1);
        informacoes1.getChildren().add(botoes1);

        HBox campo1 = new HBox();
        campo1.setSpacing(15);
        campo1.getChildren().add(numero1);
        campo1.getChildren().add(informacoes1);


        Label numero2 = new Label("2.");
        Label bombeiro2 = new Label("bombeiro 2");
        Label excluir2 = new Label("Excluir?");
        Button sim2 = new Button("Sim");
        Button nao2 = new Button("Não");

        HBox botoes2 = new HBox();
        botoes2.setSpacing(20);
        botoes2.getChildren().add(sim2);
        botoes2.getChildren().add(nao2);

        VBox informacoes2 = new VBox();
        informacoes2.setSpacing(10);
        informacoes2.getChildren().add(bombeiro2);
        informacoes2.getChildren().add(excluir2);
        informacoes2.getChildren().add(botoes2);

        HBox campo2 = new HBox();
        campo2.setSpacing(15);
        campo2.getChildren().add(numero2);
        campo2.getChildren().add(informacoes2);


        HBox primeiraLinha = new HBox();
        primeiraLinha.setSpacing(60);
        primeiraLinha.getChildren().add(campo1);
        primeiraLinha.getChildren().add(campo2);


        Label numero3 = new Label("3.");
        Label bombeiro3 = new Label("bombeiro 3");
        Label excluir3 = new Label("Excluir?");
        Button sim3 = new Button("Sim");
        Button nao3 = new Button("Não");

        HBox botoes3 = new HBox();
        botoes3.setSpacing(20);
        botoes3.getChildren().add(sim3);
        botoes3.getChildren().add(nao3);

        VBox informacoes3 = new VBox();
        informacoes3.setSpacing(10);
        informacoes3.getChildren().add(bombeiro3);
        informacoes3.getChildren().add(excluir3);
        informacoes3.getChildren().add(botoes3);

        HBox campo3 = new HBox();
        campo3.setSpacing(15);
        campo3.getChildren().add(numero3);
        campo3.getChildren().add(informacoes3);


        Label numero4 = new Label("4.");
        Label bombeiro4 = new Label("bombeiro 4");
        Label excluir4 = new Label("Excluir?");
        Button sim4 = new Button("Sim");
        Button nao4 = new Button("Não");

        HBox botoes4 = new HBox();
        botoes4.setSpacing(20);
        botoes4.getChildren().add(sim4);
        botoes4.getChildren().add(nao4);

        VBox informacoes4 = new VBox();
        informacoes4.setSpacing(10);
        informacoes4.getChildren().add(bombeiro4);
        informacoes4.getChildren().add(excluir4);
        informacoes4.getChildren().add(botoes4);

        HBox campo4 = new HBox();
        campo4.setSpacing(15);
        campo4.getChildren().add(numero4);
        campo4.getChildren().add(informacoes4);


        HBox segundaLinha = new HBox();
        segundaLinha.setSpacing(60);
        segundaLinha.getChildren().add(campo3);
        segundaLinha.getChildren().add(campo4);


        Label numero5 = new Label("5.");
        Label bombeiro5 = new Label("bombeiro 5");
        Label excluir5 = new Label("Excluir?");
        Button sim5 = new Button("Sim");
        Button nao5 = new Button("Não");

        HBox botoes5 = new HBox();
        botoes5.setSpacing(20);
        botoes5.getChildren().add(sim5);
        botoes5.getChildren().add(nao5);

        VBox informacoes5 = new VBox();
        informacoes5.setSpacing(10);
        informacoes5.getChildren().add(bombeiro5);
        informacoes5.getChildren().add(excluir5);
        informacoes5.getChildren().add(botoes5);

        HBox campo5 = new HBox();
        campo5.setSpacing(15);
        campo5.getChildren().add(numero5);
        campo5.getChildren().add(informacoes5);


        Label numero6 = new Label("6.");
        Label bombeiro6 = new Label("bombeiro 6");
        Label excluir6 = new Label("Excluir?");
        Button sim6 = new Button("Sim");
        Button nao6 = new Button("Não");

        HBox botoes6 = new HBox();
        botoes6.setSpacing(20);
        botoes6.getChildren().add(sim6);
        botoes6.getChildren().add(nao6);

        VBox informacoes6 = new VBox();
        informacoes6.setSpacing(10);
        informacoes6.getChildren().add(bombeiro6);
        informacoes6.getChildren().add(excluir6);
        informacoes6.getChildren().add(botoes6);

        HBox campo6 = new HBox();
        campo6.setSpacing(15);
        campo6.getChildren().add(numero6);
        campo6.getChildren().add(informacoes6);


        HBox terceiraLinha = new HBox();
        terceiraLinha.setSpacing(60);
        terceiraLinha.getChildren().add(campo5);
        terceiraLinha.getChildren().add(campo6);


        Label notificacao =
                new Label("NOTIFICAÇÃO DO SISTEMA:");

        Label confirmar =
                new Label("Confirmar a exclusão do Bombeiro?");

        Button sim = new Button("Sim");
        Button nao = new Button("Não");

        HBox botoesFinais = new HBox();
        botoesFinais.setSpacing(50);
        botoesFinais.getChildren().add(sim);
        botoesFinais.getChildren().add(nao);


        VBox confirmacao = new VBox();
        confirmacao.setSpacing(15);
        confirmacao.getChildren().add(notificacao);
        confirmacao.getChildren().add(confirmar);
        confirmacao.getChildren().add(botoesFinais);


        root.getChildren().add(titulo);
        root.getChildren().add(primeiraLinha);
        root.getChildren().add(segundaLinha);
        root.getChildren().add(terceiraLinha);
        root.getChildren().add(confirmacao);


        Scene scene = new Scene(root, 800, 600);

        stage.setScene(scene);

        stage.setTitle("Bombeiros Exclusivos");

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
