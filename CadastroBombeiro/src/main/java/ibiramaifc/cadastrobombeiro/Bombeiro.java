/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ibiramaifc.cadastrobombeiro;

/**
 *
 * @author aluno
 */
public class Bombeiro {
    private String nome;
    private String cpf;
    private String matricula;
    private String cargo;
    private String telefone;
    private String unidade;
    
    public Bombeiro (String nome, String cpf, String matricula, String cargo, String telefone, String unidade){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.cargo = cargo;
        this.telefone = telefone;
        this.unidade = unidade;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public String getMatricula(){
        return matricula;
    }
    public String getCargo(){
        return cargo;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getUnidade(){
        return unidade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public void setUnidade(String unidade){
        this.unidade = unidade;
    }
}
