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

public class Insertar_Notas extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int tabla;
    public Insertar_Notas() {
        initComponents();
        this.setTitle("Insertar Notas");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        txtEvaluacion = new javax.swing.JTextField();
        txtNota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEvaluacion = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        txtServicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/InsertarNotas.png"))); // NOI18N
        jLabel1.setBounds(150, 40, 400, 50);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Codigo del alumno:");
        jLabel2.setBounds(50, 190, 120, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Codigo de la Evaluacion:");
        jLabel3.setBounds(30, 230, 150, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyReleased(evt);
            }
        });
        txtAlumno.setBounds(180, 190, 90, 30);
        jLayeredPane1.add(txtAlumno, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtEvaluacion.setEditable(false);
        txtEvaluacion.setBounds(180, 230, 90, 30);
        jLayeredPane1.add(txtEvaluacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNotaKeyTyped(evt);
            }
        });
        txtNota.setBounds(180, 270, 90, 30);
        jLayeredPane1.add(txtNota, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Nota:");
        jLabel4.setBounds(50, 270, 60, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(190, 340, 80, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblEvaluacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha", "Preguntas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEvaluacion.getTableHeader().setReorderingAllowed(false);
        tblEvaluacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEvaluacionMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblEvaluacion);
        tblEvaluacion.getColumnModel().getColumn(0).setResizable(false);
        tblEvaluacion.getColumnModel().getColumn(1).setResizable(false);
        tblEvaluacion.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane2.setBounds(330, 130, 290, 180);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.setBounds(50, 340, 90, 50);
        jLayeredPane1.add(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/10.jpg"))); // NOI18N
        jLabel5.setBounds(0, 0, 660, 420);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Academia", "Asesoria" }));
        cbxServicio.setBounds(110, 110, 100, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(210, 150, 100, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DRAG_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(110, 150, 90, 30);
        jLayeredPane1.add(txtServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Servicio:");
        jLabel8.setBounds(40, 150, 60, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased
        if(txtAlumno.getText().length()>5){
              txtAlumno.setText(txtAlumno.getText().substring(0, 6));
        }
    }//GEN-LAST:event_txtAlumnoKeyReleased

    private void txtNotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtNotaKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(verificar()){
            registrarNota();
        }
        else{
            JOptionPane.showMessageDialog(this, "Campos vacios y sin llenar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblEvaluacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEvaluacionMousePressed
        for(int i=0;i<tblEvaluacion.getRowCount();i++){
            if(tblEvaluacion.isRowSelected(i)){
                txtEvaluacion.setText(String.valueOf(tblEvaluacion.getValueAt(tblEvaluacion.getSelectedRow(),0)));
            }
        }
    }//GEN-LAST:event_tblEvaluacionMousePressed

    private void txtNotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaKeyReleased
        if(recorrer(txtNota.getText())){
            if(Integer.parseInt(txtNota.getText())>32768){
                 txtNota.setText("32768");
            }
        }
    }//GEN-LAST:event_txtNotaKeyReleased

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    switch(cbxServicio.getSelectedIndex()){
            case 0:JOptionPane.showMessageDialog(this,"Seleccione Academia o Asesoria","ERROR",JOptionPane.ERROR_MESSAGE);break;
            case 1:Seleccionar_Ciclo x = new Seleccionar_Ciclo();        
                    x.setVisible(true);break;
            case 2:Seleccionar_Asesoria y = new Seleccionar_Asesoria();        
                    y.setVisible(true);break;
        } 
}//GEN-LAST:event_jButton1ActionPerformed

private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    if(cbxServicio.getSelectedIndex()==1){
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
      }
      if(cbxServicio.getSelectedIndex()==2){
       try {
            String linea;
            FileReader f = new FileReader("ActualizarAsesoria.txt");
            BufferedReader b = new BufferedReader(f);
            while((linea=b.readLine())!=null){
                StringTokenizer t = new StringTokenizer(linea,",");
                String boleano=t.nextToken();
                if(Boolean.valueOf(boleano)){
                    txtServicio.setText(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                }
                else{
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                    System.out.println(t.nextToken());
                }
            }
            b.close();
        } catch (IOException ex) {}
       try{
            FileWriter p = new FileWriter("ActualizarAsesoria.txt");
        }
        catch(IOException ex){}
      }
      if(recorrer(txtServicio.getText())){
          mostrarDatos();
      }
}//GEN-LAST:event_formWindowGainedFocus
    public void mostrarDatos(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Fecha");
            Salones.addColumn("Preguntas");
            CallableStatement cst = con.prepareCall("{call usp_ListarEvaluacion(?)}");
            cst.setString(1,txtServicio.getText());
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tblEvaluacion.setModel(Salones);
            r.close();
            cst.close();
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }   
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
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
    public boolean verificar(){
        boolean verificacion=true;
        verificacion=verificacion&&recorrer(txtAlumno.getText());
        verificacion=verificacion&&recorrer(txtEvaluacion.getText());
        verificacion=verificacion&&recorrer(txtNota.getText());
        return verificacion;
    }
    public void registrarNota(){
        try{
            String codigoalumno=txtAlumno.getText();
            String codigoevaluacion = txtEvaluacion.getText();
            int nota=Integer.parseInt(txtNota.getText());
            CallableStatement cst = con.prepareCall("{call usp_InsertarCalificacionEvaluacionAlumno(?,?,?)}");
            cst.setString(1,codigoalumno);
            cst.setString(2,codigoevaluacion);
            cst.setInt(3,nota);
            int rpta = cst.executeUpdate();
            if(rpta==1){
                JOptionPane.showMessageDialog(this, "Registrado Correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Nota ya registrada","ERROR",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Insertar_Notas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEvaluacion;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtEvaluacion;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
