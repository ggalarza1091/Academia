package academia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tavo
 */
public class Seleccionar_Cursos extends javax.swing.JFrame {
    Connection con;
    int tabla;
    /** Creates new form Seleccionar_Cursos */
    public Seleccionar_Cursos() {
        initComponents();
        this.setTitle("Seleccionar Cursos");
        setLocationRelativeTo(null);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
            mostrarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso", "Costo Hora"
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
        jScrollPane1.setViewportView(tblCursos);
        tblCursos.getColumnModel().getColumn(0).setResizable(false);
        tblCursos.getColumnModel().getColumn(1).setResizable(false);
        tblCursos.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane1.setBounds(40, 200, 430, 210);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.setBounds(510, 200, 88, 40);
        jLayeredPane1.add(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(510, 260, 90, 40);
        jLayeredPane1.add(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/SeleccionarCursos.png"))); // NOI18N
        jLabel1.setBounds(80, 20, 469, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/38.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 640, 460);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    if(tblCursos.getSelectedRow()!=-1){
            try {
                FileWriter f = new FileWriter("ActualizarCurso.txt");
                PrintWriter p = new PrintWriter(f);
                p.println("true,"+tblCursos.getValueAt(tblCursos.getSelectedRow(), 0)+","+tblCursos.getValueAt(tblCursos.getSelectedRow(), 1)+","+tblCursos.getValueAt(tblCursos.getSelectedRow(), 2));
                p.close();
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Seleccionar_Cursos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else{
        JOptionPane.showMessageDialog(this,"Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_btnAgregarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.dispose();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        tblCursos.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    public void mostrarDatos(){
        DefaultTableModel Curso = new DefaultTableModel();
    try {
            Curso.addColumn("Codigo");
            Curso.addColumn("Curso");
            Curso.addColumn("Costo Hora");
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
        this.tblCursos.setModel(Curso);
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
            java.util.logging.Logger.getLogger(Seleccionar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Seleccionar_Cursos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCursos;
    // End of variables declaration//GEN-END:variables
}