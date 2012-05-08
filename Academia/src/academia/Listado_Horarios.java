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
public class Listado_Horarios extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Listado_Horarios() {
        initComponents();
        this.setTitle("Listado de Horarios");
        try {
            FileWriter f = new FileWriter("ExcelHorarios.txt");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dia", "Curso", "Hora Inicio", "Hora Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHorario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHorario);
        tblHorario.getColumnModel().getColumn(0).setResizable(false);
        tblHorario.getColumnModel().getColumn(1).setResizable(false);
        tblHorario.getColumnModel().getColumn(2).setResizable(false);
        tblHorario.getColumnModel().getColumn(3).setResizable(false);

        jScrollPane1.setBounds(30, 210, 670, 240);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo del Ciclo:");
        jLabel1.setBounds(20, 160, 100, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(120, 160, 100, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoHorarios.png"))); // NOI18N
        jLabel2.setBounds(150, 10, 440, 60);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(250, 160, 80, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(620, 160, 73, 30);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Guardar Registro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(440, 160, 130, 30);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/75.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 730, 480);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char caracter = evt.getKeyChar();
          if(((caracter < '0') ||(caracter > '9'))&&((caracter < 'a') ||(caracter > 'z'))&&((caracter < 'A') ||(caracter > 'Z'))){
              evt.consume();
          }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        if(txtCodigo.getText().length()>5){
             txtCodigo.setText(txtCodigo.getText().substring(0, 5));
        }
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(recorrer(txtCodigo.getText())){
            buscar();
        }
        else{
            JOptionPane.showMessageDialog(this,"Ingrese un codigo de un ciclo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(recorrer(txtCodigo.getText())){
            validateDir("D:\\Horarios",true);
            Object dato[];
            String codigo = txtCodigo.getText();
            try {
                FileWriter f = new FileWriter("ExcelHorarios.txt");
                PrintWriter p = new PrintWriter(f);
                p.println("Dia=Curso=Hora de Inicio=Hora de Termino=");
                p.close();
            } catch (IOException ex) {}
            try {
                CallableStatement cst = con.prepareCall("{call usp_HorarioCicloAcademico(?)}");
                cst.setString(1,codigo);
                ResultSet r=cst.executeQuery();
                while(r.next()){
                    dato = new Object[4];
                    for(int i=0;i<4;i++){
                        dato[i]=r.getString(i+1);
                    }
                    try {
                        FileWriter f = new FileWriter("ExcelHorarios.txt",true);
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
                FileReader m = new FileReader("ExcelHorarios.txt");
                BufferedReader b = new BufferedReader(m);
                while((linea=b.readLine())!=null){
                    crearfila(i,hoja,linea);
                    i++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                FileOutputStream elFichero = new FileOutputStream("D:\\Horarios\\Horario-"+codigo+".xls");
                libro.write(elFichero);
                elFichero.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                e.printStackTrace();
            }
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Horarios\\Horario-"+codigo+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Ingrese un codigo de un ciclo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
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
    public void buscar(){
        DefaultTableModel Cursos = new DefaultTableModel();
        Cursos.addColumn("Dia");
        Cursos.addColumn("Curso");
        Cursos.addColumn("Hora Inicio");
        Cursos.addColumn("Hora Termino");
            try {
                String codigo= txtCodigo.getText();
                CallableStatement cst = con.prepareCall("{call usp_HorarioCicloAcademico(?)}");
                cst.setString(1,codigo);
                ResultSet r=cst.executeQuery();
                outerloop:
                    while(r.next()){
                        Object dato[] = new Object[4];
                        for(int i=0;i<4;i++){
                            dato[i]=r.getString(i+1);
                        }
                        Cursos.addRow(dato);
                    }
                r.close();
                cst.close();
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al mostrar los Horarios","Error",JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.tblHorario.setModel(Cursos);
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
            java.util.logging.Logger.getLogger(Listado_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Horarios().setVisible(true);
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
    private javax.swing.JTable tblHorario;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
