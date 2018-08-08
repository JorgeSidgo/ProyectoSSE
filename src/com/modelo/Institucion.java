
package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Institucion
 * Versión: 1.0
 * Fecha: 06-08-18
 * Copyright: ITCA FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */

public class Institucion {
    private int idIns;
    private String nombreIns;
    private String direccionIns;
    private String correoIns;
    private String teleIns;
    TipoInstitucion idTipo;

    public Institucion() {
    }

    public Institucion(int idIns, String nombreIns, String direccionIns, String correoIns, String teleIns, TipoInstitucion idTipo) {
        this.idIns = idIns;
        this.nombreIns = nombreIns;
        this.direccionIns = direccionIns;
        this.correoIns = correoIns;
        this.teleIns = teleIns;
        this.idTipo = idTipo;
    }

    public int getIdIns() {
        return idIns;
    }

    public void setIdIns(int idIns) {
        this.idIns = idIns;
    }

    public String getNombreIns() {
        return nombreIns;
    }

    public void setNombreIns(String nombreIns) {
        this.nombreIns = nombreIns;
    }

    public String getDireccionIns() {
        return direccionIns;
    }

    public void setDireccionIns(String direccionIns) {
        this.direccionIns = direccionIns;
    }

    public String getCorreoIns() {
        return correoIns;
    }

    public void setCorreoIns(String correoIns) {
        this.correoIns = correoIns;
    }

    public String getTeleIns() {
        return teleIns;
    }

    public void setTeleIns(String teleIns) {
        this.teleIns = teleIns;
    }

    public TipoInstitucion getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoInstitucion idTipo) {
        this.idTipo = idTipo;
    }
    
    
}
