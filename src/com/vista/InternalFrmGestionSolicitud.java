
package com.vista;

import com.dao.DaoCoordinador;
import com.dao.DaoEstudiante;
import com.dao.DaoInstitucion;
import com.dao.DaoSolicitud;
import com.modelo.Solicitud;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Nombre de la Clase: InternalFrmGestionSolicitud
 * Version: 1.0
 * Fecha: 02-09-2018
 * CopyRight: ITCA FEPADE
 * @author Javier Montoya
 */
public class InternalFrmGestionSolicitud extends javax.swing.JInternalFrame {
    
    Solicitud so = new Solicitud();
    DaoSolicitud daoS = new DaoSolicitud();
    DaoInstitucion daoI = new DaoInstitucion();
    DaoEstudiante daoE = new DaoEstudiante();
    DaoCoordinador daoC = new DaoCoordinador();
    
    public InternalFrmGestionSolicitud() {
        initComponents();
        this.llenarTabla();
        this.jTxAObservaciones.hide();
        this.idSolicitud.hide();
        this.jPanelSolicitud.hide();
        this.disabledC();
    }
    
    private void disabledC()
    {
        this.jTxtEstado.enable(false);
        this.jTxtIdE.enable(false);
        this.jTxtIdCo.enable(false);
        this.jTxtIdIns.enable(false);
        this.jTxtFecha.enable(false);
        
        this.jBtnUpd.hide();
        this.jBtnDlt.hide();
    }
    
    private void enabledC()
    {
        this.jBtnUpd.show();
        this.jBtnDlt.show();
    }
    
    private void cleanC()
    {
        this.idSolicitud.setText("");
        this.jTxtIdIns.setText("");
        this.jTxtIdE.setText("");
        this.jTxtIdCo.setText("");
        this.jTxtFecha.setText("");
        this.jTxtEstado.setText("");
        
        this.jChkAprobada.setSelected(false);
        this.jChkDenegada.setSelected(false);
        this.jChkObser.setSelected(false);
    }
    
    private void llenarTabla()
    {
        String[] col = {"ID Solicitud","Estado de Solicitud","Estudiante","Coordinador","Institución","Fecha","Comentarios"};
        Object[] obj = new Object[7];
        DefaultTableModel df = new DefaultTableModel(null, col);
        List ls;
        
        try 
        {
            ls = daoS.mostrarSolicitud();
            
            for (int i = 0; i < ls.size(); i++) {
                so = (Solicitud)ls.get(i);
                obj[0] = so.getId();
                obj[1] = so.getEstadoSolicitud();
                obj[2] = daoE.nombreEstudiante(so.getIdEstudiante());
                obj[3] = daoC.nombreCoordinador(so.getIdCoordinador());
                obj[4] = daoI.nombreInstitucion(so.getIdInstitucion());
                obj[5] = so.getFecha();
                obj[6] = so.getComentarios();
                df.addRow(obj);
            }
            this.jTablaSolicitud.setModel(df);
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se puede comenzar a llenar la tabla "+e.getMessage());
        }
    }
    
    private void llenarCampos()
    {
        int Fila = this.jTablaSolicitud.getSelectedRow();
        
        if (Fila > -1) {
            String estado = this.jTxtEstado.getText();
            
            this.idSolicitud.setText(String.valueOf(this.jTablaSolicitud.getValueAt(Fila, 0))); //aqui tengo guardado el id de la solicitud
            this.jTxtEstado.setText(String.valueOf(this.jTablaSolicitud.getValueAt(Fila, 1)));
            this.jTxtIdE.setText(String.valueOf(this.jTablaSolicitud.getValueAt(Fila, 2)));
            this.jTxtIdCo.setText(String.valueOf(this.jTablaSolicitud.getValueAt(Fila, 3)));
            this.jTxtIdIns.setText(String.valueOf(this.jTablaSolicitud.getValueAt(Fila, 4)));
            this.jTxtFecha.setText(String.valueOf(this.jTablaSolicitud.getValueAt(Fila, 5)));
            this.jTxAObservaciones.setText(String.valueOf(this.jTablaSolicitud.getValueAt(Fila, 6)));
            
            if (estado == "aprobada") {
                this.jChkAprobada.setSelected(true);
            }else if(estado == "negada"){
                this.jChkDenegada.setSelected(true);
            }else if(estado == "observaciones"){
                this.jChkObser.setSelected(true);
            }
        }
    }
    
    private void actualizarSolicitud(int id)
    {
        if (this.jChkAprobada.isSelected() || this.jChkDenegada.isSelected() || this.jChkObser.isSelected()) {
            if (this.jChkAprobada.isSelected()) {
                so.setId(id);
                so.setEstadoSolicitud("aprobada");
                so.setComentarios("");
            }else if(this.jChkDenegada.isSelected()){
                so.setId(id);
                so.setEstadoSolicitud("negada");
                so.setComentarios("");
            }else if(this.jChkObser.isSelected()){
                so.setId(id);
                so.setEstadoSolicitud("observaciones");
                so.setComentarios(this.jTxAObservaciones.getText());
            }
            
            int SioNo = JOptionPane.showConfirmDialog(this, "Desea modificar la Solicitud", "Actualizar Solicitud", JOptionPane.YES_NO_OPTION);
            if (SioNo == 0) {
                daoS.updSolicitud(so);
            }else{
                this.cleanC();
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un estado para guardar la solicitud");
        }
    }
    
    private void insertarSolicitud()
    {
        //JOptionPane.showMessageDialog(null, "Empleado Guardado Exitosamente", "Actualizacion Correcta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void eliminarSolicitud(int id)
    {
        int SioNo = JOptionPane.showConfirmDialog(this, "Desea eliminar la Solicitud", "Eliminar Solicitud", JOptionPane.YES_NO_OPTION);
        
        if (SioNo==0) {
            daoS.dltSolicitud(id);
        }else{
            this.cleanC();
            this.jPanelSolicitud.hide();
            this.jBtnUpd.hide();
            this.jBtnDlt.hide();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxAObservaciones = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaSolicitud = new javax.swing.JTable();
        jTxtIdE = new javax.swing.JTextField();
        jTxtIdCo = new javax.swing.JTextField();
        jTxtIdIns = new javax.swing.JTextField();
        jTxtFecha = new javax.swing.JTextField();
        jBtnUpd = new javax.swing.JButton();
        jBtnDlt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        idSolicitud = new javax.swing.JLabel();
        jPanelSolicitud = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jChkDenegada = new javax.swing.JCheckBox();
        jChkObser = new javax.swing.JCheckBox();
        jChkAprobada = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTxtEstado = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Gestión Solicitud");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Gestión de Solicitud");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(814, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 151, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Estudiante");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Coordinador");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Institución");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        jTxAObservaciones.setColumns(20);
        jTxAObservaciones.setRows(5);
        jScrollPane1.setViewportView(jTxAObservaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 210, 180));

        jTablaSolicitud.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaSolicitudMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaSolicitud);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 710, 130));

        jTxtIdE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtIdE, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 140, 30));

        jTxtIdCo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtIdCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, 30));

        jTxtIdIns.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtIdIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 140, 30));

        jTxtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 140, 30));

        jBtnUpd.setText("Actualizar");
        jBtnUpd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnUpdMouseClicked(evt);
            }
        });
        getContentPane().add(jBtnUpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 84, -1, -1));

        jBtnDlt.setText("Eliminar");
        jBtnDlt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDltMouseClicked(evt);
            }
        });
        getContentPane().add(jBtnDlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 111, 79, -1));

        jButton3.setText("Agregar Solicitud ");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 140, -1, 34));

        idSolicitud.setText("idSolicitud");
        getContentPane().add(idSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Estado de la Solicitud");

        buttonGroup1.add(jChkDenegada);
        jChkDenegada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jChkDenegada.setText("Denegada");
        jChkDenegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkDenegadaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jChkObser);
        jChkObser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jChkObser.setText("Observaciones");
        jChkObser.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChkObserStateChanged(evt);
            }
        });

        buttonGroup1.add(jChkAprobada);
        jChkAprobada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jChkAprobada.setText("Aprobada");

        javax.swing.GroupLayout jPanelSolicitudLayout = new javax.swing.GroupLayout(jPanelSolicitud);
        jPanelSolicitud.setLayout(jPanelSolicitudLayout);
        jPanelSolicitudLayout.setHorizontalGroup(
            jPanelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSolicitudLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSolicitudLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkDenegada)
                            .addComponent(jChkObser)
                            .addComponent(jChkAprobada)))
                    .addComponent(jLabel7))
                .addContainerGap())
        );
        jPanelSolicitudLayout.setVerticalGroup(
            jPanelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSolicitudLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jChkAprobada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jChkDenegada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jChkObser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Estado de Solicitud");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jTxtEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChkDenegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkDenegadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChkDenegadaActionPerformed

    private void jTablaSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaSolicitudMouseClicked
        this.llenarCampos();
        this.jPanelSolicitud.show();
        this.enabledC();
    }//GEN-LAST:event_jTablaSolicitudMouseClicked

    private void jChkObserStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChkObserStateChanged
        if (this.jChkObser.isSelected()) {
            this.jTxAObservaciones.show();
        }else if (!this.jChkObser.isSelected()) {
            this.jTxAObservaciones.hide();
        }
    }//GEN-LAST:event_jChkObserStateChanged

    private void jBtnUpdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnUpdMouseClicked
       this.actualizarSolicitud(Integer.parseInt(this.idSolicitud.getText()));
       this.llenarTabla();
    }//GEN-LAST:event_jBtnUpdMouseClicked

    private void jBtnDltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnDltMouseClicked
        this.eliminarSolicitud(Integer.parseInt(this.idSolicitud.getText()));
        this.llenarTabla();
    }//GEN-LAST:event_jBtnDltMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        JDesktopPane desktop = new JDesktopPane();
        InternalFrmIngresarSolicitud frm = new InternalFrmIngresarSolicitud();
        desktop.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel idSolicitud;
    private javax.swing.JButton jBtnDlt;
    private javax.swing.JButton jBtnUpd;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jChkAprobada;
    private javax.swing.JCheckBox jChkDenegada;
    private javax.swing.JCheckBox jChkObser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelSolicitud;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaSolicitud;
    private javax.swing.JTextArea jTxAObservaciones;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtFecha;
    private javax.swing.JTextField jTxtIdCo;
    private javax.swing.JTextField jTxtIdE;
    private javax.swing.JTextField jTxtIdIns;
    // End of variables declaration//GEN-END:variables
}
