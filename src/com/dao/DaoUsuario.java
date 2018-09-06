package com.dao;

import com.conexion.Conexion;
import com.modelo.Rol;
import com.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: DaoUsuario
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
    public static int idUsuario;
    public static String nomUsuario;
    public static int codRol;
    
    Usuario u = new Usuario();
    DaoCoordinador daoC = new DaoCoordinador();

    public List<Usuario> buscarUsuario(Usuario u)
    {
        List<Usuario> listaUsuario = new ArrayList();
        
        try
        {
            this.conectar();
            String sql = "{call buscarNombreUsuario(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, u.getNomUsuario());
            
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                Usuario user = new Usuario();
                
                user.setIdUsuario(res.getInt("id"));
                user.setNomUsuario(res.getString("nomUsuario"));
                user.setIdRol(res.getInt("idRol"));
                
                listaUsuario.add(user);
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return listaUsuario;
    }
    
    public List<Usuario> mostrarUsuarios()
    {
        List<Usuario> listaUsuario = new ArrayList();
        
        try
        {
            this.conectar();
            String sql = "{call mostrarUsuarios()}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                Usuario u = new Usuario();
                
                u.setIdUsuario(res.getInt("id"));
                u.setNomUsuario(res.getString("nomUsuario"));
                u.setIdRol(res.getInt("idRol"));
                
                listaUsuario.add(u);
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error DaoUsuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return listaUsuario;
    }
    
    public boolean compContra(Usuario u)
    {
        boolean respuesta = false;
        int filas = 0;
        try 
        {
            this.conectar();
            String sql = "{call compContra(?, ?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setInt(1, u.getIdUsuario());
            pre.setString(2, u.getPass());
            
            ResultSet res = pre.executeQuery();
            res.last();
            filas = res.getRow();
            
            if(filas == 1)
            {
                respuesta = true;
            }
            else
            {
                respuesta = false;
            }
            
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return respuesta;
    }
    
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
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
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
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
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
            String sql = "{call insertarUsuario(?, ?, ?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, u.getNomUsuario());
            pre.setString(2, u.getPass());
            pre.setInt(3, u.getIdRol());
            
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
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
    }
    
    public void eliminarUsuario(Usuario u)
    {
        try
        {
            this.conectar();
            String sql = "{call eliminarUsuario(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setInt(1, u.getIdUsuario());
            
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
    
    public void borradoLogicoUsuario(Usuario u)
    {
        try
        {
            this.conectar();
            String sql = "{call borradoLogicoUsuario(?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setInt(1, u.getIdUsuario());
            
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
    
    public boolean login(Usuario u)
    {
        boolean respuesta = false;
        int filas = 0;
        try
        {
            this.conectar();
            String sql = "{call login(?, ?)}";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, u.getNomUsuario());
            pre.setString(2, u.getPass());
            
            ResultSet res = pre.executeQuery();
            
            res.last();
            filas = res.getRow();
            //res.beforeFirst();
            
            if(filas == 1)
            {
                DaoUsuario.idUsuario = res.getInt("id");
                DaoUsuario.nomUsuario = res.getString("nomUsuario");
                DaoUsuario.codRol = res.getInt("idRol");
                
                if(res.getInt("idRol") == 4)
                {
                    DaoCoordinador.idCoord = daoC.devCoordUsuario(res.getInt("id")).getIdCoordinador();
                }
                respuesta = true;
            }
            else
            {
                respuesta = false;
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return respuesta;
    }
    
    public Rol getRol(int id)
    {
        Rol r = new Rol();
        
        try
        {
            this.conectar();
            String sql = "select * from rol where id = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {
                r.setId(res.getInt("id"));
                r.setDescRol(res.getString("descRol"));
            }
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return r;
    }
    
    public List<Rol> mostrarRoles()
    {
        List<Rol> listaRoles = new ArrayList();
        
        try
        {
            this.conectar();
            String sql = "select * from rol order by id asc";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            
            while(res.next())
            {   
                Rol r = new Rol();
    
                if(res.getString("descRol").equals("Estudiante"))
                {
                }
                else
                {
                    r.setId(res.getInt("id"));
                    r.setDescRol(res.getString("descRol"));

                    listaRoles.add(r);
                }
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Usuario: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return listaRoles;
    }
    
    public List papelera(){
        List registros =new ArrayList();
        ResultSet res;
        try
        {
            this.conectar();
            String sql="call papeleraUsuario()";
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
    
    public void restaurar(int u)
    {
        try
        {
            this.conectar();
            String sql = "call restaurarUsuario(?)";
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
    
    
}
