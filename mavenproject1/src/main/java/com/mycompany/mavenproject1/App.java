package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    class Ocorrencia {
        String tipo, status, data, hora, local, descricao;
        String equipe, viatura, prioridade;

        Ocorrencia(String tipo, String status, String data, String hora,
                   String local, String descricao, String equipe,
                   String viatura, String prioridade) {

            this.tipo = tipo;
            this.status = status;
            this.data = data;
            this.hora = hora;
            this.local = local;
            this.descricao = descricao;
            this.equipe = equipe;
            this.viatura = viatura;
            this.prioridade = prioridade;
        }
    }
    @Override
    public void start(Stage stage) {  

        });


        VBox tela = new VBox(
                15,
                new Label("CADASTRAR OCORRÊNCIA"),
                grid
        );

        tela.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(tela, 650, 450);

        stage.setTitle("Cadastro de Ocorrência");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
