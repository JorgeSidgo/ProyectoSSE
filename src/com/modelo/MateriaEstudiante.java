package com.modelo;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: MateriaEstudiante
 * Versión: 1.0
 * Fecha de Creación: 8 de Agosto de 2018
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class MateriaEstudiante 
{
    private int id;
    Estudiante idEstudiante;
    Materia idMateria;

    public MateriaEstudiante() {
    }

    public MateriaEstudiante(int id, Estudiante idEstudiante, Materia idMateria) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idMateria = idMateria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }
    
}
