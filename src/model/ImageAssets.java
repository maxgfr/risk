/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author golfier
 */
public class ImageAssets {
    
  public static void printPixelARGB(int pixel) {
    int alpha = (pixel >> 24) & 0xff;
    int red = (pixel >> 16) & 0xff;
    int green = (pixel >> 8) & 0xff;
    int blue = (pixel) & 0xff;
    System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
  }
  
  public static void addPixel(int pixel, int i, int j, List<Couleur> list) {      
    int alpha = (pixel >> 24) & 0xff;
    int red = (pixel >> 16) & 0xff;
    int green = (pixel >> 8) & 0xff;
    int blue = (pixel) & 0xff;
    Couleur couleur = new Couleur (alpha,red,green,blue);
    if(!list.contains(couleur)) {
        list.add(couleur);
    }
  }

  public static void imageProcess(BufferedImage image) {
    int w = image.getWidth();
    int h = image.getHeight();
    System.out.println("Width, Height: " + w + ", " + h);
    
    List<Couleur> maListeDeCouleur = new ArrayList<Couleur>();
    
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            //System.out.println("x,y: " + j + ", " + i);
            
            int pixel = image.getRGB(j, i);
            
            addPixel(pixel, i, j, maListeDeCouleur);
            
        }
    }
    
    System.out.println("Il y a " + maListeDeCouleur.size() + " couleurs différentes.");
    
  }
}
