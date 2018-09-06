
package com.vista;

import com.dao.DaoCoordinador;
import com.dao.DaoEstudiante;
import com.dao.DaoInstitucion;
import com.dao.DaoSolicitud;
import com.modelo.Estudiante;
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
    Estudiante es = new Estudiante();
    
    public InternalFrmGestionSolicitud() {
        initComponents();
        this.llenarTabla();
        this.jTxAObservaciones.hide();
        this.idSolicitud.hide();
        this.jPanelSolicitud.hide();
        this.disabledC();
        jTxtBuscar.setText("Buscar por Nombre de Estudiante");
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
    private void buscarSolicitud(String buscar)
    {
        int longitud = buscar.length();
        if((buscar != "Buscar por Nombre de Usuario") && (longitud > 1))
        {
            llenarBusqueda();
        }
        else if((buscar != "Buscar por Nombre de Usuario") && (longitud == 0))
        {
            llenarTabla();
        }
    }
    
    private void llenarBusqueda()
    {
        String[] col = {"ID Solicitud","Estado de Solicitud","Estudiante","Coordinador","Institución","Fecha","Comentarios"};
        Object[] obj = new Object[7];
        DefaultTableModel df = new DefaultTableModel(null, col);
        List ls;
        es.setNombres(this.jTxtBuscar.getText());
        
        try 
        {
            ls = daoS.buscarSolicitud(es);
            
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxAObservaciones = new javax.swing.JTextArea();
        jTxtIdE = new javax.swing.JTextField();
        jTxtIdCo = new javax.swing.JTextField();
        jTxtIdIns = new javax.swing.JTextField();
        jTxtFecha = new javax.swing.JTextField();
        idSolicitud = new javax.swing.JLabel();
        jPanelSolicitud = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jChkDenegada = new javax.swing.JCheckBox();
        jChkObser = new javax.swing.JCheckBox();
        jChkAprobada = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTxtEstado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaSolicitud = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jBtnUpd = new javax.swing.JButton();
        jBtnDlt = new javax.swing.JButton();
        jTxtBuscar = new javax.swing.JTextField();

        setBorder(null);
        setClosable(true);
        setTitle("Gestión Solicitud");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Estudiante");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Coordinador");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Institución");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Fecha");

        jTxAObservaciones.setColumns(20);
        jTxAObservaciones.setRows(5);
        jScrollPane1.setViewportView(jTxAObservaciones);

        jTxtIdE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTxtIdCo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTxtIdIns.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTxtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        idSolicitud.setText("idSolicitud");

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

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Estado de Solicitud");

        jTxtEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(36, 37, 38));

        jLabel1.setFont(new java.awt.Font("Product Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Solicitudes");
        jLabel1.setPreferredSize(new java.awt.Dimension(99, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jButton3.setText("Agregar Solicitud ");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jBtnUpd.setText("Actualizar");
        jBtnUpd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnUpdMouseClicked(evt);
            }
        });

        jBtnDlt.setText("Eliminar");
        jBtnDlt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDltMouseClicked(evt);
            }
        });

        jTxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnUpd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnDlt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTxtBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jBtnUpd)
                            .addComponent(jBtnDlt))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtIdE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(60, 60, 60)
                                .addComponent(jTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel2)))
                                .addGap(21, 21, 21)
                                .addComponent(jTxtIdCo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(37, 37, 37)
                                .addComponent(jTxtIdIns, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idSolicitud))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTxtIdE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel2))))
                                    .addComponent(jTxtIdCo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTxtIdIns, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(idSolicitud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrmIngresarSolicitud frm = new FrmIngresarSolicitud();
        frm.setLocationRelativeTo(this);
        frm.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTxtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtBuscarKeyTyped
        String buscar = this.jTxtBuscar.getText();
        this.buscarSolicitud(buscar);
    }//GEN-LAST:event_jTxtBuscarKeyTyped


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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelSolicitud;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaSolicitud;
    private javax.swing.JTextArea jTxAObservaciones;
    private javax.swing.JTextField jTxtBuscar;
    private javax.swing.JTextField jTxtEstado;
    private javax.swing.JTextField jTxtFecha;
    private javax.swing.JTextField jTxtIdCo;
    private javax.swing.JTextField jTxtIdE;
    private javax.swing.JTextField jTxtIdIns;
    // End of variables declaration//GEN-END:variables
}
