/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

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
  
  
  public static Image colorTerritoireInit (Image imageParam, List<Player> players, List<Territory> territories){
      
        BufferedImage buffImage = SwingFXUtils.fromFXImage(imageParam, null);
        
        System.out.println("List of players in Game: "+ players);
        
        int nb = 0;
        int nb_players = players.size();
        int nb_territories = territories.size();
        int territories_modulo = nb_territories % nb_players;
        int territory_per_player = nb_territories / nb_players;
        Random rand = new Random();
        
        System.out.println("Number of players : " + nb_players);
        System.out.println("Number of territories : " + nb_territories);
        System.out.println("Territories per player : " + territory_per_player);
        System.out.println("Remaining Territories : " + territories_modulo);
        
        for (int j=0; j<players.size(); j++) { // pour chaque joueur
            nb = 0;
            while (nb < territory_per_player) {
                int randomIndex = rand.nextInt(territories.size());
                Territory randomElement = territories.get(randomIndex);
                players.get(j).getTerritories().add(randomElement);
                Color color_player = players.get(j).getColor();
                for (Pixel pix : randomElement.pixelList) {
                    buffImage.setRGB(pix.x, pix.y, color_player.getRGB());
                }
                territories.remove(randomIndex);     
                nb++;
            }          
        }
        
        while (territories_modulo > 0) {
            int randomIndex = rand.nextInt(territories.size());
            Territory randomElement = territories.get(randomIndex);
            players.get(territories_modulo).getTerritories().add(randomElement);
            for (Pixel pix : randomElement.pixelList) {
                buffImage.setRGB(pix.x, pix.y, players.get(territories_modulo).getColor().getRGB());
            }
            territories_modulo--;  
        }
           
     
        Image image_final =  SwingFXUtils.toFXImage(buffImage, null);
        
        return image_final;
  }
  
}
