
package com.dao;

import com.conexion.Conexion;
import com.modelo.Solicitud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DaoSolicitud
 * Versiòn: 1.0
 * Fecha: 20-08-18
 * CopyRight: ITCA FEPADE
 * @author Javier Montoya
 */

public class DaoSolicitud extends Conexion{
    
    public void insSolicitud(Solicitud s)
    {
        try 
        {
            this.conectar();
            String sql = "call insertarSolicitud(?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, s.getIdEstudiante());
            pre.setInt(2, s.getIdCoordinador());
            pre.setInt(3, s.getIdInstitucion());
            pre.setString(4, s.getFecha());
            pre.execute();
            pre.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Es imposible ingresar la solicitud "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void updSolicitud(Solicitud s)
    {
        try 
        {
            this.conectar();
            String sql = "call editarSolicitud(?,?,?);";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, s.getId());
            pre.setString(2, s.getEstadoSolicitud());
            pre.setString(3, s.getComentarios());
            pre.execute();
            pre.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Es imposible actualizar la solicitud "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void dltSolicitud(int idSolicitud)
    {
        try
        {
            this.conectar();
            String sql = "call ocultarSolicitud(?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, idSolicitud);
            pre.execute();
            pre.close();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Es imposible eliminar la solicitud "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
                
    }
    
    public List mostrarSolicitud()
    {
        List listaS = new ArrayList();      
        
        try 
        {
            this.conectar();
            String sl = "call showSolicitud()";
            PreparedStatement p = this.getCon().prepareCall(sl);
            ResultSet r = p.executeQuery();
            
            while (r.next()) {                
                Solicitud s = new Solicitud();
                s.setId(r.getInt("id"));
                s.setEstadoSolicitud(r.getString("estadoSolicitud"));
                s.setIdEstudiante(r.getInt("idEstudiante"));
                s.setIdCoordinador(r.getInt("idCoordinador"));
                s.setIdInstitucion(r.getInt("idInstitucion"));
                s.setFecha(r.getString("fecha"));
                s.setComentarios(r.getString("comentarios"));
                listaS.add(s);
            }
            r.close();
            p.close();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Hay un problema con la Solicitud "+ e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return listaS;
    }
}
