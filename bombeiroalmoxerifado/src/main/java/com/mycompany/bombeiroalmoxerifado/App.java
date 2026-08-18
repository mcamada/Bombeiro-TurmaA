package com.mycompany.bombeiroalmoxerifado;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox principal = new VBox();
        principal.setAlignment(Pos.TOP_CENTER);
        Text titulo = new Text("Bombeiros");
        Text Cadrasto = new Text("CadrastoItem");
        VBox geral = new VBox();
        
         
        Text nome = new Text("Nome item");
        TextField TextoItem = new TextField();
        Text Categoria = new Text("Categoria");
        TextField TCategoria = new TextField();
        Text QInicial = new Text("Quantidade Inicial");
        TextField TQInicial = new TextField();
        Text UnidadeMedida = new Text("Unidade de medida");
        TextField TMedida = new TextField();
        Text Localizaçao = new Text("Localizaçao");
        TextField TLocalizaçao = new TextField();
        Text Minimo = new Text("Minimo");
        TextField TMinimo = new TextField();
        
       principal.getChildren().addAll(titulo, Cadrasto , geral );
       geral.getChildren().addAll(nome, TextoItem , Categoria,TCategoria,QInicial,TQInicial,UnidadeMedida,TMedida,Localizaçao,TLocalizaçao,Minimo,TMinimo );
      
       
       
       Scene scene = new Scene(principal , 640 , 640 );
        stage.setScene(scene);
        stage.show();
        
       
    }

    public static void main(String[] args) {
        launch();
    }

}