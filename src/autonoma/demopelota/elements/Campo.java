/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demopelota.elements;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250523
 * @version 1.0.0
 */
public class Campo {
    private Pelota pelotita;
    private Image cuevaImage;


    public Campo(Pelota pelotita) {
        this.pelotita = pelotita;
        this.cuevaImage = new ImageIcon(getClass().getResource("/autonoma/demopelota/images/Campo.jpg")).getImage();
  
    }
 

      
    public void paint(Graphics g, int ancho, int alto) {
       g.drawImage(cuevaImage, 0, 0, ancho, alto, null);
        pelotita.actualizarMovimiento(ancho, alto); 
        pelotita.paint(g);
      
    }
    
  
    
}
