package ifc.ibirama.projeto_de_tela;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    public void start(Stage stage) throws InterruptedException {
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
        
        ButtonBar botoes = new ButtonBar();
        
        Button cadastrar = new Button("Cadastrar");
        Button cancelar = new Button("Cancelar");
        
        botoes.getButtons().addAll(cadastrar, cancelar);
        
        root.getChildren().addAll(texto, geral, botoes);
        
        EventHandler<MouseEvent> naoCancelar = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Seu Login nao exite. Cadastre-se primeiro.");
            alert.show();
            
            event.consume();
            }
        };
        
        EventHandler<MouseEvent> testee = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText("Cadastrado.");
            alerta.show();
            
            var consultaBombeiros = new Scene(root, 640, 480);
            stage.setScene(consultaBombeiros);
            stage.show();
            event.consume();
            }
        };
        
        cadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, testee);
        cancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, naoCancelar);
        
        var scene = new Scene(root, 640, 480);
        scene.getStylesheets().add("/resoucers.css/style.css");
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch();
    }

}