package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TerritoryAssets {

    public static void displayListUnit(List<Unit> unitList) {
        System.out.println("------\nDISPLAY UNIT LIST");
        for (Unit unit : unitList) {
              System.out.println(unit.toString());
         }
        System.out.println("END DISPLAY UNIT LIST\n------");
    }

    public TerritoryAssets(){}

    public static boolean containsTerritory(List<Territory> territories, Color couleur) {

    for (Territory terr : territories) {
            if (terr.color.equals(couleur)) {
                return true;
            }
        }
        return false;
    }

    public static void addTerritoryPixel(List<Territory> territories, Pixel pixel) {

                    for (Territory terr : territories) {
                    if (terr.color.equals(pixel.color)) {
                        terr.addPixel(pixel);
                    }
                }
            }

    public static int countRegions(List<Territory> territories) {
            List<String>  controlledRegions = new ArrayList<>();
            int northAmerica = 0;
            int southAmerica = 0;
            int europe = 0;
            int africa = 0;
            int asia = 0;
            int oceania =0;
            for (Territory element: territories){
                    switch (element.getRegion()) {
                            case "North_America": northAmerica++;
                                    break;
                            case "South_America": southAmerica++;
                                    break;
                            case "Europe": europe++;
                                break;
                            case "Africa": africa++;
                                    break;
                            case "Asia": asia++;
                                    break;
                            case "Oceania": oceania++;
                                    break;
                    }
            }
            if (northAmerica == 9){
                    controlledRegions.add("North_America");}
            if (southAmerica == 4){
                    controlledRegions.add("South_America");}
            if (europe == 7){
                    controlledRegions.add("Europe");}
            if (africa == 6){
                    controlledRegions.add("Africa");}
            if (asia == 12){
                    controlledRegions.add("Asia");}
            if (oceania== 4){
                    controlledRegions.add("Oceania");}
            for (String element: controlledRegions){
                    System.out.println(element);
            }
            return controlledRegions.size();
    }
    
    public static boolean hasBiggestRegion(List<Territory> territories) {
            List<String>  controlledRegions = new ArrayList<>();
            int northAmerica = 0;
            int southAmerica = 0;
            int europe = 0;
            int africa = 0;
            int asia = 0;
            int oceania =0;
            for (Territory element: territories){
                    switch (element.getRegion()) {
                            case "North_America": northAmerica++;
                                    break;
                            case "South_America": southAmerica++;
                                    break;
                            case "Europe": europe++;
                                break;
                            case "Africa": africa++;
                                    break;
                            case "Asia": asia++;
                                    break;
                            case "Oceania": oceania++;
                                    break;
                    }
            }
           if (asia == 12){
               return true;
           }
            return false;
    }
    
        
        public static boolean knowIfIhaveTerriority(List<Territory> territories, Player to_Destroy) {   
            for(Territory ter : territories) {
                if (ter.player.getId() == to_Destroy.getId()) {
                    return true;
                }
            }
            return false;
        }
        
        public static boolean hasAllTerritories(List<Territory> territories, Player player) {
            for (Territory terr : territories) {
                if (terr.player.getId() != player.getId()) {
                    return false;
                }
            }
            return true;
        }
        
        public static boolean controlTerritoryWithRegion(List<Territory> territories, Player player, int nbTerritory, int nbRegion) {
            int i =0;
            List<Territory> territoriesOfGamer = new ArrayList<>();
            for (Territory terr : territories) {
               if (terr.player.getId() != player.getId()) {
                   i++;
                   territoriesOfGamer.add(terr);
               }
            }
            if (i>= nbTerritory && countRegions(territoriesOfGamer) >= nbRegion) {
                return true;
            }
            return false;
        }

        public static boolean controlTerritoryWithArmy(List<Territory> territories, Player player, int nbTerritory, int nbArmy) {
            int i =0;
            int nb_army = 0;
            for (Territory terr : territories) {
               if (terr.player.getId() != player.getId()) {
                   i++;
                   if(terr.getUnitList().size() >= 2) {
                       nb_army ++;
                   }
               }
            }
            if (i>= nbTerritory &&  nb_army >= nbArmy) {
                return true;
            }
            return false;
        }

        public static boolean controlTerritory(List<Territory> territories, Player player, int nbTerritory) {
            int i =0;
            for (Territory terr : territories) {
               if (terr.player.getId() != player.getId()) {
                   i++;
               }
            }
            if (i>= nbTerritory) {
                return true;
            }
            return false;
        }

        public static boolean controlBiggestRegionWithAnotherRegion(List<Territory> territories, Player player) {
            int i =0;
            List<Territory> territoriesOfGamer = new ArrayList<>();
            for (Territory terr : territories) {
               if (terr.player.getId() != player.getId()) {
                   i++;
                   territoriesOfGamer.add(terr);
               }
            }
            if (hasBiggestRegion(territoriesOfGamer) && countRegions(territoriesOfGamer) >= 2) {
                return true;
            }
            return false;
        }


}
