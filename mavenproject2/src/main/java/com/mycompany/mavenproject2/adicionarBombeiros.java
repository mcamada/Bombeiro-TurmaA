package com.mycompany.mavenproject2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class adicionarBombeiros extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox();

        Label titulo = new Label("Adicionar Bombeiro");

        Label nomeLabel = new Label("Nome:");
        TextField nome = new TextField();

        Label cpfLabel = new Label("CPF:");
        TextField cpf = new TextField();

        Label matriculaLabel = new Label("Matricula:");
        TextField matricula = new TextField();

        Label nascimentoLabel = new Label("Nascimento:");
        TextField nascimento = new TextField();

        Label patenteLabel = new Label("Patente:");
        TextField patente = new TextField();

        Label especialidadeLabel = new Label("Especialidade:");
        TextField especialidade = new TextField();

        Label contatoLabel = new Label("Contato:");
        TextField contato = new TextField();

        Label statusLabel = new Label("Status:");
        TextField status = new TextField();

        VBox campoNome = new VBox();
        campoNome.getChildren().add(nomeLabel);
        campoNome.getChildren().add(nome);

        VBox campoCpf = new VBox();
        campoCpf.getChildren().add(cpfLabel);
        campoCpf.getChildren().add(cpf);

        VBox campoMatricula = new VBox();
        campoMatricula.getChildren().add(matriculaLabel);
        campoMatricula.getChildren().add(matricula);

        VBox campoNascimento = new VBox();
        campoNascimento.getChildren().add(nascimentoLabel);
        campoNascimento.getChildren().add(nascimento);

        VBox campoPatente = new VBox();
        campoPatente.getChildren().add(patenteLabel);
        campoPatente.getChildren().add(patente);

        VBox campoEspecialidade = new VBox();
        campoEspecialidade.getChildren().add(especialidadeLabel);
        campoEspecialidade.getChildren().add(especialidade);

        VBox campoContato = new VBox();
        campoContato.getChildren().add(contatoLabel);
        campoContato.getChildren().add(contato);

        VBox campoStatus = new VBox();
        campoStatus.getChildren().add(statusLabel);
        campoStatus.getChildren().add(status);

        HBox primeiraLinha = new HBox();
        primeiraLinha.getChildren().add(campoNome);
        primeiraLinha.getChildren().add(campoCpf);

        HBox segundaLinha = new HBox();
        segundaLinha.getChildren().add(campoMatricula);
        segundaLinha.getChildren().add(campoNascimento);

        HBox terceiraLinha = new HBox();
        terceiraLinha.getChildren().add(campoPatente);
        terceiraLinha.getChildren().add(campoEspecialidade);

        HBox quartaLinha = new HBox();
        quartaLinha.getChildren().add(campoContato);
        quartaLinha.getChildren().add(campoStatus);

        Label confirmar = new Label("Confirmar Cadastro?");

        Button sim = new Button("Sim");

        Button nao = new Button("Não");

        EventHandler<ActionEvent> eventoSim = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Stage tela3 = new Stage();

                atualizarBombeiro atualizar = new atualizarBombeiro();

                atualizar.start(tela3);
            }
        };

        sim.addEventHandler(ActionEvent.ACTION, eventoSim);

        HBox botoes = new HBox();
        botoes.getChildren().add(sim);
        botoes.getChildren().add(nao);

        Label sucesso = new Label("Sucesso!!!");

        root.getChildren().add(titulo);
        root.getChildren().add(primeiraLinha);
        root.getChildren().add(segundaLinha);
        root.getChildren().add(terceiraLinha);
        root.getChildren().add(quartaLinha);
        root.getChildren().add(confirmar);
        root.getChildren().add(botoes);
        root.getChildren().add(sucesso);

        Scene scene = new Scene(root, 800, 600);

        stage.setScene(scene);
        stage.setTitle("Adicionar Bombeiro");
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
