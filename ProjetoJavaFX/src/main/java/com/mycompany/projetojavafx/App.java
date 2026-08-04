package com.mycompany.projetojavafx;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        Menu file = new Menu();
        Menu view = new Menu();

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
