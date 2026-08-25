package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Pagina9 {
public Scene getScene() {
VBox root = new VBox(20);
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text txt1 = new Text("DADOS VALIDADOS");
Text txt2 = new Text("ALTERAÇÕES SALVAS...\nMODIFICAÇÕES FORAM REGISTRADAS...");
Button btnSucesso = new Button("SUCESSO!");

btnSucesso.setOnAction(e -> App.mudarTela(new Pagina10().getScene()));

root.getChildren().addAll(txt1, txt2, btnSucesso);
return new Scene(root, 600, 550);
}
}
