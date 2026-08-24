package com.mycompany.gestaopessoal;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AtualizarBombeiros {

    public void mostrar() {

        Stage stage = new Stage();

        Pane root = new Pane();

        Label titulo = new Label("Atualizar Bombeiro");
        titulo.setLayoutX(250);
        titulo.setLayoutY(30);

        Label bombeiro1 = new Label("Bombeiro 1");
        bombeiro1.setLayoutX(50);
        bombeiro1.setLayoutY(100);

        Button selecionar1 = new Button("Selecionar");
        selecionar1.setLayoutX(150);
        selecionar1.setLayoutY(95);

        Label bombeiro2 = new Label("Bombeiro 2");
        bombeiro2.setLayoutX(50);
        bombeiro2.setLayoutY(140);

        Button selecionar2 = new Button("Selecionar");
        selecionar2.setLayoutX(150);
        selecionar2.setLayoutY(135);

        Label bombeiro3 = new Label("Bombeiro 3");
        bombeiro3.setLayoutX(350);
        bombeiro3.setLayoutY(100);

        Button selecionar3 = new Button("Selecionar");
        selecionar3.setLayoutX(450);
        selecionar3.setLayoutY(95);

        Label bombeiro4 = new Label("Bombeiro 4");
        bombeiro4.setLayoutX(350);
        bombeiro4.setLayoutY(140);

        Button selecionar4 = new Button("Selecionar");
        selecionar4.setLayoutX(450);
        selecionar4.setLayoutY(135);

        Label tituloInformacoes = new Label("INFORMAÇÕES ALTERÁVEIS");
        tituloInformacoes.setLayoutX(235);
        tituloInformacoes.setLayoutY(200);

        Label patente = new Label("Patente: xxxxxxxxxxxxx");
        patente.setLayoutX(100);
        patente.setLayoutY(240);

        Label especialidade = new Label("Especialidade: xxxxxxxxxxxxx");
        especialidade.setLayoutX(100);
        especialidade.setLayoutY(270);

        Label contato = new Label("Contato: xxxxxxxxxxxxx");
        contato.setLayoutX(350);
        contato.setLayoutY(240);

        Label status = new Label("Status: xxxxxxxxxxxxx");
        status.setLayoutX(350);
        status.setLayoutY(270);

        Label confirmar = new Label(
                "Deseja confirmar a atualização do bombeiro?"
        );
        confirmar.setLayoutX(190);
        confirmar.setLayoutY(330);

        Button sim = new Button("Sim");
        sim.setLayoutX(180);
        sim.setLayoutY(380);

        Button nao = new Button("Não");
        nao.setLayoutX(380);
        nao.setLayoutY(380);

        EventHandler<MouseEvent> eventoSim =
                new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                Label sucesso = new Label(
                        "Sucesso na atualização do bombeiro!!"
                );

                sucesso.setLayoutX(210);
                sucesso.setLayoutY(480);

                root.getChildren().add(sucesso);
            }
        };
        Button proximo = new Button("Excluir Bombeiro");
        proximo.setLayoutX(540);
        proximo.setLayoutY(500);

        EventHandler<MouseEvent> eventoProximo = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

        ExcluirBombeiro telaExcluir =
                new ExcluirBombeiro();

        telaExcluir.mostrar();
    }
};

proximo.addEventHandler(
        MouseEvent.MOUSE_CLICKED,
        eventoProximo
);

root.getChildren().add(proximo);

        sim.addEventHandler(
                MouseEvent.MOUSE_CLICKED,
                eventoSim
        );

        root.getChildren().add(titulo);

        root.getChildren().add(bombeiro1);
        root.getChildren().add(selecionar1);

        root.getChildren().add(bombeiro2);
        root.getChildren().add(selecionar2);

        root.getChildren().add(bombeiro3);
        root.getChildren().add(selecionar3);

        root.getChildren().add(bombeiro4);
        root.getChildren().add(selecionar4);

        root.getChildren().add(tituloInformacoes);

        root.getChildren().add(patente);
        root.getChildren().add(especialidade);
        root.getChildren().add(contato);
        root.getChildren().add(status);

        root.getChildren().add(confirmar);

        root.getChildren().add(sim);
        root.getChildren().add(nao);

        Scene scene = new Scene(root, 650, 550);

        stage.setScene(scene);
        stage.setTitle("Atualizar Bombeiro");

        stage.show();
    }
}