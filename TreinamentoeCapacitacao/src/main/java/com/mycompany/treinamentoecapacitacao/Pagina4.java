
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pagina4 {
public Scene getScene() {
VBox root = new VBox(10);
root.setPadding(new Insets(15));
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("CONSULTA DE TREINAMENTOS");
titulo.setFont(Font.font("System", 18));

TextField txtNome = new TextField();

// Seleção de Tipo
RadioButton rbExterno = new RadioButton("EXTERNO");
RadioButton rbInterno = new RadioButton("INTERNO");
ToggleGroup groupTipo = new ToggleGroup();
rbExterno.setToggleGroup(groupTipo);
rbInterno.setToggleGroup(groupTipo);
HBox boxTipo = new HBox(10, new Text("TIPO:"), rbExterno, rbInterno);

TextField txtPeriodo = new TextField();
TextField txtInstrutor = new TextField();
TextField txtCriterios = new TextField();

VBox lista = new VBox(5,
new Hyperlink("TREINAMENTO 1"),
new Hyperlink("TREINAMENTO 2"),
new Hyperlink("TREINAMENTO 3")
);

Button btnDetalhes = new Button("VER DETALHES DO TREINAMENTO 2");
btnDetalhes.setOnAction(e -> App.mudarTela(new Pagina5().getScene()));

root.getChildren().addAll(
titulo,
new Text("NOME:"), txtNome,
boxTipo,
new Text("PERÍODO:"), txtPeriodo,
new Text("INSTRUTOR:"), txtInstrutor,
new Text("DEFINIR CRITÉRIOS (OPCIONAL):"), txtCriterios,
new Text("LISTA DE TREINAMENTOS:"), lista,
btnDetalhes
);

return new Scene(new ScrollPane(root), 600, 550);
}
}
