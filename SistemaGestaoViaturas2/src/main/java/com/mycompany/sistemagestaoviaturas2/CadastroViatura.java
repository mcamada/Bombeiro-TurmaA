package com.mycompany.sistemagestaoviaturas2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadastroViatura {

    private Viatura viatura;

    public CadastroViatura(){
        viatura=null;
    }

    public CadastroViatura(Viatura viatura){
        this.viatura=viatura;
    }

    public void start(Stage stage){

        VBox root=new VBox(10);
        root.setPadding(new Insets(10));

        Label titulo=new Label(viatura==null?"Cadastrar Viatura":"Editar Viatura");
        titulo.setMaxWidth(Double.MAX_VALUE);
        titulo.setAlignment(Pos.CENTER);

        GridPane formulario=new GridPane();
        formulario.setHgap(20);
        formulario.setVgap(10);
        formulario.setAlignment(Pos.CENTER);

        Label prefixo=new Label("Prefixo");
        TextField txtPrefixo=new TextField();
        txtPrefixo.setPromptText("Ex: VT-01");

        Label tipo=new Label("Tipo");
        ComboBox<String> cbTipo=new ComboBox<>();
        cbTipo.getItems().addAll("Combate a Incendio","Resgate","Ambulancia");
        cbTipo.setValue("Combate a Incendio");

        Label placa=new Label("Placa");
        TextField txtPlaca=new TextField();
        txtPlaca.setPromptText("AAA-1234");

        Label ano=new Label("Ano");
        ComboBox<String> cbAno=new ComboBox<>();
        cbAno.getItems().addAll("2026","2025","2024","2023","2022","2021","2020");
        cbAno.setValue("2023");

        Label modelo=new Label("Modelo");
        TextField txtModelo=new TextField();

        Label status=new Label("Status");
        ComboBox<String> cbStatus=new ComboBox<>();
        cbStatus.getItems().addAll("Disponivel","Em manutencao","Indisponivel");
        cbStatus.setValue("Disponivel");

        Label local=new Label("Localizacao");
        TextField txtLocal=new TextField();

        if(viatura!=null){
            txtPrefixo.setText(viatura.getPrefixo());
            txtPlaca.setText(viatura.getPlaca());
            txtModelo.setText(viatura.getModelo());
            txtLocal.setText(viatura.getLocal());
            cbAno.setValue(viatura.getAno());
            cbTipo.setValue(viatura.getTipo());
            cbStatus.setValue(viatura.getStatus());
        }

        formulario.add(prefixo,0,0);
        formulario.add(txtPrefixo,0,1);
        formulario.add(tipo,1,0);
        formulario.add(cbTipo,1,1);
        formulario.add(placa,0,2);
        formulario.add(txtPlaca,0,3);
        formulario.add(ano,1,2);
        formulario.add(cbAno,1,3);
        formulario.add(modelo,0,4);
        formulario.add(txtModelo,0,5);
        formulario.add(status,1,4);
        formulario.add(cbStatus,1,5);
        formulario.add(local,0,6);
        formulario.add(txtLocal,0,7);

        HBox botoes=new HBox(10);
        botoes.setAlignment(Pos.CENTER);

        Button cancelar=new Button("Cancelar");
        Button salvar=new Button(viatura==null?"Cadastrar":"Salvar Alteracoes");

        cancelar.setOnAction(e->{
            App app=new App();
            app.start(new Stage());
            stage.close();
        });

        salvar.setOnAction(e->{

            if(viatura==null){
                Viatura novaViatura=new Viatura(
                        txtPrefixo.getText(),
                        txtPlaca.getText(),
                        txtModelo.getText(),
                        cbAno.getValue(),
                        txtLocal.getText(),
                        cbTipo.getValue(),
                        cbStatus.getValue(),
                        "0 Manutencoes"
                );
            }else{
                viatura.setPrefixo(txtPrefixo.getText());
                viatura.setPlaca(txtPlaca.getText());
                viatura.setModelo(txtModelo.getText());
                viatura.setAno(cbAno.getValue());
                viatura.setLocal(txtLocal.getText());
                viatura.setTipo(cbTipo.getValue());
                viatura.setStatus(cbStatus.getValue());
            }

            App app=new App();
            app.start(new Stage());
            stage.close();
        });

        botoes.getChildren().addAll(cancelar,salvar);

        root.getChildren().addAll(titulo,formulario,botoes);

        Scene scene=new Scene(root,900,600);

        stage.setScene(scene);
        stage.setTitle(viatura==null?"Cadastrar Viatura":"Editar Viatura");
        stage.show();
    }
}