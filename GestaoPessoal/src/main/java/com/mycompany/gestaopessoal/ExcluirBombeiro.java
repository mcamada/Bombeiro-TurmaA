package com.mycompany.gestaopessoal;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ExcluirBombeiro {

    public void mostrar() {

        Stage stage = new Stage();

        Pane root = new Pane();

        Label titulo = new Label("Bombeiros Excluíveis");
        titulo.setLayoutX(270);
        titulo.setLayoutY(30);

        Label bombeiro1 = new Label("1 - Bombeiro 1");
        bombeiro1.setLayoutX(130);
        bombeiro1.setLayoutY(100);

        Label excluir1 = new Label("Excluir?");
        excluir1.setLayoutX(150);
        excluir1.setLayoutY(125);

        Button sim1 = new Button("Sim");
        sim1.setLayoutX(130);
        sim1.setLayoutY(150);

        Button nao1 = new Button("Não");
        nao1.setLayoutX(180);
        nao1.setLayoutY(150);


        Label bombeiro2 = new Label("2 - Bombeiro 2");
        bombeiro2.setLayoutX(440);
        bombeiro2.setLayoutY(100);

        Label excluir2 = new Label("Excluir?");
        excluir2.setLayoutX(460);
        excluir2.setLayoutY(125);

        Button sim2 = new Button("Sim");
        sim2.setLayoutX(440);
        sim2.setLayoutY(150);

        Button nao2 = new Button("Não");
        nao2.setLayoutX(490);
        nao2.setLayoutY(150);


        Label bombeiro3 = new Label("3 - Bombeiro 3");
        bombeiro3.setLayoutX(130);
        bombeiro3.setLayoutY(210);

        Label excluir3 = new Label("Excluir?");
        excluir3.setLayoutX(150);
        excluir3.setLayoutY(235);

        Button sim3 = new Button("Sim");
        sim3.setLayoutX(130);
        sim3.setLayoutY(260);

        Button nao3 = new Button("Não");
        nao3.setLayoutX(180);
        nao3.setLayoutY(260);


        Label bombeiro4 = new Label("4 - Bombeiro 4");
        bombeiro4.setLayoutX(440);
        bombeiro4.setLayoutY(210);

        Label excluir4 = new Label("Excluir?");
        excluir4.setLayoutX(460);
        excluir4.setLayoutY(235);

        Button sim4 = new Button("Sim");
        sim4.setLayoutX(440);
        sim4.setLayoutY(260);

        Button nao4 = new Button("Não");
        nao4.setLayoutX(490);
        nao4.setLayoutY(260);

        
        Label notificacao = new Label("NOTIFICAÇÃO DO SISTEMA:");
        notificacao.setLayoutX(240);
        notificacao.setLayoutY(360);

        Label confirmar = new Label(
                "Confirmar a exclusão do Bombeiro?"
        );

        confirmar.setLayoutX(220);
        confirmar.setLayoutY(400);

        Button simFinal = new Button("Sim");
        simFinal.setLayoutX(200);
        simFinal.setLayoutY(450);

        Button naoFinal = new Button("Não");
        naoFinal.setLayoutX(400);
        naoFinal.setLayoutY(450);


        EventHandler<MouseEvent> eventoSimFinal =
                new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Label sucesso = new Label(
                        "Excluido com sucesso!"
                );

                sucesso.setLayoutX(240);
                sucesso.setLayoutY(520);

                root.getChildren().add(sucesso);
            }
        };

        simFinal.addEventHandler(
                MouseEvent.MOUSE_CLICKED,
                eventoSimFinal
        );


        root.getChildren().add(titulo);

        root.getChildren().add(bombeiro1);
        root.getChildren().add(excluir1);
        root.getChildren().add(sim1);
        root.getChildren().add(nao1);

        root.getChildren().add(bombeiro2);
        root.getChildren().add(excluir2);
        root.getChildren().add(sim2);
        root.getChildren().add(nao2);

        root.getChildren().add(bombeiro3);
        root.getChildren().add(excluir3);
        root.getChildren().add(sim3);
        root.getChildren().add(nao3);

        root.getChildren().add(bombeiro4);
        root.getChildren().add(excluir4);
        root.getChildren().add(sim4);
        root.getChildren().add(nao4);

        root.getChildren().add(notificacao);
        root.getChildren().add(confirmar);

        root.getChildren().add(simFinal);
        root.getChildren().add(naoFinal);

        Scene scene = new Scene(root, 650, 600);

        stage.setScene(scene);
        stage.setTitle("Excluir Bombeiro");

        stage.show();
    }
}