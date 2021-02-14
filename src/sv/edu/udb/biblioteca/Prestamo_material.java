/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.Conexion;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Prestamo_material extends javax.swing.JInternalFrame {
DefaultTableModel model;
ResultSet empleados;
    ResultSet llenarcombo;
    ResultSet login;
    ResultSet dato;
    static int bandera = 0;
    ResultSet llenartabla;
      ResultSet llenartabla1;

    public Prestamo_material() {
        initComponents();
        limpiar();
        tablacarnet(); 
        tablamaterial();
    }

    public void limpiar()
    {
        carnet.setText("");
        nombre.setText("");
        cargo.setText("");
        morat.setText("");
        codigomaterial.setText("");
        nombrematerial.setText("");
        Tipomaterial.setText("");
        fecha_prestamo.setDate(null);
        Carnet_usuario.setText("");
        Codigo_material.setText("");
    }
    void tablacarnet()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Carnet");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cargo");
         modelo.addColumn("Mora");
        jtprestamocarnet.setModel(modelo);
        String []datos = new String [8];
        try {
            Conexion cc = new Conexion();
            //Connection cn = cc.Conexion();
            //Statement st = cn.createStatement();
            cc.setRs("Select p.carnet_personal, p.nombre_personal, p.apellido_personal, p.correo_personal, tp.nombre_personal_tipo from tipo_personal tp inner join personal p on tp.id_tipo_personal=p.id_tipo_personal");
            /*cc.setRs("SELECT p.carnet_personal, p.nombre_personal, p.apellido_personal,  tp.nombre_personal_tipo, pm.personal_mora FROM personal p\n" +
"inner join tipo_personal tp\n" +
"on tp.id_tipo_personal=p.id_tipo_personal\n" +
"inner join prestamo_material pm\n" +
"on pm.carnet_personal_p_m=p.carnet_personal");*/
//"where pm.personal_mora=0;");
            llenartabla1=(ResultSet) cc.getRs();
            while(llenartabla1.next()){
              datos[0]=llenartabla1.getString(1);
              datos[1]=llenartabla1.getString(2);
              datos[2]=llenartabla1.getString(3);
              datos[3]=llenartabla1.getString(5);
              datos[4]=llenartabla1.getString(4);
                                                                                            
              modelo.addRow(datos);
            }
            jtprestamocarnet.setModel(modelo);
            cc.cerrarConexion();
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void tablamaterial()
    {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo del material");
        modelo.addColumn("Nombre del material");
        modelo.addColumn("Tipo de material");
        modelo.addColumn("Estante");
    
        jtprestamomateria.setModel(modelo);
        String []datos = new String [4];
        try {
            Conexion material = new Conexion();
            //Connection cn = cc.Conexion();
            //Statement st = cn.createStatement();
            material.setRs("select m.codigo_material, m.nombre_material, tm.nombre_tipo_material, e.estante from material m\n" +
"inner join tipo_material tm\n" +
"on tm.id_tipo_material=m.id_tipo_material\n" +
"inner join ejemplar e\n" +
"on m.codigo_material=e.id_ejemplar \n" +
"where e.id_estado_ejemplar ='EE4';");
            llenartabla=(ResultSet) material.getRs();
            while(llenartabla.next()){
              datos[0]=llenartabla.getString(1);
              datos[1]=llenartabla.getString(2);
              datos[2]=llenartabla.getString(3);
              datos[3]=llenartabla.getString(4);
              
                                                                                            
              modelo.addRow(datos);
            }
            jtprestamomateria.setModel(modelo);
            material.cerrarConexion();
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Carnet_usuario = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        Codigo_material = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtprestamocarnet = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtprestamomateria = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        carnet = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        cargo = new javax.swing.JTextField();
        morat = new javax.swing.JTextField();
        codigomaterial = new javax.swing.JTextField();
        nombrematerial = new javax.swing.JTextField();
        Tipomaterial = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        estante = new javax.swing.JTextField();
        fecha_prestamo = new com.toedter.calendar.JDateChooser();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setPreferredSize(new java.awt.Dimension(826, 752));

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel15.setText("Prestamo de material");

        jLabel23.setText("Carnet de usuario:");

        Carnet_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Carnet_usuarioKeyTyped(evt);
            }
        });

        jLabel26.setText("Codigo de materia:");

        Codigo_material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Codigo_materialActionPerformed(evt);
            }
        });
        Codigo_material.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Codigo_materialKeyTyped(evt);
            }
        });

        jtprestamocarnet.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtprestamocarnet.setModel(new javax.swing.table.DefaultTableModel(
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
        jtprestamocarnet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtprestamocarnetMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtprestamocarnet);

        jtprestamomateria.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtprestamomateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jtprestamomateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtprestamomateriaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtprestamomateria);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("nombre del material:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Tipo de material:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Codigo del material:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Carnet:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Cargo:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Correo:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nombre y Apellido:");

        jButton2.setText("Prestamo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        carnet.setEditable(false);
        carnet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                carnetKeyTyped(evt);
            }
        });

        nombre.setEditable(false);
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        cargo.setEditable(false);
        cargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cargoKeyTyped(evt);
            }
        });

        morat.setEditable(false);
        morat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                moratKeyTyped(evt);
            }
        });

        codigomaterial.setEditable(false);
        codigomaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigomaterialKeyTyped(evt);
            }
        });

        nombrematerial.setEditable(false);
        nombrematerial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombrematerialKeyTyped(evt);
            }
        });

        Tipomaterial.setEditable(false);
        Tipomaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TipomaterialKeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Devolucion de prestamo:");

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Estante:");

        estante.setEditable(false);
        estante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                estanteKeyTyped(evt);
            }
        });

        fecha_prestamo.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(193, 193, 193))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(Carnet_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(Codigo_material, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(44, 44, 44)
                        .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(codigomaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addGap(40, 40, 40)
                                .addComponent(nombrematerial, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(fecha_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel34)
                                        .addComponent(jLabel21)))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(morat, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nombre)
                                        .addComponent(cargo, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(113, 113, 113)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel25)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(179, 179, 179)
                                        .addComponent(jLabel35)))))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tipomaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(Carnet_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Codigo_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tipomaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(codigomaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombrematerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(morat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(fecha_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Codigo_materialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Codigo_materialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Codigo_materialActionPerformed

    private void jtprestamocarnetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtprestamocarnetMouseClicked
        int fila = jtprestamocarnet.getSelectedRow();
        if(fila>=0)
        {
            carnet.setText(jtprestamocarnet.getValueAt(fila,0).toString());
            nombre.setText(jtprestamocarnet.getValueAt(fila,2).toString());
            cargo.setText(jtprestamocarnet.getValueAt(fila,3).toString());
            morat.setText(jtprestamocarnet.getValueAt(fila,4).toString());

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }

    }//GEN-LAST:event_jtprestamocarnetMouseClicked

    private void jtprestamomateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtprestamomateriaMouseClicked

        int fila = jtprestamomateria.getSelectedRow();
        if(fila>=0)
        {
            codigomaterial.setText(jtprestamomateria.getValueAt(fila,0).toString());
            nombrematerial.setText(jtprestamomateria.getValueAt(fila,1).toString());
            Tipomaterial.setText(jtprestamomateria.getValueAt(fila,2).toString());
            estante.setText(jtprestamomateria.getValueAt(fila,3).toString());

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }
    }//GEN-LAST:event_jtprestamomateriaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    java.util.Date fechapresvacio = this.fecha_prestamo.getDate();
    String fechapresvvacio;
    fechapresvvacio = String.valueOf(fechapresvacio);
       
  /* // if (fechapresvvacio.equals(" "))
    if (fecha_prestamo.equals(" ")){
           JOptionPane.showMessageDialog(null, "Hace falta llenar campo Fecha");
       this.fecha_prestamo.requestFocus();
                                                       
             
                                } else 
        //if(!fechapresvvacio.equals(" ")){
        if (fecha_prestamo.equals(" ")){*/
         
             try
        {  
            
            Calendar cal=Calendar.getInstance(); 
            String fecha=cal.get(cal.YEAR)+"-"+(cal.get(cal.MONTH)+ 1)+"-"+cal.get(cal.DATE); //fecha actual
            java.util.Date fechavacio = this.fecha_prestamo.getDate();
            //String fechavvacio;
            //fechavvacio = String.valueOf(fecha_prestamo);
            //fecha_prestamo.setDateFormatString("YYYY-MM-DD");
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          //JOptionPane.showMessageDialog(null,fecha_prestamo.getDate() );
          String fechaz = sdf.format(fecha_prestamo.getDate());
           // String fechaz = String.valueOf(fecha_prestamo.getDate());
           if ((fechaz != null)){
              // fecha_prestamo.setDateFormatString("yyyy-MM-dd");
               Conexion pst = new Conexion();
              JOptionPane.showMessageDialog(null,cal.get(cal.MONTH));
             
               pst.setQuery("insert into prestamo_material (codigo_material_p_m, carnet_personal_p_m, fecha_prestamo, fecha_devolucion, personal_mora, id_estado_prestamo) values('"+codigomaterial.getText()+"','"+carnet.getText()+"','"+fecha+"','"+fechaz+"','0','EP1')");
JOptionPane.showMessageDialog(null,"1");           
//pst.
          // }else{
          Conexion pst2 = new Conexion();
               pst2.setQuery("UPDATE ejemplar SET  id_estado_ejemplar='EE1', estante='"+estante.getText()+"' where id_ejemplar='"+codigomaterial.getText()+"'");
           // pst2.executeUpdate();
           JOptionPane.showMessageDialog(null,"El prestamo se ha hecho correctamente");
           }else /*if(fechaz == null)*/{
           JOptionPane.showMessageDialog(null, "Hace falta llenar campo Fecha");
           }
            
                   }
        catch(SQLException | HeadlessException e)
        {
            System.out.println(e.getMessage());
        }
            
              
      //  }
                      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
   this.setVisible(false);
            Bibliotecario Biblio = new Bibliotecario();
            MDIprincipal.Escritorio.add(Biblio);
            Biblio.toFront();
            Biblio.setVisible(true);
    }//GEN-LAST:event_RegresarActionPerformed

    private void Carnet_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Carnet_usuarioKeyTyped
        char c = evt.getKeyChar();
     
if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'0' || c>'9')) evt.consume();

    }//GEN-LAST:event_Carnet_usuarioKeyTyped

    private void Codigo_materialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Codigo_materialKeyTyped
        char c = evt.getKeyChar();
     
if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_Codigo_materialKeyTyped

    private void carnetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carnetKeyTyped
        char c = evt.getKeyChar();
     
if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<'0' || c>'9')) evt.consume();
    }//GEN-LAST:event_carnetKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char c = evt.getKeyChar();
     
if((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume();
    }//GEN-LAST:event_nombreKeyTyped

    private void cargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cargoKeyTyped
       char c = evt.getKeyChar();
     
if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_cargoKeyTyped

    private void moratKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moratKeyTyped
        char c = evt.getKeyChar();
     
if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_moratKeyTyped

    private void codigomaterialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigomaterialKeyTyped
        char c = evt.getKeyChar();
     
if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_codigomaterialKeyTyped

    private void nombrematerialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombrematerialKeyTyped
        char c = evt.getKeyChar();
     
if((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume();
    }//GEN-LAST:event_nombrematerialKeyTyped

    private void TipomaterialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TipomaterialKeyTyped
      char c = evt.getKeyChar();
     
if((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume();
    }//GEN-LAST:event_TipomaterialKeyTyped

    private void estanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estanteKeyTyped
         char c = evt.getKeyChar();
     
if((c<'a' || c>'z') && (c<'A' || c>'Z')) evt.consume();
    }//GEN-LAST:event_estanteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Carnet_usuario;
    private javax.swing.JTextField Codigo_material;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField Tipomaterial;
    private javax.swing.JTextField cargo;
    private javax.swing.JTextField carnet;
    private javax.swing.JTextField codigomaterial;
    private javax.swing.JTextField estante;
    private com.toedter.calendar.JDateChooser fecha_prestamo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtprestamocarnet;
    private javax.swing.JTable jtprestamomateria;
    private javax.swing.JTextField morat;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombrematerial;
    // End of variables declaration//GEN-END:variables

}
