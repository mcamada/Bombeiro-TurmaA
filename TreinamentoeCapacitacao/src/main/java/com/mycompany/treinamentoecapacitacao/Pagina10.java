
package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Pagina10 {
public Scene getScene() {
VBox root = new VBox(12);
root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("EXCLUSÃO DE TREINAMENTO");
titulo.setFont(Font.font("System", 18));

Text lblSelecao = new Text("SELECIONE UM TREINAMENTO:");

Button btnT1 = new Button("TREINAMENTO 1");
Button btnT2 = new Button("TREINAMENTO 2");
Button btnT3 = new Button("TREINAMENTO 3");

HBox boxTreinamentos = new HBox(10, btnT1, btnT2, btnT3);
boxTreinamentos.setAlignment(Pos.CENTER);

Text lblInstrucao = new Text("CLIQUE EM 'CONFIRMAR' PARA A EXCLUSÃO");
lblInstrucao.setVisible(false);

Button btnConfirmar = new Button("CONFIRMAR");
Button btnCancelar = new Button("CANCELAR");

HBox btns = new HBox(15, btnConfirmar, btnCancelar);
btns.setAlignment(Pos.CENTER);

Text lblResultado = new Text("REGISTRO REMOVIDO...\nOPERAÇÃO REGISTRADA...");
lblResultado.setStyle("-fx-fill: gray; -fx-text-alignment: center;");
lblResultado.setVisible(false);

Button btnSucesso = new Button("SUCESSO!");
btnSucesso.setStyle("-fx-background-color: #888; -fx-text-fill: white;");
btnSucesso.setVisible(false);

// Seleção do treinamento
btnT1.setOnAction(e -> lblInstrucao.setVisible(true));
btnT2.setOnAction(e -> lblInstrucao.setVisible(true));
btnT3.setOnAction(e -> lblInstrucao.setVisible(true));

// Ao confirmar, mostra as mensagens de remoção e o botão de sucesso
btnConfirmar.setOnAction(e -> {
lblResultado.setVisible(true);
btnSucesso.setVisible(true);
});

// Ao clicar em SUCESSO!, avança/retorna para a consulta de treinamentos (pagina4)
btnSucesso.setOnAction(e -> App.mudarTela(new Pagina11().getScene()));

// Botão cancelar retorna para a pagina4
btnCancelar.setOnAction(e -> App.mudarTela(new Pagina4().getScene()));

root.getChildren().addAll(
titulo, lblSelecao, boxTreinamentos,
lblInstrucao, btns, lblResultado, btnSucesso
);

return new Scene(new ScrollPane(root), 600, 550);
}
}
