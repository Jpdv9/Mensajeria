/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_mensajeria;

import controlador.controlador_inicio_sesion;
import vistas.inicio_sesion;

/**
 *
 * Leonardo Cuadro Lopez - 2241951
 * Jean Paul Davalos - 1832375
 * Juan Felipe Figueroa Serna - 2042033
 * Miguel Angel Escobar Velez - 2159832
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
