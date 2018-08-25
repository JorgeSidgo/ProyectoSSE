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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        
        return respuesta;
    }
}
