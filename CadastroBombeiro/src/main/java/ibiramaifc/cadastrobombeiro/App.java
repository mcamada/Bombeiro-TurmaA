/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibiramaifc.cadastrobombeiro;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class App extends Application {

    public static ArrayList<Bombeiro> listaBombeiros = new ArrayList<>();

    @Override
    public void start(Stage App) {

        HBox root = new HBox();

        Label titulo = new Label("SISTEMA DE BOMBEIROS");

        Button btCadastro = new Button("cadastrar bombeiro");
        Button btPesquisa = new Button("Pesquisar bombeiro");
        Button btAtualizar = new Button("atualizar bombeiro");
        Button btVoltar = new Button ("voltar");

        ButtonBar painelBt = new ButtonBar();
        painelBt.getButtons().addAll(btCadastro, btPesquisa, btAtualizar);
        root.getChildren().add(painelBt);

        EventHandler<MouseEvent> pesquisar = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HBox box = new HBox();
                Scene pesquisaScene = new Scene(box, 800, 600);
                App.setScene(pesquisaScene);
                App.setTitle("Pesquisa");
                App.show();
                box.setAlignment(Pos.CENTER);
                event.consume();
            }
        };
        btPesquisa.addEventHandler(MouseEvent.MOUSE_CLICKED, pesquisar);

        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 800, 600);
        App.setScene(scene);
        App.setTitle("Sistema de Teste do JavaFX");
        App.show();
    }
}
