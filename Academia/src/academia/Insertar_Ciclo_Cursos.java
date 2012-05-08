package academia;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
public class Insertar_Ciclo_Cursos extends javax.swing.JFrame {
Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    DefaultTableModel Curso = new DefaultTableModel();
    public Insertar_Ciclo_Cursos() {
        initComponents();
        this.setTitle("Insertar Cursos de un Ciclo");
         Curso.addColumn("Codigo");
         Curso.addColumn("Curso");
         Curso.addColumn("Costo Hora");
         this.tabla.setModel(Curso);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtServicio = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLayeredPane1MousePressed(evt);
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

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane2.setBounds(280, 350, 419, 140);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso", "Costo "
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

        jScrollPane1.setBounds(280, 150, 419, 150);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(150, 360, 100, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(30, 360, 100, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(110, 210, 100, 30);
        jLayeredPane1.add(txtServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton3.setText("Seleccionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(110, 250, 100, 30);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Servicio:");
        jLabel8.setBounds(50, 210, 60, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(150, 420, 100, 40);
        jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.setBounds(30, 420, 100, 40);
        jLayeredPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/InsertarCursosPorCiclo.png"))); // NOI18N
        jLabel1.setBounds(10, 30, 510, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/50.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 750, 530);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Seleccionar_Ciclo x = new Seleccionar_Ciclo();        
    x.setVisible(true);
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    this.dispose();
}//GEN-LAST:event_jButton4ActionPerformed

private void jLayeredPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLayeredPane1AncestorAdded
    listarCursos();
}//GEN-LAST:event_jLayeredPane1AncestorAdded

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if(tblCursos.getSelectedRow()!=-1){
         Object dato[] = new Object[3];
         dato[0]=tblCursos.getValueAt(tblCursos.getSelectedRow(),0);
         dato[1]=tblCursos.getValueAt(tblCursos.getSelectedRow(),1);
         dato[2]=tblCursos.getValueAt(tblCursos.getSelectedRow(),2);
          if(tabla.getRowCount()==0){
                Curso.addRow(dato);
                tabla.setModel(Curso);
            }
            else{
                boolean v =true;
                outerloop:
                for(int i=0;i<tabla.getRowCount();i++){
                    if(dato[0]==tabla.getValueAt(i,0)&&dato[1]==tabla.getValueAt(i,1)&&dato[2]==tabla.getValueAt(i,2)){
                        v=false;
                        break outerloop;
                    }
                }
                if(v){
                    Curso.addRow(dato);
                    tabla.setModel(Curso);
                }
        }
    }
    else{
        JOptionPane.showMessageDialog(this,"Seleccione una fila de la tabla superior","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if(tabla.getSelectedRow()!=-1){
         Curso.removeRow(tabla.getSelectedRow());
         this.tabla.setModel(Curso);
    }
    else{
        JOptionPane.showMessageDialog(this,"Seleccione una fila de la tabla inferior","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jLayeredPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MousePressed
        tblCursos.clearSelection();
        tabla.clearSelection();
    }//GEN-LAST:event_jLayeredPane1MousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(verificar()){
            boolean v=true;
            for(int i=0;i<tabla.getRowCount();i++){
                v=v&guardar(i);
            }
            if(v){
                JOptionPane.showMessageDialog(this,"Se registro correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            String linea;
            FileReader f = new FileReader("ActualizarServicio.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                String boleano=t.nextToken();
                if(Boolean.valueOf(boleano)){
                    txtServicio.setText(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
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
        try{
            FileWriter p = new FileWriter("ActualizarServicio.txt");
        }
        catch(IOException ex){}
    }//GEN-LAST:event_formWindowGainedFocus
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtServicio.getText());
        if(tabla.getRowCount()==0){
            v=false;
        }
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
     public boolean guardar(int i){
         boolean v=false;
         try {
            
            String servicio=txtServicio.getText();
            String curso = String.valueOf(tabla.getValueAt(i,0));
            CallableStatement cst = con.prepareCall("{call usp_InsertarCicloCurso(?,?)}");
            cst.setString(1,curso);
            cst.setString(2,servicio);
            int rpta1 = cst.executeUpdate();
            if(rpta1>=1){
                v=true;
            }
            cst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Error al Registrar el Servicio Asesoria","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;   
     }
    public void listarCursos(){
    try {
        DefaultTableModel Curso = new DefaultTableModel();
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
            java.util.logging.Logger.getLogger(Insertar_Ciclo_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_Ciclo_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_Ciclo_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_Ciclo_Cursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Insertar_Ciclo_Cursos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
