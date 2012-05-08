package academia;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Insertar_Horarios extends javax.swing.JFrame {
    Connection con;
    int tabla;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    String codigoservicio;
    boolean seleccionar;
    public Insertar_Horarios() {
        initComponents();
        seleccionar=false;
        this.setTitle("Insertar Horarios");
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setIconImage(icono);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        cbxDias = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoraI = new javax.swing.JTextField();
        txtHoraT = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        cbxInicio = new javax.swing.JComboBox();
        cbxTermino = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/InsertarHorarios.png"))); // NOI18N
        jLabel1.setBounds(160, 10, 540, 60);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtServicio.setEditable(false);
        txtServicio.setBounds(500, 100, 140, 30);
        jLayeredPane1.add(txtServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servicio:");
        jLabel2.setBounds(440, 100, 70, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        btnSeleccionar.setBounds(650, 100, 110, 30);
        jLayeredPane1.add(btnSeleccionar, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        jScrollPane1.setBounds(60, 80, 300, 100);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Curso", "Hora de Inicio", "Hora de Termino"
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
        jScrollPane2.setViewportView(tblHorario);
        tblHorario.getColumnModel().getColumn(0).setResizable(false);
        tblHorario.getColumnModel().getColumn(1).setResizable(false);
        tblHorario.getColumnModel().getColumn(2).setResizable(false);
        tblHorario.getColumnModel().getColumn(3).setResizable(false);

        jScrollPane2.setBounds(30, 310, 452, 160);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxDias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        cbxDias.setBounds(620, 160, 120, 30);
        jLayeredPane1.add(cbxDias, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dia de la semana:");
        jLabel3.setBounds(500, 160, 110, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora de Inicio:");
        jLabel4.setBounds(500, 210, 90, 30);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora de Termino:");
        jLabel5.setBounds(500, 260, 110, 30);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraIKeyTyped(evt);
            }
        });
        txtHoraI.setBounds(620, 210, 50, 30);
        jLayeredPane1.add(txtHoraI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtHoraT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraTKeyTyped(evt);
            }
        });
        txtHoraT.setBounds(620, 260, 50, 30);
        jLayeredPane1.add(txtHoraT, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.setBounds(520, 360, 100, 60);
        jLayeredPane1.add(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.setBounds(650, 360, 90, 60);
        jLayeredPane1.add(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxInicio.setBounds(690, 210, 50, 30);
        jLayeredPane1.add(cbxInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxTermino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "am", "pm" }));
        cbxTermino.setBounds(690, 260, 50, 30);
        jLayeredPane1.add(cbxTermino, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/9.jpg"))); // NOI18N
        jLabel6.setBounds(0, 0, 800, 530);
        jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        seleccionar=true;
        Seleccionar_Ciclo x = new Seleccionar_Ciclo();
        x.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(seleccionar){
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
                            seleccionar=false;
                            mostrarDatos();
                            mostrarCursoHorario(codigoservicio);
                        }
                        else{
                            System.out.println(t.nextToken());
                            System.out.println(t.nextToken());
                        }
                    }
                    b.close();
           } catch (IOException ex) {}
            try {
                FileWriter f = new FileWriter("ActualizarServicio.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al grabar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblCursos.getSelectedRow()!=-1){
            if(verificar()){
                registrarCursoHorario();
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(this, "Campos vacios o mal llenados","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione una fila","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtHoraIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraIKeyReleased
        if(txtHoraI.getText().length()>5){
              txtHoraI.setText(txtHoraI.getText().substring(0, 5));
        }
        if(txtHoraI.getText().length()>=2){
            if(txtHoraI.getText().length()==2){
                if(Integer.parseInt(txtHoraI.getText())<1||Integer.parseInt(txtHoraI.getText())>12){
                    txtHoraI.setText("12"+":"+txtHoraI.getText().substring(3,txtHoraI.getText().length()));}
                txtHoraI.setText(txtHoraI.getText()+":");
            }
            else{
                if(Integer.parseInt(txtHoraI.getText())<1||Integer.parseInt(txtHoraI.getText())>12){
                    txtHoraI.setText("12"+":"+txtHoraI.getText().substring(3,txtHoraI.getText().length()));}
                txtHoraI.setText(txtHoraI.getText().substring(0,2)+":"+txtHoraI.getText().substring(3,txtHoraI.getText().length()));
            }
        }
    }//GEN-LAST:event_txtHoraIKeyReleased

    private void txtHoraTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraTKeyReleased
        if(txtHoraT.getText().length()>5){
              txtHoraT.setText(txtHoraT.getText().substring(0, 5));
        }
        if(txtHoraT.getText().length()>=2){
            if(txtHoraT.getText().length()==2){
                if(Integer.parseInt(txtHoraT.getText())<1||Integer.parseInt(txtHoraT.getText())>12){
                    txtHoraT.setText("12"+":"+txtHoraT.getText().substring(3,txtHoraT.getText().length()));}
                txtHoraT.setText(txtHoraT.getText()+":");
            }
            else{
                if(Integer.parseInt(txtHoraT.getText())<1||Integer.parseInt(txtHoraT.getText())>12){
                    txtHoraT.setText("12"+":"+txtHoraT.getText().substring(3,txtHoraT.getText().length()));}
                txtHoraT.setText(txtHoraT.getText().substring(0,2)+":"+txtHoraT.getText().substring(3,txtHoraT.getText().length()));
            }
        }
    }//GEN-LAST:event_txtHoraTKeyReleased

    private void txtHoraIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraIKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtHoraIKeyTyped

    private void txtHoraTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraTKeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtHoraTKeyTyped
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
      if((caracter < '0') ||(caracter > '9'))
          evt.consume();
    }
    public void mostrarDatos(){
        DefaultTableModel Cursos = new DefaultTableModel();
        Cursos.addColumn("Codigo");
        Cursos.addColumn("Curso");
         if(recorrer(txtServicio.getText())){
             try {
                tabla=0;
                String codigo=txtServicio.getText();
                CallableStatement cst = con.prepareCall("{call usp_ListarCicloCurso(?)}");
                cst.setString(1,codigo);
                ResultSet r=cst.executeQuery();
                while(r.next()){
                    Object dato[] = new Object[2];
                    for(int i=0;i<2;i++){
                        dato[i]=r.getString(i+1);
                    }
                    tabla++;
                Cursos.addRow(dato);
                }
                r.close();
                cst.close();
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al mostrar los Cursos","Error",JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.tblCursos.setModel(Cursos);
    }
    public boolean verificar(){
        boolean verificacion=true;
        verificacion=verificacion&&recorrer(txtServicio.getText());
        System.out.println(verificacion);
        verificacion=verificacion&&recorrer(txtHoraI.getText());
        verificacion=verificacion&&recorrer(txtHoraT.getText());
        if(cbxDias.getSelectedIndex()==0){
            verificacion=false;
        }
        if(txtHoraI.getText().length()!=5){
            verificacion=false;
        }
        if(txtHoraT.getText().length()!=5){
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
    public void registrarCursoHorario(){
        try{
           String codigoservicio=txtServicio.getText();
           String codigocurso=String.valueOf(tblCursos.getValueAt(tblCursos.getSelectedRow(),0));
           String diasemana=null;
           switch(cbxDias.getSelectedIndex()){
               case 1:diasemana="2";break;
               case 2:diasemana="3";break;
               case 3:diasemana="4";break;
               case 4:diasemana="5";break;
               case 5:diasemana="6";break;
               case 6:diasemana="7";break;
               case 7:diasemana="1";break;
           }
           String horainicio=establecerHora(txtHoraI.getText().substring(0, 2),txtHoraI.getText().substring(3,5),cbxInicio.getSelectedIndex());
           String horatermino=establecerHora(txtHoraT.getText().substring(0, 2),txtHoraT.getText().substring(3,5),cbxTermino.getSelectedIndex());
           CallableStatement cst;
           cst = con.prepareCall("{call usp_InsertarHorarioServicios(?,?,?,?,?)}");
           cst.setString(1,codigoservicio);
           cst.setString(2,codigocurso);
           cst.setString(3,diasemana);
           cst.setString(4,horainicio);
           cst.setString(5,horatermino);
           int rpta = cst.executeUpdate();
           cst.close();
           mostrarCursoHorario(codigoservicio);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"Error al guardar el Horario del curso","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public String establecerHora(String hora,String hora2, int cbx){
        String horadevuelta=null;
        switch(cbx){
            case 0:if(Integer.parseInt(hora)==12){
                        horadevuelta="00:"+hora2;
                    }
                    else{
                        horadevuelta=hora+":"+hora2;
                    }break;
            case 1: if(Integer.parseInt(hora)==12){
                         horadevuelta="12:"+hora2;
                    }
                    else{
                        horadevuelta=String.valueOf(Integer.parseInt(hora)+12);
                        if(horadevuelta.length()==1){
                            horadevuelta="0"+horadevuelta+":"+hora2;
                        }
                        else{
                            horadevuelta=horadevuelta+":"+hora2;
                        }
                    }break;
        }
        return horadevuelta;
    }
    public void mostrarCursoHorario(String codigo){
        DefaultTableModel Cursos = new DefaultTableModel();
        Cursos.addColumn("Dia");
        Cursos.addColumn("Curso");
        Cursos.addColumn("Hora Inicio");
        Cursos.addColumn("Hora Termino");
        if(recorrer(codigo)){
            try {
                tabla=0;
                CallableStatement cst = con.prepareCall("{call usp_HorarioCicloAcademico(?)}");
                cst.setString(1,codigo);
                ResultSet r=cst.executeQuery();
                outerloop:
                    while(r.next()){
                        Object dato[] = new Object[4];
                        for(int i=0;i<4;i++){
                            dato[i]=r.getString(i+1);
                        }
                        tabla++;
                        Cursos.addRow(dato);
                    }
                r.close();
                cst.close();
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al mostrar los Horarios","Error",JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.tblHorario.setModel(Cursos);
    }
    public void limpiar(){
        cbxDias.setSelectedIndex(0);
        txtHoraI.setText("");
        txtHoraT.setText("");
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
            java.util.logging.Logger.getLogger(Insertar_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Insertar_Horarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cbxDias;
    private javax.swing.JComboBox cbxInicio;
    private javax.swing.JComboBox cbxTermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTable tblHorario;
    private javax.swing.JTextField txtHoraI;
    private javax.swing.JTextField txtHoraT;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
