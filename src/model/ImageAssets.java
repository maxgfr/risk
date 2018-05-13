/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author golfier
 */
public class ImageAssets {
    
    
  public static void addTerritory(int pixel, int i, int j, List<Territory> listTerritoire) {
	    
	    Color couleur = new Color (pixel);
	    Pixel pixl = new Pixel (i, j, couleur);
	    if(!couleur.equals(Color.WHITE ) && !couleur.equals(Color.BLACK )){
	    	if(!TerritoryAssets.containsTerritory(listTerritoire, couleur)){
		    	Territory tmp = new Territory(couleur);
		    	tmp.addPixel(pixl);
		    	listTerritoire.add(tmp);
		    }
		    else{
		    	TerritoryAssets.addTerritoryPixel(listTerritoire, pixl);
		    }
	    }
	    
	  }
  
  public static List<Territory> imageProcess(BufferedImage image) {
    int w = image.getWidth();
    int h = image.getHeight();
    System.out.println("Width, Height: " + w + ", " + h);
    
    List<Territory> maListeDeTerritoire = new ArrayList<Territory>();
    
    for (int i = 0; i < w; i++) {
        for (int j = 0; j < h; j++) {
            
        	int pixel = image.getRGB(i,j);
            addTerritory(pixel, i, j, maListeDeTerritoire);
            
        }
    }
    
    /*
    ColorUtils utils = new ColorUtils();
	for (Territory terr : maListeDeTerritoire){
		System.out.println(utils.getColorNameFromColor(terr.color));
    }*/
    
    System.out.println("Il y a " + maListeDeTerritoire.size() + " couleurs différentes.");
    
    return maListeDeTerritoire;
  }
  
  
  public static BufferedImage colorTerritoire(BufferedImage image, Territory territoire, Color couleur){
      for (Pixel pix : territoire.pixelList) {
    	  image.setRGB(pix.x, pix.y, couleur.getRGB());
      }
	  return image;
  }
}
