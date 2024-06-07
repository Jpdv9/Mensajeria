/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author oberon
 */
public class mensajero {
    private int idMensajero;
    private String nombreMensajero;
    private String emailMensajero;
    private String direccionMensajero;
    private String telefonoMensajero;
    
    public int getIdMensajero(){
        return idMensajero;
    }
    
    public String getNombreMensajero(){
        return nombreMensajero;
    }
    
    public String getEmailMensajero(){
         return emailMensajero;
    }
    
    public String getDireccionMensajero(){
        return direccionMensajero;
    }
    
    public String getTelefonoMensajero(){
        return telefonoMensajero;
    }
    
    public void setIdNombre(int idMensajero){
        this.idMensajero = idMensajero;
    }
    
    public void setNombreMensajero(String nombreMensajero){
        this.nombreMensajero = nombreMensajero;
    }
    
    public void setEmailMensajero(String emailMensajero){
        this.emailMensajero = emailMensajero;
    }
    
    public void setDireccionMensajero(String direccionMensajero){
        this.direccionMensajero = direccionMensajero;
    }
    
    public void setTelefonoMensajero(String telefonoMensajero){
        this.telefonoMensajero = telefonoMensajero;
    }
    
    
    @Override
    public String toString() {
        return "Mensajero{" +
                "idCliente=" + idMensajero +
                ", emailCliente='" + emailMensajero + '\'' +
                ", nombre='" + nombreMensajero + '\'' +
                ", direccion='" + direccionMensajero + '\'' +
                ", email='" + emailMensajero + '\'' +
                ", telefono='" + telefonoMensajero + '\'' +
                '}';
    }
    
}
