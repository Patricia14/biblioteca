/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;
import Conexion.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Registro_personal extends javax.swing.JInternalFrame {

        ResultSet llenarcombo;
    ResultSet login;
    ResultSet dato;
    static int bandera1 = 0;
    private Connection conexion;
        private ResultSet rs;
        private Statement s;
    Conexion con =new Conexion();
    
    public Registro_personal()throws SQLException  {
        initComponents();
        Inicio();
        Limite();
    }
       
        public void Inicio() throws SQLException{
            
            Conexion con2=new Conexion();
           
            con2.setRs("select * from tipo_personal");
            jcbtipousuario.removeAllItems();
           
            llenarcombo=(ResultSet) con2.getRs();
            while(llenarcombo.next()){//recorremos todos los campos
             
                jcbtipousuario.addItem(llenarcombo.getString(2));
            }
            con2.cerrarConexion();//cerramos la conexion de este objeto
            
        }
        
        public void Limite(){
    jTextField1.setDocument(new LimitarCaracter(jTextField1,25));
    jTextField2.setDocument(new LimitarCaracter(jTextField2,25));
    jTextField4.setDocument(new LimitarCaracter(jTextField4,8));
    jTextField3.setDocument(new LimitarCaracter(jTextField3,8));
    jTextField5.setDocument(new LimitarCaracter(jTextField5,50));
    jTextField6.setDocument(new LimitarCaracter(jTextField6,50));
        }
        
        public void limpiar()
    {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
    }
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jcbtipousuario = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel11.setText("Registro Nuevo Estudiante/Maestro");

        jLabel1.setText("Carnet:");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel5.setText("Dirección:");

        jLabel4.setText("Teléfono:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/Guardar.jpg"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/regresar.jpg"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de usuario:");

        jLabel6.setText("Correo:");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(37, 37, 37)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jButton1)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel6))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addComponent(jcbtipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbtipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (this.jTextField4.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Hace falta llenar campo Carnet");
       this.jTextField4.requestFocus();
        }else {
           if(this.jTextField1.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Hace falta llenar campo Nombre");
           this.jTextField1.requestFocus();}
           else{
              if(this.jTextField2.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Hace falta llenar campo Apellido");
              this.jTextField2.requestFocus();}
              else{
                if(this.jTextField3.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Hace falta llenar campo Telefono");
                 this.jTextField3.requestFocus();}
                    else{
                      if(this.jTextField5.getText().equals("")){
                      JOptionPane.showMessageDialog(null, "Hace falta llenar campo Dirección");
                      this.jTextField5.requestFocus();
                                                  
             
                                } else{
                          
                           try
        {  
            
            Conexion con3 = new Conexion();
              
            
            
            String tipo =this.jcbtipousuario.getSelectedItem().toString();
            
            String tp1 = new String("Alumno");
            String tp2 = new String("Maestro");
            
              if (tp1.equals(tipo)){
             con3.setQuery("Insert into personal values('"+jTextField4.getText()+"','"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField6.getText()+"','"+jTextField3.getText()+"','"+jTextField5.getText()+"','TP1')");
             JOptionPane.showMessageDialog(null,"Usuario Ingresado Correctamente");
             limpiar();
             } else if (tp2.equals(tipo)){
                           con3.setQuery("Insert into personal values('"+jTextField4.getText()+"','"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField6.getText()+"','"+jTextField3.getText()+"','"+jTextField5.getText()+"','TP2')");
             JOptionPane.showMessageDialog(null,"Usuario Ingresado Correctamente");
             limpiar();
        }else {
                JOptionPane.showMessageDialog(null,"Usuario no se ha podido ingresar");
           
            }
            con3.cerrarConexion();
            limpiar();
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
                          
                          
                          
                          
                          /*
                          
                           // PreparedStatement pst = cn.prepareStatement("SELECT nombre_personal_tipo FROM `tipo_personal` WHERE `id_tipo_personal` = '"+tipo+"'");
            PreparedStatement pst = cn.prepareStatement("Insert into personal values('"+jTextField4.getText()+"','"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField5.getText()+"','"+tipo+"'");
            
            pst.executeUpdate();
          
                      
                                      int tipo = (int) jcbtipousuario.getSelectedIndex(); //hacemos que el valor que tengamos en el jcombobox sea un int
                                      String combotipo = String.valueOf(tipo); // valor del combobox a string
                                      String tipoperso;  
                                      tipoperso="SELECT nombre_personal_tipo FROM `tipo_personal` WHERE `id_tipo_personal` = '"+tipo+"'";
                                              s.executeUpdate(tipoperso); // el valor de la seleccion la igualamos a un int
 //int tipoperso = s.executeUpdate("SELECT nombre_personal_tipo FROM `tipo_personal` WHERE `id_tipo_personal` = '"+tipo+"'"); // el valor de la seleccion la igualamos a un int                                     
// String tipopersona = String.valueOf(tipoperso);// el valor de la seleccion la hacemos string
                                       
                                       
                                      if(combotipo == tipoperso){
                                       String insert;
                                          insert = "Insert into personal values('"+jTextField4.getText()+"','"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField5.getText()+"','"+tipo+"'";
                                        s.executeUpdate(insert);
//s.executeUpdate("Insert into personal values('"+jTextField4.getText()+"','"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField5.getText()+"','"+tipo+"'");
                                        JOptionPane.showMessageDialog(null,"Usuario Ingresada Correctamente");
                                      } else {
                                           JOptionPane.showMessageDialog(null,"Usuario no se ha podido ingresar");
                                      
                                      }
                                      
                           */    
                                        //
                                      }
                }
             }
          }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
            Bibliotecario Biblio = new Bibliotecario();
            MDIprincipal.Escritorio.add(Biblio);
            Biblio.toFront();
            Biblio.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
         char tel=  evt.getKeyChar();
        if(tel>='0' && tel<='8' ) 
      {
          evt.consume();
      }
        if(tel==10)
      {
          this.jTextField3.requestFocus();
      }
      
       
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
      char nom = evt.getKeyChar();
      if((nom<'a' || nom>'z')&&(nom<'A'||nom>'Z')&&(nom!=(char)KeyEvent.VK_BACK_SPACE)&&(nom!=(char)KeyEvent.VK_SPACE)){
      evt.consume();
     
      }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
       char ape = evt.getKeyChar();
      if((ape<'a' || ape>'z')&&(ape<'A'||ape>'Z')&&(ape!=(char)KeyEvent.VK_BACK_SPACE)&&(ape!=(char)KeyEvent.VK_SPACE)){
      evt.consume();
     
      }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char car=  evt.getKeyChar();
      if(!(car>='0' && car<='9'||car>='A' && car<='Z' ))
      {
          evt.consume();
      }
      if(car==10)
      {
          this.jTextField4.requestFocus();
      }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
       char c = evt.getKeyChar();
     
if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_jTextField5KeyTyped
//metodo para validar correo electronico

    public boolean isCorreo(String Correo){
    Pattern pat = null;
    Matcher mat = null;
    pat  = Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z](2,4)$");
    mat  = pat.matcher(Correo);

    if (mat.find () 
        ) { 
            return true;
    }
         else {
              return false;
    }
    }
    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
     /*   if (isCorreo(jTextField6.getText())) { 
            
        }else{
           JOptionPane.showMessageDialog(null,"Correo Incorrecto","Validar Correo", JOptionPane.INFORMATION_MESSAGE);
           jTextField6.requestFocus();
        }*/
    }//GEN-LAST:event_jTextField6KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JComboBox jcbtipousuario;
    // End of variables declaration//GEN-END:variables
}
