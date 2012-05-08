package academia;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class RP_Descuentos extends javax.swing.JFrame {
Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public RP_Descuentos() {
        initComponents();
        this.setTitle("Mostrar Reporte de Descuentos");
        try {
            FileWriter f = new FileWriter("ExcelRPDescuentos.txt");
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        tabla = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        txtFechaL1 = new javax.swing.JTextField();
        txtFechaL2 = new javax.swing.JTextField();
        txtFechaL3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Dscto", "Codigo Dscto", "Monto", "Motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);
        tabla.getColumnModel().getColumn(3).setResizable(false);

        jScrollPane1.setBounds(20, 250, 510, 250);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtCodigo.setBounds(80, 200, 60, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaL1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaL1FocusLost(evt);
            }
        });
        txtFechaL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaL1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaL1KeyTyped(evt);
            }
        });
        txtFechaL1.setBounds(230, 200, 30, 30);
        jLayeredPane1.add(txtFechaL1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaL2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaL2FocusLost(evt);
            }
        });
        txtFechaL2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaL2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaL2KeyTyped(evt);
            }
        });
        txtFechaL2.setBounds(270, 200, 30, 30);
        jLayeredPane1.add(txtFechaL2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFechaL3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaL3FocusLost(evt);
            }
        });
        txtFechaL3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaL3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaL3KeyTyped(evt);
            }
        });
        txtFechaL3.setBounds(310, 200, 50, 30);
        jLayeredPane1.add(txtFechaL3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha Limite:");
        jLabel1.setBounds(150, 200, 90, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo:");
        jLabel2.setBounds(20, 200, 80, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(260, 130, 70, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Guardar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(50, 130, 150, 30);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(420, 130, 70, 30);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/34.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 560, 530);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtFechaL1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaL1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL1KeyTyped

    private void txtFechaL2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaL2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL2KeyTyped

    private void txtFechaL3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaL3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL3KeyTyped

    private void txtFechaL1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaL1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL1KeyReleased

    private void txtFechaL2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaL2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL2KeyReleased

    private void txtFechaL3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaL3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL3KeyReleased

    private void txtFechaL1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaL1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL1FocusLost

    private void txtFechaL2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaL2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL2FocusLost

    private void txtFechaL3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaL3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaL3FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(verificar()){
            mostrarDatos();
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(verificar()){
            guardar();
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void crearfila(int f,HSSFSheet hoja,String linea){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,"=");
       for(int i=0;i<4;i++){
           crearcelda(i,fila,String.valueOf(t.nextToken()));
       }
    }
    public void crearcelda(int i,HSSFRow f,String txt){
        HSSFCell celda = f.createCell(i);
        celda.setCellValue(txt);
    }
    public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action)
            file.mkdirs();
        return isDirectory;
    }
    public void guardar(){
        validateDir("D:\\Reportes\\Descuentos",true);
        Object dato[];
        try {
            FileWriter f = new FileWriter("ExcelRPDescuentos.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Fecha de Descuento=Codigo de Descuento=Monto Descontado=Motivo=");
            p.close();
        } catch (IOException ex) {}
        try {
            String codigo=txtCodigo.getText();
            String fechalimite=txtFechaL3.getText()+"-"+txtFechaL2.getText()+"-"+txtFechaL1.getText();
            CallableStatement cst = con.prepareCall("{call usp_RPListaDescuentoRealizadosColaborador(?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,fechalimite);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelRPDescuentos.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"=");
                    p.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,"Error en el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Hoja 1");
        try {
            String linea;
            int i=0;
            FileReader m = new FileReader("ExcelRPDescuentos.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Reportes\\Descuentos\\"+txtCodigo.getText()+"-"+txtFechaL2.getText()+"-"+txtFechaL3.getText()+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        try {
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Reportes\\Descuentos\\"+txtCodigo.getText()+"-"+txtFechaL2.getText()+"-"+txtFechaL3.getText()+".xls");
        }   
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(RP_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RP_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RP_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RP_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RP_Descuentos().setVisible(true);
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFechaL1;
    private javax.swing.JTextField txtFechaL2;
    private javax.swing.JTextField txtFechaL3;
    // End of variables declaration//GEN-END:variables
}
