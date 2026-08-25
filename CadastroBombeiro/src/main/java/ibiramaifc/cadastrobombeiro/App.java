/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibiramaifc.cadastrobombeiro;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class App extends Application {

    public static ArrayList<Bombeiro> listaBombeiros = new ArrayList<>();

    @Override
    public void start(Stage Cadastro) {

        VBox root = new VBox();

        Label titulo = new Label("SISTEMA DE BOMBEIROS");

        Button btCadastro = new Button("cadastrar bombeiro");
        Button btPesquisa = new Button("Pesquisar bombeiro");
        Button btAtualizar = new Button("atualizar bombeiro");

        ButtonBar painelBt = new ButtonBar();
        painelBt.getButtons().addAll(btCadastro, btPesquisa, btAtualizar);
        root.getChildren().add(painelBt);

        Scene scene = new Scene(root, 800, 600);
        Cadastro.setScene(scene);
        Cadastro.setTitle("Sistema de Teste do JavaFX");
        Cadastro.show();
    }
}
