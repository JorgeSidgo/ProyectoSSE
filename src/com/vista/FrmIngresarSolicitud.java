// simona
package com.vista;

import com.dao.DaoCoordinador;
import com.dao.DaoEstudiante;
import com.dao.DaoInstitucion;
import com.dao.DaoSolicitud;
import com.modelo.Coordinador;
import com.modelo.Institucion;
import com.modelo.Solicitud;
import com.utilidades.Console;
import com.utilidades.Validacion;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: FrmIngresarSolicitud
 * Versión: 1.0
 * Fecha: 5-9-18 
 * Copyright: ITCA FEPADE
 * @author Javier Montoya
 */
public class FrmIngresarSolicitud extends javax.swing.JFrame {
    
    Solicitud so = new Solicitud();
    DaoSolicitud daoS = new DaoSolicitud();
    DaoInstitucion daoI = new DaoInstitucion();
    DaoEstudiante daoE = new DaoEstudiante();
    DaoCoordinador daoC = new DaoCoordinador();
    Console console = new Console();
    Validacion v = new Validacion();
    
    
    public FrmIngresarSolicitud() {
        initComponents();
        this.jLabelEstudiante.setVisible(false);
        this.cargarCoordinador();
        this.cargarInstitucion();
        this.jlabelCom.setVisible(false);
        this.jTxtComentarios.setVisible(false);
    }
   
    /*Variables*/
    private List listaCoordinador;
    private List listaInsti;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtEstudiante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtFecha = new javax.swing.JFormattedTextField();
        jlabelCom = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtComentarios = new javax.swing.JTextArea();
        jBtnIngresar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jLabelEstudiante = new javax.swing.JLabel();
        jComboEstado = new javax.swing.JComboBox<>();
        jChkObser = new javax.swing.JCheckBox();
        jComboCoordinador = new javax.swing.JComboBox<>();
        jComboInsti = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Solicitud");
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Ingresar Solicitud");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Estado ");

        jLabel3.setText("Carnet del Estudiante");

        jTxtEstudiante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtEstudianteFocusLost(evt);
            }
        });

        jLabel4.setText("Coordinador");

        jLabel5.setText("Institución");

        jLabel6.setText("Fecha");

        jTxtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("####-##-##"))));
        jTxtFecha.setText("2018-09-05");

        jlabelCom.setText("Comentarios");

        jTxtComentarios.setColumns(20);
        jTxtComentarios.setRows(5);
        jScrollPane1.setViewportView(jTxtComentarios);

        jBtnIngresar.setText("Ingresar Solicitud");
        jBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresarActionPerformed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jLabelEstudiante.setText("jLabel8");

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprobada", "No Aprobada" }));

        jChkObser.setText("Observaciones");
        jChkObser.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChkObserStateChanged(evt);
            }
        });

        jComboCoordinador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jComboInsti.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnIngresar)
                                    .addComponent(jBtnCancelar))
                                .addGap(162, 162, 162))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboEstado, 0, 138, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jChkObser)
                                        .addGap(60, 60, 60))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboCoordinador, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTxtEstudiante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelEstudiante)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabelCom)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jChkObser))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTxtEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelEstudiante))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboCoordinador, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jComboInsti, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabelCom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jBtnIngresar)
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancelar)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtEstudianteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtEstudianteFocusLost
        this.validarEstudiante(this.jTxtEstudiante.getText());
    }//GEN-LAST:event_jTxtEstudianteFocusLost

    private void jChkObserStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChkObserStateChanged
        
        if (jChkObser.isSelected()) {
            this.jlabelCom.setVisible(true);
            this.jTxtComentarios.setVisible(true);
        }else{
            this.jTxtComentarios.setVisible(false);
            this.jlabelCom.setVisible(false);
        }
    }//GEN-LAST:event_jChkObserStateChanged

    private void jBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresarActionPerformed
       int c = this.camposVacios();
       if(c==0)
       {
           this.insertarSolicitud();
       }else if(c!=0)
       {
           JOptionPane.showMessageDialog(null, "Debe completar todos los campos requeridos");
       }
    }//GEN-LAST:event_jBtnIngresarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_jBtnCancelarActionPerformed
    
    private void insertarSolicitud()
    {
        try 
        {
            daoS.insSolicitud(this.capturar());
            //JOptionPane.showMessageDialog(null, "Se ha insertado la solicitud", "Resultado de la Inserción", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            //JOptionPane.showMessageDialog(null, "No se ha insertado la solicitud", "Resultado de la Inserción", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    private Solicitud capturar()
    {
       int estado = this.jComboEstado.getSelectedIndex();
       
       int id = daoS.idEstudiante(this.jTxtEstudiante.getText());
       so.setIdEstudiante(id);
       
       if(estado==0)
       {
          so.setEstadoSolicitud("aprobada");
       }else if(estado==1)
       {
          so.setEstadoSolicitud("no aprobada");
       }
       
       Coordinador coordinador = (Coordinador)this.listaCoordinador.get(this.jComboCoordinador.getSelectedIndex());
       Institucion institucion = (Institucion)this.listaInsti.get(this.jComboInsti.getSelectedIndex());
       so.setIdCoordinador(coordinador.getIdCarrera());
       so.setIdInstitucion(institucion.getIdIns());
       so.setFecha(this.jTxtFecha.getText());
       so.setComentarios(this.jTxtComentarios.getText());
       return so;
    }
    
    private int camposVacios()
    {
        int contador = 0;
        
        try 
        {
            if (v.IsNullOrEmpty(jTxtEstudiante.getText().trim()))
            {
                contador++;
            }
            if (v.IsNullOrEmpty(jTxtFecha.getText().trim()))
            {
                contador++;
            }
            /*if(contador > 0)
            {
                JOptionPane.showMessageDialog(this, "Complete los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            }*/
        } 
        catch (Exception e) 
        {
            
        }
        
        return contador;
    }
    
    private void validarEstudiante(String carnet)
    {
        String nombres = "";
        
        try 
        {
            nombres = daoS.validarEst(carnet);
            if (nombres!="") {
                int opc = JOptionPane.showConfirmDialog(this, "El estudiante seleccionado es : " + nombres, "Confirmar Estudiante", JOptionPane.YES_NO_OPTION );
                if (opc==0) {
                    this.jLabelEstudiante.setVisible(true);
                    this.jLabelEstudiante.setText(nombres);
                    
                }else if(opc!=0){
                    //this.jTxtEstudiante.setFocusable(true);
                    this.jTxtEstudiante.setText("");
                }
            }else{
                this.jLabelEstudiante.setVisible(true);
                this.jLabelEstudiante.setText("El estudiante no se ha podido encontrar");
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se pudo evaluar si el estudiante existe");
        }
    }
    
    private void cargarCoordinador()
    {
        this.jComboCoordinador.removeAllItems();

        listaCoordinador = daoC.mostrarCoordinadores();
        Coordinador coordinador;

        for(Object item:listaCoordinador)
        {
            coordinador = (Coordinador) item;
            this.jComboCoordinador.addItem(coordinador.getNombres());
        }
        
    }
    
    private void limpiar()
    {
        this.jTxtEstudiante.setText("");
        this.jTxtFecha.setText("");
        this.jTxtComentarios.setText("");
    }
    
    private void cargarInstitucion()
    {
        this.jComboInsti.removeAllItems();
        
        listaInsti = daoI.mostrarInstitucion();
        Institucion insti;

        for(Object item:listaInsti)
        {
            insti = (Institucion) item;
            this.jComboInsti.addItem(insti.getNombreIns());
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmIngresarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmIngresarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmIngresarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIngresarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmIngresarSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnIngresar;
    private javax.swing.JCheckBox jChkObser;
    private javax.swing.JComboBox<String> jComboCoordinador;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JComboBox<String> jComboInsti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelEstudiante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxtComentarios;
    private javax.swing.JTextField jTxtEstudiante;
    private javax.swing.JFormattedTextField jTxtFecha;
    private javax.swing.JLabel jlabelCom;
    // End of variables declaration//GEN-END:variables
}
//lamona
