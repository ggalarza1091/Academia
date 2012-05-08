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

public class Modificar_Ciclos extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Modificar_Ciclos() {
        initComponents();
        this.setTitle("Modificar Ciclos");
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
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFechaI1 = new javax.swing.JTextField();
        txtFechaI2 = new javax.swing.JTextField();
        txtFechaI3 = new javax.swing.JTextField();
        txtFechaT1 = new javax.swing.JTextField();
        txtFechaT2 = new javax.swing.JTextField();
        txtFechaT3 = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtCiclo = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarCiclos.png"))); // NOI18N
        jLabel1.setBounds(50, 20, 400, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo:");
        jLabel2.setBounds(100, 110, 50, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.setEditable(false);
        txtCodigo.setBounds(190, 110, 80, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(280, 110, 120, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.setBounds(40, 450, 100, 50);
        jLayeredPane1.add(btnModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.setBounds(200, 450, 100, 50);
        jLayeredPane1.add(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Costo:");
        jLabel3.setBounds(100, 210, 50, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ciclo:");
        jLabel4.setBounds(100, 160, 40, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Inicio:");
        jLabel5.setBounds(100, 320, 100, 20);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha Termino:");
        jLabel6.setBounds(100, 380, 110, 20);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFechaI1.setBounds(190, 310, 30, 30);
        jLayeredPane1.add(txtFechaI1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFechaI2.setBounds(230, 310, 30, 30);
        jLayeredPane1.add(txtFechaI2, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFechaI3.setBounds(270, 310, 50, 30);
        jLayeredPane1.add(txtFechaI3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaT1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaT1FocusLost(evt);
            }
        });
        txtFechaT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaT1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaT1KeyTyped(evt);
            }
        });
        txtFechaT1.setBounds(190, 370, 30, 30);
        jLayeredPane1.add(txtFechaT1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaT2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaT2FocusLost(evt);
            }
        });
        txtFechaT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaT2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaT2KeyTyped(evt);
            }
        });
        txtFechaT2.setBounds(230, 370, 30, 30);
        jLayeredPane1.add(txtFechaT2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaT3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaT3FocusLost(evt);
            }
        });
        txtFechaT3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaT3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaT3KeyTyped(evt);
            }
        });
        txtFechaT3.setBounds(270, 370, 50, 30);
        jLayeredPane1.add(txtFechaT3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        txtCosto.setBounds(190, 210, 80, 30);
        jLayeredPane1.add(txtCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCiclo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCicloKeyReleased(evt);
            }
        });
        txtCiclo.setBounds(190, 160, 130, 30);
        jLayeredPane1.add(txtCiclo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(370, 450, 90, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Matricula:");
        jLabel7.setBounds(100, 264, 60, 20);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });
        txtMatricula.setBounds(190, 260, 80, 30);
        jLayeredPane1.add(txtMatricula, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/24.jpg"))); // NOI18N
        jLabel8.setBounds(0, 0, 500, 550);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Seleccionar_Ciclo x = new Seleccionar_Ciclo();
        x.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
                String linea;
                FileReader f = new FileReader("ActualizarServicio.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        txtCodigo.setText(t.nextToken());
                        txtCosto.setText(t.nextToken());
                        txtMatricula.setText(t.nextToken());
                        txtCiclo.setText(t.nextToken());
                        String fechaI=t.nextToken();
                        System.out.println(fechaI);
                        txtFechaI3.setText(String.valueOf(fechaI).substring(6,10));
                        txtFechaI2.setText(String.valueOf(fechaI).substring(3,5));
                        txtFechaI1.setText(String.valueOf(fechaI).substring(0,2));
                        String fechaT=t.nextToken();
                        txtFechaT3.setText(String.valueOf(fechaT).substring(6,10));
                        txtFechaT2.setText(String.valueOf(fechaT).substring(3,5));
                        txtFechaT1.setText(String.valueOf(fechaT).substring(0,2));
                        
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
            limpiarArchivo();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        limpiarArchivo();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(recorrer(txtCodigo.getText())){
            modificarCiclo(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (recorrer(txtCodigo.getText())) {             modificarCiclo(false);         }     }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9')){
            if(caracter<'.'||caracter>'.'){
                evt.consume();
            }
        }

    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtFechaI1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaI1KeyTyped

    private void txtFechaI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaI2KeyTyped

    private void txtFechaI3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaI3KeyTyped

    private void txtFechaT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaT1KeyTyped

    private void txtFechaT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaT2KeyTyped

    private void txtFechaT3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFechaT3KeyTyped

    private void txtCicloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCicloKeyReleased
        if(txtCiclo.getText().length()>20){
             txtCiclo.setText(txtCiclo.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtCicloKeyReleased

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

    private void txtFechaI1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI1KeyReleased
        if(txtFechaI1.getText().length()>1){
              txtFechaI1.setText(txtFechaI1.getText().substring(0, 2));
              if(recorrer(txtFechaI2.getText())){
                  if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))){
                      txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaI1KeyReleased

    private void txtFechaI2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI2KeyReleased
        if(txtFechaI2.getText().length()>1){
              txtFechaI2.setText(txtFechaI2.getText().substring(0, 2));
              if(Integer.parseInt(txtFechaI2.getText())<0||Integer.parseInt(txtFechaI2.getText())>12){
                  txtFechaI2.setText("12");
              }
              if(txtFechaI2.getText().length()==1){
                  if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))){
                      txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaI2KeyReleased

    private void txtFechaI3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI3KeyReleased
        if(txtFechaI3.getText().length()>3){
              txtFechaI3.setText(txtFechaI3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFechaI3KeyReleased

    private void txtFechaT1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT1KeyReleased
        if(txtFechaT1.getText().length()>1){
              txtFechaT1.setText(txtFechaT1.getText().substring(0, 2));
              if(recorrer(txtFechaT2.getText())){
                  if(Integer.parseInt(txtFechaT1.getText())<1||Integer.parseInt(txtFechaT1.getText())>maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))){
                      txtFechaT1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaT1KeyReleased

    private void txtFechaT2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT2KeyReleased
        if(txtFechaT2.getText().length()>1){
              txtFechaT2.setText(txtFechaT2.getText().substring(0, 2));
              if(Integer.parseInt(txtFechaT2.getText())<0||Integer.parseInt(txtFechaT2.getText())>12){
                  txtFechaT2.setText("12");
              }
              if(txtFechaT2.getText().length()==1){
                  if(Integer.parseInt(txtFechaT1.getText())<1||Integer.parseInt(txtFechaT1.getText())>maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))){
                      txtFechaT1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFechaT2KeyReleased

    private void txtFechaT3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT3KeyReleased
        if(txtFechaI3.getText().length()>3){
              txtFechaI3.setText(txtFechaI3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFechaT3KeyReleased

    private void txtFechaI1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaI1FocusLost
        if(recorrer(txtFechaI2.getText())){
            if(recorrer(txtFechaI1.getText())){
                if(recorrer(txtFechaI3.getText())){
                      if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))){
                          txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaI1FocusLost

    private void txtFechaI2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaI2FocusLost
        if(recorrer(txtFechaI2.getText())){
            if(recorrer(txtFechaI1.getText())){
                if(recorrer(txtFechaI3.getText())){
                      if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))){
                          txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaI2FocusLost

    private void txtFechaI3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaI3FocusLost
        if(recorrer(txtFechaI2.getText())){
            if(recorrer(txtFechaI1.getText())){
                if(recorrer(txtFechaI3.getText())){
                      if(Integer.parseInt(txtFechaI1.getText())<1||Integer.parseInt(txtFechaI1.getText())>maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))){
                          txtFechaI1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaI2.getText()),Integer.parseInt(txtFechaI3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaI3FocusLost

    private void txtFechaT1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaT1FocusLost
        if(recorrer(txtFechaT2.getText())){
            if(recorrer(txtFechaT1.getText())){
                if(recorrer(txtFechaT3.getText())){
                      if(Integer.parseInt(txtFechaT1.getText())<1||Integer.parseInt(txtFechaT1.getText())>maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))){
                          txtFechaT1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaT1FocusLost

    private void txtFechaT2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaT2FocusLost
        if(recorrer(txtFechaT2.getText())){
            if(recorrer(txtFechaT1.getText())){
                if(recorrer(txtFechaT3.getText())){
                      if(Integer.parseInt(txtFechaT1.getText())<1||Integer.parseInt(txtFechaT1.getText())>maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))){
                          txtFechaT1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaT2FocusLost

    private void txtFechaT3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaT3FocusLost
        if(recorrer(txtFechaT2.getText())){
            if(recorrer(txtFechaT1.getText())){
                if(recorrer(txtFechaT3.getText())){
                      if(Integer.parseInt(txtFechaT1.getText())<1||Integer.parseInt(txtFechaT1.getText())>maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))){
                          txtFechaT1.setText(String.valueOf(maximodia(Integer.parseInt(txtFechaT2.getText()),Integer.parseInt(txtFechaT3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFechaT3FocusLost

private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
    char caracter = evt.getKeyChar();
    if((caracter < '0') ||(caracter > '9')){
        if(caracter<'.'||caracter>'.'){
            evt.consume();
        }
    }
}//GEN-LAST:event_txtMatriculaKeyTyped

private void txtMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyReleased
        int c=0;
        String texto=txtMatricula.getText();
        if(texto.length()!=0){
            for(int i=0;i<texto.length();i++){
                if(texto.charAt(i)=='.'){
                    c++;
                }
            }
            if(c==2){
                txtMatricula.setText(texto.substring(0,texto.length()-1));
            }
            if(c>2){
                for(int j=1;j<c;j++){
                    txtMatricula.setText(texto.substring(0,texto.length()-1));
                    texto=txtMatricula.getText();
                }
            }
            if(texto.charAt(0)=='.'){
                txtMatricula.setText("0"+texto);
            }
        }

}//GEN-LAST:event_txtMatriculaKeyReleased
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
    public void limpiarArchivo(){
        try {
            FileWriter f = new FileWriter("ActualizarServicio.txt");
            PrintWriter p = new PrintWriter(f);
            p.close();
        } catch (IOException ex) {}
    }
    public void modificarCiclo(boolean estado){
        try{
            CallableStatement cst = con.prepareCall("{call usp_ActualizarCicloAcademico(?,?,?,?,?,?,?)}");
            cst.setString(1,txtCodigo.getText());
            cst.setBoolean(2,estado);
            cst.setDouble(3,Double.parseDouble(txtCosto.getText()));
            cst.setDouble(4,Double.parseDouble(txtMatricula.getText()));
            cst.setString(5,txtCiclo.getText());
            cst.setString(6,txtFechaI3.getText()+"-"+txtFechaI2.getText()+"-"+txtFechaI1.getText());
            cst.setString(7,txtFechaT3.getText()+"-"+txtFechaT2.getText()+"-"+txtFechaT1.getText());
            int rpta = cst.executeUpdate();
            if(rpta==1){
                if(estado){
                    JOptionPane.showMessageDialog(this,"Se ha modificado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);}
                else{
                    JOptionPane.showMessageDialog(this,"Se ha eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);}
            }
            cst.close();
            limpiarArchivo();
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
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
            java.util.logging.Logger.getLogger(Modificar_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Ciclos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField txtCiclo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFechaI1;
    private javax.swing.JTextField txtFechaI2;
    private javax.swing.JTextField txtFechaI3;
    private javax.swing.JTextField txtFechaT1;
    private javax.swing.JTextField txtFechaT2;
    private javax.swing.JTextField txtFechaT3;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
