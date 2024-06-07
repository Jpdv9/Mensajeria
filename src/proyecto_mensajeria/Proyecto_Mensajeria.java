/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_mensajeria;

import controlador.controlador_inicio_sesion;
import vistas.inicio_sesion;

/**
 *
 * @author oberon
 */
public class Proyecto_Mensajeria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        inicio_sesion InicioSesion = new inicio_sesion();
        controlador_inicio_sesion controladorInicioSesion = new controlador_inicio_sesion(InicioSesion);
        
        controladorInicioSesion.iniciar();
        InicioSesion.setVisible(true);
    }
    
}
