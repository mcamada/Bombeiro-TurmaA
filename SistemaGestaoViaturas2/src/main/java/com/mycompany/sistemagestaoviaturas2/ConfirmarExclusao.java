package com.mycompany.sistemagestaoviaturas2;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmarExclusao{

    private Viatura viatura;

    public ConfirmarExclusao(Viatura viatura){
        this.viatura=viatura;
    }

    public void start(Stage stage){

        VBox root=new VBox(10);
        root.setPadding(new Insets(10));

        Label titulo=new Label("Confirmar Exclusao");

        Label mensagem=new Label("Tem certeza que deseja excluir a viatura "+viatura.getPrefixo()+"?");

        HBox botoes=new HBox(10);

        Button cancelar=new Button("Cancelar");
        Button excluir=new Button("Excluir");

        cancelar.setOnAction(e->{
            stage.close();
        });

        excluir.setOnAction(e->{
            stage.close();
        });

        botoes.getChildren().addAll(cancelar,excluir);
        root.getChildren().addAll(titulo,mensagem,botoes);
        Scene scene=new Scene(root,500,200);
        
        stage.setScene(scene);
        stage.setTitle("Confirmar Exclusao");
        stage.show();
    }
}
