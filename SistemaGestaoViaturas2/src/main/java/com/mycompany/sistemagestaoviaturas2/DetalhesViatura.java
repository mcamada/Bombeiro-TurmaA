package com.mycompany.sistemagestaoviaturas2;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetalhesViatura{

    private Viatura viatura;

    public DetalhesViatura(Viatura viatura){
        this.viatura=viatura;
    }
    public void start(Stage stage){

        VBox root=new VBox(15);
        root.setPadding(new Insets(20));

        HBox cabecalho=new HBox(30);

        Label titulo=new Label(viatura.getPrefixo()+" / "+viatura.getPlaca());
        Label status=new Label(viatura.getStatus());

        cabecalho.getChildren().addAll(titulo,status);

        GridPane informacoes=new GridPane();
        informacoes.setHgap(30);
        informacoes.setVgap(15);

        informacoes.add(new Label("Tipo"),0,0);
        informacoes.add(new Label(viatura.getTipo()),0,1);
        informacoes.add(new Label("Modelo"),1,0);
        informacoes.add(new Label(viatura.getModelo()),1,1);
        informacoes.add(new Label("Ano de Fabricacao"),0,2);
        informacoes.add(new Label(viatura.getAno()),0,3);
        informacoes.add(new Label("Localizacao"),1,2);
        informacoes.add(new Label(viatura.getLocal()),1,3);

        VBox historico=new VBox(10);

        historico.getChildren().add(new Label("Historico de Manutencao"));
        historico.getChildren().add(new Label(viatura.getManutencao()));

        Button editar=new Button("Editar");
        Button excluir=new Button("Excluir");
        Button voltar=new Button("Voltar");

        editar.setOnAction(e->{
            CadastroViatura cadastro=new CadastroViatura(viatura);
            cadastro.start(new Stage());
            stage.close();
        });

        excluir.setOnAction(e->{
            ConfirmarExclusao confirmar=new ConfirmarExclusao(viatura);
            confirmar.start(new Stage());
        });

        voltar.setOnAction(e->{
            App app=new App();
            app.start(new Stage());
            stage.close();
        });

        HBox botoes=new HBox(10);
        botoes.getChildren().addAll(editar,excluir,voltar);
        root.getChildren().addAll(cabecalho,informacoes,historico,botoes);
        Scene scene=new Scene(root,900,600);
        
        stage.setScene(scene);
        stage.setTitle("Detalhes da Viatura");
        stage.show();
    }
}
