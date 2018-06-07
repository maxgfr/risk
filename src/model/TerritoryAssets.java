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





		/*list controlledRegions = [];
		String[] str = new String[10];		
		North America = 0/9;
		South America =0/4;
		Europe =0/7;
		Africa =0/6;
		Asia =0/12;
		Australia =0/4;
		for it in territories(){
			if it.region = "North America"//avec un switch
				North_America++


		}
		if North_America=9
			controlledRegions+= "North_America"

		etc
*/


/*	public void move(Territory territory1, Territory territory2) {
	//déplacement des unités de combats
	}



début fonction attaque lancelot devenu useless


public void attack(Territory territory1, Territory territory2){


		/* qu'est ce qu'on veut concretement?
		une fonction qui prend trois unités aléatoires d'un territoire,
		deux unités choisies d'un autre
		qui fait un tirage
		qui dit quelles unités sont éliminées
		qui supprime les unités
		 


		//List<Unit> unitsPlayer1 = territory1.getUnitList();
		//List<Unit> unitsPlayer2 = territory2.getUnitList();
		int nbCannons1 = territory1.nbOfUnits(TypeUnit.CANNON);
		int nbHorses1 = territory1.nbOfUnits(TypeUnit.HORSE_RIDER);
		int nbSoldiers1 = territory1.nbOfUnits(TypeUnit.SOLDIER);
		int nbSoldiers2 = territory2.nbOfUnits(TypeUnit.SOLDIER);
		int nbCannons2 = territory2.nbOfUnits(TypeUnit.CANNON);
		int nbHorses2 = territory2.nbOfUnits(TypeUnit.HORSE_RIDER);
		for 3 fois;
			switch case //unit.type
			case
			case
		for 2 fois
			switch case
			case
			case
		//faire un lot des 3 meilleurs att et 2 meilleurs def
		//tirages
					*/



}
