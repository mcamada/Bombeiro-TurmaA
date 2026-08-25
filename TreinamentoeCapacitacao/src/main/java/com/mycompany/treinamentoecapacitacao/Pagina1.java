
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pagina1 {
public Scene getScene() {
VBox root = new VBox(20);
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("FLUXO PRINCIPAL");
titulo.setFont(Font.font("System", 24));

Button btnAvancar = new Button("Avançar -> Página 2");
btnAvancar.setOnAction(e -> App.mudarTela(new Pagina2().getScene()));

root.getChildren().addAll(titulo, btnAvancar);
return new Scene(root, 600, 550);
}
}
