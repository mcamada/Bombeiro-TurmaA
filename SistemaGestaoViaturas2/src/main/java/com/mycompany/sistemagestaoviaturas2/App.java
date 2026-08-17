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

public class App extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Label titulo = new Label("Consulta de Viaturas");

        HBox pesquisa = new HBox(10);

        TextField busca = new TextField();
        busca.setPromptText("Buscar por placa...");

        Button cadastrar = new Button("Cadastrar");

        cadastrar.setOnAction(e -> {
            CadastroViatura cadastro = new CadastroViatura();
            cadastro.start(new Stage());
            stage.close();
        });

        pesquisa.getChildren().addAll(busca, cadastrar);

        GridPane filtros = new GridPane();
        filtros.setHgap(20);
        filtros.setVgap(5);

        ComboBox<String> status = new ComboBox<>();
        status.getItems().addAll("Todos", "Ativa", "Manutenção");
        status.setValue("Todos");

        ComboBox<String> tipo = new ComboBox<>();
        tipo.getItems().addAll("Todos", "Resgate", "Ambulância");
        tipo.setValue("Todos");

        ComboBox<String> local = new ComboBox<>();
        local.getItems().addAll("Todos", "Central", "Quartel");
        local.setValue("Todos");

        filtros.add(new Label("Status"), 0, 0);
        filtros.add(status, 0, 1);

        filtros.add(new Label("Tipo"), 1, 0);
        filtros.add(tipo, 1, 1);

        filtros.add(new Label("Localização"), 2, 0);
        filtros.add(local, 2, 1);

        Label quantidade = new Label("Exibindo 3 de 3 Viaturas");

        GridPane tabela = new GridPane();
        tabela.setHgap(20);
        tabela.setVgap(10);

        tabela.add(new Label("VT-01 | ABC-1234"), 0, 0);
        tabela.add(new Label("Mercedes"), 0, 1);
        tabela.add(new Label("2020"), 0, 2);
        tabela.add(new Label("Oficina Central"), 0, 3);
        tabela.add(new Label("Combate a Incendio"), 0, 4);
        tabela.add(new Label("2 Manutenções"), 0, 5);
        tabela.add(new Button("Selecionar"), 0, 6);

        tabela.add(new Label("VT-02 | DFG-5678"), 1, 0);
        tabela.add(new Label("Volkswagen"), 1, 1);
        tabela.add(new Label("2021"), 1, 2);
        tabela.add(new Label("Oficina Especializada"), 1, 3);
        tabela.add(new Label("Resgate"), 1, 4);
        tabela.add(new Label("1 Manutenção"), 1, 5);
        tabela.add(new Button("Selecionar"), 1, 6);

        tabela.add(new Label("VT-03 | HIJ-9101"), 2, 0);
        tabela.add(new Label("Fiat"), 2, 1);
        tabela.add(new Label("2022"), 2, 2);
        tabela.add(new Label("Quartel Sul"), 2, 3);
        tabela.add(new Label("Ambulancia"), 2, 4);
        tabela.add(new Label("1 Manutenção"), 2, 5);
        tabela.add(new Button("Selecionar"), 2, 6);

        root.getChildren().addAll(
                titulo,
                pesquisa,
                filtros,
                quantidade,
                tabela
        );

        Scene scene = new Scene(root, 900, 500);

        stage.setScene(scene);
        stage.setTitle("Consulta de Viaturas");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}