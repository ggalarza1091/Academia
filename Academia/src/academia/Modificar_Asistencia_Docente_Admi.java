package academia;
import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class Modificar_Asistencia_Docente_Admi extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Modificar_Asistencia_Docente_Admi() {
        initComponents();
        this.setTitle("Modificar Asistencia de Docente y Administrativo");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        cbxServicio.setVisible(false);
        lblServicio.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox();
        cbxServicio = new javax.swing.JComboBox();
        lblServicio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoraE = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHoraS = new javax.swing.JTextField();
        cbxHoraE = new javax.swing.JComboBox();
        cbxHoraS = new javax.swing.JComboBox();
        txtFecha1 = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(140, 150, 78, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo:");
        jLabel1.setBounds(60, 150, 62, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.setBounds(160, 330, 90, 40);
        jLayeredPane1.add(btnModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(420, 330, 90, 40);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarSistenciaDocente.png"))); // NOI18N
        jLabel5.setBounds(100, 10, 490, 50);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Docente", "Administrativo" }));
        cbxArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAreaItemStateChanged(evt);
            }
        });
        cbxArea.setBounds(140, 210, 120, 30);
        jLayeredPane1.add(cbxArea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria" }));
        cbxServicio.setBounds(140, 260, 120, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblServicio.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblServicio.setText("Servicio:");
        lblServicio.setBounds(80, 260, 50, 30);
        jLayeredPane1.add(lblServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Area:");
        jLabel3.setBounds(90, 210, 50, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Hora Entrada:");
        jLabel4.setBounds(330, 210, 77, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraEKeyTyped(evt);
            }
        });
        txtHoraE.setBounds(410, 210, 70, 30);
        jLayeredPane1.add(txtHoraE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Hora Salida:");
        jLabel6.setBounds(330, 260, 70, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraSKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraSKeyTyped(evt);
            }
        });
        txtHoraS.setBounds(410, 260, 70, 30);
        jLayeredPane1.add(txtHoraS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxHoraE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxHoraE.setBounds(500, 210, 60, 30);
        jLayeredPane1.add(cbxHoraE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxHoraS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxHoraS.setBounds(500, 260, 60, 30);
        jLayeredPane1.add(cbxHoraS, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        txtFecha1.setBounds(410, 150, 40, 30);
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
        txtFecha2.setBounds(460, 150, 40, 30);
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
        txtFecha3.setBounds(510, 150, 50, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Fecha:");
        jLabel7.setBounds(360, 150, 50, 30);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/23.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 680, 440);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtFecha1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha1KeyTyped

    private void txtFecha2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha2KeyTyped

    private void txtFecha3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha3KeyTyped

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

    private void txtHoraEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraEKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtHoraEKeyTyped

    private void txtHoraEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraEKeyReleased
        if(txtHoraE.getText().length()>5){
              txtHoraE.setText(txtHoraE.getText().substring(0, 5));
        }
        if(txtHoraE.getText().length()>=2){
            if(txtHoraE.getText().length()==2){
                if(Integer.parseInt(txtHoraE.getText())<1||Integer.parseInt(txtHoraE.getText())>12){
                    txtHoraE.setText("12"+":");}
                else
                    txtHoraE.setText(txtHoraE.getText()+":");
            }
            else{
               txtHoraE.setText(txtHoraE.getText().substring(0,2)+":"+txtHoraE.getText().substring(3,txtHoraE.getText().length()));
            }
        }
        if(txtHoraE.getText().length()>3){
            if(Integer.parseInt(txtHoraE.getText().substring(3,txtHoraE.getText().length()))>60||Integer.parseInt(txtHoraE.getText().substring(3,txtHoraE.getText().length()))<0){
                txtHoraE.setText(txtHoraE.getText().substring(0,2)+":"+"59");
            }
        }
    }//GEN-LAST:event_txtHoraEKeyReleased

    private void txtHoraSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraSKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtHoraSKeyTyped

    private void txtHoraSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraSKeyReleased
        if(txtHoraS.getText().length()>5){
              txtHoraS.setText(txtHoraS.getText().substring(0, 5));
        }
        if(txtHoraS.getText().length()>=2){
            if(txtHoraS.getText().length()==2){
                if(Integer.parseInt(txtHoraS.getText())<1||Integer.parseInt(txtHoraS.getText())>12){
                    txtHoraS.setText("12"+":");}
                else
                    txtHoraS.setText(txtHoraS.getText()+":");
            }
            else{
               txtHoraS.setText(txtHoraS.getText().substring(0,2)+":"+txtHoraS.getText().substring(3,txtHoraS.getText().length()));
            }
        }
        if(txtHoraS.getText().length()>3){
            if(Integer.parseInt(txtHoraS.getText().substring(3,txtHoraS.getText().length()))>60||Integer.parseInt(txtHoraS.getText().substring(3,txtHoraS.getText().length()))<0){
                txtHoraS.setText(txtHoraS.getText().substring(0,2)+":"+"59");
            }
        }
    }//GEN-LAST:event_txtHoraSKeyReleased

    private void cbxAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAreaItemStateChanged
        switch(cbxArea.getSelectedIndex()){
            case 0:cbxServicio.setVisible(false);lblServicio.setVisible(false);break;
            case 1:cbxServicio.setVisible(true);lblServicio.setVisible(true);break;
            case 2:cbxServicio.setVisible(false);lblServicio.setVisible(false);break;
        }
    }//GEN-LAST:event_cbxAreaItemStateChanged

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char caracter = evt.getKeyChar();
          if(((caracter < '0') ||(caracter > '9'))&&((caracter < 'a') ||(caracter > 'z'))&&((caracter < 'A') ||(caracter > 'Z'))){
              evt.consume();
          }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        if(txtCodigo.getText().length()>5){
             txtCodigo.setText(txtCodigo.getText().substring(0, 5));
        }
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(verificar()){
            if(cbxArea.getSelectedIndex()==2){
                modificar("F");
            }
            else{
                if(cbxServicio.getSelectedIndex()==1){
                    modificar("A");
                }
                else{
                    if(cbxServicio.getSelectedIndex()==2){
                        modificar("S");
                    }
                }
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Ingrese los datos correctamente","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    public void modificar(String tipo){
         try{
            String codigo = txtCodigo.getText();
            String fecha = txtFecha3.getText()+"-"+txtFecha2.getText()+"-"+txtFecha1.getText();
            String horaE=establecerHora(txtHoraE.getText().substring(0, 2),txtHoraE.getText().substring(3,5),cbxHoraE.getSelectedIndex());
            String horaS=establecerHora(txtHoraS.getText().substring(0, 2),txtHoraS.getText().substring(3,5),cbxHoraS.getSelectedIndex());
            CallableStatement cst = con.prepareCall("{call usp_ActualizarAsistenciaColaborador(?,?,?,?,?)}");
            cst.setString(1,fecha);
            cst.setString(2,codigo);
            cst.setString(3,tipo);
            cst.setString(4,horaE);
            cst.setString(5,horaS);
            int rpta = cst.executeUpdate();
            if(rpta==1){
               JOptionPane.showMessageDialog(this,"Se ha guardado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
         } catch (Exception ex) {
             ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,"ERROR AL GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);}
    }
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        v=v&recorrer(txtFecha1.getText());
        v=v&recorrer(txtFecha2.getText());
        v=v&recorrer(txtFecha3.getText());
        v=v&recorrer(txtHoraE.getText());
        v=v&recorrer(txtHoraS.getText());
        if(cbxArea.getSelectedIndex()==1){
            if(cbxServicio.getSelectedIndex()==0){
                v=false;
            }
        }
        if(cbxArea.getSelectedIndex()==0){
            v=false;
        }
        return v;
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
            java.util.logging.Logger.getLogger(Modificar_Asistencia_Docente_Admi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asistencia_Docente_Admi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asistencia_Docente_Admi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asistencia_Docente_Admi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Asistencia_Docente_Admi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxArea;
    private javax.swing.JComboBox cbxHoraE;
    private javax.swing.JComboBox cbxHoraS;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    private javax.swing.JTextField txtHoraE;
    private javax.swing.JTextField txtHoraS;
    // End of variables declaration//GEN-END:variables
}
