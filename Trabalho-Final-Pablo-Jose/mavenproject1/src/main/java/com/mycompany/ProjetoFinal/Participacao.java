/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProjetoFinal;

/**
 *
 * @author aluno
 */
public class Participacao {
    String identificadorDeParticipacao;
    String bombeiro;
    String treinamento;
    String status;
    double frequencia;
    double nota;
    public void registrarInscricao(){}
    public void lancarResultados(double nota,double frequencia){}
    public String confirmarConclusao(double nota,double frequencia){
        if(nota > 6 && frequencia>75*100/frequencia){
            return status = "concluido";
        }
        return this.status;
    }
    
}
