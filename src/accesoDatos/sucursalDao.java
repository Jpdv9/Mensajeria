/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;


import java.sql.*;
import modelos.*;

/**
 *
 * @author jeanp
 */
public class sucursalDao {
    
     FachadaBD fachada;
    
    public sucursalDao() {
        fachada = new FachadaBD();
    }
    
    public int guardarCliente(sucursal s, int idUsuario) {
        String sql_guardar = "INSERT INTO sucursal(id_sucural, nombre, direccion, telefono, id_cliente) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_guardar)) {
            pstmt.setInt(1, s.getIdSucursal());
            pstmt.setString(2, s.getNombre());
            pstmt.setString(3, s.getDireccion());
            pstmt.setString(4, s.getTelefono());
            pstmt.setInt(5, idUsuario);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    
    public sucursal consultarCliente(int idCliente) {
        String sql_select = "SELECT * FROM sucursal WHERE id_sucursal = ?";
        
        try (Connection conn = fachada.openConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql_select)) {
            pstmt.setInt(1, idCliente);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                sucursal s = new sucursal();
                s.setIdSucursal(rs.getInt("id_sucursal"));
                s.setNombre(rs.getString("nombre"));
                s.setDireccion(rs.getString("direccion"));
                s.setTelefono(rs.getString("telefono"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
}
