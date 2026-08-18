package com.mycompany.gestaodepessoal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            new Bombeiro("BM-2024-001", "Filipe Teske", "Sargento",
                    "Combate a Incêndio", "Ativo"),
            new Bombeiro("BM-2023-045", "Rian Pedro", "Cabo",
                    "Resgate", "Ativo"),
            new Bombeiro("BM-2022-089", "Leo Heitor", "Tenente",
                    "Operações Especiais", "Afastado")
    );
    String[] patentes = {
        "Soldado", "Cabo", "Sargento", "Subtenente", "Tenente",
        "Capitão", "Major", "Tenente-Coronel", "Coronel"
    };
    String[] especialidades = {
        "Combate a Incêndio","Resgate","Salvamento Aquático", "Produtos Perigosos", "Atendimento Pré-Hospitalar",
        "Prevenção e Investigação","Operações Especiais","Busca e Salvamento"
    };
    String[] status = {
        "Ativo", "Afastado","Inativo"
    };
    Label total = new Label();
    TableView<Bombeiro> tabela = new TableView<>();
    TextField pesquisa = new TextField();

    ComboBox<String> filtroPatente = new ComboBox<>();
    ComboBox<String> filtroEspecialidade = new ComboBox<>();
    ComboBox<String> filtroStatus = new ComboBox<>();

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Cadastro de Bombeiros");

        Button cadastrar = new Button("+ Cadastrar Bombeiro");
        Button pesquisar = new Button("Pesquisar");
        Button limpar = new Button("Limpar Filtros");
        Button excluir = new Button("Excluir Bombeiro");

        cadastrar.setOnAction(e -> cadastrar());
        pesquisar.setOnAction(e -> pesquisar());
        limpar.setOnAction(e -> limpar());
        excluir.setOnAction(e -> excluir());

        pesquisa.setPromptText("Digite o nome do bombeiro");
        pesquisa.setPrefWidth(220);
        pesquisa.setOnAction(e -> pesquisar());

        configurarFiltro(filtroPatente, "Todas", patentes);
        configurarFiltro(filtroEspecialidade, "Todas", especialidades);
        configurarFiltro(filtroStatus, "Todos", status);

        filtroPatente.setOnAction(e -> pesquisar());
        filtroEspecialidade.setOnAction(e -> pesquisar());
        filtroStatus.setOnAction(e -> pesquisar());

        HBox topo = new HBox(
                titulo, new Region(), cadastrar
        );
        HBox.setHgrow(
                topo.getChildren().get(1),
                Priority.ALWAYS
        );
        topo.setAlignment(Pos.CENTER_LEFT);
        topo.setPadding(new Insets(20));

        HBox filtros = new HBox(
                8,pesquisa,pesquisar,filtroPatente,filtroEspecialidade,filtroStatus,limpar,excluir
        );
        filtros.setAlignment(Pos.CENTER_LEFT);
        tabela.getColumns().addAll(
                coluna("Matrícula", "matricula"),coluna("Nome", "nome"),
                coluna("Patente", "patente"),coluna("Especialidade", "especialidade"),
                coluna("Status", "status")
        );
        tabela.setItems(lista);
        total.setText(
                "Total de bombeiros: " + lista.size()
        );
        VBox tela = new VBox(
                15,topo,new Label("Filtros de Pesquisa"),filtros, total, tabela 
        );
        tela.setPadding(
                new Insets(20, 45, 20, 45)
        );
        VBox.setVgrow(
                tabela,
               Priority.ALWAYS
        );
        stage.setTitle(
                "Cadastro de Bombeiros"
        );
        stage.setScene(
                new Scene(tela, 1200, 700)
        );
        stage.show();
    }
    private void configurarFiltro(
            ComboBox<String> combo,
            String primeiro,
            String[] opcoes) {

        combo.getItems().add(primeiro);
        combo.getItems().addAll(opcoes);
        combo.setValue(primeiro);
    }
    private void pesquisar() {
        String nome = pesquisa.getText()
                .trim()
                .toLowerCase();
        String patente = filtroPatente.getValue();
        String especialidade = filtroEspecialidade.getValue();
        String statusSelecionado = filtroStatus.getValue();

        ObservableList<Bombeiro> resultado
                = FXCollections.observableArrayList();
        for (Bombeiro b : lista) {

            boolean nomeOk
                    = nome.isEmpty()
                    || b.getNome().toLowerCase().contains(nome);

            boolean patenteOk
                    = patente.equals("Todas")
                    || b.getPatente().equals(patente);

            boolean especialidadeOk
                    = especialidade.equals("Todas")
                    || b.getEspecialidade().equals(especialidade);

            boolean statusOk
                    = statusSelecionado.equals("Todos")
                    || b.getStatus().equals(statusSelecionado);

            if (nomeOk
                    && patenteOk
                    && especialidadeOk
                    && statusOk) {

                resultado.add(b);
            }
        }
        tabela.setItems(resultado);

        total.setText(
                "Total de bombeiros: " + resultado.size()
        );
    }
    private void limpar() {
        pesquisa.clear();
        filtroPatente.setValue("Todas");
        filtroEspecialidade.setValue("Todas");
        filtroStatus.setValue("Todos");

        tabela.setItems(lista);

        total.setText(
                "Total de bombeiros: " + lista.size()
        );
    }
    private void excluir() {
        Bombeiro selecionado
                = tabela.getSelectionModel()
                        .getSelectedItem();
        if (selecionado == null) {
            new Alert(
                    Alert.AlertType.WARNING,
                    "Selecione um bombeiro na tabela."
            ).showAndWait();
            return;
        }
        Alert alerta = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Deseja excluir "
                + selecionado.getNome() + "?"
        );
        alerta.setTitle("Excluir Bombeiro");
        alerta.setHeaderText("Confirmar exclusão");

        if (alerta.showAndWait()
                .orElse(ButtonType.CANCEL)
                == ButtonType.OK) {

            lista.remove(selecionado);
            pesquisar();
        }
    }
    private void cadastrar() {
        Stage janela = new Stage();
        janela.initModality(
                Modality.APPLICATION_MODAL
        );
        janela.setTitle(
                "Cadastrar Bombeiro"
        );
        TextField nome = criarCampo();
        TextField cpf = criarCampo();
        TextField matricula = criarCampo();
        TextField nascimento = criarCampo();
        TextField contato = criarCampo();
        ComboBox<String> campoPatente
                = criarCombo(patentes);
        ComboBox<String> campoEspecialidade
                = criarCombo(especialidades);
        ComboBox<String> campoStatus
                = criarCombo(status);
        VBox formulario = new VBox(
                8,
                linha("Nome:", nome),linha("CPF:", cpf),linha("Matrícula:", matricula),
                linha("Data de nascimento:", nascimento),linha("Especialidade:", campoEspecialidade),
                linha("Contato:", contato),linha("Status:", campoStatus),
                linha("Patente:", campoPatente)
        );
        Button confirmar
                = new Button("Confirmar");
        Button cancelar
                = new Button("Cancelar");
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
            if (nome.getText().isEmpty()
                    || matricula.getText().isEmpty()
                    || campoPatente.getValue() == null
                    || campoEspecialidade.getValue() == null
                    || campoStatus.getValue() == null) {

                new Alert(
                        Alert.AlertType.WARNING,
                        "Preencha os campos obrigatórios."
                ).showAndWait();

                return;
            }
            Bombeiro novo = new Bombeiro(
                    matricula.getText(),
                    nome.getText(),
                    campoPatente.getValue(),
                    campoEspecialidade.getValue(),
                    campoStatus.getValue()
            );
            lista.add(novo);
            tabela.setItems(lista);
            total.setText(
                    "Total de bombeiros: " + lista.size()
            );
            janela.close();
        });
        cancelar.setOnAction(
                e -> janela.close()
        );
        HBox botoes = new HBox(
                85,
                confirmar,
                cancelar
        );
        botoes.setAlignment(
                Pos.CENTER
        );
        VBox tela = new VBox(
                15,
                formulario,
                botoes
        );
        tela.setPadding(
                new Insets(20)
        );

        janela.setScene(
                new Scene(tela, 620, 490)
        );
        janela.setResizable(false);
        janela.showAndWait();
    }
    private TextField criarCampo() {

        TextField campo
                = new TextField();

        campo.setPrefHeight(36);

        return campo;
    }
    private ComboBox<String> criarCombo(
            String[] opcoes) {

        ComboBox<String> combo
                = new ComboBox<>();

        combo.getItems().addAll(opcoes);
        combo.setPrefHeight(36);

        return combo;
    }
    private HBox linha(
            String texto,
            Control campo) {

        Label label
                = new Label(texto);

        label.setPrefWidth(180);
        label.setStyle(
                "-fx-font-size:17px;"
        );

        HBox linha
                = new HBox(
                        5, label, campo
                );

        linha.setAlignment(
                Pos.CENTER_LEFT
        );
        HBox.setHgrow(
                campo,
                Priority.ALWAYS
        );
        return linha;
    }
    private TableColumn<Bombeiro, String> coluna(
            String titulo,
            String propriedade) {

        TableColumn<Bombeiro, String> coluna
                = new TableColumn<>(titulo);

        coluna.setCellValueFactory(
                new PropertyValueFactory<>(
                        propriedade
                )
        );
        coluna.setPrefWidth(200);
        return coluna;
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

