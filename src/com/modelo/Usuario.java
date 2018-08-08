
package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Usuario
 * Versión: 1.0
 * Fecha: 06-08-18
 * Copyright: ITCA FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */

public class Usuario {
    private int idUsuario;
    private String nomUsuario;
    private String pass;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomUsuario, String pass) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.pass = pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
