
package com.dao;

import com.conexion.Conexion;
import com.modelo.Estudiante;
import com.modelo.Institucion;
import com.modelo.Solicitud;
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

public class DaoSolicitud extends Conexion{
    
    public void insSolicitud(Solicitud s)
    {
        try 
        {
            this.conectar();
            String sql = "call insertarSolicitud(?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setString(1, s.getEstadoSolicitud());
            pre.setInt(2, s.getIdEstudiante());
            pre.setInt(3, s.getIdCoordinador());
            pre.setInt(4, s.getIdInstitucion());
            pre.setString(5, s.getFecha());
            pre.setString(6, s.getComentarios());
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
    
    public List<Solicitud> buscarSolicitud(Estudiante es)
    {
        List<Solicitud> listaB = new ArrayList();
        
        try 
        {
            this.conectar();
            String sql = "call buscarSolicitud(?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setString(1, es.getNombres());
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                Solicitud s = new Solicitud();
                s.setId(res.getInt("id"));
                s.setEstadoSolicitud(res.getString("estadoSolicitud"));
                s.setIdEstudiante(res.getInt("idEstudiante"));
                s.setIdCoordinador(res.getInt("idCoordinador"));
                s.setIdInstitucion(res.getInt("idInstitucion"));
                s.setFecha(res.getString("fecha"));
                s.setComentarios(res.getString("comentarios"));
                listaB.add(s);
            }
            res.close();
            pre.close();
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Hay un problema con mostrar la busqueda de Solicitud "+ e.getMessage());
        }
        
        return listaB;
    }
    
    public int idEstudiante(String carnet)
    {
        int id = 0;
        
        try 
        {
            this.conectar();
            String sql = "call getEstudianteCarnet(?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setString(1, carnet);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                id = (res.getInt("id"));
            }
            res.close();
            pre.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el ID del estudiante");
        }
        finally
        {
            this.desconectar();
        }
        
        return id;
    }
    
    public String validarEst(String carnet)
    {
        String nombres = "";
        
        try 
        {
            this.conectar();
            String sql = "call validarEstudiante(?)";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setString(1, carnet);
            ResultSet res = pre.executeQuery();
            
            while (res.next()) {                
                nombres += (res.getString("Nombres")) + " ";
                nombres += (res.getString("Apellidos"));
            }
            res.close();
            pre.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Hay un problema con el estudiante "+ e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return nombres;
    }
    
    public List papelera(){
        List registros =new ArrayList();
        ResultSet res;
        try
        {
            this.conectar();
            String sql="call papeleraSolicitud()()";
            PreparedStatement query= this.getCon().prepareCall(sql);
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
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        
        
        return registros;
    }
    
    public Institucion getInstitucionSoli(int id)
    {
        Institucion i = new Institucion();
        int idInst = 0;
        try 
        {
            this.conectar();
            String sql = "select idInstitucion from solicitud where id = ?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, id);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                idInst = res.getInt("idInstitucion");
            }

            //JOptionPane.showMessageDialog(null, "dao " + idInst);
            
            sql = "select * from institucion where id = ? and estado = 1";
            pre = this.getCon().prepareCall(sql);
            pre.setInt(1, idInst);
            
            ResultSet res2 = pre.executeQuery();
            while (res2.next()) {
                i.setIdIns(res2.getInt("id"));
                i.setNombreIns(res2.getString("nombreInstitucion"));
                i.setDireccionIns(res2.getString("direccion"));
                i.setCorreoIns(res2.getString("correo"));
                i.setTeleIns(res2.getString("telefono"));
                i.setIdTipo(res2.getInt("idTipoInstitucion"));
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
    
    public Object[] solicitudesEstudiante(String carnet)
    {
        Object[] respuesta = new Object[2];
        
        
        List<Solicitud> lista = new ArrayList();
        
        try
        {
            this.conectar();
            String sql = "call solicitudesEstudiante(?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, carnet);
            pre.setInt(2, DaoCoordinador.idCoord);
            
            ResultSet res = pre.executeQuery();
            
            res.last();
            int filas = res.getRow();
            res.beforeFirst();
            if(filas > 0)
            {
                while(res.next())
                {
                    Solicitud s = new Solicitud();
                    
                    s.setId(res.getInt("id"));
                    s.setIdEstudiante(res.getInt("idEstudiante"));
                    s.setIdCoordinador(res.getInt("idCoordinador"));
                    s.setIdInstitucion(res.getInt("idInstitucion"));
                    s.setFecha(res.getString("fecha"));
                    
                    lista.add(s);
                }
                
                respuesta[0] = "Datos";
                respuesta[1] = lista;
            }
            else
            {
                respuesta[0] = "Nel";
                respuesta[1] = lista;
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Coordinador: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return respuesta;
    }
}
