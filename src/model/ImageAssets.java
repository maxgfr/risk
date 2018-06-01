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
    
    System.out.println("Il y a " + maListeDeTerritoire.size() + " couleurs différentes.");
    
    return maListeDeTerritoire;
  }
  
  
  public static BufferedImage colorTerritoire(BufferedImage image, Territory territoire, Color couleur){
      for (Pixel pix : territoire.pixelList) {
    	  image.setRGB(pix.x, pix.y, couleur.getRGB());
      }
	  return image;
  }
  
  
  public static Image colorTerritoireInit (Image imageParam, List<Player> players, List<Territory> territorys){
      
        BufferedImage buffImage = SwingFXUtils.fromFXImage(imageParam, null);
        List<Territory> territories = new ArrayList<Territory>(territorys);
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
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i=0;i<territorys.size();i++)
            indexes.add(i);

        for (Player player : players ) { // pour chaque joueur
        	System.out.println(player.getName());
            while (nb < territory_per_player) {
                int randomIndex = rand.nextInt(indexes.size());
                territorys.get(indexes.get(randomIndex)).setPlayer(player);
                Color color_player = player.getColor();
                for (Pixel pix : territorys.get(indexes.get(randomIndex)).pixelList) {
                    buffImage.setRGB(pix.x, pix.y, color_player.getRGB());
                }
                indexes.remove(randomIndex);
                nb++;
            }
            nb = 0;
        }

        for (int i : indexes){
            territorys.get(i).setPlayer(players.get(rand.nextInt(players.size())));
            for (Pixel pix : territorys.get(i).pixelList) {
                buffImage.setRGB(pix.x, pix.y, territorys.get(i).player.getColor().getRGB());
            }
        }
        Image image_final =  SwingFXUtils.toFXImage(buffImage, null);
        
        return image_final;
  }
  
}
