package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox tela1 = new VBox(10);
        tela1.setAlignment(Pos.CENTER);
            
        Text titulo = new Text("Almoxarifado");
        titulo.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        tela1.getChildren().add(titulo);

        GridPane infoPessoal = new GridPane();
        infoPessoal.setHgap(10);
        infoPessoal.setVgap(10);
        infoPessoal.setAlignment(Pos.CENTER);

        Font fontCampo = Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12);

        Label pesquisar = new Label("Pesquisar:");
        
        pesquisar.setFont(fontCampo);
        TextField pesquisaCampo = new TextField();
        infoPessoal.add(pesquisar, 0, 0);
        infoPessoal.add(pesquisaCampo, 1, 0);


        tela1.getChildren().add(infoPessoal);

        ObservableList<String> opcoes = FXCollections.observableArrayList("Arquivo","huihuihui");
//        ObservableList<String> opcoes1 = FXCollections.observableArrayList("1","2","3","4","5","6"); //cria outra lista
//        ListView<String> listaOpcoesl = new ListView<>(opcoes1);
        ListView<String> listaOpcoes = new ListView<>(opcoes);
        tela1.getChildren().add(listaOpcoes);
//        tela1.getChildren().add(listaOpcoesl);
        
        
        Button confirmar = new Button("Confirmar");
        Button cancelar = new Button("Cancelar");
//        Spinner<Integer> mes = new Spinner<>(1, 12, 1);

        ButtonBar botoes = new ButtonBar();
        botoes.getButtons().addAll(confirmar, cancelar);
        tela1.getChildren().addAll(botoes);
        
        
        EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {
     
         Stage cadastro = new Stage();
         cadastro.initModality(Modality.APPLICATION_MODAL);
         VBox rootCadastro = new VBox();
         rootCadastro.getChildren().add(new Label("Teste"));
         Scene cenarioCadastro = new Scene(rootCadastro,940, 480);

        cadastro.setScene(cenarioCadastro);

        cadastro.showAndWait();
 }
 };     
        Scene telap = new Scene(tela1, 940, 480);
        stage.setScene(telap);
        confirmar.addEventHandler(MouseEvent.MOUSE_CLICKED, eh);
        stage.show( );
    }

}


//    @Override
//    public void start(Stage primaryStage) {
//        
//        // --- CONFIGURAÇÃO DA CENA 1 ---
//        Button botaoMudarParaTela2 = new Button("Ir para Tela 2");
//        VBox layout1 = new VBox(10, botaoMudarParaTela2);
//        Scene cena1 = new Scene(layout1, 400, 300);
//        
//        // --- CONFIGURAÇÃO DA CENA 2 ---
//        Button botaoVoltarParaTela1 = new Button("Voltar para Tela 1");
//        
//        VBox layout2 = new VBox(10, botaoVoltarParaTela1);
//        Scene cena2 = new Scene(layout2, 400, 300);
//
//        // --- TRATAMENTO DOS EVENTOS (EVENT HANDLE) ---
//        
//        // Evento do botão 1 usando Lambda do Java 8
//        botaoMudarParaTela2.setOnAction(event -> { primaryStage.setScene(cena2); // Define a segunda cena no palco principal
//        });
//
//        // Evento do botão 2 usando o objeto do evento para pegar o Stage (útil para classes separadas)
//        botaoVoltarParaTela1.setOnAction(event -> {
//            // Se você não tiver acesso direto à variável 'primaryStage', pegue o Stage assim:
//            Stage stageAtual = (Stage) ((Button) event.getSource()).getScene().getWindow();
//            stageAtual.setScene(cena1);
//        });
//
//        // --- EXIBIÇÃO INICIAL ---
//        primaryStage.setTitle("Troca de Cena Puro Java");
//        primaryStage.setScene(cena1); // Inicia na cena 1
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
