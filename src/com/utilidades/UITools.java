package com.utilidades;

import com.vista.FrmPrincipal;
import com.vista.FrmPrincipalx;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Nombre de la Clase: UITools
 * Version: 1.0
 * Copyright: Jorge Sidgo-Pimentel
 * @author Jorge Sidgo-Pimentel
 */
public class UITools
{
    private static boolean bandera = false;
    private static boolean asdf = false;

    public void flatButton(JButton boton, String color1, String color2, String color3)
    {
        asdf = false;
        
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

            boton.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if(!boton.isEnabled() && !asdf)
                    {
                        flatButton(boton, "#636e72", "#636e72", "#636e72");
                        asdf = true;
                    }
                    else if(boton.isEnabled() && asdf)
                    {
                        flatButton(boton, color1, color2, color3);
                        asdf = false;
                    }
                    else
                    {
                        
                    }
                }
            });
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
    
    public void menusitos(JLabel label, int p, int pad, boolean menuIt)
    {
        Border compuesto;
        Border outline = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode("#3D3E3F"));
        Border padding = BorderFactory.createEmptyBorder(0, pad, 0, 0);
        
        /*if(menuIt)
        {
        label.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e)
        {
        //principal.cerrarMenu();
        }
        });
        }*/
        
        switch(p){
            case 1:
                outline = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.decode("#3D3E3F"));
                break;
            case 2:
                outline = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#3D3E3F"));
                break;
        }
        
        
        compuesto = BorderFactory.createCompoundBorder(outline, padding);
        label.setBorder(compuesto);
    }
    
    public void menuClass(JLabel label, JLabel internal, int p)
    {
        menusitos(label, p, 10, false);
        
        label.setLayout(new BoxLayout(label, BoxLayout.X_AXIS));
        internal.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-down-16.png")));
        label.add(Box.createRigidArea(new Dimension(200,0)));
        label.add(internal);
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
