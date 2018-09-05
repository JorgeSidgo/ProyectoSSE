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
    private String carrera;
    private String grupo;
    private String estadoSS;
    private int nHoras;

    public Candidato() {
    }

    public Candidato(int id, String carnet, String nombres, String apellidos, String carrera, String grupo, String estadoSS, int nHoras) {
        this.id = id;
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.grupo = grupo;
        this.estadoSS = estadoSS;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEstadoSS() {
        return estadoSS;
    }

    public void setEstadoSS(String estadoSS) {
        this.estadoSS = estadoSS;
    }

    public int getnHoras() {
        return nHoras;
    }

    public void setnHoras(int nHoras) {
        this.nHoras = nHoras;
    }
    
}
