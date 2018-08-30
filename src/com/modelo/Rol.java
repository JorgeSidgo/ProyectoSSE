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
public class Rol
{
    private int id;
    private String descRol;

    public Rol()
    {
    }

    public Rol(int id, String descRol)
    {
        this.id = id;
        this.descRol = descRol;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescRol()
    {
        return descRol;
    }

    public void setDescRol(String descRol)
    {
        this.descRol = descRol;
    }
    
    
}
