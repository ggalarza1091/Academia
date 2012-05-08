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
public class Modificar_Evaluacion extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Modificar_Evaluacion() {
        initComponents();
        this.setTitle("Modificar Evaluacion");
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

        jLabel2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvaluacion = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        txtFecha1 = new javax.swing.JTextField();
        txtPreguntas = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbxServicio = new javax.swing.JComboBox();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo:");
        jLabel1.setBounds(20, 200, 60, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Fecha:");
        jLabel3.setBounds(20, 240, 60, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Preguntas:");
        jLabel4.setBounds(20, 280, 70, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblEvaluacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Fecha", "Preguntas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
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
        jScrollPane1.setViewportView(tblEvaluacion);
        tblEvaluacion.getColumnModel().getColumn(0).setResizable(false);
        tblEvaluacion.getColumnModel().getColumn(1).setResizable(false);
        tblEvaluacion.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane1.setBounds(300, 140, 380, 230);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.setEditable(false);
        txtCodigo.setBounds(100, 200, 120, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha1.setBounds(100, 240, 30, 30);
        jLayeredPane1.add(txtFecha1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtPreguntas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPreguntasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreguntasKeyTyped(evt);
            }
        });
        txtPreguntas.setBounds(100, 280, 120, 30);
        jLayeredPane1.add(txtPreguntas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.setBounds(40, 330, 90, 40);
        jLayeredPane1.add(btnModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.setBounds(150, 330, 90, 40);
        jLayeredPane1.add(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(150, 390, 90, 40);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha2.setBounds(140, 240, 30, 30);
        jLayeredPane1.add(txtFecha2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha3.setBounds(180, 240, 40, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarEvaluacion.png"))); // NOI18N
        jLabel5.setBounds(120, 10, 500, 60);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/28.jpg"))); // NOI18N
        jLabel6.setBounds(0, 0, 720, 470);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("Servicio:");
        jLabel7.setBounds(20, 160, 50, 30);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DRAG_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(100, 160, 70, 30);
        jLayeredPane1.add(txtServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(190, 160, 100, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DRAG_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Academia", "Asesoria" }));
        cbxServicio.setBounds(100, 120, 120, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblEvaluacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEvaluacionMousePressed
        if(tblEvaluacion.getSelectedRow()!=-1){
            txtCodigo.setText(String.valueOf(tblEvaluacion.getValueAt(tblEvaluacion.getSelectedRow(),0)));
            String fecha=String.valueOf(tblEvaluacion.getValueAt(tblEvaluacion.getSelectedRow(),1));
            txtFecha1.setText(String.valueOf(fecha).substring(0,2));
            txtFecha2.setText(String.valueOf(fecha).substring(3,5));
            txtFecha3.setText(String.valueOf(fecha).substring(6,10));
            txtPreguntas.setText(String.valueOf(tblEvaluacion.getValueAt(tblEvaluacion.getSelectedRow(),2)));
        }
    }//GEN-LAST:event_tblEvaluacionMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       if(tblEvaluacion.getSelectedRow()!=-1){
           if(verificar()){
               modificar();
           }
       }
       else{
           JOptionPane.showMessageDialog(this,"Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnModificarActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    if(tblEvaluacion.getSelectedRow()!=-1){
           if(recorrer(txtCodigo.getText())){
               eliminar();
           }
       }
       else{
           JOptionPane.showMessageDialog(this,"Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
       }
}//GEN-LAST:event_btnEliminarActionPerformed

private void txtPreguntasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreguntasKeyTyped
    bloqueoLetras(evt);
}//GEN-LAST:event_txtPreguntasKeyTyped

private void txtPreguntasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreguntasKeyReleased
    if(Integer.parseInt(txtPreguntas.getText())>=250){
             txtPreguntas.setText("250");
        }
}//GEN-LAST:event_txtPreguntasKeyReleased

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
      }
      if(recorrer(txtServicio.getText())){
          mostrarDatos();
      }
}//GEN-LAST:event_formWindowGainedFocus
   public void mostrarDatos(){
        DefaultTableModel Evaluacion = new DefaultTableModel();
        try {
                Evaluacion.addColumn("Codigo");
                Evaluacion.addColumn("Fecha");
                Evaluacion.addColumn("Preguntas");
            CallableStatement cst = con.prepareCall("{call usp_ListarEvaluacion(?)}");
            cst.setString(1,txtServicio.getText());
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
                    dato[i]=r.getString(i+1);
                }
            Evaluacion.addRow(dato);
            }
            this.tblEvaluacion.setModel(Evaluacion);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9'))
            evt.consume();
    }
    public void modificar(){
        try{
            String preguntas= borrarespacios(txtPreguntas.getText());
            String codigo=borrarespacios(txtCodigo.getText());
            String fecha= txtFecha3.getText()+"-"+txtFecha2.getText()+"-"+txtFecha1.getText();
            CallableStatement cst = con.prepareCall("{call usp_ActualizarEvaluacion(?,?,?,?)}");
            cst.setString(1,codigo);
            cst.setInt(2,Integer.parseInt(preguntas));
            cst.setString(3,fecha);
            cst.setString(4,txtServicio.getText());
            int rpta = cst.executeUpdate();
            if(rpta>=1){
                JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();   
            mostrarDatos();
            limpiar();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al modificar un Curso","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void eliminar(){
        try{
            String codigo=borrarespacios(txtCodigo.getText());
            CallableStatement cst = con.prepareCall("{call usp_EliminarEvaluacion(?)}");
            cst.setString(1,codigo);
            int rpta = cst.executeUpdate();
            if(rpta>=1){
                JOptionPane.showMessageDialog(this,"Se ha eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();   
            mostrarDatos();
            limpiar();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se puede eliminar, porque ya esta en uso","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void limpiar(){
        txtCodigo.setText("");
        txtFecha1.setText("");
        txtFecha2.setText("");
        txtFecha3.setText("");
        txtPreguntas.setText("");
        tblEvaluacion.clearSelection();
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
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        v=v&recorrer(txtFecha1.getText());
        v=v&recorrer(txtFecha2.getText());
        v=v&recorrer(txtFecha3.getText());
        v=v&recorrer(txtPreguntas.getText());
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
            java.util.logging.Logger.getLogger(Modificar_Evaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Evaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Evaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Evaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Evaluacion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEvaluacion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    private javax.swing.JTextField txtPreguntas;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
