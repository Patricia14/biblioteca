/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Will
 */
public class Consulta extends javax.swing.JInternalFrame {

    ResultSet tabla;
    ResultSet escondida;
    ResultSet escondida2;
    
    public Consulta() {
        initComponents();
         String texto = tfbuscar.getText();
         String texto2=tfbuscar.getText();
        
        materiaescrito(texto);
        materiaaudio(texto2);
        
        
    }

    void materiaescrito(String texto){
    
  //   String filtro="%"+texto+"%";
     
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo material");
        modelo.addColumn("nombre");
        modelo.addColumn("id");
        modelo.addColumn("resumen");
        modelo.addColumn("Fecha publicacion");
        modelo.addColumn("fecha adquisicion");
        modelo.addColumn("cantidad material");
        modelo.addColumn("id material escrito");
        modelo.addColumn("ISBN");
        modelo.addColumn("editorial");
        modelo.addColumn("codigo material");
        modelo.addColumn("descripcion");
   
        tbescondidaes.setModel(modelo);
        String []datos = new String [14];
        try {
           // Statement st = cn.createStatement();
            //ResultSet rs = st.executeQuery
            Conexion select=new Conexion();
        select.setRs("SELECT m.* , me.*\n" +
"FROM material m\n" +
"INNER JOIN material_escrito me ON m.codigo_material = me.codigo_material\n" +
"WHERE m.codigo_material = me.codigo_material"); // LIKE "+'"'+filtro+'"');
        escondida=(ResultSet) select.getRs();
            while(escondida.next()){
              datos[0]=escondida.getString(1);
              datos[1]=escondida.getString(2);
              datos[2]=escondida.getString(3);
              datos[3]=escondida.getString(4);
              datos[4]=escondida.getString(5);
              datos[5]=escondida.getString(6);
              datos[6]=escondida.getString(7);
              datos[7]=escondida.getString(8);
              datos[8]=escondida.getString(9);
              datos[9]=escondida.getString(10);
              datos[10]=escondida.getString(11);
              datos[11]=escondida.getString(12);
              datos[12]=escondida.getString(13);
                                                                                            
              modelo.addRow(datos);
            }
            tbescondidaes.setModel(modelo);
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     void materiaaudio(String texto2)
    {
        // String filtro2="%"+texto2+"%";
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo material");
        modelo.addColumn("nombre");
        modelo.addColumn("id");
        modelo.addColumn("resumen");
        modelo.addColumn("Fecha publicacion");
        modelo.addColumn("fecha adquisicion");
        modelo.addColumn("cantidad material");
        modelo.addColumn("id material Audio");
        modelo.addColumn("duracion");
        modelo.addColumn("codigo material");
        modelo.addColumn("descripcion");
   
        tbescondidaes.setModel(modelo);
        String []datos = new String [13];
        try {
           // Statement st = cn.createStatement();
            //ResultSet rs = st.executeQuery
            Conexion select=new Conexion();
        select.setRs("SELECT m.* , av.*\n" +
"FROM material m\n" +
"inner join material_audiovisual av\n" +
"on m.codigo_material = av.codigo_material\n" +
"WHERE m.codigo_material = av.codigo_material");//+'"'+filtro2+'"');
        escondida2=(ResultSet) select.getRs();
            while(escondida2.next()){
              datos[0]=escondida2.getString(1);
              datos[1]=escondida2.getString(2);
              datos[2]=escondida2.getString(3);
              datos[3]=escondida2.getString(4);
              datos[4]=escondida2.getString(5);
              datos[5]=escondida2.getString(6);
              datos[6]=escondida2.getString(7);
              datos[7]=escondida2.getString(8);
              datos[8]=escondida2.getString(9);
              datos[9]=escondida2.getString(10);
              datos[10]=escondida2.getString(11);
             
             
                                                                                            
              modelo.addRow(datos);
            }
            tbescondidaes.setModel(modelo);
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfbuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Codigo = new javax.swing.JTextField();
        jTexttipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfid = new javax.swing.JTextField();
        tfnom = new javax.swing.JTextField();
        tffechap = new javax.swing.JTextField();
        tffechaa = new javax.swing.JTextField();
        Text1 = new javax.swing.JTextField();
        Text2 = new javax.swing.JTextField();
        Text3 = new javax.swing.JTextField();
        Text4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbescondidaes = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbescondidaav = new javax.swing.JTable();

        setClosable(true);

        tfbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfbuscarKeyReleased(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jLabel1.setText("Busqueda de material");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Titulo:");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Codigo.setEditable(false);
        Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoActionPerformed(evt);
            }
        });

        jTexttipo.setEditable(false);
        jTexttipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTexttipoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Codigo:");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Tipo de material:");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel6.setText("Resultado de busqueda");

        tfid.setEditable(false);
        tfid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidActionPerformed(evt);
            }
        });

        tfnom.setEditable(false);
        tfnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnomActionPerformed(evt);
            }
        });

        tffechap.setEditable(false);
        tffechap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffechapActionPerformed(evt);
            }
        });

        tffechaa.setEditable(false);
        tffechaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffechaaActionPerformed(evt);
            }
        });

        Text1.setEditable(false);
        Text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text1ActionPerformed(evt);
            }
        });

        Text2.setEditable(false);
        Text2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text2ActionPerformed(evt);
            }
        });

        Text3.setEditable(false);
        Text3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text3ActionPerformed(evt);
            }
        });

        Text4.setEditable(false);
        Text4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Tipo de material:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTexttipo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffechaa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffechap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexttipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfid, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfnom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tffechap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tffechaa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbescondidaes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbescondidaes.setFocusable(false);
        jScrollPane6.setViewportView(tbescondidaes);

        tbescondidaav.setModel(new javax.swing.table.DefaultTableModel(
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
        tbescondidaav.setFocusable(false);
        jScrollPane7.setViewportView(tbescondidaav);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(267, 267, 267))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
     
          int fila = tbescondidaav.getSelectedRow();
          int fila2 = tbescondidaes.getSelectedRow();
          
        if(fila>=0){
         Codigo.setText(tbescondidaav.getValueAt(fila,0).toString());
        jTexttipo.setText(tbescondidaav.getValueAt(fila,2).toString()); 
        tfid.setText(tbescondidaav.getValueAt(fila,7).toString());
        tfnom.setText(tbescondidaav.getValueAt(fila,1).toString());     
        tffechap.setText(tbescondidaav.getValueAt(fila,4).toString()); 
        tffechaa.setText(tbescondidaav.getValueAt(fila,5).toString()); 
        Text1.setText(tbescondidaav.getValueAt(fila,8).toString()); 
        Text2.setText(tbescondidaav.getValueAt(fila,10).toString()); 
        this.Text3.setVisible(false);
       
        } 
        else
        {
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");}
      
            
             if(fila2>=0){
        Codigo.setText(tbescondidaes.getValueAt(fila,0).toString());
        jTexttipo.setText(tbescondidaes.getValueAt(fila,2).toString());
         tfid.setText(tbescondidaes.getValueAt(fila,7).toString());
        tfnom.setText(tbescondidaes.getValueAt(fila,1).toString());     
        tffechap.setText(tbescondidaes.getValueAt(fila,4).toString()); 
        tffechaa.setText(tbescondidaes.getValueAt(fila,5).toString()); 
        Text1.setText(tbescondidaes.getValueAt(fila,9).toString()); 
        Text2.setText(tbescondidaes.getValueAt(fila,8).toString()); 
        Text3.setText(tbescondidaes.getValueAt(fila,10).toString()); 
            
      } 
        else
        {
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");}
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tfbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfbuscarKeyReleased
       String texto = tfbuscar.getText();
       String texto2 = tfbuscar.getText();
        materiaescrito(texto);
        materiaaudio(texto2);
        
    }//GEN-LAST:event_tfbuscarKeyReleased

    private void CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoActionPerformed

    private void jTexttipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTexttipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTexttipoActionPerformed

    private void Text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text1ActionPerformed

    private void tfnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnomActionPerformed

    private void tfidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidActionPerformed

    private void Text2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text2ActionPerformed

    private void Text3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text3ActionPerformed

    private void tffechapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffechapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tffechapActionPerformed

    private void tffechaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffechaaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tffechaaActionPerformed

    private void Text4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Codigo;
    private javax.swing.JTextField Text1;
    private javax.swing.JTextField Text2;
    private javax.swing.JTextField Text3;
    private javax.swing.JTextField Text4;
    private javax.swing.JButton btBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTexttipo;
    private javax.swing.JTable tbescondidaav;
    private javax.swing.JTable tbescondidaes;
    private javax.swing.JTextField tfbuscar;
    private javax.swing.JTextField tffechaa;
    private javax.swing.JTextField tffechap;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfnom;
    // End of variables declaration//GEN-END:variables
}
