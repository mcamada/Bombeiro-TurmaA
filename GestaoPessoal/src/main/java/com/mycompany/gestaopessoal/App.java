package com.mycompany.gestaopessoal;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        ConsultarBombeiros tela = new ConsultarBombeiros();

        tela.mostrar(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}