package com.utilidades;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 * Nombre de la clase: Console
 * fecha:15/08/2018
 * Version: 1.0
 * Copyright: ITCA-FEPADE
 * @author Abdiel Martinez
 */
public class Console
{
    
    public static void log(Object x){
        System.out.println(x);
    }
    
    public static void sms(Object x){
        JOptionPane.showMessageDialog(null, x);
    }
    
    public static String cifrar(String sinCifrar) {
        
        String resultado = "";
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-384");
            byte[] resumen = md.digest(sinCifrar.getBytes("UTF-8"));
            
            for (int i = 0; i < resumen.length; i++)
            {
               resultado += Integer.toHexString((resumen[i] >> 4) & 0xf);
               resultado += Integer.toHexString(resumen[i] & 0xf);
            }
            
        } catch (Exception e)
        {
            Console.log(e.getMessage());
        }
	 return resultado;
    }   
    
    public static void tabla(List datos, JTable jTable1)
    {
        String[]thead= (String[])datos.get(0);

        DefaultTableModel table=new DefaultTableModel(null,thead);
        String[]fila;
        for (int i = 1; i < datos.size(); i++)
        {
            fila= (String[])datos.get(i);
            table.addRow(fila);
        }
        jTable1.setModel(table);
        
        
    }

}
