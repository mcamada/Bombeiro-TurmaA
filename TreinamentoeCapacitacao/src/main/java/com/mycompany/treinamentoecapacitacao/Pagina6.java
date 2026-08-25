/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Pagina6 {
public Scene getScene() {
VBox root = new VBox(20);
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text msg = new Text("CERTIFICAÇÕES EMITIDAS ✓");
Button btnAvancar = new Button("Ir para Atualização -> Página 7");
btnAvancar.setOnAction(e -> App.mudarTela(new Pagina7().getScene()));

root.getChildren().addAll(msg, btnAvancar);
return new Scene(root, 600, 550);
}
}
