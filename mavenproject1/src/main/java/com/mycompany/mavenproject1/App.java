package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.SystemInfo.javafxVersion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        // 1- cadastro do bombeiro
        VBox cadastro = new VBox(10);

        Label tituloCadastro = new Label("Cadastro de Bombeiro");

        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField();

        Label lblCPF = new Label("CPF:");
        TextField txtCPF = new TextField();

        Label lblData = new Label("Data de Nascimento:");
        TextField txtData = new TextField();

        Label lblGenero = new Label("Sexo:");
        TextField txtGenero = new TextField();

        Button btnCadastrar = new Button("Cadastrar");
        Button btnCancelarCadastro = new Button("Cancelar");

        Label mensagemCadastro = new Label();

        cadastro.getChildren().addAll(tituloCadastro, lblNome, txtNome, lblCPF, txtCPF, lblData, txtData, lblGenero, txtGenero, btnCadastrar, btnCancelarCadastro, mensagemCadastro);

        Scene sceneCadastro = new Scene(cadastro, 500, 450);

        //botao pra cadastrar
        btnCadastrar.setOnAction(e -> {
            mensagemCadastro.setText("Bombeiro cadastrado com sucesso!");
        });

        //botao pra cancelar
        btnCancelarCadastro.setOnAction(e -> {
        txtNome.clear();
        txtCPF.clear();
        txtData.clear();
        txtGenero.clear();
        
        mensagemCadastro.setText("Cadastro Cancelado");
    }
    );
        
        //2- operação do bombeiro
        
        VBox Operação = new VBox(10);

        Label tituloOperação = new Label("Operação de bombeiro");
        
        Label lblLocal = new Label("Local da ocorrência:");
        TextField txtLocal = new TextField();
        
        Label lblTipo = new Label("Tipo da operação:");
        TextField txtTipo = new TextField();
        
        Label lblViatura = new Label("Viatura:");
        TextField txtViatura = new TextField();
        
        Label lblBombeiro = new Label("Bombeiro Responsável:");
        TextField txtBombeiro = new TextField();
        
        Label lblDescrição = new Label("Descrição:");
        TextField txtDescrição = new TextField();
        
         Button btnRegistrar = new Button("Cadastrar");
        Button btnCancelarOperação = new Button("Cancelar");
        
         Operação.getChildren().addAll(tituloOperação, lblLocal,txtLocal,lblTipo,txtLocal,lblTipo,txtTipo,lblViatura,txtViatura
         , lblBombeiro,txtBombeiro,lblDescrição,txtDescrição,btnRegistrar, btnCancelarOperação);
         
         Scene sceneOperação = new Scene(cadastro, 500, 450);
         
         //botão pra registrar Operação
         
         btnRegistrar.setOnAction(e -> {
            mensagemCadastro.setText("Operação registrada com sucesso!");
        });
         
         //botão pra cancelar Operação
         
         btnCancelarOperação.setOnAction(e -> {
        txtNome.clear();
        txtCPF.clear();
        txtData.clear();
        txtGenero.clear();
        
        mensagemCadastro.setText("Operação cancelada");
    }
    );
         
         //3- Consulta do Bombeiro
         
           VBox Consulta = new VBox(10);
           
           Label tituloConsulta = new Label("Consulta do bombeiro");
           
            Label lblCPFconsulta = new Label("Digite o CPF do bombeiro:");
        TextField txtCPFconsulta = new TextField();
        
         Button btnConsulta = new Button("Consultar");
        Button btnCancelarConsulta = new Button("Cancelar");
        
        Label resultadoConsulta = new Label();
        
         Consulta.getChildren().addAll(tituloConsulta,lblCPFconsulta,txtCPFconsulta,btnConsulta,btnCancelarConsulta, resultadoConsulta);
         
         Scene sceneConsulta = new Scene(cadastro, 500,300);
         
         //botão pra conasultar
         
         btnConsulta.setOnAction(e -> {
            resultadoConsulta.setText("Consulta realizada para o CPF :"
                    + txtCPFconsulta.getText()
            );
            
            
        });
         
         //botão pra cancelar consulta
         
         btnCancelarConsulta.setOnAction( e ->{
             txtCPFconsulta.clear();
             
             resultadoConsulta.setText("consulta cancelada");
         });
         
         //Botões pra trocar de tela
         
         Button btnIrOperação = new Button("ir para Operação");
         Button btnIrConsulta = new Button("ir para a consulta");
         
          Button btnVoltarCadastro = new Button("Voltar para o Cadastro");
          
          cadastro.getChildren().addAll(btnIrOperação, btnIrConsulta);
          
          Operação.getChildren().addAll(btnVoltarCadastro);
          
           Consulta.getChildren().addAll(btnVoltarCadastro);
           
           
           //ir para a operação
           
           btnIrOperação.setOnAction (e ->{
               
               stage.setTitle("operação bombeiro");
                       stage.setScene(sceneOperação);
           });
           
           //ir para a consulta
           
           btnIrConsulta.setOnAction (e ->{
               
               stage.setTitle("Consulta bombeiro");
                       stage.setScene(sceneConsulta);
                       
           });
           
           //voltar para o cadastro
           
           btnVoltarCadastro.setOnAction (e ->{
               
               stage.setTitle("Cadastro de bombeiro");
                       stage.setScene(sceneCadastro);
           });
           
           //iniciar o programa
           
           stage.setTitle("cadastro de bombeiro");
           stage.setScene(sceneConsulta);
           
           stage.show();
}

public static void main(String[] args){
    launch();
}
}
           
           
                 
         
         
        
         
         
        
        


