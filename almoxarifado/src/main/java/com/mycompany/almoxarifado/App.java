package com.mycompany.almoxarifado;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();    
        root.setAlignment(Pos.TOP_CENTER);
        Label titulo = new Label("Tela Inicial");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
        
        root.getChildren().add(titulo);
        
        VBox campos = new VBox(10);
        Button cadastrar = new Button("Cadrastar Item");
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            Stage cadastrar = new Stage();
            VBox rootCadastro = new VBox();
            Label titulo = new Label("Cadastrar Item");
            titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));
            
            GridPane formulario = new GridPane();
            formulario.add(new Label("*Item:"), 0, 2);
            formulario.add(new TextField(), 1, 2);
            formulario.add(new Label("*Categoria:"), 0, 3);
            formulario.add(new TextField(), 1, 3);
            formulario.add(new Label("*Data:"), 0, 4);
            
            formulario.add(new Label("*Quantidade inicial:"), 0, 5);
            
            formulario.add(new Label("*Unidade de medida:"), 0, 6);
            
            formulario.add(new Label("*Localização no estoque:"), 0, 7);
            formulario.add(new TextField(), 1, 7);
            formulario.add(new Label("*Nível mínimo de estoque:"), 0, 8);
            formulario.add(new TextField(), 1, 8);
            formulario.add(new Label("* Itens Obrigatórios"), 0, 14);
            rootCadastro.getChildren().addAll(titulo, formulario);
            Scene cenarioCadastro = new Scene(rootCadastro,640, 480);
            cadastrar.setScene(cenarioCadastro);
            cadastrar.show();
        }
        };
        cadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        stage.show();
        
        Button consultar = new Button("Consultar Item");
        EventHandler<MouseEvent> ih = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            Stage consultar = new Stage();
            VBox rootCadastro = new VBox();
            rootCadastro.getChildren().add(new Label());
            Scene cenarioCadastro = new Scene(rootCadastro,100,100);
            consultar.setScene(cenarioCadastro);
            consultar.show();
        }
        };
        consultar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        stage.show();
        
        Button atualizar = new Button("Atualizar Item");
        EventHandler<MouseEvent> ah = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            Stage atualizar = new Stage();
            VBox rootCadastro = new VBox();
            rootCadastro.getChildren().add(new Label());
            Scene cenarioCadastro = new Scene(rootCadastro,100,100);
            atualizar.setScene(cenarioCadastro);
            atualizar.show();
        }
        };
        atualizar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        stage.show();
        
        Button excluir = new Button("Excluir Item");
        EventHandler<MouseEvent> oh = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            Stage excluir = new Stage();
            VBox rootCadastro = new VBox();
            rootCadastro.getChildren().add(new Label());
            Scene cenarioCadastro = new Scene(rootCadastro,100,100);
            excluir.setScene(cenarioCadastro);
            excluir.show();
        }
        };
        excluir.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        stage.show();
        campos.setAlignment(Pos.CENTER);
        
        
        campos.getChildren().addAll(cadastrar, consultar, atualizar, excluir);
        
        root.getChildren().add(campos);
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }
    }
