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
public class Listado_Notas extends javax.swing.JFrame {
    Calendar c = Calendar.getInstance();
    String D,M,A;
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int cantidad;
    public Listado_Notas() {
        initComponents();
        this.setTitle("Listado de Notas");
        try {
            FileWriter f = new FileWriter("Notas.txt");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnListado = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo de Alumno:");
        jLabel2.setBounds(40, 190, 110, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ListadoNotas.png"))); // NOI18N
        jLabel1.setBounds(120, 40, 360, 80);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(160, 190, 120, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnListado.setText("Guardar Registro");
        btnListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoActionPerformed(evt);
            }
        });
        btnListado.setBounds(420, 280, 150, 40);
        jLayeredPane1.add(btnListado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(420, 350, 150, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnNotas.setText("Ver Notas");
        btnNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasActionPerformed(evt);
            }
        });
        btnNotas.setBounds(360, 190, 100, 40);
        jLayeredPane1.add(btnNotas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNotas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblNotas);
        tblNotas.getColumnModel().getColumn(0).setResizable(false);
        tblNotas.getColumnModel().getColumn(1).setResizable(false);

        jScrollPane1.setBounds(40, 260, 340, 160);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/20.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 600, 480);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoActionPerformed
        if(verificarCodigo()){
            validateDir("D:\\Registros\\Notas",true);
            Object dato[];
            CallableStatement cst;
            try {
                FileWriter f = new FileWriter("Notas.txt",true);
                PrintWriter p = new PrintWriter(f);
                p.println("Fecha de Evaluacion,Nota,");
                p.close();
            } catch (IOException ex) {
                Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                cst = con.prepareCall("{call usp_ListarNotasAlumno(?)}");
                cst.setString(1,txtCodigo.getText());
                ResultSet r=cst.executeQuery();
                while(r.next()){
                    dato = new Object[2];
                    for(int i=0;i<2;i++){
                        dato[i]=r.getString(i+1);
                    }
                    try {
                        FileWriter f = new FileWriter("Notas.txt",true);
                        PrintWriter p = new PrintWriter(f);
                        p.println(dato[0]+","+dato[1]+",");
                        p.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE");
                Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
            HSSFWorkbook libro = new HSSFWorkbook();
            HSSFSheet hoja = libro.createSheet();
                try {
                    String linea;
                    int i=0;
                    FileReader m = new FileReader("Notas.txt");
                    BufferedReader b = new BufferedReader(m);
                    while((linea=b.readLine())!=null){
                        crearfila(i,hoja,linea);
                        i++;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
                }

            try {
                FileOutputStream elFichero = new FileOutputStream("D:\\Registros\\Notas\\"+txtCodigo.getText()+".xls");
                libro.write(elFichero);
                elFichero.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                e.printStackTrace();
            }
            try {
                Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\Registros\\Notas\\"+txtCodigo.getText()+".xls");
            }   
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se puede abrir el archivo, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
             JOptionPane.showMessageDialog(null, "Ingrese un codigo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnListadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasActionPerformed
        if(verificarCodigo()){
            mostrarNotas();
        }
        else{
           JOptionPane.showMessageDialog(null, "Ingrese un codigo","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNotasActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        if(txtCodigo.getText().length()>6){
             txtCodigo.setText(txtCodigo.getText().substring(0,6));
        }
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char caracter = evt.getKeyChar();
          if(((caracter < '0') ||(caracter > '9'))&&((caracter < 'a') ||(caracter > 'z'))&&((caracter < 'A') ||(caracter > 'Z'))){
              evt.consume();
          }
    }//GEN-LAST:event_txtCodigoKeyTyped

    public void crearfila(int f,HSSFSheet hoja,String linea){
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
    public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action)
            file.mkdirs();
        return isDirectory;
    }
    public boolean verificarCodigo(){
        boolean v=true;
        v=v&recorrer(txtCodigo.getText());
        if(txtCodigo.getText().length()!=6){
             v=false;
        }
        return v;
    }
    public String ObtenerMes(int mes,int año){
        String mesobtenido="";
        switch(mes){
            case 0:mesobtenido="Enero ";break;
            case 1:mesobtenido="Febrero ";break;
            case 2:mesobtenido="Marzo ";break;
            case 3:mesobtenido="Abril ";break;
            case 4:mesobtenido="Mayo ";break;
            case 5:mesobtenido="Junio ";break;
            case 6:mesobtenido="Julio ";break;
            case 7:mesobtenido="Agosto ";break;
            case 8:mesobtenido="Septiembre ";break;
            case 9:mesobtenido="Octubre ";break;
            case 10:mesobtenido="Noviembre ";break;
            case 11:mesobtenido="Diciembre ";break;
        }
        mesobtenido+=String.valueOf(año);
        return mesobtenido;
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
    public void mostrarNotas(){
        DefaultTableModel notas = new DefaultTableModel();
        try {
            String codigo=txtCodigo.getText();
            notas.addColumn("Fecha");
            notas.addColumn("Nota");
            CallableStatement cst = con.prepareCall("{call usp_ListarNotasAlumno(?)}");
            cst.setString(1,codigo);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[2];
                for(int i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                }
                notas.addRow(dato);
            }
            this.tblNotas.setModel(notas);
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
            java.util.logging.Logger.getLogger(Listado_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Listado_Notas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListado;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNotas;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
