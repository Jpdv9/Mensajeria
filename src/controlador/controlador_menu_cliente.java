/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.inicio_sesion;
import vistas.vista_cliente;
import vistas.vista_informacion_cliente;
import vistas.vista_monitoriar_pedido;
import vistas.vista_solicitar_pedido;
import controlador.controlador_inicio_sesion;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanp
 */
public class controlador_menu_cliente implements ActionListener{
    private inicio_sesion inicioSesion;
    private vista_cliente vistaCliente;
    
    public controlador_menu_cliente(vista_cliente vistaCliente){
        this.vistaCliente = vistaCliente;
        
        // accion de los botones
        this.vistaCliente.btnInformacion.addActionListener(this);
        this.vistaCliente.btnSolicitarPedido.addActionListener(this);
        this.vistaCliente.bntMonitoriarPedido.addActionListener(this);
        this.vistaCliente.btnCerrarSesion.addActionListener(this);
        
    }
    
    
    
    public void inicio(){
        vistaCliente.setTitle("Menu Cliente");
        vistaCliente.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vistaCliente.btnInformacion){
            vistaCliente.setVisible(false);
            vista_informacion_cliente vic = new vista_informacion_cliente();
            controlador_informacion_cliente cic = new controlador_informacion_cliente(vic);
            cic.inicio();
            vic.setVisible(true);
        }
        
        if(e.getSource() == vistaCliente.btnSolicitarPedido){
            vistaCliente.setVisible(false);
            vista_solicitar_pedido vsp = new vista_solicitar_pedido();
            vsp.setVisible(true);
        }
        
        if(e.getSource() == vistaCliente.bntMonitoriarPedido){
            vistaCliente.setVisible(false);
            vista_monitoriar_pedido vmp = new vista_monitoriar_pedido();
            vmp.setVisible(true);
        }
        
        if(e.getSource() == vistaCliente.btnCerrarSesion){
            int opcion = JOptionPane.showConfirmDialog(vistaCliente, "¿Estás seguro de que deseas cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                vistaCliente.dispose();
                inicio_sesion inicioSesion = new inicio_sesion();
                controlador_inicio_sesion controladorInicioSesion = new controlador_inicio_sesion(inicioSesion);
                controladorInicioSesion.iniciar();
                inicioSesion.setVisible(true);
            } else if (opcion == JOptionPane.NO_OPTION) {
                // El usuario seleccionó "No", no hacemos nada, la ventana permanece abierta
            }
        }
    }
}
