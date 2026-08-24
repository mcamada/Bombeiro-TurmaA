package com.mycompany.sistemagestaoviaturas2;

public class Viatura{

    private String prefixo;
    private String placa;
    private String modelo;
    private String ano;
    private String local;
    private String tipo;
    private String status;
    private String manutencao;

    public Viatura(String prefixo,String placa,String modelo,String ano,String local,String tipo,String status,String manutencao){
        this.prefixo=prefixo;
        this.placa=placa;
        this.modelo=modelo;
        this.ano=ano;
        this.local=local;
        this.tipo=tipo;
        this.status=status;
        this.manutencao=manutencao;
    }
    public String getPrefixo(){
        return prefixo;
    }
    public void setPrefixo(String prefixo){
        this.prefixo=prefixo;
    }
    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placa){
        this.placa=placa;
    }
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    public String getAno(){
        return ano;
    }
    public void setAno(String ano){
        this.ano=ano;
    }
    public String getLocal(){
        return local;
    }
    public void setLocal(String local){
        this.local=local;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getManutencao(){
        return manutencao;
    }
    public void setManutencao(String manutencao){
        this.manutencao=manutencao;
    }
}
