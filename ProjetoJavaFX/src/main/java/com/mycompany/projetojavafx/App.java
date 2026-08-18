package com.mycompany.projetojavafx;
import javafx.application.Application;
import javafx.scene.control.TextField;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    TextField   txtld;
    TextField   txtNascimento;
    TextField   txtNome;
    TextField   txtEspecialidade;
    TextField   txtMatricula;
    TextField   txtPatente;
    TextField   txtContato;
    TextField   txtStatus;
    TextField   txtCpf;
    
    @Override
    public void start(Stage stage) {
        
        Label titulo = new Label("Cadastro de bombeiros:");

        titulo.setStyle(
                "-fx-font-size: 30px;"
                + "-fx-text-fill: black;"
        );
        
        txtld = new TextField();
        txtNascimento = new TextField();
        txtNome = new TextField();
        txtEspecialidade = new TextField();
        txtMatricula = new TextField();
        txtPatente = new TextField();
        txtContato = new TextField();
        txtStatus = new TextField();
        txtCpf = new TextField();
        
        Label lId = new Label("Identificador do bombeiro:");
        Label lNascimento = new Label("Data de nascimento:");
        Label lNome = new Label("Nome completo:");
        Label lEspecialidade = new Label("Especialidade:");
        Label lMatricula = new Label("Matrícula:");
        Label lPatente = new Label("Patente:");
        Label lContato = new Label("Contato:");
        Label lStatus = new Label("Status:");
        Label lCpf = new Label("CPF:");
        
        GridPane formulario = new GridPane();
        
        formulario.add(lId, 0, 0);
        formulario.add(txtld, 1, 0);

        formulario.add(lNascimento, 0, 1);
        formulario.add(txtNascimento, 1, 1);
        
        formulario.add(lNome, 0, 2);
        formulario.add(txtNome, 1, 2);
        
        formulario.add(lEspecialidade, 0, 3);
        formulario.add(txtEspecialidade, 1, 3);
        
        formulario.add(lMatricula, 0, 4);
        formulario.add(txtMatricula, 1, 4);
        
        formulario.add(lPatente, 0, 5);
        formulario.add(txtPatente, 1, 5);
        
        formulario.add(lContato, 0, 6);
        formulario.add(txtContato, 1, 6);
        
        formulario.add(lStatus, 0, 7);
        formulario.add(txtStatus, 1, 7);
        
        formulario.add(lCpf, 0, 8);
        formulario.add(txtCpf, 1, 8);
        
        formulario.setAlignment(Pos.CENTER);
        

        

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}

