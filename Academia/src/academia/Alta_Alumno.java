package academia;
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

public class Alta_Alumno extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Alta_Alumno() {
        initComponents();
        this.setTitle("Dar Alta - Alumnos");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlta = new javax.swing.JTable();
        btnAlta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApelPat = new javax.swing.JTextField();
        txtApelMat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblAlta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido Mat", "Apellido Pat", "Direccion", "Telefono", "Correo", "Fecha Nac", "Apoderado", "Grupo San.", "Nivel Academico", "Foto", "Obs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAlta);
        tblAlta.getColumnModel().getColumn(0).setResizable(false);
        tblAlta.getColumnModel().getColumn(1).setResizable(false);
        tblAlta.getColumnModel().getColumn(2).setResizable(false);
        tblAlta.getColumnModel().getColumn(3).setResizable(false);
        tblAlta.getColumnModel().getColumn(4).setResizable(false);
        tblAlta.getColumnModel().getColumn(5).setResizable(false);
        tblAlta.getColumnModel().getColumn(6).setResizable(false);
        tblAlta.getColumnModel().getColumn(7).setResizable(false);
        tblAlta.getColumnModel().getColumn(8).setResizable(false);
        tblAlta.getColumnModel().getColumn(10).setResizable(false);
        tblAlta.getColumnModel().getColumn(11).setResizable(false);
        tblAlta.getColumnModel().getColumn(12).setResizable(false);

        jScrollPane1.setBounds(10, 220, 1060, 260);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAlta.setText("Dar de Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });
        btnAlta.setBounds(820, 150, 100, 40);
        jLayeredPane1.add(btnAlta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/AltaAlumno.png"))); // NOI18N
        jLabel2.setBounds(380, 20, 410, 70);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.setBounds(490, 150, 65, 30);
        jLayeredPane1.add(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(960, 150, 90, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/2.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 1090, 530);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(120, 120, 110, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.POPUP_LAYER);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        txtNombre.setBounds(320, 120, 110, 30);
        jLayeredPane1.add(txtNombre, javax.swing.JLayeredPane.POPUP_LAYER);

        txtApelPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApelPatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelPatKeyTyped(evt);
            }
        });
        txtApelPat.setBounds(120, 180, 110, 30);
        jLayeredPane1.add(txtApelPat, javax.swing.JLayeredPane.POPUP_LAYER);

        txtApelMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApelMatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApelMatKeyTyped(evt);
            }
        });
        txtApelMat.setBounds(320, 180, 110, 30);
        jLayeredPane1.add(txtApelMat, javax.swing.JLayeredPane.POPUP_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo:");
        jLabel4.setBounds(30, 120, 70, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jLabel1.setBounds(240, 120, 70, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido Mat:");
        jLabel5.setBounds(240, 180, 100, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido Pat:");
        jLabel6.setBounds(30, 180, 100, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       if(verificar()){
            Datos();
       }
       else{
           JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
       if(tblAlta.getSelectedRow()!=-1){
            modificarAlumno();
       }
       else{
           JOptionPane.showMessageDialog(this,"Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnAltaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        if(txtCodigo.getText().length()>6){
             txtCodigo.setText(txtCodigo.getText().substring(0, 6));
        }
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char caracter = evt.getKeyChar();
          if(((caracter < '0') ||(caracter > '9'))&&((caracter < 'a') ||(caracter > 'z'))&&((caracter < 'A') ||(caracter > 'Z'))){
              evt.consume();
          }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtApelPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelPatKeyReleased
        if(txtApelPat.getText().length()>20){
             txtApelPat.setText(txtApelPat.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtApelPatKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
       if(txtNombre.getText().length()>20){
             txtNombre.setText(txtNombre.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApelMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelMatKeyReleased
        if(txtApelMat.getText().length()>20){
             txtApelMat.setText(txtApelMat.getText().substring(0, 20));
        }
    }//GEN-LAST:event_txtApelMatKeyReleased

    private void txtApelPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelPatKeyTyped
       bloqueoNumeros(evt);
    }//GEN-LAST:event_txtApelPatKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApelMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApelMatKeyTyped
        bloqueoNumeros(evt);
    }//GEN-LAST:event_txtApelMatKeyTyped
    public void bloqueoNumeros(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
          if((caracter < '0') ||(caracter > '9')){}
          else{
            evt.consume();
          }
    }
    public void modificarAlumno(){
        try{
            String codigo = String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),0));
            String nombre = String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),1));
            String apelpat= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),3));
            String apelmat= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),2));
            String direccion= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),4));
            String telefono= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),5));
            String correo= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),6));
            String fechanac= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),7));
            String apoderado= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),8));
            String gs= String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),9));
            String nivelacademico=String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),10));
            Boolean obs = Boolean.valueOf(String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),12)));
                CallableStatement cst = con.prepareCall("{call usp_ActualizarAlumno(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst.setString(1,codigo);
                cst.setBoolean(2,true);
                cst.setString(3,nombre);
                cst.setString(4,apelpat);
                cst.setString(5,apelmat);
                cst.setString(6,direccion);
                cst.setString(7,telefono);
                cst.setString(8,correo);
                cst.setString(9,fechanac);
                cst.setString(10,apoderado);
                cst.setString(11,gs);
                cst.setString(12,nivelacademico);
                cst.setBoolean(13,obs);
                int rpta = cst.executeUpdate();
                if(rpta==1){
                    JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
                cst.close();
                try {
                    FileWriter f = new FileWriter("AltaAlumno.txt");
                    PrintWriter p = new PrintWriter(f);
                    p.println("true,"+codigo+",");
                } catch (IOException ex) {
                    Logger.getLogger(Alta_Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
    }
    public void Datos(){
        DefaultTableModel alta = new DefaultTableModel();
        try {
                alta.addColumn("Codigo");
                alta.addColumn("Nombre");
                alta.addColumn("Apellido Pat");
                alta.addColumn("Apellido Mat");
                alta.addColumn("Direccion");
                alta.addColumn("Telefono");
                alta.addColumn("Correo");
                alta.addColumn("Fecha Nac");
                alta.addColumn("Apoderado");
                alta.addColumn("Grupo San.");
                alta.addColumn("Nivel Acad.");
                alta.addColumn("Foto");
                alta.addColumn("Obs.");
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumnosInactivos(?,?,?,?)}");
            cst.setString(1,borrarespacios(txtCodigo.getText()));
            cst.setString(2,borrarespacios(txtNombre.getText()));
            cst.setString(3,borrarespacios(txtApelMat.getText()));
            cst.setString(4,borrarespacios(txtApelPat.getText()));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[13];
                for(int i=0;i<13;i++){
                    dato[i]=r.getString(i+1);
                }
                    alta.addRow(dato);
            }
            this.tblAlta.setModel(alta);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        boolean v=false;
        v=v||recorrer(txtCodigo.getText());
        v=v||recorrer(txtNombre.getText());
        v=v||recorrer(txtApelPat.getText());
        v=v||recorrer(txtApelMat.getText());
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
    public int obtenermes(String mes){
        int m=0;
        if(mes.equalsIgnoreCase("Enero")){m=1;}
        if(mes.equalsIgnoreCase("Febrero")){m=2;}
        if(mes.equalsIgnoreCase("Marzo")){m=3;}
        if(mes.equalsIgnoreCase("Abril")){m=4;}
        if(mes.equalsIgnoreCase("Mayo")){m=5;}
        if(mes.equalsIgnoreCase("Junio")){m=6;}
        if(mes.equalsIgnoreCase("Julio")){m=7;}
        if(mes.equalsIgnoreCase("Agosto")){m=8;}
        if(mes.equalsIgnoreCase("Septiembre")){m=9;}
        if(mes.equalsIgnoreCase("Octubre")){m=10;}
        if(mes.equalsIgnoreCase("Noviembre")){m=11;}
        if(mes.equalsIgnoreCase("Diciembre")){m=12;}
        return m;
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
            java.util.logging.Logger.getLogger(Alta_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Alta_Alumno().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlta;
    private javax.swing.JTextField txtApelMat;
    private javax.swing.JTextField txtApelPat;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
