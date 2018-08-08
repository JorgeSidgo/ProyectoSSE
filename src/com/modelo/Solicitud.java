package com.modelo;

import java.util.Date;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Solicitud
 * Versión: 1.1
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class Solicitud {
    
    private int id;
    private Date fecha;
    private String comentarios;
    private int estado;
    Estudiante idEstudiante;
    Institucion idInstitucion;
    Coordinador idCoordinador;
    
    public Solicitud() {
    }

    public Solicitud(int id, Date fecha, String comentarios, int estado, Estudiante idEstudiante, Institucion idInstitucion, Coordinador idCoordinador) {
        this.id = id;
        this.fecha = fecha;
        this.comentarios = comentarios;
        this.estado = estado;
        this.idEstudiante = idEstudiante;
        this.idInstitucion = idInstitucion;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Institucion getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Institucion idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public Coordinador getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(Coordinador idCoordinador) {
        this.idCoordinador = idCoordinador;
    }
    
}
