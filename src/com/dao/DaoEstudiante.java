package com.dao;

import com.conexion.Conexion;
import com.modelo.Estudiante;
import com.modelo.Grupo;
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
    public Estudiante getEstudianteCarnet(String carnet)
    {
        Estudiante e = new Estudiante();
        
        try
        {
            this.conectar();
            String sql = "{call getEstudianteCarnet(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, carnet);
            
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                e.setCarnet(res.getString("carnet"));
                e.setNombres(res.getString("nombres"));
                e.setApellidos(res.getString("apellidos"));
                e.setIdGrupo(res.getInt("idGrupo"));
                
            }
        } catch (Exception ex)
        {
        }
        finally
        {
            this.desconectar();
        }
        
        return e;
    }
    
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
    
    public Grupo getGrupo(int id)
    {
        Grupo g = new Grupo();
        
        try
        {
            this.conectar();
            String sql = "select * from grupo where id = ? and estado = 1";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, id);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                g.setId(res.getInt("id"));
                g.setNombreGrupo(res.getString("nombreGrupo"));
                g.setIdCarrera(res.getInt("idCarrera"));
            }
        } catch (Exception e)
        {
        }
        finally
        {
            this.desconectar();
        }
        
        return g;
    }
    
    public void solventar(int id)
    {
        try 
        {
            this.conectar();
            String sql = "call solventar(?);";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1,id);
            pre.executeUpdate();
            pre.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No es posible solventar debido al siguiente error: "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
}
