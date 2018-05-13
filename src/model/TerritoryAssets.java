package model;

import java.awt.Color;
import java.util.List;

public class TerritoryAssets {
	
	public TerritoryAssets(){}
	
	public static boolean containsTerritory(List<Territory> territories, Color couleur) {
	    
		for (Territory terr : territories) {
	        if (terr.color.equals(couleur)) {
	            return true;
	        }
	    }
	    return false;
	}
		
	public static void addTerritoryPixel(List<Territory> territories, Pixel pixel) {
		    
			for (Territory terr : territories) {
		        if (terr.color.equals(pixel.color)) {
		            terr.addPixel(pixel);
		        }
		    }
		}
	

}
