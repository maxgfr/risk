/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author golfier
 */
public class Territory {
	
	    public Color color;
	    public List<Pixel> pixelList;
	    public String name;
	    public Hashtable<String, String> terrAdjacent;
	    
	    public Territory (Color color) {
	        this.color = color;
	        this.pixelList = new ArrayList<Pixel>();
	        this.terrAdjacent = new Hashtable<String,String>();
			this.name = addName(color);
	    }
	    
	    public void addPixel(Pixel pixel){
	    	pixelList.add(pixel);
	    }
	    
	    public List<Pixel> getListPixel(){
	    	return pixelList;
	    }

		public String addName(Color color) {
			switch (color.toString()) {
				case "java.awt.Color[r=109,g=109,b=12]":
					terrAdjacent.put("Alaska", "North Canada");
					terrAdjacent.put("Alaska", "West Canada");
					terrAdjacent.put("Alaska", "East Russia");
					return "Alaska";
					 
				case "java.awt.Color[r=80,g=80,b=39]":
					terrAdjacent.put("North Canada", "West Canada");
					terrAdjacent.put("North Canada", "Center Canada");
					terrAdjacent.put("North Canada", "Greenland");
					return "North_Canada";
					 
				case "java.awt.Color[r=255,g=255,b=0]":
					terrAdjacent.put("West Canada", "Center Canada");
					terrAdjacent.put("West Canada", "North Canada");
					terrAdjacent.put("West Canada", "Alaska");
					terrAdjacent.put("West Canada", "West USA");
					return "West_Canada";
					 
				case "java.awt.Color[r=148,g=148,b=73]":
					return "Center_Canada";
					 
				case "java.awt.Color[r=184,g=184,b=61]":
					return "East_Canada";
					 
				case "java.awt.Color[r=100,g=100,b=40]":
					return "West_USA";
					 
				case "java.awt.Color[r=128,g=128,b=0]":
					return "East_USA";
					 
				case "java.awt.Color[r=255,g=255,b=128]":
					return "Mexico";
					 
				case "java.awt.Color[r=255,g=128,b=128]":
					return "North_Latin_America";
					 
				case "java.awt.Color[r=128,g=0,b=0]":
					return "West_Latin_America";
					 
				case "java.awt.Color[r=128,g=64,b=64]":
					return "East_Latin_America";
					 
				case "java.awt.Color[r=255,g=0,b=0]":
					return "South_Latin_America";
					 
				case "java.awt.Color[r=214,g=214,b=127]":
					return "Greenland";
					 
				case "java.awt.Color[r=83,g=83,b=163]":
					return "Iceland";
					 
				case "java.awt.Color[r=255,g=145,b=91]":
					return "West_Africa";
					 
				case "java.awt.Color[r=174,g=87,b=0]":
					return "Center_Africa";
					 
				case "java.awt.Color[r=203,g=148,b=92]":
					return "South_Africa";
					 
				case "java.awt.Color[r=121,g=70,b=51]":
					return "Madagascar";
					 
				case "java.awt.Color[r=255,g=128,b=0]":
					return "East_Africa";
					 
				case "java.awt.Color[r=128,g=64,b=0]":
					return "North_Africa";
					 
				case "java.awt.Color[r=0,g=64,b=128]":
					return "UK";
					 
				case "java.awt.Color[r=0,g=128,b=255]":
					return "West_Europe";
					 
				case "java.awt.Color[r=49,g=105,b=160]":
					return "South_Europe";
					 
				case "java.awt.Color[r=165,g=201,b=236]":
					return "Scandinavia";
					 
				case "java.awt.Color[r=0,g=0,b=255]":
					return "Center_Europe";
					 
				case "java.awt.Color[r=0,g=0,b=128]":
					return "East_Europe";
					 
				case "java.awt.Color[r=0,g=128,b=0]":
					return "Middle_East";
					 
				case "java.awt.Color[r=68,g=179,b=68]":
					return "NW_Russia";
					 
				case "java.awt.Color[r=93,g=145,b=145]":
					return "NE_Russia";
					 
				case "java.awt.Color[r=117,g=192,b=117]":
					return "West_Russia";
					 
				case "java.awt.Color[r=96,g=179,b=137]":
					return "East_Russia";
					 
				case "java.awt.Color[r=0,g=255,b=0]":
					return "South_Russia";
					 
				case "java.awt.Color[r=0,g=64,b=0]":
					return "Mongolia";
					 
				case "java.awt.Color[r=100,g=214,b=100]":
					return "Kazakhstan";
					 
				case "java.awt.Color[r=128,g=255,b=0]":
					return "Japan";
					 
				case "java.awt.Color[r=0,g=128,b=64]":
					return "China";
					 
				case "java.awt.Color[r=0,g=128,b=128]":
					return "India";
					 
				case "java.awt.Color[r=128,g=255,b=128]":
					return "Thailand";
					 
				case "java.awt.Color[r=128,g=0,b=255]":
					return "Indonesia";
					 
				case "java.awt.Color[r=255,g=0,b=255]":
					return "Papua";
					 
				case "java.awt.Color[r=128,g=0,b=64]":
					return "West_Australia";
					 
				case "java.awt.Color[r=64,g=0,b=64]":
					return "East_Australia";
					 
				default:
					return "Invalid_country";
					 
			}
		}




	}

