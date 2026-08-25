package ifc.ibirama.projeto_de_tela;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
  Feito por VineC4rr91 e Txuli - Vulgo Vinícius Martins e Anthony Txuli dos Santos Lemes Martins
  Espero que esteja nota 10!
 */

public class App extends Application {    
    @Override
    public void start(Stage stage) throws InterruptedException {
        VBox root = new VBox();
        root.getStyleClass().add("root");
        
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
            geral.getChildren().add(new DatePicker());
            
        Label label = new Label("Consulta de Bombeiros");
        label.getStyleClass().add("label");
        
        var text = new Label("Usuários enontrados com o nome Anthony Martins:");
        
        var tipo1 = new VBox();
        var tipo2 = new VBox();
        var tipo3 = new VBox();
        
        var dadosPessoais1 = new Text("Anthony Martins; 47 991524958; 11111111; 134.622.136-67; 21/3/2010;");
        var equipe1 = new Label("Equipe atual:");
        var nome1 = new Label("¹Vinicius Martins");
        var nome2 = new Label("²Enzo Scottini");
        var nome3 = new Label("³Gregory Dolzan");
        var bt1 = new ButtonBar();
        var atualizar1 = new Button("Atualizar");    
        var excluir1 = new Button("Excluir");
        
        var dadosPessoais2 = new Text("Anthony Martins; 47 927723888; 28877275; 727.856.918-78; 12/8/2000;");
        var equipe2 = new Label("Equipe atual:");
        var nome21 = new Label("¹Giovanni Costa");
        var nome22 = new Label("²Dalvana Jonas Pires");
        var nome23 = new Label("³Yuri Pinto");
        var bt2 = new ButtonBar();
        var atualizar2 = new Button("Atualizar");    
        var excluir2 = new Button("Excluir");
        
        var dadosPessoais3 = new Text("Anthony Martins; 47 963747477; 34567889; 777.917.754-89; 1/8/1999;");
        var equipe3 = new Label("Equipe atual:");
        var nome31 = new Label("¹Nicole Mustchiaevsky");
        var nome32 = new Label("²Carlos Figo");
        var nome33 = new Label("³Adam Müller");  
        var bt3 = new ButtonBar();
        var atualizar3 = new Button("Atualizar");    
        var excluir3 = new Button("Excluir");

        bt1.getButtons().addAll(atualizar1,excluir1);
        bt2.getButtons().addAll(atualizar2,excluir2);
        bt3.getButtons().addAll(atualizar3,excluir3);
        
        tipo1.getChildren().addAll(dadosPessoais1, equipe1, nome1, nome2, nome3);
        tipo2.getChildren().addAll(dadosPessoais2, equipe2, nome21, nome22, nome23);
        tipo3.getChildren().addAll(dadosPessoais3, equipe3, nome31, nome32, nome33);
        
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
        
        EventHandler<MouseEvent> eh2 = new EventHandler<MouseEvent>() {
            @Override
        public void handle(MouseEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Consultado com sucesso.");
            alert.show();

            event.consume();
            }
        };
        
        EventHandler<MouseEvent> eh3 = new EventHandler<MouseEvent>() {
            @Override
        public void handle(MouseEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Atualizado com sucesso.");
            alert.show();

            event.consume();
            }
        };
        
        EventHandler<MouseEvent> eh4 = new EventHandler<MouseEvent>() {
            @Override
        public void handle(MouseEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Exclusão bem sucedida.");
            alert.show();

            event.consume();
            }
        };
        
        atualizar1.getStyleClass().add("button");
            
        cadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        consultar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh2);
        atualizar1.addEventHandler(MouseEvent.MOUSE_CLICKED, eh3);
        atualizar2.addEventHandler(MouseEvent.MOUSE_CLICKED, eh3);
        atualizar3.addEventHandler(MouseEvent.MOUSE_CLICKED, eh3);
        excluir1.addEventHandler(MouseEvent.MOUSE_CLICKED, eh4);
        excluir2.addEventHandler(MouseEvent.MOUSE_CLICKED, eh4);
        excluir3.addEventHandler(MouseEvent.MOUSE_CLICKED, eh4);
        
        botoes.getButtons().addAll(consultar, cadastrar);
                
        var region = new Region();
        var regiom = new Region();
        regiom.setPrefHeight(50);
        region.setPrefHeight(35);
        root.getChildren().addAll(label, regiom, geral, botoes, text, region, tipo1, bt1, tipo2, bt2, tipo3, bt3);
        
        var scene = new Scene(root, 640, 555);
        scene.getStylesheets().add("/css/style.css");
        
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch();
    }

}