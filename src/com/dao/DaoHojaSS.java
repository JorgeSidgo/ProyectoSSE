
package com.dao;

import com.conexion.Conexion;
import com.modelo.HojaServicioSocial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

public class DaoHojaSS extends Conexion{
    
   public void insertarHoja (HojaServicioSocial h)
   {
       try
       {
           
           this.conectar();
           String sql = "call insertarHojaServicio(?,?,?,?,?,?,?)";
           PreparedStatement pre = this.getCon().prepareStatement(sql);
           
           pre.setInt(1, h.getIdEstudiante());
           pre.setInt(2, h.getIdInstitucion());
           pre.setInt(3, h.getIdCoordinador());
           pre.setString(4, h.getEncargado());
           pre.setString(5, h.getFechaInicio());
           pre.setString(6, h.getFechaFinalizacion());
           pre.setInt(7, h.getHoras());
           
           pre.execute();
           pre.close();
           
       } catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       finally
       {
           this.desconectar();
       }
   }
    
    
    public List mostrar(int id){
        List registros =new ArrayList();
        ResultSet res;
        try
        {
            this.conectar();
            String sql="call mostrarHojaServicioParametro(?)";
            PreparedStatement query= this.getCon().prepareCall(sql);
            query.setInt(1, id);
            res= query.executeQuery();
            
            ResultSetMetaData meta= res.getMetaData();
            int nColumnas= meta.getColumnCount();
            
            String[] thead= new String[nColumnas];
            for (int i = 0; i < nColumnas; i++)
            {
                thead[i]=meta.getColumnLabel(i+1);
            }
            registros.add(thead);
            
            
            while(res.next()){
                String[] tBody = new String[nColumnas];
                for (int i = 0; i < nColumnas; i++)
                {
                    tBody[i]=res.getString(i+1);
                }
                registros.add(tBody);
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al mostrar hoja SS: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        
        
        return registros;
    }
    
    
}
