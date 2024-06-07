/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author oberon
 */
public class cliente {
    
    private int idCliente;
    private String emailCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String ciudadCliente;
    private String telefonoCliente;
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public String getEmailCliente(){
        return emailCliente;
    }
    
    public String getNombreCliente(){
        return nombreCliente;
    }
    
    public String getDireccionCliente(){
        return direccionCliente;
    }
    
    public String getCiudadCliente(){
        return ciudadCliente;
    }
    
    public String getTelefonoCliente(){
        return telefonoCliente;
    }
    
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    
    public void setEmailCliente(String emailCliente){
        this.emailCliente = emailCliente;
    }
    
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    
    public void setDireccionCliente(String direccionCliente){
        this.direccionCliente = direccionCliente;
    }
    
    public void setCiudadCliente(String ciudadCliente){
        this.direccionCliente = direccionCliente;
    }
    
    public void setTelefonoCliente(String telefonoCliente){
        this.telefonoCliente = telefonoCliente;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", emailCliente='" + emailCliente + '\'' +
                ", nombre='" + nombreCliente + '\'' +
                ", direccion='" + direccionCliente + '\'' +
                ", ciudad='" + ciudadCliente + '\'' +
                ", email='" + emailCliente + '\'' +
                ", telefono='" + telefonoCliente + '\'' +
                '}';
    }
    
}
