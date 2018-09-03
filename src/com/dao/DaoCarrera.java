package com.dao;

import com.conexion.Conexion;
import com.modelo.Carrera;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: DaoCarrera
 * Version: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class DaoCarrera extends Conexion
{

    public List<Carrera> mostrarCarrera()
    {
        List<Carrera> lista = new ArrayList();
        
        try
        {
            this.conectar();
            String sql = "{call mostrarCarrera()}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                Carrera c = new Carrera();
                
                c.setId(res.getInt("id"));
                c.setNombreCarrera(res.getString("nombreCarrera"));
                c.setIdEscuela(res.getInt("idEscuela"));
                
                lista.add(c);
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Carrera: " + e.getMessage());
        }
        
        return lista;
    }
    
    public Carrera buscarIdCarrera(int id)
    {
        Carrera c = new Carrera();

        try
        {
            this.conectar();
            String sql = "{call buscarIdCarrera(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                c.setId(res.getInt("id"));
                c.setNombreCarrera(res.getString("nombreCarrera"));
                c.setIdEscuela(res.getInt("idEscuela"));
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Carrera: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return c;
    }
}
