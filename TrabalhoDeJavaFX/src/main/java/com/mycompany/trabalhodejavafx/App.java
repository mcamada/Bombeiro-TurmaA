package com.mycompany.trabalhodejavafx;


import java.lang.reflect.Array;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        
        root.setAlignment(Pos.CENTER);

        Text titulo = new Text("Almoxarifado");
        titulo.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        root.getChildren().add(titulo);

        GridPane elementos = new GridPane();
        GridPane opcoes = new GridPane();

        opcoes.setVgap(20);
        opcoes.setAlignment(Pos.CENTER);

        Font Button = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 40);

        Button cadastrar = new Button("CADASTRAR");
        Button alterar = new Button("ALTERAR");
        Button consultar = new Button("CONSULTAR");
        Button excluir = new Button(" EXCLUIR ");
        
        
        cadastrar.setPrefWidth(150);
        cadastrar.setPrefHeight(40);
        alterar.setPrefWidth(150);
        alterar.setPrefHeight(40);
        consultar.setPrefWidth(150);
        consultar.setPrefHeight(40);
        excluir.setPrefWidth(150);
        excluir.setPrefHeight(40);
        
        opcoes.add(cadastrar,0,0);
        opcoes.add(alterar,0,1);
        opcoes.add(consultar,0,3);
        opcoes.add(excluir,0,4);

       elementos.add(titulo, 1, 0);
       elementos.add(opcoes,2,0);
        
       root.getChildren().add(opcoes);
       root.getChildren().add(elementos);


        Scene scene = new Scene(root, 340, 720);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

