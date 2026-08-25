package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Pagina15 {
public Scene getScene() {
VBox root = new VBox(15);
root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("TREINAMENTO EXTERNO SEM INSTITUIÇÃO");
titulo.setFont(Font.font("System", FontWeight.BOLD, 14));

Text subTitulo = new Text("SEU CADASTRO FOI BLOQUEADO");
subTitulo.setFont(Font.font("System", FontWeight.BOLD, 14));
subTitulo.setFill(Color.RED);

Text lblInstrucao = new Text("INFORME INFORMAÇÕES DA INSTITUIÇÃO RESPONSÁVEL.");
lblInstrucao.setFont(Font.font("System", FontWeight.NORMAL, 11));

TextField txtInstituicao = new TextField();
txtInstituicao.setMaxWidth(350);

// Botão para avançar para a Página 16 no fluxo de apresentação
Button btnProximo = new Button("Avançar -> Página 16");
btnProximo.setOnAction(e -> App.mudarTela(new Pagina16().getScene()));

root.getChildren().addAll(
titulo,
subTitulo,
lblInstrucao,
txtInstituicao,
btnProximo
);

return new Scene(root, 600, 600);
}
}