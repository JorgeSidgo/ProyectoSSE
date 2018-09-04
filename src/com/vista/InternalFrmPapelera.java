/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.dao.DaoInstitucion;
import com.dao.DaoUsuario;
import com.modelo.Institucion;
import com.modelo.Usuario;
import com.utilidades.Console;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rocke
 */
public class InternalFrmPapelera extends javax.swing.JInternalFrame
{

    DaoInstitucion inst =new DaoInstitucion();
    DaoUsuario user = new DaoUsuario();
    
    public InternalFrmPapelera()
    {
        initComponents();
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(false);
        tabla(inst.papelera());
        this.jbtnSeleccionados.setEnabled(false);
    }
    
    private void comboTabla(){
         int indiceCombo=this.jComboBox1.getSelectedIndex();
         switch(indiceCombo){
            case 0: //institucion
                tabla(inst.papelera());
                break;
                
            case 1: //Usuario
                tabla(user.papelera());
                break;
        }
    }
    
 
    private boolean tabla(List datos)
    {
        String[]thead= (String[])datos.get(0);

        DefaultTableModel table=new DefaultTableModel(null,thead);
        String[]fila;
        for (int i = 1; i < datos.size(); i++)
        {
            this.jButton1.setEnabled(true);
            this.jButton2.setEnabled(true);
            fila= (String[])datos.get(i);
            table.addRow(fila);
        }
        this.jTable1.setModel(table);
        return (datos.size()==1)?false:true;
        
    }
    
    private int[] selecionadosID(){
  
        int[] valor = this.jTable1.getSelectedRows();

        int selected= this.jTable1.getSelectedRowCount();
        int[] ids=new int[selected];

        for (int i = 0; i < selected; i++)
        {
            ids[i]= Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i+1, 0)));
        }
        
        return ids;
    }
    
    private int[] todosID(){
        int n = this.jTable1.getRowCount();
        int[] ids=new int[n];

        for (int i = 0; i < n; i++)
        {
            ids[i]= Integer.parseInt(String.valueOf(this.jTable1.getValueAt(i, 0)));
        }
        
        return ids;
    }
    
    private void deleteUser(int x){
        Usuario u =new Usuario(x);
        user.eliminarUsuario(u);
    }
    
    private void restUser(int x){
        
        user.restaurar(x);
    }
    
    private void clearAll(){
        int[] todo= todosID();
        
        int indiceCombo=this.jComboBox1.getSelectedIndex();
        switch(indiceCombo){
            case 0: //institucion
                break;
                
            case 1: //Usuario
                for (int i = 0; i < todo.length; i++)
                {
                    deleteUser(todo[i]);
                }
                break;
        }
    }
    
    private void restaurarAll(){
        int[] todo= todosID();
        
        int indiceCombo=this.jComboBox1.getSelectedIndex();
        switch(indiceCombo){
            case 0: //institucion
                for (int i = 0; i < todo.length; i++)
                {
                    inst.restaurar(todo[i]);
                }
                break;
                
            case 1: //Usuario
                for (int i = 0; i < todo.length; i++)
                {
                    restUser(todo[i]);
                }
                break;
        }
    }
    
    private void restaurarNotAll(){
        int[] todo= selecionadosID();
        
        int indiceCombo=this.jComboBox1.getSelectedIndex();
        switch(indiceCombo){
            case 0: //institucion
                for (int i = 0; i < todo.length; i++)
                {
                    inst.restaurar(todo[i]);
                }
                break;
                
            case 1: //Usuario
                for (int i = 0; i < todo.length; i++)
                {
                    restUser(todo[i]);
                }
                break;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbtnSeleccionados = new javax.swing.JButton();

        setClosable(true);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Registros");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Instituciones", "Usuarios" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jComboBox1MouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-trash-16.png"))); // NOI18N
        jButton1.setText("Vaciar papelera");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Restaurar todos los registros");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButton2MouseClicked(evt);
            }
        });

        jbtnSeleccionados.setText("Restaurar registros seleccionados");
        jbtnSeleccionados.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jbtnSeleccionadosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnSeleccionados))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jbtnSeleccionados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jComboBox1MouseClicked
    {//GEN-HEADEREND:event_jComboBox1MouseClicked
        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jComboBox1ItemStateChanged
    {//GEN-HEADEREND:event_jComboBox1ItemStateChanged
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.jbtnSeleccionados.setEnabled(false);
        int valu= this.jComboBox1.getSelectedIndex();
        if(valu==0){
            tabla(inst.papelera());
        }else{
            tabla(user.papelera());
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jbtnSeleccionadosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jbtnSeleccionadosMouseClicked
    {//GEN-HEADEREND:event_jbtnSeleccionadosMouseClicked
        restaurarNotAll();
        comboTabla();
    }//GEN-LAST:event_jbtnSeleccionadosMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
        if(this.jTable1.getSelectedRow()==-1){
            this.jbtnSeleccionados.setEnabled(false);
        }else{
            this.jbtnSeleccionados.setEnabled(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton1MouseClicked
    {//GEN-HEADEREND:event_jButton1MouseClicked
        if(JOptionPane.showConfirmDialog(null, "Está seguro que sea vaciar la papelera?")==0){
            clearAll();
            comboTabla();
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton2MouseClicked
    {//GEN-HEADEREND:event_jButton2MouseClicked
        restaurarAll();
        comboTabla();
        
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnSeleccionados;
    // End of variables declaration//GEN-END:variables
}
