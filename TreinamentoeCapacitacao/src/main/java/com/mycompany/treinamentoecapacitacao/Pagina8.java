
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pagina8 {
public Scene getScene() {
VBox root = new VBox(10);
root.setPadding(new Insets(15));
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("ALTERAR DADOS");
titulo.setFont(Font.font("System", 18));

TextField txtData = new TextField("12/08/2026");
TextField txtInstrutor = new TextField("Sgt. Oliveira");
TextField txtLocal = new TextField("Centro de Treinamento II");
TextField txtInstituicao = new TextField("Escola de Bombeiros");

Text tagInstrutor = new Text(" ALTERADO");
Text tagLocal = new Text(" ALTERADO");
Text tagInstituicao = new Text(" ALTERADO");
Text tagLista = new Text(" ALTERADO");
Text tagStatus = new Text(" ALTERADO");

tagInstrutor.setStyle("-fx-fill: brown; -fx-font-weight: bold;");
tagLocal.setStyle("-fx-fill: brown; -fx-font-weight: bold;");
tagInstituicao.setStyle("-fx-fill: brown; -fx-font-weight: bold;");
tagLista.setStyle("-fx-fill: brown; -fx-font-weight: bold;");
tagStatus.setStyle("-fx-fill: brown; -fx-font-weight: bold;");

HBox boxInstrutor = new HBox(5, new Text("INSTRUTOR:"), txtInstrutor, tagInstrutor);
HBox boxLista = new HBox(5, new Text("LISTA DE PARTICIPANTES:"), tagLista);
HBox boxStatus = new HBox(5, new Text("STATUS:"), tagStatus);
HBox boxLocal = new HBox(5, new Text("LOCAL:"), txtLocal, tagLocal);
HBox boxInst = new HBox(5, new Text("INSTITUIÇÃO:"), txtInstituicao, tagInstituicao);

Button btnConfirmar = new Button("CONFIRMAR");
Button btnCancelar = new Button("CANCELAR");

// Redireciona para a proxima tela ao clicar em CONFIRMAR
btnConfirmar.setOnAction(e -> App.mudarTela(new Pagina9().getScene()));

// Volta para a tela anterior ao clicar em CANCELAR
btnCancelar.setOnAction(e -> App.mudarTela(new Pagina7().getScene()));

HBox btns = new HBox(15, btnConfirmar, btnCancelar);
btns.setAlignment(Pos.CENTER);

root.getChildren().addAll(
titulo,
new Text("DATA:"), txtData,
boxInstrutor, boxLista, boxStatus, boxLocal, boxInst,
btns
);

return new Scene(new ScrollPane(root), 600, 550);
}
}
