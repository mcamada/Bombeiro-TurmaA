package ifc.ibirama.projeto_de_tela;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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
        
        TilePane geral = new TilePane();
            
            geral.setHgap(100);
            geral.setVgap(1);
            
            geral.setTileAlignment(Pos.CENTER_LEFT);
            geral.getChildren().add(new Text("Nome Completo:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Text("Contato:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Text("Especialidade:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Text("Patente:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Text("Matrícula:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Text("Status:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Text("CPF:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Text("Data de Nascimento:"));
            geral.getChildren().add(new TextField(""));
            
        Text texto = new Text("Cadastro de Bombeiros");
        
        
        root.getChildren().add(texto);
        root.getChildren().add(geral);
        
        var scene = new Scene(root, 640, 480);
        scene.getStylesheets().add("/resoucers.css/style.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}