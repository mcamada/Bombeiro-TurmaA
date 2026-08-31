package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Cadastrar Ocorrência");
        DatePicker data = new DatePicker();
        TextField hora = new TextField();
        TextField local = new TextField();
        TextArea descricao = new TextArea();
        ComboBox<String> tipo = new ComboBox<>();
        tipo.getItems().addAll("Incêndio", "Acidente", "Resgate");
        ComboBox<String> status = new ComboBox<>();
        status.getItems().addAll("Aberta", "Em andamento", "Finalizada");
        ComboBox<String> equipe = new ComboBox<>();
        equipe.getItems().addAll("1° Pelotão - Sigma", "1º Pelotão - Beta");
        ComboBox<String> viatura = new ComboBox<>();
        viatura.getItems().addAll("Viatura 1", "Viatura 2");
        ComboBox<String> prioridade = new ComboBox<>();
        prioridade.getItems().addAll("Baixa", "Média", "Alta");
        Button salvar = new Button("Salvar Ocorrência");
        salvar.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        Button consultar = new Button("Consultar Ocorrências");
        consultar.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        Button atualizar = new Button("Atualizar Ocorrência");
        Button excluir = new Button("Excluir Ocorrência");
        GridPane tela = new GridPane();
        tela.setHgap(10);
        tela.setVgap(10);
        tela.add(titulo, 0, 0, 2, 1);
        tela.add(new Label("Tipo:"), 0, 1);
        tela.add(tipo, 1, 1);
        tela.add(new Label("Status:"), 0, 2);
        tela.add(status, 1, 2);
        tela.add(new Label("Data:"), 0, 3);
        tela.add(data, 1, 3);
        tela.add(new Label("Hora:"), 0, 4);
        tela.add(hora, 1, 4);
        tela.add(new Label("Local:"), 0, 5);
        tela.add(local, 1, 5);
        tela.add(new Label("Descrição:"), 0, 6);
        tela.add(descricao, 1, 6);
        tela.add(new Label("Equipe:"), 0, 7);
        tela.add(equipe, 1, 7);
        tela.add(new Label("Viatura:"), 0, 8);
        tela.add(viatura, 1, 8);
        tela.add(new Label("Prioridade:"), 0, 9);
        tela.add(prioridade, 1, 9);
        tela.add(salvar, 3, 11);
        tela.add(consultar, 1, 11);
        tela.add(atualizar, 2, 11);
        tela.add(excluir, 4, 11);
        consultar.setOnAction(e -> {
            Stage novaTela = new Stage();
            Label tituloConsulta = new Label("Consultar Ocorrências");
            TextField dataConsulta = new TextField();
            TextField localConsulta = new TextField();
            ComboBox<String> tipoConsulta = new ComboBox<>();
            tipoConsulta.getItems().addAll("Incêndio", "Acidente", "Resgate");
            tipoConsulta.setValue("Todos");
            ComboBox<String> statusConsulta = new ComboBox<>();
            statusConsulta.getItems().addAll("Todos", "Aberta", "Em andamento", "Fechada");
            statusConsulta.setValue("Todos");
            Button buscar = new Button("Consultar");
            Button detalhes = new Button("Ver detalhes");
            ListView<String> lista = new ListView<>();
            GridPane consulta = new GridPane();
            consulta.setPadding(new Insets(20));
            consulta.setHgap(10);
            consulta.setVgap(10);
            consulta.add(tituloConsulta, 0, 0, 2, 1);
            consulta.add(new Label("Data:"), 0, 1);
            consulta.add(dataConsulta, 1, 1);
            consulta.add(new Label("Tipo:"), 0, 2);
            consulta.add(tipoConsulta, 1, 2);
            consulta.add(new Label("Status:"), 0, 3);
            consulta.add(statusConsulta, 1, 3);
            consulta.add(new Label("Local:"), 0, 4);
            consulta.add(localConsulta, 1, 4);
            consulta.add(buscar, 1, 5);
            consulta.add(new Label("Ocorrências:"), 0, 6);
            consulta.add(lista, 0, 7, 2, 1);
            consulta.add(detalhes, 1, 8);
            Scene cenaConsulta = new Scene(consulta, 500, 550);
            novaTela.setTitle("Consultar Ocorrências");
            novaTela.setScene(cenaConsulta);
            novaTela.show();
        });
        atualizar.setOnAction(e -> {
            Stage novaTela = new Stage();
            Label tituloAtualizar = new Label("Atualizar Ocorrência");
            ComboBox<String> ocorrencia = new ComboBox<>();
            ocorrencia.getItems().addAll("01 - Incêndio em José Boiteux", "02 - Acidente em Apiúna", "03 - Resgate em Ibirama");
            ComboBox<String> novoStatus = new ComboBox<>();
            novoStatus.getItems().addAll("Aberta", "Em andamento", "Fechada");
            TextArea novaDescricao = new TextArea();
            ComboBox<String> novaEquipe = new ComboBox<>();
            novaEquipe.getItems().addAll("1° Pelotão - Sigma", "1° Pelotão - Beta");
            Button confirmar = new Button("Confirmar Atualização");
            GridPane atualizacao = new GridPane();
            atualizacao.setPadding(new Insets(20));
            atualizacao.setHgap(10);
            atualizacao.setVgap(10);
            atualizacao.add(tituloAtualizar, 0, 0, 2, 1);
            atualizacao.add(new Label("Ocorrência:"), 0, 1);
            atualizacao.add(ocorrencia, 1, 1);
            atualizacao.add(new Label("Status:"), 0, 2);
            atualizacao.add(novoStatus, 1, 2);
            atualizacao.add(new Label("Descrição:"), 0, 3);
            atualizacao.add(novaDescricao, 1, 3);
            atualizacao.add(new Label("Equipe:"), 0, 4);
            atualizacao.add(novaEquipe, 1, 4);
            atualizacao.add(confirmar, 1, 5);
            Scene cenaAtualizacao = new Scene(atualizacao, 620, 400);
            novaTela.setTitle("Atualizar Ocorrência");
            novaTela.setScene(cenaAtualizacao);
            novaTela.show();
        });
        excluir.setOnAction(e -> {
            Stage novaTela = new Stage();
            Label tituloExclusao = new Label("Excluir Ocorrência");

            ComboBox<String> ocorrencia = new ComboBox<>();
            ocorrencia.getItems().addAll("01 - Incêndio em José Boiteux", "02 - Acidente em Apiúna", "03 - Resgate em Ibirama");
            Button confirmar = new Button("Confirmar Exclusão");
            GridPane exclusao = new GridPane();
            exclusao.setPadding(new Insets(20));
            exclusao.setHgap(10);
            exclusao.setVgap(10);
            exclusao.add(tituloExclusao, 0, 0, 2, 1);
            exclusao.add(new Label("Ocorrência:"), 0, 1);
            exclusao.add(ocorrencia, 1, 1);
            exclusao.add(confirmar, 1, 2);
            Scene cenaExclusao = new Scene(exclusao, 500, 250);
            novaTela.setTitle("Excluir Ocorrência");
            novaTela.setScene(cenaExclusao);
            novaTela.show();
        });
        Scene cena = new Scene(tela, 950, 640);
        stage.setTitle("Cadastrar Ocorrência");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
