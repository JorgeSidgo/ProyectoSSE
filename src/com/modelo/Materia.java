package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Materia
 * Versión: 1.0
 * Fecha de Creación: 8 de Agosto de 2018
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class Materia 
{
    private int id;
    private String nombreMateria;
    private String codMateria;

    public Materia() {
    }

    public Materia(int id, String nombreMateria, String codMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
        this.codMateria = codMateria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }
    
    
}
