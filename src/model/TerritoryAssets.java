package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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

    public static void countRegions(List<Territory> territories) {
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
            for (Territory terr : territories) {
               if (terr.player.getId() != player.getId()) {
                   i++;
               }
            }
            if (i>= nbTerritory && player.getNbRegion() >= nbRegion) {
                return true;
            }
            return false;
        }

        public static boolean controlTerritoryWithArmy(List<Territory> territories, Player player, int nbTerritory, int nbArmy) {
            int i =0;
            for (Territory terr : territories) {
               if (terr.player.getId() != player.getId()) {
                   i++;
               }
            }
            if (i>= nbTerritory && player.getNbArmy() >= nbArmy) {
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
            return player.getBiggestRegion() && player.getNbRegion() >= 2;
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


/*	public void move(Territory territory1, Territory territory2){
		if (territory2.getPlayerID()==territory1.getPlayerID())
			déplacement des unités de combats
		else
			attack();

	}


	public void attack(Territory territory1, Territory territory2){
		List<Unit> unitsPlayer1 = territory1.getUnitList();
		List<Unit> unitsPlayer2 = territory2.getUnitList();





		}


*/
	

}
