/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibirama.gestaodepessoal;


public class Bombeiro {

    private String nome;
    private String patente;
    private String funcao;
    private String situacao;

    public Bombeiro(String nome, String patente, String funcao, String situacao) {
        this.nome = nome;
        this.patente = patente;
        this.funcao = funcao;
        this.situacao = situacao;
    }

    public String getNome() {
        return nome;
    }

    public String getPatente() {
        return patente;
    }
    public String getFuncao() {
        return funcao;
    }
    public String getSituacao() {
        return situacao;
    }

    @Override
    public String toString() {
        return nome + " - " + patente + " - " + funcao + " - " + situacao;
    }
}
