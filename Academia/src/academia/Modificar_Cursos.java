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
public class Modificar_Cursos extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Modificar_Cursos() {
        initComponents();
        this.setTitle("Modificar Cursos");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
            mostrarDatos();
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
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo:");
        jLabel1.setBounds(30, 90, 70, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.setEditable(false);
        txtCodigo.setBounds(100, 90, 90, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Costo:");
        jLabel3.setBounds(30, 210, 70, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Curso:");
        jLabel2.setBounds(30, 150, 70, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCursoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCursoKeyTyped(evt);
            }
        });
        txtCurso.setBounds(100, 150, 90, 30);
        jLayeredPane1.add(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        txtCosto.setBounds(100, 210, 90, 30);
        jLayeredPane1.add(txtCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCursos.getTableHeader().setReorderingAllowed(false);
        tblCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCursosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCursos);
        tblCursos.getColumnModel().getColumn(0).setResizable(false);
        tblCursos.getColumnModel().getColumn(1).setResizable(false);
        tblCursos.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane1.setBounds(260, 100, 340, 250);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(30, 300, 90, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(140, 300, 90, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Salir");
        jButton3.setBounds(140, 370, 90, 40);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarCursos.png"))); // NOI18N
        jLabel4.setBounds(110, 10, 420, 50);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/26.jpg"))); // NOI18N
        jLabel5.setBounds(0, 0, 630, 450);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCursosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursosMousePressed
        if(tblCursos.getSelectedRow()!=-1){
            txtCodigo.setText(String.valueOf(tblCursos.getValueAt(tblCursos.getSelectedRow(),0)));
            txtCurso.setText(String.valueOf(tblCursos.getValueAt(tblCursos.getSelectedRow(),1)));
            txtCosto.setText(String.valueOf(tblCursos.getValueAt(tblCursos.getSelectedRow(),2)));
        }
    }//GEN-LAST:event_tblCursosMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(recorrer(txtCodigo.getText())){
            modificarCursos();
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(recorrer(txtCodigo.getText())){
            eliminarCurso();
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCursoKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtCursoKeyTyped

    private void txtCursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCursoKeyReleased
        if(txtCurso.getText().length()>40){
             txtCurso.setText(txtCurso.getText().substring(0, 40));
        }
    }//GEN-LAST:event_txtCursoKeyReleased

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
    public void modificarCursos(){
        try{
            String curso= borrarespacios(txtCurso.getText());
            String codigo=borrarespacios(txtCodigo.getText());
            CallableStatement cst = con.prepareCall("{call usp_ActualizarCurso(?,?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,curso);
            cst.setDouble(3,Double.parseDouble(txtCosto.getText()));
            int rpta = cst.executeUpdate();
            if(rpta==1){
                JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();   
            mostrarDatos();
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, "Error al modificar un Curso","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void eliminarCurso(){
        try{
            String codigo=borrarespacios(txtCodigo.getText());
            CallableStatement cst = con.prepareCall("{call usp_EliminarCurso(?)}");
            cst.setString(1,codigo);
            int rpta = cst.executeUpdate();
            if(rpta>=1){
                JOptionPane.showMessageDialog(this,"Se ha eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();   
            mostrarDatos();
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, "El curso esta en uso, no se puede eliminar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void mostrarDatos(){
        DefaultTableModel Curso = new DefaultTableModel();
        try {
            Curso.addColumn("Codigo");
            Curso.addColumn("Curso");
            Curso.addColumn("Costo Hora");
            CallableStatement cst = con.prepareCall("{call usp_ListarCurso}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
                    dato[i]=r.getString(i+1);
                }
            Curso.addRow(dato);
            }
            this.tblCursos.setModel(Curso);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Modificar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Cursos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtCurso;
    // End of variables declaration//GEN-END:variables
}
