package com.utilidades;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

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
public class Validacion
{
    public void numbersOnly(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public void decimales(KeyEvent evt, JTextField campo) {
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(evt.getKeyChar()) && caracter != KeyEvent.VK_BACK_SPACE  && caracter != '.') {
            evt.consume();
        }
        if(caracter == '.' && campo.getText().contains("."))
        {
            evt.consume();
        }
    }
     
    public void wordsOnly(KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }

    public boolean IsNullOrEmpty(String val) {

        if (val.equals("")) {
            return true;
        }
        if (val.length() == 0) {
            return true;
        }
        if (val == null) {
            return true;
        }
        return false;
    }
}
