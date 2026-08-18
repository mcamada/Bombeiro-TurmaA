package com.mycompany.gestaopessoal;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdicionarBombeiros {

    public void mostrar() {

        Stage stage = new Stage();

        Pane root = new Pane();

        Label titulo = new Label("Adicionar Bombeiro");
        titulo.setLayoutX(240);
        titulo.setLayoutY(30);

        Label labelNome = new Label("Nome:");
        labelNome.setLayoutX(50);
        labelNome.setLayoutY(100);

        TextField campoNome = new TextField();
        campoNome.setLayoutX(50);
        campoNome.setLayoutY(125);

        Label labelCpf = new Label("CPF:");
        labelCpf.setLayoutX(350);
        labelCpf.setLayoutY(100);

        TextField campoCpf = new TextField();
        campoCpf.setLayoutX(350);
        campoCpf.setLayoutY(125);

        Label labelMatricula = new Label("Matrícula:");
        labelMatricula.setLayoutX(50);
        labelMatricula.setLayoutY(180);

        TextField campoMatricula = new TextField();
        campoMatricula.setLayoutX(50);
        campoMatricula.setLayoutY(205);

        Label labelNascimento = new Label("Nascimento:");
        labelNascimento.setLayoutX(350);
        labelNascimento.setLayoutY(180);

        TextField campoNascimento = new TextField();
        campoNascimento.setLayoutX(350);
        campoNascimento.setLayoutY(205);
        
        Label labelPatente = new Label("Patente:");
        labelPatente.setLayoutX(50);
        labelPatente.setLayoutY(260);

        TextField campoPatente = new TextField();
        campoPatente.setLayoutX(50);
        campoPatente.setLayoutY(285);

        Label labelEspecialidade = new Label("Especialidade:");
        labelEspecialidade.setLayoutX(350);
        labelEspecialidade.setLayoutY(260);

        TextField campoEspecialidade = new TextField();
        campoEspecialidade.setLayoutX(350);
        campoEspecialidade.setLayoutY(285);

        Label labelContato = new Label("Contato:");
        labelContato.setLayoutX(50);
        labelContato.setLayoutY(340);

        TextField campoContato = new TextField();
        campoContato.setLayoutX(50);
        campoContato.setLayoutY(365);

        Label labelStatus = new Label("Status:");
        labelStatus.setLayoutX(350);
        labelStatus.setLayoutY(340);

        TextField campoStatus = new TextField();
        campoStatus.setLayoutX(350);
        campoStatus.setLayoutY(365);
        
        Label confirmar = new Label("Confirmar Cadastro?");
        confirmar.setLayoutX(260);
        confirmar.setLayoutY(440);

        Button sim = new Button("Sim");
        sim.setLayoutX(200);
        sim.setLayoutY(480);

        Button nao = new Button("Não");
        nao.setLayoutX(380);
        nao.setLayoutY(480);

        EventHandler<MouseEvent> eventoSim = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent event) {

        Label sucesso = new Label("Sucesso!!!");
        

        sucesso.setLayoutX(290);
        sucesso.setLayoutY(550);

        root.getChildren().add(sucesso);
        Button proximo = new Button("Atualizar Bomeiros");
        
        proximo.setLayoutX(540);
        proximo.setLayoutY(580);
        root.getChildren().add(proximo);
        
        EventHandler<MouseEvent> eventoProximo = new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent event) {

        AtualizarBombeiros telaAtualizar =
                new AtualizarBombeiros();

        telaAtualizar.mostrar();
    }
};

        proximo.addEventHandler(
        MouseEvent.MOUSE_CLICKED,
        eventoProximo
);
    }
};

        sim.addEventHandler(MouseEvent.MOUSE_CLICKED, eventoSim);

        root.getChildren().add(titulo);

        root.getChildren().add(labelNome);
        root.getChildren().add(campoNome);

        root.getChildren().add(labelCpf);
        root.getChildren().add(campoCpf);

        root.getChildren().add(labelMatricula);
        root.getChildren().add(campoMatricula);

        root.getChildren().add(labelNascimento);
        root.getChildren().add(campoNascimento);

        root.getChildren().add(labelPatente);
        root.getChildren().add(campoPatente);

        root.getChildren().add(labelEspecialidade);
        root.getChildren().add(campoEspecialidade);

        root.getChildren().add(labelContato);
        root.getChildren().add(campoContato);

        root.getChildren().add(labelStatus);
        root.getChildren().add(campoStatus);

        root.getChildren().add(confirmar);
        root.getChildren().add(sim);
        root.getChildren().add(nao);

        Scene scene = new Scene(root, 650, 620);

        stage.setScene(scene);
        stage.setTitle("Adicionar Bombeiro");

        stage.show();
    }
}