package com.mycompany.bombeiroalmoxerifado;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox principal = new VBox();
        principal.setAlignment(Pos.TOP_CENTER);
        Text titulo = new Text("Bombeiros");
        Text Cadrasto = new Text("Cadrasto Item");
        VBox geral = new VBox();

        Text nome = new Text("Nome item");
        TextField TextoItem = new TextField();
        Text Categoria = new Text("Categoria");
        TextField TCategoria = new TextField();
        Text QInicial = new Text("Quantidade Inicial");
        TextField TQInicial = new TextField();
        Text UnidadeMedida = new Text("Unidade de medida");
        TextField TMedida = new TextField();
        Text Localizaçao = new Text("Localizaçao");
        TextField TLocalizaçao = new TextField();
        Text Minimo = new Text("Minimo");
        TextField TMinimo = new TextField();

        principal.getChildren().addAll(titulo, Cadrasto, geral);
        Button cadastrar = new Button("cadastrar");
        
        geral.getChildren().addAll(nome, TextoItem, Categoria, TCategoria, QInicial, TQInicial, UnidadeMedida, TMedida, Localizaçao, TLocalizaçao, Minimo, TMinimo);
        geral.getChildren().add(cadastrar);

        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setHeaderText("Cadrasto concluido");
                alerta.show();
                event.consume();
            }
        };

        cadastrar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        

        Button ConsultarItem = new Button("abrir janela do Consultar Item");
        Button atualizar = new Button("Abrir janela de atualizar");
        
        
        
        
        EventHandler<MouseEvent> jk = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {

                Stage janelaConsultarItem = new Stage();
                VBox CItem = new VBox();

                VBox toponome = new VBox();
                toponome.setAlignment(Pos.TOP_CENTER);
                Text Topo = new Text("Bombeiros");
                Text Nitem = new Text("Consultar Item");

                toponome.getChildren().add(Topo);
                toponome.getChildren().add(Nitem);
                CItem.getChildren().add(toponome);

                Text nome = new Text("nome");
                CItem.getChildren().add(nome);
                TextField pesquisar = new TextField("Pesquise o item aqui");
                CItem.getChildren().addAll(pesquisar);
                Text categoria = new Text("categoria");
                CItem.getChildren().add(categoria);
                TextField categoria2 = new TextField();
                CItem.getChildren().add(categoria2);
                Text Qinicial = new Text("Quantidade inicial");
                CItem.getChildren().add(Qinicial);
                TextField Qinicial2 = new TextField();
                CItem.getChildren().add(Qinicial2);
                Text Loc = new Text("Localizaçao");
                 CItem.getChildren().add(Loc);
                TextField loc = new TextField();
                 CItem.getChildren().add(loc);
                 
                Button pesquisa = new Button("pesquisar");
                Button excluir = new Button("excluir item");
                  Button fecharjanela = new Button("voltar ao cadrasto item");
                fecharjanela.setOnAction(event ->{
                    janelaConsultarItem.close();
                });
                
                EventHandler<MouseEvent> lp = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setHeaderText("pesquisa concluida");
                        alerta.show();
                        t.consume();
                    }
                };
                EventHandler<MouseEvent> hg = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setHeaderText("excluido com sucesso");
                        alerta.show();
                        t.consume();
                    }
                };


                CItem.getChildren().addAll(pesquisa);
               
                CItem.getChildren().add(excluir);
                 CItem.getChildren().add(fecharjanela);
                pesquisa.addEventHandler(MouseEvent.MOUSE_CLICKED, lp);
                excluir.addEventHandler(MouseEvent.MOUSE_CLICKED, hg);
                principal.getStyleClass().add("EstiloBombeiro");
               CItem.getStyleClass().add("estiloTextFild");
                toponome.getStyleClass().add("EstiloBombeiro");
                Scene scene = new Scene(CItem, 640, 640);
                scene.getStylesheets().add("css/EstiloBombeiro.css");
                janelaConsultarItem.setScene(scene);

                janelaConsultarItem.show();

            }
        };
        
        

        ConsultarItem.addEventHandler(MouseEvent.MOUSE_CLICKED, jk);

        geral.getChildren().add(ConsultarItem);
        
         EventHandler<MouseEvent> po = new EventHandler<MouseEvent>() {
           @Override 
           public void handle(MouseEvent p) {
            Stage atulizaçao = new Stage();
            VBox atlz = new VBox();
            VBox atualizar = new VBox();
            Text quantidade = new Text("Quantidade");
            TextField Quantidade = new TextField();
            Text localizaçao = new Text("Localizaçao");
            TextField localizacao2 = new TextField();
            Text Nivelminimo = new Text("Nivel minimo");
            TextField nivelminimo = new TextField();
            Text Descriçao = new Text("Descriçao");
            TextField descriçao = new TextField();
            atualizar.getChildren().addAll(quantidade,Quantidade,localizaçao,localizacao2,Nivelminimo,nivelminimo,Descriçao,descriçao);
            atlz.setAlignment(Pos.TOP_CENTER);
            Text Bombeiros = new Text("Bombeiros");
            Text Atulizaçoes = new Text("Atulizaçoes");
            atlz.getChildren().add(Bombeiros);
            atlz.getChildren().add(Atulizaçoes);
            atlz.getChildren().add(atualizar);
            Button comfirmar = new Button("comfirmar");   
            
             EventHandler<MouseEvent> wo = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setHeaderText("comfirmado com sucesso");
                        alerta.show();
                        t.consume();
                    }
                };
               comfirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, wo);
               atualizar.getChildren().add(comfirmar);
               Button fecharjanela = new Button("voltar ao cadrasto item");
                fecharjanela.setOnAction(event ->{
                    atulizaçao.close();
                });
               atualizar.getChildren().add(fecharjanela);
            Scene scene = new Scene(atlz, 640, 640);
            scene.getStylesheets().add("css/EstiloBombeiro.css");
             atlz.getStyleClass().add("EstiloBombeiro");
              atlz.getStyleClass().add("EstiloBombeiro");
                atualizar.getStyleClass().add("estiloTextFild");
            
            atulizaçao.setScene(scene);
           atulizaçao.show();
           }
         };
        atualizar.addEventHandler(MouseEvent.MOUSE_CLICKED, po);
         geral.getChildren().add(atualizar);
        Scene scene = new Scene(principal, 640, 640);
          scene.getStylesheets().add("css/EstiloBombeiro.css");
           principal.getStyleClass().add("EstiloBombeiro");
          geral.getStyleClass().add("estiloTextFild");
        stage.setScene(scene);

        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
