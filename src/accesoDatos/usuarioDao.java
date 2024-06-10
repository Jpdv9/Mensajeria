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

public class usuarioDao {
    
    FachadaBD fachada;
   
    public usuarioDao() {
        fachada = new FachadaBD();
    }
    
    // GUARDAR USUARIO
    public int guardarUsuario(usuario u, int idUsuario) {
    String sql_guardar = "INSERT INTO Usuario(id_usuario, login, contrasena) VALUES (?, ?, ?)";
    
    try (Connection conn = fachada.openConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql_guardar)) {
        pstmt.setInt(1, idUsuario);
        pstmt.setString(2, u.getLogin());
        pstmt.setString(3, u.getContrasena());

        return pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace(); // Manejar la excepción adecuadamente
    }
    return -1;
}


    // CONSULTAR USUARIO
    public usuario consultarUsuario(String login) {
        String sql_select = "SELECT * FROM Usuario WHERE login = ?";
        
        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_select)) {
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                usuario u = new usuario();
                u.setLogin(rs.getString("login"));
                u.setContrasena(rs.getString("contrasena"));
                u.setDireccion(rs.getString("direccion"));
                u.setTelefono(rs.getString("telefono"));
                u.setIdCliente(rs.getInt("id_cliente"));
                u.setIdMensajero(rs.getInt("id_mensajero"));
                u.setEmailCliente(rs.getString("email_cliente"));
                u.setEmailMensajero(rs.getString("email_mensajero"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente
        }
        return null;
    }
    
    // VERIFICAR CREDENCIALES
    public boolean verificarCredenciales(String login, String contrasena) {
        String sql_verificar = "SELECT COUNT(*) FROM Usuario WHERE login = ? AND contrasena = ?";
        
        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_verificar)) {
            pstmt.setString(1, login);
            pstmt.setString(2, contrasena);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejar la excepción adecuadamente
        }
        return false;
    }
}
