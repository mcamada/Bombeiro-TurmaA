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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TelaPesquisa {

    public void iniciar() {

        Stage stage = new Stage();
        Pane root = new Pane();
        Scene scene = new Scene(root, 450, 350);

        Label titulo = new Label("Pesquisa de Cadastro");
        titulo.setLayoutX(100);
        titulo.setLayoutY(15);
        titulo.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        titulo.setTextFill(Color.web("#0D3B66"));

        Label lblUsuario = new Label("Nome de usuário:");
        lblUsuario.setLayoutX(20);
        lblUsuario.setLayoutY(70);

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("ex: joao123");
        txtUsuario.setLayoutX(170);
        txtUsuario.setLayoutY(65);
        txtUsuario.setPrefWidth(240);

        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setLayoutX(170);
        btnPesquisar.setLayoutY(105);
        btnPesquisar.setStyle("-fx-background-color: #1E88E5; -fx-text-fill: white; -fx-font-weight: bold;");

        Label resNome = new Label("Nome: ");
        resNome.setLayoutX(20);
        resNome.setLayoutY(160);

        Label resTelefone = new Label("Telefone: ");
        resTelefone.setLayoutX(20);
        resTelefone.setLayoutY(190);

        Label resCpf = new Label("CPF: ");
        resCpf.setLayoutX(20);
        resCpf.setLayoutY(220);

        Label resData = new Label("Data de nascimento: ");
        resData.setLayoutX(20);
        resData.setLayoutY(250);

        EventHandler<MouseEvent> ehPesquisar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String usuario = txtUsuario.getText();
                Bombeiro encontrado = BancoDados.buscarPorUsuario(usuario);

                if (encontrado == null) {
                    Alert alerta = new Alert(AlertType.ERROR);
                    alerta.setHeaderText("Nenhum cadastro encontrado para esse usuário!");
                    alerta.show();

                    resNome.setText("Nome: ");
                    resTelefone.setText("Telefone: ");
                    resCpf.setText("CPF: ");
                    resData.setText("Data de nascimento: ");
                } else {
                    resNome.setText("Nome: " + encontrado.getNome());
                    resTelefone.setText("Telefone: " + encontrado.getTelefone());
                    resCpf.setText("CPF: " + encontrado.getCpf());
                    resData.setText("Data de nascimento: " + encontrado.getDataNascimento());
                }
                event.consume();
            }
        };
        btnPesquisar.addEventHandler(MouseEvent.MOUSE_CLICKED, ehPesquisar);

        root.getChildren().addAll(
                titulo,
                lblUsuario, txtUsuario, btnPesquisar,
                resNome, resTelefone, resCpf, resData
        );

        stage.setScene(scene);
        stage.setTitle("Pesquisa de Cadastro");
        stage.show();
    }
}
