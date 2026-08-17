package com.mycompany.gestaodepessoal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {

    ObservableList<Bombeiro> lista = FXCollections.observableArrayList(
            new Bombeiro("BM-2024-001", "Filipe Teske", "Sargento", "Combate a Incêndio", "Ativo"),
            new Bombeiro("BM-2023-045", "Rian Pedro", "Cabo", "Resgate", "Ativo"),
            new Bombeiro("BM-2022-089", "Leo Heitor", "Tenente", "Operações Especiais", "Afastado")
    );

    Label total = new Label("Total de bombeiros: 3");

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Cadastro de Bombeiros");
        Button cadastrar = new Button("+ Cadastrar Bombeiro");
        cadastrar.setOnAction(e -> cadastrar());
        HBox topo = new HBox(titulo, new Region(), cadastrar);
        HBox.setHgrow(topo.getChildren().get(1), Priority.ALWAYS);
        topo.setAlignment(Pos.CENTER_LEFT);
        topo.setPadding(new Insets(20));
        TextField pesquisa = new TextField();
        pesquisa.setPromptText("Digite o nome do bombeiro");
        pesquisa.setPrefWidth(250);
        Button pesquisar = new Button("Pesquisar");
        Button limpar = new Button("Limpar Filtros");
        FilteredList<Bombeiro> filtrados
                = new FilteredList<>(lista, p -> true);
        TableView<Bombeiro> tabela = new TableView<>();
        tabela.setItems(filtrados);

        pesquisar.setOnAction(e -> {
            String texto = pesquisa.getText().trim().toLowerCase();

            filtrados.setPredicate(b -> texto.isEmpty()
                    || b.getNome().toLowerCase().contains(texto));

            total.setText("Total de bombeiros: " + filtrados.size());
        });

        limpar.setOnAction(e -> {
            pesquisa.clear();
            filtrados.setPredicate(b -> true);
            total.setText("Total de bombeiros: " + lista.size());
        });
        pesquisa.setOnAction(e -> pesquisar.fire());

        HBox filtros = new HBox(
                10, pesquisa, pesquisar,
                new Button("Patente"),
                new Button("Especialidade"),
                new Button("Status"),
                limpar
        );

        VBox filtroBox = new VBox(
                15,
                new Label("Filtros de Pesquisa"),
                filtros
        );

        filtroBox.setPadding(new Insets(20));

        tabela.getColumns().addAll(
                coluna("Matrícula", "matricula"),
                coluna("Nome", "nome"),
                coluna("Patente", "patente"),
                coluna("Especialidade", "especialidade"),
                coluna("Status", "status")
        );

        VBox tela = new VBox(
                20, topo, filtroBox, total, tabela
        );

        tela.setPadding(new Insets(20, 45, 20, 45));

        stage.setTitle("Cadastro de Bombeiros");
        stage.setScene(new Scene(tela, 1200, 700));
        stage.show();
    }

    private TableColumn<Bombeiro, String> coluna(
            String titulo, String propriedade) {

        TableColumn<Bombeiro, String> c
                = new TableColumn<>(titulo);

        c.setCellValueFactory(
                new PropertyValueFactory<>(propriedade));

        return c;
    }

    private void cadastrar() {

        Stage janela = new Stage();
        janela.initModality(Modality.APPLICATION_MODAL);
        janela.setTitle("Cadastrar Bombeiro");

        TextField nome = campo();
        TextField cpf = campo();
        TextField matricula = campo();
        TextField nascimento = campo();
        TextField especialidade = campo();
        TextField contato = campo();
        TextField status = campo();
        TextField patente = campo();

        VBox formulario = new VBox(8,
                linha("Nome:", nome),
                linha("CPF:", cpf),
                linha("Matrícula:", matricula),
                linha("Data de nascimento:", nascimento),
                linha("Especialidade:", especialidade),
                linha("Contato:", contato),
                linha("Status:", status),
                linha("Patente:", patente)
        );

        Button confirmar = new Button("Confirmar");
        Button cancelar = new Button("Cancelar");

        confirmar.setPrefSize(175, 40);
        cancelar.setPrefSize(175, 40);

        confirmar.setStyle(
                "-fx-background-color:#00C566;"
                + "-fx-text-fill:white;"
                + "-fx-font-weight:bold;"
        );

        cancelar.setStyle(
                "-fx-background-color:#E82127;"
                + "-fx-text-fill:white;"
                + "-fx-font-weight:bold;"
        );

        confirmar.setOnAction(e -> {

            if (nome.getText().isBlank()
                    || matricula.getText().isBlank()
                    || patente.getText().isBlank()
                    || especialidade.getText().isBlank()
                    || status.getText().isBlank()) {

                new Alert(
                        Alert.AlertType.WARNING,
                        "Preencha os campos obrigatórios."
                ).showAndWait();

                return;
            }

            lista.add(new Bombeiro(
                    matricula.getText(),
                    nome.getText(),
                    patente.getText(),
                    especialidade.getText(),
                    status.getText()
            ));

            total.setText(
                    "Total de bombeiros: " + lista.size()
            );

            janela.close();
        });

        cancelar.setOnAction(e -> janela.close());

        HBox botoes = new HBox(
                85, confirmar, cancelar
        );

        botoes.setAlignment(Pos.CENTER);

        VBox tela = new VBox(
                15, formulario, botoes
        );

        tela.setPadding(new Insets(20));

        janela.setScene(new Scene(tela, 620, 490));
        janela.setResizable(false);
        janela.showAndWait();
    }

    private TextField campo() {
        TextField t = new TextField();

        t.setPrefHeight(36);

        return t;
    }

    private HBox linha(String texto, TextField campo) {

        Label label = new Label(texto);
        label.setPrefWidth(180);
        label.setStyle("-fx-font-size:17px;");

        HBox linha = new HBox(5, label, campo);
        linha.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(campo, Priority.ALWAYS);

        return linha;
    }

    public static class Bombeiro {

        private String matricula, nome, patente,
                especialidade, status;

        public Bombeiro(
                String matricula,
                String nome,
                String patente,
                String especialidade,
                String status) {

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
