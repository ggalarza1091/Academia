package academia;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
public class Modificar_Profesor_Dictando extends javax.swing.JFrame {
Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Modificar_Profesor_Dictando() {
        initComponents();
        this.setTitle("Modificar Cursos Docente");
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
        cbxServicio = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaI1 = new javax.swing.JTextField();
        txtFechaI2 = new javax.swing.JTextField();
        txtFechaI3 = new javax.swing.JTextField();
        txtFechaT3 = new javax.swing.JTextField();
        txtFechaT2 = new javax.swing.JTextField();
        txtFechaT1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Academia", "Asesoria" }));
        cbxServicio.setBounds(120, 150, 100, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Servicio:");
        jLabel8.setBounds(20, 190, 60, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DRAG_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(120, 190, 100, 30);
        jLayeredPane1.add(txtServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Curso:");
        jLabel1.setBounds(20, 270, 50, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCurso.setEditable(false);
        txtCurso.setBounds(120, 270, 100, 30);
        jLayeredPane1.add(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Codigo Docente:");
        jLabel2.setBounds(20, 310, 110, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(120, 310, 100, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Fecha Inicio:");
        jLabel3.setBounds(20, 370, 70, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFechaI1.setBounds(120, 370, 40, 30);
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
        txtFechaI2.setBounds(170, 370, 40, 30);
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
        txtFechaI3.setBounds(220, 370, 50, 30);
        jLayeredPane1.add(txtFechaI3, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFechaT3.setBounds(220, 410, 50, 30);
        jLayeredPane1.add(txtFechaT3, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFechaT2.setBounds(170, 410, 40, 30);
        jLayeredPane1.add(txtFechaT2, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFechaT1.setBounds(120, 410, 40, 30);
        jLayeredPane1.add(txtFechaT1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Fecha Fin:");
        jLabel4.setBounds(20, 410, 70, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(30, 480, 90, 50);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(120, 230, 100, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DRAG_LAYER);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Curso", "Curso", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);
        tabla.getColumnModel().getColumn(3).setResizable(false);

        jScrollPane2.setBounds(340, 150, 390, 240);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(140, 480, 90, 50);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(250, 480, 90, 50);
        jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton5.setText("Ver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.setBounds(240, 313, 70, 30);
        jLayeredPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarCursosDocente.png"))); // NOI18N
        jLabel5.setBounds(110, 30, 560, 80);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/53.jpg"))); // NOI18N
        jLabel6.setBounds(0, 0, 760, 560);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
if(txtCodigo.getText().length()>5){
              txtCodigo.setText(txtCodigo.getText().substring(0, 5));
        }
}//GEN-LAST:event_txtCodigoKeyReleased

private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
    char caracter = evt.getKeyChar();
          if(((caracter < '0') ||(caracter > '9'))&&((caracter < 'a') ||(caracter > 'z'))&&((caracter < 'A') ||(caracter > 'Z'))){
              evt.consume();
          }
}//GEN-LAST:event_txtCodigoKeyTyped

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

private void txtFechaI1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI1KeyTyped
bloqueoLetras(evt);
}//GEN-LAST:event_txtFechaI1KeyTyped

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

private void txtFechaI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI2KeyTyped
bloqueoLetras(evt);
}//GEN-LAST:event_txtFechaI2KeyTyped

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

private void txtFechaI3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI3KeyReleased
if(txtFechaI3.getText().length()>3){
              txtFechaI3.setText(txtFechaI3.getText().substring(0, 4));
        }
}//GEN-LAST:event_txtFechaI3KeyReleased

private void txtFechaI3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaI3KeyTyped
bloqueoLetras(evt);
}//GEN-LAST:event_txtFechaI3KeyTyped

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

private void txtFechaT3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT3KeyReleased
if(txtFechaT3.getText().length()>3){
              txtFechaT3.setText(txtFechaT3.getText().substring(0, 4));
        }
}//GEN-LAST:event_txtFechaT3KeyReleased

private void txtFechaT3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT3KeyTyped
bloqueoLetras(evt);
}//GEN-LAST:event_txtFechaT3KeyTyped

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

private void txtFechaT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT2KeyTyped
bloqueoLetras(evt);
}//GEN-LAST:event_txtFechaT2KeyTyped

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

private void txtFechaT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaT1KeyTyped
bloqueoLetras(evt);
}//GEN-LAST:event_txtFechaT1KeyTyped

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    this.dispose();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    switch(cbxServicio.getSelectedIndex()){
            case 0:JOptionPane.showMessageDialog(this,"Seleccione Academia o Asesoria","ERROR",JOptionPane.ERROR_MESSAGE);break;
            case 1:Seleccionar_Ciclo x = new Seleccionar_Ciclo();        
                    x.setVisible(true);break;
            case 2:Seleccionar_Asesoria y = new Seleccionar_Asesoria();        
                    y.setVisible(true);break;
        } 
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if(verificar()){
        modificar();
    }
    else{
        JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton2ActionPerformed

private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    
}//GEN-LAST:event_formWindowLostFocus

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if(recorrer(txtServicio.getText())&&recorrer(txtCodigo.getText())&&recorrer(txtCurso.getText())){
        eliminar();
    }
    else{
        JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton4ActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        if(tabla.getSelectedRow()!=-1){
            txtCurso.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0)));
        }
    }//GEN-LAST:event_tablaMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(verificar2()){
            mostrarDatos();
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(cbxServicio.getSelectedIndex()==1){
       try {
            String linea;
            FileReader f = new FileReader("ActualizarServicio.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                String boleano=t.nextToken();
                if(Boolean.valueOf(boleano)){
                    txtServicio.setText(t.nextToken());
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
      if(cbxServicio.getSelectedIndex()==2){
       try {
            String linea;
            FileReader f = new FileReader("ActualizarAsesoria.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                String boleano=t.nextToken();
                if(Boolean.valueOf(boleano)){
                    txtServicio.setText(t.nextToken());
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
    }//GEN-LAST:event_formWindowGainedFocus
public void mostrarDatos(){
     DefaultTableModel Curso = new DefaultTableModel();
        try {
            Curso.addColumn("Codigo Curso");
            Curso.addColumn("Curso");
            Curso.addColumn("Fecha Inicio");
            Curso.addColumn("Fecha Fin");
            String codigo=txtCodigo.getText();
            String servicio=txtServicio.getText();
            CallableStatement cst = con.prepareCall("{call usp_ListarProfesorCursosServ(?,?)}");
            cst.setString(1, codigo);
            cst.setString(2, servicio);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
            Curso.addRow(dato);
            }
            this.tabla.setModel(Curso);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public boolean verificar2(){
    boolean v=true;
    v=v&recorrer(txtCodigo.getText());
    v=v&recorrer(txtServicio.getText());
    return v;
}
public void eliminar(){
    try{
            String codigo = txtCodigo.getText();
            String servicio=txtServicio.getText();
            String curso = txtCurso.getText();
            CallableStatement cst = con.prepareCall("{call usp_EliminarProfesorCursoDictando(?,?,?)}");
            cst.setString(1,servicio);
            cst.setString(2,curso);
            cst.setString(3,codigo);
            int rpta = cst.executeUpdate();
            if(rpta>=1){
               JOptionPane.showMessageDialog(this,"Se ha eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
         } catch (Exception ex) {
             ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,"ERROR Al ELIMINAR","ERROR",JOptionPane.ERROR_MESSAGE);
         }
}
public void modificar(){
    try{
            String codigo = txtCodigo.getText();
            String servicio=txtServicio.getText();
            String curso = txtCurso.getText();
            String fechaI = txtFechaI3.getText()+"-"+txtFechaI2.getText()+"-"+txtFechaI1.getText();
            String fechaT = txtFechaT3.getText()+"-"+txtFechaT2.getText()+"-"+txtFechaT1.getText();
            CallableStatement cst = con.prepareCall("{call usp_ActualizarProfesorCursoDictando(?,?,?,?,?)}");
            cst.setString(1,servicio);
            cst.setString(2,curso);
            cst.setString(3,codigo);
            cst.setString(4,fechaI);
            cst.setString(5,fechaT);
            int rpta = cst.executeUpdate();
            if(rpta>=1){
               JOptionPane.showMessageDialog(this,"Se ha modificado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
         } catch (Exception ex) {
             ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,"ERROR Al MODIFICAR","ERROR",JOptionPane.ERROR_MESSAGE);
         }
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
public boolean verificar(){
    boolean v=true;
    v=v&recorrer(txtCodigo.getText());
    v=v&recorrer(txtServicio.getText());
    v=v&recorrer(txtFechaI1.getText());
    v=v&recorrer(txtFechaI2.getText());
    v=v&recorrer(txtFechaI3.getText());
    v=v&recorrer(txtFechaT1.getText());
    v=v&recorrer(txtFechaT2.getText());
    v=v&recorrer(txtFechaT3.getText());
    return v;
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
            java.util.logging.Logger.getLogger(Modificar_Profesor_Dictando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Profesor_Dictando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Profesor_Dictando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Profesor_Dictando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Profesor_Dictando().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtFechaI1;
    private javax.swing.JTextField txtFechaI2;
    private javax.swing.JTextField txtFechaI3;
    private javax.swing.JTextField txtFechaT1;
    private javax.swing.JTextField txtFechaT2;
    private javax.swing.JTextField txtFechaT3;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
