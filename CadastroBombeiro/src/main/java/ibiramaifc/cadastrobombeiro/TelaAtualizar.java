/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibiramaifc.cadastrobombeiro;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */

public class TelaAtualizar {

    private Bombeiro bombeiroSelecionado = null;

    public void iniciar() {

        Stage stage = new Stage();
        Pane root = new Pane();
        Scene scene = new Scene(root, 520, 400);

        // ---------- Título ----------
        Label titulo = new Label("Atualizar Cadastro");
        titulo.setLayoutX(140);
        titulo.setLayoutY(15);
        titulo.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        titulo.setTextFill(Color.web("#0D3B66"));

        Label lblUsuario = new Label("Nome de usuário:");
        lblUsuario.setLayoutX(20);
        lblUsuario.setLayoutY(70);

        TextField txtUsuario = new TextField();
        txtUsuario.setLayoutX(170);
        txtUsuario.setLayoutY(65);
        txtUsuario.setPrefWidth(220);

        Button btnBuscar = new Button("Buscar");
        btnBuscar.setLayoutX(410);
        btnBuscar.setLayoutY(64);

        Label lblNome = new Label("Nome:");
        lblNome.setLayoutX(20);
        lblNome.setLayoutY(130);

        TextField txtNome = new TextField();
        txtNome.setLayoutX(170);
        txtNome.setLayoutY(125);
        txtNome.setPrefWidth(320);
        txtNome.setDisable(true);

        Label lblTelefone = new Label("Telefone:");
        lblTelefone.setLayoutX(20);
        lblTelefone.setLayoutY(170);

        TextField txtTelefone = new TextField();
        txtTelefone.setLayoutX(170);
        txtTelefone.setLayoutY(165);
        txtTelefone.setPrefWidth(320);
        txtTelefone.setDisable(true);

        Label lblCpf = new Label("CPF:");
        lblCpf.setLayoutX(20);
        lblCpf.setLayoutY(210);

        TextField txtCpf = new TextField();
        txtCpf.setLayoutX(170);
        txtCpf.setLayoutY(205);
        txtCpf.setPrefWidth(320);
        txtCpf.setDisable(true);

        Label lblData = new Label("Data de nascimento:");
        lblData.setLayoutX(20);
        lblData.setLayoutY(250);

        TextField txtData = new TextField();
        txtData.setLayoutX(170);
        txtData.setLayoutY(245);
        txtData.setPrefWidth(320);
        txtData.setDisable(true);

        Button btnAtualizar = new Button("Salvar Alterações");
        btnAtualizar.setLayoutX(190);
        btnAtualizar.setLayoutY(300);
        btnAtualizar.setStyle("-fx-background-color: #1E88E5; -fx-text-fill: white; -fx-font-weight: bold;");
        btnAtualizar.setDisable(true);

        EventHandler<MouseEvent> ehBuscar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String usuario = txtUsuario.getText();
                bombeiroSelecionado = BancoDados.buscarPorUsuario(usuario);

                if (bombeiroSelecionado == null) {
                    Alert alerta = new Alert(AlertType.ERROR);
                    alerta.setHeaderText("Nenhum cadastro encontrado para esse usuário!");
                    alerta.show();

                    txtNome.clear();
                    txtTelefone.clear();
                    txtCpf.clear();
                    txtData.clear();

                    txtNome.setDisable(true);
                    txtTelefone.setDisable(true);
                    txtCpf.setDisable(true);
                    txtData.setDisable(true);
                    btnAtualizar.setDisable(true);
                } else {
                    txtNome.setText(bombeiroSelecionado.getNome());
                    txtTelefone.setText(bombeiroSelecionado.getTelefone());
                    txtCpf.setText(bombeiroSelecionado.getCpf());
                    txtData.setText(bombeiroSelecionado.getDataNascimento());

                    txtNome.setDisable(false);
                    txtTelefone.setDisable(false);
                    txtCpf.setDisable(false);
                    txtData.setDisable(false);
                    btnAtualizar.setDisable(false);
                }
                event.consume();
            }
        };
        btnBuscar.addEventHandler(MouseEvent.MOUSE_CLICKED, ehBuscar);

        EventHandler<MouseEvent> ehAtualizar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (bombeiroSelecionado != null) {
                    bombeiroSelecionado.setNome(txtNome.getText());
                    bombeiroSelecionado.setTelefone(txtTelefone.getText());
                    bombeiroSelecionado.setCpf(txtCpf.getText());
                    bombeiroSelecionado.setDataNascimento(txtData.getText());

                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setHeaderText("Cadastro atualizado com sucesso!");
                    alerta.show();
                }
                event.consume();
            }
        };
        btnAtualizar.addEventHandler(MouseEvent.MOUSE_CLICKED, ehAtualizar);

        root.getChildren().addAll(
                titulo,
                lblUsuario, txtUsuario, btnBuscar,
                lblNome, txtNome,
                lblTelefone, txtTelefone,
                lblCpf, txtCpf,
                lblData, txtData,
                btnAtualizar
        );

        stage.setScene(scene);
        stage.setTitle("Atualizar Cadastro");
        stage.show();
    }
}
