package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Pagina16 {
public Scene getScene() {
VBox root = new VBox(15);
root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("EXCLUSÃO DE TREINAMENTO");
titulo.setFont(Font.font("System", FontWeight.BOLD, 16));

Text lblSelecione = new Text("SELECIONE UM TREINAMENTO:");
lblSelecione.setFont(Font.font("System", FontWeight.NORMAL, 12));

// Botões de Seleção de Treinamento
Button btnOpcao1 = new Button("T1");
Button btnOpcao2 = new Button("T2");
Button btnOpcao3 = new Button("T3");
HBox boxOpcoes = new HBox(10, btnOpcao1, btnOpcao2, btnOpcao3);
boxOpcoes.setAlignment(Pos.CENTER);

Text lblInstrucao = new Text("CLIQUE EM 'CONFIRMAR' PARA A EXCLUSÃO");
lblInstrucao.setStyle("-fx-background-color: #CCCCCC; -fx-padding: 5;");

Button btnConfirmar = new Button("CONFIRMAR");
Button btnCancelar = new Button("CANCELAR");
HBox boxAcoes = new HBox(15, btnConfirmar, btnCancelar);
boxAcoes.setAlignment(Pos.CENTER);

// Ação do Confirmar (Página 17 se não puder excluir ou retorno)
btnConfirmar.setOnAction(e -> App.mudarTela(new Pagina17().getScene()));
btnCancelar.setOnAction(e -> App.mudarTela(new Pagina12().getScene()));

root.getChildren().addAll(
titulo,
lblSelecione,
boxOpcoes,
lblInstrucao,
boxAcoes
);

return new Scene(root, 600, 600);
}
}