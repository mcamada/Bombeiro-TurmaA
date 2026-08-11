package ibiramaifc.cadastrobombeiro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX Atualização
 */
public class Atualizacao extends Application {

    @Override
    public void start(Stage stage) {
        
        StackPane root = new StackPane();
        Label titulo = new Label ("Atualizar");
        root.getChildren().add(titulo);
        
        var scene = new Scene(new StackPane(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}