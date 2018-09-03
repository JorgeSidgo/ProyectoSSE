package com.dao;

import com.conexion.Conexion;
import com.modelo.Candidato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Favor iterar la versión si se requiere realizar un cambio en la estructura de la clase
 * 
 * Nombre de la Clase: Estudiante
 * Version: 1.0
 * Fecha de Creación: 06-08-18
 * CopyRight: ITCA-FEPADE
 * @Autores 
 *      Benjamin Rivas 
 *      Jorge Pimentel
 *      Abdiel Martinez
 *      Javier Montoya
 */
public class DaoCandidato extends Conexion{
    public List mostrarCandidatos()
    {
        List<Candidato> lista = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "call mostrarCandidatos();";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while(res.next())
            {
                Candidato can = new Candidato();
                can.setId(res.getInt("id"));
                can.setCarnet(res.getString("carnet"));
                can.setNombres(res.getString("nombres"));
                can.setApellidos(res.getString("apellidos"));
                can.setNombreInstitucion("nombreInstitucion");
                can.setnHoras(res.getInt("nHoras"));
                lista.add(can);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error al mostrar: "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return lista;
    }
    
    public List buscarNombreCandidato(String nom)
    {
        List lista = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "call buscarNombreCandidatos(?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, nom);
            res = pre.executeQuery();
            while(res.next())
            {
                Candidato can = new Candidato();
                can.setId(res.getInt("id"));
                can.setNombres(res.getString("nombres"));
                can.setApellidos(res.getString("apellidos"));
                can.setCarnet(res.getString("carnet"));
                can.setNombreInstitucion(res.getString("nombreInstitucion"));
                can.setnHoras(res.getInt("nHoras"));
                lista.add(can);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocurrió el siguiente error al buscar: "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return lista;
    }
    
    public List buscarCarnetCandidato(String car)
    {
        List lista = new ArrayList();
        ResultSet res;
        try 
        {
            this.conectar();
            String sql = "call buscarCarnetCandidatos(?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, car);
            res = pre.executeQuery();
            while(res.next())
            {
                Candidato can = new Candidato();
                can.setId(res.getInt("id"));
                can.setNombres(res.getString("nombres"));
                can.setApellidos(res.getString("apellidos"));
                can.setCarnet(res.getString("carnet"));
                can.setNombreInstitucion(res.getString("nombreInstitucion"));
                can.setnHoras(res.getInt("nHoras"));
                lista.add(can);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocurrió el siguiente error al buscar: "+e.getMessage());
        }
        finally
        {
            this.desconectar();
        }
        return lista;
    }
}
