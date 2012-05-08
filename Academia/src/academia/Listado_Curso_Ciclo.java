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
public class Listado_Curso_Ciclo extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Listado_Curso_Ciclo() {
        initComponents();
        this.setTitle("Listado de Cursos por Ciclo");
        try {
            FileWriter f = new FileWriter("ExcelCiclosCursos.txt");
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
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCiclo = new javax.swing.JTable();
        cbxServicio = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoCursosCiclo1.png"))); // NOI18N
        jLabel1.setBounds(220, 10, 370, 100);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Guardar Registro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(420, 120, 130, 50);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(570, 120, 100, 50);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCursos);
        tblCursos.getColumnModel().getColumn(0).setResizable(false);
        tblCursos.getColumnModel().getColumn(1).setResizable(false);

        jScrollPane1.setBounds(440, 230, 240, 200);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblCiclo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Ciclo", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jScrollPane2.setBounds(30, 230, 370, 200);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria" }));
        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });
        cbxServicio.setBounds(120, 130, 120, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Servicio:");
        jLabel2.setBounds(50, 130, 60, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/18.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 720, 480);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCicloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCicloMousePressed
        if(tblCiclo.getSelectedRow()!=-1){
            mostrarCursos();
        }
    }//GEN-LAST:event_tblCicloMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(tblCiclo.getSelectedRow()!=-1&&cbxServicio.getSelectedIndex()!=0){
        String codigo = String.valueOf(tblCiclo.getValueAt(tblCiclo.getSelectedRow(),0));
        validateDir("D:\\Registros\\Ciclos_Cursos",true);
        try {
            FileWriter f = new FileWriter("ExcelCiclosCursos.txt");
            PrintWriter p = new PrintWriter(f);
            p.println("Codigo,Curso,");
            p.close();
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            CallableStatement cst = con.prepareCall("{call usp_ListarCicloCurso(?)}");
            cst.setString(1,codigo);
            ResultSet r=cst.executeQuery();
            int i=0;
            while(r.next()){
                Object dato[] = new Object[2];
                for(i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                }
                try {
                    FileWriter f = new FileWriter("ExcelCiclosCursos.txt",true);
                    PrintWriter p = new PrintWriter(f);
                    p.println(dato[0]+","+dato[1]+",");
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
            FileReader m = new FileReader("ExcelCiclosCursos.txt");
            BufferedReader b = new BufferedReader(m);
            while((linea=b.readLine())!=null){
                crearfila(i,hoja,linea,6);
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\Ciclos_Cursos\\"+codigo+"-Cursos.xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR EN LEER");
            e.printStackTrace();
        }
        try {
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\Ciclos_Cursos\\"+codigo+"-Cursos.xls");
        }   
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
        }
      }
      else{
          JOptionPane.showMessageDialog(this,"Seleccione una fila de la tabla ciclos", "ERROR",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
        switch(cbxServicio.getSelectedIndex()){
            case 1:mostrarCiclos();break;
            case 2:mostrarAsesorias();break;
        }
    }//GEN-LAST:event_cbxServicioItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    public void crearfila(int f,HSSFSheet hoja,String linea,int j){
       HSSFRow fila = hoja.createRow(f);
       StringTokenizer t = new StringTokenizer(linea,",");
       for(int i=0;i<2;i++){
           crearcelda(i,fila,String.valueOf(t.nextToken()));
       }
    }
    public void crearcelda(int i,HSSFRow f,String txt){
        HSSFCell celda = f.createCell(i);
        celda.setCellValue(txt);
    }
    public void mostrarAsesorias(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Pago");
            Salones.addColumn("Nivel Academico");
            CallableStatement cst = con.prepareCall("{call usp_ListarAsesoria}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
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
    public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action)
            file.mkdirs();
        return isDirectory;
    }
    public void mostrarCursos(){
         DefaultTableModel Curso = new DefaultTableModel();
        try {
                Curso.addColumn("Codigo");
                Curso.addColumn("Curso");
            int tabla=0;
            String codigo = String.valueOf(tblCiclo.getValueAt(tblCiclo.getSelectedRow(),0));
            CallableStatement cst = con.prepareCall("{call usp_ListarCicloCurso(?)}");
            cst.setString(1,codigo);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[2];
                for(int i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
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
    public void mostrarCiclos(){
        DefaultTableModel Salones = new DefaultTableModel();
        try {
            Salones.addColumn("Codigo");
            Salones.addColumn("Pago");
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
            java.util.logging.Logger.getLogger(Listado_Curso_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Curso_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Curso_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Curso_Ciclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Curso_Ciclo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCiclo;
    private javax.swing.JTable tblCursos;
    // End of variables declaration//GEN-END:variables
}
