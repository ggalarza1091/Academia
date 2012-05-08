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
public class Listado_Curso_Docente extends javax.swing.JFrame {
Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    public Listado_Curso_Docente() {
        initComponents();
        this.setTitle("Listado de Cursos por Docentes");
         this.setIconImage(icono);
         try {
            FileWriter f = new FileWriter("ExcelDocenteCursos.txt");
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
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox();
        txtServicio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(100, 210, 70, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo:");
        jLabel1.setBounds(50, 210, 50, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Academia", "Asesoria" }));
        cbxServicio.setBounds(260, 170, 100, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(260, 210, 100, 30);
        jLayeredPane1.add(txtServicio, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(380, 210, 100, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Servicio:");
        jLabel8.setBounds(200, 210, 60, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DRAG_LAYER);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Curso", "Fecha Inicio", "Fecha Fin"
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

        jScrollPane1.setBounds(50, 270, 550, 190);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(500, 200, 100, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Ver y Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(500, 150, 99, 40);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoCursosDocente.png"))); // NOI18N
        jLabel2.setBounds(40, 20, 570, 60);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/52.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 640, 500);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(500, 93, 100, 40);
        jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        switch (cbxServicio.getSelectedIndex()) {             case 0:                 JOptionPane.showMessageDialog(this, "Seleccione Academia o Asesoria", "ERROR", JOptionPane.ERROR_MESSAGE);                 break;             case 1:                 Seleccionar_Ciclo x = new Seleccionar_Ciclo();                 x.setVisible(true);                 break;             case 2:                 Seleccionar_Asesoria y = new Seleccionar_Asesoria();                 y.setVisible(true);                 break;         }     }//GEN-LAST:event_jButton1ActionPerformed

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
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(verificar2()){
            mostrarDatos();
        }
        else{
            JOptionPane.showMessageDialog(this,"Campos mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if(recorrer(txtCodigo.getText())&&recorrer(txtServicio.getText())){
            validateDir("D:\\Registros\\Listado\\Docente"+txtCodigo.getText(),true);
            Object dato[];
            String codigo=txtCodigo.getText();
            String servicio=txtServicio.getText();
            try {
                FileWriter f = new FileWriter("ExcelDocenteCursos.txt");
                PrintWriter p = new PrintWriter(f);
                p.println("Codigo del Curso=Nombre del Curso=Fecha de Inicio=Fecha de Termino=");
                p.close();
            } catch (IOException ex) {}
            try {
                CallableStatement cst = con.prepareCall("{call usp_ListarProfesorCursosServ(?,?)}");
                cst.setString(1, codigo);
                cst.setString(2, servicio);
                ResultSet r=cst.executeQuery();
                while(r.next()){
                    dato = new Object[4];
                    for(int i=0;i<4;i++){
                        dato[i]=r.getString(i+1);
                    }
                    try {
                        FileWriter f = new FileWriter("ExcelDocenteCursos.txt",true);
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
                FileReader m = new FileReader("ExcelDocenteCursos.txt");
                BufferedReader b = new BufferedReader(m);
                while((linea=b.readLine())!=null){
                    crearfila(i,hoja,linea);
                    i++;
                }
            } catch (IOException ex) {
                Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\Listado\\Docente"+txtCodigo.getText()+"\\CursosDocenteDictando.xls");
                libro.write(elFichero);
                elFichero.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                e.printStackTrace();
            }
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\Listado\\Docente"+txtCodigo.getText()+"\\CursosDocenteDictando.xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
         }
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
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
public boolean verificar2(){
    boolean v=true;
    v=v&recorrer(txtCodigo.getText());
    v=v&recorrer(txtServicio.getText());
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
     DefaultTableModel Curso = new DefaultTableModel();
        try {
            Curso.addColumn("Codigo Curso");
            Curso.addColumn("Curso");
            Curso.addColumn("Fecha Inicio");
            Curso.addColumn("Fecha Fin");
            String codigo=txtCodigo.getText();
            String servicio=txtServicio.getText();
            CallableStatement cst = con.prepareCall("{call usp_ListarProfesorCursosServ(?,?)}");
            cst.setString(1, codigo);
            cst.setString(2, servicio);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[4];
                for(int i=0;i<4;i++){
                    dato[i]=r.getString(i+1);
                }
            Curso.addRow(dato);
            }
            this.tabla.setModel(Curso);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Listado_Curso_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Curso_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Curso_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Curso_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Curso_Docente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
