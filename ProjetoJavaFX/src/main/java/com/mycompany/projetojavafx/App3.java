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

public class App3 extends Application {

    private Stage primaryStage;
    private Scene cenaFormulario;
    private Scene cenaConfirmacao;
    private Scene cenaSucesso;

    private TextField txtNome;
    private TextField txtPatente;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        this.cenaFormulario = criarTelaFormulario();
        this.cenaConfirmacao = criarTelaConfirmacao();
        this.cenaSucesso = criarTelaSucesso();

        stage.setTitle("Exclusão de Bombeiro");
        stage.setScene(cenaFormulario);
        stage.show();
    }

    private Scene criarTelaFormulario() {
        VBox layoutPrincipal = new VBox(25);
        layoutPrincipal.setStyle("-fx-background-color: #CC0000;");
        layoutPrincipal.setAlignment(Pos.CENTER);

        Label labelTitulo = new Label("Exclusão de bombeiro:");
        labelTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        labelTitulo.setTextFill(Color.BLACK);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome Do Bombeiro");
        lblNome.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        lblNome.setTextFill(Color.BLACK);

        txtNome = new TextField();
        txtNome.setPrefWidth(220);
        txtNome.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

        Label lblPatente = new Label("Patente:");
        lblPatente.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        lblPatente.setTextFill(Color.BLACK);

        txtPatente = new TextField();
        txtPatente.setPrefWidth(220);
        txtPatente.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(lblPatente, 0, 1);
        grid.add(txtPatente, 1, 1);

        Button btnExcluir = criarBotaoEstilizado("Excluir\nbombeiro", "#FFFFFF", "#000000");
        Button btnCancelar = criarBotaoEstilizado("Cancelar", "#FFFFFF", "#CC0000");

        btnExcluir.setOnAction(e -> {
            if (validarCampos()) {
                primaryStage.setScene(cenaConfirmacao);
            } else {
                mostrarAlerta("Campos vazios", "Por favor, preencha todos os campos antes de continuar.");
            }
        });

        btnCancelar.setOnAction(e -> limparCampos());

        HBox layoutBotoes = new HBox(20, btnExcluir, btnCancelar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(labelTitulo, grid, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private Scene criarTelaConfirmacao() {
        StackPane root = new StackPane();
        
        VBox layoutFundo = new VBox(25);
        layoutFundo.setStyle("-fx-background-color: #CC0000;");
        layoutFundo.setAlignment(Pos.CENTER);

        Label labelTitulo = new Label("Exclusão de bombeiro:");
        labelTitulo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        labelTitulo.setTextFill(Color.BLACK);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome Do Bombeiro");
        lblNome.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        lblNome.setTextFill(Color.BLACK);

        TextField txtNomeFalso = new TextField(txtNome != null ? txtNome.getText() : "");
        txtNomeFalso.setPrefWidth(220);
        txtNomeFalso.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

        Label lblPatente = new Label("Patente:");
        lblPatente.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        lblPatente.setTextFill(Color.BLACK);

        TextField txtPatenteFalso = new TextField(txtPatente != null ? txtPatente.getText() : "");
        txtPatenteFalso.setPrefWidth(220);
        txtPatenteFalso.setStyle("-fx-background-radius: 5; -fx-background-color: white;");

        grid.add(lblNome, 0, 0);
        grid.add(txtNomeFalso, 1, 0);
        grid.add(lblPatente, 0, 1);
        grid.add(txtPatenteFalso, 1, 1);

        Button btnExcluirFalso = criarBotaoEstilizado("Excluir\nbombeiro", "#FFFFFF", "#000000");
        Button btnCancelarFalso = criarBotaoEstilizado("Cancelar", "#FFFFFF", "#CC0000");

        HBox layoutBotoesFundo = new HBox(20, btnExcluirFalso, btnCancelarFalso);
        layoutBotoesFundo.setAlignment(Pos.CENTER);

        layoutFundo.getChildren().addAll(labelTitulo, grid, layoutBotoesFundo);

        VBox cardModal = new VBox(15);
        cardModal.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);");
        cardModal.setPrefSize(320, 160);
        cardModal.setMaxSize(320, 160);
        cardModal.setAlignment(Pos.CENTER);

        Label labelMensagem = new Label("Tem certeza que deseja\ncontinuar com a exclusão\ndo Bombeiro?");
        labelMensagem.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        labelMensagem.setTextFill(Color.BLACK);
        labelMensagem.setStyle("-fx-text-alignment: center;");

        Button btnSim = new Button("Sim");
        btnSim.setPrefSize(80, 30);
        btnSim.setFont(Font.font("Segoe UI", FontWeight.BOLD, 12));
        btnSim.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-cursor: hand;");

        Button btnNao = new Button("Não");
        btnNao.setPrefSize(80, 30);
        btnNao.setFont(Font.font("Segoe UI", FontWeight.BOLD, 12));
        btnNao.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 10; -fx-background-radius: 10; -fx-cursor: hand;");

        btnSim.setOnAction(e -> primaryStage.setScene(cenaSucesso));
        btnNao.setOnAction(e -> primaryStage.setScene(cenaFormulario));

        HBox layoutBotoesModal = new HBox(20, btnSim, btnNao);
        layoutBotoesModal.setAlignment(Pos.CENTER);

        cardModal.getChildren().addAll(labelMensagem, layoutBotoesModal);

        root.getChildren().addAll(layoutFundo, cardModal);
        return new Scene(root, 750, 550);
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

        Label labelSucesso = new Label("Exclusão de bombeiro\nBem sucedida!");
        labelSucesso.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        labelSucesso.setTextFill(Color.BLACK);
        labelSucesso.setStyle("-fx-text-alignment: center;");
        cardMensagem.getChildren().add(labelSucesso);

        Button btnVoltar = criarBotaoEstilizado("Voltar", "#FFFFFF", "#CC0000");
        Button btnContinuar = criarBotaoEstilizado("Continuar", "#FFFFFF", "#000000");

        btnVoltar.setOnAction(e -> {
            limparCampos();
            primaryStage.setScene(cenaFormulario);
        });

        HBox layoutBotoes = new HBox(20, btnVoltar, btnContinuar);
        layoutBotoes.setAlignment(Pos.CENTER);

        layoutPrincipal.getChildren().addAll(cardMensagem, layoutBotoes);
        return new Scene(layoutPrincipal, 750, 550);
    }

    private boolean validarCampos() {
        return !txtNome.getText().trim().isEmpty() && !txtPatente.getText().trim().isEmpty();
    }

    private void limparCampos() {
        txtNome.clear();
        txtPatente.clear();
    }

    private Button criarBotaoEstilizado(String texto, String corFundo, String corTexto) {
        Button btn = new Button(texto);
        btn.setPrefSize(130, 40);
        btn.setFont(Font.font("Segoe UI", FontWeight.BOLD, 12));
        btn.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: %s; -fx-background-radius: 15; -fx-cursor: hand; -fx-text-alignment: center;", corFundo, corTexto));
        return btn;
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}