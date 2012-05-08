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
public class Listado_Particular extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    Calendar c = Calendar.getInstance();
    public Listado_Particular() {
        initComponents();
        this.setTitle("Listado de Clases Particulares");
        this.setIconImage(icono);
        try {
            FileWriter f = new FileWriter("ExcelParticular.txt");
        } catch (IOException ex) {}
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
        tblParticulares = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblParticulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "Costo", "Fecha Clase", "Codigo Doce.", "Curso", "Horas", "Externo", "Direccion", "Pago Doce."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParticulares.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblParticulares);
        tblParticulares.getColumnModel().getColumn(0).setResizable(false);
        tblParticulares.getColumnModel().getColumn(1).setResizable(false);
        tblParticulares.getColumnModel().getColumn(2).setResizable(false);
        tblParticulares.getColumnModel().getColumn(3).setResizable(false);
        tblParticulares.getColumnModel().getColumn(4).setResizable(false);
        tblParticulares.getColumnModel().getColumn(5).setResizable(false);
        tblParticulares.getColumnModel().getColumn(6).setResizable(false);
        tblParticulares.getColumnModel().getColumn(7).setResizable(false);
        tblParticulares.getColumnModel().getColumn(8).setResizable(false);
        tblParticulares.getColumnModel().getColumn(9).setResizable(false);

        jScrollPane1.setBounds(20, 196, 830, 290);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(770, 130, 73, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Ver y Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(650, 130, 100, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoParticulares.png"))); // NOI18N
        jLabel1.setBounds(260, 10, 380, 110);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel2.setBounds(0, 0, 870, 520);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/66.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 870, 520);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        validateDir("D:\\Registros\\Listado_Particulares",true);
        Object dato[];
        String M=Integer.toString(c.get(Calendar.MONTH)+1);
        String A=Integer.toString(c.get(Calendar.YEAR));
        try {
            FileWriter f = new FileWriter("ExcelParticular.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Codigo=Cliente=Costo de la Clase=Fecha de la Clase=Codigo del Docente=Curso=Horas=Clase Externa=Direccion Externo=Pago al Docente=");
            p.close();
        } catch (IOException ex) {}
        try {
            CallableStatement cst = con.prepareCall("{call usp_ListarCLaseParticular}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[10];
                for(int i=0;i<10;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelParticular.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"="+dato[4]+"="+dato[5]+"="+dato[6]+"="+dato[7]+"="+dato[8]+"="+dato[9]+"=");
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
            FileReader m = new FileReader("ExcelParticular.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\Listado_Particulares\\Particulares-"+M+"-"+A+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        try {
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\Listado_Particulares\\Particulares-"+M+"-"+A+".xls");
        }   
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
     public void crearfila(int f,HSSFSheet hoja,String linea){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,"=");
       for(int i=0;i<10;i++){
           crearcelda(i,fila,String.valueOf(t.nextToken()));
       }
    }
    public void crearcelda(int i,HSSFRow f,String txt){
        HSSFCell celda = f.createCell(i);
        if(txt.equalsIgnoreCase("null")){
            txt=" ";
        }
        celda.setCellValue(txt);
    }
    public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action)
            file.mkdirs();
        return isDirectory;
    }
    public void mostrarDatos(){
         DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Cliente");
            Salones.addColumn("Costo Clase");
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
                for(int i=0;i<10 ;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tblParticulares.setModel(Salones);
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
            java.util.logging.Logger.getLogger(Listado_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Particular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Particular().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblParticulares;
    // End of variables declaration//GEN-END:variables
}
