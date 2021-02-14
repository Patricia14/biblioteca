/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.*;
/**
 *
 * @author Martínez
 */
public class Conexion {
    
    private Connection conexion=null;
    private Statement s= null;
    private ResultSet rs= null;
    private String query="";
    
    //constructor
    public Conexion() throws SQLException {
        try{
    //obtenemos el driver para mysql
        Class.forName("com.mysql.jdbc.Driver");
        //se obtine una conexion con la base de datos
        conexion=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","");
        //permite ejecutar sentencias SQL sin parametros
        s=conexion.createStatement();
        }
        catch(ClassNotFoundException el){
            //Error sino puedo leer el driver de mysql
            System.out.println("ERROR:No encuentro el driver de la BD"+el.getMessage());
        }
    
    }
    //Metodo que permite obtener los valores de resulset
    public ResultSet getRs(){
    return rs;
    }
    //Metodo que permite fijar la tabla resultado de la pregunta
    //SQL realizada
    public void setRs(String consulta){
    try{
    this.rs= s.executeQuery(consulta);
    }catch(SQLException e2){
    System.out.println("ERROR:Fallo en SQL:"+e2.getMessage());
    }
    }
    //Metodo que recibe un sql como parametro que sea update.insert.delete
    public void setQuery(String query) throws SQLException{
    this.s.executeUpdate(query);
    }
    public void setQuery2(String query) throws SQLException{
    this.s.executeUpdate(query);
    }
    //Metodo que cierra la conexion
    public void cerrarConexion() throws SQLException{
    conexion.close();
    }    
    
    public static void main(String[] args) throws SQLException{
//        Conexion c = new Conexion();
//        c.getRs();
    }
}
