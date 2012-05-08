package academia;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.util.Calendar;
import javax.swing.ImageIcon;


public class Modificar_Alumno extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    String direccionfoto;
    Calendar c = Calendar.getInstance();
  
    public Modificar_Alumno() {
        initComponents();
        this.setTitle("Modificar Alumno");
        try {
            FileWriter f = new FileWriter("AltaAlumno.txt");
        } catch (IOException ex) {
            Logger.getLogger(Modificar_Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter h = new FileWriter("ActualizarServicio.txt");
            FileWriter m = new FileWriter("ActualizarAsesoria.txt");
        } catch (IOException ex) {
            Logger.getLogger(Modificar_Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApelPat = new javax.swing.JTextField();
        txtApelMat = new javax.swing.JTextField();
        txtDireccion1 = new javax.swing.JTextField();
        txtDireccion2 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxNivel = new javax.swing.JComboBox();
        txtCorreo = new javax.swing.JTextField();
        txtApoderado = new javax.swing.JTextField();
        txtGS = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lblObs = new javax.swing.JLabel();
        cbxObs = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo:");
        jLabel1.setBounds(30, 100, 64, 20);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });
        txtCodigo.setBounds(90, 90, 70, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.setBounds(180, 90, 65, 30);
        jLayeredPane1.add(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText(" Nombre:");
        jLabel2.setBounds(60, 150, 70, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText(" Apellido Pat:");
        jLabel3.setBounds(40, 190, 100, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText(" Apellido Mat:");
        jLabel4.setBounds(40, 230, 90, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Direccion:");
        jLabel5.setBounds(60, 310, 80, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Telefono:");
        jLabel6.setBounds(420, 150, 80, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Correo:");
        jLabel7.setBounds(430, 190, 70, 30);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        txtNombre.setBounds(120, 150, 130, 30);
        jLayeredPane1.add(txtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtApelPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApelPatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelPatKeyTyped(evt);
            }
        });
        txtApelPat.setBounds(120, 190, 130, 30);
        jLayeredPane1.add(txtApelPat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtApelMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApelMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelMatKeyTyped(evt);
            }
        });
        txtApelMat.setBounds(120, 230, 130, 30);
        jLayeredPane1.add(txtApelMat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDireccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccion1KeyReleased(evt);
            }
        });
        txtDireccion1.setBounds(120, 310, 220, 30);
        jLayeredPane1.add(txtDireccion1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDireccion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccion2KeyReleased(evt);
            }
        });
        txtDireccion2.setBounds(120, 340, 220, 30);
        jLayeredPane1.add(txtDireccion2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        txtTelefono.setBounds(480, 150, 130, 30);
        jLayeredPane1.add(txtTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Apoderado:");
        jLabel8.setBounds(410, 230, 100, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText("Grupo Sanguineo:");
        jLabel9.setBounds(380, 270, 110, 30);
        jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("  Nivel Academico:");
        jLabel10.setBounds(380, 350, 90, 30);
        jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccion Uno", "Primaria", "Secundaria", "Pre-Universitario", "Universitario" }));
        cbxNivel.setBounds(480, 350, 130, 30);
        jLayeredPane1.add(cbxNivel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        txtCorreo.setBounds(480, 190, 130, 30);
        jLayeredPane1.add(txtCorreo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtApoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApoderadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApoderadoKeyTyped(evt);
            }
        });
        txtApoderado.setBounds(480, 230, 130, 30);
        jLayeredPane1.add(txtApoderado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtGS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGSKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGSKeyTyped(evt);
            }
        });
        txtGS.setBounds(480, 270, 130, 30);
        jLayeredPane1.add(txtGS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel12.setText(" Fecha de Nac.:");
        jLabel12.setBounds(30, 270, 100, 30);
        jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha1FocusLost(evt);
            }
        });
        txtFecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha1KeyTyped(evt);
            }
        });
        txtFecha1.setBounds(120, 270, 30, 30);
        jLayeredPane1.add(txtFecha1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha2FocusLost(evt);
            }
        });
        txtFecha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha2KeyTyped(evt);
            }
        });
        txtFecha2.setBounds(160, 270, 30, 30);
        jLayeredPane1.add(txtFecha2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha3FocusLost(evt);
            }
        });
        txtFecha3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha3KeyTyped(evt);
            }
        });
        txtFecha3.setBounds(200, 270, 50, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Alta de Alumnos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(240, 440, 130, 50);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnGuardar.setText("Modificar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.setBounds(20, 440, 100, 50);
        jLayeredPane1.add(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.setBounds(130, 440, 100, 50);
        jLayeredPane1.add(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblObs.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblObs.setText("Observacion:");
        lblObs.setBounds(400, 310, 110, 30);
        jLayeredPane1.add(lblObs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxObs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Si", "No" }));
        cbxObs.setBounds(480, 310, 130, 30);
        jLayeredPane1.add(cbxObs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(380, 440, 90, 50);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarAlumno.png"))); // NOI18N
        jLabel11.setBounds(190, 0, 450, 80);
        jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondo2.jpg"))); // NOI18N
        jLabel13.setBounds(0, 0, 770, 520);
        jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Modificar Foto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(500, 440, 120, 50);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Alta_Alumno x = new Alta_Alumno();
        x.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if(verificarBusqueda()){
            buscar();
        }
        else{
            JOptionPane.showMessageDialog(this,"Ingrese el codigo del alumno","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(verificarDatos()){
            modificarAlumno(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(verificarDatos()){
            modificarAlumno(false);
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        if(txtCodigo.getText().length()>6){
             txtCodigo.setText(txtCodigo.getText().substring(0,6));
        }
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApelPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelPatKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtApelPatKeyTyped

    private void txtApelMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelMatKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtApelMatKeyTyped

    private void txtFecha1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha1KeyTyped

    private void txtFecha2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha2KeyTyped

    private void txtFecha3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha3KeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtApoderadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApoderadoKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtApoderadoKeyTyped

    private void txtGSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGSKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtGSKeyTyped

    private void txtDireccion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion1KeyReleased
        if(txtDireccion1.getText().length()>25){
             txtDireccion1.setText(txtDireccion1.getText().substring(0, 25));
             txtDireccion2.requestFocus(true);
        }
    }//GEN-LAST:event_txtDireccion1KeyReleased

    private void txtDireccion2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion2KeyReleased
        if(txtDireccion2.getText().length()>25){
             txtDireccion2.setText(txtDireccion2.getText().substring(0, 25));
        }
    }//GEN-LAST:event_txtDireccion2KeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if(txtNombre.getText().length()>20){
             txtNombre.setText(txtNombre.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApelPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelPatKeyReleased
        if(txtApelPat.getText().length()>20){
             txtApelPat.setText(txtApelPat.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtApelPatKeyReleased

    private void txtApelMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelMatKeyReleased
        if(txtApelMat.getText().length()>20){
             txtApelMat.setText(txtApelMat.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtApelMatKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        if(txtTelefono.getText().length()>7){
             txtTelefono.setText(txtTelefono.getText().substring(0,7));
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if(txtCorreo.getText().length()>40){
             txtCorreo.setText(txtCorreo.getText().substring(0,40));
        }
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtApoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApoderadoKeyReleased
        if(txtApoderado.getText().length()>50){
             txtApoderado.setText(txtApoderado.getText().substring(0,50));
        }
    }//GEN-LAST:event_txtApoderadoKeyReleased

    private void txtGSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGSKeyReleased
        if(txtGS.getText().length()>10){
             txtGS.setText(txtGS.getText().substring(0,10));
        }
    }//GEN-LAST:event_txtGSKeyReleased

    private void txtFecha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha1FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha1FocusLost

    private void txtFecha2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha2FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha2FocusLost

    private void txtFecha3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha3FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha3FocusLost

    private void txtFecha1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha1KeyReleased
        if(txtFecha1.getText().length()>1){
              txtFecha1.setText(txtFecha1.getText().substring(0, 2));
              if(recorrer(txtFecha2.getText())){
                  if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                      txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFecha1KeyReleased

    private void txtFecha2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha2KeyReleased
        if(txtFecha2.getText().length()>1){
              txtFecha2.setText(txtFecha2.getText().substring(0, 2));
              if(Integer.parseInt(txtFecha2.getText())<0||Integer.parseInt(txtFecha2.getText())>12){
                  txtFecha2.setText("12");
              }
              if(txtFecha2.getText().length()==1){
                  if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                      txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFecha2KeyReleased

    private void txtFecha3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha3KeyReleased
        if(txtFecha3.getText().length()>3){
              txtFecha3.setText(txtFecha3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFecha3KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Modificar_Foto x = new Modificar_Foto();
        x.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
    public boolean verificarBusqueda(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        if(txtCodigo.getText().length()!=6){
             v=false;
        }
        return v;
    }
    public String borrarespacios(String c){
        String cadena=null;
        boolean pos = false;
        int posicion=0;
        if(c!=null){
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
        }
        return cadena;
    }
    public void modificarAlumno(boolean estado){
        try{
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String apelpat= txtApelPat.getText();
            String apelmat= txtApelMat.getText();
            String direccion= txtDireccion1.getText()+" "+txtDireccion2.getText();
            String telefono= txtTelefono.getText();
            String correo=txtCorreo.getText();
            String fechanac= txtFecha3.getText()+"-"+txtFecha2.getText()+"-"+txtFecha1.getText();
            String apoderado= txtApoderado.getText();
            String gs= txtGS.getText();
            String nivelacademico = null;
            switch(cbxNivel.getSelectedIndex()){
                case 1:nivelacademico="P";break;
                case 2:nivelacademico="S";break;
                case 3:nivelacademico="A";break;
                case 4:nivelacademico="U";break;
            }
            Boolean obs=true;
            switch(cbxObs.getSelectedIndex()){
                case 1:obs=true;break;
                case 2:obs=false;break;
            }
                CallableStatement cst = con.prepareCall("{call usp_ActualizarAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst.setString(1,codigo);
                cst.setBoolean(2,estado);
                cst.setString(3,nombre);
                cst.setString(4,apelpat);
                cst.setString(5,apelmat);
                cst.setString(6,direccion);
                cst.setString(7,telefono);
                cst.setString(8,correo);
                cst.setString(9,fechanac);
                cst.setString(10,apoderado);
                cst.setString(11,gs);
                cst.setString(12,nivelacademico);
                cst.setBoolean(13,obs);
                int rpta = cst.executeUpdate();
                if(rpta==1){
                    if(estado){
                        JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"El alumno ha pasado a Inactivo correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                cst.close();
         } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
    }
    public void buscar(){
        try{
            CallableStatement cst = con.prepareCall("{call usp_BusquedaAlumnosActivos(?)}");
            cst.setString(1,txtCodigo.getText());
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[13];
                for(int i=0;i<13;i++){
                    dato[i]=r.getString(i+1);
                }
                txtNombre.setText(borrarespacios(String.valueOf(dato[1])));
                txtApelPat.setText(borrarespacios(String.valueOf(dato[3])));
                txtApelMat.setText(borrarespacios(String.valueOf(dato[2])));
                String direccion=borrarespacios(borrarespacios((String.valueOf(dato[4]))));
                if(direccion.length()>25&&direccion.length()<50){
                    txtDireccion1.setText(direccion.substring(0,25));
                    txtDireccion2.setText(direccion.substring(25,direccion.length()));
                }
                else{
                    if(String.valueOf(direccion).length()<=25){
                        txtDireccion1.setText(String.valueOf(direccion).substring(0,String.valueOf(direccion).length()));
                    }
                }
                txtTelefono.setText(borrarespacios(String.valueOf(dato[5])));
                txtCorreo.setText(borrarespacios(String.valueOf(dato[6])));
                txtFecha1.setText(borrarespacios(String.valueOf(dato[7]).substring(0,2)));
                txtFecha2.setText(borrarespacios(String.valueOf(dato[7]).substring(3,5)));
                txtFecha3.setText(borrarespacios(String.valueOf(dato[7]).substring(6,10)));
                txtApoderado.setText(borrarespacios(String.valueOf(dato[8])));
                txtGS.setText(borrarespacios(String.valueOf(dato[9])));
                switch(String.valueOf(dato[10]).charAt(0)){
                    case 'P':cbxNivel.setSelectedIndex(1);break;
                    case 'S':cbxNivel.setSelectedIndex(2);break;
                    case 'A':cbxNivel.setSelectedIndex(3);break;
                    case 'U':cbxNivel.setSelectedIndex(4);break;
                }
                direccionfoto=String.valueOf(dato[11]);
                if(dato[12]!=null){
                    if(Boolean.valueOf(String.valueOf(dato[12]))){
                        cbxObs.setSelectedIndex(2);
                    }
                    else{
                        cbxObs.setSelectedIndex(1);
                    }
                }
            }
            r.close();
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Codigo ERRONEO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
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
            JOptionPane.showMessageDialog(null,"Error en el directorio","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action)
            file.mkdirs();
        return isDirectory;
    }
    public  void cargarImagen(javax.swing.JDesktopPane jDeskp,File fileImagen)
	{
        try{
            BufferedImage image = ImageIO.read(fileImagen);
            jDeskp.setBorder(new PintaImagen(image)); 
        }
        catch (Exception e){System.out.println("No cargo imagen");}
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
    public boolean verificarDatos(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        if(txtCodigo.getText().length()!=6){
             v=false;
        }
        v=v&recorrer(txtNombre.getText());
        v=v&recorrer(txtApelPat.getText());
        v=v&recorrer(txtApelMat.getText());
        v=v&recorrer(txtFecha1.getText());
        v=v&recorrer(txtFecha2.getText());
        v=v&recorrer(txtFecha3.getText());
        v=v&recorrer(txtDireccion1.getText());
        v=v&recorrer(txtTelefono.getText());
        v=v&recorrer(txtApoderado.getText());
        v=v&recorrer(txtNombre.getText());
        if(cbxObs.getSelectedIndex()==0){
            v=false;
        }
        if(cbxNivel.getSelectedIndex()==0){
            v=false;
        }
        return v;
    }
    public int maximodia(int mes,int año){
        int maximo=0;
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: maximo=31; break;
            case 2: if(año%4==0)
                      maximo=29;
                    else
                      maximo=28;
                    break;
            case 4:
            case 6:
            case 9:
            case 11:maximo=30;break;
        }
        return maximo;
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
            java.util.logging.Logger.getLogger(Modificar_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Alumno().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbxNivel;
    private javax.swing.JComboBox cbxObs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblObs;
    private javax.swing.JTextField txtApelMat;
    private javax.swing.JTextField txtApelPat;
    private javax.swing.JTextField txtApoderado;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtDireccion2;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    private javax.swing.JTextField txtGS;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

  
}
