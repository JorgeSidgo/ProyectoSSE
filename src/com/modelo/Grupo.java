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
    private int idCarrera;

    public Grupo() {
    }

    public Grupo(int id, String nombreGrupo, int idCarrera)
    {
        this.id = id;
        this.nombreGrupo = nombreGrupo;
        this.idCarrera = idCarrera;
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

    public int getIdCarrera()
    {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera)
    {
        this.idCarrera = idCarrera;
    }
    
    
}
