
package com.vista;

import com.dao.DaoEstudiante;
import com.dao.DaoUsuario;
import com.reporte.Reportes;
import com.utilidades.Console;
import com.utilidades.UITools;
import com.utilidades.Validacion;
import static com.vista.FrmPrincipalx.ii;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jsidg
 */
public class FrmPrincipal extends javax.swing.JFrame implements KeyListener
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
        this.menuBar.setVisible(false);
        addKeyListener(this);
    }
    
    DaoEstudiante estu= new DaoEstudiante();
    
    private void reporteParametrizado(String estado){
        
        Map parametro = new HashMap();
        parametro.put("estado", estado);
        
        JasperReport reporte;
        
        try
        {
            estu.conectar();
            reporte = JasperCompileManager.compileReport("src/com/reporte/ReporteSolicitud.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(reporte, parametro, estu.getCon());
            JasperViewer.viewReport(jp, false);
            
        } catch (Exception e)
        {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error papu: " + e.getMessage());
        }
        finally
        {
            estu.desconectar();
        }
        
    }
    
    private void logout(){
        try
        {
            int opcion = JOptionPane.showConfirmDialog(this, "Los cambios sin guardar se perderán", "¿Desea cerrar sesión?", JOptionPane.YES_NO_OPTION);
            
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
    }
    UITools ui = new UITools();
    Reportes rep = new Reportes();
    Validacion val = new Validacion();
    
    boolean ctrl=false, vki=false, vku=false, vkj=false, vkq=false;
    
    private static boolean menArchivo = false;
    private static boolean menSS = false;
    private static boolean menReportes = false;
    private static boolean maximizado = false;
    private static boolean menu = false;
    private static boolean barraNombre = false;
    private static Timer timer;
    private int xx;
    private int xy;
    static ImageIcon ii;
    JLabel dropSS = new JLabel();
    JLabel dropArchivo = new JLabel();
    JLabel dropReportes = new JLabel();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenuItem4 = new javax.swing.JMenuItem();
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
        menuReportes = new javax.swing.JLabel();
        menuPapelera = new javax.swing.JLabel();
        panelReportes = new javax.swing.JPanel();
        menuItReporteEstudiantes = new javax.swing.JLabel();
        menuItReporteSoliAprobadas = new javax.swing.JLabel();
        menuItReporteSoliDenegadas = new javax.swing.JLabel();
        menuItReporteUsuarios = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        keysInstituciones = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
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

        jMenuItem4.setText("jMenuItem4");

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
            .addComponent(lblIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        menuLogout.setToolTipText("Ctrl + Q");
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
        menuItInstituciones.setToolTipText("Mayus + Shift + I");
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
        menuItServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_Add_File_16px.png"))); // NOI18N
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

        menuReportes.setBackground(new java.awt.Color(36, 37, 38));
        menuReportes.setDisplayedMnemonic('n');
        menuReportes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuReportes.setForeground(new java.awt.Color(255, 255, 255));
        menuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-books-16.png"))); // NOI18N
        menuReportes.setText("Reportes");
        menuReportes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        menuReportes.setIconTextGap(10);
        menuReportes.setOpaque(true);
        menuReportes.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuReportesMouseClicked(evt);
            }
        });

        menuPapelera.setBackground(new java.awt.Color(36, 37, 38));
        menuPapelera.setDisplayedMnemonic('n');
        menuPapelera.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuPapelera.setForeground(new java.awt.Color(255, 255, 255));
        menuPapelera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-trash-16.png"))); // NOI18N
        menuPapelera.setText("Papelera");
        menuPapelera.setToolTipText("Ctrl + J");
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

        panelReportes.setBackground(new java.awt.Color(54, 56, 57));

        menuItReporteEstudiantes.setBackground(new java.awt.Color(54, 56, 57));
        menuItReporteEstudiantes.setDisplayedMnemonic('n');
        menuItReporteEstudiantes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItReporteEstudiantes.setForeground(new java.awt.Color(255, 255, 255));
        menuItReporteEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8-student-male-16.png"))); // NOI18N
        menuItReporteEstudiantes.setText("Estudiantes");
        menuItReporteEstudiantes.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItReporteEstudiantes.setIconTextGap(10);
        menuItReporteEstudiantes.setOpaque(true);
        menuItReporteEstudiantes.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItReporteEstudiantesMouseClicked(evt);
            }
        });

        menuItReporteSoliAprobadas.setBackground(new java.awt.Color(54, 56, 57));
        menuItReporteSoliAprobadas.setDisplayedMnemonic('n');
        menuItReporteSoliAprobadas.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItReporteSoliAprobadas.setForeground(new java.awt.Color(255, 255, 255));
        menuItReporteSoliAprobadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_Check_File_16px.png"))); // NOI18N
        menuItReporteSoliAprobadas.setText("Solicitudes Aprobadas");
        menuItReporteSoliAprobadas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItReporteSoliAprobadas.setIconTextGap(10);
        menuItReporteSoliAprobadas.setOpaque(true);
        menuItReporteSoliAprobadas.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItReporteSoliAprobadasMouseClicked(evt);
            }
        });

        menuItReporteSoliDenegadas.setBackground(new java.awt.Color(54, 56, 57));
        menuItReporteSoliDenegadas.setDisplayedMnemonic('n');
        menuItReporteSoliDenegadas.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItReporteSoliDenegadas.setForeground(new java.awt.Color(255, 255, 255));
        menuItReporteSoliDenegadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_Delete_File_16px.png"))); // NOI18N
        menuItReporteSoliDenegadas.setText("Solicitudes Negadas");
        menuItReporteSoliDenegadas.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItReporteSoliDenegadas.setIconTextGap(10);
        menuItReporteSoliDenegadas.setOpaque(true);
        menuItReporteSoliDenegadas.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItReporteSoliDenegadasMouseClicked(evt);
            }
        });

        menuItReporteUsuarios.setBackground(new java.awt.Color(54, 56, 57));
        menuItReporteUsuarios.setDisplayedMnemonic('n');
        menuItReporteUsuarios.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        menuItReporteUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        menuItReporteUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iconos/icons8_User_Folder_16px.png"))); // NOI18N
        menuItReporteUsuarios.setText("Reporte de Usuarios");
        menuItReporteUsuarios.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0)));
        menuItReporteUsuarios.setIconTextGap(10);
        menuItReporteUsuarios.setOpaque(true);
        menuItReporteUsuarios.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                menuItReporteUsuariosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelReportesLayout = new javax.swing.GroupLayout(panelReportes);
        panelReportes.setLayout(panelReportesLayout);
        panelReportesLayout.setHorizontalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuItReporteEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuItReporteSoliAprobadas, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuItReporteSoliDenegadas, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuItReporteUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        panelReportesLayout.setVerticalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesLayout.createSequentialGroup()
                .addComponent(menuItReporteEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuItReporteSoliAprobadas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuItReporteSoliDenegadas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuItReporteUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

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
            .addComponent(menuReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(menuPapelera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(panelReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(menuReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(menuPapelera, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menuLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");
        fileMenu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fileMenuActionPerformed(evt);
            }
        });

        keysInstituciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        keysInstituciones.setMnemonic('o');
        keysInstituciones.setText("Instituciones");
        keysInstituciones.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                keysInstitucionesActionPerformed(evt);
            }
        });
        fileMenu.add(keysInstituciones);

        jMenu1.setText("Servicio social");

        jMenuItem6.setText("Registrar Servicio social");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Solvencia");
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Solicitudes");
        jMenu1.add(jMenuItem8);

        fileMenu.add(jMenu1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Gestion de usuarios");
        fileMenu.add(jMenuItem5);

        jMenu2.setText("Reportes");
        fileMenu.add(jMenu2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Papelera");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem3);
        fileMenu.add(jSeparator1);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Cerrar sesion");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
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

        setJMenuBar(menuBar);

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
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)))
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
        logout();
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
    
    
    private void abrirInstituciones()
    {
        InternalFrmInstitucion frm = new InternalFrmInstitucion();
        abrirVentana(frm);
    }
    
    private void menuItInstitucionesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItInstitucionesMouseClicked
    {//GEN-HEADEREND:event_menuItInstitucionesMouseClicked
        abrirInstituciones();
    }//GEN-LAST:event_menuItInstitucionesMouseClicked

    private void menuUsuariosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuUsuariosMouseClicked
    {//GEN-HEADEREND:event_menuUsuariosMouseClicked
        InternalFrmUsuarios frm = new InternalFrmUsuarios();
        abrirVentana(frm);
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
        InternalFrmHoja frm = new InternalFrmHoja();
        abrirVentana(frm);
    }//GEN-LAST:event_menuItServicioMouseClicked

    private void menuItSolvenciaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItSolvenciaMouseClicked
    {//GEN-HEADEREND:event_menuItSolvenciaMouseClicked
        InternalFrmSolvencias frm = new InternalFrmSolvencias();
        abrirVentana(frm);
    }//GEN-LAST:event_menuItSolvenciaMouseClicked

    private void menuItSolicitudesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItSolicitudesMouseClicked
    {//GEN-HEADEREND:event_menuItSolicitudesMouseClicked
        InternalFrmGestionSolicitud frm = new InternalFrmGestionSolicitud();
        abrirVentana(frm);
    }//GEN-LAST:event_menuItSolicitudesMouseClicked

    private void menuReportesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuReportesMouseClicked
    {//GEN-HEADEREND:event_menuReportesMouseClicked
        if(!menReportes)
        {
        panelReportes.setVisible(true);
        dropReportes.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-up-16.png")));
        menReportes = true;
        }
        else
        {
        panelReportes.setVisible(false);
        dropReportes.setIcon(new ImageIcon(getClass().getResource("../iconos/icons8-chevron-down-16.png")));
        menReportes = false;
        }
    }//GEN-LAST:event_menuReportesMouseClicked

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fileMenuActionPerformed
    {//GEN-HEADEREND:event_fileMenuActionPerformed
        
    }//GEN-LAST:event_fileMenuActionPerformed

    private void keysInstitucionesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_keysInstitucionesActionPerformed
    {//GEN-HEADEREND:event_keysInstitucionesActionPerformed
        abrirInstituciones();
    }//GEN-LAST:event_keysInstitucionesActionPerformed

    private void menuPapeleraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPapeleraMouseClicked
        InternalFrmPapelera fr= new InternalFrmPapelera();
        abrirVentana(fr);
    }//GEN-LAST:event_menuPapeleraMouseClicked

    private void menuItReporteEstudiantesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItReporteEstudiantesMouseClicked
    {//GEN-HEADEREND:event_menuItReporteEstudiantesMouseClicked
      InternalFrmEstudiante est= new InternalFrmEstudiante();
        abrirVentana(est);
        
    }//GEN-LAST:event_menuItReporteEstudiantesMouseClicked

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAsMenuItemActionPerformed
    {//GEN-HEADEREND:event_saveAsMenuItemActionPerformed
        logout();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem6ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem6ActionPerformed
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem3ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem3ActionPerformed
        InternalFrmPapelera papeles= new InternalFrmPapelera();
        abrirVentana(papeles);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItReporteSoliAprobadasMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItReporteSoliAprobadasMouseClicked
    {//GEN-HEADEREND:event_menuItReporteSoliAprobadasMouseClicked
        reporteParametrizado("Aprobado");
    }//GEN-LAST:event_menuItReporteSoliAprobadasMouseClicked

    private void menuItReporteSoliDenegadasMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItReporteSoliDenegadasMouseClicked
    {//GEN-HEADEREND:event_menuItReporteSoliDenegadasMouseClicked
        reporteParametrizado("Negado");
    }//GEN-LAST:event_menuItReporteSoliDenegadasMouseClicked

    private void menuItReporteUsuariosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_menuItReporteUsuariosMouseClicked
    {//GEN-HEADEREND:event_menuItReporteUsuariosMouseClicked
         JasperReport reporte;
        
        try
        {
            estu.conectar();
            reporte = JasperCompileManager.compileReport("src/com/reporte/ReporteUsers.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(reporte, null, estu.getCon());
            JasperViewer.viewReport(jp, false);
            
        } catch (Exception e)
        {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error papu: " + e.getMessage());
        }
        finally
        {
            estu.desconectar();
        }
    }//GEN-LAST:event_menuItReporteUsuariosMouseClicked

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
        panelReportes.setVisible(false);
        ui.flatLabel(lblMin, "#CCCCCC", "#B7B7B7", "#A3A3A3");
        ui.flatLabel(lblMax, "#CCCCCC", "#B7B7B7", "#A3A3A3");
        ui.flatLabel(lblX, "#CCCCCC", "#E81123", "#DC5C66");
        ui.flatLabel(lblMenu, "#D74738", "#B03A2E", "#EC7063");
        ui.lblIcon(lblX, "../vista/x.png", "../vista/xW.png");
        ui.flatLabel(menuArchivo, "#242526", "#2D2E2F", "#111111");
        ui.menuClass(menuArchivo, dropArchivo, 1);
        ui.flatLabel(menuSS, "#242526", "#2D2E2F", "#111111");
        ui.menuClass(menuSS, dropSS, 2);
        ui.flatLabel(menuLogout, "#242526", "#D74738", "#E74C3C");
        ui.menusitos(menuLogout, 2, 10, false);
        ui.flatLabel(menuUsuarios, "#242526", "#2D2E2F", "#111111");
        ui.menusitos(menuUsuarios, 2, 10, false);
        ui.flatLabel(menuItInstituciones, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItInstituciones, 2, 20, true);
        ui.flatLabel(menuItServicio, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItServicio, 2, 20, true);
        ui.flatLabel(menuItSolvencia, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItSolvencia, 2, 20, true);
        ui.flatLabel(menuItSolicitudes, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItSolicitudes, 2, 20, true);
        ui.flatLabel(menuReportes,"#242526", "#2D2E2F", "#111111");
        ui.menuClass(menuReportes,dropReportes, 2);
        ui.flatLabel(menuPapelera,"#242526", "#2D2E2F", "#111111");
        ui.menusitos(menuPapelera, 1, 10, false);
        ui.flatLabel(menuItReporteEstudiantes, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItReporteEstudiantes, 2, 20, true);
        ui.flatLabel(menuItReporteSoliAprobadas, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItReporteSoliAprobadas, 2, 20, true);
        ui.flatLabel(menuItReporteSoliDenegadas, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItReporteSoliDenegadas, 2, 20, true);
        ui.flatLabel(menuItReporteUsuarios, "#363839", "#111111", "#2c3e50");
        ui.menusitos(menuItReporteUsuarios, 2, 20, true);
        if((DaoUsuario.codRol != 1) && (DaoUsuario.codRol != 2))
        {
            menuUsuarios.setVisible(false);
        }
        
        if((DaoUsuario.codRol != 4))
        {
            menuSS.setVisible(false);
        }

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel jTitleBar;
    private javax.swing.JMenuItem keysInstituciones;
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
    private javax.swing.JLabel menuItReporteEstudiantes;
    private javax.swing.JLabel menuItReporteSoliAprobadas;
    private javax.swing.JLabel menuItReporteSoliDenegadas;
    private javax.swing.JLabel menuItReporteUsuarios;
    private javax.swing.JLabel menuItServicio;
    private javax.swing.JLabel menuItSolicitudes;
    private javax.swing.JLabel menuItSolvencia;
    private javax.swing.JLabel menuLogout;
    private javax.swing.JLabel menuPapelera;
    private javax.swing.JLabel menuReportes;
    private javax.swing.JLabel menuSS;
    private javax.swing.JLabel menuUsuarios;
    private javax.swing.JPanel panelArchivo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JPanel panelSS;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_ALT:
                if(!this.menuBar.isVisible()){
                    this.menuBar.setVisible(true);
                }else{
                    this.menuBar.setVisible(false);
                }
                break;
            case KeyEvent.VK_CONTROL:
                ctrl=true;
                break;
            case KeyEvent.VK_J:
                vkj=true;
                break;
            case KeyEvent.VK_I:
                vki=true;
                break;
            case KeyEvent.VK_U:
                vku=true;
                break;
            case KeyEvent.VK_Q:
                vkq=true;
                break;
        }
        
        if(ctrl&&vkq){
            ctrl=false;
            vkq=false;
            logout();
        }
        
        if(ctrl&&vkj){
            ctrl=false;
            vkj=false;
            InternalFrmPapelera fr= new InternalFrmPapelera();
            abrirVentana(fr);
        }
        
        if(ctrl&&vki){
            ctrl=false;
            vki=false;
            abrirInstituciones();
        }
        
        if(ctrl&&vku){
            ctrl=false;
            vku=false;
            InternalFrmUsuarios frm = new InternalFrmUsuarios();
            abrirVentana(frm);
        } 
        
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        switch(keyCode){
            
            case KeyEvent.VK_CONTROL:
                ctrl=false;
                break;
            case KeyEvent.VK_J:
                vkj=false;
                break;
            case KeyEvent.VK_I:
                vki=false;
                break;
            case KeyEvent.VK_U:
                vku=false;
                break;
            case KeyEvent.VK_Q:
                vkq=false;
                break;
        }
    }

}
