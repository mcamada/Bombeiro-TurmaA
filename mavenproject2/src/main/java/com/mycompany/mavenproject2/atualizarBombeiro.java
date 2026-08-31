package com.mycompany.mavenproject2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class atualizarBombeiro extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox();

        Label titulo = new Label("Atualizar Bombeiros");

        Label bombeiro1 = new Label("Bombeiro 1");
        Button selecionar1 = new Button("Selecionar");
        VBox campoBombeiro1 = new VBox();
        campoBombeiro1.getChildren().add(bombeiro1);
        campoBombeiro1.getChildren().add(selecionar1);
        
        Label bombeiro2 = new Label("Bombeiro 2");
        Button selecionar2 = new Button("Selecionar");
        VBox campoBombeiro2 = new VBox();
        campoBombeiro2.getChildren().add(bombeiro2);
        campoBombeiro2.getChildren().add(selecionar2);
        
        HBox primeiraLinha = new HBox();
        primeiraLinha.getChildren().add(campoBombeiro1);
        primeiraLinha.getChildren().add(campoBombeiro2);

        Label bombeiro3 = new Label("Bombeiro 3");
        Button selecionar3 = new Button("Selecionar");
        VBox campoBombeiro3 = new VBox();
        campoBombeiro3.getChildren().add(bombeiro3);
        campoBombeiro3.getChildren().add(selecionar3);

        Label bombeiro4 = new Label("Bombeiro 4");
        Button selecionar4 = new Button("Selecionar");
        VBox campoBombeiro4 = new VBox();
        campoBombeiro4.getChildren().add(bombeiro4);
        campoBombeiro4.getChildren().add(selecionar4);


        HBox segundaLinha = new HBox();
        segundaLinha.getChildren().add(campoBombeiro3);
        segundaLinha.getChildren().add(campoBombeiro4);


        Label informacoesTitulo = new Label("INFORMAÇÕES ALTERAVEIS");


        Label patente = new Label("Patente:");

        Label especialidade = new Label("Especialidade:");


        VBox informacoesEsquerda = new VBox();
        informacoesEsquerda.getChildren().add(patente);
        informacoesEsquerda.getChildren().add(especialidade);


        Label contato = new Label("Contato:");

        Label status = new Label("Status:");

        VBox informacoesDireita = new VBox();
        informacoesDireita.getChildren().add(contato);
        informacoesDireita.getChildren().add(status);
        
        HBox informacoes = new HBox();
        informacoes.getChildren().add(informacoesEsquerda);
        informacoes.getChildren().add(informacoesDireita);


        Label confirmar = new Label("DESEJA CONFIRMAR A ATUALIZAÇÃO DO BOMBEIRO?");

        Button sim = new Button("Sim");
        Button nao = new Button("Não");
        
        EventHandler<ActionEvent> eventoSim = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Stage tela4 = new Stage();
                excluirBombeiro excluir  = new excluirBombeiro();
                excluir.start(tela4);
            }
        };
        sim.addEventHandler(ActionEvent.ACTION, eventoSim);

        HBox botoes = new HBox();
        botoes.getChildren().add(sim);
        botoes.getChildren().add(nao);

        Label notificacao = new Label("NOTIFICAÇÃO DO SISTEMA:");
        Label sucesso = new Label("Sucesso na atualização do bombeiro!!");

        root.getChildren().add(titulo);
        root.getChildren().add(primeiraLinha);
        root.getChildren().add(segundaLinha);
        root.getChildren().add(informacoesTitulo);
        root.getChildren().add(informacoes);
        root.getChildren().add(confirmar);
        root.getChildren().add(botoes);
        root.getChildren().add(notificacao);
        root.getChildren().add(sucesso);


        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Atualizar Bombeiro");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
