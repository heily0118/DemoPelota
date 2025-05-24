/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.demopelota.main;

import autonoma.demopelota.elements.Campo;
import autonoma.demopelota.elements.Pelota;
import autonoma.demopelota.gui.VentanaPrincipal;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250524
 * @version 1.0.0
 */
public class DemoPelota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         Pelota pelota = new Pelota(5, 100, 100, 50, 50);
        
       
        Campo campo = new Campo(pelota);

      
        VentanaPrincipal ventana = new VentanaPrincipal(campo);
        ventana.setVisible(true);

       
        Thread hiloPelota = new Thread(pelota);
        hiloPelota.start();
    }
    
}
