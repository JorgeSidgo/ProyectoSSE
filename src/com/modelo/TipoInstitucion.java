
package com.modelo;

 /**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: TipoInstitucion
 * Versión: 1.0
 * Fecha: 06-08-18
 * Copyright: ITCA FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class TipoInstitucion {
    private int idTipo;
    private String descripcion;

    public TipoInstitucion() {
    }

    public TipoInstitucion(int idTipo, String descripcion) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
