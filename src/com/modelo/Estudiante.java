package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Estudiante
 * Version: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */

public class Estudiante
{
    private int id;
    private String carnet;
    private String nombres;
    private String apellidos;
    private String correo;
    private int idGrupo;
    private int idUsuario;

    public Estudiante() {
    }

    public Estudiante(int id, String carnet, String nombres, String apellidos, String correo, int idGrupo, int idUsuario)
    {
        this.id = id;
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.idGrupo = idGrupo;
        this.idUsuario = idUsuario;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
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

    public int getIdGrupo()
    {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo)
    {
        this.idGrupo = idGrupo;
    }

    public int getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    
    
}
