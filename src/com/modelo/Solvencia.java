package com.modelo;

import java.util.Date;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Candidato
 * Versión: 1.0
 * Fecha de Creación: 1 de Septiembre de 2018
 * CopyRight: ITCA-FEPADE
 * @author 
 *      Benjamín Ramírez
 *      Abdiel Martínez
 *      Javier Montoya
 *      Jorge Sidgo
 */
public class Solvencia {
    private int id;
    private Date fecha;
    private int idEstudiante;
    private int idCoordinador;

    public Solvencia() {
    }

    public Solvencia(int id, Date fecha, int idEstudiante, int idCoordinador) {
        this.id = id;
        this.fecha = fecha;
        this.idEstudiante = idEstudiante;
        this.idCoordinador = idCoordinador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }
    
    
}
