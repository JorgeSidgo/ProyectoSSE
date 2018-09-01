
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

public class Coordinador {
    private int idCoordinador;
    private String nombres;
    private String apellidos;
    private String correo;
    private int idUsuario;
    private int idCarrera;

    public Coordinador() {
    }

    public Coordinador(int idCoordinador, String nombres, String apellidos, String correo, int idUsuario, int idCarrera)
    {
        this.idCoordinador = idCoordinador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.idUsuario = idUsuario;
        this.idCarrera = idCarrera;
    }

    public int getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(int idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
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
