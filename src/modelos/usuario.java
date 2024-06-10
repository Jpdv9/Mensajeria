/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class usuario {
    private String login;
    private String contrasena;
    private String direccion;
    private String telefono;
    private int idCliente;
    private int idMensajero;
    private String emailCliente;
    private String emailMensajero;

    // Getters y setters...
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMensajero() {
        return idMensajero;
    }

    public void setIdMensajero(int idMensajero) {
        this.idMensajero = idMensajero;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getEmailMensajero() {
        return emailMensajero;
    }

    public void setEmailMensajero(String emailMensajero) {
        this.emailMensajero = emailMensajero;
    }
}
