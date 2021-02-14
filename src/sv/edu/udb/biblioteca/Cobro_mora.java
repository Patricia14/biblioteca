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

/**
 *
 * @author Will
 */
public class Cobro_mora extends javax.swing.JInternalFrame {
DefaultTableModel model;
ResultSet empleados;
    ResultSet llenarcombo;
    ResultSet login;
    ResultSet dato;
    static int bandera = 0;
    ResultSet llenartabla;
    ResultSet llenartabla1;
    String total;

    public Cobro_mora() throws SQLException{

        initComponents();
       MostrarCobro();
                 }
    
     void MostrarCobro(){ 
         DefaultTableModel modelo = new DefaultTableModel();
     modelo.addColumn("ID prestamo");
     modelo.addColumn("Carnet");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cargo");
         modelo.addColumn("Mora");
        cobro.setModel(modelo);
        String []datos = new String [8];
        try {
            Conexion cc = new Conexion();
            //Connection cn = cc.Conexion();
            //Statement st = cn.createStatement();
            cc.setRs("SELECT pm.id_prestamo_material, p.carnet_personal, p.nombre_personal, p.apellido_personal,  tp.nombre_personal_tipo, pm.personal_mora FROM personal p\n" +
"inner join tipo_personal tp\n" +
"on tp.id_tipo_personal=p.id_tipo_personal\n" +
"inner join prestamo_material pm\n" +
"on pm.carnet_personal_p_m=p.carnet_personal\n" +
"where pm.personal_mora>0;");
            llenartabla=(ResultSet) cc.getRs();
            while(llenartabla.next()){
              datos[0]=llenartabla.getString(1);
              datos[1]=llenartabla.getString(2);
              datos[2]=llenartabla.getString(3);
              datos[3]=llenartabla.getString(4);
              datos[4]=llenartabla.getString(5);
              datos[5]=llenartabla.getString(6);
                                                                                            
              modelo.addRow(datos);
            }
            cobro.setModel(modelo);
            cc.cerrarConexion();
            
                    } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        cobro = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtmora = new javax.swing.JTextField();
        txtcarnet = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        devolver = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        Id_prestamo = new javax.swing.JTextField();
        Id = new javax.swing.JLabel();

        jMenuItem1.setText("Modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        cobro.setModel(new javax.swing.table.DefaultTableModel(
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
        cobro.setComponentPopupMenu(jPopupMenu1);
        cobro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cobroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cobro);

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel22.setText("Cobro de mora");

        jLabel23.setText("Carnet:");

        jLabel26.setText("Total de mora:");

        txtmora.setEditable(false);
        txtmora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmoraActionPerformed(evt);
            }
        });

        txtcarnet.setEditable(false);

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        devolver.setText("Buscar");
        devolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        Id_prestamo.setEditable(false);

        Id.setText("ID prestamo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(regresar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(Id))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Id_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addComponent(devolver, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(235, 235, 235))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtmora, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtcarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Id_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Id)))
                    .addComponent(devolver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtmora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void llenarjtable() throws SQLException
    {
        Conexion con = new Conexion();
        con.cerrarConexion();
        
    }
    
    public void abrirbase() throws SQLException, ClassNotFoundException
    {
 
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void devolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverActionPerformed
       MostrarCobro();
       
 if (this.txtcarnet.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Hace falta llenar campo Carnet");
       this.txtcarnet.requestFocus();
            } else{
             try
        {              
           if (!this.txtcarnet.getText().equals("")){
               Conexion actu0=new Conexion();
               //PreparedStatement pst = cn.prepareStatement
        actu0.setRs("Select sum(pm.personal_mora) AS Mora from prestamo_material pm inner join material m on m.codigo_material=pm.codigo_material_p_m where pm.carnet_personal_p_m='"+txtcarnet.getText()+"'");
            ResultSet valor=(ResultSet)actu0.getRs();
            valor.next();
            total=valor.getString(1);
            txtmora.getText().equals(total);
         }
          if (!txtcarnet.getText().equals("")){
           int pagar = JOptionPane.showConfirmDialog(this, "Desea pagar la multa de "+total+"","Cobro de mora",0,3);
        if(pagar==JOptionPane.OK_OPTION)
        {
            Conexion  actu1=new Conexion();
            //PreparedStatement pst = actu1.prepareStatement;
        actu1.setQuery("update prestamo_material set id_estado_prestamo='EP3', personal_mora=0 WHERE carnet_personal_p_m='"+txtcarnet.getText()+"'");
           //pst.executeUpdate();
        actu1.cerrarConexion();
          MostrarCobro();
        JOptionPane.showMessageDialog(null, "¡Mora pagada!");
        }}
            
                   }
        catch(SQLException | HeadlessException e)
        {
            System.out.println(e.getMessage());
        }
              
 }
    }//GEN-LAST:event_devolverActionPerformed

    public void limpiar()
    {
        txtcarnet.setText(null);
        txtmora.setText(null);
        Id_prestamo.setText(null);
       
    }
    private void cobroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cobroMouseClicked
        // TODO add your handling code here:
        int fila = cobro.getSelectedRow();
        if(fila>=0)
        {
            Id_prestamo.setText(cobro.getValueAt(fila,0).toString());
        txtcarnet.setText(cobro.getValueAt(fila,1).toString());     
}
        else
        {
            JOptionPane.showMessageDialog(null,"Fila no seleccionada");
        }
        
    }//GEN-LAST:event_cobroMouseClicked

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
      this.setVisible(false);
            Bibliotecario Biblio = new Bibliotecario();
            MDIprincipal.Escritorio.add(Biblio);
            Biblio.toFront();
            Biblio.setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

    private void txtmoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JTextField Id_prestamo;
    private javax.swing.JTable cobro;
    private javax.swing.JButton devolver;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton regresar;
    private javax.swing.JTextField txtcarnet;
    private javax.swing.JTextField txtmora;
    // End of variables declaration//GEN-END:variables
        /*Conexion cc = new Conexion();
        Connection cn = cc.Conexion();*/
}


