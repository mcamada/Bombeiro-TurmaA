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
            new Bombeiro("BM-2023-045", "Léo Heitor", "Cabo",
                    "Resgate", "Ativo")
    );

    String[] patentes = {
        "Soldado", "Cabo", "Sargento",
        "Tenente", "Capitão"
    };

    String[] especialidades = {
        "Combate a Incêndio",
        "Resgate",
        "Salvamento Aquático"
    };

    String[] status = {
        "Ativo",
        "Afastado",
        "Inativo"
    };

    TableView<Bombeiro> tabela = new TableView<>();

    @Override
    public void start(Stage stage) {

        Label titulo = new Label("Cadastro de Bombeiros");

        Button cadastrar = new Button("+ Cadastrar Bombeiro");
        Button pesquisar = new Button("Pesquisar");
        Button limpar = new Button("Limpar Filtros");
        Button editar = new Button("Editar");
        Button excluir = new Button("Excluir Bombeiro");

        cadastrar.setOnAction(e -> cadastrar());

        TextField campoPesquisa = new TextField();
        campoPesquisa.setPromptText(
                "Digite o nome do bombeiro"
        );

        ComboBox<String> filtroPatente
                = new ComboBox<>();

        filtroPatente.getItems().add("Todas");
        filtroPatente.getItems().addAll(patentes);
        filtroPatente.setValue("Todas");

        ComboBox<String> filtroEspecialidade
                = new ComboBox<>();

        filtroEspecialidade.getItems().add("Todas");
        filtroEspecialidade.getItems().addAll(especialidades);
        filtroEspecialidade.setValue("Todas");

        ComboBox<String> filtroStatus
                = new ComboBox<>();

        filtroStatus.getItems().add("Todos");
        filtroStatus.getItems().addAll(status);
        filtroStatus.setValue("Todos");

        tabela.getColumns().addAll(
                coluna("Matrícula", "matricula"),
                coluna("Nome", "nome"),
                coluna("Patente", "patente"),
                coluna("Especialidade", "especialidade"),
                coluna("Status", "status")
        );

        tabela.setItems(lista);

        HBox topo = new HBox(
                20,
                titulo,
                cadastrar
        );

        topo.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox botoes = new HBox(
                8,
                campoPesquisa,
                pesquisar,
                filtroPatente,
                filtroEspecialidade,
                filtroStatus,
                limpar,
                editar,
                excluir
        );

        VBox tela = new VBox(
                15,
                topo,
                new Label("Filtros de Pesquisa"),
                botoes,
                tabela
        );

        tela.setPadding(
                new Insets(25)
        );

        VBox.setVgrow(
                tabela,
                Priority.ALWAYS
        );

        stage.setTitle(
                "Cadastro de Bombeiros"
        );

        stage.setScene(
                new Scene(tela, 1200, 650)
        );

        stage.show();
    }

    private void cadastrar() {

        Stage janela = new Stage();

        janela.initModality(
                Modality.APPLICATION_MODAL
        );

        TextField nome = new TextField();
        TextField cpf = new TextField();
        TextField matricula = new TextField();
        TextField nascimento = new TextField();
        TextField contato = new TextField();

        ComboBox<String> patente
                = criarCombo(patentes);

        ComboBox<String> especialidade
                = criarCombo(especialidades);

        ComboBox<String> status
                = criarCombo(this.status);

        Button confirmar
                = new Button("Confirmar");

        Button cancelar
                = new Button("Cancelar");

        cancelar.setOnAction(
                e -> janela.close()
        );

        VBox formulario = new VBox(
                10,
                linha("Nome:", nome),
                linha("CPF:", cpf),
                linha("Matrícula:", matricula),
                linha("Nascimento:", nascimento),
                linha("Contato:", contato),
                linha("Patente:", patente),
                linha("Especialidade:", especialidade),
                linha("Status:", status),
                confirmar,
                cancelar
        );

        formulario.setPadding(
                new Insets(20)
        );

        janela.setTitle(
                "Cadastrar Bombeiro"
        );

        janela.setScene(
                new Scene(formulario, 550, 500)
        );

        janela.show();

    }

    private ComboBox<String> criarCombo(String[] dados) {

        ComboBox<String> combo
                = new ComboBox<>();

        combo.getItems().addAll(dados);

        return combo;
    }

    private HBox linha(
            String texto,
            Control campo
    ) {

        Label label
                = new Label(texto);

        label.setPrefWidth(140);

        HBox linha
                = new HBox(
                        10,
                        label,
                        campo
                );

        HBox.setHgrow(
                campo,
                Priority.ALWAYS
        );

        return linha;
    }

    private TableColumn<Bombeiro, String> coluna(
            String nome,
            String campo
    ) {

        TableColumn<Bombeiro, String> coluna
                = new TableColumn<>(nome);

        coluna.setCellValueFactory(
                new PropertyValueFactory<>(campo)
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
