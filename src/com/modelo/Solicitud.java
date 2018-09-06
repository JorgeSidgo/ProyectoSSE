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
    private String fecha;
    private String comentarios;
    private int estado;
    private int idEstudiante;
    private int idInstitucion;
    private int idCoordinador;
    private String estadoSolicitud;
    
    public Solicitud() {
    }

    public Solicitud(int id, String fecha, String comentarios, int estado, int idEstudiante, int idInstitucion, int idCoordinador, String estadoSolicitud) {
        this.id = id;
        this.fecha = fecha;
        this.comentarios = comentarios;
        this.estado = estado;
        this.idEstudiante = idEstudiante;
        this.idInstitucion = idInstitucion;
        this.idCoordinador = idCoordinador;
        this.estadoSolicitud = estadoSolicitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public int getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    
    
}
