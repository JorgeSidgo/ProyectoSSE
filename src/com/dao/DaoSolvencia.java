package com.dao;

import com.conexion.Conexion;
import com.modelo.Solvencia;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: DaoSolvencia
 * Versión: 1.0
 * Fecha: 06-08-18
 * Copyright: ITCA FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class DaoSolvencia extends Conexion {
    public void insertarSolvencia(Solvencia s)
    {
        try 
        {
            this.conectar();
            String sql = "call insertarSolvencia(?,?);";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, s.getIdEstudiante());
            pre.setInt(2, s.getIdCoordinador());
            pre.executeUpdate();
            pre.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Es imposible insertar la Solvencia: "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
}
