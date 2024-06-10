/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.sql.*;
import modelos.cliente;

/**
 *
 * @author jeanp
 */

public class clienteDao {
    FachadaBD fachada;
    
    public clienteDao() {
        fachada = new FachadaBD();
    }
    
    public int guardarCliente(cliente cl, int idUsuario) {
        String sql_guardar = "INSERT INTO Cliente(id_usuario, email_cliente, nombre, direccion, ciudad, telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_guardar)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setString(2, cl.getEmailCliente());
            pstmt.setString(3, cl.getNombre());
            pstmt.setString(4, cl.getDireccion());
            pstmt.setString(5, cl.getCiudad());
            pstmt.setString(6, cl.getTelefono());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    
    public cliente consultarCliente(int idCliente) {
        String sql_select = "SELECT * FROM Cliente WHERE id_cliente = ?";
        
        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_select)) {
            pstmt.setInt(1, idCliente);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                cliente cl = new cliente();
                cl.setIdCliente(rs.getInt("id_cliente"));
                cl.setEmailCliente(rs.getString("email_cliente"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setCiudad(rs.getString("ciudad"));
                cl.setTelefono(rs.getString("telefono"));
                return cl;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public int actualizarCliente(cliente cl) {
        String sql_update = "UPDATE Cliente SET email_cliente = ?, direccion = ?, ciudad = ?, telefono = ? WHERE id_cliente = ?";
        
        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_update)) {
            pstmt.setString(1, cl.getEmailCliente());
            pstmt.setString(2, cl.getDireccion());
            pstmt.setString(3, cl.getCiudad());
            pstmt.setString(4, cl.getTelefono());
            pstmt.setInt(5, cl.getIdCliente());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }
}
