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
public class Modificar_Descuentos extends javax.swing.JFrame {
Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    /** Creates new form Modificar_Descuentos */
    public Modificar_Descuentos() {
        initComponents();
        this.setTitle("Modificar Descuentos");
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtFecha3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtFechaL1 = new javax.swing.JTextField();
        txtFechaL2 = new javax.swing.JTextField();
        txtFechaL3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Fecha:");
        jLabel5.setBounds(70, 350, 40, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Monto:");
        jLabel4.setBounds(70, 310, 40, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtMonto.setBounds(120, 310, 70, 30);
        jLayeredPane1.add(txtMonto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        jScrollPane1.setViewportView(txtMotivo);

        jScrollPane1.setBounds(120, 410, 166, 96);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Motivo:");
        jLabel3.setBounds(60, 400, 40, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Codigo de Dscto:");
        jLabel2.setBounds(30, 270, 90, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha1.setBounds(120, 350, 30, 30);
        jLayeredPane1.add(txtFecha1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtCodigo.setBounds(120, 140, 70, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha2.setBounds(160, 350, 30, 30);
        jLayeredPane1.add(txtFecha2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDescuento.setEditable(false);
        txtDescuento.setBounds(120, 270, 70, 30);
        jLayeredPane1.add(txtDescuento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha3.setBounds(200, 350, 40, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo Docente:");
        jLabel1.setBounds(30, 140, 90, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha Dscto", "Codigo Dscto.", "Monto", "Motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false
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

        jScrollPane2.setBounds(370, 140, 320, 310);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFechaL1.setBounds(120, 190, 30, 30);
        jLayeredPane1.add(txtFechaL1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaL2ActionPerformed(evt);
            }
        });
        txtFechaL2.setBounds(160, 190, 30, 30);
        jLayeredPane1.add(txtFechaL2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFechaL3.setBounds(200, 190, 40, 30);
        jLayeredPane1.add(txtFechaL3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Fecha Limite:");
        jLabel6.setBounds(40, 190, 70, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(260, 190, 65, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(370, 480, 100, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(490, 480, 90, 40);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Modificar_Descuento.png"))); // NOI18N
        jLabel7.setBounds(154, 24, 450, 70);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/58.jpg"))); // NOI18N
        jLabel8.setBounds(0, 0, 760, 570);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaL2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL2ActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        if(tabla.getSelectedRow()!=-1){
           txtFecha1.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0)).substring(0,2)); 
           txtFecha2.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0)).substring(3,5)); 
           txtFecha3.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0)).substring(6,10)); 
           txtDescuento.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),1))); 
           txtMonto.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),2))); 
           txtMotivo.setText(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),3))); 
        }
    }//GEN-LAST:event_tablaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(verificar()){
            mostrarDatos();
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(verificar2()){
            modificar();
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void modificar(){
        try{
            String codigo=txtCodigo.getText();
            String descuento=txtDescuento.getText();
            double monto = Double.parseDouble(txtMonto.getText());
            String motivo = txtMotivo.getText();
            String fecha = txtFecha3.getText()+"-"+txtFecha2.getText()+"-"+txtFecha1.getText();
            CallableStatement cst = con.prepareCall("{call usp_ActualizarDescuentoColaborador(?,?,?,?,?)}");
            cst.setString(1,descuento);
            cst.setString(2,codigo);
            cst.setString(3,motivo);
            cst.setDouble(4,monto);
            cst.setString(5,fecha);
            int rpta = cst.executeUpdate();
            if(rpta==1){
                JOptionPane.showMessageDialog(this,"Se ha guardado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this,"ERROR AL ELIMINAR","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        v=v&recorrer(txtFechaL1.getText());
        v=v&recorrer(txtFechaL2.getText());
        v=v&recorrer(txtFechaL3.getText());
        return v;
    }
    public boolean verificar2(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        v=v&recorrer(txtFecha1.getText());
        v=v&recorrer(txtFecha2.getText());
        v=v&recorrer(txtFecha3.getText());
        v=v&recorrer(txtMonto.getText());
        v=v&recorrer(txtDescuento.getText());
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
    public void mostrarDatos(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Fecha Dscto");
            Salones.addColumn("Codigo Dscto");
            Salones.addColumn("Monto");
            Salones.addColumn("Motivo");
            String codigo=txtCodigo.getText();
            String fechalimite=txtFechaL3.getText()+"-"+txtFechaL2.getText()+"-"+txtFechaL1.getText();
            CallableStatement cst = con.prepareCall("{call usp_RPListaDescuentoRealizadosColaborador(?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,fechalimite);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tabla.setModel(Salones);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Modificar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Descuentos().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    private javax.swing.JTextField txtFechaL1;
    private javax.swing.JTextField txtFechaL2;
    private javax.swing.JTextField txtFechaL3;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}
