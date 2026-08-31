/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author aluno
 */
public class Item {
    private String nome;
    private String categoria;
    private int quantidade;
    private String unidadeMedida;
    private String local;
    private int nivelMinimo;

    public Item(String nome,String categoria,int qnt,String undMedida,String local,int nvMin){

        this.nome = nome;
        this.categoria = categoria;
        this.nome = nome;
        this.quantidade = qnt;
        this.unidadeMedida = undMedida;
        this.local = local;
        this.nivelMinimo = nvMin;
        
    
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidadeInicial) {
        this.quantidade = quantidadeInicial;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(int nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }
    @Override
    public String toString() {
        return "Nome: "+nome +"  Local:  "+ local;
    }

}
