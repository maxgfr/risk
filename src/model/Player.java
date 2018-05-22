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
    private List<Territory> mTerritories;
    private int nbSold;
    private Color color;

    public Player(int id, String name, Color color) {
            this.id = id;
            if(name.isEmpty()) {
                this.name = randomName();
            } else {
                this.name = name;
            }
            this.color = color;
            mTerritories = new ArrayList<Territory>();
            nbSold = 0;
    }

    public int getId(){
            return id;
    }

    public String getName(){
            return name;
    }

    public List<Territory> getTerritories(){
            return mTerritories;
    }

    public int numOfTerritories(){
            return mTerritories.size();
    }

    public void addTerritory(Territory t){
            mTerritories.add(t);
    }

    public void removeTerritory(Territory t){
            mTerritories.remove(t);
    }

    public void addArmies(int a){
            nbSold += a;
    }

    public void addArmy(){
        nbSold++;
    }

    public void looseArmies(int a){
        nbSold -= a;
    }

    public void looseArmy(){
        nbSold--;
    }
    
    public Color getColor () {
        return color;
    }
    
    public void setColor (Color color) {
        this.color = color;
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
    
    private Color randomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }
	
}

