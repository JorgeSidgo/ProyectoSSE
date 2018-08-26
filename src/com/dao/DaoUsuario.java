package com.dao;

import com.conexion.Conexion;
import com.modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Usuario
 * Versión: 1.0
 * Fecha: 06-08-18
 * Copyright: ITCA FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class DaoUsuario extends Conexion
{
    public static int codRol;
    public static String nomUsuario;
    
    Usuario u = new Usuario();
    
    public Usuario mostrarIdUsuario(int id)
    {   
        try
        {
            this.conectar();
            String sql = "{call mostrarIdUsuario(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, id);
            
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                u.setIdUsuario(res.getInt("id"));
                u.setNomUsuario(res.getString("nomUsuario"));
                u.setIdRol(res.getInt("idRol"));
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return u;
    }
    
    public Usuario mostrarNombreUsuario(String nombre)
    {   
        try
        {
            this.conectar();
            String sql = "{call mostrarNombreUsuario(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, nombre);
            
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                u.setIdUsuario(res.getInt("id"));
                u.setNomUsuario(res.getString("nomUsuario"));
                u.setIdRol(res.getInt("idRol"));
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return u;
    }
    
    public void insertarUsuario(Usuario u)
    {
        try
        {
            this.conectar();
            String sql = "{call registrarUsuario(?, ?, ?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, u.getNomUsuario());
            pre.setString(2, u.getPass());
            pre.setInt(3, u.getIdRol());
            
            pre.executeUpdate();
            pre.close();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void editarUsuario(Usuario u)
    {
        try
        {
            this.conectar();
            String sql = "{call editarUsuario(?, ?, ?, ?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, u.getNomUsuario());
            pre.setString(2, u.getPass());
            pre.setInt(3, u.getIdRol());
            pre.setInt(4, u.getIdUsuario());
            
            pre.executeUpdate();
            pre.close();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarUsuario(int id)
    {
        try
        {
            this.conectar();
            String sql = "{call eliminarUsuario(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setInt(1, id);
            
            pre.executeUpdate();
            pre.close();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void borradoLogicoUsuario(int id)
    {
        try
        {
            this.conectar();
            String sql = "{call borradoLogicoUsuario(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setInt(1, id);
            
            pre.executeUpdate();
            pre.close();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public boolean login(Usuario u)
    {
        boolean respuesta = false;
        int filas = 0;
        try
        {
            this.conectar();
            String sql = "{call p_login(?, ?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, u.getNomUsuario());
            pre.setString(2, u.getPass());
            
            ResultSet res = pre.executeQuery();
            
            res.last();
            filas = res.getRow();
            //res.beforeFirst();
            
            if(filas == 1)
            {
                this.codRol = res.getInt("idRol");
                this.nomUsuario = res.getString("nomUsuario");
                respuesta = true;
            }
            else
            {
                respuesta = false;
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return respuesta;
    }
}
