package com.mycompany.sistemagestaoviaturas2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{

    Viatura viatura1=new Viatura("VT-01","ABC-1234","Mercedes-Benz","2020","Oficina Central","Combate a Incendio","Disponivel","2 Manutencoes");
    Viatura viatura2=new Viatura("VT-02","DFG-5678","Volkswagen","2021","Oficina Especializada","Resgate","Disponivel","1 Manutencao");
    Viatura viatura3=new Viatura("VT-03","HIJ-9101","Fiat","2022","Quartel Sul","Ambulancia","Disponivel","1 Manutencao");

    @Override
    public void start(Stage stage){

        VBox root=new VBox(10);
        root.setPadding(new Insets(10));

        Label titulo=new Label("Consulta de Viaturas");

        HBox pesquisa=new HBox(10);

        TextField busca=new TextField();
        busca.setPromptText("Buscar por placa");

        Button cadastrar=new Button("Cadastrar");

        cadastrar.setOnAction(e->{
            CadastroViatura cadastro=new CadastroViatura();
            cadastro.start(new Stage());
            stage.close();
        });

        pesquisa.getChildren().addAll(busca,cadastrar);

        GridPane filtros=new GridPane();
        filtros.setHgap(20);
        filtros.setVgap(5);

        ComboBox<String> status=new ComboBox<>();
        status.getItems().addAll("Todos","Ativa","Manutencao");
        status.setValue("Todos");

        ComboBox<String> tipo=new ComboBox<>();
        tipo.getItems().addAll("Todos","Resgate","Ambulancia");
        tipo.setValue("Todos");

        ComboBox<String> local=new ComboBox<>();
        local.getItems().addAll("Todos","Central","Quartel");
        local.setValue("Todos");

        filtros.add(new Label("Status"),0,0);
        filtros.add(status,0,1);
        filtros.add(new Label("Tipo"),1,0);
        filtros.add(tipo,1,1);
        filtros.add(new Label("Localizacao"),2,0);
        filtros.add(local,2,1);

        Label quantidade=new Label("Exibindo 3 de 3 Viaturas");

        GridPane tabela=new GridPane();
        tabela.setHgap(20);
        tabela.setVgap(10);

        tabela.add(new Label(viatura1.getPrefixo()+" / "+viatura1.getPlaca()),0,0);
        tabela.add(new Label(viatura1.getModelo()),0,1);
        tabela.add(new Label(viatura1.getAno()),0,2);
        tabela.add(new Label(viatura1.getLocal()),0,3);
        tabela.add(new Label(viatura1.getTipo()),0,4);
        tabela.add(new Label(viatura1.getManutencao()),0,5);

        Button selecionar1=new Button("Selecionar");

        selecionar1.setOnAction(e->{
            DetalhesViatura detalhes=new DetalhesViatura(viatura1);
            detalhes.start(new Stage());
            stage.close();
        });

        tabela.add(selecionar1,0,6);

        tabela.add(new Label(viatura2.getPrefixo()+" / "+viatura2.getPlaca()),1,0);
        tabela.add(new Label(viatura2.getModelo()),1,1);
        tabela.add(new Label(viatura2.getAno()),1,2);
        tabela.add(new Label(viatura2.getLocal()),1,3);
        tabela.add(new Label(viatura2.getTipo()),1,4);
        tabela.add(new Label(viatura2.getManutencao()),1,5);

        Button selecionar2=new Button("Selecionar");

        selecionar2.setOnAction(e->{
            DetalhesViatura detalhes=new DetalhesViatura(viatura2);
            detalhes.start(new Stage());
            stage.close();
        });

        tabela.add(selecionar2,1,6);

        tabela.add(new Label(viatura3.getPrefixo()+" / "+viatura3.getPlaca()),2,0);
        tabela.add(new Label(viatura3.getModelo()),2,1);
        tabela.add(new Label(viatura3.getAno()),2,2);
        tabela.add(new Label(viatura3.getLocal()),2,3);
        tabela.add(new Label(viatura3.getTipo()),2,4);
        tabela.add(new Label(viatura3.getManutencao()),2,5);

        Button selecionar3=new Button("Selecionar");

        selecionar3.setOnAction(e->{
            DetalhesViatura detalhes=new DetalhesViatura(viatura3);
            detalhes.start(new Stage());
            stage.close();
        });

        tabela.add(selecionar3,2,6);
        root.getChildren().addAll(titulo,pesquisa,filtros,quantidade,tabela);
        Scene scene=new Scene(root,900,500);
        
        stage.setScene(scene);
        stage.setTitle("Consulta de Viaturas");
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
