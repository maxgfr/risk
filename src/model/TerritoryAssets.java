package model;

import java.awt.Color;
import java.util.ArrayList;
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

	public static void countRegions(List<Territory> territories) {
		List<String>  controlledRegions = new ArrayList<>();
		int northAmerica = 0;
		int southAmerica = 0;
		int europe = 0;
		int africa = 0;
		int asia = 0;
		int australia =0;
		for (Territory element: territories){
			switch (element.region) {
				case "North_America": northAmerica++;
					break;
				case "South_America": southAmerica++;
					break;
				case "Europe": europe++;
					break;
				case "Africa": africa++;
					break;
				case "Asia": asia++;
					break;
				case "Australia": australia++;
					break;
			}
		}
		if (northAmerica == 0){
			controlledRegions.add("North_America");}
		if (southAmerica == 0){
			controlledRegions.add("South_America");}
		if (europe == 0){
			controlledRegions.add("Europe");}
		if (africa == 0){
			controlledRegions.add("Africa");}
		if (asia == 0){
			controlledRegions.add("Asia");}
		if (australia == 0){
			controlledRegions.add("Australia");}
	}
		
		/*list controlledRegions = [];
		String[] str = new String[10];		
		North America = 0/9;
		South America =0/4;
		Europe =0/7;
		Africa =0/6;
		Asia =0/12;
		Australia =0/4;
		for it in territories(){
			if it.region = "North America"//avec un switch
				North_America++


		}
		if North_America=9
			controlledRegions+= "North_America"

		etc
*/
	

}
