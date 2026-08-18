package com.mycompany.gestaopessoal;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConsultarBombeiros {

    public void mostrar(Stage stage) {
        
        Pane root = new Pane();

        Label titulo = new Label("Consultar Bombeiros");
        titulo.setLayoutX(250);
        titulo.setLayoutY(30);
        

        Label labelNome = new Label("Nome:");
        labelNome.setLayoutX(50);
        labelNome.setLayoutY(100);

        TextField campoNome = new TextField();
        campoNome.setLayoutX(50);
        campoNome.setLayoutY(125);

        Label labelPatente = new Label("Patente:");
        labelPatente.setLayoutX(350);
        labelPatente.setLayoutY(100);

        TextField campoPatente = new TextField();
        campoPatente.setLayoutX(350);
        campoPatente.setLayoutY(125);

        Label labelEspecialidade = new Label("Especialidade:");
        labelEspecialidade.setLayoutX(50);
        labelEspecialidade.setLayoutY(180);

        TextField campoEspecialidade = new TextField();
        campoEspecialidade.setLayoutX(50);
        campoEspecialidade.setLayoutY(205);

        Label labelStatus = new Label("Status:");
        labelStatus.setLayoutX(350);
        labelStatus.setLayoutY(180);

        TextField campoStatus = new TextField();
        campoStatus.setLayoutX(350);
        campoStatus.setLayoutY(205);

        Label tituloBombeiros = new Label("BOMBEIROS");
        tituloBombeiros.setLayoutX(50);
        tituloBombeiros.setLayoutY(280);

        Label bombeiros = new Label(
                "Bombeiro 1\n" +
                "Bombeiro 2\n" +
                "Bombeiro 3\n" +
                "Bombeiro 4"
        );

        bombeiros.setLayoutX(50);
        bombeiros.setLayoutY(310);
        
        Button Selecionar = new Button("Selecionar");
        Selecionar.setLayoutX(120);
        Selecionar.setLayoutY(310);
        
        Button Selecionar2 = new Button("Selecionar");
        Selecionar2.setLayoutX(120);
        Selecionar2.setLayoutY(330);
        
        Button Selecionar3 = new Button("Selecionar");
        Selecionar3.setLayoutX(120);
        Selecionar3.setLayoutY(350);
        
        Button Selecionar4 = new Button("Selecionar");
        Selecionar4.setLayoutX(120);
        Selecionar4.setLayoutY(370);

        Label tituloDados = new Label("DADOS");
        tituloDados.setLayoutX(50);
        tituloDados.setLayoutY(450);

        
        Label dados = new Label(
                "Nome: xxxxxxxxxx\n" +
                "Patente: xxxxxxxxxx\n" +
                "Especialidade: xxxxxxxxxx\n" +
                "Status: xxxxxxxxxx"
        );

        dados.setLayoutX(50);
        dados.setLayoutY(480);

        Button proximo = new Button("Adicionar Bombeiros");
        proximo.setLayoutX(500);
        proximo.setLayoutY(560);

        EventHandler<MouseEvent> evento = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                AdicionarBombeiros telaAdicionar =
                        new AdicionarBombeiros();

                telaAdicionar.mostrar();
            }
        };

        proximo.addEventHandler(
                MouseEvent.MOUSE_CLICKED,
                evento
        );

        root.getChildren().add(titulo);

        root.getChildren().add(labelNome);
        root.getChildren().add(campoNome);

        root.getChildren().add(labelPatente);
        root.getChildren().add(campoPatente);

        root.getChildren().add(labelEspecialidade);
        root.getChildren().add(campoEspecialidade);

        root.getChildren().add(labelStatus);
        root.getChildren().add(campoStatus);

        root.getChildren().add(tituloBombeiros);
        root.getChildren().add(bombeiros);

        root.getChildren().add(tituloDados);
        root.getChildren().add(dados);

        root.getChildren().add(proximo);
        root.getChildren().add(Selecionar);
        root.getChildren().add(Selecionar2);
        root.getChildren().add(Selecionar3);
        root.getChildren().add(Selecionar4);

        Scene scene = new Scene(root, 650, 620);

        stage.setScene(scene);
        stage.setTitle("Consultar Bombeiros");
        stage.show();
    }
}