package com.utilidades;

import com.vista.FrmPrincipal;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

/**
 * Nombre de la Clase: UITools
 * Version: 1.0
 * Copyright: Jorge Sidgo-Pimentel
 * @author Jorge Sidgo-Pimentel
 */
public class UITools
{
    public void flatButton(JButton boton)
    {
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);
    }
    
}
