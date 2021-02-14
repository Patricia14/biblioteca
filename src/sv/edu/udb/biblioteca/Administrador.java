/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;
import Conexion.Conexion_1;
import Conexion.Conexion;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Will
 */
public class Administrador extends javax.swing.JInternalFrame {
ResultSet llenarcomboadmin;
    /**
     * Creates new form Bibliotecario
     */
   public Administrador() throws SQLException{

        initComponents();
        mostrardatos();
//        this.comboregistrarr.addItem("");
        this.comboregistrarr.addItem("11");
        this.comboregistrarr.addItem("22");
//        this.ComboUsuario.addItem("");
//        this.ComboUsuario.addItem("Super Usuario");
//        this.ComboUsuario.addItem("Bibliotecario");
        llenarCombobox();
          }
  
   void mostrardatos()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Carnet");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Tipo de usuario");
        jTable2.setModel(modelo);
        String []datos = new String [8];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from administrador");
            while(rs.next()){
              datos[0]=rs.getString(1);
              datos[1]=rs.getString(2);
              datos[2]=rs.getString(3);
              datos[3]=rs.getString(4);
              datos[4]=rs.getString(5);
              datos[5]=rs.getString(6);
              datos[6]=rs.getString(7);
              datos[7]=rs.getString(8);                                                                              
              modelo.addRow(datos);
            }
            jTable2.setModel(modelo);
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public void llenarCombobox() throws SQLException{
        
            Conexion combo=new Conexion();
            //obtenemos todos los campos de la tabla tipo_usuario
            combo.setRs("select * from tipo_administrador");
            ComboUsuario.removeAllItems();
            //atributo resulset que obtiene los valores de la clase conexion
            //devueltos por el metodo getRs
            llenarcomboadmin=(ResultSet) combo.getRs();
            while(llenarcomboadmin.next()){//recorremos todos los campos
                //agregamos los item de los tipos de usuarios que se encuentran
                //en el campo 2
                ComboUsuario.addItem(llenarcomboadmin.getString(2));
            }
            combo.cerrarConexion();//cerramos la conexion de este objeto
         
            
        
        }
   void registrar(String comboboxregis) throws SQLException{
    
        if(comboboxregis.equals("0")){
            this.setVisible(false);
                    //JOptionPane.showMessageDialog(null, "Bienvenido admin");
                    Registro_from_Admin Admin = new Registro_from_Admin();
                    MDIprincipal.Escritorio.add(Admin);
                    Admin.toFront();
                    Admin.setVisible(true);
            
            
        }else if(comboboxregis.equals("1")){
            this.setVisible(false);
                    //JOptionPane.showMessageDialog(null, "Bienvenido admin");
                    Registro_from_Bibliotecario biblio = new Registro_from_Bibliotecario();
                    MDIprincipal.Escritorio.add(biblio);
                    biblio.toFront();
                    biblio.setVisible(true);
            
            
            
        }
    
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        bienvenido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        javax.swing.JPanel Buscar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcarnet = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttipuse = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtpass = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        registro_usuario = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ComboUsuario = new javax.swing.JComboBox();
        Registrar_usuario = new javax.swing.JButton();
        Ingreso_catalogo = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        comboregistrarr = new javax.swing.JComboBox();
        Ingresar_material = new javax.swing.JButton();
        Prestamo_usuario = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Guardar_prestamo = new javax.swing.JButton();
        jcomboprestamos = new javax.swing.JComboBox<String>();
        buttonprestamo = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        limitmaterial_alumnos = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        txtmora_alumnos = new javax.swing.JSpinner();

        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setText("Bienvenido Administrador");

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel5.setText("Este espacio le ofrece la facilidad de:");

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel3.setText("Registrar usuarios, ya sea Administradores y/o Bibliotecarios");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon1.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon2.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel4.setText("Ingreso de material al catalogo");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel6.setText("Modificar valores específicos del préstamo a un usuario");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon3.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/regresar.jpg"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bienvenidoLayout = new javax.swing.GroupLayout(bienvenido);
        bienvenido.setLayout(bienvenidoLayout);
        bienvenidoLayout.setHorizontalGroup(
            bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bienvenidoLayout.createSequentialGroup()
                .addGroup(bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)))
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel5)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        bienvenidoLayout.setVerticalGroup(
            bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bienvenidoLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)))
                .addGroup(bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)))
                .addGroup(bienvenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel8))
                    .addGroup(bienvenidoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)))
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Bienvenido", bienvenido);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel22.setText("Restrablecer");

        jLabel23.setText("Carnet:");

        jLabel24.setText("Nombre:");

        jLabel25.setText("Apellido:");

        jLabel26.setText("Teléfono:");

        jLabel27.setText("Dirección:");

        jLabel28.setText("Contraseña:");

        jLabel29.setText("Tipo de usuario:");

        txtnombre.setEnabled(false);

        txtapellido.setEnabled(false);

        txttelefono.setEnabled(false);

        txtcarnet.setEnabled(false);

        txtdireccion.setEnabled(false);

        txttipuse.setEnabled(false);

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar Cambios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtcorreo.setEditable(false);
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        jLabel30.setText("Correo:");

        javax.swing.GroupLayout BuscarLayout = new javax.swing.GroupLayout(Buscar);
        Buscar.setLayout(BuscarLayout);
        BuscarLayout.setHorizontalGroup(
            BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(BuscarLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BuscarLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(1, 1, 1))
                    .addGroup(BuscarLayout.createSequentialGroup()
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(BuscarLayout.createSequentialGroup()
                                    .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel23))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(BuscarLayout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addGap(46, 46, 46)
                                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttipuse, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67)
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addComponent(jLabel28))))
                .addGap(37, 37, 37)
                .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addComponent(txtcorreo))
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BuscarLayout.setVerticalGroup(
            BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarLayout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(27, 27, 27)
                .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuscarLayout.createSequentialGroup()
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BuscarLayout.createSequentialGroup()
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtcarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txttipuse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BuscarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(BuscarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(66, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Restablecer contraseña", Buscar);

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel11.setText("Registrar super-usuarios");

        jLabel12.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel12.setText("Tipo de usuario a registrar:");

        Registrar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/Usuario.jpg"))); // NOI18N
        Registrar_usuario.setText("Registrar");
        Registrar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_usuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registro_usuarioLayout = new javax.swing.GroupLayout(registro_usuario);
        registro_usuario.setLayout(registro_usuarioLayout);
        registro_usuarioLayout.setHorizontalGroup(
            registro_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registro_usuarioLayout.createSequentialGroup()
                .addGroup(registro_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registro_usuarioLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel12))
                    .addGroup(registro_usuarioLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(ComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registro_usuarioLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(Registrar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registro_usuarioLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel11)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        registro_usuarioLayout.setVerticalGroup(
            registro_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registro_usuarioLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel11)
                .addGap(48, 48, 48)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Registrar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar super-usuarios", registro_usuario);

        jLabel13.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel13.setText("Ingreso de material");

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel14.setText("Tipo de material a registrar:");

        comboregistrarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboregistrarrActionPerformed(evt);
            }
        });

        Ingresar_material.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/material.jpg"))); // NOI18N
        Ingresar_material.setText("Ingresar");
        Ingresar_material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingresar_materialActionPerformed(evt);
            }
        });
        Ingresar_material.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Ingresar_materialKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout Ingreso_catalogoLayout = new javax.swing.GroupLayout(Ingreso_catalogo);
        Ingreso_catalogo.setLayout(Ingreso_catalogoLayout);
        Ingreso_catalogoLayout.setHorizontalGroup(
            Ingreso_catalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingreso_catalogoLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(Ingreso_catalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Ingreso_catalogoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel14))
                    .addGroup(Ingreso_catalogoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(comboregistrarr, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addGroup(Ingreso_catalogoLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(Ingresar_material, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        Ingreso_catalogoLayout.setVerticalGroup(
            Ingreso_catalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Ingreso_catalogoLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel13)
                .addGap(44, 44, 44)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboregistrarr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Ingresar_material, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ingreso catalogo", Ingreso_catalogo);

        Prestamo_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel15.setText("Préstamo a usuario");

        Guardar_prestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/Guardar.jpg"))); // NOI18N
        Guardar_prestamo.setText("Editar");
        Guardar_prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_prestamoActionPerformed(evt);
            }
        });

        jcomboprestamos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alumno", "Maestro" }));
        jcomboprestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        buttonprestamo.setText("Buscar");
        buttonprestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonprestamoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel16.setText("Limite de material");

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel17.setText("Monto de mora por día");

        javax.swing.GroupLayout Prestamo_usuarioLayout = new javax.swing.GroupLayout(Prestamo_usuario);
        Prestamo_usuario.setLayout(Prestamo_usuarioLayout);
        Prestamo_usuarioLayout.setHorizontalGroup(
            Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prestamo_usuarioLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel15)
                .addGap(0, 179, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Prestamo_usuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Guardar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Prestamo_usuarioLayout.createSequentialGroup()
                        .addComponent(jcomboprestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonprestamo)))
                .addGap(238, 238, 238))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Prestamo_usuarioLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(limitmaterial_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtmora_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        Prestamo_usuarioLayout.setVerticalGroup(
            Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prestamo_usuarioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboprestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonprestamo))
                .addGap(30, 30, 30)
                .addGroup(Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(41, 41, 41)
                .addGroup(Prestamo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limitmaterial_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmora_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(Guardar_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Préstamo a usuario", Prestamo_usuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Gracias Por Su Visita");
            Login Login = new Login();
            MDIprincipal.Escritorio.add(Login);
            Login.toFront();
            Login.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }               
    
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Ingresar_materialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Ingresar_materialKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String comboboxregistrar;
            int nombre = (int) comboregistrarr.getSelectedIndex();
            comboboxregistrar = String.valueOf(nombre);
            
            registrar(comboboxregistrar); 
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Ingresar_materialKeyReleased

    private void Ingresar_materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingresar_materialActionPerformed
        // TODO add your handling code here:
        //////////////////////////////////////////////////////////////////////////////
        String box = this.comboregistrarr.getSelectedItem().toString();
        int tipo = Integer.parseInt(box);
        if(tipo == 11){
        Registro_material_escrito registro= new Registro_material_escrito();//"reistro" es el nombre que tu le pusiste a tu primera opcion
        registro.setVisible(true);
        this.setVisible(false);//oculta el jFrame que estes usando
        }
        if(tipo == 22){
            Registro_material_audiovisual audio= new Registro_material_audiovisual();//"Frame2" es el nombre que tu le pusiste a tu 2do opcion
        audio.setVisible(true);
        this.setVisible(false);//oculta el jFrame que estes usando
        }
        
    }//GEN-LAST:event_Ingresar_materialActionPerformed

    private void Registrar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_usuarioActionPerformed
        String box = this.comboregistrarr.getSelectedItem().toString();
        String tipo = box;
        if(tipo == "Super Usuario"){
         try {
           this.setVisible(false);
           
           Administrador per = new Administrador();
           MDIprincipal.Escritorio.add(per);
           per.toFront();
           per.setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(Bibliotecario.class.getName()).log(Level.SEVERE, null, ex);
       }
        if(tipo == "Bibliotecario"){
            Bibliotecario per1 = new Bibliotecario();
             MDIprincipal.Escritorio.add(per1);
             per1.toFront();
             per1.setVisible(true);
        }
        
//        try {
//            // TODO add your handling code here:
//            String comboboxregistrar;
//            int nombre = (int) comboregistrarr.getSelectedIndex();
//            comboboxregistrar = String.valueOf(nombre);
//            
//            registrar(comboboxregistrar); 
//        } catch (SQLException ex) {
//            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }//GEN-LAST:event_Registrar_usuarioActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int fila = jTable2.getSelectedRow();
        if(fila>=0)
        {
        txtcarnet.setText(jTable2.getValueAt(fila,0).toString());     
        txtnombre.setText(jTable2.getValueAt(fila,1).toString());
        txtapellido.setText(jTable2.getValueAt(fila,2).toString());
        txttelefono.setText(jTable2.getValueAt(fila,3).toString());
        txtdireccion.setText(jTable2.getValueAt(fila,4).toString());
        txtcorreo.setText(jTable2.getValueAt(fila,5).toString());
        txtpass.setText(jTable2.getValueAt(fila,6).toString());
        txttipuse.setText(jTable2.getValueAt(fila,7).toString());
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
               try
        {  
            PreparedStatement pst = cn.prepareStatement("UPDATE administrador SET nombre_administrador='"+txtnombre.getText()+"',apellido_administrador='"+txtapellido.getText()+"',telefono_administrador='"+txttelefono.getText()+"',direccion_administrador='"+txtdireccion.getText()+"',correo_administrador='"+txtcorreo.getText()+"',contraseña_administrador='"+txtpass.getText()+"',id_tipo_administrador='"+txttipuse.getText()+"'WHERE carnet_administrador='"+txtcarnet.getText()+"'");
            pst.executeUpdate();
            mostrardatos();
            limpiar();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }                                        

    public void limpiar()
    {
        txtnombre.setText(null);
        txtapellido.setText(null);
        txtcarnet.setText(null);
        txttipuse.setText(null);
        txtpass.setText(null);
        txttelefono.setText(null);
        txtdireccion.setText(null);
        txtcorreo.setText(null);
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buttonprestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonprestamoActionPerformed
        // TODO add your handling code here:
        prestamoseditar();
    }//GEN-LAST:event_buttonprestamoActionPerformed

    private void Guardar_prestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_prestamoActionPerformed
        // TODO add your handling code here:
        /*       Guardar_prestamo.setEnabled(true);
        float inlimitmaterial = (int) limitmaterial_alumnos.getValue();
        float intxtmora_alumnos = (int) txtmora_alumnos.getValue();
        if((inlimitmaterial==1)||(intxtmora_alumnos==1)){JOptionPane.showMessageDialog(null,"Error no puede ingresar menores que uno");}*/
        try {
            // TODO add your handling code here:
            PreparedStatement presuser = cn.prepareStatement("UPDATE tipo_personal SET limite_material='"+limitmaterial_alumnos.getValue()+"',mora_monto='"+txtmora_alumnos.getValue()+"'WHERE nombre_personal_tipo='"+jcomboprestamos.getSelectedItem()+"'");
            presuser.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Guardar_prestamoActionPerformed

    private void comboregistrarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboregistrarrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboregistrarrActionPerformed
   public void prestamoseditar()
    {
        String opcprestamo = (String) jcomboprestamos.getSelectedItem();
        try {
            Statement st2 = cn.createStatement();
            ResultSet rsprestamos = st2.executeQuery("SELECT * FROM tipo_personal WHERE nombre_personal_tipo = '"+opcprestamo+"'");
                        
            if(rsprestamos.next()){
            float limite2 = Float.parseFloat(rsprestamos.getString("mora_monto"));
            txtmora_alumnos.setValue(limite2);
                String limite = (rsprestamos.getString("limite_material"));
                int limiteint = Integer.parseInt(limite);
            limitmaterial_alumnos.setValue(limiteint);             
 
            }
            else{JOptionPane.showMessageDialog(null,"NO HAY DATO");}
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboUsuario;
    private javax.swing.JButton Guardar_prestamo;
    private javax.swing.JButton Ingresar_material;
    private javax.swing.JPanel Ingreso_catalogo;
    private javax.swing.JPanel Prestamo_usuario;
    private javax.swing.JButton Registrar_usuario;
    private javax.swing.JPanel bienvenido;
    private javax.swing.JButton buttonprestamo;
    private javax.swing.JComboBox comboregistrarr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> jcomboprestamos;
    private javax.swing.JSpinner limitmaterial_alumnos;
    private javax.swing.JPanel registro_usuario;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcarnet;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JSpinner txtmora_alumnos;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttipuse;
    // End of variables declaration//GEN-END:variables
        Conexion_1 cc = new Conexion_1();
        Connection cn = cc.Conexion();
}
