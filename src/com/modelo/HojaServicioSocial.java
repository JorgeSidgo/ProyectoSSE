package com.modelo;

import java.util.Date;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: HojaServicioSocial
 * Versión: 1.0
 * Fecha de Creación: 8 de Agosto de 2018
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class HojaServicioSocial 
{
    private int id;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    Estudiante idEstudiante;
    Coordinador idCoordinador;
    Institucion idInstitucion;

    public HojaServicioSocial() {
    }

    public HojaServicioSocial(int id, Date fechaInicio, Date fechaFinalizacion, Estudiante idEstudiante, Coordinador idCoordinador, Institucion idInstitucion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.idEstudiante = idEstudiante;
        this.idCoordinador = idCoordinador;
        this.idInstitucion = idInstitucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Coordinador getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(Coordinador idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }
    
}
