package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Carrera
 * Versión: 1.0
 * Fecha de Creación: 8 de Agosto de 2018
 * CopyRight: ITCA-FEPADE
 * @author 
 *      Benjamín Ramírez
 *      Abdiel Martínez
 *      Javier Montoya
 *      Jorge Sidgo
 */
public class Carrera 
{
    
    private int id;
    private String nombreCarrera;
    private int idEscuela;

    public Carrera() {
    }

    public Carrera(int id, String nombreCarrera, int idEscuela)
    {
        this.id = id;
        this.nombreCarrera = nombreCarrera;
        this.idEscuela = idEscuela;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getIdEscuela()
    {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela)
    {
        this.idEscuela = idEscuela;
    }

    
    
}
