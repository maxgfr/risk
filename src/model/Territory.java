/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
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
            public String region;
            public Player player;


            public Territory(){}
		
	    public Territory (Color color) {
	        this.color = color;
	        this.pixelList = new ArrayList<Pixel>();
	        this.terrAdjacent = new Hashtable<String,String>();
			this.name = addName(color);
			this.unitList = new ArrayList<Unit>();
	    }
	    
	    public void addPixel(Pixel pixel){
	    	pixelList.add(pixel);
	    }
	    
	    public List<Pixel> getListPixel(){
	    	return pixelList;
	    }

	    public String getRegion(){
	    	return this.region;

		}
            
        public void setBatailleTerritoire (Player player, List<Unit> unitList) {
            this.player = player;
            this.unitList = unitList;
        }

		public String addName(Color color) {
			switch (color.toString()) {
				case "java.awt.Color[r=109,g=109,b=12]":
					terrAdjacent.put("1", "North_Canada");
					terrAdjacent.put("2", "West_Canada");
					terrAdjacent.put("3", "East_Russia");
					this.region="North_America";
					return "Alaska";
					 
				case "java.awt.Color[r=80,g=80,b=39]":
					terrAdjacent.put("1", "West_Canada");
					terrAdjacent.put("2", "Center_Canada");
					terrAdjacent.put("3", "Greenland");
					this.region="North_America";
					return "North_Canada";
					
				case "java.awt.Color[r=255,g=255,b=0]":
					terrAdjacent.put("1", "Center_Canada");
					terrAdjacent.put("2", "North_Canada");
					terrAdjacent.put("3", "Alaska");
					terrAdjacent.put("4", "West_USA");
					this.region="North_America";
					return "West_Canada";
					 
				case "java.awt.Color[r=148,g=148,b=73]":
					terrAdjacent.put("1", "North_Canada");
					terrAdjacent.put("2", "West_Canada");
					terrAdjacent.put("3", "West_USA");
					terrAdjacent.put("4", "East_USA");
					terrAdjacent.put("5", "East_Canada");
					this.region="North_America";
					return "Center_Canada";
					 
				case "java.awt.Color[r=184,g=184,b=61]":
					terrAdjacent.put("1", "East_USA");
					terrAdjacent.put("2", "Center_Canada");
					terrAdjacent.put("3", "Greenland");
					this.region="North_America";
					return "East_Canada";
					
					 
				case "java.awt.Color[r=100,g=100,b=40]":
					terrAdjacent.put("1","West_Canada");
					terrAdjacent.put("2","Center_Canada");
					terrAdjacent.put("3","East_USA");
					terrAdjacent.put("4","Mexico");
					this.region="North_America";
					return "West_USA";
					 
				case "java.awt.Color[r=128,g=128,b=0]":
					terrAdjacent.put("1","West_USA");
					terrAdjacent.put("2","Mexico");
					terrAdjacent.put("3","Center_Canada");
					terrAdjacent.put("4","East_Canada");
					this.region="North_America";
					return "East_USA";
					 
				case "java.awt.Color[r=255,g=255,b=128]":
					terrAdjacent.put("1","East_USA");
					terrAdjacent.put("2","West_USA");
					terrAdjacent.put("3","North_Latin_America");
					this.region="North_America";
					return "Mexico";
					 
				case "java.awt.Color[r=255,g=128,b=128]":
					terrAdjacent.put("1","Mexico");
					terrAdjacent.put("2","West_Latin_America");
					terrAdjacent.put("3","East_Latin_America");
					this.region="South_America";
					return "North_Latin_America";
					 
				case "java.awt.Color[r=128,g=0,b=0]":
					terrAdjacent.put("1","East_Latin_America");
					terrAdjacent.put("2","North_Latin_America");
					terrAdjacent.put("3","South_Latin_America");
					this.region="South_America";
					return "West_Latin_America";
					 
				case "java.awt.Color[r=128,g=64,b=64]":
					terrAdjacent.put("1","West_Latin_America");
					terrAdjacent.put("2","North_Latin_America");
					terrAdjacent.put("3","South_Latin_America");
					terrAdjacent.put("4","West_Africa");
					this.region="South_America";
					return "East_Latin_America";
					 
				case "java.awt.Color[r=255,g=0,b=0]":
					terrAdjacent.put("1","West_Latin_America");
					terrAdjacent.put("2","East_Latin_America");
					this.region="South_America";
					return "South_Latin_America";
					 
				case "java.awt.Color[r=214,g=214,b=127]":
					terrAdjacent.put("1","North_Canada");
					terrAdjacent.put("2","Center_Canada");
					terrAdjacent.put("3","East_Canada");
					terrAdjacent.put("4","Iceland");
					this.region="North_America";
					return "Greenland";
					 
				case "java.awt.Color[r=83,g=83,b=163]":
					terrAdjacent.put("1","Greenland");
					terrAdjacent.put("2","UK");
					terrAdjacent.put("3","Scandinavia");
					this.region="Europe";
					return "Iceland";
					 
				case "java.awt.Color[r=255,g=145,b=91]":
					terrAdjacent.put("1","East_Latin_America");
					terrAdjacent.put("2","Center_Africa");
					terrAdjacent.put("3","East_Africa");
					terrAdjacent.put("4","North_Africa");
					terrAdjacent.put("5","West_Europe");
					terrAdjacent.put("6","South_Europe");
					this.region="Africa";
					return "West_Africa";
					 
				case "java.awt.Color[r=174,g=87,b=0]":
					terrAdjacent.put("1","East_Africa");
					terrAdjacent.put("2","West_Africa");
					terrAdjacent.put("3","South_Africa");
					this.region="Africa";
					return "Center_Africa";
					 
				case "java.awt.Color[r=203,g=148,b=92]":
					terrAdjacent.put("1","East_Africa");
					terrAdjacent.put("2","Center_Africa");
					terrAdjacent.put("3","Madagascar");
					this.region="Africa";
					return "South_Africa";
					 
				case "java.awt.Color[r=121,g=70,b=51]":
					terrAdjacent.put("1","East_Africa");
					terrAdjacent.put("2","South_Africa");
					this.region="Africa";
					return "Madagascar";
					 
				case "java.awt.Color[r=255,g=128,b=0]":
					terrAdjacent.put("1","South_Africa");
					terrAdjacent.put("2","North_Africa");
					terrAdjacent.put("3","Center_Africa");
					terrAdjacent.put("4","West_Africa");
					terrAdjacent.put("5","Madagascar");
					terrAdjacent.put("6","Middle_East");
					this.region="Africa";
					return "East_Africa";
					 
				case "java.awt.Color[r=128,g=64,b=0]":
					terrAdjacent.put("1","West_Africa");
					terrAdjacent.put("2","East_Africa");
					terrAdjacent.put("3","Middle_East");
					terrAdjacent.put("4","South_Europe");
					this.region="Africa";
					return "North_Africa";
					 
				case "java.awt.Color[r=0,g=64,b=128]":
					terrAdjacent.put("1","Iceland");
					terrAdjacent.put("2","Scandinavia");
					terrAdjacent.put("3","West_Europe");
					terrAdjacent.put("4","Center_Europe");
					this.region="Europe";
					return "UK";
					 
				case "java.awt.Color[r=0,g=128,b=255]":
					terrAdjacent.put("1","UK");
					terrAdjacent.put("2","Center_Europe");
					terrAdjacent.put("3","South_Europe");
					terrAdjacent.put("4","West_Africa");
					this.region="Europe";
					return "West_Europe";
					 
				case "java.awt.Color[r=49,g=105,b=160]":
					terrAdjacent.put("1","West_Europe");
					terrAdjacent.put("2","Center_Europe");
					terrAdjacent.put("3","East_Europe");
					terrAdjacent.put("4","West_Africa");
					terrAdjacent.put("5","Middle_East");
					terrAdjacent.put("6","North_Africa");
					this.region="Europe";
					return "South_Europe";
					 
				case "java.awt.Color[r=165,g=201,b=236]":
					terrAdjacent.put("1","Iceland");
					terrAdjacent.put("2","UK");
					terrAdjacent.put("3","Center_Europe");
					terrAdjacent.put("4","East_Europe");
					this.region="Europe";
					return "Scandinavia";
					 
				case "java.awt.Color[r=0,g=0,b=255]":
					terrAdjacent.put("1","West_Europe");
					terrAdjacent.put("2","UK");
					terrAdjacent.put("3","Scandinavia");
					terrAdjacent.put("4","South_Europe");
					terrAdjacent.put("5","East_Europe");
					this.region="Europe";
					return "Center_Europe";
					 
				case "java.awt.Color[r=0,g=0,b=128]":
					terrAdjacent.put("1","South_Europe");
					terrAdjacent.put("2","Center_Europe");
					terrAdjacent.put("3","Scandinavia");
					terrAdjacent.put("4","Middle_East");
					terrAdjacent.put("5","West_Russia");
					terrAdjacent.put("6","Kazakhstan");
					this.region="Europe";
					return "East_Europe";
					 
				case "java.awt.Color[r=0,g=128,b=0]":
					terrAdjacent.put("1","North_Africa");
					terrAdjacent.put("2","East_Africa");
					terrAdjacent.put("3","South_Europe");
					terrAdjacent.put("4","East_Europe");
					terrAdjacent.put("5","Kazakhstan");
					terrAdjacent.put("6","India");
					this.region="Asia";
					return "Middle_East";
					 
				case "java.awt.Color[r=68,g=179,b=68]":
					terrAdjacent.put("1","NE_Russia");
					terrAdjacent.put("2","West_Russia");
					terrAdjacent.put("3","South_Russia");
					terrAdjacent.put("4","China");
					terrAdjacent.put("5","Mongolia");
					this.region="Asia";
					return "NW_Russia";
					 
				case "java.awt.Color[r=93,g=145,b=145]":
					terrAdjacent.put("1","NW_Russia");
					terrAdjacent.put("2","South_Russia");
					terrAdjacent.put("3","East_Russia");
					this.region="Asia";
					return "NE_Russia";
					 
				case "java.awt.Color[r=117,g=192,b=117]":
					terrAdjacent.put("1","NW_Russia");
					terrAdjacent.put("2","East_Europe");
					terrAdjacent.put("3","Kazakhstan");
					terrAdjacent.put("4","China");
					this.region="Asia";
					return "West_Russia";
					 
				case "java.awt.Color[r=96,g=179,b=137]":
					terrAdjacent.put("1","South_Russia");
					terrAdjacent.put("2","NE_Russia");
					terrAdjacent.put("3","Mongolia");
					terrAdjacent.put("4","Japan");
					terrAdjacent.put("5","Alaska");
					this.region="Asia";
					return "East_Russia";
					 
				case "java.awt.Color[r=0,g=255,b=0]":
					terrAdjacent.put("1","NW_Russia");
					terrAdjacent.put("2","NE_Russia");
					terrAdjacent.put("3","East_Russia");
					terrAdjacent.put("4","Mongolia");
					this.region="Asia";
					return "South_Russia";
					 
				case "java.awt.Color[r=0,g=64,b=0]":
					terrAdjacent.put("1","Japan");
					terrAdjacent.put("2","China");
					terrAdjacent.put("3","South_Russia");
					terrAdjacent.put("4","NW_Russia");
					terrAdjacent.put("5","East_Russia");
					this.region="Asia";
					return "Mongolia";
					 
				case "java.awt.Color[r=100,g=214,b=100]":
					terrAdjacent.put("1","West_Russia");
					terrAdjacent.put("2","Middle_East");
					terrAdjacent.put("3","India");
					terrAdjacent.put("4","China");
					terrAdjacent.put("5","East_Europe");
					this.region="Asia";
					return "Kazakhstan";
					 
				case "java.awt.Color[r=128,g=255,b=0]":
					terrAdjacent.put("1","Mongolia");
					terrAdjacent.put("2","East_Russia");
					this.region="Asia";
					return "Japan";
					 
				case "java.awt.Color[r=0,g=128,b=64]":
					terrAdjacent.put("1","Thailand");
					terrAdjacent.put("2","Kazakhstan");
					terrAdjacent.put("3","Mongolia");
					terrAdjacent.put("4","West_Russia");
					terrAdjacent.put("5","NW_Russia");
					this.region="Asia";
					return "China";
					 
				case "java.awt.Color[r=0,g=128,b=128]":
					terrAdjacent.put("1","Thailand");
					terrAdjacent.put("2","China");
					terrAdjacent.put("3","Kazakhstan");
					terrAdjacent.put("4","Middle_East");
					this.region="Asia";
					return "India";
					 
				case "java.awt.Color[r=128,g=255,b=128]":
					terrAdjacent.put("1","India");
					terrAdjacent.put("2","China");
					terrAdjacent.put("3","Indonesia");
					this.region="Asia";
					return "Thailand";
					 
				case "java.awt.Color[r=128,g=0,b=255]":
					terrAdjacent.put("1","Papua");
					terrAdjacent.put("2","Australia");
					this.region="Asia";
					return "Indonesia";
					 
				case "java.awt.Color[r=255,g=0,b=255]":
					terrAdjacent.put("1","Indonesia");
					terrAdjacent.put("2","West_Australia");
					terrAdjacent.put("3","East_Australia");
					this.region="Oceania";
					return "Papua";
					 
				case "java.awt.Color[r=128,g=0,b=64]":
					terrAdjacent.put("1","East_Australia");
					terrAdjacent.put("2","Indonesia");
					terrAdjacent.put("3","Papua");
					this.region="Oceania";
					return "West_Australia";
					 
				case "java.awt.Color[r=64,g=0,b=64]":
					terrAdjacent.put("1","West_Australia");
					terrAdjacent.put("2","Papua");
					this.region="Oceania";
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

		public void setPlayer(Player player){
			this.player = player;
		}
		
		public int getUnitNumberOfType(TypeUnit type){
			return (int) unitList.stream().filter(p -> p.getType().equals(type)).count();
		}
		
		public Unit getUnitByType(TypeUnit type){
			return (Unit) unitList.stream().filter(p -> p.getType().equals(type)).findFirst().get();
		}

		public int nbOfUnits(TypeUnit unit){
			return (int) unitList.stream().filter(p -> p.getType().equals(unit)).count();
		}

	}

