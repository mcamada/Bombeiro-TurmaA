/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibiramaifc.cadastrobombeiro;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author aluno
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.iniciar(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
