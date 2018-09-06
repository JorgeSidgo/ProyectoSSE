/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.dao.DaoCandidato;
import com.dao.DaoEstudiante;
import com.dao.DaoInstitucion;
import com.dao.DaoUsuario;
import com.modelo.Candidato;
import com.modelo.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ramirez
 */
public class InternalFrmSolvencias extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalFrmSolvencias
     */
    Usuario u = new Usuario();
    DaoUsuario daoU = new DaoUsuario();
    DaoCandidato daoC = new DaoCandidato();
    DaoEstudiante daoE = new DaoEstudiante();
    DaoInstitucion daI = new DaoInstitucion();
    Candidato c = new Candidato();
    
    String[] columnas = {"ID de Estudiante","Carnet","Nombres","Apellidos","Carrera","Grupo","Estado Servicio Social","Horas Realizadas"};
    DefaultTableModel tabla = new DefaultTableModel(null, columnas);
    TableRowSorter trs;
    
    public InternalFrmSolvencias() {
        initComponents();
        mostrarCandidatos();
        this.jBtnSolventar.setEnabled(false);
        this.jTxtIDEstudiante.setEnabled(false);
        this.jTxtCarnet.setEnabled(false);
        this.jTxtNombres.setEnabled(false);
        this.jTxtApellidos.setEnabled(false);
        this.jTxtCarrera.setEnabled(false);
        this.jTxtGrupo.setEnabled(false);
        this.jTxtNombreEstudiante.setEnabled(false);
        this.jTxtCarnetEstudiante.setEnabled(false);
        this.jTxtEstadoSS.setEnabled(false);
        this.jTxtHorasRealizadas.setEnabled(false);
    }
    
    public void mostrarCandidatos()
    {
        Object[] obj = new Object[8];
        List lista;
        try
        {
            lista = daoC.mostrarCandidatos();
            for (int i = 0; i < lista.size(); i++) 
            {
                c = (Candidato) lista.get(i);
                obj[0] = c.getId();
                obj[1] = c.getCarnet();
                obj[2] = c.getNombres();
                obj[3] = c.getApellidos();
                obj[4] = c.getCarrera();
                obj[5] = c.getGrupo();
                obj[6] = c.getEstadoSS();
                obj[7] = c.getnHoras();
                if (c.getId() != 0) {
                    tabla.addRow(obj);
                }
            }
            this.jTablaCandidatos.setModel(tabla);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al mostrar en tabla!!","Carga Fallida!! "+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarCandidatos()
    {
        String[] columnas = {"ID de Estudiante","Carnet","Nombres","Apellidos","Carrera","Grupo","Estado Servicio Social","Horas Realizadas"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        Object[] obj = new Object[8];
        List lista;
        try
        {
            lista = daoC.mostrarCandidatos();
            for (int i = 0; i < lista.size(); i++) 
            {
                c = (Candidato) lista.get(i);
                obj[0] = c.getId();
                obj[1] = c.getCarnet();
                obj[2] = c.getNombres();
                obj[3] = c.getApellidos();
                obj[4] = c.getCarrera();
                obj[5] = c.getGrupo();
                obj[6] = c.getEstadoSS();
                obj[7] = c.getnHoras();
                if (c.getId() != 0) {
                    tabla.addRow(obj);
                }
            }
            this.jTablaCandidatos.setModel(tabla);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al mostrar en tabla!!","Carga Fallida!! "+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarForm()
    {
        this.jBtnSolventar.setEnabled(true);
        int index = this.jTablaCandidatos.getSelectedRow();
        
        if (index>-1) {
            this.jTxtIDEstudiante.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 0)));
            this.jTxtCarnet.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 1)));
            this.jTxtNombres.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 2)));
            this.jTxtApellidos.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 3)));
            this.jTxtCarrera.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 4)));
            this.jTxtGrupo.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 5)));
            this.jTxtEstadoSS.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 6)));
            this.jTxtHorasRealizadas.setText(String.valueOf(this.jTablaCandidatos.getValueAt(index, 7)));
        }
    }
    
    public void limpiar()
    {
        this.jTxtCarnetEstudiante.setText("");
        this.jTxtNombreEstudiante.setText("");
    }
    
    public void limpiarCandidato()
    {
        this.jTxtIDEstudiante.setText("");
        this.jTxtCarnet.setText("");
        this.jTxtNombres.setText("");
        this.jTxtApellidos.setText("");
        this.jTxtCarrera.setText("");
        this.jTxtGrupo.setText("");
        this.jTxtEstadoSS.setText("");
        this.jTxtHorasRealizadas.setText("");
        this.jBtnSolventar.setEnabled(false);
    }
    
    private void insertarSolvencia()
    {
        try 
        {
            int idEs = Integer.parseInt(this.jTxtIDEstudiante.getText());
        
            daoE.solventar(idEs);
            JOptionPane.showMessageDialog(null, "Estudiante Solventado en sus horas sociales!!");
            actualizarCandidatos();
            limpiarCandidato();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error al solventar estudiante");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelBusqueda = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTxtCarnetEstudiante = new javax.swing.JTextField();
        jTxtNombreEstudiante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRbBuscarNombre = new javax.swing.JRadioButton();
        jRbBuscarID = new javax.swing.JRadioButton();
        jPanelCandidato = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTxtIDEstudiante = new javax.swing.JTextField();
        jTxtCarnet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtCarrera = new javax.swing.JTextField();
        jTxtNombres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxtApellidos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtGrupo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jBtnLimpiarCandidato = new javax.swing.JButton();
        jBtnSolventar = new javax.swing.JButton();
        jTxtHorasRealizadas = new javax.swing.JTextField();
        jTxtEstadoSS = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaCandidatos = new javax.swing.JTable();

        setBorder(null);
        setClosable(true);
        setTitle("Gestión de Solvencia");

        jPanel1.setBackground(new java.awt.Color(36, 37, 38));

        jLabel1.setFont(new java.awt.Font("Product Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Solvencias");
        jLabel1.setPreferredSize(new java.awt.Dimension(99, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(986, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Busque el estudiante que desea solventar en su servicio social:");

        jPanelBusqueda.setBackground(new java.awt.Color(250, 250, 250));

        jLabel3.setText("Carnet del Estudiante");

        jTxtCarnetEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCarnetEstudianteKeyTyped(evt);
            }
        });

        jTxtNombreEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNombreEstudianteKeyTyped(evt);
            }
        });

        jLabel4.setText("Nombre de Estudiante:");

        buttonGroup1.add(jRbBuscarNombre);
        jRbBuscarNombre.setText("Buscar por Nombre");
        jRbBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbBuscarNombreActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRbBuscarID);
        jRbBuscarID.setText("Buscar por Carnet");
        jRbBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbBuscarIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBusquedaLayout = new javax.swing.GroupLayout(jPanelBusqueda);
        jPanelBusqueda.setLayout(jPanelBusquedaLayout);
        jPanelBusquedaLayout.setHorizontalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRbBuscarNombre)
                    .addComponent(jLabel4)
                    .addComponent(jTxtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTxtCarnetEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRbBuscarID))
                .addContainerGap(386, Short.MAX_VALUE))
        );
        jPanelBusquedaLayout.setVerticalGroup(
            jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCarnetEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRbBuscarNombre)
                    .addComponent(jRbBuscarID))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelCandidato.setBackground(new java.awt.Color(250, 250, 250));
        jPanelCandidato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setText("ID del Estudiante:");

        jLabel6.setText("Carnet: ");

        jLabel7.setText("Carrera:");

        jLabel10.setText("Apellidos:");

        jLabel11.setText("Grupo:");

        jLabel12.setText("Nombres:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Candidato Seleccionado:");

        jBtnLimpiarCandidato.setBackground(new java.awt.Color(127, 140, 141));
        jBtnLimpiarCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/EraseTool_203.png"))); // NOI18N
        jBtnLimpiarCandidato.setText("Limpiar");
        jBtnLimpiarCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLimpiarCandidatoActionPerformed(evt);
            }
        });

        jBtnSolventar.setBackground(new java.awt.Color(255, 0, 0));
        jBtnSolventar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/yes-icon.png"))); // NOI18N
        jBtnSolventar.setText("Solventar");
        jBtnSolventar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSolventarActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado Servicio Social");

        jLabel15.setText("Horas Realizadas:");

        javax.swing.GroupLayout jPanelCandidatoLayout = new javax.swing.GroupLayout(jPanelCandidato);
        jPanelCandidato.setLayout(jPanelCandidatoLayout);
        jPanelCandidatoLayout.setHorizontalGroup(
            jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCandidatoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jTxtIDEstudiante)
                    .addComponent(jTxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jTxtCarnet)
                    .addComponent(jTxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCandidatoLayout.createSequentialGroup()
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jTxtHorasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCandidatoLayout.createSequentialGroup()
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTxtEstadoSS, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnSolventar, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jBtnLimpiarCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCandidatoLayout.setVerticalGroup(
            jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCandidatoLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel9)
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(jPanelCandidatoLayout.createSequentialGroup()
                .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCandidatoLayout.createSequentialGroup()
                        .addContainerGap(87, Short.MAX_VALUE)
                        .addComponent(jBtnLimpiarCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jBtnSolventar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelCandidatoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtIDEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtEstadoSS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCandidatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtHorasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Seleccione entre los resultados el candidato que desea solventar:");

        jTablaCandidatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablaCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaCandidatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaCandidatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(208, 208, 208)
                    .addComponent(jPanelCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(316, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNombreEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNombreEstudianteKeyTyped
        jTxtNombreEstudiante.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+jTxtNombreEstudiante.getText(), 2));
            }
        });
        
        trs = new TableRowSorter(tabla);
        jTablaCandidatos.setRowSorter(trs);
    }//GEN-LAST:event_jTxtNombreEstudianteKeyTyped

    private void jTablaCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaCandidatosMouseClicked
        llenarForm();
    }//GEN-LAST:event_jTablaCandidatosMouseClicked

    private void jBtnLimpiarCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarCandidatoActionPerformed
        limpiarCandidato();
    }//GEN-LAST:event_jBtnLimpiarCandidatoActionPerformed

    private void jRbBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbBuscarNombreActionPerformed
        this.jTxtNombreEstudiante.setEnabled(true);
        this.jTxtCarnetEstudiante.setText("");
        this.jTxtCarnetEstudiante.setEnabled(false);
    }//GEN-LAST:event_jRbBuscarNombreActionPerformed

    private void jRbBuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbBuscarIDActionPerformed
        this.jTxtNombreEstudiante.setText("");
        this.jTxtNombreEstudiante.setEnabled(false);
        this.jTxtCarnetEstudiante.setEnabled(true);
    }//GEN-LAST:event_jRbBuscarIDActionPerformed

    private void jTxtCarnetEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCarnetEstudianteKeyTyped
        jTxtCarnetEstudiante.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+jTxtCarnetEstudiante.getText(), 1));
            }
        });
        
        trs = new TableRowSorter(tabla);
        jTablaCandidatos.setRowSorter(trs);
    }//GEN-LAST:event_jTxtCarnetEstudianteKeyTyped

    private void jBtnSolventarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSolventarActionPerformed
        insertarSolvencia();
    }//GEN-LAST:event_jBtnSolventarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnLimpiarCandidato;
    private javax.swing.JButton jBtnSolventar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBusqueda;
    private javax.swing.JPanel jPanelCandidato;
    private javax.swing.JRadioButton jRbBuscarID;
    private javax.swing.JRadioButton jRbBuscarNombre;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaCandidatos;
    private javax.swing.JTextField jTxtApellidos;
    private javax.swing.JTextField jTxtCarnet;
    private javax.swing.JTextField jTxtCarnetEstudiante;
    private javax.swing.JTextField jTxtCarrera;
    private javax.swing.JTextField jTxtEstadoSS;
    private javax.swing.JTextField jTxtGrupo;
    private javax.swing.JTextField jTxtHorasRealizadas;
    private javax.swing.JTextField jTxtIDEstudiante;
    private javax.swing.JTextField jTxtNombreEstudiante;
    private javax.swing.JTextField jTxtNombres;
    // End of variables declaration//GEN-END:variables
}
