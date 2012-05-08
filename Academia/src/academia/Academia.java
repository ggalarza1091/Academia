package academia;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.sql.*;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Academia extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;
    Connection con;
    CallableStatement cst;
    ResultSet r;
    Calendar c = Calendar.getInstance();
String D,M,A;
boolean ctrl,ctrlm;
boolean registrarA,registrarAD,registrarD,buscaasistencia;
boolean RModificar,RRegistrar,alumno,administrativo,busqueda,busquedaadmi,busquedadoc;
int DayofWeek,WeekofMonth;
int ColumnAntAux,ColumnSigAux,MesAux,AAux;
int prueba,tablaMarcarAsistencia,tabladominio,tabladisponibilidad;
int hora,minutos;
String codigoRS,codigoRAcurso;
boolean Observacion;
private static FileNameExtensionFilter filter = new FileNameExtensionFilter(".jpg", new String[] { "JPG", "JPEG" });
String campos;
ImageIcon imagen = new ImageIcon("Icono.gif");
Image icono = imagen.getImage();
    public Academia() {
        initComponents();
        this.setIconImage(icono);
        RModificar=false;
        Observacion=false;
        alumno=false;
        administrativo=false;
        busqueda=false;
        busquedaadmi=false;
        buscaasistencia=false;
        try {
            FileWriter f = new FileWriter("ActualizarCurso.txt");
            FileWriter g = new FileWriter("ActualizarDocente.txt");
            FileWriter h = new FileWriter("ActualizarServicio.txt");
            FileWriter l = new FileWriter("EnviarSalon.txt");
            FileWriter m = new FileWriter("ActualizarAsesoria.txt");
            FileWriter n = new FileWriter("ActualizarCursoDominio.txt");
            FileWriter p = new FileWriter("Disponibilidad.txt");
            FileWriter q = new FileWriter("Disponibilidadextra.txt");
            FileWriter r = new FileWriter("ActualizarParticular.txt");
        } catch (IOException ex) {Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        }
        catch(Exception e){}
        setLocationRelativeTo(null);
        this.setTitle("Academia Club de Matematicas Jaque Mate");
        D=Integer.toString(c.get(Calendar.DATE));
        M=Integer.toString(c.get(Calendar.MONTH));
        A=Integer.toString(c.get(Calendar.YEAR));
        MesAux=Integer.parseInt(M);
        AAux=Integer.parseInt(A);
        DayofWeek=c.get(Calendar.DAY_OF_WEEK);
        cambiodedia();
        WeekofMonth=c.get(Calendar.WEEK_OF_MONTH);
        
        lblAsistenciaAlumno.setVisible(false);
        tblAsistencia.setVisible(false);
        ScrollAsistencia.setVisible(false);
        txtCodigo.setVisible(false);
        lblCodigo.setVisible(false);
        txtNombreAsis.setVisible(false);
        lblNombreAsis.setVisible(false);
        txtApellidoPatAsis.setVisible(false);
        btnRegresar.setVisible(false);
        lblApellidoPatAsis.setVisible(false);
        txtApellidoMatAsis.setVisible(false);
        lblApellidoMatAsis.setVisible(false);
        lblMes.setVisible(false);
        
        btnRegresarD.setVisible(false);
        btnLimpiar.setVisible(false);
        btnAnterior.setVisible(false);
        btnSiguiente.setVisible(false);
        btnActual.setVisible(false);
        lblAsistenciaAlumno.setVisible(false);
        lblAsistenciaAdministrativo.setVisible(false);
        lblNNombreD.setVisible(false);
        txtRNombre.setVisible(false);
        lblNApellidoPatD.setVisible(false);
        txtRApellidoPat.setVisible(false);
        lblNApellidoMatD.setVisible(false);
        txtRApellidoMat.setVisible(false);
        lblNNacimientoD.setVisible(false);
        txtRNacimiento1.setVisible(false);
        txtRNacimiento2.setVisible(false);
        txtRNacimiento3.setVisible(false);
        lblNDireccionD.setVisible(false);
        txtRDireccion1.setVisible(false);
        txtRDireccion2.setVisible(false);
        lblNTelefonoD.setVisible(false);
        txtRTelefono.setVisible(false);
        lblNCorreoD.setVisible(false);
        txtRCorreo.setVisible(false);
        lblRuc.setVisible(false);
        txtRuc.setVisible(false);
        lblNSueldoHoraD.setVisible(false);
        txtSueldoAcademia.setVisible(false);
        lblServicio.setVisible(false);
        btnNRegistrarD.setVisible(false);
        lblAApoderado.setVisible(false);
        txtRApoderado.setVisible(false);
        lblAGS.setVisible(false);
        txtAGS.setVisible(false);
        lblANivelAcademico.setVisible(false);
        cbxANivelAcademico.setVisible(false);
        cbxRPago.setVisible(false);
        lblRPago.setVisible(false);
        lblSueldoAcademia.setVisible(false);
        lblSueldoAsesoria.setVisible(false);
        txtSueldoAsesoria.setVisible(false);
        txtPagoAdmi.setVisible(false);
        txtServicio.setVisible(false);
        btnServicio.setVisible(false);
        cbxServicio.setVisible(false);
        lblCargo.setVisible(false);
        txtCargo.setVisible(false);
        btnAbrirFoto.setVisible(false);
        txtRFoto.setVisible(false);
        pnlFoto.setVisible(false);
        jDesktopPane1.setVisible(false);
        lblCurso.setVisible(false);
        txtCurso.setVisible(false);
        btnCurso.setVisible(false);
        sclDominioCursos.setVisible(false);
        btnDominioCursos.setVisible(false);
        tblDominioCursos.setVisible(false);
        lblDominioCursos.setVisible(false);
        btnRLimpiar.setVisible(false);
        btnTest.setVisible(false);
        btnObservacion.setVisible(false);
        txtRDireccion1.setVisible(false);
        txtRDireccion2.setVisible(false);
        lblDisponibilidad.setVisible(false);
        btnDisponibilidad.setVisible(false);
        sclDisponibilidad.setVisible(false);
        tblDisponibilidad.setVisible(false);
        lblRPagoAlumno.setVisible(false);
        txtRPagoAlumno.setVisible(false);
        btnBuscar.setVisible(false);
        lblRegresar.setVisible(false);
        lblRegistrar.setVisible(false);
        lblLimpiar.setVisible(false);
        lblSLimpiar.setVisible(false);
        lblAsisRegresar.setVisible(false);
        lblAsisLimpiar.setVisible(false);
        lblAsisAnterior.setVisible(false);
        lblAsisSiguiente.setVisible(false);
        lblAsisActual.setVisible(false);
        lblAsisServicio.setVisible(false);
        txtAsisServicio.setVisible(false);
        btnAsisServicio.setVisible(false);
        cbxAsisServ.setVisible(false);
        cbxMAHora.setVisible(false);
        cbxMATipoS.setVisible(false);
        lblFechaI.setVisible(false);
        txtFechaI1.setVisible(false);
        txtFechaI2.setVisible(false);
        txtFechaI3.setVisible(false);
        lblTest.setVisible(false);
        lblObservacion.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filechooser = new javax.swing.JFileChooser();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        pnlPestanas = new javax.swing.JTabbedPane();
        pnlBienvenido = new javax.swing.JPanel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        FondoB = new javax.swing.JLabel();
        pnlRegistro = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        btnRAlumnos = new javax.swing.JButton();
        lblRTitulo = new javax.swing.JLabel();
        btnRDocente = new javax.swing.JButton();
        btnRegresarD = new javax.swing.JButton();
        lblNNombreD = new javax.swing.JLabel();
        lblNSueldoHoraD = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        lblNApellidoMatD = new javax.swing.JLabel();
        lblNApellidoPatD = new javax.swing.JLabel();
        lblNDireccionD = new javax.swing.JLabel();
        lblNTelefonoD = new javax.swing.JLabel();
        lblNCorreoD = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        txtRNombre = new javax.swing.JTextField();
        txtRApellidoPat = new javax.swing.JTextField();
        txtRApellidoMat = new javax.swing.JTextField();
        txtRDireccion1 = new javax.swing.JTextField();
        txtRTelefono = new javax.swing.JTextField();
        txtRCorreo = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtRDireccion2 = new javax.swing.JTextField();
        txtSueldoAcademia = new javax.swing.JTextField();
        btnNRegistrarD = new javax.swing.JButton();
        lblNNacimientoD = new javax.swing.JLabel();
        txtRNacimiento1 = new javax.swing.JTextField();
        btnRAdministrativa = new javax.swing.JButton();
        lblAApoderado = new javax.swing.JLabel();
        lblAGS = new javax.swing.JLabel();
        txtAGS = new javax.swing.JTextField();
        txtRApoderado = new javax.swing.JTextField();
        lblANivelAcademico = new javax.swing.JLabel();
        cbxANivelAcademico = new javax.swing.JComboBox();
        cbxRPago = new javax.swing.JComboBox();
        lblRPago = new javax.swing.JLabel();
        lblSueldoAcademia = new javax.swing.JLabel();
        lblSueldoAsesoria = new javax.swing.JLabel();
        txtSueldoAsesoria = new javax.swing.JTextField();
        txtPagoAdmi = new javax.swing.JTextField();
        btnServicio = new javax.swing.JButton();
        txtServicio = new javax.swing.JTextField();
        cbxServicio = new javax.swing.JComboBox();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        btnAbrirFoto = new javax.swing.JButton();
        txtRFoto = new javax.swing.JTextField();
        pnlFoto = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnRLimpiar = new javax.swing.JButton();
        lblCurso = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        btnCurso = new javax.swing.JButton();
        sclDominioCursos = new javax.swing.JScrollPane();
        tblDominioCursos = new javax.swing.JTable();
        btnDominioCursos = new javax.swing.JButton();
        lblDominioCursos = new javax.swing.JLabel();
        txtRNacimiento2 = new javax.swing.JTextField();
        txtRNacimiento3 = new javax.swing.JTextField();
        btnObservacion = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        lblDisponibilidad = new javax.swing.JLabel();
        sclDisponibilidad = new javax.swing.JScrollPane();
        tblDisponibilidad = new javax.swing.JTable();
        btnDisponibilidad = new javax.swing.JButton();
        txtRPagoAlumno = new javax.swing.JTextField();
        lblRPagoAlumno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblRegresar = new javax.swing.JLabel();
        lblLimpiar = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        lblFechaI = new javax.swing.JLabel();
        txtFechaI1 = new javax.swing.JTextField();
        txtFechaI2 = new javax.swing.JTextField();
        txtFechaI3 = new javax.swing.JTextField();
        lblObservacion = new javax.swing.JLabel();
        lblTest = new javax.swing.JLabel();
        lblRAlumnos = new javax.swing.JLabel();
        lblDocentes = new javax.swing.JLabel();
        lblAdministrativa = new javax.swing.JLabel();
        pnlServicios = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        lblSServicio = new javax.swing.JLabel();
        cbxSServicio = new javax.swing.JComboBox();
        cbxSTipo = new javax.swing.JComboBox();
        lblSNombre = new javax.swing.JLabel();
        lblSApellidoPat = new javax.swing.JLabel();
        lblSApellidoMat = new javax.swing.JLabel();
        txtSNombre = new javax.swing.JTextField();
        txtSApellidoPat = new javax.swing.JTextField();
        txtSApellidoMat = new javax.swing.JTextField();
        lblSPrecio = new javax.swing.JLabel();
        txtSPrecio = new javax.swing.JTextField();
        lblSHoras = new javax.swing.JLabel();
        lblFechaClase = new javax.swing.JLabel();
        txtSHoras = new javax.swing.JTextField();
        txtSFechaClase1 = new javax.swing.JTextField();
        btnSRegistrar = new javax.swing.JButton();
        lblSEntrega = new javax.swing.JLabel();
        txtSEntrega1 = new javax.swing.JTextField();
        btnSSeleccionar = new javax.swing.JButton();
        lblSCurso = new javax.swing.JLabel();
        txtSCurso = new javax.swing.JTextField();
        lblSCAsignacion = new javax.swing.JLabel();
        txtSCAsignacion = new javax.swing.JTextField();
        lblSDocente = new javax.swing.JLabel();
        txtSDocente = new javax.swing.JTextField();
        btnSSDocente = new javax.swing.JButton();
        lblSCRealizacion = new javax.swing.JLabel();
        txtSCRealizacion = new javax.swing.JTextField();
        btnSLimpiar = new javax.swing.JButton();
        txtSFechaClase2 = new javax.swing.JTextField();
        txtSFechaClase3 = new javax.swing.JTextField();
        txtSEntrega2 = new javax.swing.JTextField();
        txtSEntrega3 = new javax.swing.JTextField();
        txtSDireccion1 = new javax.swing.JTextField();
        txtSDireccion2 = new javax.swing.JTextField();
        lblSDireccion = new javax.swing.JLabel();
        lblSPDocente = new javax.swing.JLabel();
        txtSPDocente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblSLimpiar = new javax.swing.JLabel();
        lblSRegistrar = new javax.swing.JLabel();
        pnlMAsistencia = new javax.swing.JPanel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        sclMAAsistencias = new javax.swing.JScrollPane();
        tblMAAsistencias = new javax.swing.JTable();
        cbxMA = new javax.swing.JComboBox();
        lblMA = new javax.swing.JLabel();
        lblMACiclo = new javax.swing.JLabel();
        txtMACiclo = new javax.swing.JTextField();
        btnMACiclo = new javax.swing.JButton();
        lblMATitulo = new javax.swing.JLabel();
        txtMACodigo = new javax.swing.JTextField();
        txtMAApellidoPat = new javax.swing.JTextField();
        txtMANombre = new javax.swing.JTextField();
        txtMAApellidoMat = new javax.swing.JTextField();
        txtMAIngresar = new javax.swing.JTextField();
        lblMAIngresar = new javax.swing.JLabel();
        lblMACodigo = new javax.swing.JLabel();
        lblMAApellidoPat = new javax.swing.JLabel();
        lblMANombre = new javax.swing.JLabel();
        lblMAApellidoMat = new javax.swing.JLabel();
        btnMAAEntrada = new javax.swing.JButton();
        btnMAAceptar = new javax.swing.JButton();
        btnMAGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxAsisServicio = new javax.swing.JComboBox();
        btnAsisBuscar = new javax.swing.JButton();
        cbxMAHora = new javax.swing.JComboBox();
        cbxMATipoS = new javax.swing.JComboBox();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        pnlAsistencia = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblAsistencia = new javax.swing.JLabel();
        btnAsistenciaAlumnos = new javax.swing.JButton();
        ScrollAsistencia = new javax.swing.JScrollPane();
        tblAsistencia = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombreAsis = new javax.swing.JLabel();
        txtNombreAsis = new javax.swing.JTextField();
        txtApellidoPatAsis = new javax.swing.JTextField();
        txtApellidoMatAsis = new javax.swing.JTextField();
        lblApellidoPatAsis = new javax.swing.JLabel();
        lblApellidoMatAsis = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAsistenciaAlumno = new javax.swing.JLabel();
        btnAsistenciaAdministrativa = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnActual = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblAsistenciaAdministrativo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAsisRegresar = new javax.swing.JLabel();
        lblAsisLimpiar = new javax.swing.JLabel();
        lblAsisAnterior = new javax.swing.JLabel();
        lblAsisSiguiente = new javax.swing.JLabel();
        lblAsisActual = new javax.swing.JLabel();
        btnAsisServicio = new javax.swing.JButton();
        lblAsisServicio = new javax.swing.JLabel();
        txtAsisServicio = new javax.swing.JTextField();
        cbxAsisServ = new javax.swing.JComboBox();
        lblMAAlumno = new javax.swing.JLabel();
        lblMAAdministrativa = new javax.swing.JLabel();
        btnAsisDocente = new javax.swing.JButton();
        lblAsisDocente = new javax.swing.JLabel();
        pnlBalance = new javax.swing.JPanel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        lblTIngresos = new javax.swing.JLabel();
        lblAsignacionesB = new javax.swing.JLabel();
        lblAsesoriaB = new javax.swing.JLabel();
        lblAcademiaB = new javax.swing.JLabel();
        lblDAcademiaB = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblParticularesB = new javax.swing.JLabel();
        btnIngresosB = new javax.swing.JButton();
        txtAcademiaB = new javax.swing.JFormattedTextField();
        txtAsesoriaB = new javax.swing.JFormattedTextField();
        txtParticularesB = new javax.swing.JFormattedTextField();
        txtTIngresosB = new javax.swing.JFormattedTextField();
        txtColaboradoresB = new javax.swing.JFormattedTextField();
        txtAsignacionesB = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMesB = new javax.swing.JTextField();
        txtAnoB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxBalances = new javax.swing.JComboBox();
        cbxTipoBalances = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fondoT = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecientes = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        MenuOpciones = new javax.swing.JMenu();
        menuInsertarCiclos = new javax.swing.JMenuItem();
        menuInsertarCurso = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        menuInsertarEvaluacion = new javax.swing.JMenuItem();
        menuInsertarNotas = new javax.swing.JMenuItem();
        menuInsertarSalones = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        manuModificarAdministrativo = new javax.swing.JMenuItem();
        menuModificarAlumno = new javax.swing.JMenuItem();
        menuModificarAsesorias = new javax.swing.JMenuItem();
        menuModificarAsignacion = new javax.swing.JMenuItem();
        menuModificarAsistencia = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuModificarCiclos = new javax.swing.JMenuItem();
        menuModificarParticular = new javax.swing.JMenuItem();
        menuModificarContrasena = new javax.swing.JMenuItem();
        menuModificarCursos = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        menuModificarDocente = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        menuModificarEvaluacion = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        menuModificarNotas = new javax.swing.JMenuItem();
        menuModificarSalones = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuListadoAdministrativos = new javax.swing.JMenuItem();
        menuListadoAlumnos = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        menuListadoCursos = new javax.swing.JMenuItem();
        menuListadoCiclos = new javax.swing.JMenuItem();
        menuListadoCicloCursos = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        menuListadoDocentes = new javax.swing.JMenuItem();
        menuListadoFaltantes = new javax.swing.JMenuItem();
        menuListadoNotas = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        menuDescuentos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        pnlPestanas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        pnlPestanas.setFont(new java.awt.Font("Arial", 0, 14));

        FondoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Bienvenidos.jpg"))); // NOI18N
        FondoB.setBounds(0, 0, 790, 610);
        jLayeredPane6.add(FondoB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlBienvenidoLayout = new javax.swing.GroupLayout(pnlBienvenido);
        pnlBienvenido.setLayout(pnlBienvenidoLayout);
        pnlBienvenidoLayout.setHorizontalGroup(
            pnlBienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        pnlBienvenidoLayout.setVerticalGroup(
            pnlBienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pnlPestanas.addTab("Bienvenido", pnlBienvenido);

        pnlRegistro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlRegistroAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        btnRAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/alumnos.png"))); // NOI18N
        btnRAlumnos.setContentAreaFilled(false);
        btnRAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAlumnosActionPerformed(evt);
            }
        });
        btnRAlumnos.setBounds(60, 220, 160, 150);
        jLayeredPane2.add(btnRAlumnos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblRTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/RegistroInicial.png"))); // NOI18N
        lblRTitulo.setBounds(240, 10, 280, 60);
        jLayeredPane2.add(lblRTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnRDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/docentes.png"))); // NOI18N
        btnRDocente.setText("Docentes");
        btnRDocente.setContentAreaFilled(false);
        btnRDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRDocenteActionPerformed(evt);
            }
        });
        btnRDocente.setBounds(550, 210, 180, 150);
        jLayeredPane2.add(btnRDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnRegresarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/regresar.png"))); // NOI18N
        btnRegresarD.setContentAreaFilled(false);
        btnRegresarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarDActionPerformed(evt);
            }
        });
        btnRegresarD.setBounds(30, 540, 90, 50);
        jLayeredPane2.add(btnRegresarD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNNombreD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNNombreD.setText("Nombre:");
        lblNNombreD.setBounds(30, 90, 110, 14);
        jLayeredPane2.add(lblNNombreD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNSueldoHoraD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNSueldoHoraD.setText("Pago por Hora:");
        lblNSueldoHoraD.setBounds(400, 80, 140, 20);
        jLayeredPane2.add(lblNSueldoHoraD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblServicio.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblServicio.setText("Servicios:");
        lblServicio.setBounds(400, 90, 100, 14);
        jLayeredPane2.add(lblServicio, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNApellidoMatD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNApellidoMatD.setText("Apellido Materno:");
        lblNApellidoMatD.setBounds(30, 150, 100, 14);
        jLayeredPane2.add(lblNApellidoMatD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNApellidoPatD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNApellidoPatD.setText("Apellido Paterno:");
        lblNApellidoPatD.setBounds(30, 120, 110, 14);
        jLayeredPane2.add(lblNApellidoPatD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNDireccionD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNDireccionD.setText("Direccion:");
        lblNDireccionD.setBounds(30, 210, 60, 14);
        jLayeredPane2.add(lblNDireccionD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNTelefonoD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNTelefonoD.setText("Telefono:");
        lblNTelefonoD.setBounds(30, 280, 150, 14);
        jLayeredPane2.add(lblNTelefonoD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNCorreoD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNCorreoD.setText("Correo:");
        lblNCorreoD.setBounds(30, 310, 70, 14);
        jLayeredPane2.add(lblNCorreoD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblRuc.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblRuc.setText("Ruc o Cuenta:");
        lblRuc.setBounds(30, 420, 100, 14);
        jLayeredPane2.add(lblRuc, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRNombreKeyTyped(evt);
            }
        });
        txtRNombre.setBounds(150, 80, 120, 30);
        jLayeredPane2.add(txtRNombre, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRApellidoPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRApellidoPatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRApellidoPatKeyTyped(evt);
            }
        });
        txtRApellidoPat.setBounds(150, 110, 120, 30);
        jLayeredPane2.add(txtRApellidoPat, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRApellidoMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRApellidoMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRApellidoMatKeyTyped(evt);
            }
        });
        txtRApellidoMat.setBounds(150, 140, 120, 30);
        jLayeredPane2.add(txtRApellidoMat, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRDireccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRDireccion1KeyReleased(evt);
            }
        });
        txtRDireccion1.setBounds(150, 200, 190, 30);
        jLayeredPane2.add(txtRDireccion1, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRTelefonoKeyTyped(evt);
            }
        });
        txtRTelefono.setBounds(150, 270, 120, 30);
        jLayeredPane2.add(txtRTelefono, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRCorreoKeyReleased(evt);
            }
        });
        txtRCorreo.setBounds(150, 300, 120, 30);
        jLayeredPane2.add(txtRCorreo, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        txtRuc.setBounds(150, 410, 120, 30);
        jLayeredPane2.add(txtRuc, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRDireccion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRDireccion2KeyReleased(evt);
            }
        });
        txtRDireccion2.setBounds(150, 230, 190, 30);
        jLayeredPane2.add(txtRDireccion2, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtSueldoAcademia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoAcademiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoAcademiaKeyTyped(evt);
            }
        });
        txtSueldoAcademia.setBounds(490, 110, 120, 30);
        jLayeredPane2.add(txtSueldoAcademia, javax.swing.JLayeredPane.PALETTE_LAYER);

        btnNRegistrarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Registrar.png"))); // NOI18N
        btnNRegistrarD.setContentAreaFilled(false);
        btnNRegistrarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNRegistrarDActionPerformed(evt);
            }
        });
        btnNRegistrarD.setBounds(230, 530, 90, 70);
        jLayeredPane2.add(btnNRegistrarD, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNNacimientoD.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNNacimientoD.setText("Fecha de Nacimiento: ");
        lblNNacimientoD.setBounds(30, 180, 130, 14);
        jLayeredPane2.add(lblNNacimientoD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtRNacimiento1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRNacimiento1FocusLost(evt);
            }
        });
        txtRNacimiento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRNacimiento1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRNacimiento1KeyTyped(evt);
            }
        });
        txtRNacimiento1.setBounds(150, 170, 40, 30);
        jLayeredPane2.add(txtRNacimiento1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnRAdministrativa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/administrativos.png"))); // NOI18N
        btnRAdministrativa.setContentAreaFilled(false);
        btnRAdministrativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAdministrativaActionPerformed(evt);
            }
        });
        btnRAdministrativa.setBounds(310, 210, 120, 150);
        jLayeredPane2.add(btnRAdministrativa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblAApoderado.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAApoderado.setText("Apoderado:");
        lblAApoderado.setBounds(30, 410, 110, 20);
        jLayeredPane2.add(lblAApoderado, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblAGS.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAGS.setText("Grupo Sanguineo");
        lblAGS.setBounds(30, 350, 110, 14);
        jLayeredPane2.add(lblAGS, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtAGS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAGSKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAGSKeyTyped(evt);
            }
        });
        txtAGS.setBounds(150, 340, 120, 30);
        jLayeredPane2.add(txtAGS, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRApoderadoKeyTyped(evt);
            }
        });
        txtRApoderado.setBounds(150, 410, 120, 30);
        jLayeredPane2.add(txtRApoderado, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblANivelAcademico.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblANivelAcademico.setText("Nivel Academico:");
        lblANivelAcademico.setBounds(30, 380, 130, 14);
        jLayeredPane2.add(lblANivelAcademico, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxANivelAcademico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Primaria", "Secundaria", "Pre-Universitario", "Universitario" }));
        cbxANivelAcademico.setBounds(150, 370, 120, 30);
        jLayeredPane2.add(cbxANivelAcademico, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxRPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione uno", "RUC", "Efectivo" }));
        cbxRPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxRPagoItemStateChanged(evt);
            }
        });
        cbxRPago.setBounds(150, 380, 120, 30);
        jLayeredPane2.add(cbxRPago, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblRPago.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblRPago.setText("Tipo de Pago:");
        lblRPago.setBounds(30, 380, 100, 30);
        jLayeredPane2.add(lblRPago, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSueldoAcademia.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSueldoAcademia.setText("Academia:");
        lblSueldoAcademia.setBounds(430, 120, 80, 14);
        jLayeredPane2.add(lblSueldoAcademia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSueldoAsesoria.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSueldoAsesoria.setText("Asesoria:");
        lblSueldoAsesoria.setBounds(430, 160, 70, 14);
        jLayeredPane2.add(lblSueldoAsesoria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSueldoAsesoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoAsesoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoAsesoriaKeyTyped(evt);
            }
        });
        txtSueldoAsesoria.setBounds(490, 150, 120, 30);
        jLayeredPane2.add(txtSueldoAsesoria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtPagoAdmi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoAdmiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoAdmiKeyTyped(evt);
            }
        });
        txtPagoAdmi.setBounds(490, 80, 120, 30);
        jLayeredPane2.add(txtPagoAdmi, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnServicio.setText("Seleccionar");
        btnServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicioActionPerformed(evt);
            }
        });
        btnServicio.setBounds(630, 110, 110, 30);
        jLayeredPane2.add(btnServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(490, 110, 120, 30);
        jLayeredPane2.add(txtServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria(DEATRE)" }));
        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });
        cbxServicio.setBounds(490, 80, 120, 30);
        jLayeredPane2.add(cbxServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblCargo.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCargo.setText("Cargo:");
        lblCargo.setBounds(400, 120, 140, 14);
        jLayeredPane2.add(lblCargo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCargoKeyTyped(evt);
            }
        });
        txtCargo.setBounds(490, 110, 120, 30);
        jLayeredPane2.add(txtCargo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAbrirFoto.setText("Abrir Foto");
        btnAbrirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFotoActionPerformed(evt);
            }
        });
        btnAbrirFoto.setBounds(630, 370, 110, 30);
        jLayeredPane2.add(btnAbrirFoto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtRFoto.setEditable(false);
        txtRFoto.setBounds(390, 240, 330, 30);
        jLayeredPane2.add(txtRFoto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnlFoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153)));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlFotoLayout = new javax.swing.GroupLayout(pnlFoto);
        pnlFoto.setLayout(pnlFotoLayout);
        pnlFotoLayout.setHorizontalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFotoLayout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFotoLayout.setVerticalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFotoLayout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFoto.setBounds(390, 300, 200, 190);
        jLayeredPane2.add(pnlFoto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnRLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/papelera.png"))); // NOI18N
        btnRLimpiar.setContentAreaFilled(false);
        btnRLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRLimpiarActionPerformed(evt);
            }
        });
        btnRLimpiar.setBounds(150, 520, 60, 80);
        jLayeredPane2.add(btnRLimpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblCurso.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCurso.setText("Curso:");
        lblCurso.setBounds(400, 150, 60, 14);
        jLayeredPane2.add(lblCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCurso.setEditable(false);
        txtCurso.setBounds(490, 140, 120, 30);
        jLayeredPane2.add(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCurso.setText("Curso");
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });
        btnCurso.setBounds(630, 143, 110, 30);
        jLayeredPane2.add(btnCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblDominioCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDominioCursos.getTableHeader().setReorderingAllowed(false);
        sclDominioCursos.setViewportView(tblDominioCursos);
        tblDominioCursos.getColumnModel().getColumn(0).setResizable(false);
        tblDominioCursos.getColumnModel().getColumn(1).setResizable(false);

        sclDominioCursos.setBounds(400, 230, 310, 90);
        jLayeredPane2.add(sclDominioCursos, javax.swing.JLayeredPane.MODAL_LAYER);

        btnDominioCursos.setText("Cursos");
        btnDominioCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDominioCursosActionPerformed(evt);
            }
        });
        btnDominioCursos.setBounds(550, 190, 110, 30);
        jLayeredPane2.add(btnDominioCursos, javax.swing.JLayeredPane.MODAL_LAYER);

        lblDominioCursos.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDominioCursos.setText("Cursos que domina:");
        lblDominioCursos.setBounds(400, 194, 130, 20);
        jLayeredPane2.add(lblDominioCursos, javax.swing.JLayeredPane.MODAL_LAYER);

        txtRNacimiento2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRNacimiento2FocusLost(evt);
            }
        });
        txtRNacimiento2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRNacimiento2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRNacimiento2KeyTyped(evt);
            }
        });
        txtRNacimiento2.setBounds(200, 170, 40, 30);
        jLayeredPane2.add(txtRNacimiento2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtRNacimiento3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRNacimiento3FocusLost(evt);
            }
        });
        txtRNacimiento3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRNacimiento3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRNacimiento3KeyTyped(evt);
            }
        });
        txtRNacimiento3.setBounds(250, 170, 50, 30);
        jLayeredPane2.add(txtRNacimiento3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/observacion.png"))); // NOI18N
        btnObservacion.setContentAreaFilled(false);
        btnObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionActionPerformed(evt);
            }
        });
        btnObservacion.setBounds(570, 520, 90, 50);
        jLayeredPane2.add(btnObservacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/test.png"))); // NOI18N
        btnTest.setContentAreaFilled(false);
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });
        btnTest.setBounds(450, 510, 80, 70);
        jLayeredPane2.add(btnTest, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblDisponibilidad.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDisponibilidad.setText("Disponibilidad:");
        lblDisponibilidad.setBounds(400, 330, 90, 30);
        jLayeredPane2.add(lblDisponibilidad, javax.swing.JLayeredPane.PALETTE_LAYER);

        tblDisponibilidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dia", "Hora Entrada", "Hora Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDisponibilidad.getTableHeader().setReorderingAllowed(false);
        sclDisponibilidad.setViewportView(tblDisponibilidad);
        tblDisponibilidad.getColumnModel().getColumn(0).setResizable(false);
        tblDisponibilidad.getColumnModel().getColumn(1).setResizable(false);
        tblDisponibilidad.getColumnModel().getColumn(2).setResizable(false);

        sclDisponibilidad.setBounds(400, 360, 320, 100);
        jLayeredPane2.add(sclDisponibilidad, javax.swing.JLayeredPane.PALETTE_LAYER);

        btnDisponibilidad.setText("Disponibilidad");
        btnDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibilidadActionPerformed(evt);
            }
        });
        btnDisponibilidad.setBounds(550, 330, 110, 30);
        jLayeredPane2.add(btnDisponibilidad, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtRPagoAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRPagoAlumnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRPagoAlumnoKeyTyped(evt);
            }
        });
        txtRPagoAlumno.setBounds(150, 450, 120, 30);
        jLayeredPane2.add(txtRPagoAlumno, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblRPagoAlumno.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblRPagoAlumno.setText("Pago por Servicio:");
        lblRPagoAlumno.setBounds(30, 450, 110, 30);
        jLayeredPane2.add(lblRPagoAlumno, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoT.jpg"))); // NOI18N
        jLabel1.setBounds(0, 0, 790, 610);
        jLayeredPane2.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblRegresar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblRegresar.setText("Regresar");
        lblRegresar.setBounds(50, 560, 60, 10);
        jLayeredPane2.add(lblRegresar, javax.swing.JLayeredPane.POPUP_LAYER);

        lblLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblLimpiar.setText("Limpiar");
        lblLimpiar.setBounds(160, 560, 50, 14);
        jLayeredPane2.add(lblLimpiar, javax.swing.JLayeredPane.POPUP_LAYER);

        lblRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblRegistrar.setText("Registrar");
        lblRegistrar.setBounds(240, 550, 100, 30);
        jLayeredPane2.add(lblRegistrar, javax.swing.JLayeredPane.POPUP_LAYER);

        lblFechaI.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblFechaI.setText("Fecha de Inicio:");
        lblFechaI.setBounds(390, 190, 90, 30);
        jLayeredPane2.add(lblFechaI, javax.swing.JLayeredPane.POPUP_LAYER);

        txtFechaI1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaI1FocusLost(evt);
            }
        });
        txtFechaI1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaI1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaI1KeyTyped(evt);
            }
        });
        txtFechaI1.setBounds(490, 190, 40, 30);
        jLayeredPane2.add(txtFechaI1, javax.swing.JLayeredPane.POPUP_LAYER);

        txtFechaI2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaI2FocusLost(evt);
            }
        });
        txtFechaI2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaI2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaI2KeyTyped(evt);
            }
        });
        txtFechaI2.setBounds(540, 190, 40, 30);
        jLayeredPane2.add(txtFechaI2, javax.swing.JLayeredPane.POPUP_LAYER);

        txtFechaI3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaI3FocusLost(evt);
            }
        });
        txtFechaI3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaI3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaI3KeyTyped(evt);
            }
        });
        txtFechaI3.setBounds(590, 190, 60, 30);
        jLayeredPane2.add(txtFechaI3, javax.swing.JLayeredPane.POPUP_LAYER);

        lblObservacion.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblObservacion.setText("Observacion");
        lblObservacion.setBounds(580, 570, 90, 30);
        jLayeredPane2.add(lblObservacion, javax.swing.JLayeredPane.DRAG_LAYER);

        lblTest.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblTest.setText("Test");
        lblTest.setBounds(470, 580, 48, 14);
        jLayeredPane2.add(lblTest, javax.swing.JLayeredPane.DRAG_LAYER);

        lblRAlumnos.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblRAlumnos.setText("Alumnos");
        lblRAlumnos.setBounds(110, 360, 70, 20);
        jLayeredPane2.add(lblRAlumnos, javax.swing.JLayeredPane.POPUP_LAYER);

        lblDocentes.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDocentes.setText("Docentes");
        lblDocentes.setBounds(610, 360, 70, 20);
        jLayeredPane2.add(lblDocentes, javax.swing.JLayeredPane.POPUP_LAYER);

        lblAdministrativa.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAdministrativa.setText("Administrativa");
        lblAdministrativa.setBounds(340, 360, 110, 20);
        jLayeredPane2.add(lblAdministrativa, javax.swing.JLayeredPane.POPUP_LAYER);

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pnlPestanas.addTab("Registro", pnlRegistro);

        pnlServicios.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlServiciosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ServiciosInicial.png"))); // NOI18N
        jLabel7.setBounds(230, 10, 300, 60);
        jLayeredPane4.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSServicio.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSServicio.setText("Tipo de Servicio:");
        lblSServicio.setBounds(20, 90, 120, 14);
        jLayeredPane4.add(lblSServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxSServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Clases Particulares", "Trabajos/Informes" }));
        cbxSServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSServicioItemStateChanged(evt);
            }
        });
        cbxSServicio.setBounds(140, 80, 130, 30);
        jLayeredPane4.add(cbxSServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxSTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Interno", "Externo" }));
        cbxSTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSTipoItemStateChanged(evt);
            }
        });
        cbxSTipo.setBounds(140, 120, 130, 30);
        jLayeredPane4.add(cbxSTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSNombre.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSNombre.setText("Nombre:");
        lblSNombre.setBounds(20, 170, 80, 14);
        jLayeredPane4.add(lblSNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSApellidoPat.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSApellidoPat.setText("Apellido Paterno:");
        lblSApellidoPat.setBounds(20, 200, 130, 14);
        jLayeredPane4.add(lblSApellidoPat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSApellidoMat.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSApellidoMat.setText("Apellido Materno:");
        lblSApellidoMat.setBounds(20, 230, 140, 14);
        jLayeredPane4.add(lblSApellidoMat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSNombreKeyTyped(evt);
            }
        });
        txtSNombre.setBounds(140, 160, 130, 27);
        jLayeredPane4.add(txtSNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSApellidoPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSApellidoPatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSApellidoPatKeyTyped(evt);
            }
        });
        txtSApellidoPat.setBounds(140, 190, 130, 27);
        jLayeredPane4.add(txtSApellidoPat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSApellidoMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSApellidoMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSApellidoMatKeyTyped(evt);
            }
        });
        txtSApellidoMat.setBounds(140, 220, 130, 27);
        jLayeredPane4.add(txtSApellidoMat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSPrecio.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSPrecio.setText("Precio:");
        lblSPrecio.setBounds(340, 210, 90, 14);
        jLayeredPane4.add(lblSPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSPrecioKeyTyped(evt);
            }
        });
        txtSPrecio.setBounds(450, 200, 120, 30);
        jLayeredPane4.add(txtSPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSHoras.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSHoras.setText("Horas:");
        lblSHoras.setBounds(20, 310, 80, 14);
        jLayeredPane4.add(lblSHoras, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblFechaClase.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblFechaClase.setText("Fecha de la Clase:");
        lblFechaClase.setBounds(20, 270, 150, 14);
        jLayeredPane4.add(lblFechaClase, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSHorasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSHorasKeyTyped(evt);
            }
        });
        txtSHoras.setBounds(140, 300, 130, 27);
        jLayeredPane4.add(txtSHoras, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSFechaClase1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSFechaClase1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSFechaClase1KeyTyped(evt);
            }
        });
        txtSFechaClase1.setBounds(220, 260, 50, 30);
        jLayeredPane4.add(txtSFechaClase1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Registrar.png"))); // NOI18N
        btnSRegistrar.setContentAreaFilled(false);
        btnSRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRegistrarActionPerformed(evt);
            }
        });
        btnSRegistrar.setBounds(60, 450, 90, 60);
        jLayeredPane4.add(btnSRegistrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSEntrega.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSEntrega.setText("Fecha de Entrega:");
        lblSEntrega.setBounds(20, 130, 110, 14);
        jLayeredPane4.add(lblSEntrega, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSEntrega1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSEntrega1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSEntrega1KeyTyped(evt);
            }
        });
        txtSEntrega1.setBounds(220, 120, 50, 30);
        jLayeredPane4.add(txtSEntrega1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSSeleccionar.setText("Seleccionar");
        btnSSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSeleccionarActionPerformed(evt);
            }
        });
        btnSSeleccionar.setBounds(590, 160, 120, 30);
        jLayeredPane4.add(btnSSeleccionar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSCurso.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSCurso.setText("Curso:");
        lblSCurso.setBounds(340, 170, 60, 14);
        jLayeredPane4.add(lblSCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSCurso.setEditable(false);
        txtSCurso.setBounds(450, 160, 120, 30);
        jLayeredPane4.add(txtSCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSCAsignacion.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSCAsignacion.setText("Costo de Asignacion:");
        lblSCAsignacion.setBounds(20, 270, 130, 14);
        jLayeredPane4.add(lblSCAsignacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSCAsignacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSCAsignacionKeyTyped(evt);
            }
        });
        txtSCAsignacion.setBounds(140, 260, 130, 30);
        jLayeredPane4.add(txtSCAsignacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSDocente.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSDocente.setText("Docente:");
        lblSDocente.setBounds(340, 90, 60, 14);
        jLayeredPane4.add(lblSDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSDocente.setEditable(false);
        txtSDocente.setBounds(450, 80, 120, 30);
        jLayeredPane4.add(txtSDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSSDocente.setText("Seleccionar");
        btnSSDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSDocenteActionPerformed(evt);
            }
        });
        btnSSDocente.setBounds(590, 80, 120, 30);
        jLayeredPane4.add(btnSSDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSCRealizacion.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSCRealizacion.setText("Pago al Docente:");
        lblSCRealizacion.setBounds(20, 310, 160, 14);
        jLayeredPane4.add(lblSCRealizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSCRealizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSCRealizacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSCRealizacionKeyTyped(evt);
            }
        });
        txtSCRealizacion.setBounds(140, 300, 130, 30);
        jLayeredPane4.add(txtSCRealizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/papelera.png"))); // NOI18N
        btnSLimpiar.setContentAreaFilled(false);
        btnSLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSLimpiarActionPerformed(evt);
            }
        });
        btnSLimpiar.setBounds(180, 430, 80, 90);
        jLayeredPane4.add(btnSLimpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSFechaClase2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSFechaClase2FocusLost(evt);
            }
        });
        txtSFechaClase2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSFechaClase2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSFechaClase2KeyTyped(evt);
            }
        });
        txtSFechaClase2.setBounds(180, 260, 30, 30);
        jLayeredPane4.add(txtSFechaClase2, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtSFechaClase3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSFechaClase3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSFechaClase3KeyTyped(evt);
            }
        });
        txtSFechaClase3.setBounds(140, 260, 30, 30);
        jLayeredPane4.add(txtSFechaClase3, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtSEntrega2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSEntrega2FocusLost(evt);
            }
        });
        txtSEntrega2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSEntrega2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSEntrega2KeyTyped(evt);
            }
        });
        txtSEntrega2.setBounds(180, 120, 30, 30);
        jLayeredPane4.add(txtSEntrega2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSEntrega3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSEntrega3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSEntrega3KeyTyped(evt);
            }
        });
        txtSEntrega3.setBounds(140, 120, 30, 30);
        jLayeredPane4.add(txtSEntrega3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSDireccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDireccion1KeyReleased(evt);
            }
        });
        txtSDireccion1.setBounds(140, 340, 250, 30);
        jLayeredPane4.add(txtSDireccion1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSDireccion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDireccion2KeyReleased(evt);
            }
        });
        txtSDireccion2.setBounds(140, 380, 250, 30);
        jLayeredPane4.add(txtSDireccion2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSDireccion.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSDireccion.setText("Direccion:");
        lblSDireccion.setBounds(20, 350, 100, 14);
        jLayeredPane4.add(lblSDireccion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSPDocente.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSPDocente.setText("Pago al Docente:");
        lblSPDocente.setBounds(340, 120, 120, 30);
        jLayeredPane4.add(lblSPDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtSPDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtSPDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSPDocenteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSPDocenteKeyTyped(evt);
            }
        });
        txtSPDocente.setBounds(450, 120, 120, 30);
        jLayeredPane4.add(txtSPDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoT.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 790, 610);
        jLayeredPane4.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblSLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSLimpiar.setText("Limpiar");
        lblSLimpiar.setBounds(200, 470, 70, 20);
        jLayeredPane4.add(lblSLimpiar, javax.swing.JLayeredPane.MODAL_LAYER);

        lblSRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblSRegistrar.setText("Registrar");
        lblSRegistrar.setBounds(70, 470, 60, 20);
        jLayeredPane4.add(lblSRegistrar, javax.swing.JLayeredPane.POPUP_LAYER);

        javax.swing.GroupLayout pnlServiciosLayout = new javax.swing.GroupLayout(pnlServicios);
        pnlServicios.setLayout(pnlServiciosLayout);
        pnlServiciosLayout.setHorizontalGroup(
            pnlServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        pnlServiciosLayout.setVerticalGroup(
            pnlServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pnlPestanas.addTab("Servicios", pnlServicios);

        pnlMAsistencia.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlMAsistenciaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        tblMAAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombres", "Asistio", "Tardanza", "Falto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMAAsistencias.getTableHeader().setReorderingAllowed(false);
        tblMAAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMAAsistenciasMousePressed(evt);
            }
        });
        tblMAAsistencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblMAAsistenciasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMAAsistenciasKeyReleased(evt);
            }
        });
        sclMAAsistencias.setViewportView(tblMAAsistencias);
        tblMAAsistencias.getColumnModel().getColumn(0).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(1).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(2).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(3).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(4).setResizable(false);

        sclMAAsistencias.setBounds(180, 100, 560, 450);
        jLayeredPane7.add(sclMAAsistencias, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxMA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Alumno", "Docente", "Administrativo" }));
        cbxMA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMAItemStateChanged(evt);
            }
        });
        cbxMA.setBounds(10, 130, 130, 31);
        jLayeredPane7.add(cbxMA, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblMA.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMA.setText("Seleccionar:");
        lblMA.setBounds(10, 100, 120, 14);
        jLayeredPane7.add(lblMA, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblMACiclo.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMACiclo.setText("Ciclo:");
        lblMACiclo.setBounds(10, 240, 80, 14);
        jLayeredPane7.add(lblMACiclo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtMACiclo.setEditable(false);
        txtMACiclo.setBounds(60, 230, 110, 30);
        jLayeredPane7.add(txtMACiclo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnMACiclo.setText("Ciclo");
        btnMACiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMACicloActionPerformed(evt);
            }
        });
        btnMACiclo.setBounds(60, 300, 110, 50);
        jLayeredPane7.add(btnMACiclo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblMATitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/MarcarAsistenciaInicial.png"))); // NOI18N
        lblMATitulo.setBounds(110, 0, 570, 80);
        jLayeredPane7.add(lblMATitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtMACodigo.setEditable(false);
        txtMACodigo.setBounds(300, 180, 120, 30);
        jLayeredPane7.add(txtMACodigo, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtMAApellidoPat.setEditable(false);
        txtMAApellidoPat.setBounds(580, 180, 120, 30);
        jLayeredPane7.add(txtMAApellidoPat, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtMANombre.setEditable(false);
        txtMANombre.setBounds(300, 230, 120, 30);
        jLayeredPane7.add(txtMANombre, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtMAApellidoMat.setEditable(false);
        txtMAApellidoMat.setBounds(580, 230, 120, 30);
        jLayeredPane7.add(txtMAApellidoMat, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtMAIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMAIngresarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMAIngresarKeyTyped(evt);
            }
        });
        txtMAIngresar.setBounds(60, 240, 110, 30);
        jLayeredPane7.add(txtMAIngresar, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblMAIngresar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMAIngresar.setText("Ingrese Codigo:");
        lblMAIngresar.setBounds(10, 210, 100, 20);
        jLayeredPane7.add(lblMAIngresar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblMACodigo.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMACodigo.setText("Codigo:");
        lblMACodigo.setBounds(230, 180, 70, 30);
        jLayeredPane7.add(lblMACodigo, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblMAApellidoPat.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMAApellidoPat.setText("Apellido Paterno:");
        lblMAApellidoPat.setBounds(480, 180, 110, 30);
        jLayeredPane7.add(lblMAApellidoPat, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblMANombre.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMANombre.setText("Nombre:");
        lblMANombre.setBounds(230, 230, 100, 30);
        jLayeredPane7.add(lblMANombre, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblMAApellidoMat.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMAApellidoMat.setText("Apellido Materno");
        lblMAApellidoMat.setBounds(480, 230, 96, 30);
        jLayeredPane7.add(lblMAApellidoMat, javax.swing.JLayeredPane.PALETTE_LAYER);

        btnMAAEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Guardar.png"))); // NOI18N
        btnMAAEntrada.setContentAreaFilled(false);
        btnMAAEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAAEntradaActionPerformed(evt);
            }
        });
        btnMAAEntrada.setBounds(430, 360, 90, 70);
        jLayeredPane7.add(btnMAAEntrada, javax.swing.JLayeredPane.MODAL_LAYER);

        btnMAAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/buscar.png"))); // NOI18N
        btnMAAceptar.setContentAreaFilled(false);
        btnMAAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAAceptarActionPerformed(evt);
            }
        });
        btnMAAceptar.setBounds(70, 290, 80, 70);
        jLayeredPane7.add(btnMAAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnMAGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Guardar.png"))); // NOI18N
        btnMAGuardar.setContentAreaFilled(false);
        btnMAGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAGuardarActionPerformed(evt);
            }
        });
        btnMAGuardar.setBounds(70, 450, 90, 70);
        jLayeredPane7.add(btnMAGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoT.jpg"))); // NOI18N
        jLabel4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel4.setBounds(0, 0, 790, 610);
        jLayeredPane7.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxAsisServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccion Uno", "Academia", "Asesoria" }));
        cbxAsisServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAsisServicioItemStateChanged(evt);
            }
        });
        cbxAsisServicio.setBounds(60, 180, 110, 30);
        jLayeredPane7.add(cbxAsisServicio, javax.swing.JLayeredPane.POPUP_LAYER);

        btnAsisBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/buscar.png"))); // NOI18N
        btnAsisBuscar.setContentAreaFilled(false);
        btnAsisBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsisBuscarActionPerformed(evt);
            }
        });
        btnAsisBuscar.setBounds(80, 380, 70, 60);
        jLayeredPane7.add(btnAsisBuscar, javax.swing.JLayeredPane.POPUP_LAYER);

        cbxMAHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Hora Entrada", "Hora Salida" }));
        cbxMAHora.setBounds(300, 300, 120, 30);
        jLayeredPane7.add(cbxMAHora, javax.swing.JLayeredPane.POPUP_LAYER);

        cbxMATipoS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria" }));
        cbxMATipoS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMATipoSActionPerformed(evt);
            }
        });
        cbxMATipoS.setBounds(580, 300, 120, 30);
        jLayeredPane7.add(cbxMATipoS, javax.swing.JLayeredPane.POPUP_LAYER);

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lbl1.setText("Guardar");
        lbl1.setBounds(450, 370, 60, 20);
        jLayeredPane7.add(lbl1, javax.swing.JLayeredPane.POPUP_LAYER);

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 11));
        lbl2.setText("Guardar");
        lbl2.setBounds(90, 460, 60, 20);
        jLayeredPane7.add(lbl2, javax.swing.JLayeredPane.POPUP_LAYER);

        lbl3.setFont(new java.awt.Font("Tahoma", 1, 11));
        lbl3.setText("Buscar");
        lbl3.setBounds(90, 404, 48, 20);
        jLayeredPane7.add(lbl3, javax.swing.JLayeredPane.DRAG_LAYER);

        lbl4.setFont(new java.awt.Font("Tahoma", 1, 11));
        lbl4.setText("Buscar");
        lbl4.setBounds(90, 314, 50, 20);
        jLayeredPane7.add(lbl4, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout pnlMAsistenciaLayout = new javax.swing.GroupLayout(pnlMAsistencia);
        pnlMAsistencia.setLayout(pnlMAsistenciaLayout);
        pnlMAsistenciaLayout.setHorizontalGroup(
            pnlMAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMAsistenciaLayout.createSequentialGroup()
                .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMAsistenciaLayout.setVerticalGroup(
            pnlMAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pnlPestanas.addTab("Marcar Asistencia", pnlMAsistencia);

        pnlAsistencia.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlAsistenciaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/VerAsistenciaInicial.png"))); // NOI18N
        lblAsistencia.setBounds(150, 10, 460, 70);
        jLayeredPane1.add(lblAsistencia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAsistenciaAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/alumnos.png"))); // NOI18N
        btnAsistenciaAlumnos.setContentAreaFilled(false);
        btnAsistenciaAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAsistenciaAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaAlumnosActionPerformed(evt);
            }
        });
        btnAsistenciaAlumnos.setBounds(110, 230, 160, 150);
        jLayeredPane1.add(btnAsistenciaAlumnos, javax.swing.JLayeredPane.DRAG_LAYER);

        tblAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsistencia.setRowHeight(30);
        tblAsistencia.setRowSelectionAllowed(false);
        tblAsistencia.getTableHeader().setReorderingAllowed(false);
        ScrollAsistencia.setViewportView(tblAsistencia);
        tblAsistencia.getColumnModel().getColumn(0).setResizable(false);
        tblAsistencia.getColumnModel().getColumn(1).setResizable(false);
        tblAsistencia.getColumnModel().getColumn(2).setResizable(false);
        tblAsistencia.getColumnModel().getColumn(3).setResizable(false);
        tblAsistencia.getColumnModel().getColumn(4).setResizable(false);
        tblAsistencia.getColumnModel().getColumn(5).setResizable(false);
        tblAsistencia.getColumnModel().getColumn(6).setResizable(false);

        ScrollAsistencia.setBounds(90, 280, 560, 210);
        jLayeredPane1.add(ScrollAsistencia, javax.swing.JLayeredPane.PALETTE_LAYER);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/regresar.png"))); // NOI18N
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        btnRegresar.setBounds(30, 530, 90, 50);
        jLayeredPane1.add(btnRegresar, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCodigo.setText("Ingrese Codigo:");
        lblCodigo.setBounds(70, 100, 90, 30);
        jLayeredPane1.add(lblCodigo, javax.swing.JLayeredPane.PALETTE_LAYER);
        txtCodigo.setBounds(190, 100, 100, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblNombreAsis.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblNombreAsis.setText("Nombre:");
        lblNombreAsis.setBounds(450, 200, 70, 20);
        jLayeredPane1.add(lblNombreAsis, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtNombreAsis.setEditable(false);
        txtNombreAsis.setBounds(570, 200, 100, 30);
        jLayeredPane1.add(txtNombreAsis, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtApellidoPatAsis.setEditable(false);
        txtApellidoPatAsis.setBounds(570, 150, 100, 30);
        jLayeredPane1.add(txtApellidoPatAsis, javax.swing.JLayeredPane.PALETTE_LAYER);

        txtApellidoMatAsis.setEditable(false);
        txtApellidoMatAsis.setBounds(570, 100, 100, 30);
        jLayeredPane1.add(txtApellidoMatAsis, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblApellidoPatAsis.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblApellidoPatAsis.setText("Apellido Paterno:");
        lblApellidoPatAsis.setBounds(450, 150, 110, 20);
        jLayeredPane1.add(lblApellidoPatAsis, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblApellidoMatAsis.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblApellidoMatAsis.setText("Apellido Materno:");
        lblApellidoMatAsis.setBounds(450, 100, 110, 20);
        jLayeredPane1.add(lblApellidoMatAsis, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblMes.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMes.setText("MES");
        lblMes.setBounds(340, 250, 100, 14);
        jLayeredPane1.add(lblMes, javax.swing.JLayeredPane.PALETTE_LAYER);

        lblAsistenciaAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/AsistenciaAlumno.png"))); // NOI18N
        lblAsistenciaAlumno.setBounds(90, 10, 590, 60);
        jLayeredPane1.add(lblAsistenciaAlumno, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAsistenciaAdministrativa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/administrativos.png"))); // NOI18N
        btnAsistenciaAdministrativa.setContentAreaFilled(false);
        btnAsistenciaAdministrativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaAdministrativaActionPerformed(evt);
            }
        });
        btnAsistenciaAdministrativa.setBounds(320, 230, 130, 140);
        jLayeredPane1.add(btnAsistenciaAdministrativa, javax.swing.JLayeredPane.DRAG_LAYER);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/papelera.png"))); // NOI18N
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        btnLimpiar.setBounds(660, 500, 80, 90);
        jLayeredPane1.add(btnLimpiar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/flechaAnterior.png"))); // NOI18N
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        btnAnterior.setBounds(10, 280, 60, 50);
        jLayeredPane1.add(btnAnterior, javax.swing.JLayeredPane.PALETTE_LAYER);

        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/flechaSiguiente.png"))); // NOI18N
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        btnSiguiente.setBounds(670, 280, 70, 50);
        jLayeredPane1.add(btnSiguiente, javax.swing.JLayeredPane.PALETTE_LAYER);

        btnActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/MesActual.png"))); // NOI18N
        btnActual.setContentAreaFilled(false);
        btnActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualActionPerformed(evt);
            }
        });
        btnActual.setBounds(670, 390, 60, 60);
        jLayeredPane1.add(btnActual, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.setBounds(310, 100, 100, 30);
        jLayeredPane1.add(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblAsistenciaAdministrativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/AsistenciaAdministrativo.png"))); // NOI18N
        lblAsistenciaAdministrativo.setBounds(80, 10, 620, 60);
        jLayeredPane1.add(lblAsistenciaAdministrativo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoT.jpg"))); // NOI18N
        jLabel5.setBounds(0, 0, 790, 610);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblAsisRegresar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsisRegresar.setText("Regresar");
        lblAsisRegresar.setBounds(50, 540, 80, 30);
        jLayeredPane1.add(lblAsisRegresar, javax.swing.JLayeredPane.POPUP_LAYER);

        lblAsisLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsisLimpiar.setText("Limpiar");
        lblAsisLimpiar.setBounds(680, 540, 70, 20);
        jLayeredPane1.add(lblAsisLimpiar, javax.swing.JLayeredPane.POPUP_LAYER);

        lblAsisAnterior.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsisAnterior.setText("Mes Anterior");
        lblAsisAnterior.setBounds(0, 320, 110, 30);
        jLayeredPane1.add(lblAsisAnterior, javax.swing.JLayeredPane.POPUP_LAYER);

        lblAsisSiguiente.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsisSiguiente.setText("Mes Siguiente");
        lblAsisSiguiente.setBounds(660, 320, 110, 30);
        jLayeredPane1.add(lblAsisSiguiente, javax.swing.JLayeredPane.POPUP_LAYER);

        lblAsisActual.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsisActual.setText("Mes Actual");
        lblAsisActual.setBounds(670, 440, 90, 30);
        jLayeredPane1.add(lblAsisActual, javax.swing.JLayeredPane.POPUP_LAYER);

        btnAsisServicio.setText("Seleccionar");
        btnAsisServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsisServicioActionPerformed(evt);
            }
        });
        btnAsisServicio.setBounds(310, 200, 100, 30);
        jLayeredPane1.add(btnAsisServicio, javax.swing.JLayeredPane.POPUP_LAYER);

        lblAsisServicio.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsisServicio.setText("Servicio:");
        lblAsisServicio.setBounds(110, 150, 70, 30);
        jLayeredPane1.add(lblAsisServicio, javax.swing.JLayeredPane.POPUP_LAYER);

        txtAsisServicio.setEditable(false);
        txtAsisServicio.setBounds(190, 150, 100, 30);
        jLayeredPane1.add(txtAsisServicio, javax.swing.JLayeredPane.POPUP_LAYER);

        cbxAsisServ.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria" }));
        cbxAsisServ.setBounds(190, 200, 100, 30);
        jLayeredPane1.add(cbxAsisServ, javax.swing.JLayeredPane.POPUP_LAYER);

        lblMAAlumno.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMAAlumno.setText("Alumno");
        lblMAAlumno.setBounds(160, 370, 48, 20);
        jLayeredPane1.add(lblMAAlumno, javax.swing.JLayeredPane.DRAG_LAYER);

        lblMAAdministrativa.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblMAAdministrativa.setText("Administrativa");
        lblMAAdministrativa.setBounds(330, 370, 90, 20);
        jLayeredPane1.add(lblMAAdministrativa, javax.swing.JLayeredPane.DRAG_LAYER);

        btnAsisDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/docentes.png"))); // NOI18N
        btnAsisDocente.setText("jButton3");
        btnAsisDocente.setContentAreaFilled(false);
        btnAsisDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsisDocenteActionPerformed(evt);
            }
        });
        btnAsisDocente.setBounds(540, 220, 170, 140);
        jLayeredPane1.add(btnAsisDocente, javax.swing.JLayeredPane.DRAG_LAYER);

        lblAsisDocente.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsisDocente.setText("Docentes");
        lblAsisDocente.setBounds(580, 370, 80, 20);
        jLayeredPane1.add(lblAsisDocente, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout pnlAsistenciaLayout = new javax.swing.GroupLayout(pnlAsistencia);
        pnlAsistencia.setLayout(pnlAsistenciaLayout);
        pnlAsistenciaLayout.setHorizontalGroup(
            pnlAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        pnlAsistenciaLayout.setVerticalGroup(
            pnlAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pnlPestanas.addTab("Ver Asistencia", pnlAsistencia);

        pnlBalance.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                pnlBalanceAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblTIngresos.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblTIngresos.setText("Total de Ingresos:");
        lblTIngresos.setBounds(130, 390, 130, 30);
        jLayeredPane5.add(lblTIngresos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblAsignacionesB.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsignacionesB.setText("Asignaciones:");
        lblAsignacionesB.setBounds(130, 310, 190, 30);
        jLayeredPane5.add(lblAsignacionesB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblAsesoriaB.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAsesoriaB.setText("Asesoria(DEATRE):");
        lblAsesoriaB.setBounds(130, 270, 110, 30);
        jLayeredPane5.add(lblAsesoriaB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblAcademiaB.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblAcademiaB.setText("Academia:");
        lblAcademiaB.setBounds(130, 230, 60, 30);
        jLayeredPane5.add(lblAcademiaB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblDAcademiaB.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDAcademiaB.setText("Docentes y Administrativos:");
        lblDAcademiaB.setBounds(130, 510, 190, 30);
        jLayeredPane5.add(lblDAcademiaB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Ingresos por Matriculas:");
        jLabel2.setBounds(60, 190, 280, 30);
        jLayeredPane5.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Egresos por Pagos:");
        jLabel6.setBounds(70, 470, 280, 30);
        jLayeredPane5.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Balance.png"))); // NOI18N
        jLabel11.setBounds(130, 20, 550, 60);
        jLayeredPane5.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblParticularesB.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblParticularesB.setText("Clases Particulares:");
        lblParticularesB.setBounds(130, 350, 160, 30);
        jLayeredPane5.add(lblParticularesB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnIngresosB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/balances.png"))); // NOI18N
        btnIngresosB.setContentAreaFilled(false);
        btnIngresosB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresosBActionPerformed(evt);
            }
        });
        btnIngresosB.setBounds(550, 330, 80, 70);
        jLayeredPane5.add(btnIngresosB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAcademiaB.setEditable(false);
        txtAcademiaB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtAcademiaB.setBounds(340, 230, 110, 30);
        jLayeredPane5.add(txtAcademiaB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAsesoriaB.setEditable(false);
        txtAsesoriaB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtAsesoriaB.setBounds(340, 270, 110, 30);
        jLayeredPane5.add(txtAsesoriaB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtParticularesB.setEditable(false);
        txtParticularesB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtParticularesB.setBounds(340, 350, 110, 30);
        jLayeredPane5.add(txtParticularesB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtTIngresosB.setEditable(false);
        txtTIngresosB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtTIngresosB.setBounds(340, 390, 110, 30);
        jLayeredPane5.add(txtTIngresosB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtColaboradoresB.setEditable(false);
        txtColaboradoresB.setBounds(340, 510, 110, 30);
        jLayeredPane5.add(txtColaboradoresB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAsignacionesB.setEditable(false);
        txtAsignacionesB.setBounds(340, 310, 110, 30);
        jLayeredPane5.add(txtAsignacionesB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoT.jpg"))); // NOI18N
        jLabel9.setBounds(0, 0, 790, 610);
        jLayeredPane5.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtMesB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMesBKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMesBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesBKeyTyped(evt);
            }
        });
        txtMesB.setBounds(160, 120, 40, 30);
        jLayeredPane5.add(txtMesB, javax.swing.JLayeredPane.POPUP_LAYER);

        txtAnoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnoBKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnoBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoBKeyTyped(evt);
            }
        });
        txtAnoB.setBounds(260, 120, 60, 30);
        jLayeredPane5.add(txtAnoB, javax.swing.JLayeredPane.POPUP_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Mes");
        jLabel8.setBounds(120, 120, 40, 30);
        jLayeredPane5.add(jLabel8, javax.swing.JLayeredPane.POPUP_LAYER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Año");
        jLabel10.setBounds(220, 120, 40, 30);
        jLayeredPane5.add(jLabel10, javax.swing.JLayeredPane.POPUP_LAYER);

        cbxBalances.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Ingresos", "Egresos" }));
        cbxBalances.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBalancesItemStateChanged(evt);
            }
        });
        cbxBalances.setBounds(520, 230, 150, 30);
        jLayeredPane5.add(cbxBalances, javax.swing.JLayeredPane.MODAL_LAYER);

        cbxTipoBalances.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno" }));
        cbxTipoBalances.setBounds(520, 280, 150, 30);
        jLayeredPane5.add(cbxTipoBalances, javax.swing.JLayeredPane.MODAL_LAYER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Guardar.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(550, 440, 80, 60);
        jLayeredPane5.add(jButton1, javax.swing.JLayeredPane.POPUP_LAYER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/buscar.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(370, 110, 70, 60);
        jLayeredPane5.add(jButton2, javax.swing.JLayeredPane.POPUP_LAYER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel13.setText("Guardar Todos");
        jLabel13.setBounds(550, 500, 90, 30);
        jLayeredPane5.add(jLabel13, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel14.setText("Ver y Guardar Balance");
        jLabel14.setBounds(530, 400, 130, 30);
        jLayeredPane5.add(jLabel14, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel15.setText("Buscar");
        jLabel15.setBounds(380, 160, 48, 20);
        jLayeredPane5.add(jLabel15, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout pnlBalanceLayout = new javax.swing.GroupLayout(pnlBalance);
        pnlBalance.setLayout(pnlBalanceLayout);
        pnlBalanceLayout.setHorizontalGroup(
            pnlBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        pnlBalanceLayout.setVerticalGroup(
            pnlBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pnlPestanas.addTab("Balance", pnlBalance);

        pnlPestanas.setBounds(10, -2, 890, 610);
        jLayeredPane8.add(pnlPestanas, javax.swing.JLayeredPane.PALETTE_LAYER);

        fondoT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoT.jpg"))); // NOI18N
        fondoT.setBounds(0, 0, 1220, 610);
        jLayeredPane8.add(fondoT, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblRecientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Costo", "Matricula ", "Ciclo", "Fecha Inicio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRecientes.getTableHeader().setReorderingAllowed(false);
        tblRecientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblRecientesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tblRecientes);
        tblRecientes.getColumnModel().getColumn(0).setResizable(false);
        tblRecientes.getColumnModel().getColumn(1).setResizable(false);
        tblRecientes.getColumnModel().getColumn(2).setResizable(false);
        tblRecientes.getColumnModel().getColumn(3).setResizable(false);

        jScrollPane1.setBounds(910, 10, 300, 580);
        jLayeredPane8.add(jScrollPane1, javax.swing.JLayeredPane.PALETTE_LAYER);

        jMenu1.setText("Archivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        MenuOpciones.setText("Insertar");

        menuInsertarCiclos.setText("Ciclos");
        menuInsertarCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertarCiclosActionPerformed(evt);
            }
        });
        MenuOpciones.add(menuInsertarCiclos);

        menuInsertarCurso.setText("Cursos");
        menuInsertarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertarCursoActionPerformed(evt);
            }
        });
        MenuOpciones.add(menuInsertarCurso);

        jMenuItem13.setText("Cursos-Docente");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        MenuOpciones.add(jMenuItem13);

        jMenuItem22.setText("Disponibilidad Docente");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        MenuOpciones.add(jMenuItem22);

        jMenuItem23.setText("Dominio Docente");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        MenuOpciones.add(jMenuItem23);

        menuInsertarEvaluacion.setText("Evaluacion");
        menuInsertarEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertarEvaluacionActionPerformed(evt);
            }
        });
        MenuOpciones.add(menuInsertarEvaluacion);

        menuInsertarNotas.setText("Notas");
        menuInsertarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertarNotasActionPerformed(evt);
            }
        });
        MenuOpciones.add(menuInsertarNotas);

        menuInsertarSalones.setText("Salones");
        menuInsertarSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInsertarSalonesActionPerformed(evt);
            }
        });
        MenuOpciones.add(menuInsertarSalones);

        jMenuItem21.setText("Salon por Ciclo");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        MenuOpciones.add(jMenuItem21);

        jMenuItem3.setText("Pago Administrativo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuOpciones.add(jMenuItem3);

        jMenuItem4.setText("Pago Docente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuOpciones.add(jMenuItem4);

        jMenuItem5.setText("Pago Alumno");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MenuOpciones.add(jMenuItem5);

        jMenuBar1.add(MenuOpciones);

        jMenu5.setText("Modificar");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        manuModificarAdministrativo.setText("Administrativo");
        manuModificarAdministrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manuModificarAdministrativoActionPerformed(evt);
            }
        });
        jMenu5.add(manuModificarAdministrativo);

        menuModificarAlumno.setText("Alumno");
        menuModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarAlumnoActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarAlumno);

        menuModificarAsesorias.setText("Asesorias");
        menuModificarAsesorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarAsesoriasActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarAsesorias);

        menuModificarAsignacion.setText("Asignacion");
        menuModificarAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarAsignacionActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarAsignacion);

        menuModificarAsistencia.setText("Asistencia Alumno");
        menuModificarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarAsistenciaActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarAsistencia);

        jMenuItem8.setText("Asistencia Docente y Administrativo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        menuModificarCiclos.setText("Ciclos");
        menuModificarCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarCiclosActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarCiclos);

        menuModificarParticular.setText("Clase Particular");
        menuModificarParticular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarParticularActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarParticular);

        menuModificarContrasena.setText("Contraseña");
        menuModificarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarContrasenaActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarContrasena);

        menuModificarCursos.setText("Cursos");
        menuModificarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarCursosActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarCursos);

        jMenuItem24.setText("Disponibilidad de Docente");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem24);

        menuModificarDocente.setText("Docente");
        menuModificarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarDocenteActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarDocente);

        jMenuItem25.setText("Dominio de Docente");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem25);

        jMenuItem14.setText("Descuentos");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        menuModificarEvaluacion.setText("Evaluacion");
        menuModificarEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarEvaluacionActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarEvaluacion);

        jMenuItem17.setText("Horarios del Ciclo");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem17);

        jMenuItem9.setText("Matricula Alumno");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        menuModificarNotas.setText("Notas");
        menuModificarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarNotasActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarNotas);

        menuModificarSalones.setText("Salones");
        menuModificarSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarSalonesActionPerformed(evt);
            }
        });
        jMenu5.add(menuModificarSalones);

        jMenuItem18.setText("Salones por Ciclo");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem18);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Listado");

        menuListadoAdministrativos.setText("Administrativos");
        menuListadoAdministrativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoAdministrativosActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoAdministrativos);

        menuListadoAlumnos.setText("Alumnos");
        menuListadoAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoAlumnosActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoAlumnos);

        jMenuItem11.setText("Asignaciones");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        menuListadoCursos.setText("Cursos");
        menuListadoCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoCursosActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoCursos);

        menuListadoCiclos.setText("Ciclos");
        menuListadoCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoCiclosActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoCiclos);

        menuListadoCicloCursos.setText("Cursos de un Ciclo");
        menuListadoCicloCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoCicloCursosActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoCicloCursos);

        jMenuItem15.setText("Cursos-Docente");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        menuListadoDocentes.setText("Docentes");
        menuListadoDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoDocentesActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoDocentes);

        menuListadoFaltantes.setText("Faltantes");
        menuListadoFaltantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoFaltantesActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoFaltantes);

        menuListadoNotas.setText("Notas");
        menuListadoNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListadoNotasActionPerformed(evt);
            }
        });
        jMenu4.add(menuListadoNotas);

        jMenuItem27.setText("Observados(Alumnos)");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem27);

        jMenuItem12.setText("Particulares");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem26.setText("Salones por Ciclo");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem26);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Mostrar");

        jMenuItem16.setText("Reporte de Descuentos");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem19.setText("Reporte de Docente (Academia)");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        jMenuItem20.setText("Reporte de Docente (Asesorias)");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem20);

        jMenuItem6.setText("Reporte de Pagos (Academia)");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuItem7.setText("Reporte de Pagos (Asesorias)");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuBar1.add(jMenu6);

        jMenu3.setText("Otras Opciones");

        jMenuItem10.setText("Agenda de Control");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        menuDescuentos.setText("Descuentos");
        menuDescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDescuentosActionPerformed(evt);
            }
        });
        jMenu3.add(menuDescuentos);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ayuda");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        About x = new About();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if(evt.getKeyCode()==evt.VK_ESCAPE){
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyTyped

    private void menuDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDescuentosActionPerformed
        if(contrasena(con)){
            Aplicar_Descuentos x = new Aplicar_Descuentos();
            x.setVisible(true);
        }
    }//GEN-LAST:event_menuDescuentosActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        mostrarRecientes();
        try {
                String linea;
                FileReader f = new FileReader("ActualizarCurso.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        txtSCurso.setText(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        
                    }
                    else{
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                }
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(registrarA){
                try {
                    String linea;
                    FileReader f = new FileReader("ActualizarCurso.txt");
                    BufferedReader b = new BufferedReader(f);
                    while((linea=b.readLine())!=null){
                        StringTokenizer t = new StringTokenizer(linea,",");
                        String boleano=t.nextToken();
                        if(Boolean.valueOf(boleano)){
                            codigoRAcurso=t.nextToken();
                            txtCurso.setText(codigoRAcurso);
                            System.out.println(t.nextToken());
                            System.out.println(t.nextToken());
                        }
                        else{
                            System.out.println(t.nextToken());
                            System.out.println(t.nextToken());
                            System.out.println(t.nextToken());
                        }
                    }
                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(registrarD){
                try {
                    DefaultTableModel cursos = new DefaultTableModel();
                    cursos.addColumn("Codigo");
                    cursos.addColumn("Curso");
                    for(int j=0;j<tabladominio;j++){
                        for(int k=0;k<2;k++){
                            tblDominioCursos.setValueAt("",j,k);
                        }
                    }
                    String linea=null;
                    int i=0;
                    FileReader f = new FileReader("ActualizarCursoDominio.txt");
                    BufferedReader b = new BufferedReader(f);
                    while((linea=b.readLine())!=null){
                        StringTokenizer t = new StringTokenizer(linea,",");
                        if(Boolean.valueOf(t.nextToken())){
                            Object dato[] = new Object[2];    
                            dato[0]=t.nextToken();
                            dato[1]=t.nextToken();
                            cursos.addRow(dato);
                            i++;
                        }
                        else{
                            System.out.println(t.nextToken());
                            System.out.println(t.nextToken());
                        }
                    }
                    tabladominio=i;
                    tblDominioCursos.setModel(cursos);
                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    DefaultTableModel disponibilidad = new DefaultTableModel();
                    disponibilidad.addColumn("Dia");
                    disponibilidad.addColumn("Hora Entrada");
                    disponibilidad.addColumn("Hora Salida");
                    for(int j=0;j<tabladisponibilidad;j++){
                        for(int k=0;k<3;k++){
                            tblDisponibilidad.setValueAt("",j,k);
                        }
                    }
                    String linea=null;
                    int i=0;
                    FileReader f = new FileReader("Disponibilidad.txt");
                    BufferedReader b = new BufferedReader(f);
                    while((linea=b.readLine())!=null){
                        StringTokenizer t = new StringTokenizer(linea,",");
                        if(Boolean.valueOf(t.nextToken())){
                            Object dato[] = new Object[3];    
                            dato[0]=t.nextToken();
                            dato[1]=t.nextToken();
                            dato[2]=t.nextToken();
                            disponibilidad.addRow(dato);
                            i++;
                        }
                        else{
                            System.out.println(t.nextToken());
                            System.out.println(t.nextToken());
                            System.out.println(t.nextToken());
                        }
                    }
                    tabladisponibilidad=i;
                    tblDisponibilidad.setModel(disponibilidad);
                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
            try {
                FileWriter h = new FileWriter("ActualizarCursoDominio.txt");
                FileWriter i = new FileWriter("Disponibilidad.txt");
            } catch (IOException ex) {
                Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
                try {
                String linea;
                FileReader f = new FileReader("ActualizarServicio.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        codigoRS=t.nextToken();
                        txtAsisServicio.setText(codigoRS);
                        System.out.println(t.nextToken());
                    }
                    else{
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                }
                b.close();
            } catch (IOException ex) {}
            try {
                String linea;
                FileReader f = new FileReader("ActualizarAsesoria.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        codigoRS=t.nextToken();
                        txtAsisServicio.setText(codigoRS);
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                    else{
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                }
                b.close();
            } catch (IOException ex) {}
            try {
                String linea;
                FileReader f = new FileReader("ActualizarServicio.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        codigoRS=t.nextToken();
                        txtServicio.setText(codigoRS);
                        System.out.println(t.nextToken());
                    }
                    else{
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                }
                b.close();
            } catch (IOException ex) {}
            try {
                String linea;
                FileReader f = new FileReader("ActualizarAsesoria.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        codigoRS=t.nextToken();
                        txtServicio.setText(codigoRS);
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                    else{
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                }
                b.close();
            } catch (IOException ex) {}
      if(cbxMA.getSelectedIndex()==1){
          if(cbxAsisServicio.getSelectedIndex()==1){
           try {
                String linea;
                FileReader f = new FileReader("ActualizarServicio.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        txtMACiclo.setText(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                    else{
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                }
                b.close();
            } catch (IOException ex) {}
          }
          if(cbxAsisServicio.getSelectedIndex()==2){
           try {
                String linea;
                FileReader f = new FileReader("ActualizarAsesoria.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        txtMACiclo.setText(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                    else{
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                        System.out.println(t.nextToken());
                    }
                }
                b.close();
            } catch (IOException ex) {}
          }
      }      
       try {
            String linea;
            FileReader f = new FileReader("ActualizarDocente.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                String boleano=t.nextToken();
                if(Boolean.valueOf(boleano)){
                    txtSDocente.setText(t.nextToken());
                    System.out.println(t.nextToken());
                }
                else{
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                }
            }
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
       try{
             FileWriter f = new FileWriter("ActualizarServicio.txt");
             FileWriter g = new FileWriter("ActualizarCurso.txt");
             FileWriter j = new FileWriter("ActualizarDocente.txt");
             FileWriter k = new FileWriter("ActualizarAsesoria.txt");
          }catch (IOException ex) {}
    }//GEN-LAST:event_formWindowGainedFocus

    private void menuInsertarCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertarCiclosActionPerformed
        Insertar_Servicio x = new Insertar_Servicio();
        x.setVisible(true);
    }//GEN-LAST:event_menuInsertarCiclosActionPerformed

@SuppressWarnings(value = "unchecked")
    private void menuInsertarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertarCursoActionPerformed
        Insertar_Curso x = new Insertar_Curso();
        x.setVisible(true);
    }//GEN-LAST:event_menuInsertarCursoActionPerformed

    private void menuInsertarSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertarSalonesActionPerformed
        Insertar_Salones x = new Insertar_Salones();
        x.setVisible(true);
    }//GEN-LAST:event_menuInsertarSalonesActionPerformed

    private void menuInsertarEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertarEvaluacionActionPerformed
        Insertar_Evaluacion x = new Insertar_Evaluacion();
        x.setVisible(true);
    }//GEN-LAST:event_menuInsertarEvaluacionActionPerformed

    private void menuInsertarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInsertarNotasActionPerformed
        Insertar_Notas x = new Insertar_Notas();
        x.setVisible(true);
    }//GEN-LAST:event_menuInsertarNotasActionPerformed

    private void menuListadoNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoNotasActionPerformed
        Listado_Notas x = new Listado_Notas();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoNotasActionPerformed

    private void menuListadoAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoAlumnosActionPerformed
        Listado_Alumnos x = new Listado_Alumnos();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoAlumnosActionPerformed

    private void menuListadoDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoDocentesActionPerformed
        Listado_Docentes x = new Listado_Docentes();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoDocentesActionPerformed

    private void menuListadoCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoCiclosActionPerformed
        Listado_Ciclos x = new Listado_Ciclos();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoCiclosActionPerformed

    private void menuListadoAdministrativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoAdministrativosActionPerformed
        Listado_Administrativos x = new Listado_Administrativos();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoAdministrativosActionPerformed

    private void menuListadoCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoCursosActionPerformed
        Listado_Cursos x =new Listado_Cursos();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoCursosActionPerformed

    private void menuListadoCicloCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoCicloCursosActionPerformed
        Listado_Curso_Ciclo x = new Listado_Curso_Ciclo();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoCicloCursosActionPerformed

    private void menuListadoFaltantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListadoFaltantesActionPerformed
        Listado_Faltantes x = new Listado_Faltantes();
        x.setVisible(true);
    }//GEN-LAST:event_menuListadoFaltantesActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        txtCodigo.setText("");         txtNombreAsis.setText("");         txtApellidoPatAsis.setText("");         txtApellidoMatAsis.setText("");         limpiarCalendario();         MesAux = Integer.parseInt(M);         AAux = Integer.parseInt(A);         calendario();     }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAsistenciaAdministrativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaAdministrativaActionPerformed

        alumno = false;         administrativo = true;         Asistencia(false, false, true);     }//GEN-LAST:event_btnAsistenciaAdministrativaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        Asistencia(true, false, false);         alumno = false;         administrativo = false;         busqueda = false;         txtCodigo.setText("");         txtNombreAsis.setText("");         txtApellidoPatAsis.setText("");         txtApellidoMatAsis.setText("");         limpiarCalendario();         MesAux = Integer.parseInt(M);         AAux = Integer.parseInt(A);         calendario();     }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAsistenciaAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaAlumnosActionPerformed
        alumno = true;
        administrativo = false;
        Asistencia(false, true, false);   
 }//GEN-LAST:event_btnAsistenciaAlumnosActionPerformed

    private void txtSPDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSPDocenteKeyTyped

        char caracter = evt.getKeyChar();         if ((caracter < '0') || (caracter > '9')) {             if (caracter < '.' || caracter > '.') {                 evt.consume();             }         }     }//GEN-LAST:event_txtSPDocenteKeyTyped

    private void txtSDireccion2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDireccion2KeyReleased

        if (txtSDireccion2.getText().length() > 30) {             txtSDireccion2.setText(txtSDireccion2.getText().substring(0, 16));         }     }//GEN-LAST:event_txtSDireccion2KeyReleased

    private void txtSDireccion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDireccion1KeyReleased

        if (txtSDireccion1.getText().length() > 30) {             txtSDireccion1.setText(txtSDireccion1.getText().substring(0, 30));         }     }//GEN-LAST:event_txtSDireccion1KeyReleased

    private void txtSEntrega3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEntrega3KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSEntrega3KeyTyped

    private void txtSEntrega3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEntrega3KeyReleased

        if (txtSEntrega3.getText().length() > 1) {             txtSEntrega3.setText(txtSEntrega3.getText().substring(0, 2));             if (recorrer(txtSEntrega2.getText())) {                 if (Integer.parseInt(txtSEntrega3.getText()) < 1 || Integer.parseInt(txtSEntrega3.getText()) > maximodia(Integer.parseInt(txtSEntrega2.getText()) - 1, Integer.parseInt(txtSEntrega1.getText()))) {                     txtSEntrega3.setText(String.valueOf(maximodia(Integer.parseInt(txtSEntrega2.getText()) - 1, Integer.parseInt(txtSEntrega1.getText()))));                 }             }         }     }//GEN-LAST:event_txtSEntrega3KeyReleased

    private void txtSEntrega2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEntrega2KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSEntrega2KeyTyped

    private void txtSEntrega2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEntrega2KeyReleased

        if (txtSEntrega2.getText().length() > 1) {             txtSEntrega2.setText(txtSEntrega2.getText().substring(0, 2));             if (Integer.parseInt(txtSEntrega2.getText()) < 0 || Integer.parseInt(txtSEntrega2.getText()) > 12) {                 txtSEntrega2.setText("12");             }             if (txtSEntrega2.getText().length() == 1) {                 if (Integer.parseInt(txtSEntrega3.getText()) < 1 || Integer.parseInt(txtSEntrega3.getText()) > maximodia(Integer.parseInt(txtSEntrega2.getText()), Integer.parseInt(txtSEntrega1.getText()))) {                     txtSEntrega3.setText(String.valueOf(maximodia(Integer.parseInt(txtSEntrega3.getText()), Integer.parseInt(txtSEntrega1.getText()))));                 }             }         }     }//GEN-LAST:event_txtSEntrega2KeyReleased

    private void txtSEntrega2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSEntrega2FocusLost

        if (recorrer(txtSEntrega2.getText()) && recorrer(txtSEntrega3.getText())) {             if (Integer.parseInt(txtSEntrega3.getText()) < 1 || Integer.parseInt(txtSEntrega3.getText()) > maximodia(Integer.parseInt(txtSEntrega2.getText()) - 1, Integer.parseInt(txtSEntrega1.getText()))) {                 txtSEntrega3.setText(String.valueOf(maximodia(Integer.parseInt(txtSEntrega2.getText()) - 1, Integer.parseInt(txtSEntrega1.getText()))));             }         }     }//GEN-LAST:event_txtSEntrega2FocusLost

    private void txtSFechaClase3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSFechaClase3KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSFechaClase3KeyTyped

    private void txtSFechaClase3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSFechaClase3KeyReleased

        if (txtSFechaClase3.getText().length() > 1) {             txtSFechaClase3.setText(txtSFechaClase3.getText().substring(0, 2));             if (recorrer(txtSFechaClase2.getText())) {                 if (Integer.parseInt(txtSFechaClase3.getText()) < 1 || Integer.parseInt(txtSFechaClase3.getText()) > maximodia(Integer.parseInt(txtSFechaClase2.getText()) - 1, Integer.parseInt(txtSFechaClase1.getText()))) {                     txtSFechaClase3.setText(String.valueOf(maximodia(Integer.parseInt(txtSFechaClase2.getText()) - 1, Integer.parseInt(txtSFechaClase1.getText()))));                 }             }         }     }//GEN-LAST:event_txtSFechaClase3KeyReleased

    private void txtSFechaClase2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSFechaClase2KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSFechaClase2KeyTyped

    private void txtSFechaClase2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSFechaClase2KeyReleased

        if (txtSFechaClase2.getText().length() > 1) {             txtSFechaClase2.setText(txtSFechaClase2.getText().substring(0, 2));             if (Integer.parseInt(txtSFechaClase2.getText()) < 0 || Integer.parseInt(txtSFechaClase2.getText()) > 12) {                 txtSFechaClase2.setText("12");             }             if (txtSFechaClase2.getText().length() == 1) {                 if (Integer.parseInt(txtSFechaClase3.getText()) < 1 || Integer.parseInt(txtSFechaClase3.getText()) > maximodia(Integer.parseInt(txtSFechaClase2.getText()), Integer.parseInt(txtSFechaClase1.getText()))) {                     txtSFechaClase3.setText(String.valueOf(maximodia(Integer.parseInt(txtSFechaClase2.getText()), Integer.parseInt(txtSFechaClase1.getText()))));                 }             }         }     }//GEN-LAST:event_txtSFechaClase2KeyReleased

    private void txtSFechaClase2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSFechaClase2FocusLost

        if (recorrer(txtSFechaClase2.getText()) && recorrer(txtSFechaClase3.getText())) {             if (Integer.parseInt(txtSFechaClase3.getText()) < 1 || Integer.parseInt(txtSFechaClase3.getText()) > maximodia(Integer.parseInt(txtSFechaClase2.getText()) - 1, Integer.parseInt(txtSFechaClase1.getText()))) {                 txtSFechaClase3.setText(String.valueOf(maximodia(Integer.parseInt(txtSFechaClase2.getText()) - 1, Integer.parseInt(txtSFechaClase1.getText()))));             }         }     }//GEN-LAST:event_txtSFechaClase2FocusLost

    private void btnSLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSLimpiarActionPerformed

        limpiarServicio();     }//GEN-LAST:event_btnSLimpiarActionPerformed

    private void txtSCRealizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSCRealizacionKeyTyped

        char caracter = evt.getKeyChar();         if ((caracter < '0') || (caracter > '9')) {             if (caracter < '.' || caracter > '.') {                 evt.consume();             }         }     }//GEN-LAST:event_txtSCRealizacionKeyTyped

    private void txtSCRealizacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSCRealizacionKeyReleased

        int c = 0;         String texto = txtSCRealizacion.getText();         if (texto.length() != 0) {             for (int i = 0; i < texto.length(); i++) {                 if (texto.charAt(i) == '.') {                     c++;                 }             }             if (c == 2) {                 txtSCRealizacion.setText(texto.substring(0, texto.length() - 1));             }             if (c > 2) {                 for (int j = 1; j < c; j++) {                     txtSCRealizacion.setText(texto.substring(0, texto.length() - 1));                     texto = txtSCRealizacion.getText();                 }             }             if (texto.charAt(0) == '.') {                 txtSCRealizacion.setText("0" + texto);             }         }     }//GEN-LAST:event_txtSCRealizacionKeyReleased

    private void btnSSDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSDocenteActionPerformed

        Seleccionar_Docente x = new Seleccionar_Docente();         x.setVisible(true);     }//GEN-LAST:event_btnSSDocenteActionPerformed

    private void txtSCAsignacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSCAsignacionKeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSCAsignacionKeyTyped

    private void btnSSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSeleccionarActionPerformed

        Seleccionar_Cursos x = new Seleccionar_Cursos();         x.setVisible(true);     }//GEN-LAST:event_btnSSeleccionarActionPerformed

    private void txtSEntrega1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEntrega1KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSEntrega1KeyTyped

    private void txtSEntrega1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSEntrega1KeyReleased

        if (txtSEntrega1.getText().length() > 3) {             txtSEntrega1.setText(txtSEntrega1.getText().substring(0, 4));         }     }//GEN-LAST:event_txtSEntrega1KeyReleased

    private void btnSRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRegistrarActionPerformed

        boolean verificar = true, verificar1 = true;         verificar = VerificarCampos(verificar);         if (verificar) {             if (cbxSServicio.getSelectedIndex() == 1) {                 registrarClaseParticular();                 try {                     FileWriter f = new FileWriter("ActualizarDocente.txt");                     FileWriter m = new FileWriter("ActualizarCurso.txt");                 } catch (IOException ex) {                     Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);                 }             }             if (cbxSServicio.getSelectedIndex() == 2) {                 registrarAsignacion();             }         } else {             if (verificar1) {                 JOptionPane.showMessageDialog(this, "Campos Vacios: " + campos, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);             }         }     }//GEN-LAST:event_btnSRegistrarActionPerformed

    private void txtSFechaClase1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSFechaClase1KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSFechaClase1KeyTyped

    private void txtSFechaClase1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSFechaClase1KeyReleased

        if (txtSFechaClase1.getText().length() > 3) {             txtSFechaClase1.setText(txtSFechaClase1.getText().substring(0, 4));         }     }//GEN-LAST:event_txtSFechaClase1KeyReleased

    private void txtSHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSHorasKeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtSHorasKeyTyped

    private void txtSHorasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSHorasKeyReleased

        if (recorrer(txtSHoras.getText()) && Integer.parseInt(txtSHoras.getText()) > 24) {             txtSHoras.setText("24");         }     }//GEN-LAST:event_txtSHorasKeyReleased

    private void txtSPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSPrecioKeyTyped

        char caracter = evt.getKeyChar();         if ((caracter < '0') || (caracter > '9')) {             if (caracter < '.' || caracter > '.') {                 evt.consume();             }         }     }//GEN-LAST:event_txtSPrecioKeyTyped

    private void txtSApellidoMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSApellidoMatKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtSApellidoMatKeyTyped

    private void txtSApellidoMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSApellidoMatKeyReleased

        if (txtSApellidoMat.getText().length() > 16) {             txtSApellidoMat.setText(txtSApellidoMat.getText().substring(0, 16));         }     }//GEN-LAST:event_txtSApellidoMatKeyReleased

    private void txtSApellidoPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSApellidoPatKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtSApellidoPatKeyTyped

    private void txtSApellidoPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSApellidoPatKeyReleased

        if (txtSApellidoPat.getText().length() > 16) {             txtSApellidoPat.setText(txtSApellidoPat.getText().substring(0, 16));         }     }//GEN-LAST:event_txtSApellidoPatKeyReleased

    private void txtSNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNombreKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtSNombreKeyTyped

    private void txtSNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNombreKeyReleased

        if (txtSNombre.getText().length() > 16) {             txtSNombre.setText(txtSNombre.getText().substring(0, 16));         }     }//GEN-LAST:event_txtSNombreKeyReleased

    private void cbxSServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSServicioItemStateChanged

        FileWriter f = null;         try {             f = new FileWriter("ActualizarCurso.txt");             CambiodeItem();         } catch (IOException ex) {             Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);         } finally {             try {                 f.close();             } catch (IOException ex) {                 Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);             }         }     }//GEN-LAST:event_cbxSServicioItemStateChanged

    private void txtRPagoAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRPagoAlumnoKeyTyped

        char caracter = evt.getKeyChar();         if ((caracter < '0') || (caracter > '9')) {             if (caracter < '.' || caracter > '.') {                 evt.consume();             }         }     }//GEN-LAST:event_txtRPagoAlumnoKeyTyped

    private void txtRPagoAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRPagoAlumnoKeyReleased

        int c = 0;         String texto = txtRPagoAlumno.getText();         if (texto.length() != 0) {             for (int i = 0; i < texto.length(); i++) {                 if (texto.charAt(i) == '.') {                     c++;                 }             }             if (c == 2) {                 txtRPagoAlumno.setText(texto.substring(0, texto.length() - 1));             }             if (c > 2) {                 for (int j = 1; j < c; j++) {                     txtRPagoAlumno.setText(texto.substring(0, texto.length() - 1));                     texto = txtRPagoAlumno.getText();                 }             }             if (texto.charAt(0) == '.') {                 txtRPagoAlumno.setText("0" + texto);             }         }     }//GEN-LAST:event_txtRPagoAlumnoKeyReleased

    private void btnDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibilidadActionPerformed

        Insertar_Disponibilidad x = new Insertar_Disponibilidad();         x.setVisible(true);     }//GEN-LAST:event_btnDisponibilidadActionPerformed

    private void txtRNacimiento3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNacimiento3KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtRNacimiento3KeyTyped

    private void txtRNacimiento3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNacimiento3KeyReleased

        if (txtRNacimiento3.getText().length() > 3) {             txtRNacimiento3.setText(txtRNacimiento3.getText().substring(0, 4));         }     }//GEN-LAST:event_txtRNacimiento3KeyReleased

    private void txtRNacimiento3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRNacimiento3FocusLost

        if (recorrer(txtRNacimiento2.getText())) {             if (recorrer(txtRNacimiento3.getText())) {                 if (recorrer(txtRNacimiento1.getText())) {                     if (Integer.parseInt(txtRNacimiento1.getText()) < 1 || Integer.parseInt(txtRNacimiento1.getText()) > maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))) {                         txtRNacimiento1.setText(String.valueOf(maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))));                     }                 }             }         }     }//GEN-LAST:event_txtRNacimiento3FocusLost

    private void txtRNacimiento2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNacimiento2KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtRNacimiento2KeyTyped

    private void txtRNacimiento2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNacimiento2KeyReleased

        if (txtRNacimiento2.getText().length() > 1) {             txtRNacimiento2.setText(txtRNacimiento2.getText().substring(0, 2));             if (Integer.parseInt(txtRNacimiento2.getText()) < 0 || Integer.parseInt(txtRNacimiento2.getText()) > 12) {                 txtRNacimiento2.setText("12");             }             if (txtRNacimiento2.getText().length() == 1) {                 if (Integer.parseInt(txtRNacimiento3.getText()) < 1 || Integer.parseInt(txtRNacimiento3.getText()) > maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))) {                     txtRNacimiento3.setText(String.valueOf(maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))));                 }             }         }     }//GEN-LAST:event_txtRNacimiento2KeyReleased

    private void txtRNacimiento2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRNacimiento2FocusLost

        if (recorrer(txtRNacimiento2.getText())) {             if (recorrer(txtRNacimiento3.getText())) {                 if (recorrer(txtRNacimiento1.getText())) {                     if (Integer.parseInt(txtRNacimiento1.getText()) < 1 || Integer.parseInt(txtRNacimiento1.getText()) > maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))) {                         txtRNacimiento1.setText(String.valueOf(maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))));                     }                 }             }         }     }//GEN-LAST:event_txtRNacimiento2FocusLost

    private void btnDominioCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDominioCursosActionPerformed

        Seleccionar_CursosDominio x = new Seleccionar_CursosDominio();         x.setVisible(true);     }//GEN-LAST:event_btnDominioCursosActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed

        Seleccionar_Cursos x = new Seleccionar_Cursos();         x.setVisible(true);     }//GEN-LAST:event_btnCursoActionPerformed

    private void btnRLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRLimpiarActionPerformed

        limpiarRegistro();     }//GEN-LAST:event_btnRLimpiarActionPerformed

    private void txtCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyReleased

        if (txtCargo.getText().length() > 20) {             txtCargo.setText(txtCargo.getText().substring(0, 20));         }     }//GEN-LAST:event_txtCargoKeyReleased

    private void btnServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicioActionPerformed

        switch (cbxServicio.getSelectedIndex()) {             case 0:                 JOptionPane.showMessageDialog(this, "Seleccione un Servicio", "ERROR", JOptionPane.ERROR_MESSAGE);                 break;             case 1:                 Seleccionar_Ciclo x = new Seleccionar_Ciclo();                 x.setVisible(true);                 break;             case 2:                 Seleccionar_Asesoria y = new Seleccionar_Asesoria();                 y.setVisible(true);                 break;         }     }//GEN-LAST:event_btnServicioActionPerformed

    private void txtPagoAdmiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoAdmiKeyTyped

        char caracter = evt.getKeyChar();         if ((caracter < '0') || (caracter > '9')) {             if (caracter < '.' || caracter > '.') {                 evt.consume();             }         }     }//GEN-LAST:event_txtPagoAdmiKeyTyped

    private void txtPagoAdmiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoAdmiKeyReleased

        int c = 0;         String texto = txtPagoAdmi.getText();         if (texto.length() != 0) {             for (int i = 0; i < texto.length(); i++) {                 if (texto.charAt(i) == '.') {                     c++;                 }             }             if (c == 2) {                 txtPagoAdmi.setText(texto.substring(0, texto.length() - 1));             }             if (c > 2) {                 for (int j = 1; j < c; j++) {                     txtPagoAdmi.setText(texto.substring(0, texto.length() - 1));                     texto = txtPagoAdmi.getText();                 }             }             if (texto.charAt(0) == '.') {                 txtPagoAdmi.setText("0" + texto);             }         }     }//GEN-LAST:event_txtPagoAdmiKeyReleased

    private void txtSueldoAsesoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoAsesoriaKeyTyped

        char caracter = evt.getKeyChar();         if ((caracter < '0') || (caracter > '9')) {             if (caracter < '.' || caracter > '.') {                 evt.consume();             }         }     }//GEN-LAST:event_txtSueldoAsesoriaKeyTyped

    private void txtSueldoAsesoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoAsesoriaKeyReleased

        int c = 0;         String texto = txtSueldoAsesoria.getText();         if (texto.length() != 0) {             for (int i = 0; i < texto.length(); i++) {                 if (texto.charAt(i) == '.') {                     c++;                 }             }             if (c == 2) {                 txtSueldoAsesoria.setText(texto.substring(0, texto.length() - 1));             }             if (c > 2) {                 for (int j = 1; j < c; j++) {                     txtSueldoAsesoria.setText(texto.substring(0, texto.length() - 1));                     texto = txtSueldoAsesoria.getText();                 }             }             if (texto.charAt(0) == '.') {                 txtSueldoAsesoria.setText("0" + texto);             }         }     }//GEN-LAST:event_txtSueldoAsesoriaKeyReleased

    private void cbxRPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxRPagoItemStateChanged

        cambiarItem();     }//GEN-LAST:event_cbxRPagoItemStateChanged

    private void txtRApoderadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRApoderadoKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtRApoderadoKeyTyped

    private void txtAGSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAGSKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtAGSKeyTyped

    private void txtAGSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAGSKeyReleased

        if (txtAGS.getText().length() > 10) {             txtAGS.setText(txtAGS.getText().substring(0, 10));         }     }//GEN-LAST:event_txtAGSKeyReleased

    private void btnRAdministrativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAdministrativaActionPerformed

        registrarA = false;         registrarAD = true;         registrarD = false;         Registro(false, false, false, true);         cambiarItem();     }//GEN-LAST:event_btnRAdministrativaActionPerformed

    private void txtRNacimiento1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNacimiento1KeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtRNacimiento1KeyTyped

    private void txtRNacimiento1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNacimiento1KeyReleased

        if (txtRNacimiento1.getText().length() > 1) {             txtRNacimiento1.setText(txtRNacimiento1.getText().substring(0, 2));             if (recorrer(txtRNacimiento2.getText())) {                 if (Integer.parseInt(txtRNacimiento2.getText()) < 1 || Integer.parseInt(txtRNacimiento1.getText()) > maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))) {                     txtRNacimiento1.setText(String.valueOf(maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))));                 }             }         }     }//GEN-LAST:event_txtRNacimiento1KeyReleased

    private void txtRNacimiento1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRNacimiento1FocusLost

        if (recorrer(txtRNacimiento2.getText())) {             if (recorrer(txtRNacimiento3.getText())) {                 if (recorrer(txtRNacimiento1.getText())) {                     if (Integer.parseInt(txtRNacimiento1.getText()) < 1 || Integer.parseInt(txtRNacimiento1.getText()) > maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))) {                         txtRNacimiento1.setText(String.valueOf(maximodia(Integer.parseInt(txtRNacimiento2.getText()) - 1, Integer.parseInt(txtRNacimiento3.getText()))));                     }                 }             }         }     }//GEN-LAST:event_txtRNacimiento1FocusLost

    private void txtSueldoAcademiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoAcademiaKeyTyped

        char caracter = evt.getKeyChar();         if ((caracter < '0') || (caracter > '9')) {             if (caracter < '.' || caracter > '.') {                 evt.consume();             }         }     }//GEN-LAST:event_txtSueldoAcademiaKeyTyped

    private void txtSueldoAcademiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoAcademiaKeyReleased

        int c = 0;         String texto = txtSueldoAcademia.getText();         if (texto.length() != 0) {             for (int i = 0; i < texto.length(); i++) {                 if (texto.charAt(i) == '.') {                     c++;                 }             }             if (c == 2) {                 txtSueldoAcademia.setText(texto.substring(0, texto.length() - 1));             }             if (c > 2) {                 for (int j = 1; j < c; j++) {                     txtSueldoAcademia.setText(texto.substring(0, texto.length() - 1));                     texto = txtSueldoAcademia.getText();                 }             }             if (texto.charAt(0) == '.') {                 txtSueldoAcademia.setText("0" + texto);             }         }     }//GEN-LAST:event_txtSueldoAcademiaKeyReleased

    private void txtRDireccion2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRDireccion2KeyReleased

        if (txtRDireccion2.getText().length() > 25) {             txtRDireccion2.setText(txtRDireccion2.getText().substring(0, 25));         }     }//GEN-LAST:event_txtRDireccion2KeyReleased

    private void txtRCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRCorreoKeyReleased

        if (txtRCorreo.getText().length() > 40) {             txtRCorreo.setText(txtRCorreo.getText().substring(0, 40));         }     }//GEN-LAST:event_txtRCorreoKeyReleased

    private void txtRTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRTelefonoKeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtRTelefonoKeyTyped

    private void txtRDireccion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRDireccion1KeyReleased

        if (txtRDireccion1.getText().length() > 25) {             txtRDireccion1.setText(txtRDireccion1.getText().substring(0, 25));             txtRDireccion2.requestFocus(true);         }     }//GEN-LAST:event_txtRDireccion1KeyReleased

    private void txtRApellidoMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRApellidoMatKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtRApellidoMatKeyTyped

    private void txtRApellidoMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRApellidoMatKeyReleased

        if (txtRApellidoMat.getText().length() > 20) {             txtRApellidoMat.setText(txtRApellidoMat.getText().substring(0, 20));         }     }//GEN-LAST:event_txtRApellidoMatKeyReleased

    private void txtRApellidoPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRApellidoPatKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtRApellidoPatKeyTyped

    private void txtRApellidoPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRApellidoPatKeyReleased

        if (txtRApellidoPat.getText().length() > 20) {             txtRApellidoPat.setText(txtRApellidoPat.getText().substring(0, 20));         }     }//GEN-LAST:event_txtRApellidoPatKeyReleased

    private void txtRNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNombreKeyTyped

        bloqueoNumeros(evt);     }//GEN-LAST:event_txtRNombreKeyTyped

    private void txtRNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNombreKeyReleased

        if (txtRNombre.getText().length() > 20) {             txtRNombre.setText(txtRNombre.getText().substring(0, 20));         }     }//GEN-LAST:event_txtRNombreKeyReleased

    private void btnRegresarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarDActionPerformed

        registrarA = false;         registrarAD = false;         registrarD = false;         Registro(true, false, false, false);         limpiarRegistro();     }//GEN-LAST:event_btnRegresarDActionPerformed

    private void btnRDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRDocenteActionPerformed

        DefaultTableModel cursos = new DefaultTableModel();         cursos.addColumn("Codigo");         cursos.addColumn("Curso");         tblDominioCursos.setModel(cursos);         DefaultTableModel disponibilidad = new DefaultTableModel();         disponibilidad.addColumn("Dia");         disponibilidad.addColumn("Hora Entrada");         disponibilidad.addColumn("Hora Salida");         tblDisponibilidad.setModel(disponibilidad);         registrarA = false;         registrarAD = false;         registrarD = true;         Registro(false, false, true, false);         cambiarItem();     }//GEN-LAST:event_btnRDocenteActionPerformed

    private void btnRAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAlumnosActionPerformed

        registrarA = true;         registrarAD = false;         registrarD = false;         Registro(false, true, false, false);     }//GEN-LAST:event_btnRAlumnosActionPerformed

    private void txtSPDocenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSPDocenteKeyReleased

    }//GEN-LAST:event_txtSPDocenteKeyReleased

    private void txtSPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSPrecioKeyReleased

    }//GEN-LAST:event_txtSPrecioKeyReleased

    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtCargoKeyTyped

    private void btnAbrirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirFotoActionPerformed
        File fileImagen = null;         
        getFilechooser().addChoosableFileFilter(filter);       
        int returnVal = getFilechooser().showOpenDialog(this);         
        if (returnVal == getFilechooser().APPROVE_OPTION) {
            fileImagen = getFilechooser().getSelectedFile();
        }
        getTxtRFoto().setText(fileImagen.toString());               
        if (fileImagen != null) {           
            cargarImagen(getjDesktopPane1(), fileImagen);    
        }   
    }//GEN-LAST:event_btnAbrirFotoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         if (alumno) {            
             if (recorrer(txtCodigo.getText())&&recorrer(txtAsisServicio.getText())) {   
                 buscarAsistenciaAlumno();
                 llenarCamposAlumno();
             }         
             else {        
                 JOptionPane.showMessageDialog(this, "Falta Codigo y/o Servicio", "ERROR", JOptionPane.ERROR_MESSAGE);     
             }        
        } 
        else{    
            if (administrativo){          
                if (recorrer(txtCodigo.getText())){     
                    buscarAsistenciaAdministrativo();   
                    llenarCamposAdmi();
                } else {                     
                    JOptionPane.showMessageDialog(this, "INGRESE UN CODIGO", "ERROR", JOptionPane.ERROR_MESSAGE);  
                }         
            } 
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAsisBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsisBuscarActionPerformed
        if(recorrer(txtMACiclo.getText()))
            buscarAsis();
        else
            JOptionPane.showMessageDialog(this,"Escoga un Ciclo o Asesoria");
    }//GEN-LAST:event_btnAsisBuscarActionPerformed

    private void btnAsisServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsisServicioActionPerformed
        switch(cbxAsisServ.getSelectedIndex()){
            case 0:JOptionPane.showMessageDialog(this, "Seleccione un Servicio","ERROR",JOptionPane.ERROR_MESSAGE);break;
            case 1:Seleccionar_Ciclo x = new Seleccionar_Ciclo();
                    x.setVisible(true);break;
            case 2:Seleccionar_Asesoria y = new Seleccionar_Asesoria();
                    y.setVisible(true);break;
        }
    }//GEN-LAST:event_btnAsisServicioActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        limpiarCalendario(); 
        MesAux--;      
        if (MesAux == -1) {
            MesAux = 11;       
            AAux--;    
        }         
        CalendarioAnterior(); 
        if (busqueda) {  
            if(alumno)
            buscarAsistenciaAlumno();   
            if(administrativo){
            buscarAsistenciaAdministrativo();
            }
        }
        
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        validateDir("D:\\Test\\",true);
        File f = new File("TEST.docx");
        if(f.exists()){
            String direccion=String.valueOf(f.getAbsoluteFile());
            fileMove(direccion,"D:\\Test\\TEST.docx");
        }
        try { 
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + "D:\\Test\\TEST.docx");  
        } catch (Exception e) {      
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);    
        } 
    }//GEN-LAST:event_btnTestActionPerformed

    private void tblRecientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblRecientesAncestorAdded
        
    }//GEN-LAST:event_tblRecientesAncestorAdded

    private void btnMAAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAAceptarActionPerformed
        if(recorrer(txtMAIngresar.getText())&&txtMAIngresar.getText().length()==5){
            System.out.println("ENTRO");
            switch (cbxMA.getSelectedIndex()) { 
                case 3:   System.out.println("ENTROA");       
                    buscarAdministrativo();       
                    break;            
                case 2:           System.out.println("ENTROD"); 
                    buscarDocente();   
                    break;    
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Ingrese correctamente el codigo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMAAceptarActionPerformed

    private void btnMAAEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAAEntradaActionPerformed
        if(cbxMAHora.getSelectedIndex()!=0){
            if(cbxMAHora.getSelectedIndex()==1){
                if (busquedaadmi) {  
                    registrarAsistencia("F");    
                } 
                else {   
                    if (busquedadoc) { 
                        String tipo="A";
                        switch(cbxMATipoS.getSelectedIndex()){
                            case 1:tipo="A";registrarAsistencia(tipo); break;
                            case 2:tipo="S";registrarAsistencia(tipo); break;
                        }
                    } 
                    else{
                       JOptionPane.showMessageDialog(this, "Seleccione un servicio o Ingrese un codigo", "ERROR", JOptionPane.ERROR_MESSAGE);  
                    }
                }
            }
            else{
                if(cbxMAHora.getSelectedIndex()==2){
                    if (busquedaadmi) {  
                        actualizarAsistencia("F");    
                    } 
                    else {   
                        if (busquedadoc) { 
                            String tipo="A";
                            switch(cbxMATipoS.getSelectedIndex()){
                                case 1:tipo="A";actualizarAsistencia(tipo); break;
                                case 2:tipo="S";actualizarAsistencia(tipo); break;
                            }
                               
                        } 
                        else{
                           JOptionPane.showMessageDialog(this, "Ingrese codigo", "ERROR", JOptionPane.ERROR_MESSAGE);  
                        }
                    }
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Va a Marcar Asistencia de Entrada o de Salida? Seleccione","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMAAEntradaActionPerformed

    private void btnNRegistrarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNRegistrarDActionPerformed
        if (registrarA) {  
            if (verificarRegistroAlumno()) {      
                switch (cbxServicio.getSelectedIndex()) {    
                    case 1:                    
                        RegistrarAlumnoCiclo();       
                        break;                
                    case 2:                  
                        RegistrarAlumnoAsesoria();       
                        break;                
                }        
            } 
            else {  
                JOptionPane.showMessageDialog(this, "Campos Vacios o mal llenados", "ERROR", JOptionPane.ERROR_MESSAGE);      
            }    
        }
        else {    
            if (registrarD) {  
                registrarDocente();   
            }
            else {   
                if (registrarAD) {    
                    registrarAdministrativo();    
                }          
            }       
        }
    }//GEN-LAST:event_btnNRegistrarDActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Insertar_PagoAdmi x = new Insertar_PagoAdmi();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Insertar_PagoDoc x = new Insertar_PagoDoc();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Insertar_PagoAlum x = new Insertar_PagoAlum();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (contrasena(con)) {
        Mostrar_ReporteAsesoria x = new Mostrar_ReporteAsesoria();
        x.setVisible(true);}
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (contrasena(con)) {
        Mostrar_ReporteAcademia x = new Mostrar_ReporteAcademia();
        x.setVisible(true);}
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btnMACicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMACicloActionPerformed
        switch(cbxAsisServicio.getSelectedIndex()){
            case 0:JOptionPane.showMessageDialog(this,"Seleccione Academia o Asesoria","ERROR",JOptionPane.ERROR_MESSAGE);break;
            case 1:Seleccionar_Ciclo x = new Seleccionar_Ciclo();        
                    x.setVisible(true);break;
            case 2:Seleccionar_Asesoria y = new Seleccionar_Asesoria();        
                    y.setVisible(true);break;
        }  
    }//GEN-LAST:event_btnMACicloActionPerformed

    private void cbxAsisServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAsisServicioItemStateChanged

        txtMACiclo.setText("");     }//GEN-LAST:event_cbxAsisServicioItemStateChanged

    private void pnlRegistroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlRegistroAncestorAdded
        
    }//GEN-LAST:event_pnlRegistroAncestorAdded

    private void pnlServiciosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlServiciosAncestorAdded
        CambiodeItem();
    }//GEN-LAST:event_pnlServiciosAncestorAdded

    private void pnlMAsistenciaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlMAsistenciaAncestorAdded
        switch (cbxMA.getSelectedIndex()) {         
            case 0: MarcarAsistencia(false, false, false);
                    busquedaadmi=false;
                    busquedadoc=false;
                    break;            
            case 1:MarcarAsistencia(true, false, false);   
            busquedaadmi=false;
                    busquedadoc=false;
                    break;   
                
            case 2:MarcarAsistencia(false, true, false);      
            busquedaadmi=false;
                    busquedadoc=true;
                    break;        
            case 3:MarcarAsistencia(false, false, true);   
            busquedaadmi=true;
                    busquedadoc=false;
                    break;       
        }                                   
    }//GEN-LAST:event_pnlMAsistenciaAncestorAdded

    private void pnlAsistenciaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlAsistenciaAncestorAdded
        calendario();
    }//GEN-LAST:event_pnlAsistenciaAncestorAdded

    private void tblMAAsistenciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMAAsistenciasKeyPressed
       char caracter = evt.getKeyChar();
       restringir();
       if(caracter !='X'||caracter!='x'||caracter!=evt.VK_UP||caracter!=evt.VK_DOWN||caracter!=evt.VK_LEFT||caracter!=evt.VK_RIGHT||caracter!=evt.VK_ENTER){
          
       }
       else{
           evt.consume();
       }
    }//GEN-LAST:event_tblMAAsistenciasKeyPressed

    private void tblMAAsistenciasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMAAsistenciasMousePressed
        restringir();
    }//GEN-LAST:event_tblMAAsistenciasMousePressed

    private void tblMAAsistenciasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMAAsistenciasKeyReleased
        restringir();
    }//GEN-LAST:event_tblMAAsistenciasKeyReleased

    private void btnMAGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAGuardarActionPerformed
       if(buscaasistencia){
           boolean v=true;
          for (int i = 0; i < tblMAAsistencias.getRowCount(); i++) {      
             v=v&&GuardarAsistencia(i);  
          }
          if(v){
               JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
          }
          
       }
    }//GEN-LAST:event_btnMAGuardarActionPerformed

    private void btnObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObservacionActionPerformed
        String obs=null;
        if(Observacion==false){
            Observacion = true; 
            obs="activado";
        }
        else{
            if(Observacion){
                Observacion = false; 
                obs="desactivado";
            }
        }
        JOptionPane.showMessageDialog(this,"Observacion esta "+obs,"Informacion",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnObservacionActionPerformed

    private void txtFechaI1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaI1KeyTyped

    private void txtFechaI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaI2KeyTyped

    private void txtFechaI3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaI3KeyTyped

    private void txtFechaI1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI1KeyReleased
        if(txtFechaI1.getText().length()>1){
              txtFechaI1.setText(txtFechaI1.getText().substring(0, 2));
              if(recorrer(txtFechaI2.getText())){
                  if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))){
                      txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaI1KeyReleased

    private void txtFechaI2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI2KeyReleased
        if(txtFechaI2.getText().length()>1){
              txtFechaI2.setText(txtFechaI2.getText().substring(0, 2));
              if(Integer.parseInt(txtFechaI2.getText())<1||Integer.parseInt(txtFechaI2.getText())>12){
                  txtFechaI2.setText("12");
              }
              if(txtFechaI2.getText().length()==1){
                  if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))){
                      txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaI2KeyReleased

    private void txtFechaI3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI3KeyReleased
        if(txtFechaI3.getText().length()>3){
              txtFechaI3.setText(txtFechaI3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFechaI3KeyReleased

    private void txtFechaI1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaI1FocusLost
        if(recorrer(txtFechaI2.getText())){
            if(recorrer(txtFechaI1.getText())){
                if(recorrer(txtFechaI3.getText())){
                      if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))){
                          txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaI1FocusLost

    private void txtFechaI2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaI2FocusLost
        if(recorrer(txtFechaI2.getText())){
            if(recorrer(txtFechaI1.getText())){
                if(recorrer(txtFechaI3.getText())){
                      if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))){
                          txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaI2FocusLost

    private void txtFechaI3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaI3FocusLost
        if(recorrer(txtFechaI2.getText())){
            if(recorrer(txtFechaI1.getText())){
                if(recorrer(txtFechaI3.getText())){
                      if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))){
                          txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText())-1,Integer.parseInt(txtFechaI3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaI3FocusLost

    private void pnlBalanceAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnlBalanceAncestorAdded
         String M=Integer.toString(c.get(Calendar.MONTH)+1);
         String A=Integer.toString(c.get(Calendar.YEAR));
         txtMesB.setText(M);
         txtAnoB.setText(A);
         txtMesB.requestFocus(true);
         mostrarBalance();
    }//GEN-LAST:event_pnlBalanceAncestorAdded

    private void txtMesBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesBKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtMesBKeyTyped

    private void txtAnoBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoBKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtAnoBKeyTyped

    private void txtMesBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesBKeyReleased
        if(txtMesB.getText()!=null){
            if(Integer.parseInt(txtMesB.getText())<1){
                  txtAnoB.setText("1");
            }
            if(Integer.parseInt(txtMesB.getText())>12){
                  txtAnoB.setText("12");
            }
        }
    }//GEN-LAST:event_txtMesBKeyReleased

    private void txtAnoBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoBKeyReleased
        if(txtAnoB.getText().length()>3){
              txtAnoB.setText(txtAnoB.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtAnoBKeyReleased

    private void txtAnoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoBKeyPressed
        String A=Integer.toString(c.get(Calendar.YEAR));
        if(evt.getKeyCode()==evt.VK_CONTROL)
            ctrl=false;
        if(ctrl==false){
            if(evt.getKeyCode()==evt.VK_V){
                txtAnoB.setText(A);
                ctrl=true;
            }
        }
        if(evt.getKeyCode()==evt.VK_ENTER){
            mostrarBalance();
        }
    }//GEN-LAST:event_txtAnoBKeyPressed

    private void txtMesBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesBKeyPressed
        String A=Integer.toString(c.get(Calendar.YEAR));
        if(evt.getKeyCode()==evt.VK_CONTROL)
            ctrlm=false;
        if(ctrlm==false){
            if(evt.getKeyCode()==evt.VK_V){
                txtMesB.setText(A);
                ctrlm=true;
            }
        }
        if(evt.getKeyCode()==evt.VK_ENTER){
            mostrarBalance();
        }
    }//GEN-LAST:event_txtMesBKeyPressed

    private void cbxBalancesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBalancesItemStateChanged
        switch(cbxBalances.getSelectedIndex()){
            case 0: cbxTipoBalances.removeAllItems();
                    cbxTipoBalances.addItem("Seleccione Uno");
                    break;
            case 1: cbxTipoBalances.removeAllItems();
                    cbxTipoBalances.addItem("Seleccione Uno");
                    cbxTipoBalances.addItem("Academia");
                    cbxTipoBalances.addItem("Asesorias");
                    cbxTipoBalances.addItem("Asignaciones");
                    cbxTipoBalances.addItem("Particulares");
                    break;
            case 2: cbxTipoBalances.removeAllItems();
                    cbxTipoBalances.addItem("Seleccione Uno");
                    cbxTipoBalances.addItem("Docentes y Admi.");
                    break;
        }
    }//GEN-LAST:event_cbxBalancesItemStateChanged

    private void btnIngresosBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresosBActionPerformed
       if(recorrer(txtMesB.getText())&&recorrer(txtAnoB.getText())){     
            String M=txtMesB.getText();
            String A=txtAnoB.getText();
            validateDir("D:\\Reportes",true);
            switch(cbxBalances.getSelectedIndex()){
                case 0:JOptionPane.showMessageDialog(this,"Eliga Tipo de balance que desea ver","ERROR",JOptionPane.ERROR_MESSAGE);break;
                case 1: validateDir("D:\\Reportes\\Ingresos",true);
                        switch(cbxTipoBalances.getSelectedIndex()){
                            case 0:JOptionPane.showMessageDialog(this,"Eliga un tipo de Ingreso","ERROR",JOptionPane.ERROR_MESSAGE);break;
                            case 1:excelAcademia(M,A,true);break;
                            case 2:excelAsesoria(M,A,true);break;
                            case 3:excelAsignacion(M,A,true);break;
                            case 4:excelParticular(M,A,true);break;
                        }break;
                case 2: validateDir("D:\\Reportes\\Egresos",true);
                        switch(cbxTipoBalances.getSelectedIndex()){
                            case 0:JOptionPane.showMessageDialog(this,"Eliga un tipo de Egreso","ERROR",JOptionPane.ERROR_MESSAGE);break;
                            case 1:excelColaborador(M,A,true);break;
                        }break;
            }
       }
       else{
           JOptionPane.showMessageDialog(this,"Ingrese una Fecha","ERROR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnIngresosBActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if(contrasena(con)){
            Agenda_Control x = new Agenda_Control();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        RP_Descuentos x = new RP_Descuentos();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(recorrer(txtMesB.getText())&&recorrer(txtAnoB.getText())){ 
             validateDir("D:\\Reportes",true);
             validateDir("D:\\Reportes\\Ingresos",true);
             validateDir("D:\\Reportes\\Egresos",true);
             String M=txtMesB.getText();
             String A=txtAnoB.getText();
             excelAcademia(M,A,false);
             excelAsesoria(M,A,false);
             excelAsignacion(M,A,false);
             excelParticular(M,A,false);
             excelColaborador(M,A,false);
        try {
            Runtime r = Runtime.getRuntime();
	    Process p = null;
            p = r.exec("explorer.exe "+"D:\\Reportes");
        }   
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir la carpeta problablemente fue borrada","ERROR",JOptionPane.ERROR_MESSAGE);
        }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(recorrer(txtMesB.getText())&&recorrer(txtAnoB.getText())){
            mostrarBalance();
        }
        else{
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
        switch (cbxServicio.getSelectedIndex()) {     
            case 0:       
                lblCurso.setVisible(false);      
                txtCurso.setVisible(false);       
                btnCurso.setVisible(false);            
                btnTest.setVisible(false);               
                btnObservacion.setVisible(false); 
                lblTest.setVisible(false);
                lblObservacion.setVisible(false);
                Observacion = false;          
                break;            
            case 1:          
                lblCurso.setVisible(false);    
                txtCurso.setVisible(false);  
                btnCurso.setVisible(false);    
                txtServicio.setText("");        
                btnTest.setVisible(false);       
                btnObservacion.setVisible(false);  
                lblTest.setVisible(false);
                lblObservacion.setVisible(false);
                Observacion = false;              
                break;            
            case 2:               
                lblCurso.setVisible(true); 
                txtCurso.setVisible(true);     
                btnCurso.setVisible(true);     
                btnTest.setVisible(true);      
                btnObservacion.setVisible(true);
                lblTest.setVisible(true);
                lblObservacion.setVisible(true);
                txtServicio.setText("");         
                break;      
        }  
    }//GEN-LAST:event_cbxServicioItemStateChanged

private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
    Listado_Asignacion x = new Listado_Asignacion();
    x.setVisible(true);
}//GEN-LAST:event_jMenuItem11ActionPerformed

private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
    Listado_Particular x = new Listado_Particular();
    x.setVisible(true);
}//GEN-LAST:event_jMenuItem12ActionPerformed

private void txtRTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRTelefonoKeyReleased
    if(registrarD||registrarAD){
        if (txtRTelefono.getText().length() > 9) {        
        txtRTelefono.setText(txtRTelefono.getText().substring(0, 9));      
    }
    }
    if(registrarA){
            if (txtRTelefono.getText().length() > 7) {        
            txtRTelefono.setText(txtRTelefono.getText().substring(0, 7));      
        }
    }
}//GEN-LAST:event_txtRTelefonoKeyReleased

private void cbxSTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSTipoItemStateChanged
    boolean cbx = false;    
    switch (cbxSTipo.getSelectedIndex()) { 
        case 0: cbx=false; break;
        case 1:                
            cbx = false;      
            break;         
        case 2:     
                cbx = true;      
                break;     
    }        
    lblSDireccion.setVisible(cbx);     
    txtSDireccion1.setVisible(cbx); 
    txtSDireccion2.setVisible(cbx);        
}//GEN-LAST:event_cbxSTipoItemStateChanged

private void btnAsisDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsisDocenteActionPerformed
    Asistencia_Docente x = new Asistencia_Docente();
    x.setVisible(true);
}//GEN-LAST:event_btnAsisDocenteActionPerformed

private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
limpiarCalendario();        
MesAux++;       
if (MesAux == 12) {  
    MesAux = 0;    
    AAux++;      
}      
CalendarioSiguiente();     
if (busqueda) {          
    if(alumno)
    buscarAsistenciaAlumno();   
    if(administrativo){
    buscarAsistenciaAdministrativo();
    }  
}                                            

}//GEN-LAST:event_btnSiguienteActionPerformed

private void btnActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualActionPerformed
limpiarCalendario();  
MesAux = Integer.parseInt(M); 
AAux = Integer.parseInt(A);     
calendario();       
if (busqueda) {    
    if(alumno)
    buscarAsistenciaAlumno();   
    if(administrativo){
    buscarAsistenciaAdministrativo();
    }  
}  
}//GEN-LAST:event_btnActualActionPerformed

private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
    Profesor_Dictando x = new Profesor_Dictando();
    x.setVisible(true);
}//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed

        Modificar_Matricula x = new Modificar_Matricula();         x.setVisible(true);     }//GEN-LAST:event_jMenu5ActionPerformed

    private void menuModificarSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarSalonesActionPerformed

        if (contrasena(con)) {             Modificar_Salones x = new Modificar_Salones();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarSalonesActionPerformed

    private void menuModificarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarNotasActionPerformed

        if (contrasena(con)) {             Modificar_Notas x = new Modificar_Notas();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarNotasActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        if (contrasena(con)) {             Modificar_Matricula x = new Modificar_Matricula();             x.setVisible(true);         }     }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void menuModificarEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarEvaluacionActionPerformed

        if (contrasena(con)) {             Modificar_Evaluacion x = new Modificar_Evaluacion();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarEvaluacionActionPerformed

    private void menuModificarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarDocenteActionPerformed

        if (contrasena(con)) {             Modificar_Docente x = new Modificar_Docente();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarDocenteActionPerformed

    private void menuModificarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarCursosActionPerformed

        if (contrasena(con)) {             Modificar_Cursos x = new Modificar_Cursos();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarCursosActionPerformed

    private void menuModificarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarContrasenaActionPerformed

        if (contrasena(con)) {             Modificar_Contrasena x = new Modificar_Contrasena();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarContrasenaActionPerformed

    private void menuModificarParticularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarParticularActionPerformed

        if (contrasena(con)) {             Modificar_Particular x = new Modificar_Particular();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarParticularActionPerformed

    private void menuModificarCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarCiclosActionPerformed

        if (contrasena(con)) {             Modificar_Ciclos x = new Modificar_Ciclos();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarCiclosActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        if (contrasena(con)) {             Modificar_Asistencia_Docente_Admi x = new Modificar_Asistencia_Docente_Admi();             x.setVisible(true);         }     }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void menuModificarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarAsistenciaActionPerformed

        if (contrasena(con)) {             Modificar_Asistencia x = new Modificar_Asistencia();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarAsistenciaActionPerformed

    private void menuModificarAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarAsignacionActionPerformed

        if (contrasena(con)) {             Modificar_Asignacion x = new Modificar_Asignacion();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarAsignacionActionPerformed

    private void menuModificarAsesoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarAsesoriasActionPerformed

        if (contrasena(con)) {             Modificar_Asesorias x = new Modificar_Asesorias();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarAsesoriasActionPerformed

    private void menuModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarAlumnoActionPerformed

        if (contrasena(con)) {             Modificar_Alumno x = new Modificar_Alumno();             x.setVisible(true);         }     }//GEN-LAST:event_menuModificarAlumnoActionPerformed

    private void manuModificarAdministrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manuModificarAdministrativoActionPerformed

        if (contrasena(con)) {             Modificar_Administrativo x = new Modificar_Administrativo();             x.setVisible(true);         }     }//GEN-LAST:event_manuModificarAdministrativoActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        if (contrasena(con)) { 
            Modificar_Horarios x = new Modificar_Horarios();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        if (contrasena(con)) {
            Eliminar_Salones_Ciclo x = new Eliminar_Salones_Ciclo();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        if (contrasena(con)) {
            RP_Docente_Academia x = new RP_Docente_Academia();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        if (contrasena(con)) {
            RP_Docente_Asesoria x = new RP_Docente_Asesoria();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        Disponibilidad_Docente x = new Disponibilidad_Docente();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        Dominio_Docente x = new Dominio_Docente();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
         if (contrasena(con)) {
            Modificar_Descuentos x = new Modificar_Descuentos(); 
            x.setVisible(true);
         }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        Listado_Curso_Docente x = new Listado_Curso_Docente();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        if (contrasena(con)) {
            Listado_Salones_Ciclo x = new Listado_Salones_Ciclo();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        if (contrasena(con)) {
            Insertar_Salones_Ciclos x = new Insertar_Salones_Ciclos();
            x.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyReleased
        if(txtRuc.getText().length()>11){
              txtRuc.setText(txtRuc.getText().substring(0, 11));
        }
    }//GEN-LAST:event_txtRucKeyReleased

    private void cbxMATipoSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMATipoSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMATipoSActionPerformed

    private void txtMAIngresarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMAIngresarKeyTyped
        char caracter = evt.getKeyChar();
          if(((caracter < '0') ||(caracter > '9'))&&((caracter < 'a') ||(caracter > 'z'))&&((caracter < 'A') ||(caracter > 'Z'))){
              evt.consume();
          }
    }//GEN-LAST:event_txtMAIngresarKeyTyped

    private void txtMAIngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMAIngresarKeyReleased
        if(txtCodigo.getText().length()>5){
             txtCodigo.setText(txtCodigo.getText().substring(0, 5));
        }
    }//GEN-LAST:event_txtMAIngresarKeyReleased

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        if (contrasena(con)) {
            Eliminar_Disponibilidad x = new Eliminar_Disponibilidad(); 
            x.setVisible(true);
         }
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
         if (contrasena(con)) {
            Eliminar_Dominio_Docente x = new Eliminar_Dominio_Docente(); 
            x.setVisible(true);
         }
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        Listar_Observados x = new Listar_Observados();
        x.setVisible(true);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void cbxMAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMAItemStateChanged
        limpiar();
        switch (cbxMA.getSelectedIndex()) {         
            case 0: MarcarAsistencia(false, false, false);
                    busquedaadmi=false;
                    busquedadoc=false;
                    break;            
            case 1:MarcarAsistencia(true, false, false);   
            busquedaadmi=false;
                    busquedadoc=false;
                    break;   
                
            case 2:MarcarAsistencia(false, true, false);      
            busquedaadmi=false;
                    busquedadoc=true;
                    break;        
            case 3:MarcarAsistencia(false, false, true);   
            busquedaadmi=true;
                    busquedadoc=false;
                    break;       
        }  
    }//GEN-LAST:event_cbxMAItemStateChanged

    private void jLabel4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4AncestorAdded
     public void llenarCamposAlumno(){
         try{
            CallableStatement cst = con.prepareCall("{call usp_BusquedaAlumnosActivos(?)}");
            cst.setString(1,txtCodigo.getText());
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[13];
                for(int i=0;i<13;i++){
                    dato[i]=r.getString(i+1);
                }
                txtNombreAsis.setText(borrarespacios(String.valueOf(dato[1])));
                txtApellidoPatAsis.setText(borrarespacios(String.valueOf(dato[3])));
                txtApellidoMatAsis.setText(borrarespacios(String.valueOf(dato[2])));
            }
            r.close();
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Codigo ERRONEO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
     }
     public void llenarCamposAdmi(){
         try {
            String codigo = txtCodigo.getText();
            CallableStatement cst = con.prepareCall("{call usp_ConsultarFuncional(?)}");
            cst.setString(1,codigo);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[14];
                for(int i=0;i<14;i++){
                    dato[i]=r.getString(i+1);
                }
                txtNombreAsis.setText(String.valueOf(dato[1]));
                txtApellidoPatAsis.setText(String.valueOf(dato[2]));
                txtApellidoMatAsis.setText(String.valueOf(dato[3]));
                String direccion=borrarespacios(String.valueOf(dato[4]));
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Codigo Erroneo","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Modificar_Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public void crearfila(int f,HSSFSheet hoja,String linea,int j){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,"=");
       for(int i=0;i<j;i++){
           crearcelda(i,fila,String.valueOf(t.nextToken()));
       }
    }
    public void crearcelda(int i,HSSFRow f,String txt){
        HSSFCell celda = f.createCell(i);
        celda.setCellValue(txt);
    }
    public boolean contrasena(Connection con){
        char c;
        String contrasena = null, usuario = null;
        usuario=JOptionPane.showInputDialog("Ingrese Usuario");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        Object[] obj = {"Ingrese Contraseña:\n\n", passwordField};
        Object stringArray[] = {"OK","Cancel"};
        if (JOptionPane.showOptionDialog(null, obj, "Necesita Contraseña",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj) == JOptionPane.YES_OPTION)
        contrasena = String.valueOf(passwordField.getPassword());
        boolean v=false;
        if(recorrer(usuario)&&recorrer(contrasena)&&usuario.length()<=15&&contrasena.length()<=15){
            try{
                usuario = borrarespacios(usuario);
                contrasena =borrarespacios(contrasena);
                CallableStatement cst = con.prepareCall("{call dbo.usp_chekPass(?,?,?)}");
                cst.setString(1,usuario);
                cst.setString(2,contrasena);
                cst.registerOutParameter(3,Types.CHAR);
                int rpta = cst.executeUpdate();
                String c1=cst.getString(3);
                cst.close();
                c=c1.charAt(0);
                if(rpta>=1){
                    if(c=='a'){
                        v=true;
                    }
                    if(c=='b'){
                        v=false;
                        JOptionPane.showMessageDialog(this, "Usuario o contraseña erroneos","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }
             } 
             catch (SQLException ex) {
                 ex.printStackTrace();
                JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
             }
        }
        else{
            JOptionPane.showMessageDialog(this,"Ingrese correctamente el usuario y/o contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return v;
    }
    public void excelAcademia(String mes,String ano,boolean v){
        Object dato[];
        try {
            FileWriter f = new FileWriter("ExcelRPAcademia.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Fecha de Pago=Codigo de Alumno=Nombres=Cantidad Pagada=");
            p.close();
        } catch (IOException ex) {}
        try {
            CallableStatement cst = con.prepareCall("{call usp_RPReporteIngresoPagoAlumnoAcademia(?,?)}");
            cst.setByte(1, (byte)Integer.parseInt(mes));
            cst.setShort(2,(short)Integer.parseInt(ano));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelRPAcademia.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"=");
                    p.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Hoja 1");
        try {
            String linea;
            int i=0;
            FileReader m = new FileReader("ExcelRPAcademia.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea,4);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Reportes\\Ingresos\\RPIngresosAcademia-"+mes+"-"+ano+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        if(v){
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Reportes\\Ingresos\\RPIngresosAcademia-"+mes+"-"+ano+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void excelAsesoria(String mes,String ano,boolean v){
        Object dato[];
        try {
            FileWriter f = new FileWriter("ExcelRPAsesoria.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Fecha de Pago=Codigo de Alumno=Nombres=Cantidad Pagada=");
            p.close();
        } catch (IOException ex) {}
        try {
            CallableStatement cst = con.prepareCall("{call usp_RPReporteIngresoPagoAlumnoAsesoria(?,?)}");
            cst.setByte(1, (byte)Integer.parseInt(mes));
            cst.setShort(2,(short)Integer.parseInt(ano));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelRPAsesoria.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"=");
                    p.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Hoja 1");
        try {
            String linea;
            int i=0;
            FileReader m = new FileReader("ExcelRPAsesoria.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea,4);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Reportes\\Ingresos\\RPIngresosAsesoria-"+mes+"-"+ano+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        if(v){
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Reportes\\Ingresos\\RPIngresosAsesoria-"+mes+"-"+ano+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void excelAsignacion(String mes,String ano,boolean v){
        Object dato[];
        try {
            FileWriter f = new FileWriter("ExcelRPAsignacion.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Fecha de Entrega=Codigo de Asignacion=Nombre del Cliente=Codigo del Profesor=Nombre del Profesor=Pago al Profesor=Costo de Asignacion=");
            p.close();
        } catch (IOException ex) {}
        try {
            CallableStatement cst = con.prepareCall("{call usp_RPReporteIngresoAsignaciones(?,?)}");
            cst.setByte(1, (byte)Integer.parseInt(mes));
            cst.setShort(2,(short)Integer.parseInt(ano));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[7];
                for(int i=0;i<7;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelRPAsignacion.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"="+dato[4]+"="+dato[5]+"="+dato[6]+"=");
                    p.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Hoja 1");
        try {
            String linea;
            int i=0;
            FileReader m = new FileReader("ExcelRPAsignacion.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea,7);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Reportes\\Ingresos\\RPIngresosAsignacion-"+mes+"-"+ano+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        if(v){
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Reportes\\Ingresos\\RPIngresosAsignacion-"+mes+"-"+ano+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void excelParticular(String mes,String ano,boolean v){
        Object dato[];
        try {
            FileWriter f = new FileWriter("ExcelRPParticular.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Fecha de PEgo=Codigo del Alumno=Nombre del Alumno=Cantidad Pagada=");
            p.close();
        } catch (IOException ex) {}
        try {
            CallableStatement cst = con.prepareCall("{call usp_RPReporteIngresoPagoAlumnoAcademia(?,?)}");
            cst.setByte(1, (byte)Integer.parseInt(mes));
            cst.setShort(2,(short)Integer.parseInt(ano));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelRPParticular.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"=");
                    p.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Hoja 1");
        try {
            String linea;
            int i=0;
            FileReader m = new FileReader("ExcelRPParticular.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea,4);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Reportes\\Ingresos\\RPIngresosParticular-"+mes+"-"+ano+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        if(v){
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Reportes\\Ingresos\\RPIngresosParticular-"+mes+"-"+ano+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void excelColaborador(String mes,String ano,boolean v){
        Object dato[];
        try {
            FileWriter f = new FileWriter("ExcelRPColaborador.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Fecha de Pago=Codigo de Colaborador=Nombre del Colaborador=Pago=");
            p.close();
        } catch (IOException ex) {}
        try {
            CallableStatement cst = con.prepareCall("{call usp_RPReportePagoColaboradores(?,?)}");
            cst.setByte(1, (byte)Integer.parseInt(mes));
            cst.setShort(2,(short)Integer.parseInt(ano));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelRPColaborador.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"=");
                    p.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Hoja 1");
        try {
            String linea;
            int i=0;
            FileReader m = new FileReader("ExcelRPColaborador.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea,4);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Reportes\\Egresos\\RPEgresosColaborador-"+mes+"-"+ano+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        if(v){
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Reportes\\Egresos\\RPEgresosColaborador-"+mes+"-"+ano+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void mostrarBalance(){
        balanceAcademia();
        balanceAsesoria();
        balanceAsignacion();
        balanceParticular();
        balanceColaborador();
        double total=0;
        if(recorrer(txtAcademiaB.getText())&&recorrer(txtAsesoriaB.getText())&&recorrer(txtAsignacionesB.getText())&&recorrer(txtParticularesB.getText())){
           total=Double.parseDouble(txtAcademiaB.getText())+Double.parseDouble(txtAsesoriaB.getText())+Double.parseDouble(txtAsignacionesB.getText())+Double.parseDouble(txtParticularesB.getText());
        }
        txtTIngresosB.setText(Double.toString(total));
    }
    public void balanceAcademia(){
        try{
            int mes=Integer.parseInt(txtMesB.getText());
            int ano=Integer.parseInt(txtAnoB.getText());
            double ingreso=0;
            CallableStatement cst1 = con.prepareCall("{call usp_RPTotalIngresoAlumnoAcademia(?,?,?)}");
            cst1.setByte(1, (byte)mes);
            cst1.setShort(2,(short)ano);
            cst1.registerOutParameter(3,java.sql.Types.SMALLINT);
            int rpta=cst1.executeUpdate();
            ingreso = cst1.getShort(3);
            txtAcademiaB.setText(Double.toString(ingreso));
            cst1.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error en el procedure","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void balanceAsesoria(){
        try{
            int mes=Integer.parseInt(txtMesB.getText());
            int ano=Integer.parseInt(txtAnoB.getText());
            double ingreso;
            CallableStatement cst1 = con.prepareCall("{call usp_RPTotalIngresoAlumnoAsesoria(?,?,?)}");
            cst1.setByte(1, (byte)mes);
            cst1.setShort(2,(short)ano);
            cst1.registerOutParameter(3,java.sql.Types.SMALLINT);
            int rpta=cst1.executeUpdate();
            ingreso = cst1.getShort(3);
            txtAsesoriaB.setText(Double.toString(ingreso));
            cst1.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error en el procedure","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void balanceAsignacion(){
        try{
            int mes=Integer.parseInt(txtMesB.getText());
            int ano=Integer.parseInt(txtAnoB.getText());
            double ingreso;
            CallableStatement cst1 = con.prepareCall("{call usp_RPTotalIngresoAsignaciones(?,?,?)}");
            cst1.setByte(1, (byte)mes);
            cst1.setShort(2,(short)ano);
            cst1.registerOutParameter(3,java.sql.Types.SMALLINT);
            int rpta=cst1.executeUpdate();
            ingreso = cst1.getShort(3);
            txtAsignacionesB.setText(Double.toString(ingreso));
            cst1.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error en el procedure","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void balanceParticular(){
        try{
            int mes=Integer.parseInt(txtMesB.getText());
            int ano=Integer.parseInt(txtAnoB.getText());
            double ingreso;
            CallableStatement cst1 = con.prepareCall("{call usp_RPTotalIngresoClaseParticular(?,?,?)}");
            cst1.setByte(1, (byte)mes);
            cst1.setShort(2,(short)ano);
            cst1.registerOutParameter(3,java.sql.Types.SMALLINT);
            int rpta=cst1.executeUpdate();
            ingreso = cst1.getShort(3);
            txtParticularesB.setText(Double.toString(ingreso));
            cst1.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error en el procedure","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void balanceColaborador(){
        try{
            int mes=Integer.parseInt(txtMesB.getText());
            int ano=Integer.parseInt(txtAnoB.getText());
            double ingreso;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con1=DriverManager.getConnection("jdbc:odbc:conexion");
            CallableStatement cst1 = con1.prepareCall("{call usp_RPTotalPagoColaborador(?,?,?)}");
            cst1.setByte(1, (byte)mes);
            cst1.setShort(2,(short)ano);
            cst1.registerOutParameter(3,java.sql.Types.SMALLINT);
            int rpta=cst1.executeUpdate();
            ingreso = cst1.getShort(3);
            txtColaboradoresB.setText(Double.toString(ingreso));
            cst1.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error en el procedure","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void restringir(){
        for(int i=0;i<tblMAAsistencias.getRowCount();i++){
            int c=0;
            String codigo=String.valueOf(tblMAAsistencias.getValueAt(i,0));
            String nombre=String.valueOf(tblMAAsistencias.getValueAt(i,1));
            String asistio=String.valueOf(tblMAAsistencias.getValueAt(i,2));
            String tardanza=String.valueOf(tblMAAsistencias.getValueAt(i,3));
            String falto=String.valueOf(tblMAAsistencias.getValueAt(i,4)); 
            
            if(asistio.equalsIgnoreCase("null")){
            }
            else{
                if(asistio.equalsIgnoreCase("x")){
                    if(asistio.length()>1){
                        tblMAAsistencias.setValueAt("x",i,2);
                    }
                }
                else{tblMAAsistencias.setValueAt("",i,2);}
                
            } 
            if(tardanza.equalsIgnoreCase("null")){
            }
            else{
                if(tardanza.equalsIgnoreCase("x")){
                    if(tardanza.length()>1){
                    tblMAAsistencias.setValueAt("x",i,3);
                    }
                
                }
                else{tblMAAsistencias.setValueAt("",i,3);}
                
            }
            if(falto.equalsIgnoreCase("null")){
            }
            else{
                if(falto.equalsIgnoreCase("x")){
                    if(falto.length()>1){
                        tblMAAsistencias.setValueAt("x",i,4);
                    }
                }
                else{tblMAAsistencias.setValueAt("",i,4);}
                
            }
            if(asistio.equalsIgnoreCase("X")){
                c++;
            }
            if(tardanza.equalsIgnoreCase("X")){
                c++;
            }
            if(falto.equalsIgnoreCase("X")){
                c++;
            }
            if(c>1){
                tblMAAsistencias.setValueAt("",i,2);
                tblMAAsistencias.setValueAt("",i,3);
                tblMAAsistencias.setValueAt("",i,4);
            }
        }
    }
    public void mostrarRecientes(){
        DefaultTableModel Ciclos = new DefaultTableModel();
        try {
            Ciclos.addColumn("Costo");
            Ciclos.addColumn("Matricula");
            Ciclos.addColumn("Ciclo");
            Ciclos.addColumn("Fecha Inicio");
            CallableStatement cst = con.prepareCall("{call usp_ListarCicloAcademico}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                int j=0;
                Object dato[] = new Object[4];
                for(int i=0;i<6;i++){
                    if(i==0||i==5){}
                    else{
                       dato[j]=r.getString(i+1);
                       j++;
                    }
                }
            Ciclos.addRow(dato);
            }
            this.tblRecientes.setModel(Ciclos);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void buscarAsis(){
        try {
            DefaultTableModel Salones = new DefaultTableModel();
            Salones.addColumn("Codigo");
            Salones.addColumn("Nombres");
            Salones.addColumn("Asistio");
            Salones.addColumn("Tardanza");
            Salones.addColumn("Falto");
            String codigo = txtMACiclo.getText();
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumnosPorCiclo(?)}");
            cst.setString(1,codigo);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[5];
                for(int i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                }
                for(int i=2;i<5;i++){
                    dato[i]=null;
                }
            Salones.addRow(dato);
            }
            this.tblMAAsistencias.setModel(Salones);
            r.close();
            cst.close();
            buscaasistencia=true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Codigo Erroneo","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Modificar_Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void limpiarRegistro(){
        txtRNombre.setText("");
        txtRApellidoPat.setText("");
        txtRApellidoMat.setText("");
        txtRNacimiento1.setText("");
        txtRNacimiento2.setText("");
        txtRNacimiento3.setText("");
        txtRDireccion1.setText("");
        txtRDireccion2.setText("");
        txtRTelefono.setText("");
        txtRCorreo.setText("");
        txtRuc.setText("");
        cbxRPago.setSelectedIndex(0);
        txtSueldoAcademia.setText("");
        txtRApoderado.setText("");
        txtAGS.setText("");
        cbxANivelAcademico.setSelectedIndex(0);
        txtSueldoAsesoria.setText("");
        txtPagoAdmi.setText("");
        txtServicio.setText("");
        cbxServicio.setSelectedIndex(0);
        txtCargo.setText("");
        txtRFoto.setText("");
        jDesktopPane1.setBorder(new PintaImagen());
        txtCurso.setText("");
        DefaultTableModel cursos = new DefaultTableModel();
        cursos.addColumn("Codigo");
        cursos.addColumn("Curso");
        tblDominioCursos.setModel(cursos);
        DefaultTableModel disponibilidad = new DefaultTableModel();
        disponibilidad.addColumn("Dia");
        disponibilidad.addColumn("Hora Entrada");
        disponibilidad.addColumn("Hora Salida");
        tblDisponibilidad.setModel(disponibilidad);
        try{
             FileWriter a = new FileWriter("ActualizarCursoDominio.txt");
             FileWriter b = new FileWriter("Disponibilidad.txt");
             FileWriter c = new FileWriter("Disponibilidadextra.txt");
        }catch (IOException ex) {}
        tabladominio=0;
        tabladisponibilidad=0;
        txtRPagoAlumno.setText("");
    }
    public void buscarAdministrativo(){
        try {
            String codigo = borrarespacios(txtMAIngresar.getText());
            CallableStatement cst = con.prepareCall("{call usp_ConsultarFuncional(?)}");
            cst.setString(1,borrarespacios(codigo));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[14];
                for(int i=0;i<14;i++){
                    dato[i]=r.getString(i+1);
                }
                txtMACodigo.setText(String.valueOf(dato[0]));
                txtMANombre.setText(String.valueOf(dato[1]));
                txtMAApellidoPat.setText(String.valueOf(dato[2]));
                txtMAApellidoMat.setText(String.valueOf(dato[3]));
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en el Procedure","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Modificar_Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarDocente(){
        System.out.println("Entroooo!!");
        try {
            String codigo = borrarespacios(txtMAIngresar.getText());
            System.out.println(codigo);
            CallableStatement cst1 = con.prepareCall("{call usp_ConsultarProfesor(?)}");
            cst1.setString(1,codigo);
            ResultSet r1=cst1.executeQuery();
            System.out.println(codigo);
            while(r1.next()){
                Object dato[] = new Object[14];
                for(int i=0;i<14;i++){
                    dato[i]=r1.getString(i+1);
                    System.out.println(dato[i]);
                }
                txtMACodigo.setText(String.valueOf(dato[0]));
                txtMANombre.setText(String.valueOf(dato[1]));
                txtMAApellidoPat.setText(String.valueOf(dato[2]));
                txtMAApellidoMat.setText(String.valueOf(dato[3]));
            }
            r1.close();
            cst1.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Error en el Procedure","ERROR",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
    }
    public void registrarAsistencia(String tipo){
        try{
            Calendar c = Calendar.getInstance();
            String D,A,M,H,MIN;
            D=Integer.toString(c.get(Calendar.DATE));
            M=Integer.toString(c.get(Calendar.MONTH)+1);
            A=Integer.toString(c.get(Calendar.YEAR));
            H=Integer.toString(c.get(Calendar.HOUR_OF_DAY));
            MIN=Integer.toString(c.get(Calendar.MINUTE));
            String fecha=A+"-"+M+"-"+D;
            String horaIngreso=H+":"+MIN;
            String codigo = txtMAIngresar.getText();
            System.out.println(horaIngreso);
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con1=DriverManager.getConnection("jdbc:odbc:conexion");
            CallableStatement cst = con1.prepareCall("{call usp_InsertarDetalleAsistenciaColaborador(?,?,?,?,?)}");
            cst.setString(1,tipo);
            cst.setString(2,fecha);
            cst.setString(3,codigo);
            cst.setString(4,horaIngreso);
            cst.setString(5,null);
            int rpta = cst.executeUpdate();
            if(rpta==1){
                JOptionPane.showMessageDialog(this,"Asistencia Guardada","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                limpiarServicio();
            }
            limpiar();
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"La hora de entrada ya ha sido guardada","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void limpiar(){
        txtMACodigo.setText("");
        txtMANombre.setText("");
        txtMAApellidoPat.setText("");
        txtMAApellidoMat.setText("");
        txtMAIngresar.setText("");
    }
    public void actualizarAsistencia(String tipo){
        String horaIngreso=obtenerhoradeIngreso(tipo);
        System.out.println(horaIngreso);
        if(horaIngreso!=null){
            try{
                Calendar c = Calendar.getInstance();
                String D,A,M,H,MIN;
                D=Integer.toString(c.get(Calendar.DATE));
                M=Integer.toString(c.get(Calendar.MONTH)+1);
                A=Integer.toString(c.get(Calendar.YEAR));
                H=Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                MIN=Integer.toString(c.get(Calendar.MINUTE));
                String fecha=A+"-"+M+"-"+D;

                String horaSalida=H+":"+MIN;
                String codigo = txtMAIngresar.getText();
                System.out.println(tipo);
                System.out.println(fecha);
                System.out.println(codigo);
                System.out.println(horaIngreso);
                System.out.println(horaSalida);
                System.out.println(c.get(Calendar.MINUTE));

                CallableStatement cst = con.prepareCall("{call usp_ActualizarAsistenciaColaborador(?,?,?,?,?)}");
                cst.setString(1,fecha);
                cst.setString(2,codigo);
                cst.setString(3,tipo);
                cst.setString(4,horaIngreso);
                cst.setString(5,horaSalida);
                int rpta = cst.executeUpdate();
                if(rpta==1){
                    JOptionPane.showMessageDialog(this,"Asistencia de Salida Registrada Satisfactoriamente","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    limpiarServicio();
                }
                cst.close();
                limpiar();
            }
            catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,"Error en el procedure","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"No ha marcado hora de ingreso");
        }
    }
    public String obtenerhoradeIngreso(String tipo){
        String horaIngreso=null;
        String codigo = borrarespacios(txtMAIngresar.getText());
        String D,A,M;
        D=Integer.toString(c.get(Calendar.DATE));
        M=Integer.toString(c.get(Calendar.MONTH)+1);
        A=Integer.toString(c.get(Calendar.YEAR));
        String fecha=D+"/"+M+"/"+A;
        try {
            CallableStatement cst1 = con.prepareCall("{call usp_ListarAsistenciaColaborador(?,?)}");
            cst1.setString(1,codigo);
            cst1.setString(2,tipo);
            ResultSet r1=cst1.executeQuery();
            outerloop:
            while(r1.next()){
                boolean v = false;
                Object dato[] = new Object[5];
                for(int i=0;i<5;i++){
                    dato[i]=r1.getString(i+1);
                    if(i==1){
                        System.out.println("-----------------------------1");
                        System.out.println(fecha);
                        System.out.println(dato[i]);
                        System.out.println(Integer.parseInt(String.valueOf(dato[i]).substring(0,2))==Integer.parseInt(fecha.substring(0,fecha.indexOf("/"))));
                        System.out.println(Integer.parseInt(String.valueOf(dato[i]).substring(3,5))==Integer.parseInt(fecha.substring(fecha.indexOf("/")+1,fecha.indexOf("/", fecha.indexOf("/")+1))));
                        System.out.println(Integer.parseInt(String.valueOf(dato[i]).substring(6,10))==Integer.parseInt(fecha.substring(fecha.indexOf("/", fecha.indexOf("/")+1)+1,fecha.length())));
                        if(Integer.parseInt(String.valueOf(dato[i]).substring(0,2))==Integer.parseInt(fecha.substring(0,fecha.indexOf("/")))&&Integer.parseInt(String.valueOf(dato[i]).substring(3,5))==Integer.parseInt(fecha.substring(fecha.indexOf("/")+1,fecha.indexOf("/", fecha.indexOf("/")+1)))&&Integer.parseInt(String.valueOf(dato[i]).substring(6,10))==Integer.parseInt(fecha.substring(fecha.indexOf("/", fecha.indexOf("/")+1)+1,fecha.length()))){
                           v=true;  
                        }
                    }
                    if(v&&i==3&&(tipo.equalsIgnoreCase("A")||tipo.equalsIgnoreCase("S"))){
                        int cbx=0;
                        if(String.valueOf(dato[3]).substring(String.valueOf(dato[3]).length()-2,String.valueOf(dato[3]).length()).equalsIgnoreCase("AM")){
                            cbx=0;
                        }
                        if(String.valueOf(dato[3]).substring(String.valueOf(dato[3]).length()-2,String.valueOf(dato[3]).length()).equalsIgnoreCase("PM")){
                            cbx=1;
                        }
                        System.out.println(cbx);
                        horaIngreso=establecerHora(String.valueOf(dato[3]).substring(0,String.valueOf(dato[3]).indexOf(":")),String.valueOf(dato[3]).substring(String.valueOf(dato[3]).indexOf(":")+1,String.valueOf(dato[3]).length()-2),cbx);
                        System.out.println(horaIngreso);
                        System.out.println("-----------------------------2");
                        break outerloop;  
                    }
                    if(v&&i==2&&tipo.equalsIgnoreCase("F")){
                        int cbx=0;
                        if(String.valueOf(dato[2]).substring(String.valueOf(dato[2]).length()-2,String.valueOf(dato[2]).length()).equalsIgnoreCase("AM")){
                            cbx=0;
                        }
                        if(String.valueOf(dato[2]).substring(String.valueOf(dato[2]).length()-2,String.valueOf(dato[2]).length()).equalsIgnoreCase("PM")){
                            cbx=1;
                        }
                        System.out.println(cbx);
                        horaIngreso=establecerHora(String.valueOf(dato[2]).substring(0,String.valueOf(dato[2]).indexOf(":")),String.valueOf(dato[2]).substring(String.valueOf(dato[2]).indexOf(":")+1,String.valueOf(dato[2]).length()-2),cbx);
                        System.out.println(horaIngreso);
                        System.out.println("-----------------------------2");
                        break outerloop;
                    }
                }
            }
            r1.close();
            cst1.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en el Procedure","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Modificar_Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horaIngreso;
    }
    public String establecerHora(String hora,String hora2, int cbx){
        String horadevuelta=null;
        switch(cbx){
            case 0:if(Integer.parseInt(hora)==12){
                        horadevuelta="00:"+hora2;
                    }
                    else{
                        horadevuelta=hora+":"+hora2;
                    }break;
            case 1: if(Integer.parseInt(hora)==12){
                         horadevuelta="12:"+hora2;
                    }
                    else{
                        horadevuelta=String.valueOf(Integer.parseInt(hora)+12);
                        if(horadevuelta.length()==1){
                            horadevuelta="0"+horadevuelta+":"+hora2;
                        }
                        else{
                            horadevuelta=horadevuelta+":"+hora2;
                        }
                    }break;
        }
        return horadevuelta;
    }
    public void buscarAsistenciaAlumno(){
       AsistenciaAlumno a[]=new AsistenciaAlumno[32];
       Object dato[]=new Object[2];
       int j=0;
       try{
            String codigo = borrarespacios(txtCodigo.getText());
            String codigos = borrarespacios(txtAsisServicio.getText());
            int mes = MesAux+1;
            int ano = AAux;
            CallableStatement cst1 = con.prepareCall("{call usp_ListarAlumnosAsistencia(?,?,?,?)}");
            cst1.setString(1,codigo);
            cst1.setString(2,codigos);
            cst1.setInt(3,mes);
            cst1.setInt(4,ano);
            ResultSet r1=cst1.executeQuery();
            while(r1.next()){
                a[j]= new AsistenciaAlumno();
                dato[0]=r1.getString(1);
                dato[1]=r1.getString(2);        
                a[j].setDia(String.valueOf(dato[0]).substring(0,2));
                a[j].setAsistencia(String.valueOf(dato[1]));
                j++;
            }
            r1.close();
            cst1.close();
            busqueda=true;
            
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Codigo ERRONEO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        int fila=0;
        while(fila<j){
            for(int i=0;i<=5;i++){
                for(int k=0;k<=6;k++){
                    System.out.println(String.valueOf(Integer.parseInt(a[fila].getDia())));
                    System.out.println(String.valueOf(tblAsistencia.getValueAt(i,k)));
                    System.out.println(String.valueOf(Integer.parseInt(a[fila].getDia())).equalsIgnoreCase(String.valueOf(tblAsistencia.getValueAt(i,k))));
                    if(String.valueOf(Integer.parseInt(a[fila].getDia())).equalsIgnoreCase(String.valueOf(tblAsistencia.getValueAt(i,k)))){
                        System.out.println(tblAsistencia.getValueAt(i,k)+"-"+a[fila].getAsistencia());
                        tblAsistencia.setValueAt(tblAsistencia.getValueAt(i,k)+"-"+a[fila].getAsistencia(),i,k);
                        
                    }

                }
            }  
            fila++;
        }
   }
    
    public void buscarAsistenciaAdministrativo(){
       AsistenciaAlumno a[]=new AsistenciaAlumno[32];
       Object dato[]=new Object[4];
       int j=0;
       System.out.println("ENTROOO");
       try{
            String codigo = borrarespacios(txtCodigo.getText());
            int mes = MesAux+1;
            int ano = AAux;
            CallableStatement cst1 = con.prepareCall("{call usp_ListarAsistenciaColaborador(?,?)}");
            cst1.setString(1,codigo);
            cst1.setString(2,"F");
            ResultSet r1=cst1.executeQuery();
            while(r1.next()){
                
                for(int i=0;i<4;i++){
                    a[j]= new AsistenciaAlumno();
                    dato[i]=r1.getString(i+1);  
                    System.out.println(dato[i]);
                    if(i==1){
                        System.out.println(mes);
                        System.out.println(Integer.parseInt(String.valueOf(dato[1]).substring(3,5)));
                        System.out.println(mes==Integer.parseInt(String.valueOf(dato[1]).substring(3,5)));
                        System.out.println(ano);
                        System.out.println(Integer.parseInt(String.valueOf(dato[1]).substring(6,10)));
                        System.out.println(ano==Integer.parseInt(String.valueOf(dato[1]).substring(6,10)));
                        if(mes==Integer.parseInt(String.valueOf(dato[1]).substring(3,5))&&ano==Integer.parseInt(String.valueOf(dato[1]).substring(6,10))){
                            a[j].setDia(String.valueOf(dato[1]).substring(0,2));
                            j++;
                        }
                    }
                    
                }
            }
            r1.close();
            cst1.close();
            busqueda=true;
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Codigo ERRONEO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        int fila=0;
        while(fila<j){
            for(int i=0;i<=5;i++){
                for(int k=0;k<=6;k++){
                    System.out.println(String.valueOf(Integer.parseInt(a[fila].getDia())));
                    System.out.println(String.valueOf(tblAsistencia.getValueAt(i,k)));
                    System.out.println(String.valueOf(Integer.parseInt(a[fila].getDia())).equalsIgnoreCase(String.valueOf(tblAsistencia.getValueAt(i,k))));
                    if(String.valueOf(Integer.parseInt(a[fila].getDia())).equalsIgnoreCase(String.valueOf(tblAsistencia.getValueAt(i,k)))){
                        System.out.println(tblAsistencia.getValueAt(i,k)+"-"+a[fila].getAsistencia());
                        tblAsistencia.setValueAt(tblAsistencia.getValueAt(i,k)+"-Asistio",i,k);
                        
                    }
                }
            }  
            fila++;
        }
    }
    public void cambiarItem(){
        switch(cbxRPago.getSelectedIndex()){
            case 0:lblRuc.setVisible(false);
                   txtRuc.setVisible(false);break;
            case 1:lblRuc.setVisible(true);
                   txtRuc.setVisible(true);break;
            case 2:lblRuc.setVisible(false);
                   txtRuc.setVisible(false);break;
        }
    }
    public void calendario(){
        lblMes.setText(ObtenerMes(Integer.parseInt(M),Integer.parseInt(A)));
        tblAsistencia.setValueAt(D,WeekofMonth-1,DayofWeek-1);
        int dia,semana,diadelasemana;
        dia=Integer.parseInt(D);
        semana=WeekofMonth-1;
        diadelasemana=DayofWeek-1;
        outerloop:
            do{
                do{
                    if(diadelasemana==-1){
                        diadelasemana=6;
                    }
                    tblAsistencia.setValueAt(dia,semana,diadelasemana);
                    diadelasemana--;
                    dia--;
                    if(dia<1){
                         if(diadelasemana==-1){
                             diadelasemana=6;
                         }
                         ColumnAntAux=diadelasemana;
                         break outerloop;
                    }
               }while(diadelasemana>=0);
               semana--;
            }while(dia>0);
        dia=Integer.parseInt(D);
        semana=WeekofMonth-1;
        diadelasemana=DayofWeek-1;
        outerloop2:
            while(dia<=maximodia(Integer.parseInt(M),Integer.parseInt(A))){
                do{
                    if(diadelasemana==7){
                        diadelasemana=0;
                    }
                    tblAsistencia.setValueAt(dia,semana,diadelasemana);
                    diadelasemana++;
                    dia++;
                    if(dia>maximodia(Integer.parseInt(M),Integer.parseInt(A))){
                        if(diadelasemana==-1){
                            diadelasemana=6;
                        }
                        ColumnSigAux=diadelasemana;
                        break outerloop2;
                    }
                }while(diadelasemana<=6);
                semana++;
            }
    }
    public void limpiarCalendario(){
        for(int i=0;i<=5;i++){
            for(int j=0;j<=6;j++){
                tblAsistencia.setValueAt("",i,j);
            }
        }   
    }
    public void CalendarioAnterior(){
        int filaaux=5;
        do{
            lblMes.setText(ObtenerMes(MesAux,AAux));
            limpiarCalendario();         
            int dias=maximodia(MesAux,AAux);
            int columna=ColumnAntAux,fila=filaaux;
            ColumnSigAux=ColumnAntAux+1;
            if(ColumnAntAux==6){
                ColumnSigAux=0;
            }
            outerloop3:
            do{
                if(fila!=filaaux){
                   columna=6;
                }
                do{
                    tblAsistencia.setValueAt(dias,fila,columna);
                    columna--;
                    dias--;
                    if(dias==0){
                        if(columna==-1){
                            columna=6;
                        }
                        if(revision()==false){
                            ColumnAntAux=columna;
                        }
                        break outerloop3;
                    }
                }while(columna>=0);
                fila--;
            }while(dias>=0);
            if(revision()){
                filaaux--;
            }
        }while(revision());
    }
    public boolean revision(){
        boolean revisar=true;
        for(int i=6;i>=0;i--){
                revisar=revisar&&(tblAsistencia.getValueAt(0,i)=="");
        }
        return revisar;
    }
    public void CalendarioSiguiente(){
            lblMes.setText(ObtenerMes(MesAux,AAux));
            limpiarCalendario();         
            int diafinal=maximodia(MesAux,AAux),dias=1;
            int columna=ColumnSigAux,fila=0;
            ColumnAntAux=ColumnSigAux-1;
            if(ColumnSigAux==0){
                ColumnAntAux=6;
            }
            outerloop3:
            do{
                if(fila!=0){
                   columna=0;
                }
                do{
                    tblAsistencia.setValueAt(dias,fila,columna);
                    columna++;
                    dias++;
                    if(dias>diafinal){
                        if(columna==7){
                            columna=0;
                        }
                        if(revision()==false){
                            ColumnSigAux=columna;
                        }
                        break outerloop3;
                    }
                }while(columna<7);
                fila++;
            }while(dias<=diafinal);
    }
    public void bloqueoNumeros(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9')){}
      else{
        evt.consume();
      }
    }
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
    } 
    public static void fileMove(String sourceFile, String destinationFile) {
        System.out.println("Desde: " + sourceFile);
        System.out.println("Hacia: " + destinationFile);
        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);
            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.close();
            File file = new File(sourceFile);
            if (file.exists()) {
                file.delete();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No se olvide colocar una foto en la ventana modificar","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action)
            file.mkdirs();
        return isDirectory;
    }
    public  void cargarImagen(javax.swing.JDesktopPane jDeskp,File fileImagen){
        try{
            BufferedImage image = ImageIO.read(fileImagen);
            jDeskp.setBorder(new PintaImagen(image)); 
        }
        catch (Exception e){System.out.println("No cargo imagen, sorry");}
    }
    @SuppressWarnings("AssignmentToMethodParameter")
    public boolean VerificarCampos(boolean verificar){
        campos="";
        if(cbxSServicio.getSelectedIndex()==0){
            verificar=verificar&&false;
            campos="Servicio, ";
        }
        if(cbxSServicio.getSelectedIndex()==1){
            if(cbxSTipo.getSelectedIndex()==0){
                verificar=verificar&&false;
                campos+="Tipo de Clases Particulares, ";
            }
            verificar=verificar&&recorrer(txtSHoras.getText());
            if(recorrer(txtSHoras.getText())==false){
                campos+="Cantidad de Horas, ";
            }
            verificar=verificar&&recorrer(txtSFechaClase1.getText());
            verificar=verificar&&recorrer(txtSFechaClase2.getText());
            verificar=verificar&&recorrer(txtSFechaClase3.getText());
            if(recorrer(txtSFechaClase1.getText())==false||recorrer(txtSFechaClase2.getText())==false||recorrer(txtSFechaClase3.getText())==false){
                campos+="Fecha de la Clase, ";
            }
            verificar=verificar&&recorrer(txtSDocente.getText());
            if(recorrer(txtSDocente.getText())==false){
                campos+="Docente, ";
            }
            verificar=verificar&&recorrer(txtSCurso.getText());
            if(recorrer(txtSCurso.getText())==false){
                campos+="Curso, ";
            }
            verificar=verificar&&recorrer(txtSPrecio.getText());
            if(recorrer(txtSPrecio.getText())==false){
                campos+="Precio por Hora, ";
           }
        }
        if(cbxSServicio.getSelectedIndex()==2){
            verificar=verificar&&recorrer(txtSEntrega1.getText());
            if(recorrer(txtSEntrega1.getText())==false){
                verificar=verificar&&false;
                campos+="Fecha de Entrega, ";
            }
        }
        verificar=verificar&&recorrer(txtSNombre.getText());
        if(recorrer(txtSNombre.getText())==false){
                campos+="Nombres, ";
        }
        verificar=verificar&&recorrer(txtSApellidoPat.getText());
        if(recorrer(txtSApellidoPat.getText())==false){
                campos+="Apellido Paterno, ";
        }
        verificar=verificar&&recorrer(txtSApellidoMat.getText());
        if(recorrer(txtSApellidoMat.getText())==false){
                campos+="Apellido Materno, ";
        }
        
        return verificar;
    }
    public boolean recorrer(String c){
        boolean v=true;
        int contador=0;
        if(c.length()==0){
            v=false;
        }
        else{
            for(int i=0;i<c.length();i++){
                if(c.charAt(i)==' '){
                    contador++;
                }
            }
            if(contador==c.length()){
                v=false;
            }
        }
        return v;
    }
    public void CambiodeItem(){
        switch(cbxSServicio.getSelectedIndex()){
            case 0:Servicios(true,false,false);
                break;
            case 1:Servicios(false,true,false);
                   break;
            case 2:Servicios(false,false,true);
                   break;
        }
    }
    public void Servicios(boolean entrada,boolean particular,boolean informe){
        lblSServicio.setVisible(entrada||particular||informe);
        cbxSServicio.setVisible(entrada||particular||informe);
        cbxSTipo.setVisible(particular);
        lblSHoras.setVisible(particular);
        txtSHoras.setVisible(particular);
        lblFechaClase.setVisible(particular);
        txtSFechaClase1.setVisible(particular);
        lblSEntrega.setVisible(informe);
        txtSEntrega1.setVisible(informe);
        txtSEntrega2.setVisible(informe);
        txtSEntrega3.setVisible(informe);
        lblSNombre.setVisible(particular||informe);
        txtSNombre.setVisible(particular||informe);
        lblSApellidoPat.setVisible(particular||informe);
        txtSApellidoPat.setVisible(particular||informe);
        lblSApellidoMat.setVisible(particular||informe);
        txtSApellidoMat.setVisible(particular||informe);
        lblSCAsignacion.setVisible(informe);
        txtSCAsignacion.setVisible(informe);
        lblSDocente.setVisible(particular||informe);
        txtSDocente.setVisible(particular||informe);
        btnSSDocente.setVisible(particular||informe);
        lblSCRealizacion.setVisible(informe);
        txtSCRealizacion.setVisible(informe);
        lblSCurso.setVisible(particular);
        txtSCurso.setVisible(particular);
        btnSSeleccionar.setVisible(particular);
        lblSPrecio.setVisible(particular);
        txtSPrecio.setVisible(particular);
        btnSRegistrar.setVisible(particular||informe);
        btnSLimpiar.setVisible(particular||informe);
        txtSFechaClase2.setVisible(particular);
        txtSFechaClase3.setVisible(particular);
        lblSDireccion.setVisible(false);
        txtSDireccion1.setVisible(false);
        txtSDireccion2.setVisible(false);
        txtSPDocente.setVisible(particular);
        lblSPDocente.setVisible(particular);
        lblSLimpiar.setVisible(particular||informe);
        lblSRegistrar.setVisible(particular||informe);
    }
    public void limpiarServicio(){
        switch(cbxSServicio.getSelectedIndex()){
            case 1:cbxSTipo.setSelectedIndex(0);
                   txtSNombre.setText("");
                   txtSApellidoPat.setText("");
                   txtSApellidoMat.setText("");
                   txtSFechaClase1.setText("");
                   txtSFechaClase2.setText("");
                   txtSFechaClase3.setText("");
                   txtSDireccion1.setText("");
                   txtSDireccion2.setText("");
                   txtSHoras.setText("");
                   txtSDocente.setText("");
                   txtSCurso.setText("");
                   txtSPDocente.setText("");
                   txtSPrecio.setText("");break;
            case 2:txtSEntrega1.setText("");
                    txtSEntrega2.setText("");
                    txtSEntrega3.setText("");
                   txtSNombre.setText("");
                   txtSApellidoPat.setText("");
                   txtSApellidoMat.setText("");
                   txtSCAsignacion.setText("");
                   txtSCRealizacion.setText("");
                   txtSPDocente.setText("");
                   txtSDocente.setText("");break;
        }
    }
    public void Asistencia(boolean entrada,boolean alumno,boolean administrativo){
        btnAsistenciaAlumnos.setVisible(entrada);
        btnAsistenciaAdministrativa.setVisible(entrada);
        btnAsisDocente.setVisible(entrada);
        lblAsisDocente.setVisible(entrada);
        lblAsistencia.setVisible(entrada);
        lblAsistenciaAlumno.setVisible(alumno||administrativo);
        tblAsistencia.setVisible(alumno||administrativo);
        ScrollAsistencia.setVisible(alumno||administrativo);
        txtCodigo.setVisible(alumno||administrativo);
        lblCodigo.setVisible(alumno||administrativo);
        txtNombreAsis.setVisible(alumno||administrativo);
        lblNombreAsis.setVisible(alumno||administrativo);
        txtApellidoPatAsis.setVisible(alumno||administrativo);
        lblApellidoPatAsis.setVisible(alumno||administrativo);
        txtApellidoMatAsis.setVisible(alumno||administrativo);
        lblApellidoMatAsis.setVisible(alumno||administrativo);
        btnRegresar.setVisible(alumno||administrativo);
        lblMes.setVisible(alumno||administrativo);
        btnLimpiar.setVisible(alumno||administrativo);
        btnAnterior.setVisible(alumno||administrativo);
        btnSiguiente.setVisible(alumno||administrativo);
        btnActual.setVisible(alumno||administrativo);
        btnBuscar.setVisible(alumno||administrativo);
        lblAsistenciaAlumno.setVisible(alumno);
        lblAsistenciaAdministrativo.setVisible(administrativo);
        lblAsisRegresar.setVisible(alumno||administrativo);
        lblAsisLimpiar.setVisible(alumno||administrativo);
        lblAsisAnterior.setVisible(alumno||administrativo);
        lblAsisSiguiente.setVisible(alumno||administrativo);
        lblAsisActual.setVisible(alumno||administrativo);
        lblAsisServicio.setVisible(alumno);
        txtAsisServicio.setVisible(alumno);
        btnAsisServicio.setVisible(alumno);
        cbxAsisServ.setVisible(alumno);
        lblMAAlumno.setVisible(entrada);
        lblMAAdministrativa.setVisible(entrada);
        if(alumno||administrativo){
            lblMes.setText(ObtenerMes(Integer.parseInt(M),Integer.parseInt(A)));
        }
    }
    
    public void Registro(boolean entrada, boolean alumno, boolean docente, boolean administrativo){
        lblRTitulo.setVisible(entrada||alumno||docente||administrativo);
        btnRAlumnos.setVisible(entrada);
        btnRDocente.setVisible(entrada);
        btnRAdministrativa.setVisible(entrada);
        btnRegresarD.setVisible(alumno||docente||administrativo);
        lblNNombreD.setVisible(alumno||docente||administrativo);
        txtRNombre.setVisible(alumno||docente||administrativo);
        lblNApellidoPatD.setVisible(alumno||docente||administrativo);
        txtRApellidoPat.setVisible(alumno||docente||administrativo);
        lblNApellidoMatD.setVisible(alumno||docente||administrativo);
        txtRApellidoMat.setVisible(alumno||docente||administrativo);
        lblNNacimientoD.setVisible(alumno||docente||administrativo);
        txtRNacimiento1.setVisible(alumno||docente||administrativo);
        txtRNacimiento2.setVisible(alumno||docente||administrativo);
        txtRNacimiento3.setVisible(alumno||docente||administrativo);
        lblNDireccionD.setVisible(alumno||docente||administrativo);
        txtRDireccion1.setVisible(alumno||docente||administrativo);
        txtRDireccion2.setVisible(alumno||docente||administrativo);
        lblNTelefonoD.setVisible(alumno||docente||administrativo);
        txtRTelefono.setVisible(alumno||docente||administrativo);
        lblNCorreoD.setVisible(alumno||docente||administrativo);
        txtRCorreo.setVisible(alumno||docente||administrativo);
        lblRuc.setVisible(docente||administrativo);
        txtRuc.setVisible(docente||administrativo);
        lblRPago.setVisible(docente||administrativo);
        cbxRPago.setVisible(docente||administrativo);
        lblNSueldoHoraD.setVisible(docente||administrativo);
        txtSueldoAcademia.setVisible(docente);
        lblServicio.setVisible(alumno);
        lblAApoderado.setVisible(alumno);
        txtRApoderado.setVisible(alumno);
        lblAGS.setVisible(alumno);
        txtAGS.setVisible(alumno);
        lblANivelAcademico.setVisible(alumno);
        cbxANivelAcademico.setVisible(alumno);
        lblSueldoAcademia.setVisible(docente);
        lblSueldoAsesoria.setVisible(docente);
        txtSueldoAsesoria.setVisible(docente);
        btnNRegistrarD.setVisible(alumno||docente||administrativo);
        txtPagoAdmi.setVisible(administrativo);
        txtServicio.setVisible(alumno);
        btnServicio.setVisible(alumno);
        cbxServicio.setVisible(alumno);
        lblCargo.setVisible(administrativo);
        txtCargo.setVisible(administrativo);
        btnAbrirFoto.setVisible(alumno);
        txtRFoto.setVisible(alumno);
        pnlFoto.setVisible(alumno);
        jDesktopPane1.setVisible(alumno);
        lblCurso.setVisible(false);
        txtCurso.setVisible(false);
        btnCurso.setVisible(false);
        sclDominioCursos.setVisible(docente);
        btnDominioCursos.setVisible(docente);
        tblDominioCursos.setVisible(docente);
        lblDominioCursos.setVisible(docente);   
        btnRLimpiar.setVisible(alumno||docente||administrativo);
        btnTest.setVisible(false);
        btnObservacion.setVisible(false);
        lblDisponibilidad.setVisible(docente);
        btnDisponibilidad.setVisible(docente);
        sclDisponibilidad.setVisible(docente);
        tblDisponibilidad.setVisible(docente);
        lblRPagoAlumno.setVisible(alumno);
        txtRPagoAlumno.setVisible(alumno);
        lblRegresar.setVisible(alumno||docente||administrativo);
        lblRegistrar.setVisible(alumno||docente||administrativo);
        lblLimpiar.setVisible(alumno||docente||administrativo);
        lblFechaI.setVisible(alumno);
        txtFechaI1.setVisible(alumno);
        txtFechaI2.setVisible(alumno);
        txtFechaI3.setVisible(alumno);
        lblRAlumnos.setVisible(entrada);
        lblDocentes.setVisible(entrada);
        lblAdministrativa.setVisible(entrada);
        if(administrativo){
            lblNSueldoHoraD.setText("Pago Mensual:");
            lblNTelefonoD.setText("Telefono");
        }
        if(docente){
            lblNSueldoHoraD.setText("Pago Hora:");
            lblNTelefonoD.setText("Celular");
            
        }
        if(alumno){
            lblNTelefonoD.setText("Telefono");
        }
    }
    public void MarcarAsistencia(boolean alumno, boolean docente, boolean administrativo){
        lblMATitulo.setVisible(true);
        lblMA.setVisible(true);
        cbxMA.setVisible(true);
        lblMAIngresar.setVisible(docente||administrativo);
        txtMAIngresar.setVisible(docente||administrativo);
        lblMACodigo.setVisible(docente||administrativo);
        txtMACodigo.setVisible(docente||administrativo);
        lblMANombre.setVisible(docente||administrativo);
        txtMANombre.setVisible(docente||administrativo);
        lblMAApellidoPat.setVisible(docente||administrativo);
        txtMAApellidoPat.setVisible(docente||administrativo);
        lblMAApellidoMat.setVisible(docente||administrativo);
        txtMAApellidoMat.setVisible(docente||administrativo);
        btnMAAEntrada.setVisible(docente||administrativo);
        sclMAAsistencias.setVisible(alumno);
        tblMAAsistencias.setVisible(alumno);
        lblMACiclo.setVisible(alumno);
        txtMACiclo.setVisible(alumno);
        btnMACiclo.setVisible(alumno);
        btnMAGuardar.setVisible(alumno);
        btnMAAceptar.setVisible(docente||administrativo);
        cbxAsisServicio.setVisible(alumno);
        btnAsisBuscar.setVisible(alumno);
        cbxMAHora.setVisible(docente||administrativo);
        cbxMATipoS.setVisible(docente);
        lbl1.setVisible(docente||administrativo);
        lbl2.setVisible(alumno);
        lbl3.setVisible(alumno);
        lbl4.setVisible(docente||administrativo);
        
    }
    public int obtenermesnum(String mes){
        int m=0;
        if(mes.equalsIgnoreCase("Enero")){m=1;}
        if(mes.equalsIgnoreCase("Febrero")){m=2;}
        if(mes.equalsIgnoreCase("Marzo")){m=3;}
        if(mes.equalsIgnoreCase("Abril")){m=4;}
        if(mes.equalsIgnoreCase("Mayo")){m=5;}
        if(mes.equalsIgnoreCase("Junio")){m=6;}
        if(mes.equalsIgnoreCase("Julio")){m=7;}
        if(mes.equalsIgnoreCase("Agosto")){m=8;}
        if(mes.equalsIgnoreCase("Septiembre")){m=9;}
        if(mes.equalsIgnoreCase("Octubre")){m=10;}
        if(mes.equalsIgnoreCase("Noviembre")){m=11;}
        if(mes.equalsIgnoreCase("Diciembre")){m=12;}
        return m;
    }
    public String ObtenerMes(int mes,int año){
        String mesobtenido="";
        switch(mes){
            case 0:mesobtenido="Enero ";break;
            case 1:mesobtenido="Febrero ";break;
            case 2:mesobtenido="Marzo ";break;
            case 3:mesobtenido="Abril ";break;
            case 4:mesobtenido="Mayo ";break;
            case 5:mesobtenido="Junio ";break;
            case 6:mesobtenido="Julio ";break;
            case 7:mesobtenido="Agosto ";break;
            case 8:mesobtenido="Septiembre ";break;
            case 9:mesobtenido="Octubre ";break;
            case 10:mesobtenido="Noviembre ";break;
            case 11:mesobtenido="Diciembre ";break;
        }
        mesobtenido+=String.valueOf(año);
        return mesobtenido;
    }
    public int maximodia(int mes,int año){
        int maximo=0;
        switch(mes){
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11: maximo=31; break;
            case 1: if(año%4==0)
                      maximo=29;
                    else
                      maximo=28;
                    break;
            case 3:
            case 5:
            case 8:
            case 10:maximo=30;break;
        }
        return maximo;
    }
    
    public void cambiodedia(){
        switch(DayofWeek){
            case 1:DayofWeek=7;break;
            case 2:DayofWeek=1;break;
            case 3:DayofWeek=2;break;
            case 4:DayofWeek=3;break;
            case 5:DayofWeek=4;break;
            case 6:DayofWeek=5;break;
            case 7:DayofWeek=6;break;
        }
    }
    public void registrarClaseParticular(){
        try{
            String nombre=txtSNombre.getText()+" "+txtSApellidoPat.getText()+" "+txtSApellidoMat.getText();
            String tipo=String.valueOf(String.valueOf(cbxSTipo.getSelectedItem()).charAt(0));
            String direccion;
            if(cbxSTipo.getSelectedIndex()==2){
                direccion=txtSDireccion1.getText()+txtSDireccion2.getText();}
            else{
                direccion=null;}
            String codigo=txtSCurso.getText();
            String fecha= txtSFechaClase1.getText()+"-"+txtSFechaClase2.getText()+"-"+txtSFechaClase3.getText();
            double pago = Double.parseDouble(txtSPrecio.getText());
            int horas = Integer.parseInt(txtSHoras.getText());
            String codigocola = txtSDocente.getText();
            double pagodocente=Double.parseDouble(txtSPDocente.getText());
            String codigoparticular;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con1=DriverManager.getConnection("jdbc:odbc:conexion");
            CallableStatement cst = con1.prepareCall("{call usp_InsertarClaseParticular(?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1, nombre);
            cst.setString(2,tipo);
            cst.setString(3,direccion);
            cst.setString(4,codigo);
            cst.setString(5,fecha);
            cst.setDouble(6, pago);
            cst.setInt(7,horas);
            cst.setString(8,codigocola);
            cst.setDouble(9,pagodocente);
            cst.registerOutParameter(10,Types.CHAR);
            int rpta = cst.executeUpdate();
            codigoparticular=cst.getString(10);
            if(rpta==1){
                JOptionPane.showMessageDialog(this,"Clase Particular Registrada Satisfactoriamente","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                limpiarServicio();
            }
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void registrarAsignacion(){
        try{
            String D=Integer.toString(c.get(Calendar.DATE));
            String M=Integer.toString(c.get(Calendar.MONTH)+1);
            String A=Integer.toString(c.get(Calendar.YEAR));
            double casig = Double.parseDouble(txtSCAsignacion.getText());
            double creal = Double.parseDouble(txtSCRealizacion.getText());
            String nombre = borrarespacios(txtSNombre.getText())+" "+borrarespacios(txtSApellidoPat.getText())+" "+borrarespacios(txtSApellidoMat.getText());
            String fechae = txtSEntrega1.getText()+"-"+txtSEntrega2.getText()+"-"+txtSEntrega3.getText();
            String fechar = A+"-"+M+"-"+D;
            String codigodocente = txtSDocente.getText();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con1=DriverManager.getConnection("jdbc:odbc:conexion");
            CallableStatement cst = con1.prepareCall("{call usp_InsertarAsignacion(?,?,?,?,?,?,?)}");
            cst.setDouble(1,casig);
            cst.setString(2,fechar);
            cst.setString(3,fechae);
            cst.setDouble(4,creal);
            cst.setString(5,nombre);
            cst.setString(6, codigodocente);
            cst.registerOutParameter(7, Types.CHAR);
            int rpta = cst.executeUpdate();
            String codigo = cst.getString(7);
            if(rpta==1){
                JOptionPane.showMessageDialog(this,"Informe Registrado Satisfactoriamente","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                limpiarServicio();
            }
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void listarAlumnos(String salon){
        DefaultTableModel masis = new DefaultTableModel();
        masis.addColumn("Codigo");
        masis.addColumn("Nombre");
        masis.addColumn("Apellido Pat");
        masis.addColumn("Apellido Mat");
        masis.addColumn("Asistio");
        masis.addColumn("Tardanza");
        masis.addColumn("Falto");
         try {
            tablaMarcarAsistencia=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumno}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[13];
                for(int i=0;i<4;i++){
                    if(i==0){
                        dato[0]=salon;
                    }
                    else{
                        dato[i]=r.getString(i+1);
                    }
                }
                tablaMarcarAsistencia++;
                masis.addRow(dato);
            }
            this.tblMAAsistencias.setModel(masis);
            r.close();
            cst.close();
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public boolean GuardarAsistencia(int i){
        boolean v=false;
        try{
            String codigo = String.valueOf(tblMAAsistencias.getValueAt(i,0));
            String tipo=null;
            String D=Integer.toString(c.get(Calendar.DATE));
            String M=Integer.toString(c.get(Calendar.MONTH)+1);
            String A=Integer.toString(c.get(Calendar.YEAR));
            String fecha=A+"-"+M+"-"+D;
            if(String.valueOf(tblMAAsistencias.getValueAt(i,2)).equalsIgnoreCase("X")){
                tipo="A";
            }
            else{
                if(String.valueOf(tblMAAsistencias.getValueAt(i,3)).equalsIgnoreCase("X")){
                    tipo="T";
                }
                else{
                    if(String.valueOf(tblMAAsistencias.getValueAt(i,4)).equalsIgnoreCase("X")){
                        tipo="F";
                    }   
                }
            }
            String codigociclo=txtMACiclo.getText();
            if(tipo!=null){
                CallableStatement cst1 = con.prepareCall("{call usp_InsertarDetalleAsistenciaAlumno(?,?,?,?)}");
                cst1.setString(1,codigociclo);
                cst1.setString(2,fecha);
                cst1.setString(3,codigo);
                cst1.setString(4,tipo);
                int rpta = cst1.executeUpdate();
                if(rpta>=1){
                    v=true;
                }
                cst1.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Erro al registrar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return v;
    }
    public void RegistrarAlumnoCiclo(){
        String direccionfoto;
        direccionfoto=RegistrarAlumno();
        JOptionPane.showMessageDialog(this,"El directorio es: "+borrarespacios(direccionfoto),"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
        boolean dir = validateDir("D:\\FotosAlumnos", true);
        fileMove(borrarespacios(txtRFoto.getText()),direccionfoto);
        Observacion=false;
    }
    public void RegistrarAlumnoAsesoria(){
        String direccionfoto;
        direccionfoto=RegistrarAlumno();
        JOptionPane.showMessageDialog(this,"El directorio es: "+borrarespacios(direccionfoto),"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
        boolean dir = validateDir("D:\\FotosAlumnos", true);
        fileMove(borrarespacios(txtRFoto.getText()),direccionfoto);
        Observacion=false;
    }
    public String RegistrarAlumno(){
        String direccionfoto=null;
        int rpta;
        try{
            String nombre = borrarespacios(txtRNombre.getText());
            String apelpat= borrarespacios(txtRApellidoPat.getText());
            String apelmat= borrarespacios(txtRApellidoMat.getText());
            String direccion= borrarespacios(txtRDireccion1.getText())+borrarespacios(txtRDireccion2.getText());
            String telefono= borrarespacios(txtRTelefono.getText());
            String correo= borrarespacios(txtRCorreo.getText());
            String fechanac= borrarespacios(txtRNacimiento3.getText())+"-"+borrarespacios(txtRNacimiento2.getText())+"-"+borrarespacios(txtRNacimiento1.getText());
            String apoderado= borrarespacios(txtRApoderado.getText());
            String gs= borrarespacios(txtAGS.getText());
            String nivelacademico;
            if(cbxANivelAcademico.getSelectedIndex()==3){
                nivelacademico="A";
            }
            else{
                nivelacademico= String.valueOf(String.valueOf(cbxANivelAcademico.getSelectedItem()).charAt(0));
            }
                CallableStatement cst1 = con.prepareCall("{call usp_InsertarAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst1.setString(1,nombre);
                cst1.setString(2,apelpat);
                cst1.setString(3,apelmat);
                cst1.setString(4,direccion);
                cst1.setString(5,telefono);
                cst1.setString(6,correo);
                cst1.setString(7,fechanac);
                cst1.setString(8,apoderado);
                cst1.setString(9,gs);
                cst1.setString(10,borrarespacios(nivelacademico));
                cst1.setBoolean(11,Observacion);
                cst1.registerOutParameter(12, Types.CHAR);
                cst1.registerOutParameter(13, Types.VARCHAR);
                rpta = cst1.executeUpdate();
                String codigo = borrarespacios(cst1.getString(12));
                direccionfoto=borrarespacios(cst1.getString(13)); 
                cst1.close();
                if(rpta>=1){
                    JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    RegistrarCiclo(codigo,borrarespacios(txtCurso.getText()));
                    RegistrarPago(codigo,borrarespacios(txtServicio.getText()));
                }
         } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
        return direccionfoto;
    }
    public void RegistrarPago(String codigoalumno, String codigoservicio){
        try {
            String año=Integer.toString(c.get(Calendar.YEAR));
            String mes=Integer.toString(c.get(Calendar.MONTH)+1);
            String dia=Integer.toString(c.get(Calendar.DATE));
            String fecha = año+"-"+mes+"-"+dia;
            CallableStatement cst = con.prepareCall("{call usp_InsertarPagoAlumno(?,?,?,?,?)}");
                   cst.setString(1,borrarespacios(codigoalumno));
                   cst.setString(2,borrarespacios(txtServicio.getText()));
                   cst.setDouble(3,Double.parseDouble(borrarespacios(txtRPagoAlumno.getText())));
                   cst.setString(4,String.valueOf(borrarespacios(fecha)));
                   cst.registerOutParameter(5,Types.CHAR);
                   int rpta = cst.executeUpdate();
                   String codigoPago=cst.getString(5);
                   if(rpta>=1)
                    JOptionPane.showMessageDialog(this,"El codigo del alumno es: "+borrarespacios(codigoalumno)+"\n"+"El codigo de Pago es: "+borrarespacios(codigoPago),"Informacion",JOptionPane.INFORMATION_MESSAGE);
                   cst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar Pago","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void RegistrarCiclo(String codigo,String curso){
        String fecha=txtFechaI3.getText()+"-"+txtFechaI2.getText()+"-"+txtFechaI1.getText();
        try {
            CallableStatement cst = con.prepareCall("{call usp_InsertarMatricula(?,?,?,?)}");
                   cst.setString(1,borrarespacios(codigo));
                   cst.setString(2,borrarespacios(txtServicio.getText()));
                   cst.setString(3,fecha);
                   cst.setString(4,borrarespacios(curso));
                   int rpta = cst.executeUpdate();
                   cst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar Matricula","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void registrarDocente(){
        try{
            String año=Integer.toString(c.get(Calendar.YEAR));
            String mes=Integer.toString(c.get(Calendar.MONTH)+1);
            String dia=Integer.toString(c.get(Calendar.DATE));
            String fecha=año+"-"+mes+"-"+dia;
            String nombre = borrarespacios(txtRNombre.getText());
            String apelpat= borrarespacios(txtRApellidoPat.getText());
            String apelmat= borrarespacios(txtRApellidoMat.getText());
            String direccion= borrarespacios(txtRDireccion1.getText())+borrarespacios(txtRDireccion2.getText());
            String telefono= borrarespacios(txtRTelefono.getText());
            String correo= borrarespacios(txtRCorreo.getText());
            String metodopago= borrarespacios(String.valueOf(String.valueOf(cbxRPago.getSelectedItem()).charAt(0)));
            String ruccuenta= borrarespacios(txtRuc.getText());
            String fechanac = borrarespacios(txtRNacimiento3.getText())+"-"+borrarespacios(txtRNacimiento2.getText())+"-"+borrarespacios(txtRNacimiento1.getText());
            String pagoacademia= borrarespacios(txtSueldoAcademia.getText());
            String pagoasesoria= borrarespacios(txtSueldoAsesoria.getText());
            String codigodocente;
                CallableStatement cst = con.prepareCall("{call usp_InsertarColaboradorProfesor(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst.setString(1,nombre);
                cst.setString(2,apelpat);
                cst.setString(3,apelmat);
                cst.setString(4,direccion);
                cst.setString(5,telefono);
                cst.setString(6,correo);
                cst.setString(7,metodopago);
                cst.setString(8,fecha);
                cst.setString(9,ruccuenta);
                cst.setString(10,fechanac);
                cst.setString(11,pagoacademia);
                cst.setString(12,pagoasesoria);
                cst.registerOutParameter(13, Types.CHAR);   
                int rpta = cst.executeUpdate();
                codigodocente=borrarespacios(cst.getString(13));
                if(rpta==1){
                    JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(this,"Su codigo es:"+codigodocente,"Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
                cst.close();
                
                for(int i=0;i<tblDominioCursos.getRowCount();i++){
                    registrarDominioCursos(codigodocente,i);
                }
                for(int i=0;i<tblDisponibilidad.getRowCount();i++){
                    registrarDisponibilidad(codigodocente,i);
                }
                limpiarRegistro(); 
                try {
                    FileWriter p = new FileWriter("ActualizarCursoDominio.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    FileWriter f = new FileWriter("Disponibilidad.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
                }
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
    }
    public void registrarDominioCursos(String codigo,int fila){
        try {
            CallableStatement cst = con.prepareCall("{call usp_InsertarCursosDOminioProfesor(?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,String.valueOf(tblDominioCursos.getValueAt(fila, 0)));
            int rpta = cst.executeUpdate();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void registrarDisponibilidad(String codigo,int fila){
        try {
            String dia=diasemana(String.valueOf(tblDisponibilidad.getValueAt(fila, 0)));
            CallableStatement cst = con.prepareCall("{call usp_InsertarDisponibilidadColaborador(?,?,?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,dia);
            cst.setString(3,String.valueOf(tblDisponibilidad.getValueAt(fila, 1)));
            cst.setString(4,String.valueOf(tblDisponibilidad.getValueAt(fila, 2)));
            int rpta = cst.executeUpdate();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String diasemana(String dia){
        String diaentero=null;
        if(dia.equalsIgnoreCase("lunes")){
            diaentero="2";
        }
        if(dia.equalsIgnoreCase("martes")){
            diaentero="3";
        }
        if(dia.equalsIgnoreCase("miercoles")){
            diaentero="4";
        }
        if(dia.equalsIgnoreCase("jueves")){
            diaentero="5";
        }
        if(dia.equalsIgnoreCase("viernes")){
            diaentero="6";
        }
        if(dia.equalsIgnoreCase("sabado")){
            diaentero="7";
        }
        if(dia.equalsIgnoreCase("domingo")){
            diaentero="1";
        }
        return diaentero;
    }
    public void registrarAdministrativo(){
        try{
            String año=Integer.toString(c.get(Calendar.YEAR));
            String mes=Integer.toString(c.get(Calendar.MONTH)+1);
            String dia=Integer.toString(c.get(Calendar.DATE));
            String fecha=año+"-"+mes+"-"+dia;
            String nombre = borrarespacios(txtRNombre.getText());
            String apelpat= borrarespacios(txtRApellidoPat.getText());
            String apelmat= borrarespacios(txtRApellidoMat.getText());
            String direccion= borrarespacios(txtRDireccion1.getText())+txtRDireccion2.getText();
            String telefono= borrarespacios(txtRTelefono.getText());
            String correo= borrarespacios(txtRCorreo.getText());
            String metodopago= String.valueOf(String.valueOf(cbxRPago.getSelectedItem()).charAt(0));
            String ruccuenta= borrarespacios(txtRuc.getText());
            String fechanac = borrarespacios(txtRNacimiento3.getText())+"-"+borrarespacios(txtRNacimiento2.getText())+"-"+borrarespacios(txtRNacimiento1.getText());
            String pago= borrarespacios(txtPagoAdmi.getText());
            String cargo = borrarespacios(txtCargo.getText());
            String codigoadmi;
                CallableStatement cst = con.prepareCall("{call usp_InsertarColaboradorFuncional(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst.setString(1,nombre);
                cst.setString(2,apelpat);
                cst.setString(3,apelmat);
                cst.setString(4,direccion);
                cst.setString(5,telefono);
                cst.setString(6,correo);
                cst.setString(7,metodopago);
                cst.setString(8,fecha);
                cst.setString(9,ruccuenta);
                cst.setString(10,fechanac);
                cst.setString(11,pago);
                cst.setString(12,cargo);
                cst.registerOutParameter(13, Types.CHAR);   
                int rpta = cst.executeUpdate();
                codigoadmi=borrarespacios(cst.getString(13));
                cst.close();
                if(rpta==1){
                    JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(this,"Su codigo es:"+codigoadmi,"Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
                limpiarRegistro(); 
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public String borrarespacios(String c){
        String cadena=null;
        boolean pos = false;
        int posicion=0;
        outerloop:
        for(int i=c.length()-1;i>=0;i--){
            if(c.charAt(i)!=' '){
                posicion=i+1;
                pos=true;
                break outerloop;
            }
        }
        if(pos)
            cadena=c.substring(0,posicion);
        else
            cadena=c;
        return cadena;
    }
    public boolean verificarRegistroAlumno(){
        boolean v=true;
        v=v&recorrer(txtRNombre.getText());
        v=v&recorrer(txtRApellidoPat.getText());
        v=v&recorrer(txtRApellidoMat.getText());
        v=v&recorrer(txtRNacimiento1.getText());
        v=v&recorrer(txtRNacimiento2.getText());
        v=v&recorrer(txtRNacimiento3.getText());
        v=v&recorrer(txtRDireccion1.getText());
        v=v&recorrer(txtRTelefono.getText());
        v=v&recorrer(txtRCorreo.getText());
        v=v&recorrer(txtAGS.getText());
        if(cbxANivelAcademico.getSelectedIndex()==0){
            v=false;
        }
        v=v&recorrer(txtRApoderado.getText());
        v=v&recorrer(txtRPagoAlumno.getText());
        if(cbxServicio.getSelectedIndex()==0){
            v=false;
        }
        v=v&recorrer(txtServicio.getText());
        return v;
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
            java.util.logging.Logger.getLogger(Academia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Academia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Academia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Academia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Academia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoB;
    private javax.swing.JMenu MenuOpciones;
    private javax.swing.JScrollPane ScrollAsistencia;
    private javax.swing.JButton btnAbrirFoto;
    private javax.swing.JButton btnActual;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAsisBuscar;
    private javax.swing.JButton btnAsisDocente;
    private javax.swing.JButton btnAsisServicio;
    private javax.swing.JButton btnAsistenciaAdministrativa;
    private javax.swing.JButton btnAsistenciaAlumnos;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDisponibilidad;
    private javax.swing.JButton btnDominioCursos;
    private javax.swing.JButton btnIngresosB;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMAAEntrada;
    private javax.swing.JButton btnMAAceptar;
    private javax.swing.JButton btnMACiclo;
    private javax.swing.JButton btnMAGuardar;
    private javax.swing.JButton btnNRegistrarD;
    private javax.swing.JButton btnObservacion;
    private javax.swing.JButton btnRAdministrativa;
    private javax.swing.JButton btnRAlumnos;
    private javax.swing.JButton btnRDocente;
    private javax.swing.JButton btnRLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresarD;
    private javax.swing.JButton btnSLimpiar;
    private javax.swing.JButton btnSRegistrar;
    private javax.swing.JButton btnSSDocente;
    private javax.swing.JButton btnSSeleccionar;
    private javax.swing.JButton btnServicio;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnTest;
    private javax.swing.JComboBox cbxANivelAcademico;
    private javax.swing.JComboBox cbxAsisServ;
    private javax.swing.JComboBox cbxAsisServicio;
    private javax.swing.JComboBox cbxBalances;
    private javax.swing.JComboBox cbxMA;
    private javax.swing.JComboBox cbxMAHora;
    private javax.swing.JComboBox cbxMATipoS;
    private javax.swing.JComboBox cbxRPago;
    private javax.swing.JComboBox cbxSServicio;
    private javax.swing.JComboBox cbxSTipo;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JComboBox cbxTipoBalances;
    private javax.swing.JFileChooser filechooser;
    private javax.swing.JLabel fondoT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lblAApoderado;
    private javax.swing.JLabel lblAGS;
    private javax.swing.JLabel lblANivelAcademico;
    private javax.swing.JLabel lblAcademiaB;
    private javax.swing.JLabel lblAdministrativa;
    private javax.swing.JLabel lblApellidoMatAsis;
    private javax.swing.JLabel lblApellidoPatAsis;
    private javax.swing.JLabel lblAsesoriaB;
    private javax.swing.JLabel lblAsignacionesB;
    private javax.swing.JLabel lblAsisActual;
    private javax.swing.JLabel lblAsisAnterior;
    private javax.swing.JLabel lblAsisDocente;
    private javax.swing.JLabel lblAsisLimpiar;
    private javax.swing.JLabel lblAsisRegresar;
    private javax.swing.JLabel lblAsisServicio;
    private javax.swing.JLabel lblAsisSiguiente;
    private javax.swing.JLabel lblAsistencia;
    private javax.swing.JLabel lblAsistenciaAdministrativo;
    private javax.swing.JLabel lblAsistenciaAlumno;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDAcademiaB;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblDocentes;
    private javax.swing.JLabel lblDominioCursos;
    private javax.swing.JLabel lblFechaClase;
    private javax.swing.JLabel lblFechaI;
    private javax.swing.JLabel lblLimpiar;
    private javax.swing.JLabel lblMA;
    private javax.swing.JLabel lblMAAdministrativa;
    private javax.swing.JLabel lblMAAlumno;
    private javax.swing.JLabel lblMAApellidoMat;
    private javax.swing.JLabel lblMAApellidoPat;
    private javax.swing.JLabel lblMACiclo;
    private javax.swing.JLabel lblMACodigo;
    private javax.swing.JLabel lblMAIngresar;
    private javax.swing.JLabel lblMANombre;
    private javax.swing.JLabel lblMATitulo;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNApellidoMatD;
    private javax.swing.JLabel lblNApellidoPatD;
    private javax.swing.JLabel lblNCorreoD;
    private javax.swing.JLabel lblNDireccionD;
    private javax.swing.JLabel lblNNacimientoD;
    private javax.swing.JLabel lblNNombreD;
    private javax.swing.JLabel lblNSueldoHoraD;
    private javax.swing.JLabel lblNTelefonoD;
    private javax.swing.JLabel lblNombreAsis;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JLabel lblParticularesB;
    private javax.swing.JLabel lblRAlumnos;
    private javax.swing.JLabel lblRPago;
    private javax.swing.JLabel lblRPagoAlumno;
    private javax.swing.JLabel lblRTitulo;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblSApellidoMat;
    private javax.swing.JLabel lblSApellidoPat;
    private javax.swing.JLabel lblSCAsignacion;
    private javax.swing.JLabel lblSCRealizacion;
    private javax.swing.JLabel lblSCurso;
    private javax.swing.JLabel lblSDireccion;
    private javax.swing.JLabel lblSDocente;
    private javax.swing.JLabel lblSEntrega;
    private javax.swing.JLabel lblSHoras;
    private javax.swing.JLabel lblSLimpiar;
    private javax.swing.JLabel lblSNombre;
    private javax.swing.JLabel lblSPDocente;
    private javax.swing.JLabel lblSPrecio;
    private javax.swing.JLabel lblSRegistrar;
    private javax.swing.JLabel lblSServicio;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblSueldoAcademia;
    private javax.swing.JLabel lblSueldoAsesoria;
    private javax.swing.JLabel lblTIngresos;
    private javax.swing.JLabel lblTest;
    private javax.swing.JMenuItem manuModificarAdministrativo;
    private javax.swing.JMenuItem menuDescuentos;
    private javax.swing.JMenuItem menuInsertarCiclos;
    private javax.swing.JMenuItem menuInsertarCurso;
    private javax.swing.JMenuItem menuInsertarEvaluacion;
    private javax.swing.JMenuItem menuInsertarNotas;
    private javax.swing.JMenuItem menuInsertarSalones;
    private javax.swing.JMenuItem menuListadoAdministrativos;
    private javax.swing.JMenuItem menuListadoAlumnos;
    private javax.swing.JMenuItem menuListadoCicloCursos;
    private javax.swing.JMenuItem menuListadoCiclos;
    private javax.swing.JMenuItem menuListadoCursos;
    private javax.swing.JMenuItem menuListadoDocentes;
    private javax.swing.JMenuItem menuListadoFaltantes;
    private javax.swing.JMenuItem menuListadoNotas;
    private javax.swing.JMenuItem menuModificarAlumno;
    private javax.swing.JMenuItem menuModificarAsesorias;
    private javax.swing.JMenuItem menuModificarAsignacion;
    private javax.swing.JMenuItem menuModificarAsistencia;
    private javax.swing.JMenuItem menuModificarCiclos;
    private javax.swing.JMenuItem menuModificarContrasena;
    private javax.swing.JMenuItem menuModificarCursos;
    private javax.swing.JMenuItem menuModificarDocente;
    private javax.swing.JMenuItem menuModificarEvaluacion;
    private javax.swing.JMenuItem menuModificarNotas;
    private javax.swing.JMenuItem menuModificarParticular;
    private javax.swing.JMenuItem menuModificarSalones;
    private javax.swing.JPanel pnlAsistencia;
    private javax.swing.JPanel pnlBalance;
    private javax.swing.JPanel pnlBienvenido;
    private javax.swing.JPanel pnlFoto;
    private javax.swing.JPanel pnlMAsistencia;
    private javax.swing.JTabbedPane pnlPestanas;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JPanel pnlServicios;
    private javax.swing.JScrollPane sclDisponibilidad;
    private javax.swing.JScrollPane sclDominioCursos;
    private javax.swing.JScrollPane sclMAAsistencias;
    private javax.swing.JTable tblAsistencia;
    private javax.swing.JTable tblDisponibilidad;
    private javax.swing.JTable tblDominioCursos;
    private javax.swing.JTable tblMAAsistencias;
    private javax.swing.JTable tblRecientes;
    private javax.swing.JTextField txtAGS;
    private javax.swing.JFormattedTextField txtAcademiaB;
    private javax.swing.JTextField txtAnoB;
    private javax.swing.JTextField txtApellidoMatAsis;
    private javax.swing.JTextField txtApellidoPatAsis;
    private javax.swing.JFormattedTextField txtAsesoriaB;
    private javax.swing.JFormattedTextField txtAsignacionesB;
    private javax.swing.JTextField txtAsisServicio;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtColaboradoresB;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtFechaI1;
    private javax.swing.JTextField txtFechaI2;
    private javax.swing.JTextField txtFechaI3;
    private javax.swing.JTextField txtMAApellidoMat;
    private javax.swing.JTextField txtMAApellidoPat;
    private javax.swing.JTextField txtMACiclo;
    private javax.swing.JTextField txtMACodigo;
    private javax.swing.JTextField txtMAIngresar;
    private javax.swing.JTextField txtMANombre;
    private javax.swing.JTextField txtMesB;
    private javax.swing.JTextField txtNombreAsis;
    private javax.swing.JTextField txtPagoAdmi;
    private javax.swing.JFormattedTextField txtParticularesB;
    private javax.swing.JTextField txtRApellidoMat;
    private javax.swing.JTextField txtRApellidoPat;
    private javax.swing.JTextField txtRApoderado;
    private javax.swing.JTextField txtRCorreo;
    private javax.swing.JTextField txtRDireccion1;
    private javax.swing.JTextField txtRDireccion2;
    private javax.swing.JTextField txtRFoto;
    private javax.swing.JTextField txtRNacimiento1;
    private javax.swing.JTextField txtRNacimiento2;
    private javax.swing.JTextField txtRNacimiento3;
    private javax.swing.JTextField txtRNombre;
    private javax.swing.JTextField txtRPagoAlumno;
    private javax.swing.JTextField txtRTelefono;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSApellidoMat;
    private javax.swing.JTextField txtSApellidoPat;
    private javax.swing.JTextField txtSCAsignacion;
    private javax.swing.JTextField txtSCRealizacion;
    private javax.swing.JTextField txtSCurso;
    private javax.swing.JTextField txtSDireccion1;
    private javax.swing.JTextField txtSDireccion2;
    private javax.swing.JTextField txtSDocente;
    private javax.swing.JTextField txtSEntrega1;
    private javax.swing.JTextField txtSEntrega2;
    private javax.swing.JTextField txtSEntrega3;
    private javax.swing.JTextField txtSFechaClase1;
    private javax.swing.JTextField txtSFechaClase2;
    private javax.swing.JTextField txtSFechaClase3;
    private javax.swing.JTextField txtSHoras;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JTextField txtSPDocente;
    private javax.swing.JTextField txtSPrecio;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtSueldoAcademia;
    private javax.swing.JTextField txtSueldoAsesoria;
    private javax.swing.JFormattedTextField txtTIngresosB;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnAbrirFoto() {
        return btnAbrirFoto;
    }

    public void setBtnAbrirFoto(javax.swing.JButton btnAbrirFoto) {
        this.btnAbrirFoto = btnAbrirFoto;
    }

    public javax.swing.JFileChooser getFilechooser() {
        return filechooser;
    }

    public void setFilechooser(javax.swing.JFileChooser filechooser) {
        this.filechooser = filechooser;
    }

    public javax.swing.JTextField getTxtRFoto() {
        return txtRFoto;
    }

    public void setTxtRFoto(javax.swing.JTextField txtSFoto) {
        this.txtRFoto = txtRFoto;
    }

    public javax.swing.JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(javax.swing.JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }
}
