/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.List;

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
        boolean findTerritory1 = false;
        boolean findTerritory2 = false;
        Territory selectedTerritory1 = null;
        Territory selectedTerritory2 = null;
        List<Territory> listTerritory = game.getMaListeDeTerritoire();
        while(!findTerritory1 || !findTerritory2) {
            for(Territory terr : listTerritory) {
                if(!findTerritory1) {
                    if(terr.player.getId() == this.getId()) {
                        selectedTerritory1 = terr;
                        findTerritory1 = true; 
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
        }
        game.setSelectedTerritory1(selectedTerritory1);
        game.setSelectedTerritory2(selectedTerritory2);
    }
    
    @Override
    public Territory reinforcment(Game game) {
        List<Territory> listTerritory = game.getMaListeDeTerritoire();
        for(Territory terr : listTerritory) {
            if (terr.player.equals(this)){
                Unit unitToDispatch = new Unit(game.getSelectedUnitType());
                if(this.getUnitToDispatch() >= unitToDispatch.getCost()){
                    terr.getUnitList().add(unitToDispatch);
                    return terr;
                }
            }
        }
        
        return null;
    }
    
}
