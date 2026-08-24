package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

        @Override
    public void start(Stage stage) {

// -----------------------------------------------------------------------------------------------
// ---- Tela de Login ----------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------
        
        VBox login = new VBox(20);  
        login.setAlignment(Pos.CENTER);
        Scene scene = new Scene(login, 200, 300);

        Text tituloLogin = new Text("Login do Sistema");
//        titulo.setId(STYLESHEET_MODENA);
//      titulo.getStyleClass().add("titulo");
        login.getChildren().add(tituloLogin);

        GridPane campos = new GridPane();
        campos.setAlignment(Pos.CENTER);

        Label ldLogin = new Label("Login:");
        Label lbSenha = new Label("senha:");
        TextField tfLogin = new TextField();
        PasswordField pfSenha = new PasswordField();
        
        campos.add(ldLogin, 0, 0);
        campos.add(lbSenha, 0, 1);
        campos.add(tfLogin, 1, 0);       
        campos.add(pfSenha, 1, 1);

        login.getChildren().add(campos);


        HBox botoes1 = new HBox(5);
        botoes1.setAlignment(Pos.CENTER);

        
        Button logar = new Button("logar");
        Button sair = new Button("sair");
        botoes1.getChildren().addAll(logar, sair);

        login.getChildren().add(botoes1);


// -----------------------------------------------------------------------------------------------
// ---- Lista de Itens ---------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------


        VBox tela2 = new VBox(10);
        Scene scene2 = new Scene(tela2, 240, 440);
        tela2.setAlignment(Pos.CENTER);

        Text tituloItens = new Text("Lista de Itens");
        tituloItens.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        tela2.getChildren().add(tituloItens);

        GridPane infoPessoal = new GridPane();
        infoPessoal.setHgap(10);
        infoPessoal.setVgap(10);

        Font fontCampo = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12);

        Label pesquisar = new Label("Pesquisar:");

        pesquisar.setFont(fontCampo);
        TextField pesquisaCampo = new TextField();
        infoPessoal.add(pesquisar, 0, 0);
        infoPessoal.add(pesquisaCampo, 1, 0);


        tela2.getChildren().add(infoPessoal);

        ObservableList<String> opcoes = FXCollections.observableArrayList("Arquivo","Arquivo","Arquivo",
        "Arquivo","Arquivo","Arquivo","Arquivo","Arquivo","Arquivo","Arquivo","Arquivo","Arquivo",
        "Arquivo","Arquivo","Arquivo","Arquivo","Arquivo","Arquivo","Arquivo");

//        ObservableList<String> opcoes1 = FXCollections.observableArrayList("1","2","3","4","5","6"); //cria outra lista
//        ListView<String> listaOpcoesl = new ListView<>(opcoes1);
        ListView<String> listaOpcoes = new ListView<>(opcoes);
        tela2.getChildren().add(listaOpcoes);
//        tela1.getChildren().add(listaOpcoesl);

        HBox botoes = new HBox(5);


        Button botao2 = new Button("CADASTRAR");

        botoes.getChildren().addAll(botao2);

        HBox.setHgrow(botao2, Priority.ALWAYS);

        botao2.setMaxWidth(Double.MAX_VALUE);

        tela2.getChildren().add(botoes);

//-------------------------------------------------------------------------------------------------
//----- Lista de Opções ---------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

        VBox tela3 = new VBox(10);
        tela3.setAlignment(Pos.CENTER);
        Scene scene3 = new Scene(tela3, 240, 440);

        Text titulo3 = new Text("Opções");
        titulo3.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        tela3.getChildren().add(titulo3);

        VBox listaOpcoes2 = new VBox(10);
        listaOpcoes2.setAlignment(Pos.CENTER);

        Font Button = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 40);

        Button alterar = new Button(" ALTERAR ");
        Button consultar = new Button(" CONSULTAR ");
        Button excluir = new Button(" EXCLUIR ");
        Button voltar = new Button(" CANCELAR ");

       listaOpcoes2.getChildren().addAll(alterar,consultar,excluir,voltar);
       tela3.getChildren().addAll(listaOpcoes2);

//---- Passar para proxima tela clicando 2 vezes no item -----

        listaOpcoes.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2) {
        stage.setScene(scene3);
            }
        });

//-------------------------------------------------------------------------------------------------
//----- Cadastro de Item -----------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------
        
        VBox telaCadastro = new VBox(20); 
        telaCadastro.setAlignment(Pos.CENTER);
        Scene sceneCadastro = new Scene(telaCadastro, 240, 440);
        
        Label tituloCadastro = new Label("Cadastrar item");
        
        GridPane novoitemCrt = new GridPane();
        
        Label nomeCadastro = new Label("NOME :");
        Label categoriaCadastro = new Label("CATEGORIA :");
        Label qtdInicialCadastro = new Label("QNT. INICIAL :");
        Label undMedidaCadastro = new Label("UND. MEDIDA :");;
        Label locCadastro = new Label("LOCAL:");
        Label nvMinimoCadastro = new Label("NIVEL MIN. :");
        
     
        TextField nomeCampo = new TextField();
        TextField categoriaCampo = new TextField();
        TextField qtdInicialCampo = new TextField();
        TextField undMedidaCampo = new TextField();
        TextField locEstoqueCampo = new TextField();
        TextField nvMinimoCampo = new TextField();
        
        novoitemCrt.add(nomeCadastro, 0, 1);
        novoitemCrt.add(categoriaCadastro, 0, 2);
        novoitemCrt.add(qtdInicialCadastro, 0, 3);
        novoitemCrt.add(undMedidaCadastro, 0, 4);
        novoitemCrt.add(locCadastro, 0, 5);
        novoitemCrt.add(nvMinimoCadastro, 0, 6);
        
        novoitemCrt.add(nomeCampo, 1, 1);
        novoitemCrt.add(categoriaCampo, 1, 2);
        novoitemCrt.add(qtdInicialCampo,1, 3);
        novoitemCrt.add(undMedidaCampo, 1, 4);
        novoitemCrt.add(locEstoqueCampo, 1, 5);
        novoitemCrt.add(nvMinimoCampo, 1, 6);
        
        telaCadastro.getChildren().add(novoitemCrt);
        
//-------------------------------------------------------------------------------------------------
//----- Ação Cocluida -----------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

        VBox conclusao = new VBox(10);
        Scene sceneFinal = new Scene(conclusao,240,440);
        conclusao.setAlignment(Pos.CENTER);

        Label abc = new Label("Acao bem sucedida");

        Button voltarInicio = new Button("CONTINUAR");

        conclusao.getChildren().addAll(abc,voltarInicio);

//-------------------------------------------------------------------------------------------------
//----- ações dos botões --------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------


        excluir.setOnAction(event -> {
        stage.setScene(sceneFinal);
        });

        voltarInicio.setOnAction(event -> {
        stage.setScene(scene2);
        });

        logar.setOnAction(event -> {
        stage.setScene(scene2);
        });

        voltar.setOnAction(event -> {
        stage.setScene(scene2);
        });

//-------------------------------------------------------------------------------------------------
//----- inicialização -----------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Almoxarifado");
        
        stage.setScene(sceneCadastro);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
