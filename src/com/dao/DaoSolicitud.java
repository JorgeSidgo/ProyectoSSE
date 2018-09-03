
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
            String sql = "call editarSolicitud(?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, s.getId());
            pre.setInt(2, s.getIdEstudiante());
            pre.setInt(3, s.getIdCoordinador());
            pre.setInt(4, s.getIdInstitucion());
            pre.setString(6, s.getFecha());
            pre.setString(5, s.getComentarios());
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
            String sql = "call eliminarSolicitud(?)";
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
    
    public List supermostrar()
    {
        List listaS = new ArrayList();
        Object[] obj = new Object[10];
        Solicitud s = new Solicitud();
        
        try 
        {
            this.conectar();
            String sl = "call showEstudiante()";
            PreparedStatement p = this.getCon().prepareCall(sl);
            ResultSet r = p.executeQuery();
            
            while (r.next()) {                
                
                obj[0] = (r.getInt("id"));
                obj[1] = (r.getString("fecha"));
                obj[2] = (r.getString("comentarios"));
            }
            r.close();
            p.close();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Hay un problema con la Solicitud "+ e.getMessage());
        }
               
        try 
        {
            
            String sql = "call solEstudiante(?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, s.getId());
            ResultSet res = pre.executeQuery();
            
            while (res.next()) {                
                
                obj[3]=(res.getInt("id_Estudiante"));
                obj[4]=(res.getString("nombre_Estudiante"));
            }
            res.close();
            pre.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Hay un error con mostrar Estudiante " + e.getMessage());
        }
        
        try 
        {
            String sql2 = "call solCoordinador(?)";
            PreparedStatement pre2 = this.getCon().prepareCall(sql2);
            pre2.setInt(1, s.getId());
            ResultSet res2 = pre2.executeQuery();
            
            while(res2.next())
            {
                obj[5] = (res2.getInt("id_Coordinador"));
                obj[6] = (res2.getString("nombre_Coordinador"));
            }
            res2.close();
            pre2.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Hay un error con mostrar el Coordinador " + e.getMessage());
        }
        
        try 
        {
            String sql3 = "call solInstitucion()";
            PreparedStatement pre3 = this.getCon().prepareCall(sql3);
            pre3.setInt(1, s.getId());
            ResultSet res3 = pre3.executeQuery();
            
            while(res3.next())
            {
                obj[7] = (res3.getInt("id_Intitucion"));
                obj[8] = (res3.getString("nombre_Institucion"));
            }
            
            res3.close();
            pre3.close();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Hay un error con mostrar la Institución" + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
            /*Espero que esto sirva*/
            //s.setId();
        
        for (int i = 0; i <= 9; i++) {
            listaS.add(obj[i]);
        }
        
        return listaS;
    }
}
