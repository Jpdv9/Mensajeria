/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import accesoDatos.usuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.controlador_menu_cliente;
import modelos.usuario;
import vistas.inicio_sesion;
import vistas.registrarse;
import vistas.vista_cliente;
import vistas.vista_mensajero;


/**
 *
 * @author oberon
 */
public class controlador_inicio_sesion implements ActionListener{
    private inicio_sesion inicioSesion;
    private usuario Usuario;
    private usuarioDao UsuarioDao;
    
    public controlador_inicio_sesion(inicio_sesion inicioSesion){
        this.inicioSesion = inicioSesion;
        this.Usuario = new usuario();
        this.UsuarioDao = new usuarioDao();
        
        
        //Para que los botones se activen y hagan la accion dada.
        this.inicioSesion.btnIncioSesion.addActionListener(this);
        this.inicioSesion.btnRegistrar.addActionListener(this);
    }
    
    
    public void iniciar(){
        inicioSesion.setTitle("Bienvenido");
        inicioSesion.setLocationRelativeTo(null);
    }
    

   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inicioSesion.btnIncioSesion) {
            String nombreUsuario = inicioSesion.txtUsuario.getText();
            String contrasena = inicioSesion.txtContrasena.getText();

            String tipoUsuario = (String) inicioSesion.boxTipoUsuario.getSelectedItem();

            if (UsuarioDao.verificarCredenciales(nombreUsuario, contrasena)) {
                System.out.println("Inicio de sesión exitoso");

                inicioSesion.setVisible(false);

                if (tipoUsuario.equals("cliente")) {
                    vista_cliente vistaCliente = new vista_cliente();
                    controlador_menu_cliente controladorCliente = new controlador_menu_cliente(vistaCliente);
                    controladorCliente.inicio();
                    vistaCliente.setVisible(true);
                } else if (tipoUsuario.equals("mensajero")) {
                    // Código para abrir la vista del mensajero
                    vista_mensajero vistaMensajero = new vista_mensajero();
                    //controlador_menu_cliente controladorCliente = new controlador_menu_cliente(vistaCliente);
                    //controladorCliente.inicio();
                    vistaMensajero.setVisible(true);
                } else {
                    System.out.println("Tipo de usuario no válido");
                }
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        }

        if (e.getSource() == inicioSesion.btnRegistrar) {
            inicioSesion.setVisible(false);
            registrarse Registrarse = new registrarse();
            controlador_registro controladorRegistro = new controlador_registro(Registrarse);
            controladorRegistro.iniciar();
            Registrarse.setVisible(true);
        }
    }
}
    

    

