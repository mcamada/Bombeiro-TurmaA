package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Pagina14 {
public Scene getScene() {
VBox root = new VBox(8);
root.setPadding(new Insets(15));
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("CADASTRO DE TREINAMENTO");
titulo.setFont(Font.font("System", FontWeight.BOLD, 16));

TextField txtNome = new TextField();

RadioButton rbExterno = new RadioButton("EXTERNO");
RadioButton rbInterno = new RadioButton("INTERNO");
ToggleGroup groupTipo = new ToggleGroup();
rbExterno.setToggleGroup(groupTipo);
rbInterno.setToggleGroup(groupTipo);
rbExterno.setSelected(true); // Vem marcado como EXTERNO igual o protótipo
HBox boxTipo = new HBox(10, new Text("TIPO:"), rbExterno, rbInterno);

TextField txtDescricao = new TextField();
TextField txtCarga = new TextField();
TextField txtDataIni = new TextField();
TextField txtDataFim = new TextField();
TextField txtInstrutor = new TextField();

// Campo de Instituição com os asteriscos vermelhos de erro
TextField txtInst = new TextField();
Text errInst = new Text("******");
errInst.setFill(Color.RED);
errInst.setFont(Font.font("System", FontWeight.BOLD, 14));

VBox boxInst = new VBox(2, new Text("INSTITUIÇÃO (OBRIGADO SE EXTERNO):"), txtInst, errInst);

TextField txtLocal = new TextField();
TextField txtParticipantes = new TextField();

Button btnCadastrar = new Button("CADASTRAR");
Button btnCancelar = new Button("CANCELAR");

// Clicar em cadastrar leva direto para a Tela de Bloqueio (Página 15)
btnCadastrar.setOnAction(e -> App.mudarTela(new Pagina15().getScene()));
btnCancelar.setOnAction(e -> App.mudarTela(new Pagina13().getScene()));

HBox btns = new HBox(15, btnCadastrar, btnCancelar);
btns.setAlignment(Pos.CENTER);

root.getChildren().addAll(
titulo,
new Text("NOME DO TREINAMENTO:"), txtNome,
boxTipo,
new Text("DESCRIÇÃO:"), txtDescricao,
new Text("CARGA HORÁRIA:"), txtCarga,
new Text("DATA INICIAL:"), txtDataIni,
new Text("DATA FINAL:"), txtDataFim,
new Text("INSTRUTOR RESPONSÁVEL:"), txtInstrutor,
boxInst,
new Text("LOCAL:"), txtLocal,
new Text("ASSOCIAR BOMBEIROS PARTICIPANTES (OPCIONAL):"), txtParticipantes,
btns
);

return new Scene(new ScrollPane(root), 600, 600);
}
}
