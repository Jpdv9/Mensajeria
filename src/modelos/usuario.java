/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author oberon
 */
public class usuario {
    
    private String usuario;
    private String contrasena;
    private String email;
    private String direccion;
    private String telefono;
    
    
    public String getUsuario(){
        return usuario;
    }
    
     public String getContrasena(){
        return contrasena;
    }
     
    public String getEmail(){
        return email;
    }
    
     public String getDireccion(){
        return direccion;
    }
     
    public String getTelefono(){
        return telefono;
    }
    
    public void setUsuario(String Usuario){
        this.usuario = Usuario;
    }
     
    public void setContrasena(String Contrasena){
        this.contrasena = Contrasena;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
}
