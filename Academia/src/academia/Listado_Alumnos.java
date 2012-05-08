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
public class Listado_Alumnos extends javax.swing.JFrame {
    Calendar c = Calendar.getInstance();
    String D,M,A;
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int cantidad;
    public Listado_Alumnos() {
        initComponents();
        this.setTitle("Listado de Alumnos");
        try {
            FileWriter f = new FileWriter("ExcelAlumnos.txt");
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
        jLabel1 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        btnListado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiclo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        cbxServicio = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoAlumnos.png"))); // NOI18N
        jLabel1.setBounds(20, 20, 410, 50);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(120, 170, 100, 30);
        jLayeredPane1.add(txtServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnListado.setText("Ver Listado");
        btnListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoActionPerformed(evt);
            }
        });
        btnListado.setBounds(40, 260, 100, 50);
        jLayeredPane1.add(btnListado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCiclo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Pago", "Matricula ", "Nombre", "Fecha Inic.", "Fecha Fin"
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
        jScrollPane1.setViewportView(tblCiclo);
        tblCiclo.getColumnModel().getColumn(0).setResizable(false);
        tblCiclo.getColumnModel().getColumn(1).setResizable(false);
        tblCiclo.getColumnModel().getColumn(2).setResizable(false);
        tblCiclo.getColumnModel().getColumn(3).setResizable(false);
        tblCiclo.getColumnModel().getColumn(4).setResizable(false);
        tblCiclo.getColumnModel().getColumn(5).setResizable(false);

        jScrollPane1.setBounds(260, 120, 480, 190);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Servicio:");
        jLabel2.setBounds(50, 120, 60, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(160, 330, 100, 50);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria" }));
        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });
        cbxServicio.setBounds(120, 120, 100, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/16.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 810, 430);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoActionPerformed
        validateDir("D:\\Registros\\Listado_Alumnos",true);
        Object dato[];
        String codigo=txtServicio.getText();
        try {
            FileWriter f = new FileWriter("ExcelAlumnos.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Codigo=Nombre=Apellido Materno=Apellido Paterno=Direccion=Telefono=Correo=Fecha de Nacimiento=Nombre de Apoderado=Grupo Sanguineo=Nivel Academico=Direccion de Foto=Observacion=");
            p.close();
        } catch (IOException ex) {}
        try {
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumnosPorCiclo2(?)}");
            cst.setString(1, codigo);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                dato = new Object[13];
                for(int i=0;i<13;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelAlumnos.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+"="+dato[1]+"="+dato[2]+"="+dato[3]+"="+dato[4]+"="+dato[5]+"="+dato[6]+"="+dato[7]+"="+dato[8]+"="+dato[9]+"="+dato[10]+"="+dato[11]+"="+dato[12]+"=");
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
            FileReader m = new FileReader("ExcelAlumnos.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\Listado_Alumnos\\"+codigo+"-Alumnos.xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        try {
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\Listado_Alumnos\\"+codigo+"-Alumnos.xls");
        }   
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnListadoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
        switch(cbxServicio.getSelectedIndex()){
            case 0:break;
            case 1:mostrarCiclos();break;
            case 2:mostrarAsesorias();break;
        }
    }//GEN-LAST:event_cbxServicioItemStateChanged

    private void tblCicloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCicloMousePressed
        if(tblCiclo.getSelectedRow()!=-1){
            txtServicio.setText(String.valueOf(tblCiclo.getValueAt(tblCiclo.getSelectedRow(),0)));
        }
    }//GEN-LAST:event_tblCicloMousePressed
    public void crearfila(int f,HSSFSheet hoja,String linea){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,"=");
       for(int i=0;i<13;i++){
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
            this.tblCiclo.setModel(Salones);
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
            Salones.addColumn("Matricula");
            Salones.addColumn("Nivel Academico");
            CallableStatement cst = con.prepareCall("{call usp_ListarAsesoria}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tblCiclo.setModel(Salones);
            r.close();
            cst.close();
        } catch (Exception ex){
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
            java.util.logging.Logger.getLogger(Listado_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Alumnos().setVisible(true);
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
    private javax.swing.JTable tblCiclo;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
