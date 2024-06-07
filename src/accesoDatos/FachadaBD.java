/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.sql.*;

/**
 *
 * @author oberon
 */
public class FachadaBD {
    String url, usuario, password;
    Connection conexion = null;
    
    FachadaBD(){
        url = "jdbc:postgresql://localhost:5432/Mensajeria";
        usuario = "jean";
        password = "3167178829";
    }
    
    public Connection openConnection(){
        try{
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Cargado");
        } catch(ClassNotFoundException e){
            System.out.println("No se pudo cargar el driver");
        }
        
        try{
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Exitosa con la Base de datos");
            return conexion;
        }catch (SQLException e){
            System.out.println("No se pudo conectar la Bases de datos");
             e.printStackTrace();
            return null;
        }
    }
    
    public Connection getConnection(){
        if(conexion == null){
            return this.openConnection();
        }
        else{
            return conexion;
        }
    }
    
    public void closeConection(Connection c){
        try{
            if(conexion != null){
                c.close();
            }
        }catch(SQLException e){
            System.out.println("No se pude cerrar");
        }
    }
    
    public static void main(String a[]){
            FachadaBD fachada = new FachadaBD();
            Connection c = fachada.openConnection();
           fachada.closeConection(c);
    }

}
