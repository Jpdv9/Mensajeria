/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import accesoDatos.clienteDao;
import accesoDatos.usuarioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.cliente;
import vistas.vista_cliente;
import vistas.vista_informacion_cliente;

/**
 *
 * @author jeanp
 */


public class controlador_informacion_cliente implements ActionListener{
    private vista_informacion_cliente vic;
    private usuarioDao UsuarioDao;
    private clienteDao ClienteDao;
    
   
    
    public controlador_informacion_cliente(vista_informacion_cliente vic){
        this.vic = vic;
        this.UsuarioDao = new usuarioDao();
        this.ClienteDao = new clienteDao();
        
        // Acciones de los botonos
        this.vic.btnActualizarDatos.addActionListener(this);
        this.vic.btnSalir.addActionListener(this);
    }
    
    public void inicio(){
        vic.setTitle("Actualizar y añadir informacion");
        vic.setLocationRelativeTo(null);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vic.btnActualizarDatos){
            actualizarUsuario();
        }
        if(e.getSource() == vic.btnSalir){
            int opcion = JOptionPane.showConfirmDialog(vic, "¿Estás seguro de que deseas salir?", "Salir", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                vic.dispose();
                vista_cliente vistaCliente = new vista_cliente();
                controlador_menu_cliente cmc = new controlador_menu_cliente(vistaCliente);
                cmc.inicio();
                vistaCliente.setVisible(true);
            } else if (opcion == JOptionPane.NO_OPTION) {
                // El usuario seleccionó "No", no hacemos nada, la ventana permanece abierta
            }

        }
    }
    
    private void actualizarUsuario(){
        String email = vic.txtEmail.getText();
        String direccion = vic.txtDireccionCliente.getText();
        String ciudad = vic.txtCiudad.getText();
        String telefono = vic.txtTelefonoCliente.getText();
        
        if(email.isEmpty() || direccion.isEmpty() || ciudad.isEmpty() || telefono.isEmpty()){
            JOptionPane.showMessageDialog(vic, "Por favor, complete todos los campos.");
            return;
        }
        
        cliente Cliente = new cliente();
        Cliente.setEmailCliente(email);
        Cliente.setDireccion(direccion);
        Cliente.setCiudad(ciudad);
        Cliente.setTelefono(telefono);
        
        int resultadoCliente = ClienteDao.actualizarCliente(Cliente);
        
        if (resultadoCliente > 0) {
            JOptionPane.showMessageDialog(vic, "Cliente actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(vic, "Error al actualizar el cliente.");
        }

    }
    
}
