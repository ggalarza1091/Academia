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
public class Modificar_Asesorias extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Modificar_Asesorias() {
        initComponents();
        this.setTitle("Modificar Asesorias");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
            limpiarArchivo();
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
        btnSeleccionar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        cbxNivel = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoraE = new javax.swing.JTextField();
        txtHoraS = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cbxHoraE = new javax.swing.JComboBox();
        cbxHoraS = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarAsesorias.png"))); // NOI18N
        jLabel1.setBounds(20, 20, 500, 50);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        btnSeleccionar.setBounds(360, 90, 110, 30);
        jLayeredPane1.add(btnSeleccionar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.setEditable(false);
        txtCodigo.setBounds(210, 90, 130, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        txtCosto.setBounds(210, 130, 130, 30);
        jLayeredPane1.add(txtCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Primaria", "Secundaria", "Pre-Universitaria", "Universitaria" }));
        cbxNivel.setBounds(210, 210, 130, 30);
        jLayeredPane1.add(cbxNivel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Costo:");
        jLabel3.setBounds(150, 130, 60, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Codigo:");
        jLabel2.setBounds(150, 90, 60, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText(" Nivel Academico:");
        jLabel4.setBounds(100, 210, 110, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText(" Hora Entrada:");
        jLabel5.setBounds(110, 250, 90, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText(" Hora Salida:");
        jLabel6.setBounds(120, 300, 70, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraEKeyTyped(evt);
            }
        });
        txtHoraE.setBounds(210, 250, 60, 30);
        jLayeredPane1.add(txtHoraE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraSKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraSKeyTyped(evt);
            }
        });
        txtHoraS.setBounds(210, 300, 60, 30);
        jLayeredPane1.add(txtHoraS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.setBounds(80, 350, 90, 50);
        jLayeredPane1.add(btnModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(380, 350, 90, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxHoraE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxHoraE.setBounds(280, 250, 60, 30);
        jLayeredPane1.add(cbxHoraE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxHoraS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxHoraS.setBounds(280, 300, 60, 30);
        jLayeredPane1.add(cbxHoraS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(230, 350, 90, 50);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondo1.jpg"))); // NOI18N
        jLabel7.setBounds(0, 0, 550, 420);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtMatricula.setBounds(210, 170, 130, 30);
        jLayeredPane1.add(txtMatricula, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Matricula:");
        jLabel8.setBounds(140, 170, 70, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Seleccionar_Asesoria x = new Seleccionar_Asesoria();
        x.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
                String linea;
                FileReader f = new FileReader("ActualizarAsesoria.txt");
                BufferedReader b = new BufferedReader(f);
                while((linea=b.readLine())!=null){
                    StringTokenizer t = new StringTokenizer(linea,",");
                    String boleano=t.nextToken();
                    if(Boolean.valueOf(boleano)){
                        txtCodigo.setText(t.nextToken());
                        txtCosto.setText(t.nextToken());
                        txtMatricula.setText(t.nextToken());
                        String nivel=t.nextToken();
                        if(nivel.equalsIgnoreCase("primaria")){
                            cbxNivel.setSelectedIndex(1);
                        }
                        if(nivel.equalsIgnoreCase("secundaria")){
                            cbxNivel.setSelectedIndex(2);
                        }
                        if(nivel.equalsIgnoreCase("pre-universitario")){
                            cbxNivel.setSelectedIndex(3);
                        }
                        if(nivel.equalsIgnoreCase("universitario")){
                            cbxNivel.setSelectedIndex(4);
                        }
                        
                        
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(verificar()){
            modificarAsesoria(true);
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        limpiarArchivo();
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(verificar()){
            modificarAsesoria(false);
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
     public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
    }
    public void modificarAsesoria(boolean estado){
        try{
            String nivelAcademico= String.valueOf(String.valueOf(cbxNivel.getSelectedItem()).charAt(0));
            if(cbxNivel.getSelectedIndex()==3){
                nivelAcademico="A";
            }
            String horaE=establecerHora(txtHoraE.getText().substring(0, 2),txtHoraE.getText().substring(3,5),cbxHoraE.getSelectedIndex());
            String horaS=establecerHora(txtHoraS.getText().substring(0, 2),txtHoraS.getText().substring(3,5),cbxHoraS.getSelectedIndex());
            CallableStatement cst = con.prepareCall("{call usp_ActualizarServicioAsesoria(?,?,?,?,?,?,?)}");
            cst.setString(1,txtCodigo.getText());
            cst.setBoolean(2,estado);
            cst.setDouble(3,Double.parseDouble(txtCosto.getText()));
            cst.setDouble(4,Double.parseDouble(txtMatricula.getText()));
            cst.setString(5,nivelAcademico);
            cst.setString(6,horaE);
            cst.setString(7,horaS);
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
    public void limpiarArchivo(){
        try {
            FileWriter f = new FileWriter("ActualizarAsesoria.txt");
            PrintWriter p = new PrintWriter(f);
            p.close();
        } catch (IOException ex) {
            Logger.getLogger(Modificar_Asesorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        v=v&recorrer(txtCosto.getText());
        if(cbxNivel.getSelectedIndex()==0){
            v=false;
        }
        v=v&recorrer(txtHoraE.getText());
        v=v&recorrer(txtHoraS.getText());
        if(txtHoraE.getText().length()!=5){
            v=false;
        }
        if(txtHoraS.getText().length()!=5){
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
            java.util.logging.Logger.getLogger(Modificar_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asesorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Asesorias().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cbxHoraE;
    private javax.swing.JComboBox cbxHoraS;
    private javax.swing.JComboBox cbxNivel;
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
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtHoraE;
    private javax.swing.JTextField txtHoraS;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}
