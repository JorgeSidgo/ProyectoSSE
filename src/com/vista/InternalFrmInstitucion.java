package com.vista;

import com.dao.DaoInstitucion;
import com.modelo.Institucion;
import com.utilidades.Console;
import com.utilidades.UITools;
import com.utilidades.Validacion;

/**
 *
 * @author jsidg
 */
public class InternalFrmInstitucion extends javax.swing.JInternalFrame
{

    UITools ui = new UITools();
    Validacion val = new Validacion();
    DaoInstitucion inst = new DaoInstitucion();
    
    public InternalFrmInstitucion()
    {
        initComponents();
        initUi();
        Console.tabla(inst.mostrar(),this.jTable1);
//        jTxtId.setVisible(false);
    }

    private Institucion capturar(){
        Institucion in= new Institucion();
        in.setCorreoIns(this.jTxtCorreo.getText());
        in.setDireccionIns(this.jTxtDireccion.getText());
        in.setIdTipo(this.jCbxTipoInstitucion.getSelectedIndex()+1);
        in.setNombreIns(this.jTxtNombreInstitucion.getText());
        in.setTeleIns(this.jTxtTelefono.getText());
        in.setIdIns(Integer.parseInt(this.jTxtId.getText()));
        
        return in;
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombreInstitucion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCbxTipoInstitucion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTxtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtTelefono = new javax.swing.JFormattedTextField();
        jTxtId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jBtnRegistrar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setTitle("Gestión de Instituciones");
        setFocusCycleRoot(false);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-museum-20.png"))); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                formKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(36, 37, 38));

        jLabel1.setFont(new java.awt.Font("Product Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Instituciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        jLabel2.setText("Nombre de la Institucion:");

        jLabel3.setText("Tipo de Institución");

        jCbxTipoInstitucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Publica", "Privada", "ONG" }));

        jLabel4.setText("Dirección:");

        jLabel5.setText("Correo:");

        jLabel6.setText("Teléfono:");

        try
        {
            jTxtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        jTxtId.setText("no borrar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(207, 207, 207))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTxtTelefono)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCbxTipoInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTxtNombreInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(275, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCbxTipoInstitucion, jTxtNombreInstitucion});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtNombreInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtTelefono))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCbxTipoInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCbxTipoInstitucion, jTxtNombreInstitucion});

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jBtnRegistrar.setBackground(new java.awt.Color(46, 204, 113));
        jBtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/NewFile_6276.png"))); // NOI18N
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
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/PencilAngled_16xLG_color.png"))); // NOI18N
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
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/StatusAnnotations_Blocked_16xMD_color.png"))); // NOI18N
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
        jBtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/EraseTool_203.png"))); // NOI18N
        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.setIconTextGap(5);
        jBtnLimpiar.setPreferredSize(new java.awt.Dimension(73, 20));

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
                    .addComponent(jBtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_formKeyTyped
    {//GEN-HEADEREND:event_formKeyTyped
       
    }//GEN-LAST:event_formKeyTyped

    private void jBtnRegistrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnRegistrarActionPerformed
    {//GEN-HEADEREND:event_jBtnRegistrarActionPerformed
        inst.insertar(capturar());
        Console.tabla(inst.mostrar(),this.jTable1);
    }//GEN-LAST:event_jBtnRegistrarActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnEditarActionPerformed
    {//GEN-HEADEREND:event_jBtnEditarActionPerformed
        inst.actualizar(capturar());
        Console.tabla(inst.mostrar(),this.jTable1);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnEliminarActionPerformed
    {//GEN-HEADEREND:event_jBtnEliminarActionPerformed
        inst.eliminar(Integer.parseInt(this.jTxtId.getText()));
        Console.tabla(inst.mostrar(),this.jTable1);
    }//GEN-LAST:event_jBtnEliminarActionPerformed


    private void initUi()
    {
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
    private javax.swing.JComboBox<String> jCbxTipoInstitucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtDireccion;
    private javax.swing.JTextField jTxtId;
    private javax.swing.JTextField jTxtNombreInstitucion;
    private javax.swing.JFormattedTextField jTxtTelefono;
    // End of variables declaration//GEN-END:variables
}
