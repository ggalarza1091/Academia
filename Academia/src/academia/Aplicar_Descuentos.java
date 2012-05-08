package academia;
import java.awt.Image;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Aplicar_Descuentos extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    int tabla;
    String A,M,D;
    Calendar c = Calendar.getInstance();
    public Aplicar_Descuentos() {
        initComponents();
        this.setTitle("Aplicar Descuentos");
        this.setIconImage(icono);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        D=Integer.toString(c.get(Calendar.DATE));
        M=Integer.toString(c.get(Calendar.MONTH)+1);
        A=Integer.toString(c.get(Calendar.YEAR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDescuento = new javax.swing.JTable();
        txtDescuento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxArea = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtseleccionado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Descuentos.png"))); // NOI18N
        jLabel1.setBounds(120, 20, 380, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblDescuento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido Pat", "Apellido Mat", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDescuento.getTableHeader().setReorderingAllowed(false);
        tblDescuento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDescuentoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDescuento);
        tblDescuento.getColumnModel().getColumn(0).setResizable(false);
        tblDescuento.getColumnModel().getColumn(1).setResizable(false);
        tblDescuento.getColumnModel().getColumn(2).setResizable(false);
        tblDescuento.getColumnModel().getColumn(3).setResizable(false);
        tblDescuento.getColumnModel().getColumn(4).setResizable(false);

        jScrollPane1.setBounds(30, 190, 540, 140);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });
        txtDescuento.setBounds(150, 390, 100, 30);
        jLayeredPane1.add(txtDescuento, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setForeground(new java.awt.Color(191, 118, 6));
        jLabel6.setText("Descuento:");
        jLabel6.setBounds(30, 390, 90, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAceptar.setText("Aplicar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.setBounds(340, 120, 90, 40);
        jLayeredPane1.add(btnAceptar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.setBounds(470, 120, 90, 40);
        jLayeredPane1.add(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Docente", "Administrativo" }));
        cbxArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAreaItemStateChanged(evt);
            }
        });
        cbxArea.setBounds(120, 120, 120, 30);
        jLayeredPane1.add(cbxArea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setForeground(new java.awt.Color(191, 118, 6));
        jLabel3.setText("Area:");
        jLabel3.setBounds(40, 120, 60, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtseleccionado.setEditable(false);
        txtseleccionado.setBounds(150, 430, 100, 30);
        jLayeredPane1.add(txtseleccionado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setForeground(new java.awt.Color(191, 118, 6));
        jLabel4.setText("Codigo Seleccionado:");
        jLabel4.setBounds(10, 430, 140, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtMotivo.setColumns(20);
        txtMotivo.setRows(5);
        txtMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMotivoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtMotivo);

        jScrollPane2.setBounds(330, 380, 240, 100);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(191, 118, 6));
        jLabel2.setText("Motivo:");
        jLabel2.setBounds(280, 390, 60, 20);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/4.jpg"))); // NOI18N
        jLabel5.setBounds(0, 0, 600, 530);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(verificar()){
            aplicardescuento();
        }
        else{
        JOptionPane.showMessageDialog(this,"Campos Vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        tblDescuento.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAreaItemStateChanged
        switch(cbxArea.getSelectedIndex()){
            case 0:limpiar();break;
            case 1:listarDocentes();break;
            case 2:listarAdministrativos();break;
        }
    }//GEN-LAST:event_cbxAreaItemStateChanged

    private void tblDescuentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDescuentoMousePressed
        for(int i=0;i<tblDescuento.getRowCount();i++){
            if(tblDescuento.isRowSelected(i)){
                txtseleccionado.setText(String.valueOf(tblDescuento.getValueAt(tblDescuento.getSelectedRow(),0)));
            }
        }
    }//GEN-LAST:event_tblDescuentoMousePressed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
                char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9')){
            if(caracter<'.'||caracter>'.'){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtMotivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoKeyReleased
        if(txtMotivo.getText().length()>39){
              txtMotivo.setText(txtMotivo.getText().substring(0, 40));
        }
    }//GEN-LAST:event_txtMotivoKeyReleased

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
                int c=0;
        String texto=txtDescuento.getText();
        if(texto.length()!=0){
            for(int i=0;i<texto.length();i++){
                if(texto.charAt(i)=='.'){
                    c++;
                }
            }
            if(c==2){
                txtDescuento.setText(texto.substring(0,texto.length()-1));
            }
            if(c>2){
                for(int j=1;j<c;j++){
                    txtDescuento.setText(texto.substring(0,texto.length()-1));
                    texto=txtDescuento.getText();
                }
            }
            if(texto.charAt(0)=='.'){
                txtDescuento.setText("0"+texto);
            }
        }
    }//GEN-LAST:event_txtDescuentoKeyReleased
    public void limpiar(){
        DefaultTableModel asignacion = new DefaultTableModel();
        asignacion.addColumn("Codigo");
        asignacion.addColumn("Nombre");
        asignacion.addColumn("Apellido Pat");
        asignacion.addColumn("Apellido Mat");
        asignacion.addColumn("Pago Actual");
        this.tblDescuento.setModel(asignacion);
    }
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
    }
    public boolean verificar(){
        boolean verificacion=true;
        verificacion=verificacion&&recorrer(txtDescuento.getText());
        verificacion=verificacion&&recorrer(txtseleccionado.getText());
        if(cbxArea.getSelectedIndex()==0){
            verificacion=false;
        }
        return verificacion;
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
    public void aplicardescuento(){
        try{
            String A,D,M;
            D=Integer.toString(c.get(Calendar.DATE));
            M=Integer.toString(c.get(Calendar.MONTH)+1);
            A=Integer.toString(c.get(Calendar.YEAR));
            String codigocolaborador=txtseleccionado.getText();
            String motivo = txtMotivo.getText();
            Double monto=Double.parseDouble(txtDescuento.getText());
            String fecha=A+"-"+M+"-"+D;
            CallableStatement cst = con.prepareCall("{call usp_InsertarDescuentoCOlaborador(?,?,?,?,?)}");
            cst.setString(1,codigocolaborador);
            cst.setString(2,motivo);
            cst.setDouble(3,monto);
            cst.setString(4,fecha);
            cst.registerOutParameter(5, Types.CHAR);
            int rpta = cst.executeUpdate();
            String codigo=cst.getString(5);
            if(rpta==1){
                JOptionPane.showMessageDialog(this, "Registrado Correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void listarDocentes(){
        DefaultTableModel Docentes = new DefaultTableModel();
        try {
            Docentes.addColumn("Codigo");
            Docentes.addColumn("Nombre");
            Docentes.addColumn("Apellido Pat");
            Docentes.addColumn("Apellido Mat");
            Docentes.addColumn("Celular");
            tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListaProfesoresActivos}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[5];
                for(int i=0;i<5;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Docentes.addRow(dato);
            }
            this.tblDescuento.setModel(Docentes);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listarAdministrativos(){
        DefaultTableModel Administrativos = new DefaultTableModel();
        try {
            Administrativos.addColumn("Codigo");
            Administrativos.addColumn("Cargo");
            Administrativos.addColumn("Nombre");
            Administrativos.addColumn("Apellido Pat");
            Administrativos.addColumn("Apellido Mat");
            tabla=0;
            CallableStatement cst = con.prepareCall("{call usp_ListarFuncionalesActivos}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[5];
                for(int i=0;i<5;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla++;
            Administrativos.addRow(dato);
            }
            this.tblDescuento.setModel(Administrativos);
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
            java.util.logging.Logger.getLogger(Aplicar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicar_Descuentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Aplicar_Descuentos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbxArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDescuento;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextArea txtMotivo;
    private javax.swing.JTextField txtseleccionado;
    // End of variables declaration//GEN-END:variables
}
