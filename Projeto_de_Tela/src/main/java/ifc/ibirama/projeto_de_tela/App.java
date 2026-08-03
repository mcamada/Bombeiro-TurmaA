package ifc.ibirama.trabalhobombeiros;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Feito por VineC4rr91 e Anthony - Vulgo Vinícius Martins e Anthony Txuli dos Santos Lemes Martins
 * Espero que esteja nota 10!
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        
        Text texto = new Text("Cadastro de Bombeiros");
        
        TilePane geral = new TilePane();
        
            geral.setHgap(10);
            geral.setVgap(10);
            geral.getChildren().add(new Text("teste"));
            geral.getChildren().add(new Text("teste"));
            geral.getChildren().add(new Text("teste"));
        
        
        root.getChildren().add(texto);
        
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add("/css/style.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}