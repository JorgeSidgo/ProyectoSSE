package com.dao;

import com.conexion.Conexion;
import com.modelo.Coordinador;
import com.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
}
