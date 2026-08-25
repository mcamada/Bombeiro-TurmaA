package com.mycompany.treinamentoecapacitacao;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Pagina13 {
public Scene getScene() {
VBox root = new VBox(15);
root.setPadding(new Insets(20));
root.setAlignment(Pos.CENTER);
root.setStyle("-fx-background-color: #EAEAEA;");

Text titulo = new Text("DADOS INVÁLIDOS NO CADASTRO");
titulo.setFont(Font.font("System", FontWeight.BOLD, 16));

Text subTitulo = new Text("O SISTEMA IDENTIFICA INCONSISTÊNCIAS");
subTitulo.setFont(Font.font("System", FontWeight.NORMAL, 14));

Text lblCampos = new Text("CAMPOS OBRIGATÓRIOS NÃO PREENCHIDOS, FORMATOS INVÁLIDOS");
lblCampos.setFont(Font.font("System", FontWeight.BOLD, 12));
lblCampos.setFill(Color.RED);

Text lblDatasInconsistentes = new Text("DATAS INCONSISTENTES");
lblDatasInconsistentes.setFont(Font.font("System", FontWeight.NORMAL, 14));

Text lblDataErro = new Text("DATA FIM ANTERIOR A DATA INÍCIO");
lblDataErro.setFont(Font.font("System", FontWeight.BOLD, 12));
lblDataErro.setFill(Color.RED);

// BOTÃO APONTANDO PARA A PRÓXIMA PÁGINA (PÁGINA 14)
Button btnProximo = new Button("Ver Próximo Erro -> Página 14");
btnProximo.setOnAction(e -> App.mudarTela(new Pagina14().getScene()));

root.getChildren().addAll(
titulo,
subTitulo,
lblCampos,
lblDatasInconsistentes,
lblDataErro,
btnProximo
);

return new Scene(root, 600, 600);
}
}