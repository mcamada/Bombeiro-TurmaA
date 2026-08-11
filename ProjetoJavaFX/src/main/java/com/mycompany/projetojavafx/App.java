package com.mycompany.projetojavafx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        Label titulo = new Label("Cadastro de bombeiros");
        Label Identificador = new Label("Identificador do bombeiro");
        Label DataNascimento = new Label("Data de nascimento");
        Label Nome = new Label ("Nome completo");
        Label Especialidade = new Label ("Especialidade");
        Label Matricula = new Label ("Matrícula");
        Label Patente = new Label ("Patente");
        Label Contato = new Label ("Contato");
        Label Status = new Label ("Status");
        Label CPF = new Label ("CPF");

        root.getChildren().add(titulo);
        root.getChildren().add(Identificador);
        root.getChildren().add(DataNascimento);
        root.getChildren().add(Nome);
        root.getChildren().add(Especialidade);
        root.getChildren().add(Matricula);
        root.getChildren().add(Patente);
        root.getChildren().add(Contato);
        root.getChildren().add(Status);
        root.getChildren().add(CPF);
        
        Menu file = new Menu("Novo");
        Menu view = new Menu("View");
        
        Button botao1 = new Button("Cadastrar");
        Button botao2 = new Button("Cancelar");
        
        root.getChildren().add(botao1);
        root.getChildren().add(botao2);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}

