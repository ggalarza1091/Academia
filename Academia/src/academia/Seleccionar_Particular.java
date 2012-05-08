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

public class Seleccionar_Particular extends javax.swing.JFrame {

    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Seleccionar_Particular() {
        initComponents();
        this.setTitle("Seleccionar Clase Particular");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParticular = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblParticular.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "Tipo", "Direccion", "Curso", "Fecha", "Costo", "Horas", "Docente", "Pago Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParticular.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblParticular);
        tblParticular.getColumnModel().getColumn(0).setResizable(false);
        tblParticular.getColumnModel().getColumn(2).setResizable(false);
        tblParticular.getColumnModel().getColumn(4).setResizable(false);
        tblParticular.getColumnModel().getColumn(5).setResizable(false);
        tblParticular.getColumnModel().getColumn(6).setResizable(false);
        tblParticular.getColumnModel().getColumn(7).setResizable(false);
        tblParticular.getColumnModel().getColumn(8).setResizable(false);
        tblParticular.getColumnModel().getColumn(9).setResizable(false);

        jScrollPane1.setBounds(10, 180, 840, 260);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.setBounds(100, 100, 90, 50);
        jLayeredPane1.add(btnAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(630, 100, 90, 50);
        jLayeredPane1.add(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/SeleccionarClaseParticular.png"))); // NOI18N
        jLabel1.setBounds(90, 10, 700, 70);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/41.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 870, 460);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(tblParticular.getSelectedRow()!=-1){
            try {
                FileWriter f = new FileWriter("ActualizarParticular.txt");
                PrintWriter p = new PrintWriter(f);
                int fila=tblParticular.getSelectedRow();
                p.println("true,"+tblParticular.getValueAt(fila,0)+","+tblParticular.getValueAt(fila,1)+","+tblParticular.getValueAt(fila,2)+","+tblParticular.getValueAt(fila,3)+","+tblParticular.getValueAt(fila,4)+","+tblParticular.getValueAt(fila,5)+","+tblParticular.getValueAt(fila,6)+","+tblParticular.getValueAt(fila,7)+","+tblParticular.getValueAt(fila,8)+","+tblParticular.getValueAt(fila,9)+",");
                p.close();
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Seleccionar_Particular.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
     public void mostrarDatos(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Cliente");
            Salones.addColumn("Costo");
            Salones.addColumn("Fecha Clase");
            Salones.addColumn("Codigo Doce.");
            Salones.addColumn("Curso");
            Salones.addColumn("Horas");
            Salones.addColumn("Externo");
            Salones.addColumn("Direccion");
            Salones.addColumn("Pago Doce.");
            CallableStatement cst = con.prepareCall("{call usp_ListarCLaseParticular}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[10];
                for(int i=0;i<10;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tblParticular.setModel(Salones);
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
            java.util.logging.Logger.getLogger(Seleccionar_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Seleccionar_Particular().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblParticular;
    // End of variables declaration//GEN-END:variables
}
