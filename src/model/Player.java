/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author golfier
 */
public class Player {
	
	private String name;
	private int id;
	private List<Territory> mTerritories;
	private int nbSold;
	
	Player(String name, int id) {
		this.name = name;
		this.id = id;
		mTerritories = new ArrayList<Territory>();
                nbSold = 0;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}

	public List<Territory> getOccupiedTerritories(){
		return mTerritories;
	}

	public int numOfTerritories(){
		return mTerritories.size();
	}
	
	public void occupyTerritory(Territory t){
		mTerritories.add(t);
	}
	
	public void looseTerritory(Territory t){
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
	
	
}

