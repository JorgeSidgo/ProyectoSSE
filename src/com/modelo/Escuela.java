
package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Escuela
 * Versión: 1.0
 * Fecha: 06-08-18
 * Copyright: ITCA FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */

public class Escuela {
    private int idEscuela;
    private String nombreEscuela;

    public Escuela() {
    }

    public Escuela(int idEscuela, String nombreEscuela) {
        this.idEscuela = idEscuela;
        this.nombreEscuela = nombreEscuela;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }
    
    
}
