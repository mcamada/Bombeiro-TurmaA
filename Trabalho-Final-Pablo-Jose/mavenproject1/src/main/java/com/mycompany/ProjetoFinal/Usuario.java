/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ProjetoFinal;

/**
 *
 * @author aluno
 */
public class Usuario {
    String identificadorDoUsuario;
    String login;
    String senha;
    String perfil;
    public boolean autenticar(String senha,String login) { 
        return true; 
    }
    public boolean verificarPermissao(String perfil) { 
        return true; 
    }
}
