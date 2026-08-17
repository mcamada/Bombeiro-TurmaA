package com.mycompany.sistemagestaoviaturas2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

@Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        VBox topo = new VBox(10);
        topo.setPadding(new Insets(10));

        Label titulo = new Label("Consulta de Viaturas");
        titulo.setStyle("-fx-font-size:24; -fx-font-weight:bold;");

        HBox pesquisa = new HBox(10);

        TextField txtBusca = new TextField();
        txtBusca.setPromptText("Buscar por placa...");

        Button btCadastrar = new Button("Cadastrar");

        pesquisa.getChildren().addAll(txtBusca, btCadastrar);

        GridPane filtros = new GridPane();
        filtros.setHgap(20);
        filtros.setVgap(10);

        ComboBox<String> cbStatus = new ComboBox<>();
        cbStatus.getItems().addAll("Todos", "Ativa", "Manutenção");
        cbStatus.setValue("Todos");

        ComboBox<String> cbTipo = new ComboBox<>();
        cbTipo.getItems().addAll("Todos", "Resgate", "Ambulância");

        cbTipo.setValue("Todos");

        ComboBox<String> cbLocal = new ComboBox<>();
        cbLocal.getItems().addAll("Todos", "Central", "Quartel");
        cbLocal.setValue("Todos");

        filtros.add(new Label("Status"), 0, 0);
        filtros.add(cbStatus, 0, 1);

        filtros.add(new Label("Tipo"), 1, 0);
        filtros.add(cbTipo, 1, 1);

        filtros.add(new Label("Localização"), 2, 0);
        filtros.add(cbLocal, 2, 1);

        topo.getChildren().addAll(titulo, pesquisa, filtros);

        VBox centro = new VBox(10);
        centro.setPadding(new Insets(10));

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
        tabela.add(new Button("Selecionar"),0, 6);

        tabela.add(new Label("VT-02 | DFG-5678"), 1, 0);
        tabela.add(new Label("Volkswagen"), 1, 1);
        tabela.add(new Label("2021"), 1, 2);
        tabela.add(new Label("Oficina Especializada"), 1, 3);
        tabela.add(new Label("Resgate"), 1, 4);
        tabela.add(new Label("1 Manutenção"), 1, 5);
        tabela.add(new Button("Selecionar"),1, 6);

        tabela.add(new Label("VT-03 | HIJ-9101"), 2, 0);
        tabela.add(new Label("Fiat"), 2, 1);
        tabela.add(new Label("2022"), 2, 2);
        tabela.add(new Label("Quartel Sul"), 2, 3);
        tabela.add(new Label("Ambulancia"), 2, 4);
        tabela.add(new Label("1 Manutenção"), 2, 5);
        tabela.add(new Button("Selecionar"),2, 6);

       
     
        centro.getChildren().addAll(quantidade, tabela);

        root.setTop(topo);
        root.setCenter(centro);

        Scene scene = new Scene(root, 900, 500);

        stage.setScene(scene);
        stage.setTitle("Consulta de Viaturas");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
