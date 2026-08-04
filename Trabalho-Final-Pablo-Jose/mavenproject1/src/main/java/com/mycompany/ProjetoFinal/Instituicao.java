/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProjetoFinal;

/**
 *
 * @author aluno
 */
public class Instituicao {
    String identificadorDeInstituicao;
    String nome;
    int cnpj;
    int contato;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCNPJ() { 
        return cnpj; 
    }
    public void setCNPJ(int cnpj) { 
        this.cnpj = cnpj; 
    }
    public int getContato() { 
        return contato; 
    }
    public void setContato(int contato) {
        this.contato = contato; 
    }
}
