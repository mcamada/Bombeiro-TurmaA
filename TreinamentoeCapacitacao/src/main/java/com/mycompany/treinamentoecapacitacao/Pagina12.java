package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pagina12 {
public Scene getScene() {
VBox root = new VBox(8);
root.setPadding(new Insets(15));
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("CADASTRO DE TREINAMENTO");
titulo.setFont(Font.font("System", 18));

TextField txtNome = new TextField();

RadioButton rbExterno = new RadioButton("EXTERNO");
RadioButton rbInterno = new RadioButton("INTERNO");
ToggleGroup groupTipo = new ToggleGroup();
rbExterno.setToggleGroup(groupTipo);
rbInterno.setToggleGroup(groupTipo);
HBox boxTipo = new HBox(10, new Text("TIPO:"), rbExterno, rbInterno);

TextField txtDescricao = new TextField();

// Carga Horária
TextField txtCarga = new TextField("ABC");
Text errCarga = new Text("FORMATO INVÁLIDO");
errCarga.setStyle("-fx-fill: red; -fx-font-weight: bold;");
HBox boxCarga = new HBox(5, new Text("CARGA HORÁRIA:"), txtCarga, errCarga);

TextField txtDataIni = new TextField();
TextField txtDataFim = new TextField();
TextField txtInstrutor = new TextField();
TextField txtInst = new TextField();

// Local
TextField txtLocal = new TextField();
Text errLocal = new Text("NÃO PREENCHIDO");
errLocal.setStyle("-fx-fill: red; -fx-font-weight: bold;");
HBox boxLocal = new HBox(5, new Text("LOCAL:"), txtLocal, errLocal);

TextField txtParticipantes = new TextField();

Button btnCadastrar = new Button("CADASTRAR");
Button btnCancelar = new Button("CANCELAR");

Text lblAviso = new Text("DADOS INVÁLIDOS NO CADASTRO");
lblAviso.setStyle("-fx-fill: red; -fx-font-weight: bold;");
lblAviso.setVisible(false);

// LÓGICA DOS FLUXOS ALTERNATIVOS
btnCadastrar.setOnAction(e -> {
// Fluxo Alternativo 1: Treinamento Externo Sem Instituição (Página 15)
if (rbExterno.isSelected() && txtInst.getText().trim().isEmpty()) {
App.mudarTela(new Pagina15().getScene());
return;
}

// Fluxo Alternativo 2: Dados Inválidos / Formato / Campos Vazios (Página 13)
if (txtCarga.getText().matches(".*[a-zA-Z].*") || txtLocal.getText().trim().isEmpty()) {
lblAviso.setVisible(true);
App.mudarTela(new Pagina13().getScene());
return;
}

// Fluxo Alternativo 3: Participante Inválido (Página 18)
if (txtParticipantes.getText().equalsIgnoreCase("invalido")) {
App.mudarTela(new Pagina18().getScene());
return;
}

// Se tudo estiver certo, avança para a próxima página do fluxo principal
App.mudarTela(new Pagina14().getScene());
});

btnCancelar.setOnAction(e -> App.mudarTela(new Pagina1().getScene()));

HBox btns = new HBox(15, btnCadastrar, btnCancelar);
btns.setAlignment(Pos.CENTER);

root.getChildren().addAll(
titulo,
new Text("NOME DO TREINAMENTO:"), txtNome,
boxTipo,
new Text("DESCRIÇÃO:"), txtDescricao,
boxCarga,
new Text("DATA INICIAL:"), txtDataIni,
new Text("DATA FINAL:"), txtDataFim,
new Text("INSTRUTOR RESPONSÁVEL:"), txtInstrutor,
new Text("INSTITUIÇÃO (OBRIGADO SE EXTERNO):"), txtInst,
boxLocal,
new Text("ASSOCIAR BOMBEIROS PARTICIPANTES (OPCIONAL):"), txtParticipantes,
btns,
lblAviso
);

return new Scene(new ScrollPane(root), 600, 600);
}
}