/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.usuario;
import vistas.inicio_sesion;
import vistas.registrarse;
import vistas.vista_cliente;


/**
 *
 * @author oberon
 */
public class controlador_inicio_sesion implements ActionListener{
    private inicio_sesion InicioSesion;
    private usuario Usuario;
    
    public controlador_inicio_sesion(inicio_sesion InicioSesion){
        this.InicioSesion = InicioSesion;
        Usuario = new usuario();
        
        
        //Para que los botones se activen y hagan la accion dada.
        this.InicioSesion.btnIncioSesion.addActionListener(this);
        this.InicioSesion.btnRegistrar.addActionListener(this);
    }
    
    
    public void iniciar(){
        InicioSesion.setTitle("Bienvenido");
        InicioSesion.setLocationRelativeTo(null);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Acciones de los botones
        // Boton Inciar Sesion
        
        if(e.getSource() == InicioSesion.btnIncioSesion){
            String usuario = InicioSesion.txtUsuario.getText();
            String contrasena = InicioSesion.txtContrasena.getText();
            
            // Prueba para ver si funciona las ventanas
            
            if (validarCredenciales(usuario, contrasena)) {
                // Acciones a realizar si las credenciales son correctas
                // Si el usuario y contraseña son correctos para lo de abajo
                InicioSesion.setVisible(false);
                vista_cliente vistaCliente = new vista_cliente();
                vistaCliente.setVisible(true);
                       
            } else {
                // Acciones a realizar si las credenciales son incorrectas
                // Colocar un aviso
                System.out.println("Usuario o contraseña incorrectos");
            }
            
            
        }
        
        if(e.getSource() == InicioSesion.btnRegistrar){
            InicioSesion.setVisible(false);
            registrarse Registrarse = new registrarse();
            controlador_registro controladorRegistro = new controlador_registro(Registrarse);
            controladorRegistro.iniciar();
            Registrarse.setVisible(true);
            }
            
        }
    
        //  Esto se eliminara mas adelante, esto es solo para pruebas...
        private boolean validarCredenciales(String usuario, String contrasena) {
        // Lógica de validación de credenciales (por ejemplo, comparar con datos almacenados)
        // Aquí deberías implementar la validación real
        return "admin".equals(usuario) && "1234".equals(contrasena);
    }

}
    

    

