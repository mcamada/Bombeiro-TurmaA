
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pagina7 {
public Scene getScene() {
VBox root = new VBox(8);
root.setPadding(new Insets(15));
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("ATUALIZAÇÃO DE TREINAMENTOS");
titulo.setFont(Font.font("System", 18));

TextField txtBusca = new TextField();
txtBusca.setPromptText("Digite para buscar...");

Text subDados = new Text("DADOS ATUAIS:");
subDados.setFont(Font.font("System", 14));

// Exibição dos dados já cadastrados
VBox dadosAtuais = new VBox(5,
new Text("NOME DO TREINAMENTO: Treinamento de Resgate"),
new Text("TIPO: INTERNO"),
new Text("DESCRIÇÃO: Treinamento prático de primeiros socorros"),
new Text("CARGA HORÁRIA: 40h"),
new Text("DATA INICIAL: 10/08/2026"),
new Text("DATA FINAL: 15/08/2026"),
new Text("INSTRUTOR RESPONSÁVEL: Sgt. Silva"),
new Text("INSTITUIÇÃO: -"),
new Text("LOCAL: Batalhão Central"),
new Text("ASSOCIAR BOMBEIROS PARTICIPANTES: 12 Selecionados")
);

Button btnAlterar = new Button("ALTERAR DADOS");
Button btnCancelar = new Button("CANCELAR");

btnAlterar.setOnAction(e -> App.mudarTela(new Pagina8().getScene()));
btnCancelar.setOnAction(e -> App.mudarTela(new Pagina4().getScene()));

HBox btns = new HBox(15, btnAlterar, btnCancelar);
btns.setAlignment(Pos.CENTER);

root.getChildren().addAll(
titulo,
new Text("SELECIONE UM TREINAMENTO:"),
txtBusca,
subDados,
dadosAtuais,
btns
);

return new Scene(new ScrollPane(root), 600, 550);
}
}