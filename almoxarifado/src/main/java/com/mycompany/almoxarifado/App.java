package com.mycompany.almoxarifado;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        Label titulo = new Label("Tela Inicial");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));

        root.getChildren().add(titulo);

        VBox campos = new VBox(10);
        Button cadastrar = new Button("Cadrastar Item");
        cadastrar.setId("btcadastrar");
        EventHandler<MouseEvent> cadastra = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage cadastrar = new Stage();
                cadastrar.initModality(Modality.APPLICATION_MODAL);
                VBox rootCadastro = new VBox();

                Label titulo = new Label("Cadastrar Item");
                titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));

                GridPane formulario = new GridPane();

                formulario.add(new Label("*Item:"), 0, 2);
                formulario.add(new TextField(), 1, 2);

                formulario.add(new Label("*Categoria:"), 0, 3);
                formulario.add(new TextField(), 1, 3);

                formulario.add(new Label("*Data:"), 0, 4);
                formulario.add(new TextField(), 1, 4);

                formulario.add(new Label("*Quantidade inicial:"), 0, 5);
                Spinner quantidade = new Spinner(1, 1000, 0);
                formulario.add(quantidade, 1, 5);

                formulario.add(new Label("*Unidade de medida:"), 0, 6);
                formulario.add(new TextField(), 1, 6);

                formulario.add(new Label("*Localização no estoque:"), 0, 7);
                formulario.add(new TextField(), 1, 7);

                formulario.add(new Label("*Nível mínimo de estoque:"), 0, 8);
                formulario.add(new TextField(), 1, 8);

                HBox botoes = new HBox();

                Button confirmar = new Button("CONFIRMAR");
                confirmar.setId("btcondirmar");
                confirmar.getStyleClass().add("button");
                Button cancelar = new Button("CANCELAR");
                cancelar.getStyleClass().add("button");

                Label obrigatorio = new Label("* Itens Obrigatórios");
                obrigatorio.setFont(Font.font("Arial", FontPosture.REGULAR, 10));
                obrigatorio.setTextFill(Color.RED);
                
                botoes.getChildren().addAll(confirmar, cancelar, obrigatorio);
                rootCadastro.getChildren().addAll(titulo, formulario, botoes);
                Scene cenarioCadastro = new Scene(rootCadastro, 640, 480);
                cadastrar.setScene(cenarioCadastro);
                
                
                EventHandler<MouseEvent> botaoAlerta = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        confirmar.getStyleClass().add("fieldErro");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("CAMPO OBRIGATÓRIO NÃO PREENCHIDO");
                        alert.show();
                        event.consume();
                    }
                };
                confirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, botaoAlerta);
                cadastrar.showAndWait();
            }
        };
        cadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, cadastra);
        stage.show();

        //-----------------------------------------------------------------------------------------------------------------
        
        Button consultar = new Button("Consultar Item");
        consultar.setId("btconsultar");
        EventHandler<MouseEvent> consulta = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage consultar1 = new Stage();
                consultar1.initModality(Modality.APPLICATION_MODAL);
                VBox rootCadastro = new VBox();

                Label titulo = new Label("Consultar Item");
                titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));

                GridPane formulario1 = new GridPane();

                formulario1.add(new Label("*Item:"), 0, 2);
                formulario1.add(new TextField(), 1, 2);
                
                formulario1.add(new Label("*Categoria:"), 0, 3);
                formulario1.add(new TextField(), 1, 3);

                formulario1.add(new Label("*Quantidade Disponível:"), 0, 5);
                Spinner quantidade = new Spinner(1, 1000, 0);
                formulario1.add(quantidade, 1, 5);

                formulario1.add(new Label("*Localização no Estoque:"), 0, 6);
                formulario1.add(new TextField(), 1, 6);

                HBox botoes = new HBox();

                Button confirmar = new Button("CONFIRMAR");
                confirmar.getStyleClass().add("button");
                Button cancelar = new Button("CANCELAR");
                cancelar.setId("btcancelar");
                cancelar.getStyleClass().add("button");

                Label obrigatorio = new Label("* Itens Obrigatórios");
                obrigatorio.setFont(Font.font("Arial", FontPosture.REGULAR, 10));
                obrigatorio.setTextFill(Color.RED);
                
                ObservableList<String> itens = FXCollections.observableArrayList("Item","Item","Item","Item","Item","Item","Item");
                ListView<String> lista = new ListView<String>(itens);

                botoes.getChildren().addAll(confirmar, cancelar, obrigatorio);
                rootCadastro.getChildren().addAll(titulo, formulario1, botoes, lista);
                Scene cenarioCadastro = new Scene(rootCadastro, 640, 480);
                consultar1.setScene(cenarioCadastro);
                
                
                EventHandler<MouseEvent> botaoAlerta = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        confirmar.getStyleClass().add("fieldErro");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("CAMPO OBRIGATÓRIO NÃO PREENCHIDO");
                        alert.show();
                        event.consume();
                    }
                };
                confirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, botaoAlerta);
                consultar1.showAndWait();
            }
        };
        consultar.addEventHandler(MouseEvent.MOUSE_CLICKED, consulta);
        stage.show();

        //-----------------------------------------------------------------------------------------------------------------
        Button atualizar = new Button("Atualizar Item");
        EventHandler<MouseEvent> atualiza = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage atualizar1 = new Stage();
                atualizar1.initModality(Modality.APPLICATION_MODAL);
                VBox rootAtualiza = new VBox();

                Label titulo = new Label("Atualizar Item");
                titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));

                GridPane formulario2 = new GridPane();

                formulario2.add(new Label("*Item:"), 0, 2);
                formulario2.add(new TextField(), 1, 2);
                
                formulario2.add(new Label("*Categoria:"), 0, 3);
                formulario2.add(new TextField(), 1, 3);


                formulario2.add(new Label("*Quantidade Disponível:"), 0, 5);
                Spinner quantidade = new Spinner(1, 1000, 0);
                formulario2.add(quantidade, 1, 5);

                formulario2.add(new Label("*Localização no Estoque:"), 0, 6);
                formulario2.add(new TextField(), 1, 6);
                
                formulario2.add(new Label("*Descrição:"), 0, 7);
                formulario2.add(new TextArea(), 1, 7);


                HBox botoes = new HBox();

                Button confirmar = new Button("CONFIRMAR");
                confirmar.getStyleClass().add("button");
                Button cancelar = new Button("CANCELAR");
                cancelar.getStyleClass().add("button");

                Label obrigatorio = new Label("* Itens Obrigatórios");
                obrigatorio.setFont(Font.font("Arial", FontPosture.REGULAR, 10));
                obrigatorio.setTextFill(Color.RED);
                
                ObservableList<String> itens = FXCollections.observableArrayList("Item","Item","Item","Item","Item","Item","Item");
                ListView<String> lista = new ListView<String>(itens);

                botoes.getChildren().addAll(confirmar, cancelar, obrigatorio);
                rootAtualiza.getChildren().addAll(titulo, formulario2, botoes, lista);
                Scene cenarioAtualiza = new Scene(rootAtualiza, 640, 480);
                atualizar1.setScene(cenarioAtualiza);
                
                
                EventHandler<MouseEvent> botaoAlerta = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        confirmar.getStyleClass().add("fieldErro");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("CAMPO OBRIGATÓRIO NÃO PREENCHIDO");
                        alert.show();
                        event.consume();
                    }
                };
                confirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, botaoAlerta);
                atualizar1.showAndWait();
            }
        };
        atualizar.addEventHandler(MouseEvent.MOUSE_CLICKED, atualiza);
        stage.show();

        //-----------------------------------------------------------------------------------------------------------------
        Button excluir = new Button("Excluir Item");
        EventHandler<MouseEvent> exclui = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage excluir1 = new Stage();
                excluir1.initModality(Modality.APPLICATION_MODAL);
                VBox rootExclui = new VBox();

                Label titulo = new Label("Excluir Item");
                titulo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30));

                GridPane formulario3 = new GridPane();

                formulario3.add(new Label("*Item:"), 0, 2);
                formulario3.add(new TextField(), 1, 2);
                
                formulario3.add(new Label("*Categoria:"), 0, 3);
                formulario3.add(new TextField(), 1, 3);

                HBox botoes = new HBox();

                Button confirmar = new Button("CONFIRMAR");
                confirmar.getStyleClass().add("button");
                Button cancelar = new Button("CANCELAR");
                cancelar.getStyleClass().add("button");

                Label obrigatorio = new Label("* Itens Obrigatórios");
                obrigatorio.setFont(Font.font("Arial", FontPosture.REGULAR, 10));
                obrigatorio.setTextFill(Color.RED);
                
                ObservableList<String> itens = FXCollections.observableArrayList("Item","Item","Item","Item","Item","Item","Item");
                ListView<String> lista = new ListView<String>(itens);

                botoes.getChildren().addAll(confirmar, cancelar, obrigatorio);
                rootExclui.getChildren().addAll(titulo, formulario3, botoes, lista);
                Scene cenarioExclui = new Scene(rootExclui, 640, 480);
                excluir1.setScene(cenarioExclui);
                
                
                EventHandler<MouseEvent> botaoAlerta = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        confirmar.getStyleClass().add("fieldErro");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("CAMPO OBRIGATÓRIO NÃO PREENCHIDO");
                        alert.show();
                        event.consume();
                    }
                };
                confirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, botaoAlerta);
                excluir1.showAndWait();
            }
        };
        excluir.addEventHandler(MouseEvent.MOUSE_CLICKED, exclui);
        stage.show();

        campos.setAlignment(Pos.CENTER);

        campos.getChildren().addAll(cadastrar, consultar, atualizar, excluir);

        root.getChildren().add(campos);
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add("/css/style.css");
        stage.setScene(scene);
        stage.show();

    }
}