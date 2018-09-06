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
    private String fechaInicio;
    private String fechaFinalizacion;
    private int idEstudiante;
    private int idCoordinador;
    private int idInstitucion;
    private String encargado;
    private int horas;

    public HojaServicioSocial() {
    }

    public HojaServicioSocial(int id, String fechaInicio, String fechaFinalizacion, int idEstudiante, int idCoordinador, int idInstitucion, String encargado, int horas)
    {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.idEstudiante = idEstudiante;
        this.idCoordinador = idCoordinador;
        this.idInstitucion = idInstitucion;
        this.encargado = encargado;
        this.horas = horas;
    }

    public int getHoras()
    {
        return horas;
    }

    public void setHoras(int horas)
    {
        this.horas = horas;
    }


    

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion()
    {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion)
    {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    

    public int getIdEstudiante()
    {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante)
    {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCoordinador()
    {
        return idCoordinador;
    }

    public void setIdCoordinador(int idCoordinador)
    {
        this.idCoordinador = idCoordinador;
    }

    public int getIdInstitucion()
    {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion)
    {
        this.idInstitucion = idInstitucion;
    }

    public String getEncargado()
    {
        return encargado;
    }

    public void setEncargado(String encargado)
    {
        this.encargado = encargado;
    }

    
    
}
