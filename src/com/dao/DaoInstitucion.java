    package com.dao;

import com.conexion.Conexion;
import com.modelo.Institucion;
import com.modelo.Usuario;
import com.utilidades.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: DaoInstitucion
 * Version: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */

public class DaoInstitucion extends Conexion
{
    public Institucion buscarIDInstitucion(int id)
    {
        Institucion i = new Institucion();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "call buscarIDInstitucion(?);";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, id);
            res = pre.executeQuery();
            while (res.next()) {
                i.setIdIns(res.getInt("id"));
                i.setNombreIns(res.getString("nombreInstitucion"));
                i.setDireccionIns(res.getString("direccion"));
                i.setCorreoIns(res.getString("correo"));
                i.setTeleIns(res.getString("telefono"));
                i.setIdTipo(res.getInt("idTipoInstitucion"));
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocurrió el siguiente error al buscar la Institución: "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return i;
    }
    
    public List papelera(){
        List registros= new ArrayList();
        ResultSet res;
        Institucion i = new Institucion();
        try
        {
            String sql="call papeleraInstitucion()";
            this.conectar();
            PreparedStatement query=this.getCon().prepareCall(sql);
            res=query.executeQuery();
            
            ResultSetMetaData meta= res.getMetaData();
            int nColumnas=meta.getColumnCount();    //cantidad de columnas
            
            String [] thead= new String[nColumnas];
            
            for (int j = 0; j < meta.getColumnCount(); j++)
            {
                thead[j]=meta.getColumnLabel(j+1);  //cada valor del array sera elnombre de una columna
            }
            registros.add(thead);                   //primer item de la lista sera el thead
            
            String [] fila= new String[nColumnas];
            while(res.next()){
                
                for (int j = 0; j < nColumnas; j++)
                {
                    fila[j]=res.getString(j+1);
                }
                registros.add(fila);
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Ocurrió el siguiente error al buscar en la papelera: "+e.getMessage());
        }finally{
            this.desconectar();
        }
        
        return registros;
    }
    
    public void restaurar(int u)
    {
        try
        {
            this.conectar();
            String sql = "call restaurarInstitucion(?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setInt(1, u);
            
            pre.executeUpdate();
            pre.close();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }

    }
    

    public String nombreInstitucion(int id)
    {
        String nombreI = "";
        ResultSet res;
        
        try 
        {
            this.conectar();
            String sql = "call stringInstitucion(?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, id);
            res = pre.executeQuery();
            
            while(res.next())
            {
                nombreI = (res.getString("Nombre"));
            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se puede mostrar el nombre de la Institución " + e.getMessage());
        }
        return nombreI;
    }
}
