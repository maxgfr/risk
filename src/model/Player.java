/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author golfier
 */
public class Player {
	
    private String name;
    private int id;
    private Color color;
    private String maMission;
    private int nbArmy;
    private int nbRegion;
    private boolean biggestRegion;
    private int unitToDispatch;
    private boolean isFinished;
    
    public Player(int id, String name, Color color) {
            this.id = id;
            if(name.isEmpty()) {
                this.name = randomName();
            } else {
                this.name = name;
            }
            this.color = color;
            maMission = "";
            nbArmy = 0;
            nbRegion = 0;
            biggestRegion= false;
            
    }

    public int getId(){
            return id;
    }

    public String getName(){
            return name;
    }
    
    public String getMaMission(){
            return maMission;
    }

    public Color getColor () {
        return color;
    }
    
    public void setColor (Color color) {
        this.color = color;
    }
    
    public void setMaMission(String miss){
        maMission = miss;
    }

    
    private String randomName() {
        Random r = new Random();
        String value="";
        char random_Char ;
        for(int i=0; i<10;i++) { 
            random_Char = (char) (48 + r.nextInt(74));
            value=value+random_Char;
        }
        return value;
    }
    

	public int getUnitToDispatch() {
		return unitToDispatch;
	}

	public void setUnitToDispatch(int unitToDispatch) {
		this.unitToDispatch = unitToDispatch;
	}
        
    public int getNbArmy() {
    	return nbArmy;
	}

	public void setNbArmy(int nb) {
		this.nbArmy = nb;
	}
        
    public int getNbRegion() {
	return nbRegion;
	}

	public void setNbRegion(int nb) {
		this.nbRegion = nb;
	}
        
        public boolean getBiggestRegion() {
		return biggestRegion;
	}

	public void setBiggestRegion(boolean b) {
		this.biggestRegion = b;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

    public void attack(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Territory reinforcment(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}

