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
public class Listado_Ciclos extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Listado_Ciclos() {
        initComponents();
        this.setTitle("Listado de Ciclos");
        try {
            FileWriter f = new FileWriter("ExcelCiclos.txt");
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
        DefaultTableModel Ciclos = new DefaultTableModel();
        Ciclos.addColumn("Codigo");
       Ciclos.addColumn("Pago");
       Ciclos.addColumn("Matricula");
       Ciclos.addColumn("Ciclo");
       Ciclos.addColumn("Fecha Inic.");
       Ciclos.addColumn("Fecha Fin");
       this.tblCiclos.setModel(Ciclos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        btnListado = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiclos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoCiclos.png"))); // NOI18N
        jLabel1.setBounds(110, 20, 380, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnListado.setText("Guardar Registro");
        btnListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoActionPerformed(evt);
            }
        });
        btnListado.setBounds(320, 140, 130, 50);
        jLayeredPane1.add(btnListado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(470, 140, 90, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servicio:");
        jLabel2.setBounds(60, 150, 70, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria" }));
        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });
        cbxServicio.setBounds(130, 150, 97, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCiclos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Ciclo", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCiclos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCiclos);
        tblCiclos.getColumnModel().getColumn(0).setResizable(false);
        tblCiclos.getColumnModel().getColumn(1).setResizable(false);
        tblCiclos.getColumnModel().getColumn(2).setResizable(false);

        jScrollPane1.setBounds(60, 250, 500, 190);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/17.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 610, 500);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoActionPerformed
        validateDir("D:\\Registros",true);
        switch(cbxServicio.getSelectedIndex()){
            case 1:try {
                        FileWriter f = new FileWriter("ExcelCiclos.txt");
                        PrintWriter p = new PrintWriter(f);
                        p.println("Codigo,Pago por Ciclo,Pago por Matricula,Nombre del Ciclo,Fecha de Inicio,Fecha de Termino");
                        p.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        CallableStatement cst = con.prepareCall("{call usp_ListarCicloAcademico}");
                        ResultSet r=cst.executeQuery();
                        int i=0;
                        while(r.next()){
                            Object dato[] = new Object[6];
                            for(i=0;i<6;i++){
                                dato[i]=r.getString(i+1);
                            }
                            try {
                                FileWriter f = new FileWriter("ExcelCiclos.txt",true);
                                PrintWriter p = new PrintWriter(f);
                                p.println(dato[0]+","+dato[1]+","+dato[2]+","+dato[3]+","+dato[4]+","+dato[5]+",");
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
                        FileReader m = new FileReader("ExcelCiclos.txt");
                        BufferedReader b = new BufferedReader(m);
                        while((linea=b.readLine())!=null){
                            crearfila(i,hoja,linea,6);
                            i++;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\ListadoCiclos.xls");
                        libro.write(elFichero);
                        elFichero.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                        e.printStackTrace();
                    }
                    try {
                        Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\ListadoCiclos.xls");
                    }   
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
                    }break;
            case 2: try {
                        FileWriter f = new FileWriter("ExcelCiclos.txt");
                        PrintWriter p = new PrintWriter(f);
                        p.println("Codigo,Pago,Nivel Academico");
                        p.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        CallableStatement cst = con.prepareCall("{call usp_ListarAsesoria}");
                        ResultSet r=cst.executeQuery();
                        int i=0;
                        while(r.next()){
                            Object dato[] = new Object[3];
                            for(i=0;i<3;i++){
                                dato[i]=r.getString(i+1);
                            }
                            try {
                                FileWriter f = new FileWriter("ExcelCiclos.txt",true);
                                PrintWriter p = new PrintWriter(f);
                                p.println(dato[0]+","+dato[1]+","+dato[2]+",");
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
                    HSSFWorkbook libro1 = new HSSFWorkbook();
                    HSSFSheet hoja1 = libro1.createSheet("Hoja 1");
                    try {
                        String linea;
                        int i=0;
                        FileReader m = new FileReader("ExcelCiclos.txt");
                        BufferedReader b = new BufferedReader(m);
                        while((linea=b.readLine())!=null){
                            crearfila(i,hoja1,linea,3);
                            i++;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\ListadoAsesorias.xls");
                        libro1.write(elFichero);
                        elFichero.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                        e.printStackTrace();
                    }
                    try {
                        Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\ListadoAsesorias.xls");
                    }   
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
                    }break;
        }
    }//GEN-LAST:event_btnListadoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
        DefaultTableModel Ciclos = new DefaultTableModel();
        switch(cbxServicio.getSelectedIndex()){
            case 1:Ciclos.addColumn("Codigo");
                   Ciclos.addColumn("Pago");
                   Ciclos.addColumn("Matricula");
                   Ciclos.addColumn("Ciclo");
                   Ciclos.addColumn("Fecha Inic.");
                   Ciclos.addColumn("Fecha Fin");
                   mostrarCiclos();break;
            case 2:Ciclos.addColumn("Codigo");
                   Ciclos.addColumn("Pago");
                   Ciclos.addColumn("Nivel Academico");
                   mostrarAsesorias();break;
        }
        this.tblCiclos.setModel(Ciclos);
    }//GEN-LAST:event_cbxServicioItemStateChanged
    public void mostrarCiclos(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Costo");
            Salones.addColumn("Matricula");
            Salones.addColumn("Asesoria");
            Salones.addColumn("Fecha de Inicio");
            Salones.addColumn("Fecha de Termino");
            int tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarCicloAcademico}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[6];
                for(int i=0;i<6;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Salones.addRow(dato);
            }
            this.tblCiclos.setModel(Salones);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void mostrarAsesorias(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Costo");
            Salones.addColumn("Nivel Academico");
            int tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarAsesoria}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Salones.addRow(dato);
            }
            this.tblCiclos.setModel(Salones);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void crearfila(int f,HSSFSheet hoja,String linea,int j){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,",");
       for(int i=0;i<j;i++){
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
            java.util.logging.Logger.getLogger(Listado_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Ciclos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Ciclos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListado;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCiclos;
    // End of variables declaration//GEN-END:variables
}
