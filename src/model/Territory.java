/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author golfier
 */
public class Territory {
	
	    public Color color;
	    public List<Pixel> pixelList;
	    public String name;
	    
	    public Territory (Color color) {
	        this.color = color;
	        this.pixelList = new ArrayList<Pixel>();

	    }
	    
	    public void addPixel(Pixel pixel){
	    	pixelList.add(pixel);
	    }
	    
	    public List<Pixel> getListPixel(){
	    	return pixelList;
	    }

	    public void addName(Color color) {
			switch (color) {
				case 1:
					this.name = "Alaska";
					break;
				case 2:
					this.name = "North Canada";
					break;
				case 3:
					this.name = "West Canada";
					break;
				case 4:
					this.name = "Center Canada";
					break;
				case 5:
					this.name = "East Canada";
					break;
				case 6:
					this.name = "West USA";
					break;
				case 7:
					this.name = "East USA";
					break;
				case 1:
					this.name = "Mexico";
					break;
				case 2:
					this.name = "North Latin America";
					break;
				case 3:
					this.name = "West Latin America";
					break;
				case 4:
					this.name = "East Latin America";
					break;
				case 5:
					this.name = "South Latin America";
					break;
				case 6:
					this.name = "Greenland;
					break;
				case 7:
					this.name = "Iceland";
					break;
				case 1:
					this.name = "West Africa";
					break;
				case 2:
					this.name = "Center Africa";
					break;
				case 3:
					this.name = "South Africa";
					break;
				case 4:
					this.name = "Madagascar";
					break;
				case 5:
					this.name = "East Africa";
					break;
				case 6:
					this.name = "North Africa";
					break;
				case 7:
					this.name = "UK";
					break;
				case 1:
					this.name = "West Europe";
					break;
				case 2:
					this.name = "South Europe";
					break;
				case 3:
					this.name = "Scandinavia";
					break;
				case 4:
					this.name = "Center Europe";
					break;
				case 5:
					this.name = "East Europe";
					break;
				case 6:
					this.name = "Middle East";
					break;
				case 7:
					this.name = "NW Russia";
					break;
				case 1:
					this.name = "NE Russia";
					break;
				case 2:
					this.name = "West Russia";
					break;
				case 3:
					this.name = "East Russia";
					break;
				case 4:
					this.name = "South Russia";
					break;
				case 5:
					this.name = "Mongolia";
					break;
				case 6:
					this.name = "Kazakhstan";
					break;
				case 7:
					this.name = "Japon";
					break;
				case 1:
					this.name = "China";
					break;
				case 2:
					this.name = "India";
					break;
				case 3:
					this.name = "Thailand";
					break;
				case 4:
					this.name = "Indonesia";
					break;
				case 5:
					this.name = "Papua";
					break;
				case 6:
					this.name = "West Australia";
					break;
				case 7:
					this.name = "East Australia";
					break;
				default:
					monthString = "Invalid month";
					break;
			}
		}




	}
}
