package com.mycompany.treinamentoecapacitacao;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

private static Stage stagePrincipal;

@Override
public void start(Stage stage) {
stagePrincipal = stage;
stagePrincipal.setTitle("Sistema de Gestão de Treinamentos");


// Abre na Página 1 do Canva
mudarTela(new Pagina1().getScene());
stagePrincipal.show();
}

public static void mudarTela(javafx.scene.Scene novaCena) {
stagePrincipal.setScene(novaCena);
}

public static void main(String[] args) {
launch();
}
}


