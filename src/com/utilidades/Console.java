package com.utilidades;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.swing.JOptionPane;


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

}
