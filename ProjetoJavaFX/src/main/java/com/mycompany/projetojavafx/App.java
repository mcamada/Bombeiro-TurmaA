package com.mycompany.projetojavafx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private Stage primaryStage;
    private Scene cenaFormulario;
    private Scene cenaSucesso;

    private List<TextField> camposTexto = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        this.cenaFormulario = criarTelaFormulario();
        this.cenaSucesso = criarTelaSucesso();

        stage.setTitle("Cadastro de Bombeiros");
        stage.setScene(cenaFormulario);
        stage.show();
    }

    private Scene criarTelaFormulario() {
        VBox layoutPrincipal = new VBox(15);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);
        layoutPrincipal.setPrefSize(700, 500);

        Label labelTitulo = new Label("Cadastro de bombeiros:");
        labelTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        labelTitulo.setTextFill(Color.BLACK);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);
        grid.setAlignment(Pos.CENTER);

        String[] campos = {
            "Identificador do bombeiro:", "Data de nascimento:", "Nome completo:",
            "Especialidade:", "Matrícula:", "Patente:",
            "Contato:", "Status:", "CPF:"
        };

        for (int i = 0; i < campos.length; i++) {
            Label label = new Label(campos[i]);
            label.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            label.setTextFill(Color.BLACK);
            
            TextField txtField = new TextField();
            txtField.setPrefWidth(180);
            txtField.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

            grid.add(label, 0, i);
            grid.add(txtField, 1, i);

            camposTexto.add(txtField);
        }

        Button btnCadastrar = criarBotaoEstilizado("Cadastrar", "#FFFFFF", "#000000");
        Button btnCancelar = criarBotaoEstilizado("Cancelar", "#FFFFFF", "#CC0000");

        btnCadastrar.setOnAction(e -> {
            if (validarCampos()) {
                primaryStage.setScene(cenaSucesso);
            }else{
                
            }
        });

        btnCancelar.setOnAction(e -> limparCampos());

        HBox layoutBotoes = new HBox(20, btnCadastrar, btnCancelar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(labelTitulo, grid, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private Scene criarTelaSucesso() {
        VBox layoutPrincipal = new VBox(30);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);

        VBox cardMensagem = new VBox();
        cardMensagem.setStyle("-fx-background-color: white; -fx-background-radius: 15;");
        cardMensagem.setPrefSize(350, 120);
        cardMensagem.setMaxSize(350, 120);
        cardMensagem.setAlignment(Pos.CENTER);

        Label labelSucesso = new Label("Atualização de bombeiro bem sucedida!");
        labelSucesso.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        labelSucesso.setTextFill(Color.BLACK);
        labelSucesso.setStyle("-fx-text-alignment: center;");
        cardMensagem.getChildren().add(labelSucesso);

        Button btnVoltar = criarBotaoEstilizado("Voltar", "#FFFFFF", "#CC0000");
        Button btnContinuar = criarBotaoEstilizado("Continuar", "#FFFFFF", "#000000");

        btnVoltar.setOnAction(e -> primaryStage.setScene(cenaFormulario));

        HBox layoutBotoes = new HBox(20, btnVoltar, btnContinuar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(cardMensagem, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private boolean validarCampos() {
        for (TextField tf : camposTexto) {
            if (tf.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void limparCampos() {
        for (TextField tf : camposTexto) {
            tf.clear();
        }
    }

    private Button criarBotaoEstilizado(String texto, String corFundo, String corTexto) {
        Button btn = new Button(texto);
        btn.setPrefSize(120, 35);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        btn.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: %s; -fx-background-radius: 15; -fx-cursor: hand;", corFundo, corTexto));
        return btn;
    }
    public static void main(String[] args) {
        launch(args);
    }
}