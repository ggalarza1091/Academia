package academia;
import java.sql.*;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Intro extends javax.swing.JFrame {
    boolean inicio;
    private int xM;
    private int yM;
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Intro() {
        initComponents(); 
        this.setTitle("Academia Club de Matematicas Jaque Mate");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        inicio=true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jLayeredPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLayeredPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        jLabel2.setBounds(60, 238, 150, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        jLabel1.setBounds(60, 198, 130, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ficha-boton-cerrar.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(360, 10, 20, 20);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(280, 200, 90, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        txtUsuario.setBounds(130, 200, 130, 30);
        jLayeredPane1.add(txtUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtContrasena.setText("jPasswod1");
        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusGained(evt);
            }
        });
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyReleased(evt);
            }
        });
        txtContrasena.setBounds(130, 240, 130, 30);
        jLayeredPane1.add(txtContrasena, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/intro.jpg"))); // NOI18N
        Fondo.setBounds(0, 0, 390, 290);
        jLayeredPane1.add(Fondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(verificar()){
            contrasena(con);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
       if(evt.getKeyCode()==evt.VK_ENTER){
            if(verificar()){
                contrasena(con);
            }
       }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            if(verificar()){
                contrasena(con);
            }
        }
    }//GEN-LAST:event_txtContrasenaKeyPressed

    private void txtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusGained
        if(inicio){
            txtContrasena.setText("");
            inicio=false;
        }
    }//GEN-LAST:event_txtContrasenaFocusGained

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getX()+(evt.getX()-getxM()),this.getY()+(evt.getY()-getyM()));
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        setxM(evt.getX());
        setyM(evt.getY());
    }//GEN-LAST:event_formMousePressed

private void jLayeredPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLayeredPane1AncestorAdded
    txtUsuario.requestFocus(true);
}//GEN-LAST:event_jLayeredPane1AncestorAdded

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        if(txtUsuario.getText().length()>15){
             txtUsuario.setText(txtUsuario.getText().substring(0, 15));
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtContrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyReleased
        if(String.valueOf(txtContrasena.getPassword()).length()>15){
             txtContrasena.setText(String.valueOf(txtContrasena.getPassword()).substring(0, 15));
             System.out.println(String.valueOf(txtContrasena.getPassword()).substring(0, 15));
        }
    }//GEN-LAST:event_txtContrasenaKeyReleased
    public void contrasena(Connection con){
        char c;
        try{
            String usuario = String.valueOf(txtUsuario.getText());
            String contrasena =String.valueOf(txtContrasena.getPassword());
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
                    JOptionPane.showMessageDialog(this,"Bienvenido"+"\n"+"El programa abrira cuando de clic en Aceptar"+"\n"+"Espere unos segundos mientras carga...","Informacion",JOptionPane.INFORMATION_MESSAGE);
                    Academia x = new Academia();
                    x.setVisible(true);
                    this.dispose();
                }
                if(c=='b'){
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña erroneos","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
         } 
         catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
         }
    }
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtUsuario.getText());
        v=v&recorrer(String.valueOf(txtContrasena.getPassword()));
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
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Intro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Intro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public int getxM() {
        return xM;
    }

    public void setxM(int xM) {
        this.xM = xM;
    }

    public int getyM() {
        return yM;
    }

    public void setyM(int yM) {
        this.yM = yM;
    }
}
