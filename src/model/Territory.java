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
	    public List<Unit> unitList;
	    
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
					terrAdjacent.put("Alaska", "North_Canada");
					terrAdjacent.put("Alaska", "West_Canada");
					terrAdjacent.put("Alaska", "East_Russia");
					return "Alaska";
					 
				case "java.awt.Color[r=80,g=80,b=39]":
					terrAdjacent.put("North_Canada", "West_Canada");
					terrAdjacent.put("North_Canada", "Center_Canada");
					terrAdjacent.put("North_Canada", "Greenland");
					return "North_Canada";
					
				case "java.awt.Color[r=255,g=255,b=0]":
					terrAdjacent.put("West_Canada", "Center_Canada");
					terrAdjacent.put("West_Canada", "North_Canada");
					terrAdjacent.put("West_Canada", "Alaska");
					terrAdjacent.put("West_Canada", "West_USA");
					return "West_Canada";
					 
				case "java.awt.Color[r=148,g=148,b=73]":
					terrAdjacent.put("Center_Canada", "North_Canada");
					terrAdjacent.put("Center_Canada", "West_Canada");
					terrAdjacent.put("Center_Canada", "West_USA");
					terrAdjacent.put("Center_Canada", "East_USA");
					terrAdjacent.put("Center_Canada", "East_Canada");
					return "Center_Canada";
					 
				case "java.awt.Color[r=184,g=184,b=61]":
					terrAdjacent.put("East_Canada", "East_USA");
					terrAdjacent.put("East_Canada", "Center_Canada");
					terrAdjacent.put("East_Canada", "Greenland");
					return "East_Canada";
					
					 
				case "java.awt.Color[r=100,g=100,b=40]":
					terrAdjacent.put("West_USA","West_Canada");
					terrAdjacent.put("West_USA","Center_Canada");
					terrAdjacent.put("West_USA","East_USA");
					terrAdjacent.put("West_USA","Mexico");
					return "West_USA";
					 
				case "java.awt.Color[r=128,g=128,b=0]":
					terrAdjacent.put("East_USA","West_USA");
					terrAdjacent.put("East_USA","Mexico");
					terrAdjacent.put("East_USA","Center_Canada");
					terrAdjacent.put("East_USA","East_Canada");
					return "East_USA";
					 
				case "java.awt.Color[r=255,g=255,b=128]":
					terrAdjacent.put("Mexico","East_USA");
					terrAdjacent.put("Mexico","West_USA");
					terrAdjacent.put("Mexico","North_Latin_America");
					return "Mexico";
					 
				case "java.awt.Color[r=255,g=128,b=128]":
					terrAdjacent.put("North_Latin_America","Mexico");
					terrAdjacent.put("North_Latin_America","West_Latin_America");
					terrAdjacent.put("North_Latin_America","East_Latin_America");
					return "North_Latin_America";
					 
				case "java.awt.Color[r=128,g=0,b=0]":
					terrAdjacent.put("West_Latin_America","East_Latin_America");
					terrAdjacent.put("West_Latin_America","North_Latin_America");
					terrAdjacent.put("West_Latin_America","South_Latin_America");
					return "West_Latin_America";
					 
				case "java.awt.Color[r=128,g=64,b=64]":
					terrAdjacent.put("East_Latin_America","West_Latin_America");
					terrAdjacent.put("East_Latin_America","North_Latin_America");
					terrAdjacent.put("East_Latin_America","South_Latin_America");
					terrAdjacent.put("East_Latin_America","West_Africa");
					return "East_Latin_America";
					 
				case "java.awt.Color[r=255,g=0,b=0]":
					terrAdjacent.put("South_Latin_America","West_Latin_America");
					terrAdjacent.put("South_Latin_America","East_Latin_America");
					return "South_Latin_America";
					 
				case "java.awt.Color[r=214,g=214,b=127]":
					terrAdjacent.put("Greenland","North_Canada");
					terrAdjacent.put("Greenland","Center_Canada");
					terrAdjacent.put("Greenland","East_Canada");
					terrAdjacent.put("Greenland","Iceland");
					return "Greenland";
					 
				case "java.awt.Color[r=83,g=83,b=163]":
					terrAdjacent.put("Iceland","Greenland");
					terrAdjacent.put("Iceland","UK");
					terrAdjacent.put("Iceland","Scandinavia");
					return "Iceland";
					 
				case "java.awt.Color[r=255,g=145,b=91]":
					terrAdjacent.put("West_Africa","East_Latin_America");
					terrAdjacent.put("West_Africa","Center_Africa");
					terrAdjacent.put("West_Africa","East_Africa");
					terrAdjacent.put("West_Africa","North_Africa");
					terrAdjacent.put("West_Africa","West_Europe");
					terrAdjacent.put("West_Africa","South_Europe");
					return "West_Africa";
					 
				case "java.awt.Color[r=174,g=87,b=0]":
					terrAdjacent.put("Center_Africa","East_Africa");
					terrAdjacent.put("Center_Africa","West_Africa");
					terrAdjacent.put("Center_Africa","South_Africa");
					return "Center_Africa";
					 
				case "java.awt.Color[r=203,g=148,b=92]":
					terrAdjacent.put("South_Africa","East_Africa");
					terrAdjacent.put("South_Africa","Center_Africa");
					terrAdjacent.put("South_Africa","Madagascar");
					return "South_Africa";
					 
				case "java.awt.Color[r=121,g=70,b=51]":
					terrAdjacent.put("Madagascar","East_Africa");
					terrAdjacent.put("Madagascar","South_Africa");
					return "Madagascar";
					 
				case "java.awt.Color[r=255,g=128,b=0]":
					terrAdjacent.put("East_Africa","South_Africa");
					terrAdjacent.put("East_Africa","North_Africa");
					terrAdjacent.put("East_Africa","Center_Africa");
					terrAdjacent.put("East_Africa","West_Africa");
					terrAdjacent.put("East_Africa","Madagascar");
					terrAdjacent.put("East_Africa","Middle_East");
					return "East_Africa";
					 
				case "java.awt.Color[r=128,g=64,b=0]":
					terrAdjacent.put("North_Africa","West_Africa");
					terrAdjacent.put("North_Africa","East_Africa");
					terrAdjacent.put("North_Africa","Middle_East");
					terrAdjacent.put("North_Africa","South_Europe");
					return "North_Africa";
					 
				case "java.awt.Color[r=0,g=64,b=128]":
					terrAdjacent.put("UK","Iceland");
					terrAdjacent.put("UK","Scandinavia");
					terrAdjacent.put("UK","West_Europe");
					terrAdjacent.put("UK","Center_Europe");
					return "UK";
					 
				case "java.awt.Color[r=0,g=128,b=255]":
					terrAdjacent.put("West_Europe","UK");
					terrAdjacent.put("West_Europe","Center_Europe");
					terrAdjacent.put("West_Europe","South_Europe");
					terrAdjacent.put("West_Europe","West_Africa");
					return "West_Europe";
					 
				case "java.awt.Color[r=49,g=105,b=160]":
					terrAdjacent.put("South_Europe","West_Europe");
					terrAdjacent.put("South_Europe","Center_Europe");
					terrAdjacent.put("South_Europe","East_Europe");
					terrAdjacent.put("South_Europe","West_Africa");
					terrAdjacent.put("South_Europe","Middle_East");
					terrAdjacent.put("South_Europe","North_Africa");
					return "South_Europe";
					 
				case "java.awt.Color[r=165,g=201,b=236]":
					terrAdjacent.put("Scandinavia","Iceland");
					terrAdjacent.put("Scandinavia","UK");
					terrAdjacent.put("Scandinavia","Center_Europe");
					terrAdjacent.put("Scandinavia","East_Europe");
					return "Scandinavia";
					 
				case "java.awt.Color[r=0,g=0,b=255]":
					terrAdjacent.put("Center_Europe","West_Europe");
					terrAdjacent.put("Center_Europe","UK");
					terrAdjacent.put("Center_Europe","Scandinavia");
					terrAdjacent.put("Center_Europe","South_Europe");
					terrAdjacent.put("Center_Europe","East_Europe");
					return "Center_Europe";
					 
				case "java.awt.Color[r=0,g=0,b=128]":
					terrAdjacent.put("East_Europe","South_Europe");
					terrAdjacent.put("East_Europe","Center_Europe");
					terrAdjacent.put("East_Europe","Scandinavia");
					terrAdjacent.put("East_Europe","Middle_East");
					terrAdjacent.put("East_Europe","West_Russia");
					terrAdjacent.put("East_Europe","Kazakhstan");
					return "East_Europe";
					 
				case "java.awt.Color[r=0,g=128,b=0]":
					terrAdjacent.put("Middle_East","North_Africa");
					terrAdjacent.put("Middle_East","East_Africa");
					terrAdjacent.put("Middle_East","South_Europe");
					terrAdjacent.put("Middle_East","East_Europe");
					terrAdjacent.put("Middle_East","Kazakhstan");
					terrAdjacent.put("Middle_East","India");
					return "Middle_East";
					 
				case "java.awt.Color[r=68,g=179,b=68]":
					terrAdjacent.put("NW_Russia","NE_Russia");
					terrAdjacent.put("NW_Russia","West_Russia");
					terrAdjacent.put("NW_Russia","South_Russia");
					terrAdjacent.put("NW_Russia","China");
					terrAdjacent.put("NW_Russia","Mongolia");
					return "NW_Russia";
					 
				case "java.awt.Color[r=93,g=145,b=145]":
					terrAdjacent.put("NE_Russia","NW_Russia");
					terrAdjacent.put("NE_Russia","South_Russia");
					terrAdjacent.put("NE_Russia","East_Russia");
					return "NE_Russia";
					 
				case "java.awt.Color[r=117,g=192,b=117]":
					terrAdjacent.put("West_Russia","NW_Russia");
					terrAdjacent.put("West_Russia","East_Europe");
					terrAdjacent.put("West_Russia","Kazakhstan");
					terrAdjacent.put("West_Russia","China");
					return "West_Russia";
					 
				case "java.awt.Color[r=96,g=179,b=137]":
					terrAdjacent.put("East_Russia","South_Russia");
					terrAdjacent.put("East_Russia","NE_Russia");
					terrAdjacent.put("East_Russia","Mongolia");
					terrAdjacent.put("East_Russia","Japan");
					terrAdjacent.put("East_Russia","Alaska");
					return "East_Russia";
					 
				case "java.awt.Color[r=0,g=255,b=0]":
					terrAdjacent.put("South_Russia","NW_Russia");
					terrAdjacent.put("South_Russia","NE_Russia");
					terrAdjacent.put("South_Russia","East_Russia");
					terrAdjacent.put("South_Russia","Mongolia");
					return "South_Russia";
					 
				case "java.awt.Color[r=0,g=64,b=0]":
					terrAdjacent.put("Mongolia","Japan");
					terrAdjacent.put("Mongolia","China");
					terrAdjacent.put("Mongolia","South_Russia");
					terrAdjacent.put("Mongolia","NW_Russia");
					terrAdjacent.put("Mongolia","East_Russia");
					return "Mongolia";
					 
				case "java.awt.Color[r=100,g=214,b=100]":
					terrAdjacent.put("Kazakhstan","West_Russia");
					terrAdjacent.put("Kazakhstan","Middle_East");
					terrAdjacent.put("Kazakhstan","India");
					terrAdjacent.put("Kazakhstan","China");
					terrAdjacent.put("Kazakhstan","East_Europe");
					return "Kazakhstan";
					 
				case "java.awt.Color[r=128,g=255,b=0]":
					terrAdjacent.put("Japan","Mongolia");
					terrAdjacent.put("Japan","East_Russia");
					return "Japan";
					 
				case "java.awt.Color[r=0,g=128,b=64]":
					terrAdjacent.put("China","India");
					terrAdjacent.put("China","Thailand");
					terrAdjacent.put("China","Kazakhstan");
					terrAdjacent.put("China","Mongolia");
					terrAdjacent.put("China","West_Russia");
					terrAdjacent.put("China","NW_Russia");
					return "China";
					 
				case "java.awt.Color[r=0,g=128,b=128]":
					terrAdjacent.put("India","Thailand");
					terrAdjacent.put("India","China");
					terrAdjacent.put("India","Kazakhstan");
					terrAdjacent.put("India","Middle_East");
					return "India";
					 
				case "java.awt.Color[r=128,g=255,b=128]":
					terrAdjacent.put("Thailand","India");
					terrAdjacent.put("Thailand","China");
					terrAdjacent.put("Thailand","Indonesia");
					return "Thailand";
					 
				case "java.awt.Color[r=128,g=0,b=255]":
					terrAdjacent.put("Indonesia","Thailand");
					terrAdjacent.put("Indonesia","Papua");
					terrAdjacent.put("Indonesia","Australia");
					return "Indonesia";
					 
				case "java.awt.Color[r=255,g=0,b=255]":
					terrAdjacent.put("Papua","Indonesia");
					terrAdjacent.put("Papua","West_Australia");
					terrAdjacent.put("Papua","East_Australia");
					return "Papua";
					 
				case "java.awt.Color[r=128,g=0,b=64]":
					terrAdjacent.put("West_Australia","East_Australia");
					terrAdjacent.put("West_Australia","Indonesia");
					terrAdjacent.put("West_Australia","Papua");
					return "West_Australia";
					 
				case "java.awt.Color[r=64,g=0,b=64]":
					terrAdjacent.put("East_Australia","West_Australia");
					terrAdjacent.put("East_Australia","Papua");
					return "East_Australia";
					 
				default:
					//terrAdjacent.put(null);
					return "Invalid_country";
					 
			}
		}

		
		/**
		 * @return the unitList
		 */
		public List<Unit> getUnitList() {
			return unitList;
		}

		/**
		 * @param unitList the unitList to set
		 */
		public void setUnitList(List<Unit> unitList) {
			this.unitList = unitList;
		}

		


	}

