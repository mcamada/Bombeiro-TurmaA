package com.mycompany.sistemagestaoviaturas2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetalhesViatura {

    private Viatura viatura;

    public DetalhesViatura(Viatura viatura){
        this.viatura=viatura;
    }

    public void start(Stage stage){

        VBox root=new VBox(15);
        root.setPadding(new Insets(20));

        HBox cabecalho=new HBox(30);
        cabecalho.setAlignment(Pos.CENTER);

        Label titulo=new Label(viatura.getPrefixo()+" / "+viatura.getPlaca());

        Label status=new Label(viatura.getStatus());

        cabecalho.getChildren().addAll(titulo,status);

        GridPane informacoes=new GridPane();
        informacoes.setHgap(30);
        informacoes.setVgap(15);
        informacoes.setAlignment(Pos.CENTER);

        Label tipoTitulo=new Label("Tipo");
        Label modeloTitulo=new Label("Modelo");
        Label anoTitulo=new Label("Ano de Fabricacao");
        Label localTitulo=new Label("Localizacao");

        Label tipo=new Label(viatura.getTipo());
        Label modelo=new Label(viatura.getModelo());
        Label ano=new Label(viatura.getAno());
        Label local=new Label(viatura.getLocal());

        informacoes.add(tipoTitulo,0,0);
        informacoes.add(tipo,0,1);

        informacoes.add(modeloTitulo,1,0);
        informacoes.add(modelo,1,1);

        informacoes.add(anoTitulo,0,2);
        informacoes.add(ano,0,3);

        informacoes.add(localTitulo,1,2);
        informacoes.add(local,1,3);

        VBox historico=new VBox(10);
        historico.setAlignment(Pos.CENTER);

        Label tituloHistorico=new Label("Historico de Manutencao");
        Label manutencao=new Label(viatura.getManutencao());

        historico.getChildren().addAll(tituloHistorico,manutencao);

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
        botoes.setAlignment(Pos.CENTER);
        botoes.getChildren().addAll(editar,excluir,voltar);

        root.getChildren().addAll(
                cabecalho,
                informacoes,
                historico,
                botoes
        );

        Scene scene=new Scene(root,900,600);

        stage.setScene(scene);
        stage.setTitle("Detalhes da Viatura");
        stage.show();
    }
}