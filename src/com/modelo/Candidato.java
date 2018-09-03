/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Candidato
 * Versión: 1.0
 * Fecha de Creación: 1 de Septiembre de 2018
 * CopyRight: ITCA-FEPADE
 * @author 
 *      Benjamín Ramírez
 *      Abdiel Martínez
 *      Javier Montoya
 *      Jorge Sidgo
 */
public class Candidato {
    private int id;
    private String carnet;
    private String nombres;
    private String apellidos;
    private String nombreInstitucion;
    private int nHoras;

    public Candidato() {
    }

    public Candidato(int id, String carnet, String nombres, String apellidos, String nombreInstitucion, int nHoras) {
        this.id = id;
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreInstitucion = nombreInstitucion;
        this.nHoras = nHoras;
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

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public int getnHoras() {
        return nHoras;
    }

    public void setnHoras(int nHoras) {
        this.nHoras = nHoras;
    }
    
}
