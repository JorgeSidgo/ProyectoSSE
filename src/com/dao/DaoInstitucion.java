package com.dao;

import com.conexion.Conexion;
import com.modelo.Institucion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
