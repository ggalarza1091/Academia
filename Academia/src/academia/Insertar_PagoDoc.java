package academia;
import java.awt.Image;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Insertar_PagoDoc extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage(); 
    Calendar c = Calendar.getInstance();
    public Insertar_PagoDoc() {
        initComponents();
        this.setTitle("Pagar a Docentes");
        this.setIconImage(icono);
        String D=Integer.toString(c.get(Calendar.DATE));
        String M=Integer.toString(c.get(Calendar.MONTH)+1);
        String A=Integer.toString(c.get(Calendar.YEAR));
        txtRFechaP1.setText(D);
        txtRFechaP2.setText(M);
        txtRFechaP3.setText(A);
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
        txt2 = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        txt7 = new javax.swing.JTextField();
        txt8 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        lblRFechaP = new javax.swing.JLabel();
        txtRFechaP1 = new javax.swing.JTextField();
        txtRFechaP2 = new javax.swing.JTextField();
        txtRFechaP3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo:");
        jLabel1.setBounds(100, 110, 70, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt2.setEditable(false);
        txt2.setBounds(200, 290, 90, 30);
        jLayeredPane1.add(txt2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        txtCodigo.setBounds(160, 110, 90, 30);
        jLayeredPane1.add(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt4.setEditable(false);
        txt4.setBounds(440, 290, 90, 30);
        jLayeredPane1.add(txt4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt3.setEditable(false);
        txt3.setBounds(200, 210, 90, 30);
        jLayeredPane1.add(txt3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt1.setEditable(false);
        txt1.setBounds(200, 250, 90, 30);
        jLayeredPane1.add(txt1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Minutos Academia:");
        jLabel3.setBounds(60, 250, 150, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Minutos Asesoria:");
        jLabel4.setBounds(70, 290, 140, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Codigo Pago:");
        jLabel5.setBounds(90, 210, 120, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pago Asesoria:");
        jLabel6.setBounds(300, 290, 120, 30);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.setBounds(390, 110, 71, 40);
        jLayeredPane1.add(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pago Academia:");
        jLabel2.setBounds(300, 250, 130, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pago Clase Particular:");
        jLabel7.setBounds(50, 330, 150, 30);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pago por Asignacion:");
        jLabel8.setBounds(300, 210, 150, 30);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Dscto.:");
        jLabel9.setBounds(300, 330, 160, 30);
        jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt6.setEditable(false);
        txt6.setBounds(440, 210, 90, 30);
        jLayeredPane1.add(txt6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt7.setEditable(false);
        txt7.setBounds(440, 250, 90, 30);
        jLayeredPane1.add(txt7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt8.setEditable(false);
        txt8.setBounds(440, 330, 90, 30);
        jLayeredPane1.add(txt8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txt5.setEditable(false);
        txt5.setBounds(200, 330, 90, 30);
        jLayeredPane1.add(txt5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblRFechaP.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblRFechaP.setForeground(new java.awt.Color(255, 255, 255));
        lblRFechaP.setText("Fecha de Pago:");
        lblRFechaP.setBounds(60, 160, 110, 30);
        jLayeredPane1.add(lblRFechaP, javax.swing.JLayeredPane.POPUP_LAYER);

        txtRFechaP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRFechaP1FocusLost(evt);
            }
        });
        txtRFechaP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRFechaP1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFechaP1KeyTyped(evt);
            }
        });
        txtRFechaP1.setBounds(160, 160, 40, 30);
        jLayeredPane1.add(txtRFechaP1, javax.swing.JLayeredPane.POPUP_LAYER);

        txtRFechaP2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRFechaP2FocusLost(evt);
            }
        });
        txtRFechaP2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRFechaP2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFechaP2KeyTyped(evt);
            }
        });
        txtRFechaP2.setBounds(210, 160, 40, 30);
        jLayeredPane1.add(txtRFechaP2, javax.swing.JLayeredPane.POPUP_LAYER);

        txtRFechaP3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRFechaP3FocusLost(evt);
            }
        });
        txtRFechaP3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRFechaP3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFechaP3KeyTyped(evt);
            }
        });
        txtRFechaP3.setBounds(260, 160, 50, 30);
        jLayeredPane1.add(txtRFechaP3, javax.swing.JLayeredPane.POPUP_LAYER);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(490, 110, 53, 40);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/13.jpg"))); // NOI18N
        jLabel10.setBounds(0, 0, 590, 440);
        jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Insertar_Pago_Docente.png"))); // NOI18N
        jLabel11.setBounds(10, 20, 570, 80);
        jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.POPUP_LAYER);

        txt9.setEditable(false);
        txt9.setBounds(200, 380, 90, 30);
        jLayeredPane1.add(txt9, javax.swing.JLayeredPane.DRAG_LAYER);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Pagado:");
        jLabel12.setBounds(100, 380, 100, 30);
        jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased

        if (txtCodigo.getText().length() > 5) {             txtCodigo.setText(txtCodigo.getText().substring(0, 5));         }     }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

        char caracter = evt.getKeyChar();         if (((caracter < '0') || (caracter > '9')) && ((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))) {             evt.consume();         }     }//GEN-LAST:event_txtCodigoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(recorrer(txtCodigo.getText())&&txtCodigo.getText().length()==5&&recorrer(txtRFechaP1.getText())&&recorrer(txtRFechaP2.getText())&&recorrer(txtRFechaP3.getText())){
            Insertar();
        }
        else{
            JOptionPane.showMessageDialog(this,"Ingrese Correctamente los datos","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtRFechaP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRFechaP1FocusLost
        if (recorrer(txtRFechaP2.getText())) {         
            if (recorrer(txtRFechaP1.getText())) {        
                if (recorrer(txtRFechaP3.getText())) {        
                    if (Integer.parseInt(txtRFechaP1.getText()) < 1 || Integer.parseInt(txtRFechaP1.getText()) > maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))) {           
                        txtRFechaP1.setText(String.valueOf(maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))));            
                    }              
                }          
            }        
        }
    }//GEN-LAST:event_txtRFechaP1FocusLost

    private void txtRFechaP1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFechaP1KeyReleased
        if (txtRFechaP1.getText().length() > 1) {         
            txtRFechaP1.setText(txtRFechaP1.getText().substring(0, 2));   
            if (recorrer(txtRFechaP2.getText())) {           
                if (Integer.parseInt(txtRFechaP1.getText()) < 1 || Integer.parseInt(txtRFechaP1.getText()) > maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))) {         
                    txtRFechaP1.setText(String.valueOf(maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))));            
                }            
            }       
        }
    }//GEN-LAST:event_txtRFechaP1KeyReleased

    private void txtRFechaP1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFechaP1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtRFechaP1KeyTyped

    private void txtRFechaP2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRFechaP2FocusLost
    if (recorrer(txtRFechaP2.getText())) {         
            if (recorrer(txtRFechaP1.getText())) {        
                if (recorrer(txtRFechaP3.getText())) {        
                    if (Integer.parseInt(txtRFechaP1.getText()) < 1 || Integer.parseInt(txtRFechaP1.getText()) > maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))) {           
                        txtRFechaP1.setText(String.valueOf(maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))));            
                    }              
                }          
            }        
        }
    }//GEN-LAST:event_txtRFechaP2FocusLost

    private void txtRFechaP2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFechaP2KeyReleased
        if (txtRFechaP2.getText().length() > 1) {        
            txtRFechaP2.setText(txtRFechaP2.getText().substring(0, 2));  
            if (Integer.parseInt(txtRFechaP2.getText()) < 0 || Integer.parseInt(txtRFechaP2.getText()) > 12) { 
                txtRFechaP2.setText("12");          
            }           
            if (txtRFechaP2.getText().length() == 1) {
                if (Integer.parseInt(txtRFechaP1.getText()) < 1 || Integer.parseInt(txtRFechaP1.getText()) > maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))) {         
                    txtRFechaP1.setText(String.valueOf(maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))));           
                }            
            }      
        }                                    

    }//GEN-LAST:event_txtRFechaP2KeyReleased

    private void txtRFechaP2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFechaP2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtRFechaP2KeyTyped

    private void txtRFechaP3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRFechaP3FocusLost
    if (recorrer(txtRFechaP2.getText())) {         
            if (recorrer(txtRFechaP1.getText())) {        
                if (recorrer(txtRFechaP3.getText())) {        
                    if (Integer.parseInt(txtRFechaP1.getText()) < 1 || Integer.parseInt(txtRFechaP1.getText()) > maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))) {           
                        txtRFechaP1.setText(String.valueOf(maximodia(Integer.parseInt(txtRFechaP2.getText()) - 1, Integer.parseInt(txtRFechaP3.getText()))));            
                    }              
                }          
            }        
        }
    }//GEN-LAST:event_txtRFechaP3FocusLost

    private void txtRFechaP3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFechaP3KeyReleased
        if (txtRFechaP3.getText().length() > 3) {   
            txtRFechaP3.setText(txtRFechaP3.getText().substring(0, 4));    
        }
    }//GEN-LAST:event_txtRFechaP3KeyReleased

    private void txtRFechaP3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFechaP3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtRFechaP3KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    public void Insertar(){
        try{
            String codigo = txtCodigo.getText();
            String fecha = txtRFechaP3.getText()+"-"+txtRFechaP2.getText()+"-"+txtRFechaP1.getText();
            CallableStatement cst = con.prepareCall("{call usp_InsertarPagoProfesor(?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,fecha);
            cst.registerOutParameter(3, Types.SMALLINT);
            cst.registerOutParameter(4, Types.SMALLINT);
            cst.registerOutParameter(5, Types.CHAR);
            cst.registerOutParameter(6, Types.DOUBLE);
            cst.registerOutParameter(7, Types.DOUBLE);
            cst.registerOutParameter(8, Types.DOUBLE);
            cst.registerOutParameter(9, Types.DOUBLE);
            cst.registerOutParameter(10, Types.DOUBLE);
            cst.registerOutParameter(11, Types.DOUBLE);
            int rpta = cst.executeUpdate();
            int macademia = cst.getShort(3);
            int masesoria = cst.getShort(4);
            String codigoPago = cst.getString(5);
            double pagoasesoria = cst.getDouble(6);
            double pagoAcademia = cst.getDouble(7);
            double pagoparticular = cst.getDouble(8);
            double pagoasiginacion = cst.getDouble(9);
            double totaldscto = cst.getDouble(10);
            double totalpagado = cst.getDouble(11);
            txt3.setText(borrarespacios(codigoPago));
            System.out.println(codigoPago);
            txt1.setText(Integer.toString(macademia));
            txt2.setText(Integer.toString(masesoria));
            txt5.setText(Double.toString(pagoparticular));
            txt6.setText(Double.toString(pagoasiginacion));
            txt7.setText(Double.toString(pagoAcademia));
            txt4.setText(Double.toString(pagoasesoria));
            txt8.setText(Double.toString(totaldscto));
            txt9.setText(Double.toString(totalpagado));
            if(rpta==1){
               JOptionPane.showMessageDialog(this,"Se ha guardado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            cst.close();
         } catch (Exception ex) {
             ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,"ERROR Al GUARDAR","ERROR",JOptionPane.ERROR_MESSAGE);}
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
     public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
    } 
     public int maximodia(int mes,int año){
        int maximo=0;
        switch(mes){
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11: maximo=31; break;
            case 1: if(año%4==0)
                      maximo=29;
                    else
                      maximo=28;
                    break;
            case 3:
            case 5:
            case 8:
            case 10:maximo=30;break;
        }
        return maximo;
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
            java.util.logging.Logger.getLogger(Insertar_PagoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_PagoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_PagoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_PagoDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Insertar_PagoDoc().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblRFechaP;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txt9;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtRFechaP1;
    private javax.swing.JTextField txtRFechaP2;
    private javax.swing.JTextField txtRFechaP3;
    // End of variables declaration//GEN-END:variables
}
