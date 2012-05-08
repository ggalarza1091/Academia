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
public class Listado_Salones_Ciclo extends javax.swing.JFrame {
Calendar c = Calendar.getInstance();
    String D,M,A;
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int cantidad;
    public Listado_Salones_Ciclo() {
        initComponents();
        this.setTitle("Listado de Salones por Ciclo");
         try {
            FileWriter f = new FileWriter("ExcelSalonesCiclo.txt");
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCiclo = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLayeredPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLayeredPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jButton1.setText("Ver y Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(453, 180, 110, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(590, 180, 73, 40);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCiclo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Pago", "Matricula", "Ciclo", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCiclo.getTableHeader().setReorderingAllowed(false);
        tblCiclo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCicloMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblCiclo);
        tblCiclo.getColumnModel().getColumn(0).setResizable(false);
        tblCiclo.getColumnModel().getColumn(1).setResizable(false);
        tblCiclo.getColumnModel().getColumn(2).setResizable(false);
        tblCiclo.getColumnModel().getColumn(3).setResizable(false);
        tblCiclo.getColumnModel().getColumn(4).setResizable(false);
        tblCiclo.getColumnModel().getColumn(5).setResizable(false);

        jScrollPane2.setBounds(30, 240, 490, 230);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblSalon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Salon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSalon.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSalon);
        tblSalon.getColumnModel().getColumn(0).setResizable(false);

        jScrollPane1.setBounds(543, 240, 140, 230);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoSalonCiclo.png"))); // NOI18N
        jLabel1.setBounds(110, 0, 540, 80);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/62.jpg"))); // NOI18N
        jLabel2.setBounds(0, 0, 720, 530);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLayeredPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLayeredPane1AncestorAdded
        mostrarDatos();
    }//GEN-LAST:event_jLayeredPane1AncestorAdded

    private void tblCicloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCicloMousePressed
        if(tblCiclo.getSelectedRow()!=-1){
            mostrarSalones();
        }
    }//GEN-LAST:event_tblCicloMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tblCiclo.getSelectedRow()!=-1){
            D=Integer.toString(c.get(Calendar.DATE));
            M=Integer.toString(c.get(Calendar.MONTH)+1);
            A=Integer.toString(c.get(Calendar.YEAR));
           validateDir("D:\\Registros\\Salones",true);
            Object dato[];
            String codigo=String.valueOf(tblCiclo.getValueAt(tblCiclo.getSelectedRow(),0));
            try {
                FileWriter f = new FileWriter("ExcelSalonesCiclo.txt");
                PrintWriter p = new PrintWriter(f);
                p.println("Codigo");
                p.close();
            } catch (IOException ex) {}
            try {
                CallableStatement cst = con.prepareCall("{call usp_ListarSalonesCiclo(?)}");
                cst.setString(1,codigo);
                ResultSet r=cst.executeQuery();
                while(r.next()){
                    dato = new Object[1];
                    for(int i=0;i<1;i++){
                        dato[i]=r.getString(i+1);
                    }
                    try {
                        FileWriter f = new FileWriter("ExcelSalonesCiclo.txt",true);
                        PrintWriter p = new PrintWriter(f);
                        p.println(dato[0]+",");
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
                FileReader m = new FileReader("ExcelSalonesCiclo.txt");
                BufferedReader b = new BufferedReader(m);
                while((linea=b.readLine())!=null){
                    crearfila(i,hoja,linea);
                    i++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\Salones\\"+codigo+"-"+M+"-"+A+".xls");
                libro.write(elFichero);
                elFichero.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                e.printStackTrace();
            }
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\Salones\\"+codigo+"-"+M+"-"+A+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void crearfila(int f,HSSFSheet hoja,String linea){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,",");
       for(int i=0;i<1;i++){
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
    public void mostrarSalones(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Salon");
            CallableStatement cst = con.prepareCall("{call usp_ListarSalonesCiclo(?)}");
            cst.setString(1,String.valueOf(tblCiclo.getValueAt(tblCiclo.getSelectedRow(),0)));
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[1];
                for(int i=0;i<1;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tblSalon.setModel(Salones);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void mostrarDatos(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Costo");
            Salones.addColumn("Matricula");
            Salones.addColumn("Ciclo");
            Salones.addColumn("Fecha de Inicio");
            Salones.addColumn("Fecha de Termino");
            CallableStatement cst = con.prepareCall("{call usp_ListarCicloAcademico}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[6];
                for(int i=0;i<6;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tblCiclo.setModel(Salones);
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
            java.util.logging.Logger.getLogger(Listado_Salones_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Salones_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Salones_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Salones_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Salones_Ciclo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCiclo;
    private javax.swing.JTable tblSalon;
    // End of variables declaration//GEN-END:variables
}
