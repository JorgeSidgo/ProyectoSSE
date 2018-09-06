/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.dao.DaoCarrera;
import com.dao.DaoCoordinador;
import com.dao.DaoUsuario;
import com.modelo.Carrera;
import com.modelo.Coordinador;
import com.modelo.Rol;
import com.modelo.Usuario;
import com.utilidades.UITools;
import com.utilidades.Validacion;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsidg
 */
public class InternalFrmUsuarios extends javax.swing.JInternalFrame
{

    UITools ui = new UITools();
    Validacion val = new Validacion();
    Usuario u = new Usuario();
    Coordinador c = new Coordinador();
    DaoUsuario daoU = new DaoUsuario();
    DaoCoordinador daoC = new DaoCoordinador();
    DaoCarrera daoCarrera = new DaoCarrera();
    Timer timer;
    boolean llenarTabla = false;

    public InternalFrmUsuarios()
    {
        initComponents();
        initUi();
    }
    /*
* jionda
* */
    private List listaRoles;
    private List listaCarrera;

    public List getListaRoles()
    {
        return listaRoles;
    }

    public void setListaRoles(List listaRoles)
    {
        this.listaRoles = listaRoles;
    }

    public List getListaCarrera()
    {
        return listaCarrera;
    }

    public void setListaCarrera(List listaCarrera)
    {
        this.listaCarrera = listaCarrera;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombreUsuario = new javax.swing.JTextField();
        lblContra = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCbxRoles = new javax.swing.JComboBox<>();
        jTxtPass = new javax.swing.JPasswordField();
        jTxtId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jBtnRegistrar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jChShow = new javax.swing.JCheckBox();
        jTxtBuscar = new javax.swing.JTextField();
        jPanelCoordinador = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCbxCarrera = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setTitle("Gestión de Usuarios");

        jPanel1.setBackground(new java.awt.Color(36, 37, 38));

        jLabel1.setFont(new java.awt.Font("Product Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios");
        jLabel1.setPreferredSize(new java.awt.Dimension(99, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanelUsuario.setBackground(new java.awt.Color(250, 250, 250));

        jLabel2.setText("Nombre de Usuario:");

        lblContra.setText("Contraseña:");

        jLabel5.setText("Permisos:");

        jCbxRoles.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jCbxRolesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContra)
                    .addComponent(jTxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(jCbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(326, Short.MAX_VALUE))
        );

        jPanelUsuarioLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCbxRoles, jTxtNombreUsuario, jTxtPass});

        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContra, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelUsuarioLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCbxRoles, jTxtNombreUsuario, jTxtPass});

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jBtnRegistrar.setBackground(new java.awt.Color(46, 204, 113));
        jBtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_Add_File_16px.png"))); // NOI18N
        jBtnRegistrar.setText("Registrar");
        jBtnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnRegistrar.setPreferredSize(new java.awt.Dimension(73, 20));
        jBtnRegistrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnRegistrarActionPerformed(evt);
            }
        });

        jBtnEditar.setBackground(new java.awt.Color(52, 152, 219));
        jBtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_Edit_16px.png"))); // NOI18N
        jBtnEditar.setText("Editar");
        jBtnEditar.setPreferredSize(new java.awt.Dimension(73, 20));
        jBtnEditar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setBackground(new java.awt.Color(231, 76, 60));
        jBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_No_16px.png"))); // NOI18N
        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setPreferredSize(new java.awt.Dimension(73, 20));
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnLimpiar.setBackground(new java.awt.Color(127, 140, 141));
        jBtnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_Broom_16px.png"))); // NOI18N
        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.setIconTextGap(5);
        jBtnLimpiar.setPreferredSize(new java.awt.Dimension(73, 20));
        jBtnLimpiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnLimpiarActionPerformed(evt);
            }
        });

        jChShow.setBackground(new java.awt.Color(250, 250, 250));
        jChShow.setText("Mostrar Coordinadores");
        jChShow.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jChShowItemStateChanged(evt);
            }
        });

        jTxtBuscar.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                jTxtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jTxtBuscarFocusLost(evt);
            }
        });
        jTxtBuscar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTxtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jChShow, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChShow)
                    .addComponent(jTxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtnEditar, jBtnEliminar, jBtnLimpiar, jBtnRegistrar, jTxtBuscar});

        jPanelCoordinador.setBackground(new java.awt.Color(250, 250, 250));

        jLabel3.setText("Nombre:");

        jTxtNombre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jTxtNombreKeyPressed(evt);
            }
        });

        jTxtApellido.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jTxtApellidoKeyPressed(evt);
            }
        });

        jLabel6.setText("Apellido:");

        jLabel7.setText("Correo:");

        jTxtCorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel8.setText("Carrera:");

        javax.swing.GroupLayout jPanelCoordinadorLayout = new javax.swing.GroupLayout(jPanelCoordinador);
        jPanelCoordinador.setLayout(jPanelCoordinadorLayout);
        jPanelCoordinadorLayout.setHorizontalGroup(
            jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoordinadorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jCbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jPanelCoordinadorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCbxCarrera, jTxtCorreo});

        jPanelCoordinadorLayout.setVerticalGroup(
            jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoordinadorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCoordinadorLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCoordinadorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCoordinadorLayout.createSequentialGroup()
                        .addGroup(jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCoordinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbxCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelCoordinadorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCbxCarrera, jTxtCorreo});

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTabla.setRowHeight(22);
        jTabla.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCoordinador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCoordinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbxRolesItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jCbxRolesItemStateChanged
    {//GEN-HEADEREND:event_jCbxRolesItemStateChanged
        String selected = this.jCbxRoles.getSelectedItem().toString();

        if (selected.equals("Coordinador"))
        {
            this.jPanelCoordinador.setVisible(true);
        } 
        else
        {
            this.jPanelCoordinador.setVisible(false);
        }
    }//GEN-LAST:event_jCbxRolesItemStateChanged

    private void jChShowItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jChShowItemStateChanged
    {//GEN-HEADEREND:event_jChShowItemStateChanged
        if (this.jChShow.isSelected())
        {
            llenarTablaCoordinadores();
            jPanelCoordinador.setVisible(true);
        } else
        {
            llenarTablaUsuarios();
            jPanelCoordinador.setVisible(false);
        }
    }//GEN-LAST:event_jChShowItemStateChanged

    private void jBtnRegistrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRegistrarActionPerformed
    {//GEN-HEADEREND:event_jBtnRegistrarActionPerformed
       String estado = this.jCbxRoles.getSelectedItem().toString();
       if(estado.equals("Coordinador"))
       {
           insertarCoordinador();
       }
       else
       {
           insertarUsuario();
       }
    }//GEN-LAST:event_jBtnRegistrarActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTablaMouseClicked
    {//GEN-HEADEREND:event_jTablaMouseClicked
        int fila = this.jTabla.getSelectedRow();

        if (this.jChShow.isSelected())
        {
            this.jTxtId.setText(jTabla.getValueAt(fila, 0).toString());
            this.jTxtNombreUsuario.setText(jTabla.getValueAt(fila, 3).toString());
            this.lblContra.setText("Nueva Contraseña:");
            this.jCbxRoles.setSelectedItem("Coordinador");
            this.jTxtNombre.setText(jTabla.getValueAt(fila, 1).toString());
            this.jTxtApellido.setText(jTabla.getValueAt(fila, 2).toString());
            this.jTxtCorreo.setText(jTabla.getValueAt(fila, 4).toString());
            this.jCbxCarrera.setSelectedItem((jTabla.getValueAt(fila, 5).toString()));
        } else
        {
            this.jTxtId.setText(jTabla.getValueAt(fila, 0).toString());
            this.jTxtNombreUsuario.setText(jTabla.getValueAt(fila, 1).toString());
            this.lblContra.setText("Nueva Contraseña:");
            this.jCbxRoles.setSelectedItem(jTabla.getValueAt(fila, 2).toString());
            this.jPanelCoordinador.setVisible(false);
        }

        jBtnEditar.setEnabled(true);
        jBtnEliminar.setEnabled(true);
        jBtnRegistrar.setEnabled(false);
    }//GEN-LAST:event_jTablaMouseClicked

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed

        if(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea actualizar el registro?")==0){
            if (jCbxRoles.getSelectedItem().toString().equals("Coordinador"))
            {
                editarCoordinador();
            } else
            {
                editarUsuario();
            }
        }
        
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jBtnLimpiarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnEliminarActionPerformed
    {//GEN-HEADEREND:event_jBtnEliminarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea actualizar el registro?")==0){
            if (jCbxRoles.getSelectedItem().toString().equals("Coordinador"))
            {
                eliminarCoordinador();
            } else
            {
                eliminarUsuario();
            }
        }
        
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jTxtNombreKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTxtNombreKeyPressed
    {//GEN-HEADEREND:event_jTxtNombreKeyPressed
        val.wordsOnly(evt);
    }//GEN-LAST:event_jTxtNombreKeyPressed

    private void jTxtApellidoKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTxtApellidoKeyPressed
    {//GEN-HEADEREND:event_jTxtApellidoKeyPressed
        val.wordsOnly(evt);
    }//GEN-LAST:event_jTxtApellidoKeyPressed

    private void jTxtBuscarFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jTxtBuscarFocusGained
    {//GEN-HEADEREND:event_jTxtBuscarFocusGained
        jTxtBuscar.setText("");
    }//GEN-LAST:event_jTxtBuscarFocusGained

    private void jTxtBuscarFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jTxtBuscarFocusLost
    {//GEN-HEADEREND:event_jTxtBuscarFocusLost

        
        jTxtBuscar.setText("Buscar por Nombre de Usuario");
        
        /*timer = new Timer(1000, (ActionEvent e) ->
        {
        JOptionPane.showMessageDialog(null, "dec");
        if(!llenarTabla)
        {
        llenarTablaUsuarios();
        llenarTabla = true;
        }
        else
        {
        timer.stop();
        llenarTabla = false;
        }
        });
        
        if(llenarTabla)
        {
        timer.start();
        }*/
    }//GEN-LAST:event_jTxtBuscarFocusLost

    private void jTxtBuscarKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTxtBuscarKeyTyped
    {//GEN-HEADEREND:event_jTxtBuscarKeyTyped
        String buscar = this.jTxtBuscar.getText();
        int longitud = buscar.length();
        if((buscar != "Buscar por Nombre de Usuario") && (longitud > 1))
        {
            llenarTablaBuscarUsuarios();
        }
        else if((buscar != "Buscar por Nombre de Usuario") && (longitud == 0))
        {
            llenarTablaUsuarios();
        }
    }//GEN-LAST:event_jTxtBuscarKeyTyped

    private boolean confirmar(String mensaje)
    {
        int opcion;

        opcion = JOptionPane.showConfirmDialog(this, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION);

        if (opcion == 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    private boolean compContra(String mensaje)
    {
        boolean res = false;
        try
        {
            String contra;
            JLabel lbl = new JLabel(mensaje);
            JTextField pswd = new JPasswordField();
            Object[] obj =
            {
                lbl, pswd
            };
            int opcion = JOptionPane.showConfirmDialog(null, obj, "Contraseña", JOptionPane.OK_CANCEL_OPTION);
            
            
            if(opcion == 0)
            {
                contra = pswd.getText();

                u.setIdUsuario(DaoUsuario.idUsuario);
                u.setPass(contra);

                res = daoU.compContra(u);

                if(!res)
                {
                    JOptionPane.showMessageDialog(this, "Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
                
            return res;
        } catch (Exception e)
        {
            return false;
        }

    }

    private void limpiar()
    {
        this.jTxtNombreUsuario.setText("");
        this.jTxtPass.setText("");
        this.jTxtNombre.setText("");
        this.jTxtApellido.setText("");
        this.jTxtCorreo.setText("");
        this.jCbxRoles.setSelectedIndex(0);
        this.jCbxCarrera.setSelectedIndex(0);
        this.lblContra.setText("Contraseña:");
        jBtnEditar.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        jBtnRegistrar.setEnabled(true);
    }

    private void llenarTablaUsuarios()
    {
        String[] columnas =
        {
            "N°", "Nombre de Usuario", "Permisos"
        };
        Object[] obj = new Object[3];
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);

        try
        {
            List lista = daoU.mostrarUsuarios();

            for (int i = 0; i < lista.size(); i++)
            {
                u = (Usuario) lista.get(i);

                obj[0] = u.getIdUsuario();
                obj[1] = u.getNomUsuario();
                obj[2] = daoU.getRol(u.getIdRol()).getDescRol();

                tabla.addRow(obj);
            }
            this.jTabla.setModel(tabla);
        } catch (Exception e)
        {
        }
    }
    
    private void llenarTablaBuscarUsuarios()
    {
        String[] columnas =
        {
            "N°", "Nombre de Usuario", "Permisos"
        };
        Object[] obj = new Object[3];
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        u.setNomUsuario(this.jTxtBuscar.getText());
        
        
        try
        {
            List lista = daoU.buscarUsuario(u);

            for (int i = 0; i < lista.size(); i++)
            {
                u = (Usuario) lista.get(i);

                obj[0] = u.getIdUsuario();
                obj[1] = u.getNomUsuario();
                obj[2] = daoU.getRol(u.getIdRol()).getDescRol();

                tabla.addRow(obj);
            }
            this.jTabla.setModel(tabla);
        } catch (Exception e)
        {
        }
    }

    private void llenarTablaCoordinadores()
    {
        String[] columnas =
        {
            "N°", "Nombres", "Apellidos", "Nombre de Usuario", "Correo", "Carrera"
        };
        Object[] obj = new Object[6];
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);

        try
        {
            List listaCoordinador = daoC.mostrarCoordinadores();

            for (int i = 0; i < listaCoordinador.size(); i++)
            {
                c = (Coordinador) listaCoordinador.get(i);

                obj[0] = c.getIdCoordinador();
                obj[1] = c.getNombres();
                obj[2] = c.getApellidos();
                obj[3] = daoU.mostrarIdUsuario(c.getIdUsuario()).getNomUsuario();
                obj[4] = c.getCorreo();
                obj[5] = daoCarrera.buscarIdCarrera(c.getIdCarrera()).getNombreCarrera();

                tabla.addRow(obj);
            }
            this.jTabla.setModel(tabla);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void insertarUsuario()
    {
        try
        {
            if (validarUsuario() == 0)
            {
                if (confirmar("¿Desea hacer este registro?"))
                {
                    u.setNomUsuario(this.jTxtNombreUsuario.getText().trim());
                    u.setPass(String.valueOf(this.jTxtPass.getPassword()).trim());

                    int index = seleccionarComboRoles(this.jCbxRoles.getSelectedItem().toString());

                    u.setIdRol(index);

                    daoU.insertarUsuario(u);

                    limpiar();
                    llenarTablaUsuarios();
                }
            }
        } catch (Exception e)
        {
        }
    }

    private void editarUsuario()
    {
        try
        {
            if (validarUsuario() == 0)
            {
                if (confirmar("¿Desea guardar los cambios hechos a este registro?"))
                {
                    if (compContra("Ingrese su contraseña para confirmar los cambios el registro"))
                    {
                        u.setIdUsuario(Integer.parseInt(this.jTxtId.getText()));
                        u.setNomUsuario(this.jTxtNombreUsuario.getText().trim());
                        u.setPass(String.valueOf(this.jTxtPass.getPassword()).trim());
                        u.setIdRol(seleccionarComboRoles(this.jCbxRoles.getSelectedItem().toString()));

                        daoU.editarUsuario(u);

                        limpiar();
                        llenarTablaUsuarios();
                    }
                }
            }
        } catch (Exception e)
        {
        }
    }

    private void eliminarUsuario()
    {
        try
        {

            if (confirmar("¿Desea eliminar este registro?"))
            {
                if (compContra("Ingrese su contraseña para eliminar el registro"))
                {
                    u.setIdUsuario(Integer.parseInt(this.jTxtId.getText()));

                    daoU.borradoLogicoUsuario(u);

                    limpiar();
                    llenarTablaUsuarios();
                }
            }
        } catch (Exception e)
        {
        }
    }

    private void insertarCoordinador()
    {
        try
        {
            if (validarCoordinador() == 0)
            {
                if (confirmar("¿Desea hacer este registro?"))
                {
                    u.setNomUsuario(this.jTxtNombreUsuario.getText().trim());
                    u.setPass(String.valueOf(this.jTxtPass.getPassword()).trim());
                    //u.setIdRol(seleccionarComboRoles(this.jCbxRoles.getSelectedItem().toString()));

                    c.setNombres(jTxtNombre.getText().trim());
                    c.setApellidos(jTxtApellido.getText().trim());
                    c.setCorreo(jTxtCorreo.getText().trim());
                    c.setIdCarrera(seleccionarComboCarreras(jCbxCarrera.getSelectedItem().toString()));

                    daoC.insertarCoordinador(c, u);

                    limpiar();
                    llenarTablaCoordinadores();
                }
            }
        } catch (Exception e)
        {
        }
    }

    private void eliminarCoordinador()
    {
        try
        {

            if (confirmar("¿Desea eliminar este registro?"))
            {
                if (compContra("Ingrese la contraseña actual para eliminar el registro"))
                {
                    c.setIdCoordinador(Integer.parseInt(this.jTxtId.getText()));

                    daoC.borradoLogicoCoordinador(c);

                    limpiar();
                    llenarTablaCoordinadores();
                }
            }
        } catch (Exception e)
        {
        }
    }

    private void editarCoordinador()
    {
        try
        {
            if (validarCoordinador() == 0)
            {
                if (confirmar("¿Desea guardar los cambios hechos a este registro?"))
                {
                    if (compContra("Ingrese la contraseña actual para confirmar los cambios el registro"))
                    {
                        u.setNomUsuario(this.jTxtNombreUsuario.getText().trim());
                        u.setPass(String.valueOf(this.jTxtPass.getPassword()).trim());
                        //u.setIdRol(seleccionarComboRoles(this.jCbxRoles.getSelectedItem().toString()));

                        c.setNombres(jTxtNombre.getText().trim());
                        c.setApellidos(jTxtApellido.getText().trim());
                        c.setCorreo(jTxtCorreo.getText().trim());
                        c.setIdCarrera(seleccionarComboCarreras(jCbxCarrera.getSelectedItem().toString()));
                        c.setIdCoordinador(Integer.parseInt(jTxtId.getText()));

                        daoC.editarCoordinador(c, u);

                        limpiar();
                        llenarTablaCoordinadores();
                    }
                }
            }

        } catch (Exception e)
        {
        }
    }

    private int validarCoordinador()
    {
        int contador = 0;

        try
        {
            if (val.IsNullOrEmpty(jTxtNombreUsuario.getText().trim()))
            {
                contador++;
            }
            if (val.IsNullOrEmpty(String.valueOf(jTxtPass.getPassword()).trim()))
            {
                contador++;
            }
            if (val.IsNullOrEmpty(jTxtNombre.getText().trim()))
            {
                contador++;
            }
            if (val.IsNullOrEmpty(jTxtApellido.getText().trim()))
            {
                contador++;
            }
            if (val.IsNullOrEmpty(jTxtCorreo.getText().trim()))
            {
                contador++;
            }
            
            if(contador > 0)
            {
                JOptionPane.showMessageDialog(this, "Complete los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e)
        {
        }

        return contador;
    }

    private int validarUsuario()
    {
        int contador = 0;

        try
        {

            if (val.IsNullOrEmpty(jTxtNombreUsuario.getText().trim()))
            {
                contador++;
            }
            if (val.IsNullOrEmpty(String.valueOf(jTxtPass.getPassword()).trim()))
            {
                contador++;
            }
            
            if(contador > 0)
        {
            JOptionPane.showMessageDialog(this, "Complete los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        }
        } catch (Exception e)
        {
        }

        return contador;
    }

    private void llenarComboCarreras()
    {
        this.setListaCarrera(daoCarrera.mostrarCarrera());

        for (int i = 0; i < listaCarrera.size(); i++)
        {
            Carrera c = new Carrera();
            c = (Carrera) listaCarrera.get(i);
            this.jCbxCarrera.addItem(c.getNombreCarrera());
        }
    }

    private void llenarComboRoles()
    {
        this.setListaRoles(daoU.mostrarRoles());

        for (int i = 0; i < this.listaRoles.size(); i++)
        {
            Rol r = new Rol();
            r = (Rol) listaRoles.get(i);
            this.jCbxRoles.addItem(r.getDescRol());
        }
    }

    private int seleccionarComboCarreras(String item)
    {
        int index = 0;

        for (int i = 0; i < listaCarrera.size(); i++)
        {
            Carrera c = new Carrera();
            c = (Carrera) listaCarrera.get(i);

            if (item.equals(c.getNombreCarrera()))
            {
                index = c.getId();
            }
        }

        return index;
    }

    private int seleccionarComboRoles(String item)
    {
        int index = 0;

        for (int i = 0; i < listaRoles.size(); i++)
        {
            Rol r = new Rol();
            r = (Rol) listaRoles.get(i);
            if (item.equals(r.getDescRol()))
            {
                index = r.getId();
            }
        }

        return index;
    }
        
    private void initBusqueda()
    {
        JLabel internal = new JLabel();
        
        jTxtBuscar.setLayout(new BoxLayout(jTxtBuscar, BoxLayout.X_AXIS));
        internal.setIcon(new ImageIcon(getClass().getResource("../iconos/lupe.png")));
        jTxtBuscar.add(Box.createRigidArea(new Dimension(200,0)));
        jTxtBuscar.add(internal);
        jTxtBuscar.setText("Buscar por Nombre de Usuario");
    }
    
    private void initUi()
    {
        //validarUsuario();
        jBtnEditar.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        jTxtId.setVisible(false);
        llenarComboRoles();
        initBusqueda();
        llenarComboCarreras();
        llenarTablaUsuarios();
        jPanelCoordinador.setVisible(false);
        ui.flatButton(jBtnRegistrar, "#2ECC71", "#28B463", "#58D68D");
        ui.flatButton(jBtnEditar, "#3498DB", "#2E86C1", "#5DADE2");
        ui.flatButton(jBtnEliminar, "#E74C3C", "#CB4335", "#EC7063");
        ui.flatButton(jBtnLimpiar, "#7F8C8D", "#707B7C", "#99A3A4");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jBtnRegistrar;
    private javax.swing.JComboBox<String> jCbxCarrera;
    private javax.swing.JComboBox<String> jCbxRoles;
    private javax.swing.JCheckBox jChShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCoordinador;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtBuscar;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtId;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtNombreUsuario;
    private javax.swing.JPasswordField jTxtPass;
    private javax.swing.JLabel lblContra;
    // End of variables declaration//GEN-END:variables
}
