/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author golfier
 */
public class AI extends Player {
    
    public AI(int id, String name, Color color) {
        super(id, name, color);
    }
    
    @Override
    public void attack(Game game) {
    	
    	boolean findTerritory = false;
        //Territory attacker = null;
        List<Territory> listTerritory = (List<Territory>) game.getMaListeDeTerritoire().stream().filter(
    			p -> p.player.equals(this)
    			&&
    			p.unitList.size() > 3
    			).collect(Collectors.toList());
        if (listTerritory.size() > 1){
        	int i = 0;
	        while(!findTerritory && i < 250) {
		    	for (Territory attacker: listTerritory){
		    		String nameAttacker = attacker.terrAdjacent.get(Integer.toString(new Random().nextInt(attacker.terrAdjacent.size())));
		        	List<Territory> listAttackable = (List<Territory>) game.getMaListeDeTerritoire().stream().filter(
		        			p -> !p.player.equals(this) && 
		        			p.name == nameAttacker
		        			).collect(Collectors.toList());
		        	if (!listAttackable.isEmpty()){
		        		findTerritory = true;
		        		game.setSelectedTerritory1(attacker);
		                game.setSelectedTerritory2(listAttackable.get(new Random().nextInt(listAttackable.size())));
		                break;
		        	}
		    	}
	        	//attacker = listTerritory.get(new Random().nextInt(listTerritory.size()));
	        	
	        	i++;
		    	
		    }
        }
        /*boolean findTerritory1 = false;
        boolean findTerritory2 = false;
        Territory selectedTerritory1 = null;
        Territory selectedTerritory2 = null;
        List<Territory> listTerritory = game.getMaListeDeTerritoire();
        while(!findTerritory1 || !findTerritory2) {
            for(Territory terr : listTerritory) {
                if(!findTerritory1) {
                    if(terr.player.getId() == this.getId()) {
                    	if (terr.unitList.size() > 3){
                    		selectedTerritory1 = terr;
                            findTerritory1 = true; 
                    	}
                        
                    }
                }
                if(terr.player.getId() != this.getId()) {
                   if (findTerritory1){
                       if (terr.terrAdjacent.contains(selectedTerritory1.name)){
                           selectedTerritory2 = terr;
                           findTerritory2 = true; 
                       }
                    }
                } 
            }
        }*/
        
    }
    
    @Override
    public void reinforcment(Game game) {
    	List<Territory> listTerritory = new ArrayList<Territory>();
    	for (Territory terr : game.getMaListeDeTerritoire()) {
            if (terr.player.equals(this)) {
            	listTerritory.add(terr);
            }
        }
        while(this.getUnitToDispatch() > 0){
        	Unit[]  listUnit = {new Unit(TypeUnit.SOLDIER),new Unit(TypeUnit.CANNON), new Unit(TypeUnit.HORSE_RIDER)};
        	Unit unitDispatched = listUnit[( (int) new Random().nextInt(listUnit.length))];
        	if (unitDispatched.getCost() <= this.getUnitToDispatch()){
        		listTerritory.get(new Random().nextInt(listTerritory.size())).getUnitList().add(unitDispatched);
            	this.setUnitToDispatch(this.getUnitToDispatch() - unitDispatched.getCost());
        	}
        	
        }
        
    }
    
}
