package com.mycompany.sistemagestaoviaturas2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    Viatura viatura1 = new Viatura("VT-01","ABC-1234","Mercedes-Benz","2020","Oficina Central","Combate a Incendio","Disponivel","2 Manutencoes");
    Viatura viatura2 = new Viatura("VT-02","DFG-5678","Volkswagen","2021","Oficina Especializada","Resgate","Disponivel","1 Manutencao");
    Viatura viatura3 = new Viatura("VT-03","HIJ-9101","Fiat","2022","Quartel Sul","Ambulancia","Disponivel","1 Manutencao");

    @Override
    public void start(Stage stage){

        VBox root=new VBox(10);
        root.setPadding(new Insets(10));

        Label titulo=new Label("Consulta de Viaturas");
        titulo.setMaxWidth(Double.MAX_VALUE);
        titulo.setAlignment(Pos.CENTER);

        HBox pesquisa=new HBox(10);
        pesquisa.setAlignment(Pos.CENTER);

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
        filtros.setAlignment(Pos.CENTER);

        Label labelStatus=new Label("Status");
        Label labelTipo=new Label("Tipo");
        Label labelLocal=new Label("Localizacao");

        ComboBox<String> status=new ComboBox<>();
        status.getItems().addAll("Todos","Ativa","Manutencao");
        status.setValue("Todos");

        ComboBox<String> tipo=new ComboBox<>();
        tipo.getItems().addAll("Todos","Resgate","Ambulancia");
        tipo.setValue("Todos");

        ComboBox<String> local=new ComboBox<>();
        local.getItems().addAll("Todos","Central","Quartel");
        local.setValue("Todos");

        filtros.add(labelStatus,0,0);
        filtros.add(status,0,1);
        filtros.add(labelTipo,1,0);
        filtros.add(tipo,1,1);
        filtros.add(labelLocal,2,0);
        filtros.add(local,2,1);

        Label quantidade=new Label("Exibindo 3 de 3 Viaturas");
        quantidade.setMaxWidth(Double.MAX_VALUE);
        quantidade.setAlignment(Pos.CENTER);

        GridPane tabela=new GridPane();
        tabela.setHgap(20);
        tabela.setVgap(10);
        tabela.setAlignment(Pos.CENTER);

        adicionarViatura(tabela,viatura1,0,stage);
        adicionarViatura(tabela,viatura2,1,stage);
        adicionarViatura(tabela,viatura3,2,stage);

        root.getChildren().addAll(titulo,pesquisa,filtros,quantidade,tabela);

        Scene scene=new Scene(root,900,500);

        stage.setScene(scene);
        stage.setTitle("Consulta de Viaturas");
        stage.show();
    }

    private void adicionarViatura(GridPane tabela,Viatura viatura,int coluna,Stage stage){

        Label identificacao=new Label(viatura.getPrefixo()+" / "+viatura.getPlaca());
        Label modelo=new Label(viatura.getModelo());
        Label ano=new Label(viatura.getAno());
        Label local=new Label(viatura.getLocal());
        Label tipo=new Label(viatura.getTipo());
        Label manutencao=new Label(viatura.getManutencao());

        Button selecionar=new Button("Selecionar");

        selecionar.setOnAction(e->{
            DetalhesViatura detalhes=new DetalhesViatura(viatura);
            detalhes.start(new Stage());
            stage.close();
        });

        tabela.add(identificacao,coluna,0);
        tabela.add(modelo,coluna,1);
        tabela.add(ano,coluna,2);
        tabela.add(local,coluna,3);
        tabela.add(tipo,coluna,4);
        tabela.add(manutencao,coluna,5);
        tabela.add(selecionar,coluna,6);
    }

    public static void main(String[] args){
        launch();
    }
}