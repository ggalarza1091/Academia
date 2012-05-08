package academia;
import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.Calendar;
public class Modificar_Asistencia extends javax.swing.JFrame {
    Connection con;
    ImageIcon imagen = new ImageIcon("Icono.gif");
    Image icono = imagen.getImage();
    Calendar c = Calendar.getInstance();
    public Modificar_Asistencia() {
        initComponents();
        this.setTitle("Modificar Asistencia");
        this.setIconImage(icono);
        String D=Integer.toString(c.get(Calendar.DATE));
        String M=Integer.toString(c.get(Calendar.MONTH)+1);
        String A=Integer.toString(c.get(Calendar.YEAR));
        txtFecha1.setText(D);
        txtFecha2.setText(M);
        txtFecha3.setText(A);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"ERROR EN LA CONEXION","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Insertar_Salones.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel asignacion = new DefaultTableModel();
        asignacion.addColumn("Codigo");
        asignacion.addColumn("Costo");
        asignacion.addColumn("Matricula");
        asignacion.addColumn("Ciclo");
        asignacion.addColumn("Fecha Inicio");
        asignacion.addColumn("Fecha Fin");
        this.tblServicio.setModel(asignacion);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txtFecha1 = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        txtFecha3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicio = new javax.swing.JTable();
        cbxServicio = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMAAsistencias = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/ModificarAsistencia.png"))); // NOI18N
        jLabel1.setBounds(240, 20, 500, 50);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha1FocusLost(evt);
            }
        });
        txtFecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha1KeyTyped(evt);
            }
        });
        txtFecha1.setBounds(110, 160, 30, 30);
        jLayeredPane1.add(txtFecha1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha2FocusLost(evt);
            }
        });
        txtFecha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha2KeyTyped(evt);
            }
        });
        txtFecha2.setBounds(150, 160, 30, 30);
        jLayeredPane1.add(txtFecha2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtFecha3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFecha3FocusLost(evt);
            }
        });
        txtFecha3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFecha3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecha3KeyTyped(evt);
            }
        });
        txtFecha3.setBounds(190, 160, 50, 30);
        jLayeredPane1.add(txtFecha3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Fecha:");
        jLabel2.setBounds(30, 160, 60, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblServicioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicio);

        jScrollPane1.setBounds(30, 270, 280, 200);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Uno", "Academia", "Asesoria" }));
        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });
        cbxServicio.setBounds(120, 210, 110, 30);
        jLayeredPane1.add(cbxServicio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Servicio:");
        jLabel3.setBounds(30, 210, 100, 30);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblMAAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Asistio", "Tardanza", "Falto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMAAsistencias.getTableHeader().setReorderingAllowed(false);
        tblMAAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMAAsistenciasMousePressed(evt);
            }
        });
        tblMAAsistencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblMAAsistenciasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMAAsistenciasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblMAAsistencias);
        tblMAAsistencias.getColumnModel().getColumn(0).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(1).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(2).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(3).setResizable(false);
        tblMAAsistencias.getColumnModel().getColumn(4).setResizable(false);

        jScrollPane2.setBounds(370, 140, 450, 390);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(50, 500, 80, 30);
        jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(200, 500, 70, 30);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/Fondos/22.jpg"))); // NOI18N
        jLabel4.setBounds(0, 0, 880, 600);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFecha1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha1KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha1KeyTyped

    private void txtFecha2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha2KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha2KeyTyped

    private void txtFecha3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha3KeyTyped
        bloqueoLetras(evt);
    }//GEN-LAST:event_txtFecha3KeyTyped

    private void txtFecha1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha1KeyReleased
        if(txtFecha1.getText().length()>1){
              txtFecha1.setText(txtFecha1.getText().substring(0, 2));
              if(recorrer(txtFecha2.getText())){
                  if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                      txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFecha1KeyReleased

    private void txtFecha2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha2KeyReleased
        if(txtFecha2.getText().length()>1){
              txtFecha2.setText(txtFecha2.getText().substring(0, 2));
              if(Integer.parseInt(txtFecha2.getText())<0||Integer.parseInt(txtFecha2.getText())>12){
                  txtFecha2.setText("12");
              }
              if(txtFecha2.getText().length()==1){
                  if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                      txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                  }
              }
        }
    }//GEN-LAST:event_txtFecha2KeyReleased

    private void txtFecha3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecha3KeyReleased
        if(txtFecha3.getText().length()>3){
              txtFecha3.setText(txtFecha3.getText().substring(0, 4));
        }
    }//GEN-LAST:event_txtFecha3KeyReleased

    private void txtFecha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha1FocusLost
        if (recorrer(txtFecha2.getText())) {
            if (recorrer(txtFecha1.getText())) {
                if (recorrer(txtFecha3.getText())) {
                    if (Integer.parseInt(txtFecha1.getText()) < 1 || Integer.parseInt(txtFecha1.getText()) > maximodia(Integer.parseInt(txtFecha2.getText()), Integer.parseInt(txtFecha3.getText()))) {
                        txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()), Integer.parseInt(txtFecha3.getText()))));
                    }
                }
            }
        }
    }//GEN-LAST:event_txtFecha1FocusLost

    private void txtFecha2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha2FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha2FocusLost

    private void txtFecha3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFecha3FocusLost
        if(recorrer(txtFecha2.getText())){
            if(recorrer(txtFecha1.getText())){
                if(recorrer(txtFecha3.getText())){
                      if(Integer.parseInt(txtFecha1.getText())<1||Integer.parseInt(txtFecha1.getText())>maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))){
                          txtFecha1.setText(String.valueOf(maximodia(Integer.parseInt(txtFecha2.getText()),Integer.parseInt(txtFecha3.getText()))));
                      }
                }
            }
        }
    }//GEN-LAST:event_txtFecha3FocusLost

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
        switch(cbxServicio.getSelectedIndex()){
            case 0:limpiar();break;
            case 1:mostrarAcademia();break;
            case 2:mostrarAsesoria();break;
        }
    }//GEN-LAST:event_cbxServicioItemStateChanged

    private void tblMAAsistenciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMAAsistenciasKeyPressed
         char caracter = evt.getKeyChar();
       restringir();
       if(caracter !='X'||caracter!='x'||caracter!=evt.VK_UP||caracter!=evt.VK_DOWN||caracter!=evt.VK_LEFT||caracter!=evt.VK_RIGHT||caracter!=evt.VK_ENTER){
          
       }
       else{
           evt.consume();
       }
    }//GEN-LAST:event_tblMAAsistenciasKeyPressed

    private void tblMAAsistenciasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMAAsistenciasKeyReleased
        restringir();
    }//GEN-LAST:event_tblMAAsistenciasKeyReleased

    private void tblMAAsistenciasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMAAsistenciasMousePressed
        restringir();
    }//GEN-LAST:event_tblMAAsistenciasMousePressed

    private void tblServicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicioMousePressed
        if(tblServicio.getSelectedRow()!=-1){
            buscarAsis();
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione una final en la tabla Servicios","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblServicioMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tblServicio.getSelectedRow()!=-1){
            boolean v=true;
            for (int i = 0; i < tblMAAsistencias.getRowCount(); i++) {  
                v=v&GuardarAsistencia(i);     
            }
            if(!v){
                JOptionPane.showMessageDialog(this,"Para poder modificar las asistencias\nse deben haber registrado antes","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Seleccione una final en la tabla Servicios","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
     public boolean GuardarAsistencia(int i){
         boolean v=true;
        try{
            String codigo = String.valueOf(tblMAAsistencias.getValueAt(i,0));
            String tipo=null;
            String D=Integer.toString(c.get(Calendar.DATE));
            String M=Integer.toString(c.get(Calendar.MONTH)+1);
            String A=Integer.toString(c.get(Calendar.YEAR));
            String fecha=A+"-"+M+"-"+D;
            if(String.valueOf(tblMAAsistencias.getValueAt(i,2)).equalsIgnoreCase("X")){
                tipo="A";
            }
            else{
                if(String.valueOf(tblMAAsistencias.getValueAt(i,3)).equalsIgnoreCase("X")){
                    tipo="T";
                }
                else{
                    if(String.valueOf(tblMAAsistencias.getValueAt(i,4)).equalsIgnoreCase("X")){
                        tipo="F";
                    }   
                }
            }
            CallableStatement cst = con.prepareCall("{call usp_ActualizarDetalleAsistenciaAlumno(?,?,?)}");
            cst.setString(1,fecha);
            cst.setString(2,codigo);
            cst.setString(3,tipo);
            int rpta = cst.executeUpdate();
            if(rpta>=1){
                JOptionPane.showMessageDialog(this,"Se ha registrado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                v=false;
            }
            cst.close();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error al registrar","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return v;
    }
    public void buscarAsis(){
        try {
            DefaultTableModel Salones = new DefaultTableModel();
            Salones.addColumn("Codigo");
            Salones.addColumn("Nombres");
            Salones.addColumn("Asistio");
            Salones.addColumn("Tardanza");
            Salones.addColumn("Falto");
            String codigo = String.valueOf(tblServicio.getValueAt(tblServicio.getSelectedRow(),0));
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumnosPorCiclo(?)}");
            cst.setString(1,codigo);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[5];
                for(int i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                }
            Salones.addRow(dato);
            }
            this.tblMAAsistencias.setModel(Salones);
            r.close();
            cst.close();
            for(int j=0;j<tblMAAsistencias.getRowCount();j++){
                listarAsistencias(j);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Codigo Erroneo","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Modificar_Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void listarAsistencias(int j){
         String asis=null;
         try {
            int m=0;
            String codigo= borrarespacios(String.valueOf(tblMAAsistencias.getValueAt(j,0)));
            String codigoserv = borrarespacios(String.valueOf(tblServicio.getValueAt(tblServicio.getSelectedRow(),0)));
            int dia=Integer.parseInt(txtFecha1.getText());
            int mes=Integer.parseInt(txtFecha2.getText());
            int ano=Integer.parseInt(txtFecha3.getText());
            CallableStatement cst = con.prepareCall("{call usp_ListarAlumnosAsistencia(?,?,?,?)}");
            cst.setString(1,codigo);
            cst.setString(2,codigoserv);
            cst.setByte(3,(byte)mes);
            cst.setShort(4,(short)ano);
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[2];
                for(int i=0;i<2;i++){
                    dato[i]=r.getString(i+1);
                    if(i==1){
                        if(Integer.parseInt(String.valueOf(dato[0]).substring(0,2))==(dia)){
                            switch(String.valueOf(dato[1]).charAt(0)){
                                case 'A':asis="x";m=2;break;
                                case 'T':asis="x";m=3;break;
                                case 'F':asis="x";m=4;break;
                            }
                        }
                    }
                }
            }
            if(m>=2){
                tblMAAsistencias.setValueAt(asis, j, m);
            }
            r.close();
            cst.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Codigo Erroneo","ERROR",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Modificar_Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void restringir(){
        for(int i=0;i<tblMAAsistencias.getRowCount();i++){
            int c=0;
            String codigo=String.valueOf(tblMAAsistencias.getValueAt(i,0));
            String nombre=String.valueOf(tblMAAsistencias.getValueAt(i,1));
            String asistio=String.valueOf(tblMAAsistencias.getValueAt(i,2));
            String tardanza=String.valueOf(tblMAAsistencias.getValueAt(i,3));
            String falto=String.valueOf(tblMAAsistencias.getValueAt(i,4)); 
            
            if(asistio.equalsIgnoreCase("null")){
            }
            else{
                if(asistio.equalsIgnoreCase("x")){
                    if(asistio.length()>1){
                        tblMAAsistencias.setValueAt("x",i,2);
                    }
                }
                else{tblMAAsistencias.setValueAt("",i,2);}
                
            } 
            if(tardanza.equalsIgnoreCase("null")){
            }
            else{
                if(tardanza.equalsIgnoreCase("x")){
                    if(tardanza.length()>1){
                    tblMAAsistencias.setValueAt("x",i,3);
                    }
                
                }
                else{tblMAAsistencias.setValueAt("",i,3);}
                
            }
            if(falto.equalsIgnoreCase("null")){
            }
            else{
                if(falto.equalsIgnoreCase("x")){
                    if(falto.length()>1){
                        tblMAAsistencias.setValueAt("x",i,4);
                    }
                }
                else{tblMAAsistencias.setValueAt("",i,4);}
                
            }
            if(asistio.equalsIgnoreCase("X")){
                c++;
            }
            if(tardanza.equalsIgnoreCase("X")){
                c++;
            }
            if(falto.equalsIgnoreCase("X")){
                c++;
            }
            if(c>1){
                tblMAAsistencias.setValueAt("",i,2);
                tblMAAsistencias.setValueAt("",i,3);
                tblMAAsistencias.setValueAt("",i,4);
            }
        }
    }
    public void limpiar(){
        DefaultTableModel asignacion = new DefaultTableModel();
        asignacion.addColumn("Codigo");
        asignacion.addColumn("Costo");
        asignacion.addColumn("Matricula");
        asignacion.addColumn("Ciclo");
        asignacion.addColumn("Fecha Inicio");
        asignacion.addColumn("Fecha Fin");
        this.tblServicio.setModel(asignacion);
    }
    public void mostrarAcademia(){
        DefaultTableModel asignacion = new DefaultTableModel();
        try {
            asignacion.addColumn("Codigo");
            asignacion.addColumn("Costo");
            asignacion.addColumn("Matricula");
            asignacion.addColumn("Ciclo");
            asignacion.addColumn("Fecha Inicio");
            asignacion.addColumn("Fecha Fin");
            CallableStatement cst = con.prepareCall("{call usp_ListarCicloAcademico}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[6];
                for(int i=0;i<6;i++){
                    dato[i]=r.getString(i+1);
                }
            asignacion.addRow(dato);
            }
            this.tblServicio.setModel(asignacion);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void mostrarAsesoria(){
        DefaultTableModel asignacion = new DefaultTableModel();
        try {
            asignacion.addColumn("Codigo");
            asignacion.addColumn("Costo");
            asignacion.addColumn("Nivel Academico");
            CallableStatement cst = con.prepareCall("{call usp_ListarAsesoria}");
            ResultSet r=cst.executeQuery();
            while(r.next()){
                Object dato[] = new Object[3];
                for(int i=0;i<3;i++){
                    dato[i]=r.getString(i+1);
                }
            asignacion.addRow(dato);
            }
            this.tblServicio.setModel(asignacion);
            r.close();
            cst.close();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al mostrar los datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void bloqueoLetras(java.awt.event.KeyEvent evt){
        char caracter = evt.getKeyChar();
        if((caracter < '0') ||(caracter > '9'))
            evt.consume();
    }
    public int maximodia(int mes,int año){
        int maximo=0;
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: maximo=31; break;
            case 2: if(año%4==0)
                      maximo=29;
                    else
                      maximo=28;
                    break;
            case 4:
            case 6:
            case 9:
            case 11:maximo=30;break;
        }
        return maximo;
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
            java.util.logging.Logger.getLogger(Modificar_Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Modificar_Asistencia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMAAsistencias;
    private javax.swing.JTable tblServicio;
    private javax.swing.JTextField txtFecha1;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtFecha3;
    // End of variables declaration//GEN-END:variables
}
