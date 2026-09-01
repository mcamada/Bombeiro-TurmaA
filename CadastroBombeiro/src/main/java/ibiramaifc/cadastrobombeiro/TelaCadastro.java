/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibiramaifc.cadastrobombeiro;

/**
 *
 * @author aluno
 */
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TelaCadastro {

    public void iniciar(Stage stage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, 520, 540);

        Label titulo = new Label("Cadastro de Bombeiro");
        titulo.setLayoutX(120);
        titulo.setLayoutY(15);
        titulo.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        titulo.setTextFill(Color.web("#0D3B66"));

        Label lblNome = new Label("Nome:");
        lblNome.setLayoutX(20);
        lblNome.setLayoutY(70);

        TextField txtNome = new TextField();
        txtNome.setLayoutX(160);
        txtNome.setLayoutY(65);
        txtNome.setPrefWidth(330);

        Label lblUsuario = new Label("Nome de usuário:");
        lblUsuario.setLayoutX(20);
        lblUsuario.setLayoutY(110);

        TextField txtUsuario = new TextField();
        txtUsuario.setLayoutX(160);
        txtUsuario.setLayoutY(105);
        txtUsuario.setPrefWidth(330);

        Label lblSenha = new Label("Senha:");
        lblSenha.setLayoutX(20);
        lblSenha.setLayoutY(150);

        PasswordField txtSenha = new PasswordField();
        txtSenha.setLayoutX(160);
        txtSenha.setLayoutY(145);
        txtSenha.setPrefWidth(330);

        Label lblRepetirSenha = new Label("Repetir senha:");
        lblRepetirSenha.setLayoutX(20);
        lblRepetirSenha.setLayoutY(190);

        PasswordField txtRepetirSenha = new PasswordField();
        txtRepetirSenha.setLayoutX(160);
        txtRepetirSenha.setLayoutY(185);
        txtRepetirSenha.setPrefWidth(330);

        Label lblTelefone = new Label("Telefone:");
        lblTelefone.setLayoutX(20);
        lblTelefone.setLayoutY(230);

        TextField txtTelefone = new TextField();
        txtTelefone.setPromptText("ex: +55 47 98888-8888");
        txtTelefone.setLayoutX(160);
        txtTelefone.setLayoutY(225);
        txtTelefone.setPrefWidth(330);

        Label lblCpf = new Label("CPF:");
        lblCpf.setLayoutX(20);
        lblCpf.setLayoutY(270);

        TextField txtCpf = new TextField();
        txtCpf.setPromptText("ex: 123.456.789-12");
        txtCpf.setLayoutX(160);
        txtCpf.setLayoutY(265);
        txtCpf.setPrefWidth(330);

        Label lblData = new Label("Data de nascimento:");
        lblData.setLayoutX(20);
        lblData.setLayoutY(310);

        TextField txtData = new TextField();
        txtData.setPromptText("ex: 01/01/1900");
        txtData.setLayoutX(160);
        txtData.setLayoutY(305);
        txtData.setPrefWidth(330);

        Button btnCadastrar = new Button("Cadastrar");
        btnCadastrar.setLayoutX(200);
        btnCadastrar.setLayoutY(360);
        btnCadastrar.setStyle("-fx-background-color: #1E88E5; -fx-text-fill: white; -fx-font-weight: bold;");

        EventHandler<MouseEvent> ehCadastrar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String nome = txtNome.getText();
                String usuario = txtUsuario.getText();
                String senha = txtSenha.getText();
                String repetirSenha = txtRepetirSenha.getText();
                String telefone = txtTelefone.getText();
                String cpf = txtCpf.getText();
                String dataNascimento = txtData.getText();

                if (nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()
                        || telefone.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty()) {
                    Alert alerta = new Alert(AlertType.ERROR);
                    alerta.setHeaderText("Preencha todos os campos!");
                    alerta.show();
                    event.consume();
                    return;
                }

                if (!senha.equals(repetirSenha)) {
                    Alert alerta = new Alert(AlertType.ERROR);
                    alerta.setHeaderText("As senhas digitadas não são iguais!");
                    alerta.show();
                    event.consume();
                    return;
                }

                if (BancoDados.buscarPorUsuario(usuario) != null) {
                    Alert alerta = new Alert(AlertType.ERROR);
                    alerta.setHeaderText("Já existe um cadastro com esse nome de usuário!");
                    alerta.show();
                    event.consume();
                    return;
                }

                Bombeiro novoBombeiro = new Bombeiro(nome, usuario, senha, telefone, cpf, dataNascimento);
                BancoDados.listaBombeiros.add(novoBombeiro);

                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setHeaderText("Cadastro realizado com sucesso!");
                alerta.show();

                txtNome.clear();
                txtUsuario.clear();
                txtSenha.clear();
                txtRepetirSenha.clear();
                txtTelefone.clear();
                txtCpf.clear();
                txtData.clear();

                event.consume();
            }
        };
        btnCadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, ehCadastrar);

        Button btnPesquisar = new Button("Pesquisar Cadastro");
        btnPesquisar.setLayoutX(130);
        btnPesquisar.setLayoutY(410);

        EventHandler<MouseEvent> ehPesquisar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TelaPesquisa telaPesquisa = new TelaPesquisa();
                telaPesquisa.iniciar();
                event.consume();
            }
        };
        btnPesquisar.addEventHandler(MouseEvent.MOUSE_CLICKED, ehPesquisar);

        Button btnAtualizar = new Button("Atualizar Cadastro");
        btnAtualizar.setLayoutX(290);
        btnAtualizar.setLayoutY(410);

        EventHandler<MouseEvent> ehAtualizar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TelaAtualizar telaAtualizar = new TelaAtualizar();
                telaAtualizar.iniciar();
                event.consume();
            }
        };
        btnAtualizar.addEventHandler(MouseEvent.MOUSE_CLICKED, ehAtualizar);

        root.getChildren().addAll(
                titulo,
                lblNome, txtNome,
                lblUsuario, txtUsuario,
                lblSenha, txtSenha,
                lblRepetirSenha, txtRepetirSenha,
                lblTelefone, txtTelefone,
                lblCpf, txtCpf,
                lblData, txtData,
                btnCadastrar, btnPesquisar, btnAtualizar
        );

        stage.setScene(scene);
        stage.setTitle("Cadastro de Bombeiro");
        stage.show();
    }
}
