/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.dao.DaoUsuario;
import com.utilidades.UITools;
import static com.vista.FrmPrincipalx.ii;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author jsidg
 */
public class FrmPrincipal extends javax.swing.JFrame
{

    public FrmPrincipal()
    {
        initComponents();
        initUi();
        maximizar();
        if(DaoUsuario.nomUsuario!=null)
        {
            lblUsuario.setText(DaoUsuario.nomUsuario);
        }
        
    }
    UITools ui = new UITools();
    private static boolean menArchivo = false;
    private static boolean menSS = false;
    private static boolean maximizado = false;
    private static boolean menu = false;
    private static boolean barraNombre = false;
    private static Timer timer;
    private int xx;
    private int xy;
    static ImageIcon ii;
    JLabel dropSS = new JLabel();
    JLabel dropArchivo = new JLabel();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jTitleBar = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblX = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();
        lblIcon = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        menuArchivo = new javax.swing.JLabel();
        menuSS = new javax.swing.JLabel();
        menuLogout = new javax.swing.JLabel();
        panelArchivo = new javax.swing.JPanel();
        menuItInstituciones = new javax.swing.JLabel();
        panelSS = new javax.swing.JPanel();
        menuItServicio = new javax.swing.JLabel();
        menuItSolvencia = new javax.swing.JLabel();
        menuItSolicitudes = new javax.swing.JLabel();
        menuUsuarios = new javax.swing.JLabel();
        menuPapelera = new javax.swing.JLabel();

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control SSE");
        setUndecorated(true);

        jTitleBar.setBackground(new java.awt.Color(204, 204, 204));
        jTitleBar.setPreferredSize(new java.awt.Dimension(769, 30));
        jTitleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                jTitleBarMouseDragged(evt);
            }
        });
        jTitleBar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jTitleBarMousePressed(evt);
            }
        });

        lblMenu.setBackground(new java.awt.Color(215, 71, 56));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/men.png"))); // NOI18N
        lblMenu.setOpaque(true);
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblMenuMouseClicked(evt);
            }
        });

        lblNombre.setBackground(new java.awt.Color(215, 71, 56));
        lblNombre.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/relleno.png"))); // NOI18N
        lblNombre.setText("Control SSE  ");
        lblNombre.setToolTipText("");
        lblNombre.setIconTextGap(-1);
        lblNombre.setOpaque(true);
        lblNombre.setPreferredSize(new java.awt.Dimension(80, 20));

        lblX.setBackground(new java.awt.Color(204, 204, 204));
        lblX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vista/x.png"))); // NOI18N
        lblX.setLabelFor(this);
        lblX.setOpaque(true);
        lblX.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblXMouseClicked(evt);
            }
        });

        lblMax.setBackground(new java.awt.Color(204, 204, 204));
        lblMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vista/maxSec.png"))); // NOI18N
        lblMax.setLabelFor(this);
        lblMax.setOpaque(true);
        lblMax.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblMaxMouseClicked(evt);
            }
        });

        lblMin.setBackground(new java.awt.Color(204, 204, 204));
        lblMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/min.png"))); // NOI18N
        lblMin.setLabelFor(this);
        lblMin.setOpaque(true);
        lblMin.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblMinMouseClicked(evt);
            }
        });

        lblUsuario.setBackground(new java.awt.Color(204, 204, 204));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setLabelFor(this);
        lblUsuario.setText("Usuario");
        lblUsuario.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jTitleBarLayout = new javax.swing.GroupLayout(jTitleBar);
        jTitleBar.setLayout(jTitleBarLayout);
        jTitleBarLayout.setHorizontalGroup(
            jTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTitleBarLayout.createSequentialGroup()
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jTitleBarLayout.setVerticalGroup(
            jTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jTitleBarLayout.createSequentialGroup()
                .addGroup(jTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        desktopPane.setBackground(new java.awt.Color(250, 250, 250));

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vista/logo.png"))); // NOI18N
        lblIcon.setToolTipText("");
        lblIcon.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblIconMouseClicked(evt);
            }
        });

        desktopPane.setLayer(lblIcon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        panelMenu.setBackground(new java.awt.Color(36, 37, 38));
        panelMenu.setPreferredSize(new java.awt.Dimension(225, 0));

        menuArchivo.setBackground(new java.awt.Color(36, 37, 38));
        menuArchivo.setDisplayedMnemonic('n');
        menuArchivo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuArchivo.setForeground(new java.awt.Color(255, 255, 255));
        menuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-filing-cabinet-16 (1).png"))); // NOI18N
        menuArchivo.setText("Archivo");
        menuArchivo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        menuArchivo.setIconTextGap(10);
        menuArchivo.setOpaque(true);
        menuArchivo.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuArchivoMouseClicked(evt);
            }
        });

        menuSS.setBackground(new java.awt.Color(36, 37, 38));
        menuSS.setDisplayedMnemonic('n');
        menuSS.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuSS.setForeground(new java.awt.Color(255, 255, 255));
        menuSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-helping-hand-16 (1).png"))); // NOI18N
        menuSS.setText("Servicio Social");
        menuSS.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        menuSS.setIconTextGap(10);
        menuSS.setOpaque(true);
        menuSS.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuSSMouseClicked(evt);
            }
        });

        menuLogout.setBackground(new java.awt.Color(36, 37, 38));
        menuLogout.setDisplayedMnemonic('n');
        menuLogout.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        menuLogout.setForeground(new java.awt.Color(255, 255, 255));
        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-shutdown-16 (1).png"))); // NOI18N
        menuLogout.setText("Cerrar Sesión");
        menuLogout.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        menuLogout.setIconTextGap(10);
        menuLogout.setOpaque(true);
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuLogoutMouseClicked(evt);
            }
        });

        panelArchivo.setBackground(new java.awt.Color(54, 56, 57));

        menuItInstituciones.setBackground(new java.awt.Color(54, 56, 57));
        menuItInstituciones.setDisplayedMnemonic('n');
        menuItInstituciones.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItInstituciones.setForeground(new java.awt.Color(255, 255, 255));
        menuItInstituciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-building-16.png"))); // NOI18N
        menuItInstituciones.setText("Instituciones");
        menuItInstituciones.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItInstituciones.setIconTextGap(10);
        menuItInstituciones.setOpaque(true);
        menuItInstituciones.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItInstitucionesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelArchivoLayout = new javax.swing.GroupLayout(panelArchivo);
        panelArchivo.setLayout(panelArchivoLayout);
        panelArchivoLayout.setHorizontalGroup(
            panelArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuItInstituciones, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        panelArchivoLayout.setVerticalGroup(
            panelArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArchivoLayout.createSequentialGroup()
                .addComponent(menuItInstituciones, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSS.setBackground(new java.awt.Color(54, 56, 57));

        menuItServicio.setBackground(new java.awt.Color(54, 56, 57));
        menuItServicio.setDisplayedMnemonic('n');
        menuItServicio.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItServicio.setForeground(new java.awt.Color(255, 255, 255));
        menuItServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-document-16.png"))); // NOI18N
        menuItServicio.setText("Registrar SS");
        menuItServicio.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItServicio.setIconTextGap(10);
        menuItServicio.setOpaque(true);
        menuItServicio.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItServicioMouseClicked(evt);
            }
        });

        menuItSolvencia.setBackground(new java.awt.Color(54, 56, 57));
        menuItSolvencia.setDisplayedMnemonic('n');
        menuItSolvencia.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItSolvencia.setForeground(new java.awt.Color(255, 255, 255));
        menuItSolvencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-public-16.png"))); // NOI18N
        menuItSolvencia.setText("Solvencia");
        menuItSolvencia.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItSolvencia.setIconTextGap(10);
        menuItSolvencia.setOpaque(true);
        menuItSolvencia.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItSolvenciaMouseClicked(evt);
            }
        });

        menuItSolicitudes.setBackground(new java.awt.Color(54, 56, 57));
        menuItSolicitudes.setDisplayedMnemonic('n');
        menuItSolicitudes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItSolicitudes.setForeground(new java.awt.Color(255, 255, 255));
        menuItSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-invite-16.png"))); // NOI18N
        menuItSolicitudes.setText("Solicitudes");
        menuItSolicitudes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItSolicitudes.setIconTextGap(10);
        menuItSolicitudes.setOpaque(true);
        menuItSolicitudes.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItSolicitudesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSSLayout = new javax.swing.GroupLayout(panelSS);
        panelSS.setLayout(panelSSLayout);
        panelSSLayout.setHorizontalGroup(
            panelSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuItServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuItSolvencia, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuItSolicitudes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        panelSSLayout.setVerticalGroup(
            panelSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSSLayout.createSequentialGroup()
                .addComponent(menuItServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuItSolvencia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuItSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuUsuarios.setBackground(new java.awt.Color(36, 37, 38));
        menuUsuarios.setDisplayedMnemonic('n');
        menuUsuarios.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        menuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-user-groups-16.png"))); // NOI18N
        menuUsuarios.setText("Gestión de Usuarios");
        menuUsuarios.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        menuUsuarios.setIconTextGap(10);
        menuUsuarios.setOpaque(true);
        menuUsuarios.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuUsuariosMouseClicked(evt);
            }
        });

        menuPapelera.setBackground(new java.awt.Color(36, 37, 38));
        menuPapelera.setDisplayedMnemonic('n');
        menuPapelera.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuPapelera.setForeground(new java.awt.Color(255, 255, 255));
        menuPapelera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-trash-16.png"))); // NOI18N
        menuPapelera.setText("Papelera");
        menuPapelera.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        menuPapelera.setIconTextGap(10);
        menuPapelera.setOpaque(true);
        menuPapelera.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuPapeleraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuSS, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(panelArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuPapelera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(menuArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuSS, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuPapelera, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktopPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopPane)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void lblXMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblXMouseClicked
    {//GEN-HEADEREND:event_lblXMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblXMouseClicked

    private void lblMaxMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblMaxMouseClicked
    {//GEN-HEADEREND:event_lblMaxMouseClicked
        maximizar();
    }//GEN-LAST:event_lblMaxMouseClicked

    private void jTitleBarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTitleBarMousePressed
    {//GEN-HEADEREND:event_jTitleBarMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jTitleBarMousePressed

    private void jTitleBarMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTitleBarMouseDragged
    {//GEN-HEADEREND:event_jTitleBarMouseDragged
        if (maximizado)
        {
            maximizar();
        }
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jTitleBarMouseDragged

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblMenuMouseClicked
    {//GEN-HEADEREND:event_lblMenuMouseClicked

        menu();

        /*timer = new Timer(1, new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
        if (!barraNombre)
        {
        lbl();
        barraNombre = true;
        } else
        {
        timer.stop();
        barraNombre = false;
        }
        }
        });
        if (!barraNombre)
        {
        timer.start();
        }*/

    }//GEN-LAST:event_lblMenuMouseClicked

    private void lblMinMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblMinMouseClicked
    {//GEN-HEADEREND:event_lblMinMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_lblMinMouseClicked

    private void lblUsuarioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblUsuarioMouseClicked
    {//GEN-HEADEREND:event_lblUsuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUsuarioMouseClicked

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuLogoutMouseClicked
    {//GEN-HEADEREND:event_menuLogoutMouseClicked
        try
        {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?, los cambios que no han sido guardados se perderán", "Confirmar", JOptionPane.YES_NO_OPTION);
            
            if(opcion == 0)
            {
                FrmLogin frm = new FrmLogin();
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
                this.maximizado = false;
                this.dispose();
            }
            
        } catch (Exception e)
        {
        }
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void menuArchivoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuArchivoMouseClicked
    {//GEN-HEADEREND:event_menuArchivoMouseClicked

        if(!menArchivo)
        {
            panelArchivo.setVisible(true);
            dropArchivo.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-up-16.png")));
            menArchivo = true;
        }
        else
        {
            panelArchivo.setVisible(false);
            dropArchivo.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-down-16.png")));
            menArchivo = false;
        }
    }//GEN-LAST:event_menuArchivoMouseClicked

    private void menuSSMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuSSMouseClicked
    {//GEN-HEADEREND:event_menuSSMouseClicked
        if(!menSS)
        {
        panelSS.setVisible(true);
        dropSS.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-up-16.png")));
        menSS = true;
        }
        else
        {
        panelSS.setVisible(false);
        dropSS.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-down-16.png")));
        menSS = false;
        }
    }//GEN-LAST:event_menuSSMouseClicked

    public void cerrarSubMenus(JPanel contenedor, JLabel interno )
    {
        contenedor.setVisible(false);
        interno.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-down-16.png")));
    }
    
    public void cerrarMenu()
    {
        panelMenu.setVisible(false);       
        cerrarSubMenus(panelArchivo, dropArchivo);
        menArchivo = false;
        cerrarSubMenus(panelSS, dropSS);
        menSS = false;
        menu = false;
    }
    
    private void menuItInstitucionesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItInstitucionesMouseClicked
    {//GEN-HEADEREND:event_menuItInstitucionesMouseClicked
        InternalFrmInstitucion frm = new InternalFrmInstitucion();
        abrirVentana(frm);
    }//GEN-LAST:event_menuItInstitucionesMouseClicked

    private void menuUsuariosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuUsuariosMouseClicked
    {//GEN-HEADEREND:event_menuUsuariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuUsuariosMouseClicked

    private void lblIconMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblIconMouseClicked
    {//GEN-HEADEREND:event_lblIconMouseClicked
        if(menu)
        {
            cerrarMenu();
        }
    }//GEN-LAST:event_lblIconMouseClicked

    private void menuItServicioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItServicioMouseClicked
    {//GEN-HEADEREND:event_menuItServicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItServicioMouseClicked

    private void menuItSolvenciaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItSolvenciaMouseClicked
    {//GEN-HEADEREND:event_menuItSolvenciaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItSolvenciaMouseClicked

    private void menuItSolicitudesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItSolicitudesMouseClicked
    {//GEN-HEADEREND:event_menuItSolicitudesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItSolicitudesMouseClicked

    private void menuPapeleraMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuPapeleraMouseClicked
    {//GEN-HEADEREND:event_menuPapeleraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPapeleraMouseClicked

    private void borders(int a, int b, int c)
    {
        desktopPane.setBorder(new MatteBorder(0, c, b, b, Color.decode("#E74C3C")));
        jTitleBar.setBorder(new MatteBorder(b, 0, 0, b, Color.decode("#E74C3C")));
        panelMenu.setBorder(new MatteBorder(0, a, a, 0, Color.decode("#E74C3C")));
    }

    /*    public void lbl()
    {
    if (menu)
    {
    
    lblNombre.setSize(new Dimension(205, 30));
    lblNombre.setPreferredSize(new Dimension(205, 30));
    } else
    {
    
    lblNombre.setSize(new Dimension(90, 30));
    lblNombre.setPreferredSize(new Dimension(90, 30));
    }
    }*/

    public void menu()
    {
        if (!menu)
        {
            panelMenu.setVisible(true);
            menu = true;
            if(!maximizado)
            {
                borders(1, 1, 0);
            }
        } else
        {
            cerrarMenu();
            if(!maximizado)
            {
                borders(0, 1, 1);
            }
        }
    }

    public void maximizar()
    {
        if (!maximizado)
        {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            this.setMaximizedBounds(env.getMaximumWindowBounds());
            ii = new ImageIcon(getClass().getResource("maxSec.png"));
            lblMax.setIcon(ii);
            borders(0, 0, 0);
            this.maximizado = true;
        } else
        {
            setExtendedState(NORMAL);
            ii = new ImageIcon(getClass().getResource("max.png"));
            lblMax.setIcon(ii);
            borders(0, 1, 1);
            this.maximizado = false;
        }
    }

    public void initUi()
    {
        panelSS.setVisible(false);
        panelMenu.setVisible(false);
        panelArchivo.setVisible(false);
        ui.flatLabel(lblMin, "#CCCCCC", "#B7B7B7", "#A3A3A3");
        ui.flatLabel(lblMax, "#CCCCCC", "#B7B7B7", "#A3A3A3");
        ui.flatLabel(lblX, "#CCCCCC", "#E81123", "#DC5C66");
        ui.flatLabel(lblMenu, "#D74738", "#B03A2E", "#EC7063");
        ui.lblIcon(lblX, "../vista/x.png", "../vista/xW.png");
        ui.flatLabel(menuArchivo, "#242526", "#2D2E2F", "#111111");
        ui.menuClass(menuArchivo, dropArchivo, 1);
        ui.flatLabel(menuSS, "#242526", "#2D2E2F", "#111111");
        ui.menuClass(menuSS, dropSS, 10);
        ui.flatLabel(menuLogout, "#242526", "#D74738", "#E74C3C");
        ui.menusitos(menuLogout, 1, 10, false);
        ui.flatLabel(menuUsuarios, "#242526", "#2D2E2F", "#111111");
        ui.menusitos(menuUsuarios, 1, 10, false);
        ui.flatLabel(menuItInstituciones, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItInstituciones, 2, 20, true);
        ui.flatLabel(menuItServicio, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItServicio, 2, 20, true);
        ui.flatLabel(menuItSolvencia, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItSolvencia, 2, 20, true);
        ui.flatLabel(menuItSolicitudes, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItSolicitudes, 2, 20, true);
        ui.flatLabel(menuPapelera,"#242526", "#2D2E2F", "#111111");
        ui.menusitos(menuPapelera, 1, 10, false);

    }

    private void abrirVentana(JInternalFrame form)
    {
        cerrarMenu();
        
        JInternalFrame[] frms = this.desktopPane.getAllFrames();
        int n = frms.length;
        if(n == 0)
        {
            this.desktopPane.add(form);
            try
            {
                form.setMaximum(true);
            } catch (PropertyVetoException ex)
            {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            form.setVisible(true);
        }
        else
        {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar este formulario para abrir " + form.getTitle() + "?\n" , "Abrir ventana", JOptionPane.YES_NO_OPTION);
            if(opcion == 0)
            {
                JInternalFrame actual = this.desktopPane.getSelectedFrame();
                actual.dispose();
                abrirVentana(form);
            }
            else
            {
                form.dispose();
            }
        }
    }
    
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
                FrmPrincipal frm = new FrmPrincipal();
                frm.setLocationRelativeTo(null);
                frm.setExtendedState(MAXIMIZED_BOTH);
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel jTitleBar;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblX;
    private javax.swing.JLabel menuArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel menuItInstituciones;
    private javax.swing.JLabel menuItServicio;
    private javax.swing.JLabel menuItSolicitudes;
    private javax.swing.JLabel menuItSolvencia;
    private javax.swing.JLabel menuLogout;
    private javax.swing.JLabel menuPapelera;
    private javax.swing.JLabel menuSS;
    private javax.swing.JLabel menuUsuarios;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JPanel panelArchivo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelSS;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
