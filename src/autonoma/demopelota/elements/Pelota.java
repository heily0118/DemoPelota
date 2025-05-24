/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.demopelota.elements;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250523
 * @version 1.0.0
 */
public class Pelota extends SpriteMobile {
    private Image imagen;
    private int stepX;
    private int stepY;
    private float alpha = 1.0f; 

    public Pelota(int step, int x, int y, int height, int width) {
        super(step, x, y, height, width);
        this.imagen = new ImageIcon(getClass().getResource("/autonoma/demopelota/images/Pelota.png")).getImage();
        this.stepX = step;
        this.stepY = step;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Aplicar desvanecido
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(imagen, x, y, width, height, null);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }

    public void actualizarMovimiento(int anchoCampo, int altoCampo) {
        x += stepX;
        y += stepY;

       
        if (x <= 0 || x + width >= anchoCampo) {
            stepX = -stepX;
            desvanecer();
        }

        if (y <= 0 || y + height >= altoCampo) {
            stepY = -stepY;
            desvanecer();
        }
    }

    private void desvanecer() {
       
        alpha = 0.5f;

       
        new Thread(() -> {
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {}
            alpha = 1.0f;
        }).start();
    }

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void run() {
       
        while (true) {
            actualizarMovimiento(700, 600); 
            try {
                Thread.sleep(30); 
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}