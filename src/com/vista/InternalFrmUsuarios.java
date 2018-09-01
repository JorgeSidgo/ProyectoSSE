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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jsidg
 */
public class InternalFrmUsuarios extends javax.swing.JInternalFrame {

    UITools ui = new UITools();
    Usuario u = new Usuario();
    Coordinador c = new Coordinador();
    DaoUsuario daoU = new DaoUsuario();
    DaoCoordinador daoC = new DaoCoordinador();
    DaoCarrera daoCarrera = new DaoCarrera();
    
    public InternalFrmUsuarios() {
        initComponents();
        initUi();
        
    }

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
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombreUsuario = new javax.swing.JTextField();
        lblContra = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCbxRoles = new javax.swing.JComboBox<>();
        jTxtPass = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jBtnRegistrar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jChShow = new javax.swing.JCheckBox();
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

        jCbxRoles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
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
                    .addComponent(jCbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(jCbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelUsuarioLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCbxRoles, jTxtNombreUsuario, jTxtPass});

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jBtnRegistrar.setBackground(new java.awt.Color(46, 204, 113));
        jBtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/NewFile_6276.png"))); // NOI18N
        jBtnRegistrar.setText("Registrar");
        jBtnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnRegistrar.setPreferredSize(new java.awt.Dimension(73, 20));
        jBtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarActionPerformed(evt);
            }
        });

        jBtnEditar.setBackground(new java.awt.Color(52, 152, 219));
        jBtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/PencilAngled_16xLG_color.png"))); // NOI18N
        jBtnEditar.setText("Editar");
        jBtnEditar.setPreferredSize(new java.awt.Dimension(73, 20));
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setBackground(new java.awt.Color(231, 76, 60));
        jBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/StatusAnnotations_Blocked_16xMD_color.png"))); // NOI18N
        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setPreferredSize(new java.awt.Dimension(73, 20));

        jBtnLimpiar.setBackground(new java.awt.Color(127, 140, 141));
        jBtnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/EraseTool_203.png"))); // NOI18N
        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.setIconTextGap(5);
        jBtnLimpiar.setPreferredSize(new java.awt.Dimension(73, 20));

        jChShow.setBackground(new java.awt.Color(250, 250, 250));
        jChShow.setText("Mostrar Coordinadores");
        jChShow.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jChShowItemStateChanged(evt);
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
                .addComponent(jChShow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jBtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jChShow))
                .addContainerGap())
        );

        jPanelCoordinador.setBackground(new java.awt.Color(250, 250, 250));

        jLabel3.setText("Nombre:");

        jLabel6.setText("Apellido:");

        jLabel7.setText("Correo:");

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
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTabla.setRowHeight(22);
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
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
        
        if(selected.equals("Coordinador"))
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
        if(this.jChShow.isSelected())
        {
            llenarTablaCoordinadores();
            jPanelCoordinador.setVisible(true);
        }
        else
        {
            llenarTablaUsuarios();
            jPanelCoordinador.setVisible(false);
        }
    }//GEN-LAST:event_jChShowItemStateChanged

    private void jBtnRegistrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRegistrarActionPerformed
    {//GEN-HEADEREND:event_jBtnRegistrarActionPerformed
        if(this.jCbxRoles.getSelectedItem().toString() != "Coordinador")
        {
            insertarUsuario();
        }
    }//GEN-LAST:event_jBtnRegistrarActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTablaMouseClicked
    {//GEN-HEADEREND:event_jTablaMouseClicked
        int fila = this.jTabla.getSelectedRow();
        
        if(this.jChShow.isSelected())
        {
            
        }
        else
        {
            this.jTxtNombreUsuario.setText(jTabla.getValueAt(fila, 1).toString());
            this.lblContra.setText("Nueva Contraseña:");
            this.jCbxRoles.setSelectedItem(jTabla.getValueAt(fila, 2).toString());
        }
    }//GEN-LAST:event_jTablaMouseClicked

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        jBtnEliminar.setEnabled(false);
    }//GEN-LAST:event_jBtnEditarActionPerformed
    
    private void limpiar()
    {
        this.jTxtNombreUsuario.setText("");
        this.jTxtPass.setText("");
        this.jTxtNombre.setText("");
        this.jTxtApellido.setText("");
        this.jTxtCorreo.setText("");
        this.jCbxRoles.setSelectedIndex(0);
        this.jCbxCarrera.setSelectedIndex(0);
    }
    
    private void llenarTablaUsuarios()
    {
        String[] columnas = {"N°", "Nombre de Usuario", "Permisos"};
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
    
    private void llenarTablaCoordinadores()
    {
        String[] columnas = {
            "N°", "Nombres", "Apellidos", "Nombre de Usuario",  "Correo", "Carrera"
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
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void editarUsuario()
    {
        
    }
    
    private void insertarUsuario()
    {
        try
        {
            u.setNomUsuario(this.jTxtNombreUsuario.getText().trim());
            u.setPass(String.valueOf(this.jTxtPass.getPassword()).trim());
            
            int index = seleccionarComboRoles(this.jCbxRoles.getSelectedItem().toString());
            
            u.setIdRol(index);
            
            daoU.insertarUsuario(u);
            
            limpiar();
            llenarTablaUsuarios();
            
        } catch (Exception e)
        {
        }
    }
    
    private void validarUsuario()
    {
        
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
            
            if(item.equals(c.getNombreCarrera()))
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
            if(item.equals(r.getDescRol()))
            {
                index = r.getId();
            }
        }
        
        return index;    
    }
    private void initUi()
    {
        //jBtnEditar.setEnabled(false);
        //jBtnEliminar.setEnabled(false);
        llenarComboRoles();
        llenarComboCarreras();
        llenarTablaUsuarios();
        //llenarTablaCoordinadores();
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
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtNombreUsuario;
    private javax.swing.JPasswordField jTxtPass;
    private javax.swing.JLabel lblContra;
    // End of variables declaration//GEN-END:variables
}
