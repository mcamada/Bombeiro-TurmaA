package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Pagina17 {
public Scene getScene() {
VBox root = new VBox(20);
root.setPadding(new Insets(30));
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("EXCLUSÃO NÃO PERMITIDA");
titulo.setFont(Font.font("System", FontWeight.BOLD, 16));

Text subTitulo = new Text("TREINAMENTO COM CERTIFICADOS EMITIDOS");
subTitulo.setFont(Font.font("System", FontWeight.NORMAL, 13));

Text lblMensagem = new Text("NÃO É POSSÍVEL REALIZAR A EXCLUSÃO");
lblMensagem.setFont(Font.font("System", FontWeight.NORMAL, 12));

Text lblSugestao = new Text("SUGERIMOS INATIVAÇÃO!");
lblSugestao.setFont(Font.font("System", FontWeight.BOLD, 13));
lblSugestao.setFill(Color.RED);
lblSugestao.setStyle("-fx-background-color: #DDDDDD; -fx-padding: 6 12 6 12;");

Button btnInativar = new Button("INATIVAR");
Button btnCancelar = new Button("CANCELAR");

btnInativar.setOnAction(e -> App.mudarTela(new Pagina18().getScene()));
btnCancelar.setOnAction(e -> App.mudarTela(new Pagina16().getScene()));

HBox boxBotoes = new HBox(20, btnInativar, btnCancelar);
boxBotoes.setAlignment(Pos.CENTER);

root.getChildren().addAll(
titulo,
subTitulo,
lblMensagem,
lblSugestao,
boxBotoes
);

return new Scene(root, 600, 600);
}
}