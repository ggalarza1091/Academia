package academia;
import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Insertar_Salones extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int tabla;
    boolean entrada;
    public Insertar_Salones() {
        initComponents();
        this.setTitle("Insertar Salones");
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
        jLabel5 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCapMax = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/InsertarSalones.png"))); // NOI18N
        jLabel5.setBounds(50, 10, 460, 59);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAceptar.setText("Agregar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.setBounds(420, 130, 83, 30);
        jLayeredPane1.add(btnAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(420, 190, 83, 30);
        jLayeredPane1.add(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Piso:");
        jLabel3.setBounds(160, 140, 80, 20);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPisoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisoKeyTyped(evt);
            }
        });
        txtPiso.setBounds(240, 140, 123, 30);
        jLayeredPane1.add(txtPiso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblSalones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Capacidad Max.", "Piso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSalones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSalones);
        tblSalones.getColumnModel().getColumn(0).setResizable(false);
        tblSalones.getColumnModel().getColumn(1).setResizable(false);
        tblSalones.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane1.setBounds(40, 230, 340, 160);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Capacidad Maxima:");
        jLabel2.setBounds(110, 100, 130, 20);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCapMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCapMaxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCapMaxKeyTyped(evt);
            }
        });
        txtCapMax.setBounds(240, 100, 123, 30);
        jLayeredPane1.add(txtCapMax, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/14.jpg"))); // NOI18N
        jLabel1.setBounds(0, 0, 530, 420);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    if(verificar()){
        registrarSalon();
    }
    else{
        JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCapMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapMaxKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtCapMaxKeyTyped

    private void txtPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisoKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtPisoKeyTyped

    private void txtPisoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisoKeyReleased
        if(Integer.parseInt(txtPiso.getText())>20){
             txtPiso.setText("20");
        }
    }//GEN-LAST:event_txtPisoKeyReleased

    private void txtCapMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCapMaxKeyReleased
        if(Integer.parseInt(txtCapMax.getText())>200){
             txtCapMax.setText("200");
        }
    }//GEN-LAST:event_txtCapMaxKeyReleased
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
    } 
    public void registrarSalon(){
        try{
            int capacidad=Integer.parseInt(txtCapMax.getText());
            int piso = Integer.parseInt(txtPiso.getText());
            CallableStatement cst = con.prepareCall("{call usp_InsertarSalon(?,?,?)}");
            cst.setInt(1,capacidad);
            cst.setInt(2, piso);
            cst.registerOutParameter(3, Types.CHAR);
            int rpta = cst.executeUpdate();
            String codigo = cst.getString(3);
            if(rpta==1){
                JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
            mostrarDatos();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Erro al registrar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void mostrarDatos(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
                Salones.addColumn("Codigo");
                Salones.addColumn("Capacidad");
                Salones.addColumn("Piso");
            tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarSalon}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Salones.addRow(dato);
            }
            this.tblSalones.setModel(Salones);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtCapMax.getText());
        v=v&recorrer(txtPiso.getText());
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
            java.util.logging.Logger.getLogger(Insertar_Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_Salones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Insertar_Salones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalones;
    private javax.swing.JTextField txtCapMax;
    private javax.swing.JTextField txtPiso;
    // End of variables declaration//GEN-END:variables
}
