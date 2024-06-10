/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.inicio_sesion;
import vistas.vista_informacion_mensajero;
import vistas.vista_mensajero;

/**
 *
 * @author jeanp
 */
public class controlador_menu_mensajero implements ActionListener{
    private vista_mensajero vistaMensajero;
    
    public controlador_menu_mensajero(vista_mensajero vistaMensajero){
        this.vistaMensajero = vistaMensajero;
        
        //Acciones de los botones
        this.vistaMensajero.btnInformacion.addActionListener(this);
        this.vistaMensajero.btnPedidos.addActionListener(this);
        this.vistaMensajero.btnCerrarSesion.addActionListener(this);
    }
    
    public void inicio(){
        vistaMensajero.setTitle("Menu Mensajero");
        vistaMensajero.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMensajero.btnInformacion){
            
            vistaMensajero.setVisible(false);
            vista_informacion_mensajero vim = new vista_informacion_mensajero();
            // Controladores
            vim.setVisible(true);
        }
        
        
        if(e.getSource() == vistaMensajero.btnPedidos){
            vistaMensajero.setVisible(false);
            
        }
        
        if(e.getSource() == vistaMensajero.btnCerrarSesion){
             int opcion = JOptionPane.showConfirmDialog(vistaMensajero, "¿Estás seguro de que deseas cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                vistaMensajero.dispose();
                inicio_sesion inicioSesion = new inicio_sesion();
                controlador_inicio_sesion controladorInicioSesion = new controlador_inicio_sesion(inicioSesion);
                controladorInicioSesion.iniciar();
                inicioSesion.setVisible(true);
            } else if (opcion == JOptionPane.NO_OPTION) {
                // El usuario seleccionó "No", no hacemos nada... 
            }
        }
        
    }
    
    
}
