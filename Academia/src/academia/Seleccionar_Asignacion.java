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
public class Seleccionar_Asignacion extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
   
    public Seleccionar_Asignacion() {
        initComponents();
        this.setTitle("Seleccionar Asignacion");
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
        tblAsignacion = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Costo", "Fecha Recepcion", "Fecha Entrega", "Pago Docente", "Cliente", "Cod Docente", "Docente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsignacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAsignacion);

        jScrollPane1.setBounds(10, 180, 690, 280);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.setBounds(80, 110, 100, 50);
        jLayeredPane1.add(btnAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(510, 110, 100, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/SeleccionarAsignacion.png"))); // NOI18N
        jLabel1.setBounds(90, 20, 560, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/36.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 710, 490);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(tblAsignacion.getSelectedRow()!=-1){
            try {
                FileWriter f = new FileWriter("ActualizarAsignacion.txt");
                PrintWriter p = new PrintWriter(f);
                int fila=tblAsignacion.getSelectedRow();
                p.println("true,"+tblAsignacion.getValueAt(fila,0)+","+tblAsignacion.getValueAt(fila,1)+","+tblAsignacion.getValueAt(fila,2)+","+tblAsignacion.getValueAt(fila,3)+","+tblAsignacion.getValueAt(fila,4)+","+tblAsignacion.getValueAt(fila,5)+","+tblAsignacion.getValueAt(fila,6)+","+tblAsignacion.getValueAt(fila,7)+",");
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
        DefaultTableModel asignacion = new DefaultTableModel();
        try {
            asignacion.addColumn("Codigo");
            asignacion.addColumn("Costo");
            asignacion.addColumn("Fecha Recepcion");
            asignacion.addColumn("Fecha Entrega");
            asignacion.addColumn("Pago Docente");
            asignacion.addColumn("Cliente");
            asignacion.addColumn("Cod Docente");
            asignacion.addColumn("Docente");
            CallableStatement cst = con.prepareCall("{call usp_ListarAsignacion}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[8];
                for(int i=0;i<8;i++){
                    dato[i]=r.getString(i+1);
                }
            asignacion.addRow(dato);
            }
            this.tblAsignacion.setModel(asignacion);
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
            java.util.logging.Logger.getLogger(Seleccionar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Asignacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Seleccionar_Asignacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAsignacion;
    // End of variables declaration//GEN-END:variables
}
