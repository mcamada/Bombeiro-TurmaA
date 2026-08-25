package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Pagina18 {
public Scene getScene() {
VBox root = new VBox(20);
root.setPadding(new Insets(30));
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("PARTICIPANTE INVALIDO");
titulo.setFont(Font.font("System", FontWeight.BOLD, 16));

Text subTitulo = new Text("BOMBEIRO NÃO CADASTRADO OU INATIVO.");
subTitulo.setFont(Font.font("System", FontWeight.NORMAL, 13));

Text lblMensagem = new Text("NÃO É POSSÍVEL REALIZAR A INCLUSÃO");
lblMensagem.setFont(Font.font("System", FontWeight.NORMAL, 12));

Button btnInicio = new Button("VOLTAR AO INÍCIO");
btnInicio.setOnAction(e -> App.mudarTela(new Pagina12().getScene()));

root.getChildren().addAll(
titulo,
subTitulo,
lblMensagem,
btnInicio
);

return new Scene(root, 600, 600);
}
}