package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Grupo
 * Versión: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class Grupo 
{
    
    private int id;
    private String nombreGrupo;
    Carrera idCarrera;

    public Grupo() {
    }

    public Grupo(int id, String nombreGrupo) {
        this.id = id;
        this.nombreGrupo = nombreGrupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
}
