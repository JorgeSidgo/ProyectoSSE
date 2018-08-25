package com.utilidades;

import com.vista.FrmPrincipalx;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Nombre de la Clase: UITools
 * Version: 1.0
 * Copyright: Jorge Sidgo-Pimentel
 * @author Jorge Sidgo-Pimentel
 */
public class UITools
{

    public void flatButton(JButton boton, String color1, String color2, String color3)
    {
        try
        {
            Color background = Color.decode(color1);
            Color hover = Color.decode(color2);
            Color active = Color.decode(color3);

            boton.setBackground(background);
            boton.setBorderPainted(false);
            boton.setFocusPainted(false);
            boton.setContentAreaFilled(false);
            boton.setOpaque(true);

            boton.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e)
            {
                boton.setBackground(hover);
            }
            public void mouseExited(MouseEvent e)
            {
                boton.setBackground(background);
            }
            public void mousePressed(MouseEvent e)
            {
                boton.setBackground(active);
            }
            public void mouseReleased(MouseEvent e)
            {
                boton.setBackground(background);
            }
        });
        } catch (Exception e)
        {
            
        }
        
    }
        
    public void lblIcon(JLabel label, String icon1, String icon2)
    {
        ImageIcon i = new ImageIcon(getClass().getResource(icon1));
        ImageIcon ii = new ImageIcon(getClass().getResource(icon2));
        
        label.addMouseListener(new MouseAdapter(){
            
            public void mouseEntered(MouseEvent e)
            {
                label.setIcon(ii);
            }
            public void mouseExited(MouseEvent e)
            {
                label.setIcon(i);
            }
            
        });
        
        
    }
    
    public void flatLabel(JLabel label, String color1, String color2, String color3)
    {
        try
        {
            Color background = Color.decode(color1);
            Color hover = Color.decode(color2);
            Color active = Color.decode(color3);

            label.setBackground(background);
            label.setOpaque(true);

            label.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e)
            {
                label.setBackground(hover);
            }
            public void mouseExited(MouseEvent e)
            {
                label.setBackground(background);
            }
            public void mousePressed(MouseEvent e)
            {
                label.setBackground(active);
            }
            public void mouseReleased(MouseEvent e)
            {
                label.setBackground(background);
            }
        });
        } catch (Exception e)
        {
            
        }
        
    }
}
