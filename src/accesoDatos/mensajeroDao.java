/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.*;

/**
 *
 * @author jeanp
 */
public class mensajeroDao {
    FachadaBD fachada;
    
    public mensajeroDao(){
        fachada = new FachadaBD();
    }
    
    //GUARDAD Mensajero
    
    public int guardarMensajero(mensajero m, int idUsuario){
        String sql_guardar = "INSERT INTO mensajero (id_usuario, nombre, email_mensajero, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = fachada.openConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql_guardar)) {
        pstmt.setInt(1, idUsuario);
        pstmt.setString(2, m.getNombre());
        pstmt.setString(3, m.getEmail());
        pstmt.setString(4, m.getDireccion());
        pstmt.setString(5, m.getTelefono());

        return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente
        }
        return -1;
    }
    
    
    public mensajero consultarCliente(int idMensajero) {
        String sql_select = "SELECT * FROM Mensajero WHERE id_mensajero = ?";
        
        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_select)) {
            pstmt.setInt(1, idMensajero);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                mensajero m = new mensajero();
                m.setIdMensajero(rs.getInt("id_mensajero"));
                m.setNombre(rs.getString("nombre"));
                m.setEmail(rs.getString("email_cliente"));
                m.setDireccion(rs.getString("direccion"));
                m.setTelefono(rs.getString("telefono"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
