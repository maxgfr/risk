/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author golfier
 */
public class Mission {
    
   private static Mission instance = null;
   
   private boolean init;
   
   private static final String MISSION_1 = "Détruire le joueur";
   private static final String MISSION_2 = "Conquérir tous les territoires";
   private static final String MISSION_3 = "Contrôler 3 régions et au moins 18 territoires";
   private static final String MISSION_4 = "Contrôler 18 territoires avec au moins 2 armées";
   private static final String MISSION_5 = "Contrôler 30 territoires";
   private static final String MISSION_6 = "Contrôler 24 territoires";
   private static final String MISSION_7 = "Contrôler 21 territoires";
   private static final String MISSION_8 = "Contrôler la plus grosse région + 1 autre région";
   
   protected Mission() {
        init = false;
   }
   public static Mission getInstance() {
      if(instance == null) {
         instance = new Mission();
      }
      return instance;
   }
   
   
    
   public void initMission(List<Player> players) {
        if (isInit()) { // GAME INITIALIZED
            return;
        }
        int nb_players = players.size();
        Random rdm = new Random();
        int randomIndex = 0;
        List<String> allMissions = new ArrayList<>();
        for (Player player : players) {
            switch (nb_players) {
                case 1:  
                    allMissions.add(MISSION_3);
                    allMissions.add(MISSION_8);
                    randomIndex = rdm.nextInt(allMissions.size());
                    break;
                case 2:
                    allMissions.add(MISSION_2);
                    allMissions.add(MISSION_5);
                    allMissions.add(MISSION_8);
                    randomIndex = rdm.nextInt(allMissions.size());
                    break;
                case 3:
                    allMissions.add(MISSION_1);
                    allMissions.add(MISSION_2);
                    allMissions.add(MISSION_3);
                    allMissions.add(MISSION_4);
                    allMissions.add(MISSION_5);
                    allMissions.add(MISSION_8);
                    randomIndex = rdm.nextInt(allMissions.size());
                    break;
                case 4:  
                    allMissions.add(MISSION_1);
                    allMissions.add(MISSION_3);
                    allMissions.add(MISSION_4);
                    allMissions.add(MISSION_6);
                    allMissions.add(MISSION_8);
                    randomIndex = rdm.nextInt(allMissions.size());
                    break;
                case 5:  
                    allMissions.add(MISSION_1);
                    allMissions.add(MISSION_3);
                    allMissions.add(MISSION_4);
                    allMissions.add(MISSION_6);
                    allMissions.add(MISSION_8);
                    randomIndex = rdm.nextInt(allMissions.size());
                    break;
                case 6:
                    allMissions.add(MISSION_1);
                    allMissions.add(MISSION_3);
                    allMissions.add(MISSION_4);
                    allMissions.add(MISSION_7);
                    allMissions.add(MISSION_8);
                    randomIndex = rdm.nextInt(allMissions.size());
                    break;
                default:
                    break;
            }
            if (allMissions.get(randomIndex) == MISSION_1) {
                String name_gamer_to_destroy = players.get(rdm.nextInt(players.size())).getName();
                while (name_gamer_to_destroy == player.getName()) {
                    name_gamer_to_destroy = players.get(rdm.nextInt(players.size())).getName();
                }
                player.setMaMission(allMissions.get(randomIndex)+" "+name_gamer_to_destroy);
            } else {
                player.setMaMission(allMissions.get(randomIndex));
            } 
        }        
        init = true;  
    }
    
    public boolean isInit() {
        return init;
    }
    
    public boolean hasWin (Player player) {
        Game game = Game.getInstance();
        String mission_joueur = player.getMaMission();
        List<Territory> territories = game.getMaListeDeTerritoire();
        switch(mission_joueur) {
            case MISSION_1:
                String name_joueur_to_destroy = mission_joueur.replace("Détruire le joueur ","");
                System.out.println("Name gamer to destroy : "+name_joueur_to_destroy);
                Player to_Destroy = game.getPlayerWithName(name_joueur_to_destroy);
                boolean have_territory = false;
                if (to_Destroy != null) {
                    if (!TerritoryAssets.knowIfIhaveTerriority(territories, to_Destroy)) {
                        return true;
                    }    
                }              
                return false;
            case MISSION_2:
                if (TerritoryAssets.hasAllTerritories(territories, player)) {
                    return true;
                }
                return false;
            case MISSION_3:
                if (TerritoryAssets.controlTerritoryWithRegion(territories, player, 18, 3)) {
                    return true;
                }
                return false;
            case MISSION_4:
                if (TerritoryAssets.controlTerritoryWithArmy(territories, player, 18, 2)) {
                    return true;
                }
                return false;
            case MISSION_5:
                if (TerritoryAssets.controlTerritory(territories, player, 30)) {
                    return true;
                }
                return false;
            case MISSION_6:
                 if (TerritoryAssets.controlTerritory(territories, player, 24)) {
                    return true;
                }
                return false;
            case MISSION_7:
                if (TerritoryAssets.controlTerritory(territories, player, 21)) {
                    return true;
                }
                return false;
            case MISSION_8:
                if (TerritoryAssets.controlBiggestRegionWithAnotherRegion(territories, player)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
   
    
    

    
}
