package academia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.Image;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Modificar_Asignacion extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Modificar_Asignacion() {
        initComponents();
        this.setTitle("Modificar Asignacion");
        limpiarArchivo();
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtFechaE1 = new javax.swing.JTextField();
        txtFechaE2 = new javax.swing.JTextField();
        txtFechaE3 = new javax.swing.JTextField();
        txtFechaR1 = new javax.swing.JTextField();
        txtFechaR2 = new javax.swing.JTextField();
        txtFechaR3 = new javax.swing.JTextField();
        txtDocente = new javax.swing.JTextField();
        btnDocente = new javax.swing.JButton();
        txtPago = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Cliente:");
        jLabel1.setBounds(150, 150, 90, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Codigo:");
        jLabel2.setBounds(150, 100, 90, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Costo:");
        jLabel3.setBounds(150, 200, 90, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Fecha de Entrega:");
        jLabel4.setBounds(150, 250, 130, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Fecha de Recepcion:");
        jLabel5.setBounds(150, 300, 150, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Pago al Docente:");
        jLabel6.setBounds(150, 410, 130, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("Docente:");
        jLabel7.setBounds(150, 350, 90, 30);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.setEditable(false);
        txtCodigo.setBounds(220, 100, 100, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Asignacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(340, 100, 90, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });
        txtCliente.setBounds(220, 150, 210, 30);
        jLayeredPane1.add(txtCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        txtCosto.setBounds(220, 200, 70, 30);
        jLayeredPane1.add(txtCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaE1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaE1FocusLost(evt);
            }
        });
        txtFechaE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaE1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaE1KeyTyped(evt);
            }
        });
        txtFechaE1.setBounds(290, 250, 30, 30);
        jLayeredPane1.add(txtFechaE1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaE2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaE2FocusLost(evt);
            }
        });
        txtFechaE2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaE2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaE2KeyTyped(evt);
            }
        });
        txtFechaE2.setBounds(330, 250, 30, 30);
        jLayeredPane1.add(txtFechaE2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaE3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaE3FocusLost(evt);
            }
        });
        txtFechaE3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaE3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaE3KeyTyped(evt);
            }
        });
        txtFechaE3.setBounds(370, 250, 40, 30);
        jLayeredPane1.add(txtFechaE3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaR1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaR1FocusLost(evt);
            }
        });
        txtFechaR1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaR1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaR1KeyTyped(evt);
            }
        });
        txtFechaR1.setBounds(290, 300, 30, 30);
        jLayeredPane1.add(txtFechaR1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaR2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaR2FocusLost(evt);
            }
        });
        txtFechaR2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaR2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaR2KeyTyped(evt);
            }
        });
        txtFechaR2.setBounds(330, 300, 30, 30);
        jLayeredPane1.add(txtFechaR2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaR3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaR3FocusLost(evt);
            }
        });
        txtFechaR3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaR3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaR3KeyTyped(evt);
            }
        });
        txtFechaR3.setBounds(370, 300, 40, 30);
        jLayeredPane1.add(txtFechaR3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtDocente.setBounds(220, 350, 80, 30);
        jLayeredPane1.add(txtDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnDocente.setText("Docente");
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });
        btnDocente.setBounds(320, 350, 73, 30);
        jLayeredPane1.add(btnDocente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });
        txtPago.setBounds(260, 410, 70, 30);
        jLayeredPane1.add(txtPago, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.setBounds(70, 480, 90, 50);
        jLayeredPane1.add(btnModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.setBounds(240, 480, 90, 50);
        jLayeredPane1.add(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(400, 480, 90, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarAsignacion.png"))); // NOI18N
        jLabel8.setBounds(20, 20, 510, 60);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/6.jpg"))); // NOI18N
        jLabel9.setBounds(0, 0, 560, 560);
        jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        limpiarArchivo();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        if(recorrer(txtCodigo.getText())){
            Seleccionar_Docente x = new Seleccionar_Docente();
            x.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione la asginacion a modificar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            String linea;
            FileReader f = new FileReader("ActualizarAsignacion.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                String boleano=t.nextToken();
                if(Boolean.valueOf(boleano)){
                    txtCodigo.setText(t.nextToken());
                    txtCosto.setText(t.nextToken());
                    String fecharec=t.nextToken();
                    System.out.println(fecharec);
                    txtFechaR3.setText(String.valueOf(fecharec).substring(6,10));
                    txtFechaR2.setText(String.valueOf(fecharec).substring(3,5));
                    txtFechaR1.setText(String.valueOf(fecharec).substring(0,2));
                    String fechaent=t.nextToken();
                    txtFechaE3.setText(String.valueOf(fechaent).substring(6,10));
                    txtFechaE2.setText(String.valueOf(fechaent).substring(3,5));
                    txtFechaE1.setText(String.valueOf(fechaent).substring(0,2));
                    txtPago.setText(t.nextToken());
                    txtCliente.setText(t.nextToken());
                    txtDocente.setText(t.nextToken());
                }
                else{
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                }
            }
            b.close();
        } catch (IOException ex) {}
        limpiarArchivo();
        try {
            String linea;
            FileReader f = new FileReader("ActualizarDocente.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                String boleano = t.nextToken();
                if(Boolean.valueOf(boleano)){
                    txtDocente.setText(t.nextToken());
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
        try {
            FileWriter g = new FileWriter("ActualizarDocente.txt");
        } catch (IOException ex) {
            Logger.getLogger(Modificar_Particular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Seleccionar_Asignacion x = new Seleccionar_Asignacion();
        x.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(recorrer(txtCodigo.getText())){
            modificarAsignacion();
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione la asginacion a modificar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(recorrer(txtCodigo.getText())){
            eliminarAsignacion();
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione la asginacion a modificar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyReleased
        if(txtCliente.getText().length()>50){
             txtCliente.setText(txtCliente.getText().substring(0, 50));
        }
    }//GEN-LAST:event_txtClienteKeyReleased

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
                char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9')){
            if(caracter<'.'||caracter>'.'){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
                int c=0;
        String texto=txtCosto.getText();
        if(texto.length()!=0){
            for(int i=0;i<texto.length();i++){
                if(texto.charAt(i)=='.'){
                    c++;
                }
            }
            if(c==2){
                txtCosto.setText(texto.substring(0,texto.length()-1));
            }
            if(c>2){
                for(int j=1;j<c;j++){
                    txtCosto.setText(texto.substring(0,texto.length()-1));
                    texto=txtCosto.getText();
                }
            }
            if(texto.charAt(0)=='.'){
                txtCosto.setText("0"+texto);
            }
        }
    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
                char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9')){
            if(caracter<'.'||caracter>'.'){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPagoKeyTyped

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
                int c=0;
        String texto=txtPago.getText();
        if(texto.length()!=0){
            for(int i=0;i<texto.length();i++){
                if(texto.charAt(i)=='.'){
                    c++;
                }
            }
            if(c==2){
                txtPago.setText(texto.substring(0,texto.length()-1));
            }
            if(c>2){
                for(int j=1;j<c;j++){
                    txtPago.setText(texto.substring(0,texto.length()-1));
                    texto=txtPago.getText();
                }
            }
            if(texto.charAt(0)=='.'){
                txtPago.setText("0"+texto);
            }
        }
    }//GEN-LAST:event_txtPagoKeyReleased

    private void txtFechaE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaE1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaE1KeyTyped

    private void txtFechaE2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaE2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaE2KeyTyped

    private void txtFechaE3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaE3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaE3KeyTyped

    private void txtFechaR1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaR1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaR1KeyTyped

    private void txtFechaR2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaR2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaR2KeyTyped

    private void txtFechaR3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaR3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaR3KeyTyped

    private void txtFechaE1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaE1KeyReleased
        if(txtFechaE1.getText().length()>1){
              txtFechaE1.setText(txtFechaE1.getText().substring(0, 2));
              if(recorrer(txtFechaE2.getText())){
                  if(Integer.parseInt(txtFechaE1.getText())<1||Integer.parseInt(txtFechaE1.getText())>maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))){
                      txtFechaE1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaE1KeyReleased

    private void txtFechaE2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaE2KeyReleased
         if(txtFechaE2.getText().length()>1){
              txtFechaE2.setText(txtFechaE2.getText().substring(0, 2));
              if(Integer.parseInt(txtFechaE2.getText())<0||Integer.parseInt(txtFechaE2.getText())>12){
                  txtFechaE2.setText("12");
              }
              if(txtFechaE2.getText().length()==1){
                  if(Integer.parseInt(txtFechaE1.getText())<1||Integer.parseInt(txtFechaE1.getText())>maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))){
                      txtFechaE1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaE2KeyReleased

    private void txtFechaE3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaE3KeyReleased
        if(txtFechaE3.getText().length()>3){
              txtFechaE3.setText(txtFechaE3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFechaE3KeyReleased

    private void txtFechaR1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaR1KeyReleased
        if(txtFechaR1.getText().length()>1){
              txtFechaR1.setText(txtFechaR1.getText().substring(0, 2));
              if(recorrer(txtFechaE2.getText())){
                  if(Integer.parseInt(txtFechaR1.getText())<1||Integer.parseInt(txtFechaR1.getText())>maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaE3.getText()))){
                      txtFechaR1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaR1KeyReleased

    private void txtFechaR2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaR2KeyReleased
        if(txtFechaR2.getText().length()>1){
              txtFechaR2.setText(txtFechaR2.getText().substring(0, 2));
              if(Integer.parseInt(txtFechaR2.getText())<0||Integer.parseInt(txtFechaR2.getText())>12){
                  txtFechaR2.setText("12");
              }
              if(txtFechaR2.getText().length()==1){
                  if(Integer.parseInt(txtFechaR1.getText())<1||Integer.parseInt(txtFechaR1.getText())>maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))){
                      txtFechaR1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaR2KeyReleased

    private void txtFechaR3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaR3KeyReleased
        if(txtFechaR3.getText().length()>3){
              txtFechaR3.setText(txtFechaR3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFechaR3KeyReleased

    private void txtFechaE1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaE1FocusLost
        if(recorrer(txtFechaE2.getText())){
            if(recorrer(txtFechaE1.getText())){
                if(recorrer(txtFechaE3.getText())){
                      if(Integer.parseInt(txtFechaE1.getText())<1||Integer.parseInt(txtFechaE1.getText())>maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))){
                          txtFechaE1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaE1FocusLost

    private void txtFechaE2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaE2FocusLost
        if(recorrer(txtFechaE2.getText())){
            if(recorrer(txtFechaE1.getText())){
                if(recorrer(txtFechaE3.getText())){
                      if(Integer.parseInt(txtFechaE1.getText())<1||Integer.parseInt(txtFechaE1.getText())>maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))){
                          txtFechaE1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaE2FocusLost

    private void txtFechaE3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaE3FocusLost
        if(recorrer(txtFechaE2.getText())){
            if(recorrer(txtFechaE1.getText())){
                if(recorrer(txtFechaE3.getText())){
                      if(Integer.parseInt(txtFechaE1.getText())<1||Integer.parseInt(txtFechaE1.getText())>maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))){
                          txtFechaE1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaE2.getText()),Integer.parseInt(txtFechaE3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaE3FocusLost

    private void txtFechaR1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaR1FocusLost
        if(recorrer(txtFechaR2.getText())){
            if(recorrer(txtFechaR1.getText())){
                if(recorrer(txtFechaR3.getText())){
                      if(Integer.parseInt(txtFechaR1.getText())<1||Integer.parseInt(txtFechaR1.getText())>maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))){
                          txtFechaR1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaR1FocusLost

    private void txtFechaR2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaR2FocusLost
        if(recorrer(txtFechaR2.getText())){
            if(recorrer(txtFechaR1.getText())){
                if(recorrer(txtFechaR3.getText())){
                      if(Integer.parseInt(txtFechaR1.getText())<1||Integer.parseInt(txtFechaR1.getText())>maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))){
                          txtFechaR1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaR2FocusLost

    private void txtFechaR3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaR3FocusLost
        if(recorrer(txtFechaR2.getText())){
            if(recorrer(txtFechaR1.getText())){
                if(recorrer(txtFechaR3.getText())){
                      if(Integer.parseInt(txtFechaR1.getText())<1||Integer.parseInt(txtFechaR1.getText())>maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))){
                          txtFechaR1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaR2.getText()),Integer.parseInt(txtFechaR3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaR3FocusLost
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
    public void modificarAsignacion(){
        try{
            String fecharec= txtFechaR3.getText()+"-"+txtFechaR2.getText()+"-"+txtFechaR1.getText();
            String fechaent= txtFechaE3.getText()+"-"+txtFechaE2.getText()+"-"+txtFechaE1.getText();
            CallableStatement cst = con.prepareCall("{call usp_ActualizarAsignacion(?,?,?,?,?,?,?)}");
            cst.setString(1,txtCodigo.getText());
            cst.setDouble(2,Double.parseDouble(txtCosto.getText()));
            cst.setString(3,fecharec);
            cst.setString(4,fechaent);
            cst.setDouble(5,Double.parseDouble(txtPago.getText()));
            cst.setString(6,txtCliente.getText());
            cst.setString(7,txtDocente.getText());
            int rpta = cst.executeUpdate();
            if(rpta==1){
                    JOptionPane.showMessageDialog(this,"Se ha modificado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);}
            cst.close();
            limpiarArchivo();
            limpiar();
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
    }
    public void eliminarAsignacion(){
        try{
            CallableStatement cst = con.prepareCall("{call usp_EliminarAsignacion(?)}");
            cst.setString(1,txtCodigo.getText());
            int rpta = cst.executeUpdate();
            if(rpta>=1){
                    JOptionPane.showMessageDialog(this,"Se ha eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);}
            cst.close();
            limpiarArchivo();
            limpiar();
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
    }
            
            
    public void limpiarArchivo(){
        try {
            FileWriter f = new FileWriter("ActualizarAsignacion.txt");
            PrintWriter p = new PrintWriter(f);
            p.close();
        } catch (IOException ex) {}
    }
    public void limpiar(){
        txtCodigo.setText("");
        txtCosto.setText("");
        txtDocente.setText("");
        txtCliente.setText("");
        txtPago.setText("");
        txtFechaR1.setText("");
        txtFechaR2.setText("");
        txtFechaR3.setText("");
        txtFechaE1.setText("");
        txtFechaE2.setText("");
        txtFechaE3.setText("");
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
            java.util.logging.Logger.getLogger(Modificar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Asignacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtFechaE1;
    private javax.swing.JTextField txtFechaE2;
    private javax.swing.JTextField txtFechaE3;
    private javax.swing.JTextField txtFechaR1;
    private javax.swing.JTextField txtFechaR2;
    private javax.swing.JTextField txtFechaR3;
    private javax.swing.JTextField txtPago;
    // End of variables declaration//GEN-END:variables
}
