package academia;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
public class Seleccionar_CursosDominio extends javax.swing.JFrame {
    Connection con;
    int tabla;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    DefaultTableModel dominio = new DefaultTableModel();
    public Seleccionar_CursosDominio() {
        initComponents();
        this.setTitle("Seleccionar Cursos de Dominio");
        this.setIconImage(icono);
        dominio.addColumn("Codigo");
        dominio.addColumn("Curso");
        tblCursos.setModel(dominio);
        setLocationRelativeTo(this);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
            mostrarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        colocarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDominioCursos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.setBounds(30, 360, 90, 50);
        jLayeredPane1.add(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblDominioCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDominioCursos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDominioCursos);
        tblDominioCursos.getColumnModel().getColumn(0).setResizable(false);
        tblDominioCursos.getColumnModel().getColumn(1).setResizable(false);

        jScrollPane1.setBounds(30, 130, 340, 200);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Cancelar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(640, 360, 90, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCursos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblCursos);
        tblCursos.getColumnModel().getColumn(0).setResizable(false);
        tblCursos.getColumnModel().getColumn(1).setResizable(false);

        jScrollPane2.setBounds(390, 130, 340, 200);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        btnBorrar.setBounds(390, 360, 80, 50);
        jLayeredPane1.add(btnBorrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.setBounds(540, 360, 80, 50);
        jLayeredPane1.add(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/SeleccionarCursosDominio1.png"))); // NOI18N
        jLabel1.setBounds(220, 0, 380, 130);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/39.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 770, 440);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblDominioCursos.getSelectedRow()!=-1){
            Object dato[]=new Object[2];
            dato[0]=tblDominioCursos.getValueAt(tblDominioCursos.getSelectedRow(),0);
            dato[1]=tblDominioCursos.getValueAt(tblDominioCursos.getSelectedRow(),1);
            if(tblCursos.getRowCount()==0){
                dominio.addRow(dato);
                tblCursos.setModel(dominio);
            }
            else{
                boolean v =true;
                outerloop:
                for(int i=0;i<tblCursos.getRowCount();i++){
                    if(dato[0]==tblCursos.getValueAt(i,0)&&dato[1]==tblCursos.getValueAt(i,1)){
                        v=false;
                        break outerloop;
                    }
                }
                if(v){
                    dominio.addRow(dato);
                    tblCursos.setModel(dominio);
                }
        }   }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione un CURSO a agregar");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(tblCursos.getRowCount()!=0){
            try {
                FileWriter m = new FileWriter("ActualizarCursoDominio.txt");
            } catch (IOException ex) {
                Logger.getLogger(Seleccionar_CursosDominio.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                FileWriter f = new FileWriter("ActualizarCursoDominio.txt",true);
                PrintWriter p = new PrintWriter(f);
                for(int i=0;i<tblCursos.getRowCount();i++)
                    p.println("true,"+tblCursos.getValueAt(i, 0)+","+tblCursos.getValueAt(i, 1)+",");
                p.close();
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Seleccionar_Cursos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else{
        JOptionPane.showMessageDialog(this,"Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
         if(tblCursos.getSelectedRow()!=-1){
            dominio.removeRow(tblCursos.getSelectedRow());
            tblCursos.setModel(dominio);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    public void mostrarDatos(){
        DefaultTableModel Curso = new DefaultTableModel();
        try {
                Curso.addColumn("Codigo");
                Curso.addColumn("Curso");
            tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarCurso}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[2];
                for(int i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Curso.addRow(dato);
            }
            this.tblDominioCursos.setModel(Curso);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void colocarDatos(){
        try {
            String linea;
            FileReader f = new FileReader("ActualizarCursoDominio.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                if(Boolean.valueOf(t.nextToken())){
                    Object dato[] = new Object[2];    
                    dato[0]=t.nextToken();
                    dato[1]=t.nextToken();
                    dominio.addRow(dato);
                }
                else{
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                }
            }
            tblCursos.setModel(dominio);
            b.close();
        }
        catch(IOException ex){JOptionPane.showMessageDialog(this, "no hay archivo","ERROR",JOptionPane.ERROR_MESSAGE);}
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
            java.util.logging.Logger.getLogger(Seleccionar_CursosDominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_CursosDominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_CursosDominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_CursosDominio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Seleccionar_CursosDominio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTable tblDominioCursos;
    // End of variables declaration//GEN-END:variables
}
