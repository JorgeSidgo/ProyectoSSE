/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.utilidades.UITools;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;

/**
 *
 * @author jsidg
 */
public class FrmPrincipal extends javax.swing.JFrame
{

    private static boolean maximizado = false;
    private static boolean menu = false;
    private int xx;
    private int xy;
    static ImageIcon ii;

    UITools ui = new UITools();
    
    public FrmPrincipal()
    {
        // XD papu
        initComponents();
        maximizar();
        jMenu.setVisible(false);
        layerPanel.setVisible(false);
        menBarArchivo.setVisible(false);
        menBarSS.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        InternalFrmEstudiante internal = new InternalFrmEstudiante();
        this.abrirVentana(internal);
    }

     public void abrirVentana(JInternalFrame internal)
    {
        
        this.desktopPane.add(internal);
        
        try
        {
            internal.setMaximum(true);
        } catch (PropertyVetoException ex)
        {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        internal.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        desktopPane = new javax.swing.JDesktopPane();
        jTitulo = new javax.swing.JPanel();
        jBtnSalir = new javax.swing.JLabel();
        jBtnMax = new javax.swing.JLabel();
        jBtnMin = new javax.swing.JLabel();
        jBtnMenu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenu = new javax.swing.JPanel();
        menArchivo = new javax.swing.JLabel();
        menSS = new javax.swing.JLabel();
        layerPanel = new javax.swing.JLayeredPane();
        menBarSS = new javax.swing.JPanel();
        menItSS = new javax.swing.JLabel();
        menItSolvencia = new javax.swing.JLabel();
        menItSolicitudes = new javax.swing.JLabel();
        menBarArchivo = new javax.swing.JPanel();
        menItEstudiantes = new javax.swing.JLabel();
        menItInstituciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        desktopPane.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jTitulo.setBackground(new java.awt.Color(23, 32, 42));
        jTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                jTituloMouseDragged(evt);
            }
        });
        jTitulo.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jTituloMousePressed(evt);
            }
        });

        jBtnSalir.setBackground(new java.awt.Color(23, 32, 42));
        jBtnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-delete-16.png"))); // NOI18N
        jBtnSalir.setOpaque(true);
        jBtnSalir.setPreferredSize(new java.awt.Dimension(42, 30));
        jBtnSalir.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBtnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jBtnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jBtnSalirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jBtnSalirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                jBtnSalirMouseReleased(evt);
            }
        });

        jBtnMax.setBackground(new java.awt.Color(23, 32, 42));
        jBtnMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBtnMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vista/icons8-compress-16.png"))); // NOI18N
        jBtnMax.setOpaque(true);
        jBtnMax.setPreferredSize(new java.awt.Dimension(42, 30));
        jBtnMax.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBtnMaxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jBtnMaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jBtnMaxMouseExited(evt);
            }
        });

        jBtnMin.setBackground(new java.awt.Color(23, 32, 42));
        jBtnMin.setFont(new java.awt.Font("Ostrich Sans Medium", 0, 36)); // NOI18N
        jBtnMin.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBtnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-minus-16.png"))); // NOI18N
        jBtnMin.setOpaque(true);
        jBtnMin.setPreferredSize(new java.awt.Dimension(42, 30));
        jBtnMin.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBtnMinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jBtnMinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jBtnMinMouseExited(evt);
            }
        });

        jBtnMenu.setBackground(new java.awt.Color(23, 32, 42));
        jBtnMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBtnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-menu-16.png"))); // NOI18N
        jBtnMenu.setOpaque(true);
        jBtnMenu.setPreferredSize(new java.awt.Dimension(42, 30));
        jBtnMenu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jBtnMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jBtnMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jBtnMenuMouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(188, 188, 188));
        jLabel2.setFont(new java.awt.Font("Product Sans", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 229, 229));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Control SSE");
        jLabel2.setPreferredSize(new java.awt.Dimension(34, 30));

        javax.swing.GroupLayout jTituloLayout = new javax.swing.GroupLayout(jTitulo);
        jTitulo.setLayout(jTituloLayout);
        jTituloLayout.setHorizontalGroup(
            jTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTituloLayout.createSequentialGroup()
                .addComponent(jBtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 632, Short.MAX_VALUE)
                .addComponent(jBtnMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtnMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jTituloLayout.setVerticalGroup(
            jTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTituloLayout.createSequentialGroup()
                .addGroup(jTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu.setBackground(new java.awt.Color(28, 40, 51));
        jMenu.setPreferredSize(new java.awt.Dimension(161, 25));

        menArchivo.setBackground(new java.awt.Color(28, 40, 51));
        menArchivo.setForeground(new java.awt.Color(250, 250, 250));
        menArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-filing-cabinet-16.png"))); // NOI18N
        menArchivo.setText("Archivo");
        menArchivo.setOpaque(true);
        menArchivo.setPreferredSize(new java.awt.Dimension(34, 25));
        menArchivo.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menArchivoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                menArchivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                menArchivoMouseExited(evt);
            }
        });

        menSS.setBackground(new java.awt.Color(28, 40, 51));
        menSS.setForeground(new java.awt.Color(250, 250, 250));
        menSS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-helping-hand-16.png"))); // NOI18N
        menSS.setText("Servicio Social");
        menSS.setOpaque(true);
        menSS.setPreferredSize(new java.awt.Dimension(34, 25));
        menSS.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menSSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                menSSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                menSSMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jMenuLayout = new javax.swing.GroupLayout(jMenu);
        jMenu.setLayout(jMenuLayout);
        jMenuLayout.setHorizontalGroup(
            jMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMenuLayout.createSequentialGroup()
                .addComponent(menArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menSS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jMenuLayout.setVerticalGroup(
            jMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layerPanel.setBackground(new java.awt.Color(15, 22, 30));
        layerPanel.setOpaque(true);
        layerPanel.setPreferredSize(new java.awt.Dimension(0, 30));

        menBarSS.setBackground(new java.awt.Color(33, 47, 61));
        menBarSS.setPreferredSize(new java.awt.Dimension(0, 30));

        menItSS.setBackground(new java.awt.Color(33, 47, 61));
        menItSS.setForeground(new java.awt.Color(250, 250, 250));
        menItSS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menItSS.setText("Registrar SS");
        menItSS.setOpaque(true);
        menItSS.setPreferredSize(new java.awt.Dimension(34, 30));
        menItSS.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                menItSSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                menItSSMouseExited(evt);
            }
        });

        menItSolvencia.setBackground(new java.awt.Color(33, 47, 61));
        menItSolvencia.setForeground(new java.awt.Color(250, 250, 250));
        menItSolvencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menItSolvencia.setText("Solvencia");
        menItSolvencia.setOpaque(true);
        menItSolvencia.setPreferredSize(new java.awt.Dimension(34, 30));
        menItSolvencia.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                menItSolvenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                menItSolvenciaMouseExited(evt);
            }
        });

        menItSolicitudes.setBackground(new java.awt.Color(33, 47, 61));
        menItSolicitudes.setForeground(new java.awt.Color(250, 250, 250));
        menItSolicitudes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menItSolicitudes.setText("Solicitudes");
        menItSolicitudes.setOpaque(true);
        menItSolicitudes.setPreferredSize(new java.awt.Dimension(34, 30));
        menItSolicitudes.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                menItSolicitudesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                menItSolicitudesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout menBarSSLayout = new javax.swing.GroupLayout(menBarSS);
        menBarSS.setLayout(menBarSSLayout);
        menBarSSLayout.setHorizontalGroup(
            menBarSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menBarSSLayout.createSequentialGroup()
                .addComponent(menItSS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menItSolvencia, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menItSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menBarSSLayout.setVerticalGroup(
            menBarSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menBarSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(menItSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(menItSolvencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(menItSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menBarArchivo.setBackground(new java.awt.Color(33, 47, 61));
        menBarArchivo.setPreferredSize(new java.awt.Dimension(0, 30));

        menItEstudiantes.setBackground(new java.awt.Color(33, 47, 61));
        menItEstudiantes.setForeground(new java.awt.Color(250, 250, 250));
        menItEstudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menItEstudiantes.setText("Estudiantes");
        menItEstudiantes.setOpaque(true);
        menItEstudiantes.setPreferredSize(new java.awt.Dimension(34, 30));
        menItEstudiantes.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                menItEstudiantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                menItEstudiantesMouseExited(evt);
            }
        });

        menItInstituciones.setBackground(new java.awt.Color(33, 47, 61));
        menItInstituciones.setForeground(new java.awt.Color(250, 250, 250));
        menItInstituciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menItInstituciones.setText("Instituciones");
        menItInstituciones.setOpaque(true);
        menItInstituciones.setPreferredSize(new java.awt.Dimension(34, 30));
        menItInstituciones.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                menItInstitucionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                menItInstitucionesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout menBarArchivoLayout = new javax.swing.GroupLayout(menBarArchivo);
        menBarArchivo.setLayout(menBarArchivoLayout);
        menBarArchivoLayout.setHorizontalGroup(
            menBarArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menBarArchivoLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(menItEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menItInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menBarArchivoLayout.setVerticalGroup(
            menBarArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menBarArchivoLayout.createSequentialGroup()
                .addGroup(menBarArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menItInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menItEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layerPanel.setLayer(menBarSS, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerPanel.setLayer(menBarArchivo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerPanelLayout = new javax.swing.GroupLayout(layerPanel);
        layerPanel.setLayout(layerPanelLayout);
        layerPanelLayout.setHorizontalGroup(
            layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menBarSS, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addGroup(layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menBarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE))
        );
        layerPanelLayout.setVerticalGroup(
            layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerPanelLayout.createSequentialGroup()
                .addComponent(menBarSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layerPanelLayout.createSequentialGroup()
                    .addComponent(menBarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addComponent(layerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(layerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktopPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalirMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnSalirMouseClicked
    {//GEN-HEADEREND:event_jBtnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBtnSalirMouseClicked

    private void jBtnSalirMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnSalirMouseEntered
    {//GEN-HEADEREND:event_jBtnSalirMouseEntered
        jBtnSalir.setBackground(new Color(229, 57, 53));
    }//GEN-LAST:event_jBtnSalirMouseEntered

    private void jBtnSalirMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnSalirMouseExited
    {//GEN-HEADEREND:event_jBtnSalirMouseExited
        jBtnSalir.setBackground(new Color(23, 32, 42));
    }//GEN-LAST:event_jBtnSalirMouseExited

    private void jBtnMaxMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMaxMouseEntered
    {//GEN-HEADEREND:event_jBtnMaxMouseEntered
        jBtnMax.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_jBtnMaxMouseEntered

    private void jBtnSalirMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnSalirMousePressed
    {//GEN-HEADEREND:event_jBtnSalirMousePressed
        jBtnSalir.setBackground(new Color(211, 47, 47));
    }//GEN-LAST:event_jBtnSalirMousePressed

    private void jBtnSalirMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnSalirMouseReleased
    {//GEN-HEADEREND:event_jBtnSalirMouseReleased
        jBtnSalir.setBackground(new Color(23, 32, 42));
    }//GEN-LAST:event_jBtnSalirMouseReleased

    private void jBtnMinMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMinMouseEntered
    {//GEN-HEADEREND:event_jBtnMinMouseEntered
        jBtnMin.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_jBtnMinMouseEntered

    private void jBtnMenuMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMenuMouseEntered
    {//GEN-HEADEREND:event_jBtnMenuMouseEntered
        jBtnMenu.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_jBtnMenuMouseEntered

    private void jBtnMenuMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMenuMouseExited
    {//GEN-HEADEREND:event_jBtnMenuMouseExited
        jBtnMenu.setBackground(new Color(23, 32, 42));
    }//GEN-LAST:event_jBtnMenuMouseExited

    private void jBtnMinMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMinMouseExited
    {//GEN-HEADEREND:event_jBtnMinMouseExited
        jBtnMin.setBackground(new Color(23, 32, 42));
    }//GEN-LAST:event_jBtnMinMouseExited

    private void jBtnMaxMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMaxMouseExited
    {//GEN-HEADEREND:event_jBtnMaxMouseExited
        jBtnMax.setBackground(new Color(23, 32, 42));
    }//GEN-LAST:event_jBtnMaxMouseExited

    private void jBtnMinMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMinMouseClicked
    {//GEN-HEADEREND:event_jBtnMinMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jBtnMinMouseClicked

    private void jBtnMaxMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMaxMouseClicked
    {//GEN-HEADEREND:event_jBtnMaxMouseClicked
        maximizar();
    }//GEN-LAST:event_jBtnMaxMouseClicked

    private void jTituloMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTituloMousePressed
    {//GEN-HEADEREND:event_jTituloMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jTituloMousePressed

    private void jTituloMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTituloMouseDragged
    {//GEN-HEADEREND:event_jTituloMouseDragged
        if (maximizado)
        {
            setExtendedState(NORMAL);
            this.maximizado = false;
        }
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jTituloMouseDragged

    private void jBtnMenuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jBtnMenuMouseClicked
    {//GEN-HEADEREND:event_jBtnMenuMouseClicked
        if (!menu)
        {
            jMenu.setVisible(true);
            this.menu = true;
        } else
        {
            jMenu.setVisible(false);
            layerPanel.setVisible(false);
            menBarSS.setVisible(false);
            menBarArchivo.setVisible(false);
            this.menu = false;
        }
    }//GEN-LAST:event_jBtnMenuMouseClicked

    private void menArchivoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menArchivoMouseClicked
    {//GEN-HEADEREND:event_menArchivoMouseClicked
        layerPanel.setVisible(true);
        menBarSS.setVisible(false);
        menBarArchivo.setVisible(true);
    }//GEN-LAST:event_menArchivoMouseClicked

    private void menSSMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menSSMouseClicked
    {//GEN-HEADEREND:event_menSSMouseClicked
        layerPanel.setVisible(true);
        menBarArchivo.setVisible(false);
        menBarSS.setVisible(true);
    }//GEN-LAST:event_menSSMouseClicked

    private void menArchivoMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menArchivoMouseEntered
    {//GEN-HEADEREND:event_menArchivoMouseEntered
        menArchivo.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_menArchivoMouseEntered

    private void menSSMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menSSMouseEntered
    {//GEN-HEADEREND:event_menSSMouseEntered
        menSS.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_menSSMouseEntered

    private void menItEstudiantesMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItEstudiantesMouseEntered
    {//GEN-HEADEREND:event_menItEstudiantesMouseEntered
        menItEstudiantes.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_menItEstudiantesMouseEntered

    private void menItInstitucionesMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItInstitucionesMouseEntered
    {//GEN-HEADEREND:event_menItInstitucionesMouseEntered
        menItInstituciones.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_menItInstitucionesMouseEntered

    private void menItSSMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItSSMouseEntered
    {//GEN-HEADEREND:event_menItSSMouseEntered
        menItSS.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_menItSSMouseEntered

    private void menItSolvenciaMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItSolvenciaMouseEntered
    {//GEN-HEADEREND:event_menItSolvenciaMouseEntered
        menItSolvencia.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_menItSolvenciaMouseEntered

    private void menItSolicitudesMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItSolicitudesMouseEntered
    {//GEN-HEADEREND:event_menItSolicitudesMouseEntered
        menItSolicitudes.setBackground(new Color(52, 73, 94));
    }//GEN-LAST:event_menItSolicitudesMouseEntered

    private void menArchivoMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menArchivoMouseExited
    {//GEN-HEADEREND:event_menArchivoMouseExited
        menArchivo.setBackground(new Color(28, 40, 51));
    }//GEN-LAST:event_menArchivoMouseExited

    private void menSSMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menSSMouseExited
    {//GEN-HEADEREND:event_menSSMouseExited
        menSS.setBackground(new Color(28, 40, 51));
    }//GEN-LAST:event_menSSMouseExited

    private void menItEstudiantesMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItEstudiantesMouseExited
    {//GEN-HEADEREND:event_menItEstudiantesMouseExited
        menItEstudiantes.setBackground(new Color(33, 47, 61));
    }//GEN-LAST:event_menItEstudiantesMouseExited

    private void menItInstitucionesMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItInstitucionesMouseExited
    {//GEN-HEADEREND:event_menItInstitucionesMouseExited
        menItInstituciones.setBackground(new Color(33, 47, 61));
    }//GEN-LAST:event_menItInstitucionesMouseExited

    private void menItSSMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItSSMouseExited
    {//GEN-HEADEREND:event_menItSSMouseExited
        menItSS.setBackground(new Color(33, 47, 61));
    }//GEN-LAST:event_menItSSMouseExited

    private void menItSolvenciaMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItSolvenciaMouseExited
    {//GEN-HEADEREND:event_menItSolvenciaMouseExited
        menItSolvencia.setBackground(new Color(33, 47, 61));
    }//GEN-LAST:event_menItSolvenciaMouseExited

    private void menItSolicitudesMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menItSolicitudesMouseExited
    {//GEN-HEADEREND:event_menItSolicitudesMouseExited
        menItSolicitudes.setBackground(new Color(33, 47, 61));
    }//GEN-LAST:event_menItSolicitudesMouseExited

    private void maximizar()
    {
        if (!maximizado)
        {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            this.setMaximizedBounds(env.getMaximumWindowBounds());
            ii = new ImageIcon(getClass().getResource("icons8-compress-16.png"));
            jBtnMax.setIcon(ii);
            this.maximizado = true;
        } else
        {
            setExtendedState(NORMAL);
            ii = new ImageIcon(getClass().getResource("icons8-enlarge-16.png"));
            jBtnMax.setIcon(ii);
            this.maximizado = false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                FrmPrincipal frame = new FrmPrincipal();
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jBtnMax;
    private javax.swing.JLabel jBtnMenu;
    private javax.swing.JLabel jBtnMin;
    private javax.swing.JLabel jBtnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jMenu;
    private javax.swing.JPanel jTitulo;
    private javax.swing.JLayeredPane layerPanel;
    private javax.swing.JLabel menArchivo;
    private javax.swing.JPanel menBarArchivo;
    private javax.swing.JPanel menBarSS;
    private javax.swing.JLabel menItEstudiantes;
    private javax.swing.JLabel menItInstituciones;
    private javax.swing.JLabel menItSS;
    private javax.swing.JLabel menItSolicitudes;
    private javax.swing.JLabel menItSolvencia;
    private javax.swing.JLabel menSS;
    // End of variables declaration//GEN-END:variables

}