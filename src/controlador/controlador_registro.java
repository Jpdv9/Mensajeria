/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.usuario;
import vistas.registrarse;

/**
 *
 * @author oberon
 */
public class controlador_registro implements ActionListener{
    
    private registrarse Registrarse;
    private usuario Usuario;
    
    public controlador_registro(registrarse Registrarse){
        this.Registrarse = Registrarse;
        Usuario = new usuario();
    }
    
    public void iniciar(){
       Registrarse.setTitle("Registrar Usuario");
       Registrarse.setLocationRelativeTo(null);

   } 

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
