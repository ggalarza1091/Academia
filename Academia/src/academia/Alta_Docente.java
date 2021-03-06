package academia;
import java.awt.Image;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Alta_Docente extends javax.swing.JFrame {
 Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    Calendar c = Calendar.getInstance();
    String A,D,M;
    public Alta_Docente() {
        initComponents();
        this.setTitle("Dar Alta - Docente");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        D=Integer.toString(c.get(Calendar.DATE));
        M=Integer.toString(c.get(Calendar.MONTH)+1);
        A=Integer.toString(c.get(Calendar.YEAR));
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlta = new javax.swing.JTable();
        cbxMes = new javax.swing.JComboBox();
        txtAno = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Fecha de Ingreso:");
        jLabel1.setBounds(30, 130, 110, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblAlta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido Pat.", "Apellido Mat", "Fecha Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAlta);
        tblAlta.getColumnModel().getColumn(0).setResizable(false);
        tblAlta.getColumnModel().getColumn(1).setResizable(false);
        tblAlta.getColumnModel().getColumn(2).setResizable(false);
        tblAlta.getColumnModel().getColumn(3).setResizable(false);
        tblAlta.getColumnModel().getColumn(4).setResizable(false);

        jScrollPane1.setBounds(30, 210, 620, 180);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbxMes.setBounds(140, 130, 110, 30);
        jLayeredPane1.add(cbxMes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoKeyTyped(evt);
            }
        });
        txtAno.setBounds(260, 130, 80, 30);
        jLayeredPane1.add(txtAno, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.setBounds(350, 130, 65, 30);
        jLayeredPane1.add(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAlta.setText("Dar de Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });
        btnAlta.setBounds(460, 130, 87, 40);
        jLayeredPane1.add(btnAlta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(570, 130, 80, 40);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/AltaDocente.png"))); // NOI18N
        jLabel2.setBounds(130, 10, 420, 70);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/3.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 680, 510);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        if(tblAlta.getSelectedRow()!=-1){
            modificarDocente();
       }
       else{
           JOptionPane.showMessageDialog(this,"Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(verificar()){
            buscarDatos();
       }
       else{
           JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtAnoKeyTyped

    private void txtAnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyReleased
        if(txtAno.getText().length()>3){
             txtAno.setText(txtAno.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtAnoKeyReleased
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9'))
            evt.consume();
    }
    public void modificarDocente(){
        String codigo = null,nombre= null,apelpat= null,apelmat= null,direccion= null,celular= null,correo= null,metodopago= null,fechanac= null,pagoacademia= null,pagoasesoria= null,rucoefectivo= null,fechaingreso= null;
        try{
            CallableStatement cst1 = con.prepareCall("{call usp_ListaProfesorInactivos}");
            ResultSet m=cst1.executeQuery();
            outerloop:
                while(m.next()){
                    Object dato[] = new Object[14];
                    if(String.valueOf(m.getString(1)).equalsIgnoreCase(String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),0)))){
                        for(int i=0;i<14;i++){
                            if(i==0){
                                dato[i]=String.valueOf(tblAlta.getValueAt(tblAlta.getSelectedRow(),0));
                            }
                            else{
                                dato[i]=m.getString(i+1);
                            }
                        }
                        codigo = String.valueOf(dato[0]);
                        nombre = String.valueOf(dato[1]);
                        apelpat= String.valueOf(dato[2]);
                        apelmat= String.valueOf(dato[3]);
                        direccion= String.valueOf(dato[4]);
                        celular= String.valueOf(dato[5]);
                        correo= String.valueOf(dato[6]);
                        metodopago=String.valueOf(dato[7]);
                        if(metodopago.equalsIgnoreCase("E")){
                            rucoefectivo=null;
                        }
                        else{
                            rucoefectivo=String.valueOf(dato[10]);
                        }
                        fechanac= String.valueOf(dato[11]).substring(6,10)+"-"+String.valueOf(dato[11]).substring(3,5)+"-"+String.valueOf(dato[11]).substring(0,2);
                        pagoacademia = String.valueOf(dato[12]);
                        pagoasesoria = String.valueOf(dato[13]);
                        fechaingreso=A+"-"+M+"-"+D;
                        break outerloop;
                    }
                }
            m.close();
            cst1.close();
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
        try{
                CallableStatement cst = con.prepareCall("{call usp_ActualizarColaboradorFuncional(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst.setString(1,codigo);
                System.out.println(codigo);
                cst.setBoolean(2,true);
                cst.setString(3,null);
                cst.setString(4,nombre);
                System.out.println(nombre);
                cst.setString(5,apelpat);
                System.out.println(apelpat);
                cst.setString(6,apelmat);
                System.out.println(apelmat);
                cst.setString(7,direccion);
                System.out.println(direccion);
                cst.setString(8,celular);
                System.out.println(celular);
                cst.setString(9,correo);
                System.out.println(correo);
                cst.setString(10,metodopago);
                System.out.println(metodopago);
                cst.setString(11,fechaingreso);
                System.out.println(fechaingreso);
                cst.setString(12,rucoefectivo);
                System.out.println(rucoefectivo);
                cst.setString(13,fechanac);
                System.out.println(fechanac);
                cst.setString(14,pagoacademia);
                System.out.println(pagoacademia);
                cst.setString(15,pagoasesoria);
                System.out.println(pagoasesoria);
                int rpta = cst.executeUpdate();
                if(rpta>=0){
                    JOptionPane.showMessageDialog(this,"Se ha reintegrado Correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
                cst.close();
                try {
                    FileWriter f = new FileWriter("AltaDocente.txt");
                    PrintWriter p = new PrintWriter(f);
                    p.println("true,"+codigo+",");
                } catch (IOException ex) {
                    Logger.getLogger(Alta_Alumno.class.getName()).log(Level.SEVERE, null, ex);
                }
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"ERROR AL REGISTRAR","ERROR",JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Academia.class.getName()).log(Level.SEVERE, null, ex);}
    }
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
    public void mostrarDatos(){
        DefaultTableModel alta = new DefaultTableModel();
        try {
                alta.addColumn("Codigo");
                alta.addColumn("Nombre");
                alta.addColumn("Apellido Pat");
                alta.addColumn("Apellido Mat");
                alta.addColumn("Fecha Salida");
            CallableStatement cst = con.prepareCall("{call usp_ListaProfesorInactivos}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[5];
                boolean v=false;
                int j=0;
                for(int i=0;i<14;i++){
                    if(i==0||i==1||i==2||i==3||i==8){
                        dato[j]=r.getString(i+1);
                        j++;
                    }
                }
                alta.addRow(dato);
            }
            this.tblAlta.setModel(alta);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarDatos(){
        DefaultTableModel alta = new DefaultTableModel();
        try {
                alta.addColumn("Codigo");
                alta.addColumn("Nombre");
                alta.addColumn("Apellido Pat");
                alta.addColumn("Apellido Mat");
                alta.addColumn("Fecha Salida");
            CallableStatement cst = con.prepareCall("{call usp_ListaProfesorInactivos}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[5]; 
                boolean v=false;
                int j=0;
                for(int i=0;i<14;i++){
                    if(i==0||i==1||i==2||i==3||i==8){
                        dato[j]=r.getString(i+1);
                        if(i==8){
                        String fecha= String.valueOf(dato[j]);
                            if(Integer.parseInt(fecha.substring(3,5))==obtenermes(String.valueOf(cbxMes.getSelectedItem()))){
                                if(Integer.parseInt(fecha.substring(6,10))==Integer.parseInt(txtAno.getText())){
                                    v=true;
                                    
                                }
                            }
                        }
                        j++;
                    }
                }
                if(v){
                    alta.addRow(dato);
                }
            }
            this.tblAlta.setModel(alta);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public boolean verificar(){
        boolean v=true;
        v=v&recorrer(txtAno.getText());
        if(cbxMes.getSelectedIndex()==0){
            v=false;
        }
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
     public int obtenermes(String mes){
        int m=0;
        if(mes.equalsIgnoreCase("Enero")){m=1;}
        if(mes.equalsIgnoreCase("Febrero")){m=2;}
        if(mes.equalsIgnoreCase("Marzo")){m=3;}
        if(mes.equalsIgnoreCase("Abril")){m=4;}
        if(mes.equalsIgnoreCase("Mayo")){m=5;}
        if(mes.equalsIgnoreCase("Junio")){m=6;}
        if(mes.equalsIgnoreCase("Julio")){m=7;}
        if(mes.equalsIgnoreCase("Agosto")){m=8;}
        if(mes.equalsIgnoreCase("Septiembre")){m=9;}
        if(mes.equalsIgnoreCase("Octubre")){m=10;}
        if(mes.equalsIgnoreCase("Noviembre")){m=11;}
        if(mes.equalsIgnoreCase("Diciembre")){m=12;}
        return m;
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
            java.util.logging.Logger.getLogger(Alta_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta_Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Alta_Docente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlta;
    private javax.swing.JTextField txtAno;
    // End of variables declaration//GEN-END:variables
}
