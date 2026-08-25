
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Pagina2 {
public Scene getScene() {
VBox root = new VBox(10);
root.setPadding(new Insets(20));
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("CADASTRO DE TREINAMENTO");

TextField txtNome = new TextField();
RadioButton rbExterno = new RadioButton("EXTERNO");
RadioButton rbInterno = new RadioButton("INTERNO");
ToggleGroup tgTipo = new ToggleGroup();
rbExterno.setToggleGroup(tgTipo);
rbInterno.setToggleGroup(tgTipo);

TextArea txtDescricao = new TextArea();
TextField txtCarga = new TextField();
TextField txtDataIni = new TextField();
TextField txtDataFim = new TextField();
TextField txtInstrutor = new TextField();
TextField txtInstituicao = new TextField();
TextField txtLocal = new TextField();
TextField txtBombeiros = new TextField();

Button btnCadastrar = new Button("CADASTRAR");
Button btnCancelar = new Button("CANCELAR");

btnCadastrar.setOnAction(e -> App.mudarTela(new Pagina3().getScene()));
btnCancelar.setOnAction(e -> App.mudarTela(new Pagina1().getScene()));

HBox btns = new HBox(10, btnCadastrar, btnCancelar);
btns.setAlignment(Pos.CENTER);

root.getChildren().addAll(
titulo, new Text("NOME DO TREINAMENTO:"), txtNome,
new HBox(10, rbExterno, rbInterno),
new Text("DESCRIÇÃO:"), txtDescricao,
new Text("CARGA HORÁRIA:"), txtCarga,
new Text("DATA INICIAL:"), txtDataIni,
new Text("DATA FINAL:"), txtDataFim,
new Text("INSTRUTOR RESPONSÁVEL:"), txtInstrutor,
new Text("INSTITUIÇÃO (OBRIGADO SE EXTERNO):"), txtInstituicao,
new Text("LOCAL:"), txtLocal,
new Text("ASSOCIAR BOMBEIROS PARTICIPANTES:"), txtBombeiros,
btns
);

return new Scene(new ScrollPane(root), 600, 550);
}
}