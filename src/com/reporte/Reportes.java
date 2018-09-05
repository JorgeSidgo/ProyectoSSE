
package com.reporte;

import com.conexion.Conexion;
import java.sql.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import com.conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        JasperReport reporte;
        
        try
        {
            this.conectar();
            reporte = JasperCompileManager.compileReport("src/com/reporte/reporteEstudiantes.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(reporte, null, this.getCon());
            JasperViewer.viewReport(jp, false);
            
        } catch (Exception e)
        {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error papu: " + e.getMessage());
        }
        finally
        {
            this.desconectar();
        }

    }
    
}
