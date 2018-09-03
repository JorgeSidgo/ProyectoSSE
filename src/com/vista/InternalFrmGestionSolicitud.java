
package com.vista;

import com.dao.DaoSolicitud;
import com.modelo.Solicitud;
import java.util.List;
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
    
    public InternalFrmGestionSolicitud() {
        initComponents();
    }
    
    private void llenarTabla()
    {
        String[] col = {"ID Solicitud","Estudiante","Coordinador","Institución","Fecha","Comentarios"};
        Object[] obj = new Object[6];
        DefaultTableModel df = new DefaultTableModel();
        List ls;
        
        try 
        {
            DaoSolicitud daoS = new DaoSolicitud();
            ls = daoS.supermostrar();
            
            for (int i = 0; i < ls.size(); i++) {
                so = (Solicitud)ls.get(i);
                obj[0] = so.getId();
                obj[1] = so.getNombreEstudiante();
                obj[2] = so.getNombreCoordinador();
                obj[3] = so.getIdInstitucion();
                obj[4] = so.getFecha();
                obj[5] = so.getComentarios();
                df.addRow(obj);
            }
            this.jTablaSolicitud.setModel(df);
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se puede comenzar a llenar la tabla "+e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxAObservaciones = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaSolicitud = new javax.swing.JTable();
        jTxtIdE = new javax.swing.JTextField();
        jTxtIdCo = new javax.swing.JTextField();
        jTxtIdIns = new javax.swing.JTextField();
        jTxtFecha = new javax.swing.JTextField();

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
                .addContainerGap(714, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 151, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Estudiante");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Coordinador");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Institución");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Fecha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Estado de la Solicitud");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox1.setText("Aprobada");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, 20));

        jCheckBox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox2.setText("Denegada");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, 20));

        jCheckBox3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox3.setText("Observaciones");
        getContentPane().add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, 20));

        jTxAObservaciones.setColumns(20);
        jTxAObservaciones.setRows(5);
        jScrollPane1.setViewportView(jTxAObservaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 210, 200));

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
        jScrollPane2.setViewportView(jTablaSolicitud);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 470, 130));

        jTxtIdE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtIdE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 30));

        jTxtIdCo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtIdCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 140, 30));

        jTxtIdIns.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtIdIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, 30));

        jTxtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaSolicitud;
    private javax.swing.JTextArea jTxAObservaciones;
    private javax.swing.JTextField jTxtFecha;
    private javax.swing.JTextField jTxtIdCo;
    private javax.swing.JTextField jTxtIdE;
    private javax.swing.JTextField jTxtIdIns;
    // End of variables declaration//GEN-END:variables
}
