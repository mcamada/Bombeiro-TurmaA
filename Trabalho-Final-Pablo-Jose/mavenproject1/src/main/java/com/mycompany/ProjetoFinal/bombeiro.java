/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProjetoFinal;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class bombeiro {
    String identificaorDoBombeiro;
    String nome;
    int cpf;
    int matricula;
    Date dataDeNascimento;
    String patente;
    String especialidade;
    int contato;
    String status;
    public String verificarEligibilidade(String status){
        if(status.equals("concluido")){
            return status = "elegivel";
        }
        return status;
    }
}
