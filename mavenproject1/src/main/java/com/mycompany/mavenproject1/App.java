package com.mycompany.mavenproject1;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
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
        Scene scene = new Scene(login, 400, 400);

        Label tituloLogin = new Label("Login do Sistema");
        tituloLogin.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

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
        Scene scene2 = new Scene(tela2, 400, 400);
        tela2.setAlignment(Pos.CENTER);

        Text tituloItens = new Text("Lista de Itens");
        tituloItens.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        tela2.getChildren().add(tituloItens);

//        GridPane infoPessoal = new GridPane();
//        infoPessoal.setHgap(10);
//        infoPessoal.setVgap(10);

        Font fontCampo = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12);

//        tela2.getChildren().add(infoPessoal);

        ObservableList<Item> opcoes = FXCollections.observableArrayList();
        ListView<Item> listaOpcoes = new ListView<>(opcoes);
        
        opcoes.add(new Item("Capacete", "EPI", 20, "Unidade", "Estante A1", 5)); 
        opcoes.add(new Item("Luva", "EPI", 50, "Par", "Estante A2", 10)); 
        opcoes.add(new Item("Mangueira", "Equipamento", 10, "Unidade", "Estante B1", 2)); 
        opcoes.add(new Item("Lanterna", "Equipamento", 15, "Unidade", "Estante B2", 3));

        tela2.getChildren().add(listaOpcoes);
//        tela1.getChildren().add(listaOpcoesl);

        HBox botoes = new HBox(5);
        botoes.setAlignment(Pos.CENTER);


        Button cadastrar = new Button("CADASTRAR");
        Button consultar = new Button("CONSULTAR");
        Button alterar = new Button("ALTERAR");
        Button excluir = new Button("EXCLUIR");
        botoes.getChildren().addAll(cadastrar,consultar,alterar,excluir);

        

        tela2.getChildren().add(botoes);

//-------------------------------------------------------------------------------------------------
//----- Cadastro de Item -----------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------
        
        VBox telaCadastro = new VBox(20); 
        telaCadastro.setAlignment(Pos.CENTER);
        Scene sceneCadastro = new Scene(telaCadastro, 400, 400);
        
        Text tituloCadastro = new Text("Cadastrar item");
        tituloCadastro.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

        
        GridPane novoitemCrt = new GridPane();
        novoitemCrt.setAlignment(Pos.CENTER);

        
        Label nomeCadastro = new Label("NOME :");
        Label categoriaCadastro = new Label("CATEGORIA :");
        Label qtdInicialCadastro = new Label("QUANTIDADE :");
        Label undMedidaCadastro = new Label("UND. MEDIDA :");
        Label locCadastro = new Label("LOCAL:");
        Label nvMinimoCadastro = new Label("NIVEL MIN. :");
        
     
        TextField nomeCampo = new TextField();
        TextField categoriaCampo = new TextField();
        Spinner<Integer> qtdInicialCampo = new Spinner<>(1,100,1,1);
        TextField undMedidaCampo = new TextField();
        TextField locEstoqueCampo = new TextField();
        Spinner<Integer> nvMinimoCampo = new Spinner<>(1,100,1,1);
        
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
        
        HBox butoes = new HBox(10);
        butoes.setAlignment(Pos.CENTER);
        Button continuarC = new Button("CADASTRAR");
        Button cancelarC = new Button("CANCELAR");
        
        butoes.getChildren().addAll(continuarC,cancelarC);
        
        telaCadastro.getChildren().addAll(tituloCadastro,novoitemCrt,butoes);
        
        
    // -----------------------------------------------------------------------------------------------
        // ---- Tela de Alteração ------------------------------------------------------------------------
        // -----------------------------------------------------------------------------------------------

        VBox telaAlterar = new VBox(20);
        telaAlterar.setAlignment(Pos.CENTER);
        Scene sceneAlterar = new Scene(telaAlterar, 400, 400);

        Text tituloAlterar = new Text("Alterar item");
        tituloAlterar.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

        GridPane gradeAlterar = new GridPane();
        gradeAlterar.setAlignment(Pos.CENTER);

        Label nomeAlterar = new Label("NOME:");
        Label categoriaAlterar = new Label("CATEGORIA:");
        Label qtdAlterar = new Label("QUANTIDADE:");
        Label unidadeAlterar = new Label("UND. MEDIDA:");
        Label localAlterar = new Label("LOCAL:");
        Label nivelAlterar = new Label("NIVEL MIN.:");

        TextField nomeCampoAlterar = new TextField();
        TextField categoriaCampoAlterar = new TextField();
        Spinner<Integer> qtdCampoAlterar = new Spinner<>(1,100,1,1);
        TextField unidadeCampoAlterar = new TextField();
        TextField localCampoAlterar = new TextField();
        Spinner<Integer> nivelCampoAlterar = new Spinner<>(1,100,1,1);

        gradeAlterar.add(nomeAlterar, 0, 0);
        gradeAlterar.add(categoriaAlterar, 0, 1);
        gradeAlterar.add(qtdAlterar, 0, 2);
        gradeAlterar.add(unidadeAlterar, 0, 3);
        gradeAlterar.add(localAlterar, 0, 4);
        gradeAlterar.add(nivelAlterar, 0, 5);

        gradeAlterar.add(nomeCampoAlterar, 1, 0);
        gradeAlterar.add(categoriaCampoAlterar, 1, 1);
        gradeAlterar.add(qtdCampoAlterar, 1, 2);
        gradeAlterar.add(unidadeCampoAlterar, 1, 3);
        gradeAlterar.add(localCampoAlterar, 1, 4);
        gradeAlterar.add(nivelCampoAlterar, 1, 5);

        HBox botoesAlterar = new HBox(10);
        botoesAlterar.setAlignment(Pos.CENTER);

        Button salvarAlteracao = new Button("SALVAR");
        Button cancelarAlteracao = new Button("CANCELAR");

        botoesAlterar.getChildren().addAll(salvarAlteracao, cancelarAlteracao);
        telaAlterar.getChildren().addAll(tituloAlterar, gradeAlterar, botoesAlterar);

  
//-------------------------------------------------------------------------------------------------
//----- Consultar ---------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------
        

            VBox consulta = new VBox(20);
        consulta.setAlignment(Pos.CENTER);
        Scene sceneCon = new Scene(consulta, 400, 400);
        
        Text tituloConsultar = new Text("Consultar item");
        tituloConsultar.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

        GridPane gradeCon = new GridPane();
        gradeCon.setAlignment(Pos.CENTER);

        Label nomeCon = new Label("NOME :");
        Label categoriaCon = new Label("CATEGORIA :");
        Label qtdInicialCon = new Label("QUANTIDADE :");
        Label undMedidaCon = new Label("UND. MEDIDA :");
        Label locCon = new Label("LOCAL:");
        
        TextField nomeCampoCon = new TextField();
        TextField categoriaCampoCon = new TextField();
        Spinner<Integer> qtdInicialCampoCon = new Spinner<>(1,100,1,1);
        TextField undMedidaCampoCon = new TextField();
        TextField locEstoqueCampoCon = new TextField();
        
        gradeCon.add(nomeCon, 0, 1);
        gradeCon.add(categoriaCon, 0, 2);
        gradeCon.add(qtdInicialCon, 0, 3);
        gradeCon.add(undMedidaCon, 0, 4);
        gradeCon.add(locCon, 0, 5);
        
        gradeCon.add(nomeCampoCon, 1, 1);
        gradeCon.add(categoriaCampoCon, 1, 2);
        gradeCon.add(qtdInicialCampoCon,1, 3);
        gradeCon.add(undMedidaCampoCon, 1, 4);
        gradeCon.add(locEstoqueCampoCon, 1, 5);
        
        Button voltarCon= new Button("VOLTAR");
        voltarCon.setAlignment(Pos.CENTER);

       
        consulta.getChildren().addAll(tituloConsultar,gradeCon,voltarCon);

//-------------------------------------------------------------------------------------------------
//----- Ação Cocluida -----------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

        VBox conclusao = new VBox(10);
        Scene sceneFinal = new Scene(conclusao,400,400);
        conclusao.setAlignment(Pos.CENTER);

        Label abc = new Label("Ação Concluida");
        abc.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));


        Button voltarInicio = new Button("CONTINUAR");

        conclusao.getChildren().addAll(abc,voltarInicio);

//-------------------------------------------------------------------------------------------------
//----- ações dos botões --------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

// ---- Na tela de login ---------------------

        logar.setOnAction(event -> {
            if (!tfLogin.getText().equals("adm") || !pfSenha.getText().equals("123")) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setContentText("Senha ou Login incorretos");
                alerta.showAndWait();

                return;
            }else{
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText(null);
                alerta.setContentText("Bem vindo ao Almoxarifado dos Bombeiros");
                alerta.showAndWait();            
            
            };
//    tfLogin
//                pfSenha                

  
            
        stage.setScene(scene2);
        });

        
        
// ---- Na tela de alteracao ---------------------
        
        salvarAlteracao.setOnAction(event -> {
        
            
            
       
        stage.setScene(sceneFinal);
        
        
        });
        
        cancelarAlteracao.setOnAction(event -> {
        stage.setScene(scene2);
        });
        
        
// ---- Na tela de consulta ---------------------


        voltarCon.setOnAction(event -> {
            stage.setScene(scene2);
        });
        
        
        
// ---- Na tela de cadastro ---------------------
        
        continuarC.setOnAction(event -> {
            
        if (nomeCampo.getText().equals("") || categoriaCampo.getText().equals("") || 
            undMedidaCampo.getText().equals("") || locEstoqueCampo.getText().equals("")){

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campos Obrigatórios");
            alerta.setHeaderText(null);
            alerta.setContentText("O MEU FIOTE, TEM Q PREENCHER ISSO AI!!!!!!!!!");

            alerta.showAndWait();

            return;
            }
        
        Item novoItem = new Item(
            nomeCampo.getText(),categoriaCampo.getText(),qtdInicialCampo.getValue(),
            undMedidaCampo.getText(),locEstoqueCampo.getText(),
            nvMinimoCampo.getValue()
        );
        
        opcoes.add(novoItem);

        
        stage.setScene(sceneFinal);
        });
        
        cancelarC.setOnAction(event -> {
        stage.setScene(scene2);
        });
        
        
// ---- Na tela final ---------------------

        voltarInicio.setOnAction(event -> {        
        stage.setScene(scene2);
        });
        
        
        
        
// ---- Na tela da lista de itens ---------------------

        cadastrar.setOnAction(event -> {
            
        nomeCampoCon.clear();
        categoriaCampoCon.clear();
        undMedidaCampoCon.clear();
        locEstoqueCampoCon.clear();
            
        stage.setScene(sceneCadastro);
        });
        
        excluir.setOnAction(event -> {

            Item itemSelecionado =  listaOpcoes.getSelectionModel().getSelectedItem();

            if (itemSelecionado == null) {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Nenhum item selecionado");
                alerta.setHeaderText(null);
                alerta.setContentText("Selecione um item para excluir.");
                alerta.showAndWait();

                return;
            }else{
                    opcoes.remove(itemSelecionado);

                    Alert excluido = new Alert(Alert.AlertType.WARNING);

                    excluido.setTitle("Item excluído");
                    excluido.setHeaderText(null);
                    excluido.setContentText("Item excluído com sucesso.");
                    excluido.showAndWait();
               }
        });

        
        alterar.setOnAction(event -> {
        Item itemSelecionado =  listaOpcoes.getSelectionModel().getSelectedItem();
        
          if (itemSelecionado == null) {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Nenhum item selecionado");
                alerta.setHeaderText(null);
                alerta.setContentText("Selecione um item para alterar.");
                alerta.showAndWait();

                return;
            }


        nomeCampoAlterar.setText(itemSelecionado.getNome());
        categoriaCampoAlterar.setText(itemSelecionado.getCategoria());
        qtdCampoAlterar.getValueFactory().setValue(itemSelecionado.getQuantidade());
        unidadeCampoAlterar.setText(itemSelecionado.getUnidadeMedida());
        localCampoAlterar.setText(itemSelecionado.getLocal());
        nivelCampoAlterar.getValueFactory().setValue(itemSelecionado.getNivelMinimo());

            
        stage.setScene(sceneAlterar);
            
        });
        
        consultar.setOnAction(event -> {
        
        nomeCampo.clear();
        categoriaCampo.clear();
        undMedidaCampo.clear();
        locEstoqueCampo.clear();
        
        stage.setScene(sceneCon);
        });
        


//-------------------------------------------------------------------------------------------------
//----- inicialização -----------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------

        scene.getStylesheets().add("/css/style.css");
        stage.setTitle("Almoxarifado");
        
        stage.setScene(scene);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}


