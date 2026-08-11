package com.mycompany.treinamentoecapacitacao;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * andri e leticia, info25A
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        TilePane caixas = new TilePane();

        caixas.setHgap(100);
        caixas.setVgap(1);

        root.setAlignment(Pos.CENTER_LEFT);
        caixas.getChildren().add(new Text("Nome do Treinamento"));

        VBox botoes = new VBox();

        botoes.getChildren().add(new Text("Tipo:"));
        botoes.getChildren().add(new Button("Interno"));
        botoes.getChildren().add(new Button("Externo"));

        caixas.getChildren().add(new Text("Descrição:"));

        VBox btss = new VBox();

        btss.getChildren().add(new Text("Carga Horária:"));
        btss.getChildren().add(new Button("Data Inicial:"));
        btss.getChildren().add(new Button("Data Final:"));

        caixas.getChildren().add(new Text("Instrutor Responsável:"));
        caixas.getChildren().add(new Text("Instituição (obrigado se externo):"));
        caixas.getChildren().add(new Text("Local:"));
        caixas.getChildren().add(new Text("Associar bombeiros participantes (opcional):"));

        VBox botoess = new VBox();

        botoess.getChildren().add(new Button("Cadastrar"));
        botoess.getChildren().add(new Button("Cancelar"));

        Text texto = new Text("Cadastro de Treinamento");
        root.getChildren().addAll(caixas);
        caixas.getChildren().addAll(botoes, btss, botoess);

        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
