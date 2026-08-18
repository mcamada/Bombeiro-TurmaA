package ifc.ibirama.projeto_de_tela;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
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
            geral.getChildren().add(new Label("Nome Completo:"));
            geral.getChildren().add(new TextField("Anthony Martins"));
            geral.getChildren().add(new Label("Contato:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Label("Matrícula:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Label("CPF:"));
            geral.getChildren().add(new TextField(""));
            geral.getChildren().add(new Label("Data de Nascimento"));
            geral.getChildren().add(new TextField(""));
            
        Label label = new Label("Consulta de Bombeiros");
        
        var text = new Label("Usuários enontrados com o nome Anthony Martins:");
        
        var dadosPessoais1 = new Text("Anthony Martins; 47 991524958; 11111111; 134.622.136-67; 21/3/2010;");
        var equipe = new Label("Equipe atual:");
        var nome1 = new Label("¹Vinicius Martins");
        var nome2 = new Label("²Enzo Scottini");
        var nome3 = new Label("³Gregory Dolzan");
        
        var dadosPessoais2 = new Text("Anthony Martins; 47 927723888; 28877275; 727.856.918-78; 12/8/2000;");
        var equipe2 = new Label("Equipe atual:");
        var nome21 = new Label("¹Giovanni Costa");
        var nome22 = new Label("²Dalvana Jonas Pires");
        var nome23 = new Label("³Yuri Pinto");
        
        var dadosPessoais3 = new Text("Anthony Martins; 47 963747477; 34567889; 777.917.754-89; 1/8/1999;");
        var equipe3 = new Label("Equipe atual:");
        var nome31 = new Label("¹Nicole Mustchiaevsky");
        var nome32 = new Label("²Carlos Figo");
        var nome33 = new Label("³Adam Müller");        
        var vbox = new VBox();
        
        
        
        vbox.getChildren().addAll(equipe, nome1, nome2, nome3);
        
        ButtonBar botoes = new ButtonBar();
        
        Button cadastrar = new Button("Cadastrar");
        
        Button consultar = new Button("Consultar");
        
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
            @Override
        public void handle(MouseEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Este usuário já foi cadastrado. Caso queira achá-lo, excluí-lo ou atualizá-lo, culsulte-o");
            alert.show();

            event.consume();
            }
        };

        cadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        
        botoes.getButtons().addAll(consultar, cadastrar);
        
        root.getChildren().addAll(label, geral, botoes, dadosPessoais1, vbox);
        
        var scene = new Scene(root, 640, 480);
        scene.getStylesheets().add("/resoucers.css/style.css");
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch();
    }

}