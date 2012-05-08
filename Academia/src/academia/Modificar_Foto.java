package academia;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.sql.*;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.File;

public class Modificar_Foto extends javax.swing.JFrame {
private static FileNameExtensionFilter filter = new FileNameExtensionFilter(".jpg", new String[] { "JPG", "JPEG" });
ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
        Connection con;
    public Modificar_Foto() {
        initComponents();
        this.setIconImage(icono);
        this.setTitle("Modificar Foto");
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        }
        catch(Exception e){}
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        txtFoto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Codigo del Alumno:");
        jLabel1.setBounds(50, 110, 120, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(170, 110, 100, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );

        jPanel1.setBounds(40, 170, 230, 220);
        jLayeredPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFoto.setEditable(false);
        txtFoto.setBounds(300, 170, 290, 30);
        jLayeredPane1.add(txtFoto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnBuscar.setText("Buscar Foto");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.setBounds(310, 250, 120, 40);
        jLayeredPane1.add(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(450, 250, 110, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(310, 310, 120, 40);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarFoto.png"))); // NOI18N
        jLabel2.setBounds(130, 0, 400, 80);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/74.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 620, 440);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        File fileImagen = null;         
        getFileChooser().addChoosableFileFilter(filter);       
        int returnVal = getFileChooser().showOpenDialog(this);         
        if (returnVal == getFileChooser().APPROVE_OPTION) {
            fileImagen = getFileChooser().getSelectedFile();
        }
        if(returnVal==getFileChooser().APPROVE_OPTION){
            getTxtFoto().setText(fileImagen.toString());
        }
        if (fileImagen != null) {           
            cargarImagen(getjDesktopPane1(), fileImagen);    
        }   
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(recorrer(txtCodigo.getText())&&verificar()){   
            validateDir("D:\\FotosAlumnos", true);
            File f = new File("D:\\FotosAlumnos\\"+txtCodigo.getText()+".jpg");
            if(f.exists()){
                fileMove(borrarespacios(txtFoto.getText()),"D:\\FotosAlumnos\\"+txtCodigo.getText()+".jpg");
                System.out.println("EXISTE");
                JOptionPane.showMessageDialog(this,"Se ha modificado correctamente la foto","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                fileMove(borrarespacios(txtFoto.getText()),"D:\\FotosAlumnos\\"+txtCodigo.getText()+".jpg");
                System.out.println("NO EXISTE");
                JOptionPane.showMessageDialog(this,"Se ha modificado correctamente la foto","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            txtCodigo.setText("");
            txtFoto.setText("");
        }
       else{
           JOptionPane.showMessageDialog(this,"Ingrese codigo del alumno","ERROR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char caracter = evt.getKeyChar();
          if(((caracter < '0') ||(caracter > '9'))&&((caracter < 'a') ||(caracter > 'z'))&&((caracter < 'A') ||(caracter > 'Z'))){
              evt.consume();
          }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        if(txtCodigo.getText().length()>6){
             txtCodigo.setText(txtCodigo.getText().substring(0, 6));
        }
    }//GEN-LAST:event_txtCodigoKeyReleased
 public String borrarespacios(String c){
        String cadena=null;
        boolean pos = false;
        int posicion=0;
        outerloop:
            for(int i=c.length()-1;i>=0;i--){
                if(c.charAt(i)!=' '){
                    posicion=i+1;
                    pos=true;
                    break outerloop;
                }
            }
        if(pos)
            cadena=c.substring(0,posicion);
        else
            cadena=c;
        return cadena;
    }
    public static void fileMove(String sourceFile, String destinationFile) {
        System.out.println("Desde: " + sourceFile);
        System.out.println("Hacia: " + destinationFile);
        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);
            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.close();
            File file = new File(sourceFile);
            if (file.exists()) {
                file.delete();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"No se encuentra direccion","Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
 }
    public boolean verificar(){
     boolean v=false;
     try {
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumno}");
            ResultSet r=cst.executeQuery();
            outerloop:
                while(r.next()){
                    Object dato[] = new Object[13];
                    for(int i=0;i<13;i++){
                        dato[i]=r.getString(i+1);
                        if(borrarespacios(txtCodigo.getText()).equalsIgnoreCase(String.valueOf(dato[0]))){
                            v=true;
                            break outerloop;
                        }
                    }
                }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN EL PROCEDURE","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Listado_Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
     return v;
 }
    public  void cargarImagen(javax.swing.JDesktopPane jDeskp,File fileImagen){
        try{
            BufferedImage image = ImageIO.read(fileImagen);
            jDeskp.setBorder(new PintaImagen(image)); 
        }
        catch (Exception e){System.out.println("No cargo imagen, sorry");}
    }
 public static boolean validateDir(String path, boolean action) {
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (action)
            file.mkdirs();
        return isDirectory;
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
            java.util.logging.Logger.getLogger(Modificar_Foto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Foto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Foto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Foto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Foto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFoto;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JFileChooser getFileChooser() {
        return FileChooser;
    }

    public void setFileChooser(javax.swing.JFileChooser FileChooser) {
        this.FileChooser = FileChooser;
    }

    public javax.swing.JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(javax.swing.JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public javax.swing.JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(javax.swing.JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }

    public javax.swing.JTextField getTxtFoto() {
        return txtFoto;
    }

    public void setTxtFoto(javax.swing.JTextField txtFoto) {
        this.txtFoto = txtFoto;
    }
}
