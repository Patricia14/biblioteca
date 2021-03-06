/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;
import Conexion.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Will
 */
public class Login extends javax.swing.JInternalFrame {
    ResultSet empleados;
    ResultSet llenarcombo;
    ResultSet login;
    ResultSet dato;
    static int bandera = 0;
    /**
     * Creates new form NewJInternalFrame
     * @throws java.sql.SQLException
     */
   /* public Login() {
        initComponents();
    }*/
    public Login() throws SQLException {
        initComponents();
        Limite();
        iniciarValores();
     
    }
    
      public void Limite(){
    txtusuario.setDocument(new LimitarCaracter(txtusuario,8));
    txtpassword.setDocument(new LimitarCaracter(txtpassword,8));
        }
    
         //Conexion con= new Conexion();//creacion del objeto
        public void iniciarValores() throws SQLException{
            /*con.setRs("select * from usuarios");///
            //atributo resulset que obtiene los valores de la clase conexion
            //devuelto por el metodo getRS()
            empleados=(ResultSet) con.getRs();
            empleados.last();//nos permite ir al ultimo registro
            empleados.beforeFirst();//nos permite volver al registro inicial
            empleados.next();//nos movemos el primer registro*/
            
            //creacion del objeto con2 que permite llenar con valores
            //el jcombobox y tambien para el ingreso de datos
            Conexion con2=new Conexion();
            //obtenemos todos los campos de la tabla tipo_usuario
            con2.setRs("select * from tipo_administrador");
            cmbTipoUsuario.removeAllItems();
            //atributo resulset que obtiene los valores de la clase conexion
            //devueltos por el metodo getRs
            llenarcombo=(ResultSet) con2.getRs();
            while(llenarcombo.next()){//recorremos todos los campos
                //agregamos los item de los tipos de usuarios que se encuentran
                //en el campo 2
                cmbTipoUsuario.addItem(llenarcombo.getString(2));
            }
            con2.cerrarConexion();//cerramos la conexion de este objeto
            //llenarTxtbox(); //metodo para llenar campos del formulario
            //btnAnterior.setEnabled(false);
           // btnSiguiente.setEnabled(true);
            
            
        
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnlogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox();
        lblpassword = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        lblusuario = new javax.swing.JLabel();

        setClosable(true);

        btnlogin.setText("Ingresar");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Tipo de usuario:");

        cmbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoUsuarioActionPerformed(evt);
            }
        });

        lblpassword.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblpassword.setText("Contraseña:");

        lblusuario.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblusuario.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(txtpassword)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
    String usu=txtusuario.getText();
    String pas=new String(txtpassword.getPassword());
    String combobox;
    int nombre = (int) cmbTipoUsuario.getSelectedIndex();
            combobox = String.valueOf(nombre);
        try {
            acceder(usu, pas, combobox);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnloginActionPerformed

    private void cmbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoUsuarioActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cmbTipoUsuarioActionPerformed

    void acceder(String usuario, String pass, String combobox) throws SQLException
    {   
        Conexion con= new Conexion();
        String cap="";
        con.setRs("SELECT * FROM administrador WHERE carnet_administrador='"+usuario+"' && contraseña_administrador='"+pass+"'");
        try {
            login=(ResultSet) con.getRs();
            while(login.next())
            {
                cap=login.getString("id_tipo_administrador");
            }
            if(combobox.equals("0")){
                if(cap.equals("1"))
                {
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Bienvenido admin");
                    Administrador Admin = new Administrador();
                    MDIprincipal.Escritorio.add(Admin);
                    Admin.toFront();
                    Admin.setVisible(true);  
                }
                if((!cap.equals("1")))
                {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña Incorrecto");
                }
            }
            if(combobox.equals("1")){
                if(cap.equals("2"))
                {
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Bienvenido biblioteca");
                    Bibliotecario Bibliotecario = new Bibliotecario();
                    MDIprincipal.Escritorio.add(Bibliotecario);
                    Bibliotecario.toFront();
                    Bibliotecario.setVisible(true);
                }
                if((!cap.equals("2")))
                {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña Incorrecto");
                }
            }
            if((!combobox.equals("0"))&& (!combobox.equals("1"))){
                JOptionPane.showMessageDialog(this, "Usuario o contraseña Incorrecto");
                if((!cap.equals("1"))&& (!cap.equals("2")))
                {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña Incorrecto");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JComboBox cmbTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
