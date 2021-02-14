/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Bibliotecario extends javax.swing.JInternalFrame {

   DefaultTableModel model;
    ResultSet empleados;
    ResultSet llenarcombo;
    ResultSet login;
    ResultSet dato;
    static int bandera = 0;
    ResultSet llenartabla;
    ResultSet llenartabla1;
    int mora1;
    ResultSet llenartablaprestamo;
    
    
    public Bibliotecario() {
        initComponents();
         
        Carga();
       Prestamo_inicio();
       
    }

    
 void Carga()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Carnet");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo");
        modelo.addColumn("Tipo de usuario");
        
        tdatos.setModel(modelo);
        String []datos = new String [8];
        try {
            //Statement st = cn.createStatement();
            Conexion tabla = new Conexion();
            //Connection cn = cc.Conexion();
            //Statement st = cn.createStatement();
            //tabla.setRs
            //ResultSet rs = st.executeQuery
        tabla.setRs("Select p.carnet_personal, p.nombre_personal, p.apellido_personal, p.correo_personal, tp.nombre_personal_tipo\n" +
"from tipo_personal tp\n" +
"inner join personal p\n" +
"on tp.id_tipo_personal=p.id_tipo_personal");
        llenartabla1=(ResultSet) tabla.getRs();
            while(llenartabla1.next()){
              datos[0]=llenartabla1.getString(1);
              datos[1]=llenartabla1.getString(2);
              datos[2]=llenartabla1.getString(3);
              datos[3]=llenartabla1.getString(4);
              datos[4]=llenartabla1.getString(5);
                                                                                           
              modelo.addRow(datos);
            }
            tdatos.setModel(modelo);
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 
 
  void tablaestatus(String texto){
     String filtro="%"+texto+"%";
      
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Carnet");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Tipo de usuario");
        modelo.addColumn("Codigo de materia");
        modelo.addColumn("Nombre del material");
        modelo.addColumn("Estante");
        modelo.addColumn("Mora");
        //jtprestamocarnet.setModel(modelo);
        String []datos = new String [8];
        try {
            Conexion cc = new Conexion();
            //Connection cn = cc.Conexion();
            //Statement st = cn.createStatement();
            cc.setRs("select carnet_personal, nombre_personal, apellido_personal, tp.nombre_personal_tipo, codigo_material, nombre_material, e.estante, pm.personal_mora\n" +
"from personal p\n" +
"inner join prestamo_material pm\n" +
"on p.carnet_personal=pm.carnet_personal_p_m\n" +
"inner join material m\n" +
"on pm.codigo_material_p_m=m.codigo_material\n" +
"inner join ejemplar e\n" +
"on m.codigo_material=e.id_ejemplar\n" +
"inner join tipo_personal tp\n" +
"on tp.id_tipo_personal=p.id_tipo_personal where carnet_personal LIKE "+'"'+filtro+'"');
            /*cc.setRs("SELECT * FROM administrador where carnet_administrador LIKE "+'"'+filtro+'"');*/
            llenartabla=(ResultSet) cc.getRs();
            while(llenartabla.next()){
              datos[0]=llenartabla.getString(1);
              datos[1]=llenartabla.getString(2);
              datos[2]=llenartabla.getString(3);
              datos[3]=llenartabla.getString(4);
              datos[4]=llenartabla.getString(5);
              datos[5]=llenartabla.getString(6);
              datos[6]=llenartabla.getString(7);
              datos[7]=llenartabla.getString(8);                                                                              
              modelo.addRow(datos);
            }
            jtestatus.setModel(modelo);
            cc.cerrarConexion();
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
  public void llenarjtable() throws SQLException
    {
        Conexion con = new Conexion();
        con.cerrarConexion();
        
    }
  
   void Prestamo_inicio()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID prestamo");
        modelo.addColumn("Nombre del material");
        modelo.addColumn("Carnet del usuario");
        modelo.addColumn("Fecha prestamo");
        modelo.addColumn("Fecha devolucion");
        modelo.addColumn("Personal mora");
        modelo.addColumn("Estado del prestamo");
   
        Prestamoinicio.setModel(modelo);
        String []datos = new String [8];
        try {
           // Statement st = cn.createStatement();
            //ResultSet rs = st.executeQuery
            Conexion select=new Conexion();
        select.setRs("Select pm.id_prestamo_material, m.nombre_material, pm.carnet_personal_p_m, pm.fecha_prestamo, pm.fecha_devolucion, pm.personal_mora, ep.estado_del_prestamo \n" +
"from prestamo_material pm\n" +
"inner join estado_prestamo ep\n" +
"on pm.id_estado_prestamo=ep.id_estado\n" +
"inner join material m\n" +
"on  pm.codigo_material_p_m=m.codigo_material;");
        llenartablaprestamo=(ResultSet) select.getRs();
            while(llenartablaprestamo.next()){
              datos[0]=llenartablaprestamo.getString(1);
              datos[1]=llenartablaprestamo.getString(2);
              datos[2]=llenartablaprestamo.getString(3);
              datos[3]=llenartablaprestamo.getString(4);
              datos[4]=llenartablaprestamo.getString(5);
              datos[5]=llenartablaprestamo.getString(6);
              datos[6]=llenartablaprestamo.getString(7);
                                                                                            
              modelo.addRow(datos);
            }
            Prestamoinicio.setModel(modelo);
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jtpprestamo_material = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Registrar_usuario = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tdatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtestatus = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Prestamoinicio = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        Cobro_mora = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Maestros = new javax.swing.JButton();
        Material = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel2.setText("Bienvenido Bibliotecario");

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel5.setText("Este espacio le ofrece la facilidad de:");

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel3.setText("Registrar usuarios, ya sea Alumno y/o Maestro");

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel4.setText("Revisar Estatus de algun usuario");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel6.setText("Registrar un prestamo de un libro");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/regresar.jpg"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon3.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon2.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon1.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel10.setText("Devolucion de material");

        jLabel13.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel13.setText("Cobro de mora");

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel14.setText("Busqueda de material y Estadisticas");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon1.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon2.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/icon3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel8))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpprestamo_material.addTab("Bienvenido", jPanel8);

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel11.setText("Registrar usuarios");

        Registrar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/Usuario.jpg"))); // NOI18N
        Registrar_usuario.setText("Registrar");
        Registrar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Registrar_usuarioActionPerformed(evt);
            }
        });

        tdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tdatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(Registrar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(Registrar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jtpprestamo_material.addTab("Registro de usuarios", jPanel1);

        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jtestatus.setModel(new javax.swing.table.DefaultTableModel(
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
        jtestatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtestatusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtestatus);

        jLabel1.setText("Carnet de usuario:");

        jLabel39.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel39.setText("Estatus de Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel39)))
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jtpprestamo_material.addTab("Estatus de usuario", jPanel2);

        jLabel12.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel12.setText("Prestamo de material");

        Prestamoinicio.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(Prestamoinicio);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/biblioteca/img/Home.jpg"))); // NOI18N
        jButton5.setText("Prestamo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Cobro_mora.setText("Cobro de mora");
        Cobro_mora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cobro_moraActionPerformed(evt);
            }
        });

        jButton8.setText("Devolucion");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Cobro_mora, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(Cobro_mora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        jtpprestamo_material.addTab("Prestamo de material", jPanel3);

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel15.setText("Estadisticas por información");

        Maestros.setText("Estadistica de Maestros");
        Maestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaestrosActionPerformed(evt);
            }
        });

        Material.setText("Estadistica de Material");
        Material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaterialActionPerformed(evt);
            }
        });

        jButton4.setText("Estadistica de Alumnos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Maestros, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Material, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15)
                .addGap(65, 65, 65)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Maestros, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Material, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );

        jtpprestamo_material.addTab("Estadisticas", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpprestamo_material)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpprestamo_material)
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

    private void Registrar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Registrar_usuarioActionPerformed
       try {
           this.setVisible(false);
           
           Registro_personal per = new Registro_personal();
           MDIprincipal.Escritorio.add(per);
           per.toFront();
           per.setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(Bibliotecario.class.getName()).log(Level.SEVERE, null, ex);
       }

        
    }//GEN-LAST:event_Registrar_usuarioActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jtestatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtestatusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtestatusMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
           this.setVisible(false);
           
           Prestamo_material perm = new Prestamo_material();
           MDIprincipal.Escritorio.add(perm);
           perm.toFront();
           perm.setVisible(true);
     
         
               
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Cobro_moraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cobro_moraActionPerformed
         try {
           this.setVisible(false);
           
           Cobro_mora cm = new Cobro_mora();
           MDIprincipal.Escritorio.add(cm);
           cm.toFront();
           cm.setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(Bibliotecario.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_Cobro_moraActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    try {
           this.setVisible(false);
           
           Devolucion_material dm = new Devolucion_material();
           MDIprincipal.Escritorio.add(dm);
           dm.toFront();
           dm.setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(Bibliotecario.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        String texto = txtBuscar.getText();
        tablaestatus(texto);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jPanel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorAdded

    }//GEN-LAST:event_jPanel2AncestorAdded

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        Estadistica_Alumnos EA = new Estadistica_Alumnos();
            MDIprincipal.Escritorio.add(EA);
            EA.toFront();
            EA.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void MaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaterialActionPerformed
        this.setVisible(false);
        Estadistica_Material EM = new Estadistica_Material();
            MDIprincipal.Escritorio.add(EM);
            EM.toFront();
            EM.setVisible(true);
    }//GEN-LAST:event_MaterialActionPerformed

    private void MaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaestrosActionPerformed
       this.setVisible(false);
        Estadistica_Maestros EM = new Estadistica_Maestros();
            MDIprincipal.Escritorio.add(EM);
            EM.toFront();
            EM.setVisible(true);
    }//GEN-LAST:event_MaestrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cobro_mora;
    private javax.swing.JButton Maestros;
    private javax.swing.JButton Material;
    private javax.swing.JTable Prestamoinicio;
    private javax.swing.JButton Registrar_usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtestatus;
    private javax.swing.JTabbedPane jtpprestamo_material;
    private javax.swing.JTable tdatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables


}
