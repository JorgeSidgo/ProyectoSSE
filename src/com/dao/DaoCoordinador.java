package com.dao;

import com.conexion.Conexion;
import com.modelo.Coordinador;
import com.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: DaoCoordinador
 * Version: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class DaoCoordinador extends Conexion
{
    public List<Coordinador> mostrarCoordinadores()
    {
        List<Coordinador> listaCoordinador = new ArrayList();
        
        try
        {
            this.conectar();
            String sql = "{call mostrarCoordinadores()}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                Coordinador c = new Coordinador();
                
                c.setIdCoordinador(res.getInt("id"));
                c.setNombres(res.getString("nombres"));
                c.setApellidos(res.getString("apellidos"));
                c.setCorreo(res.getString("correo"));
                c.setIdUsuario(res.getInt("idUsuario"));
                c.setIdCarrera(res.getInt("idCarrera"));
                
                listaCoordinador.add(c);
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Coordinador: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return listaCoordinador;
    }
    
    public void insertarCoordinador(Coordinador c, Usuario u)
    {
        try
        {
            this.conectar();
            String sql = "{call insertarCoordinador(?,?,?,?,?,?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, c.getNombres());
            pre.setString(2, c.getApellidos());
            pre.setString(3, c.getCorreo());
            pre.setString(4, u.getNomUsuario());
            pre.setString(5, u.getPass());
            pre.setInt(6, c.getIdCarrera());
            
            pre.execute();
            pre.close();            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Coordinador: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void editarCoordinador(Coordinador c, Usuario u)
    {
        try
        {
            this.conectar();
            String sql = "{call editarCoordinador(?,?,?,?,?,?,?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, c.getNombres());
            pre.setString(2, c.getApellidos());
            pre.setString(3, c.getCorreo());
            pre.setString(4, u.getNomUsuario());
            pre.setString(5, u.getPass());
            pre.setInt(6, c.getIdCarrera());
            pre.setInt(7, c.getIdCoordinador());
            
            pre.execute();
            pre.close();            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Coordinador: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void borradoLogicoCoordinador(Coordinador c)
    {
        try
        {
            this.conectar();
            String sql = "{call borradoLogicoCoordinador(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, c.getIdCoordinador());
            
            pre.execute();
            pre.close();            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Coordinador: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
}
