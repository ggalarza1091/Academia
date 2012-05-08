package academia;

import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Insertar_Curso extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int tabla;
    public Insertar_Curso() {
        initComponents();
        this.setTitle("Insertar Curso");
        setLocationRelativeTo(null);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
            mostrarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtCurso.requestFocus(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLayeredPane1MouseClicked(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.setBounds(40, 270, 90, 40);
        jLayeredPane1.add(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(130, 370, 90, 40);
        jLayeredPane1.add(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Curso:");
        jLabel2.setBounds(80, 120, 60, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCursoKeyReleased(evt);
            }
        });
        txtCurso.setBounds(130, 120, 230, 30);
        jLayeredPane1.add(txtCurso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        txtPrecio.setBounds(130, 160, 60, 30);
        jLayeredPane1.add(txtPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso", "Precio Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCurso.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCurso);
        tblCurso.getColumnModel().getColumn(0).setResizable(false);
        tblCurso.getColumnModel().getColumn(1).setResizable(false);
        tblCurso.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane1.setBounds(270, 240, 370, 180);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Precio por Hora:");
        jLabel3.setBounds(30, 160, 110, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/InsertarCurso.png"))); // NOI18N
        jLabel1.setBounds(140, 10, 400, 80);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/5.jpg"))); // NOI18N
        jLabel4.setBounds(0, 0, 660, 460);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

private void jLayeredPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MouseClicked
    tblCurso.clearSelection();
}//GEN-LAST:event_jLayeredPane1MouseClicked

private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    tblCurso.clearSelection();
}//GEN-LAST:event_formMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(verificar()){
            try{
                String curso=txtCurso.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                CallableStatement cst = con.prepareCall("{call usp_InsertarCurso(?,?,?)}");
                cst.setString(1,curso);
                cst.setDouble(2,precio);
                cst.registerOutParameter(3, Types.CHAR);
                int rpta = cst.executeUpdate();
                String codigo= cst.getString(3);
                if(rpta==1){
                    JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
                cst.close();   
                mostrarDatos();
            }
            catch(Exception e){JOptionPane.showMessageDialog(this, "Error al registrar un Curso","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCursoKeyReleased
        if(txtCurso.getText().length()>39){
              txtCurso.setText(txtCurso.getText().substring(0, 40));
        }
    }//GEN-LAST:event_txtCursoKeyReleased

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9')){
            if(caracter<'.'||caracter>'.'){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        int c=0;
        String texto=txtPrecio.getText();
        if(texto.length()!=0){
            for(int i=0;i<texto.length();i++){
                if(texto.charAt(i)=='.'){
                    c++;
                }
            }
            if(c==2){
                txtPrecio.setText(texto.substring(0,texto.length()-1));
            }
            if(c>2){
                for(int j=1;j<c;j++){
                    txtPrecio.setText(texto.substring(0,texto.length()-1));
                    texto=txtPrecio.getText();
                }
            }
            if(texto.charAt(0)=='.'){
                txtPrecio.setText("0"+texto);
            }
        }
    }//GEN-LAST:event_txtPrecioKeyReleased
    public boolean verificar(){
        boolean verificacion=true;
        verificacion=verificacion&recorrer(txtCurso.getText());
        verificacion=verificacion&recorrer(txtPrecio.getText());
        return verificacion;
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
    public void mostrarDatos(){
        DefaultTableModel Curso = new DefaultTableModel();
        try {
                Curso.addColumn("Codigo");
                Curso.addColumn("Curso");
                Curso.addColumn("Precio Hora");
            tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarCurso}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Curso.addRow(dato);
            }
            this.tblCurso.setModel(Curso);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(Insertar_Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Insertar_Curso().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
