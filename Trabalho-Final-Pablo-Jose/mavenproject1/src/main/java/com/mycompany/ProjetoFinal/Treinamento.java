/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ProjetoFinal;

import java.util.Date;

/**
 *
 * @author aluno
 */
 public class Treinamento {
     
 private String identificadorDoTreinamento;
 private String nome;
 private String descricao;
 private String tipo; // interno, externo
 private int cargaHoraria;
 private Date dataInicio;
 private Date dataFim;
 private String status;
 private String local;
 private String instituicaoNome;
 private boolean eligibilidade;
    public boolean verificarEligibilidade(String nome,String tipo,int cargaHoraria,Date dataInicio,Date dataFim,String status,String local,String instituicaoNome){
        return this.eligibilidade;
    }
}
