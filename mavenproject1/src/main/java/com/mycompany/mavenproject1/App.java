package com.mycompany.mavenproject1;

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

                GridPane infoPessoal = new GridPane();
        infoPessoal.setHgap(10);
        infoPessoal.setVgap(10);
        infoPessoal.setAlignment(Pos.CENTER);

        Font fontCampo = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12);

        Label pesquisar = new Label("Pesquisar:");
        
        pesquisar.setFont(fontCampo);
        TextField pesquisaCampo = new TextField();
        infoPessoal.add(pesquisar, 0, 0);
        infoPessoal.add(pesquisaCampo, 1, 0);


        root.getChildren().add(infoPessoal);

        ObservableList<String> opcoes = FXCollections.observableArrayList("Arquivo","huihuihui");
//        ObservableList<String> opcoes1 = FXCollections.observableArrayList("1","2","3","4","5","6"); cria outra lista
        ListView<String> listaOpcoes = new ListView<>(opcoes);
        root.getChildren().add(listaOpcoes);


        Button confirmar = new Button("Confirmar");
        Button cancelar = new Button("Cancelar");
//        Spinner<Integer> mes = new Spinner<>(1, 12, 1);

        ButtonBar botoes = new ButtonBar();
        botoes.getButtons().addAll(confirmar, cancelar);
        root.getChildren().addAll(botoes);
        
        Scene scene = new Scene(root, 940, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

