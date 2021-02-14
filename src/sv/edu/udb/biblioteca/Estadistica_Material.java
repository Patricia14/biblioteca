/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;

import Conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Estadistica_Material extends javax.swing.JInternalFrame {

    DefaultTableModel model;
ResultSet empleados;
    ResultSet llenarcombo;
    ResultSet login;
    ResultSet dato;
    static int bandera = 0;
    ResultSet tabla;
 
    String total;
    
    public Estadistica_Material() {
        initComponents();
        MostrarCobro();
    }

    void MostrarCobro(){ 
         DefaultTableModel modelo = new DefaultTableModel();
     modelo.addColumn("Codigo");
     modelo.addColumn("Nombre");
        modelo.addColumn("ID tipo de material");
        modelo.addColumn("Resumen");
        modelo.addColumn("fecha publicacion");
         modelo.addColumn("fecha adquisicion");
         modelo.addColumn("cantidad material");
         modelo.addColumn("Libro");
        Material.setModel(modelo);
        String []datos = new String [8];
        try {
            Conexion cc = new Conexion();
            //Connection cn = cc.Conexion();
            //Statement st = cn.createStatement();
            cc.setRs("select  m.*, count(*) AS libro \n" +
"from prestamo_material pm \n" +
"inner join material m\n" +
"on pm.codigo_material_p_m = m.codigo_material \n" +
"group by codigo_material_p_m desc");
                  tabla=(ResultSet) cc.getRs();
            while(tabla.next()){
              datos[0]=tabla.getString(1);
              datos[1]=tabla.getString(2);
              datos[2]=tabla.getString(3);
              datos[3]=tabla.getString(4);
              datos[4]=tabla.getString(5);
              datos[5]=tabla.getString(6);
              datos[6]=tabla.getString(7);
              datos[7]=tabla.getString(8);
                                                                                            
              modelo.addRow(datos);
            }
            Material.setModel(modelo);
            cc.cerrarConexion();
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Material = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();

        Material.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Material);

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel15.setText("Estadistica Material");

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Regresar)
                        .addGap(295, 295, 295))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Regresar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
      this.setVisible(false);
            Bibliotecario Biblio = new Bibliotecario();
            MDIprincipal.Escritorio.add(Biblio);
            Biblio.toFront();
            Biblio.setVisible(true);
    }//GEN-LAST:event_RegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Material;
    private javax.swing.JButton Regresar;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
