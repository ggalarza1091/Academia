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

public class Listado_Faltantes extends javax.swing.JFrame {
    Calendar c = Calendar.getInstance();
    String D,M,A;
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int cantidad;
    public Listado_Faltantes() {
        initComponents();
        this.setTitle("Listado de Faltantes");
        try {
            FileWriter f = new FileWriter("ExcelAlumnosFaltantes.txt");
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        D=Integer.toString(c.get(Calendar.DATE));
        M=Integer.toString(c.get(Calendar.MONTH)+1);
        A=Integer.toString(c.get(Calendar.YEAR));
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
        tblFaltantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtFecha1 = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblFaltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFaltantes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblFaltantes);
        tblFaltantes.getColumnModel().getColumn(0).setResizable(false);
        tblFaltantes.getColumnModel().getColumn(1).setResizable(false);

        jScrollPane1.setBounds(20, 180, 320, 200);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoFaltantes.png"))); // NOI18N
        jLabel1.setBounds(120, 20, 469, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(520, 330, 130, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha1FocusLost(evt);
            }
        });
        txtFecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha1KeyTyped(evt);
            }
        });
        txtFecha1.setBounds(120, 110, 30, 30);
        jLayeredPane1.add(txtFecha1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha2FocusLost(evt);
            }
        });
        txtFecha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha2KeyTyped(evt);
            }
        });
        txtFecha2.setBounds(160, 110, 30, 30);
        jLayeredPane1.add(txtFecha2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha3FocusLost(evt);
            }
        });
        txtFecha3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha3KeyTyped(evt);
            }
        });
        txtFecha3.setBounds(200, 110, 60, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("Fecha:");
        jLabel2.setBounds(60, 110, 40, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(380, 180, 130, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Guardar Registro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(450, 260, 130, 40);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/19.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 670, 500);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(verificar()){
            mostrarTabla();
        }
        else{
            JOptionPane.showMessageDialog(this, "Ingrese Fecha", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtFecha1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha1KeyTyped

    private void txtFecha2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha2KeyTyped

    private void txtFecha3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha3KeyTyped

    private void txtFecha1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha1KeyReleased
        if(txtFecha1.getText().length()>1){
              txtFecha1.setText(txtFecha1.getText().substring(0, 2));
              if(recorrer(txtFecha2.getText())){
                  if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                      txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFecha1KeyReleased

    private void txtFecha2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha2KeyReleased
        if(txtFecha2.getText().length()>1){
              txtFecha2.setText(txtFecha2.getText().substring(0, 2));
              if(Integer.parseInt(txtFecha2.getText())<0||Integer.parseInt(txtFecha2.getText())>12){
                  txtFecha2.setText("12");
              }
              if(txtFecha2.getText().length()==1){
                  if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                      txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFecha2KeyReleased

    private void txtFecha3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha3KeyReleased
        if(txtFecha3.getText().length()>3){
              txtFecha3.setText(txtFecha3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFecha3KeyReleased

    private void txtFecha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha1FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha1FocusLost

    private void txtFecha2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha2FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha2FocusLost

    private void txtFecha3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha3FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha3FocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(verificar()){
            validateDir("D:\\Registros\\Listado_Alumnos",true);
            Object dato[];
            String fecha=txtFecha3.getText()+"-"+txtFecha2.getText()+"-"+txtFecha1.getText();
            try {
                FileWriter f = new FileWriter("ExcelAlumnosFaltantes.txt");
                PrintWriter p = new PrintWriter(f);
                p.println("Codigo=Nombre=");
                p.close();
            } catch (IOException ex) {}
            try {
                CallableStatement cst = con.prepareCall("{call usp_ListarAlumnosFaltantesFecha(?)}");
                cst.setString(1, fecha);
                ResultSet r=cst.executeQuery();
                while(r.next()){
                    dato = new Object[2];
                    for(int i=0;i<2;i++){
                        dato[i]=r.getString(i+1);
                    }
                    try {
                        FileWriter f = new FileWriter("ExcelAlumnosFaltantes.txt",true);
                        PrintWriter p = new PrintWriter(f);
                        p.println(dato[0]+"="+dato[1]+"=");
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
                FileReader m = new FileReader("ExcelAlumnosFaltantes.txt");
                BufferedReader b = new BufferedReader(m);
                while((linea=b.readLine())!=null){
                    crearfila(i,hoja,linea);
                    i++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\Listado_Alumnos\\"+fecha+"-Alumnos.xls");
                libro.write(elFichero);
                elFichero.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                e.printStackTrace();
            }
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\Listado_Alumnos\\"+fecha+"-Alumnos.xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtFecha1.getText())&&recorrer(txtFecha2.getText())&&recorrer(txtFecha3.getText());
        return v;
    }
    public void crearfila(int f,HSSFSheet hoja,String linea){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,"=");
       for(int i=0;i<2;i++){
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
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9'))
            evt.consume();
    }
    public void mostrarTabla(){
        DefaultTableModel Salones = new DefaultTableModel();
        String fecha=txtFecha3.getText()+"-"+txtFecha2.getText()+"-"+txtFecha1.getText();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Nombre");
            int tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumnosFaltantesFecha(?)}");
            cst.setString(1, fecha);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[2];
                for(int i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Salones.addRow(dato);
            }
            this.tblFaltantes.setModel(Salones);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
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
    public int maximodia(int mes,int año){
        int maximo=0;
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: maximo=31; break;
            case 2: if(año%4==0)
                      maximo=29;
                    else
                      maximo=28;
                    break;
            case 4:
            case 6:
            case 9:
            case 11:maximo=30;break;
        }
        return maximo;
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
            java.util.logging.Logger.getLogger(Listado_Faltantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Faltantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Faltantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Faltantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Faltantes().setVisible(true);
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
    private javax.swing.JTable tblFaltantes;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    // End of variables declaration//GEN-END:variables
}
