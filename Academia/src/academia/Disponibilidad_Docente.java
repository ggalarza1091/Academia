package academia;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Disponibilidad_Docente extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Disponibilidad_Docente() {
        initComponents();
        this.setTitle("Disponibilidad de Docente");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        cbxDias = new javax.swing.JComboBox();
        txtHoraE = new javax.swing.JTextField();
        txtHoraS = new javax.swing.JTextField();
        cbxHoraE = new javax.swing.JComboBox();
        cbxHoraS = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        cbxDias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        cbxDias.setBounds(130, 230, 130, 31);
        jLayeredPane1.add(cbxDias, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraEKeyTyped(evt);
            }
        });
        txtHoraE.setBounds(410, 170, 50, 30);
        jLayeredPane1.add(txtHoraE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraSKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraSKeyTyped(evt);
            }
        });
        txtHoraS.setBounds(410, 230, 50, 30);
        jLayeredPane1.add(txtHoraS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxHoraE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxHoraE.setBounds(480, 170, 60, 30);
        jLayeredPane1.add(cbxHoraE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxHoraS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxHoraS.setBounds(480, 230, 60, 30);
        jLayeredPane1.add(cbxHoraS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Dia:");
        jLabel1.setBounds(90, 230, 50, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Hora Entrada:");
        jLabel2.setBounds(320, 170, 90, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Hora Salida:");
        jLabel3.setBounds(330, 230, 80, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Codigo Docente:");
        jLabel4.setBounds(40, 170, 130, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(160, 170, 100, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(150, 310, 120, 50);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(310, 310, 100, 50);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/disponibilidadDocente.png"))); // NOI18N
        jLabel5.setBounds(80, 20, 450, 60);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/47.jpg"))); // NOI18N
        jLabel6.setBounds(0, 0, 590, 410);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoraEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraEKeyReleased

        if (txtHoraE.getText().length() > 5) {             txtHoraE.setText(txtHoraE.getText().substring(0, 5));         }         if (txtHoraE.getText().length() >= 2) {             if (txtHoraE.getText().length() == 2) {                 if (Integer.parseInt(txtHoraE.getText()) < 1 || Integer.parseInt(txtHoraE.getText()) > 12) {                     txtHoraE.setText("12" + ":");                 } else {                     txtHoraE.setText(txtHoraE.getText() + ":");                 }             } else {                 txtHoraE.setText(txtHoraE.getText().substring(0, 2) + ":" + txtHoraE.getText().substring(3, txtHoraE.getText().length()));             }         }         if (txtHoraE.getText().length() > 3) {             if (Integer.parseInt(txtHoraE.getText().substring(3, txtHoraE.getText().length())) > 60 || Integer.parseInt(txtHoraE.getText().substring(3, txtHoraE.getText().length())) < 0) {                 txtHoraE.setText(txtHoraE.getText().substring(0, 2) + ":" + "59");             }         }     }//GEN-LAST:event_txtHoraEKeyReleased

    private void txtHoraEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraEKeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtHoraEKeyTyped

    private void txtHoraSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraSKeyReleased

        if (txtHoraS.getText().length() > 5) {             txtHoraS.setText(txtHoraS.getText().substring(0, 5));         }         if (txtHoraS.getText().length() >= 2) {             if (txtHoraS.getText().length() == 2) {                 if (Integer.parseInt(txtHoraS.getText()) < 1 || Integer.parseInt(txtHoraS.getText()) > 12) {                     txtHoraS.setText("12" + ":");                 } else {                     txtHoraS.setText(txtHoraS.getText() + ":");                 }             } else {                 txtHoraS.setText(txtHoraS.getText().substring(0, 2) + ":" + txtHoraS.getText().substring(3, txtHoraS.getText().length()));             }         }         if (txtHoraS.getText().length() > 3) {             if (Integer.parseInt(txtHoraS.getText().substring(3, txtHoraS.getText().length())) > 60 || Integer.parseInt(txtHoraS.getText().substring(3, txtHoraS.getText().length())) < 0) {                 txtHoraS.setText(txtHoraS.getText().substring(0, 2) + ":" + "59");             }         }     }//GEN-LAST:event_txtHoraSKeyReleased

    private void txtHoraSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraSKeyTyped

        bloqueoLetras(evt);     }//GEN-LAST:event_txtHoraSKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(verificar()){
            registrarDisponibilidad();
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
    }
     public boolean verificar(){
        boolean verificacion=true;
        if(cbxDias.getSelectedIndex()==0){
            verificacion=false;
        }
        verificacion=verificacion&&recorrer(txtHoraE.getText());
        verificacion=verificacion&&recorrer(txtHoraS.getText());
        if(txtHoraE.getText().length()!=5||txtHoraS.getText().length()!=5){
            verificacion=false;
        }
        return verificacion;
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
     public void registrarDisponibilidad(){
        try {
            String codigo=txtCodigo.getText();
            String dia=diasemana(String.valueOf(cbxDias.getSelectedItem()));
            CallableStatement cst = con.prepareCall("{call usp_InsertarDisponibilidadColaborador(?,?,?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,dia);
            cst.setString(3,establecerHora(txtHoraE.getText().substring(0, 2),txtHoraE.getText().substring(3,5),cbxHoraE.getSelectedIndex()));
            cst.setString(4,establecerHora(txtHoraS.getText().substring(0, 2),txtHoraS.getText().substring(3,5),cbxHoraS.getSelectedIndex()));
            int rpta = cst.executeUpdate();
            if(rpta>=1){
                JOptionPane.showMessageDialog(this,"Disponibilidad registrada satisfactoriamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            if(rpta==0){
                JOptionPane.showMessageDialog(this,"Esa Disponibilidad ya ha sido Registrada","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(Disponibilidad_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Disponibilidad_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Disponibilidad_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Disponibilidad_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Disponibilidad_Docente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxDias;
    private javax.swing.JComboBox cbxHoraE;
    private javax.swing.JComboBox cbxHoraS;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtHoraE;
    private javax.swing.JTextField txtHoraS;
    // End of variables declaration//GEN-END:variables
}
