package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pagina11 {
public Scene getScene() {
VBox root = new VBox(20);
root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("FLUXOS ALTERNATIVOS");
titulo.setFont(Font.font("System", 22));

Button btnAvancar = new Button("IR PARA CADASTRO (COM ERROS)");
btnAvancar.setOnAction(e -> App.mudarTela(new Pagina12().getScene()));

root.getChildren().addAll(titulo, btnAvancar);

return new Scene(new ScrollPane(root), 600, 550);
}
}