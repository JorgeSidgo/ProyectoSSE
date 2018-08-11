package com.conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Conexion
 * Version: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class Conexion
{
    private Connection con;
    private final String DB_URL = "jdbc:mysql://localhost:3306/sse?zeroDateTimeBehavior=convertToNull";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    public Connection getCon()
    {
        return con;
    }

    public void setCon(Connection con)
    {
        this.con = con;
    }
    
    public void conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException  | ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error en la Conexión: " + e.getMessage());
        }
    }
    
    public void desconectar()
    {
        try
        {
            if(this.con != null)
            {
                if(!this.con.isClosed())
                {
                    con.close();
                }
            }
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error al Desconectar: " + e.getMessage());
        }
    }
}
