package academia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.StringTokenizer;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
public class Agenda_Control extends javax.swing.JFrame {
Calendar c = Calendar.getInstance();
String D,M,A;
String archivo;
private static FileNameExtensionFilter filter = new FileNameExtensionFilter("Documentos de Word(.doc .docx)", new String[] { "DOC", "DOCX" });
    public Agenda_Control() {
        initComponents();
        this.setTitle("Agenda de Control");
        this.setLocationRelativeTo(this);
        D=Integer.toString(c.get(Calendar.DATE));
        M=Integer.toString(c.get(Calendar.MONTH)+1);
        A=Integer.toString(c.get(Calendar.YEAR));
        txtFecha1.setText(D);
        txtFecha2.setText(M);
        txtFecha3.setText(A);
        txtDocumento.requestFocus();
        validateDir("D:\\Agenda de Control",true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filechooser = new javax.swing.JFileChooser();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        txtFecha3 = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDocumento = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/salir.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(450, 80, 50, 60);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha3.setBounds(160, 110, 40, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha2.setBounds(100, 110, 30, 30);
        jLayeredPane1.add(txtFecha2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mes:");
        jLabel1.setBounds(70, 110, 30, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDocumento.setColumns(20);
        txtDocumento.setRows(5);
        jScrollPane1.setViewportView(txtDocumento);

        jScrollPane1.setBounds(30, 160, 570, 320);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Guardar2.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(350, 100, 40, 40);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Año:");
        jLabel2.setBounds(130, 110, 30, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Agregar Fecha");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(210, 110, 110, 30);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dia:");
        jLabel3.setBounds(10, 110, 30, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtFecha1.setBounds(40, 110, 30, 30);
        jLayeredPane1.add(txtFecha1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/44.jpg"))); // NOI18N
        jLabel4.setBounds(0, 0, 640, 520);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Agenda_control.png"))); // NOI18N
        jLabel5.setBounds(50, 20, 540, 70);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Guardar Documento");
        jLabel6.setBounds(320, 140, 130, 14);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Salir");
        jLabel7.setBounds(460, 140, 41, 14);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DRAG_LAYER);

        jButton4.setText("Ver Docs");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(520, 100, 80, 40);
        jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        validateDir("D:\\Agenda de Control",true);
        File f = new File("D:\\Agenda de Control\\Agenda-"+M+"-"+A+".docx");
         XWPFDocument doc = null;
        if(f.exists()){
            try {
                try {
                    doc = new XWPFDocument(new FileInputStream("D:\\Agenda de Control\\Agenda-"+M+"-"+A+".docx"));
                } catch (IOException ex) {
                    Logger.getLogger(Agenda_Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex){
                Logger.getLogger(Agenda_Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        else{
            doc = new XWPFDocument();
        }
        try {
            String texto=txtDocumento.getText();
            StringTokenizer t = new StringTokenizer(texto,"\n");
            int c=t.countTokens();
            for(int i=1;i<=c;i++){
                crearParrafos(doc,t.nextToken());
            }
            try {
                FileOutputStream elFichero = new FileOutputStream("D:\\Agenda de Control\\Agenda-"+M+"-"+A+".docx");
                doc.write(elFichero);
                elFichero.close();
                JOptionPane.showMessageDialog(this,"Se guardo Correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,"ERROR EN LEER");
                e.printStackTrace();
            }
        } catch (Exception ex) {
            Logger.getLogger(Agenda_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String texto;         if (recorrer(txtFecha1.getText()) && recorrer(txtFecha2.getText()) && recorrer(txtFecha3.getText())) {             texto = txtDocumento.getText();             if (!recorrer(texto)) {                 texto = txtFecha1.getText() + "-" + txtFecha2.getText() + "-" + txtFecha3.getText() + "\n";             } else {                 texto = texto + "\n" + txtFecha1.getText() + "-" + txtFecha2.getText() + "-" + txtFecha3.getText() + "\n";             }             txtDocumento.setText(texto);             txtDocumento.requestFocus();         } else {             JOptionPane.showMessageDialog(this, "Ingrese una Fecha", "ERROR", JOptionPane.ERROR_MESSAGE);         }     }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       validateDir("D:\\Agenda de Control\\",true);
        try {
            Runtime r = Runtime.getRuntime();
	    Process p = null;
            p = r.exec("explorer.exe "+"D:\\Agenda de Control");
        }   
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede abrir la carpeta problablemente fue borrada","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    public void crearParrafos(XWPFDocument doc,String texto){
        XWPFParagraph p = doc.createParagraph();
        XWPFRun r = p.createRun();
        System.out.println(texto);
        r.setText(texto);
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
            java.util.logging.Logger.getLogger(Agenda_Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda_Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda_Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda_Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Agenda_Control().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser filechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDocumento;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JFileChooser getFilechooser() {
        return filechooser;
    }

    public void setFilechooser(javax.swing.JFileChooser filechooser) {
        this.filechooser = filechooser;
    }
}
