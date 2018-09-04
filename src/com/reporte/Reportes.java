package com.reporte;

import com.conexion.Conexion;
import java.sql.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jsidg
 */
public class Reportes extends Conexion
{
    
    public void reporteEstudiantes()
    {
        try
        {
            this.conectar();
        } catch (Exception e)
        {
        }
        finally
        {
            this.desconectar();
        }
    }
    
}
