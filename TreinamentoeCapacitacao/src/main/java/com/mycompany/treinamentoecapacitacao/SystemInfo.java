package com.mycompany.treinamentoecapacitacao;

public class SystemInfo {

public static String javaVersion() {
return System.getProperty("java.version");
}

public static String javafxVersion() {
return System.getProperty("javafx.version");
}

// Regras de permissão de perfil
public static boolean podeExcluir(String perfil) {
return "Supervisor".equalsIgnoreCase(perfil);
}

public static boolean podeEditarConcluido(String status, String perfil) {
if ("Concluído".equalsIgnoreCase(status)) {
return "Supervisor".equalsIgnoreCase(perfil);
}
return true;
}
}