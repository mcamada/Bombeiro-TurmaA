package com.mycompany.gestaodepessoal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

import static javafx.application.Application.launch;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label titulo = new Label("Cadastro de Bombeiros");

        Button cadastrar = new Button("+ Cadastrar Bombeiro");

        HBox topo = new HBox(20, titulo, cadastrar);
        topo.setPadding(new Insets(20));
        topo.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        Region espaco = new Region();
        HBox.setHgrow(espaco, Priority.ALWAYS);

        topo.getChildren().clear();
        topo.getChildren().addAll(titulo,espaco,cadastrar);

        Label filtros = new Label("Filtros de Pesquisa");

        TextField pesquisa = new TextField();
        pesquisa.setPromptText("Digite o nome do bombeiro");
        pesquisa.setPrefWidth(250);

        Button patente = new Button("Patente");
        Button especialidade = new Button("Especialidade");
        Button status = new Button("Status");
        Button limpar = new Button("Limpar Filtros");

        limpar.setOnAction(e -> pesquisa.clear());

        HBox campos = new HBox(10,pesquisa,patente,especialidade,status,limpar);

        VBox filtroBox = new VBox(15,filtros,campos);

        filtroBox.setPadding(new Insets(20));

        Label total = new Label("Total de bombeiros: 3");

        HBox totalBox = new HBox(total);
        totalBox.setPadding(new Insets(15));

        TableView<Bombeiro> tabela = new TableView<>();

        TableColumn<Bombeiro, String> matricula = new TableColumn<>("Matrícula");

        matricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        TableColumn<Bombeiro, String> nome = new TableColumn<>("Nome");

        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Bombeiro, String> patenteColuna = new TableColumn<>("Patente");

        patenteColuna.setCellValueFactory(new PropertyValueFactory<>("patente"));

        TableColumn<Bombeiro, String> especialidadeColuna = new TableColumn<>("Especialidade");

        especialidadeColuna.setCellValueFactory(new PropertyValueFactory<>("especialidade"));

        TableColumn<Bombeiro, String> statusColuna = new TableColumn<>("Status");

        statusColuna.setCellValueFactory(new PropertyValueFactory<>("status"));

        tabela.getColumns().addAll(matricula,nome,patenteColuna,especialidadeColuna,statusColuna);

        ObservableList<Bombeiro> lista
                = FXCollections.observableArrayList(
                        new Bombeiro("BM-2024-001","Filipe Teske","Sargento","Combate a Incêndio","Ativo"),
                        new Bombeiro("BM-2023-045","Rian Pedro","Cabo","Resgate","Ativo"),
                        new Bombeiro("BM-2022-089","Leo Heitor","Tenente","Operações Especiais","Afastado")
                );

        tabela.setItems(lista);

        VBox tela = new VBox(20,topo,filtroBox,totalBox,tabela);

        tela.setPadding(new Insets(20, 45, 20, 45));

        Scene scene = new Scene(tela, 1200, 700);

        stage.setTitle("Cadastro de Bombeiros");

        stage.setScene(scene);
        stage.show();
    }

    public static class Bombeiro {

        private String matricula;
        private String nome;
        private String patente;
        private String especialidade;
        private String status;

        public Bombeiro(
                String matricula,
                String nome,
                String patente,
                String especialidade,
                String status
        ) {
            this.matricula = matricula;
            this.nome = nome;
            this.patente = patente;
            this.especialidade = especialidade;
            this.status = status;
        }

        public String getMatricula() {
            return matricula;
        }

        public String getNome() {
            return nome;
        }

        public String getPatente() {
            return patente;
        }

        public String getEspecialidade() {
            return especialidade;
        }

        public String getStatus() {
            return status;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}