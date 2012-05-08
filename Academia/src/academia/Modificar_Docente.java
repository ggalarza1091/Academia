package academia;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Calendar;
import javax.swing.ImageIcon;

public class Modificar_Docente extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    Calendar c = Calendar.getInstance();
    String A,M,D;
    public Modificar_Docente() {
        initComponents();
        this.setTitle("Modificar Docente");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        txtFechaI.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApelPat = new javax.swing.JTextField();
        txtApelMat = new javax.swing.JTextField();
        txtDireccion1 = new javax.swing.JTextField();
        txtDireccion2 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cbxPago = new javax.swing.JComboBox();
        txtAcademia = new javax.swing.JTextField();
        txtAsesoria = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtFechaI = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Codigo:");
        jLabel2.setBounds(30, 80, 64, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtCodigo.setBounds(90, 80, 70, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText(" Nombre:");
        jLabel3.setBounds(60, 140, 70, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText(" Apellido Pat:");
        jLabel4.setBounds(40, 180, 100, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText(" Apellido Mat:");
        jLabel5.setBounds(40, 220, 90, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Direccion:");
        jLabel6.setBounds(60, 300, 80, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Celular:");
        jLabel7.setBounds(70, 370, 80, 30);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Correo:");
        jLabel8.setBounds(460, 140, 70, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        txtNombre.setBounds(120, 140, 100, 30);
        jLayeredPane1.add(txtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtApelPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApelPatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelPatKeyTyped(evt);
            }
        });
        txtApelPat.setBounds(120, 180, 100, 30);
        jLayeredPane1.add(txtApelPat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtApelMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApelMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelMatKeyTyped(evt);
            }
        });
        txtApelMat.setBounds(120, 220, 100, 30);
        jLayeredPane1.add(txtApelMat, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDireccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccion1KeyReleased(evt);
            }
        });
        txtDireccion1.setBounds(120, 300, 220, 30);
        jLayeredPane1.add(txtDireccion1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDireccion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccion2KeyReleased(evt);
            }
        });
        txtDireccion2.setBounds(120, 330, 220, 30);
        jLayeredPane1.add(txtDireccion2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        txtTelefono.setBounds(120, 370, 100, 30);
        jLayeredPane1.add(txtTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText("Metodo de Pago:");
        jLabel9.setBounds(410, 180, 100, 30);
        jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ruc:");
        jLabel10.setBounds(470, 220, 80, 30);
        jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        txtCorreo.setBounds(520, 140, 110, 30);
        jLayeredPane1.add(txtCorreo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        txtRuc.setBounds(520, 220, 110, 30);
        jLayeredPane1.add(txtRuc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel12.setText(" Fecha de Nac.:");
        jLabel12.setBounds(30, 260, 100, 30);
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
        txtFecha1.setBounds(120, 260, 30, 30);
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
        txtFecha2.setBounds(160, 260, 30, 30);
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
        txtFecha3.setBounds(200, 260, 40, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarDocente.png"))); // NOI18N
        jLabel1.setBounds(120, 10, 460, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.setBounds(190, 80, 65, 30);
        jLayeredPane1.add(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Ruc", "Efectivo" }));
        cbxPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPagoItemStateChanged(evt);
            }
        });
        cbxPago.setBounds(520, 180, 110, 30);
        jLayeredPane1.add(cbxPago, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAcademia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAcademiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAcademiaKeyTyped(evt);
            }
        });
        txtAcademia.setBounds(520, 300, 110, 30);
        jLayeredPane1.add(txtAcademia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAsesoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAsesoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAsesoriaKeyTyped(evt);
            }
        });
        txtAsesoria.setBounds(520, 340, 110, 30);
        jLayeredPane1.add(txtAsesoria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Pago por Hora:");
        jLabel11.setBounds(420, 260, 120, 30);
        jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Academia:");
        jLabel13.setBounds(450, 300, 70, 30);
        jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" Asesoria:");
        jLabel14.setBounds(450, 340, 90, 30);
        jLayeredPane1.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.setBounds(30, 450, 90, 50);
        jLayeredPane1.add(btnModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.setBounds(160, 450, 90, 50);
        jLayeredPane1.add(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(460, 450, 80, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFechaI.setBounds(330, 90, 70, 20);
        jLayeredPane1.add(txtFechaI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Dar Alta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(560, 450, 80, 50);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(310, 450, 90, 50);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/27.jpg"))); // NOI18N
        jLabel15.setBounds(0, 0, 720, 540);
        jLayeredPane1.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(recorrer(txtCodigo.getText())&&txtCodigo.getText().length()==5){
            busqueda();
        }
        else{
            JOptionPane.showMessageDialog(this,"Ingrese Correctamente el Codigo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    if(verificar()){
        modificarDocente(true);
    }
}//GEN-LAST:event_btnModificarActionPerformed

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    if(verificar()){
        modificarDocente(false);
    }
}//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Alta_Docente x = new Alta_Docente();
        x.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAcademiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcademiaKeyTyped
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9')){
            if(caracter<'.'||caracter>'.'){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAcademiaKeyTyped

    private void txtAsesoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsesoriaKeyTyped
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9')){
            if(caracter<'.'||caracter>'.'){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAsesoriaKeyTyped

    private void txtAcademiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcademiaKeyReleased
        int c=0;
        String texto=txtAcademia.getText();
        if(texto.length()!=0){
            for(int i=0;i<texto.length();i++){
                if(texto.charAt(i)=='.'){
                    c++;
                }
            }
            if(c==2){
                txtAcademia.setText(texto.substring(0,texto.length()-1));
            }
            if(c>2){
                for(int j=1;j<c;j++){
                    txtAcademia.setText(texto.substring(0,texto.length()-1));
                    texto=txtAcademia.getText();
                }
            }
            if(texto.charAt(0)=='.'){
                txtAcademia.setText("0"+texto);
            }
        }
    }//GEN-LAST:event_txtAcademiaKeyReleased

    private void txtAsesoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAsesoriaKeyReleased
        int c=0;
        String texto=txtAsesoria.getText();
        if(texto.length()!=0){
            for(int i=0;i<texto.length();i++){
                if(texto.charAt(i)=='.'){
                    c++;
                }
            }
            if(c==2){
                txtAsesoria.setText(texto.substring(0,texto.length()-1));
            }
            if(c>2){
                for(int j=1;j<c;j++){
                    txtAsesoria.setText(texto.substring(0,texto.length()-1));
                    texto=txtAsesoria.getText();
                }
            }
            if(texto.charAt(0)=='.'){
                txtAsesoria.setText("0"+texto);
            }
        }
    }//GEN-LAST:event_txtAsesoriaKeyReleased

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

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtRucKeyTyped

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

    private void txtDireccion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion1KeyReleased
        if(txtDireccion1.getText().length()>24&&evt.getKeyCode()!=evt.VK_SHIFT&&evt.getKeyCode()!=evt.VK_LEFT&&evt.getKeyCode()!=evt.VK_RIGHT&&evt.getKeyCode()!=evt.VK_UP&&evt.getKeyCode()!=evt.VK_DOWN){
             txtDireccion1.setText(txtDireccion1.getText().substring(0, 25));
             txtDireccion2.requestFocus(true);
        }
    }//GEN-LAST:event_txtDireccion1KeyReleased

    private void txtDireccion2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion2KeyReleased
        if(txtDireccion2.getText().length()>25){
             txtDireccion2.setText(txtDireccion2.getText().substring(0, 25));
        }
    }//GEN-LAST:event_txtDireccion2KeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        if(txtTelefono.getText().length()>9){
             txtTelefono.setText(txtTelefono.getText().substring(0, 9));
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if(txtCorreo.getText().length()>40){
             txtCorreo.setText(txtCorreo.getText().substring(0, 40));
        }
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyReleased
        if(txtRuc.getText().length()>20){
             txtRuc.setText(txtRuc.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtRucKeyReleased

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPagoItemStateChanged
        switch(cbxPago.getSelectedIndex()){
            case 0:break;
            case 1:break;
            case 2:break;
        }
    }//GEN-LAST:event_cbxPagoItemStateChanged
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
public boolean verificar(){
    boolean v=true;
    v=v&recorrer(txtNombre.getText());
    v=v&recorrer(txtApelPat.getText());
    v=v&recorrer(txtApelMat.getText());
    v=v&recorrer(txtFecha1.getText())&recorrer(txtFecha2.getText())&recorrer(txtFecha3.getText());
    v=v&recorrer(txtDireccion1.getText());
    if(cbxPago.getSelectedIndex()==1){
        v=v&recorrer(txtRuc.getText());
    }
    if(cbxPago.getSelectedIndex()==2){
        txtRuc.setText("");
    }
    if(cbxPago.getSelectedIndex()==0){
        v=false;
    }
    v=v&recorrer(txtAcademia.getText());
    v=v&recorrer(txtAsesoria.getText());
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
public void busqueda(){
    try {
            String codigo = txtCodigo.getText();
            CallableStatement cst = con.prepareCall("{call usp_ConsultarProfesor(?)}");
            cst.setString(1,codigo);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[14];
                for(int i=0;i<14;i++){
                    dato[i]=r.getString(i+1);
                }
                txtCodigo.setText(codigo);
                txtNombre.setText(String.valueOf(dato[1]));
                txtApelPat.setText(String.valueOf(dato[2]));
                txtApelMat.setText(String.valueOf(dato[3]));
                String direccion=borrarespacios(String.valueOf(dato[4]));
                if(direccion.length()>25&&direccion.length()<50){
                    txtDireccion1.setText(direccion.substring(0,25));
                    txtDireccion2.setText(direccion.substring(25,direccion.length()));
                }
                else{
                    if(direccion.length()<=25){
                        txtDireccion1.setText(direccion.substring(0,direccion.length()));
                    }
                }
                txtTelefono.setText(String.valueOf(dato[5]));
                txtCorreo.setText(borrarespacios(String.valueOf(dato[6])));
                switch(String.valueOf(dato[7]).charAt(0)){
                    case 'R':cbxPago.setSelectedIndex(1);break;
                    case 'E':cbxPago.setSelectedIndex(2);break;
                }
                if(String.valueOf(dato[7]).charAt(0)=='R'){
                    txtRuc.setText(borrarespacios(String.valueOf(dato[10])));
                }
                txtFechaI.setText(String.valueOf(dato[9]));
                txtFecha3.setText(String.valueOf(dato[11]).substring(0,4));
                txtFecha2.setText(String.valueOf(dato[11]).substring(5,7));
                txtFecha1.setText(String.valueOf(dato[11]).substring(8,10));
                txtAcademia.setText(String.valueOf(dato[12]));
                txtAsesoria.setText(String.valueOf(dato[13]));
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Codigo Erroneo","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Modificar_Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void limpiar(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApelPat.setText("");
        txtApelMat.setText("");
        txtFecha1.setText("");
        txtFecha2.setText("");
        txtFecha3.setText("");
        txtDireccion1.setText("");
        txtDireccion2.setText("");
        txtTelefono.setText("");
        txtFechaI.setText("");
        txtCorreo.setText("");
        txtRuc.setText("");
        txtAcademia.setText("");
        txtAsesoria.setText("");
        cbxPago.setSelectedIndex(0);
    }
public void modificarDocente(boolean estado){
    try{
        D=Integer.toString(c.get(Calendar.DATE));
        M=Integer.toString(c.get(Calendar.MONTH)+1);
        A=Integer.toString(c.get(Calendar.YEAR));
        System.out.println(A+"-"+M+"-"+D);
        String fechaS=A+"-"+M+"-"+D;
        String fechaI=txtFechaI.getText();
        CallableStatement cst = con.prepareCall("{call usp_ActualizarColaboradorProfesor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        cst.setString(1,txtCodigo.getText());
        cst.setBoolean(2,estado);
        cst.setString(3,fechaS);
        cst.setString(4,txtNombre.getText());
        cst.setString(5,txtApelPat.getText());
        cst.setString(6,txtApelMat.getText());
        cst.setString(7,txtDireccion1.getText()+txtDireccion2.getText());
        cst.setString(8,txtTelefono.getText());
        cst.setString(9,txtCorreo.getText());
        cst.setString(10,String.valueOf(String.valueOf(cbxPago.getSelectedItem()).charAt(0)));
        cst.setString(11,fechaI);
        cst.setString(12,txtRuc.getText());
        cst.setString(13,txtFecha1.getText()+"-"+txtFecha2.getText()+"-"+txtFecha3.getText());
        cst.setDouble(14,Double.parseDouble(txtAcademia.getText()));
        cst.setDouble(15,Double.parseDouble(txtAsesoria.getText()));
        int rpta = cst.executeUpdate();
        if(rpta==1){
            if(estado){
                JOptionPane.showMessageDialog(this,"Se ha modificado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);}
            else{
                JOptionPane.showMessageDialog(this,"Se ha eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);}
            limpiar();
        }
        cst.close();
     } catch (SQLException ex) {
    JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
    Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
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
            java.util.logging.Logger.getLogger(Modificar_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Docente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField txtAcademia;
    private javax.swing.JTextField txtApelMat;
    private javax.swing.JTextField txtApelPat;
    private javax.swing.JTextField txtAsesoria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtDireccion2;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    private javax.swing.JTextField txtFechaI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
