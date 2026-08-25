
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Pagina3 {
public Scene getScene() {
VBox root = new VBox(20);
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text msg1 = new Text("DADOS VALIDADOS..");
Text msg2 = new Text("TREINAMENTO REGISTRADO");
Button btnSucesso = new Button("SUCESSO!");
Button btnConsultar = new Button("CONSULTAR TREINAMENTOS");

btnConsultar.setOnAction(e -> App.mudarTela(new Pagina4().getScene()));

root.getChildren().addAll(msg1, msg2, btnSucesso, btnConsultar);
return new Scene(root, 600, 550);
}
}
