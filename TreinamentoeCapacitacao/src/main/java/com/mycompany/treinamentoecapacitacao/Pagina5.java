
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Pagina5 {
public Scene getScene() {
VBox root = new VBox(15);
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("LISTA DE PARTICIPANTES:");
Text p1 = new Text("PARTICIPANTE 1");
Text p2 = new Text("PARTICIPANTE 2");
Text p3 = new Text("PARTICIPANTE 3");

Button btnPlanejado = new Button("PLANEJADO");
Button btnAndamento = new Button("EM ANDAMENTO..");
Button btnConcluido = new Button("CONCLUÍDO");

btnConcluido.setOnAction(e -> App.mudarTela(new Pagina6().getScene()));

root.getChildren().addAll(titulo, p1, p2, p3, new Text("STATUS:"), btnPlanejado, btnAndamento, btnConcluido);
return new Scene(root, 600, 550);
}
}