/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.usuario;
import modelos.cliente;
import modelos.mensajero;
import accesoDatos.usuarioDao;
import accesoDatos.clienteDao;
import accesoDatos.mensajeroDao;
import vistas.registrarse;

public class controlador_registro implements ActionListener {
    
    private registrarse Registrarse;
    private usuarioDao UsuarioDao;
    private clienteDao ClienteDao;
    private mensajeroDao MensajeroDao;
    
    public controlador_registro(registrarse Registrarse) {
        this.Registrarse = Registrarse;
        this.UsuarioDao = new usuarioDao();
        this.ClienteDao = new clienteDao();
        this.MensajeroDao = new mensajeroDao();
        this.Registrarse.btnRegistrarse.addActionListener(this);
        this.Registrarse.btnCancelar.addActionListener(this);
    }
    
    public void iniciar() {
        Registrarse.setTitle("Registrar Usuario");
        Registrarse.setLocationRelativeTo(null);
        Registrarse.setVisible(true);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Registrarse.btnRegistrarse) {
            registrarUsuario();
        } else if (e.getSource() == Registrarse.btnCancelar) {
            cancelarRegistro();
        }
    }

    private void registrarUsuario() {
        String login = Registrarse.txtLogin.getText();
        String contrasena = Registrarse.txtContrasena.getText();
        String direccion = Registrarse.txtDireccion.getText();
        String telefono = Registrarse.txtTelefonos.getText();
        String email = Registrarse.txtEmail.getText();
        String nombre = Registrarse.txtNombre.getText();
        String tipoUsuario = Registrarse.boxTipoUsuario.getSelectedItem().toString();

        if (login.isEmpty() || contrasena.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || email.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(Registrarse, "Por favor, complete todos los campos.");
            return;
        }

        int identificacion;
        try {
            identificacion = Integer.parseInt(Registrarse.txtIdentificacion.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(Registrarse, "La identificación debe ser un número entero válido.");
            return;
        }

        if (UsuarioDao.consultarUsuario(login) != null) {
            JOptionPane.showMessageDialog(Registrarse, "El usuario ya existe en la base de datos.");
            return;
        }

        usuario Usuario = new usuario();
        Usuario.setLogin(login);
        Usuario.setContrasena(contrasena);
        Usuario.setIdCliente(identificacion);
        Usuario.setDireccion(direccion);
        Usuario.setTelefono(telefono);
        Usuario.setEmailCliente(email);

        int resultadoUsuario = UsuarioDao.guardarUsuario(Usuario, identificacion);

        if (tipoUsuario.equals("Cliente")) {
            cliente Cliente = new cliente();
            Cliente.setIdCliente(identificacion);
            Cliente.setEmailCliente(email);
            Cliente.setNombre(nombre);
            Cliente.setDireccion(direccion);
            Cliente.setTelefono(telefono);

            int resultadoCliente = ClienteDao.guardarCliente(Cliente, identificacion);

            if (resultadoUsuario > 0 && resultadoCliente > 0) {
                JOptionPane.showMessageDialog(Registrarse, "Cliente registrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(Registrarse, "Error al registrar el cliente.");
            }
        } else if (tipoUsuario.equals("Mensajero")) {
            mensajero Mensajero = new mensajero();
            Mensajero.setIdMensajero(identificacion);
            Mensajero.setEmail(email);
            Mensajero.setNombre(nombre);
            Mensajero.setDireccion(direccion);
            Mensajero.setTelefono(telefono);

            int resultadoMensajero = MensajeroDao.guardarMensajero(Mensajero, identificacion);

            if (resultadoUsuario > 0 && resultadoMensajero > 0) {
                JOptionPane.showMessageDialog(Registrarse, "Mensajero registrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(Registrarse, "Error al registrar el mensajero.");
            }
        }
    }

    private void cancelarRegistro() {
        Registrarse.dispose(); // Cierra la ventana de registro
    }
}
