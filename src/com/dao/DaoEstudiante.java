package com.dao;

import com.conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: DaoEstudiante
 * Version: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */

public class DaoEstudiante extends Conexion
{
    public String nombreEstudiante(int id)
    {
        String nombreE = "";
        ResultSet res;
        
        try 
        {
            this.conectar();
            String sql = "call stringEstudiante(?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, id);
            res = pre.executeQuery();
            
            while(res.next())
            {
                nombreE = (res.getString("Nombres"));
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se puede mostrar el nombre del Estudiante" + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return nombreE;
    }
}
