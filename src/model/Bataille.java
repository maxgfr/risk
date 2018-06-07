/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author golfier
 */
public class Bataille {
    
    private static Bataille instance = null;
    
    public static Bataille getInstance() {
       if(instance == null) {
          instance = new Bataille();
       }
       return instance;
    }
    
    
    protected Bataille () {
       
    }
    
    public void attackBetweenTerritory (Territory territoryA, Territory territoryB) {
        Player attackeur = territoryA.player;
        Player defenseur = territoryB.player;
        
        List<Unit> unitAttackeur = territoryA.getUnitList();
        List<Unit> unitDefenseur = territoryB.getUnitList();
        
        List<Unit> unitStayAttack = territoryA.getUnitList();
        List<Unit> unitStayDefense = territoryB.getUnitList();
        
        if (unitAttackeur.isEmpty() || unitDefenseur.isEmpty()) {
            System.out.println("L'attackeur ou défenseur n'a plus d'unités...");
            return;
        }
        if (unitAttackeur.size() < 3){
        	System.out.println("L'attackeur n'a pas assez d'unités...");
        	return;
        }
        
        if (territoryA.equals(territoryB)){
        	System.out.println("Impossible de s'attaquer soit même");
        	return;
        }
        
        if(!territoryA.terrAdjacent.contains(territoryB.name)){
        	System.out.println("Impossible d'attaquer un territoire non adjacent");
        	return;
        }
        	
        System.out.println("Attaque de :" + territoryA.name + " vers : " + territoryB.name);
        // L'attaquant attaque avec au maximum 3 unités à la fois. Il doit toujours
        // rester au moins 1 unité sur le territoire de départ qui ne participe pas au
        // combat.
        int maxUnittoAttack = 3;
        int minToStay = 1;
        
        //TerritoryAssets.displayListUnit(unitAttackeur);
        
        Collections.sort(unitAttackeur, new Comparator<Unit>() {
            @Override
            public int compare(Unit lhs, Unit rhs) {
                if (lhs.getPriorityAttack() < rhs.getPriorityAttack()) {
                    return -1;
                } 
                else if (lhs.getPriorityAttack() > rhs.getPriorityAttack()) {
                    return 1;
                } 
                else {
                    return 0;
                }
            }
        });

        List<Unit> unitForTheAttack = new ArrayList<Unit>();
        
        int size_max = unitAttackeur.size() - minToStay;
        
        while(size_max >= maxUnittoAttack) {
            size_max--;
        }
        
        for (int i = 0; i<size_max; i++) {
            unitForTheAttack.add(unitAttackeur.get(i));
            unitStayAttack.remove(unitAttackeur.get(i));
  
        }
        
        
        TerritoryAssets.displayListUnit(unitForTheAttack);
        
        
        
        // Le défenseur défend avec au maximum 2 unités qui sont sélectionnés selon
        // leur niveau de priorité défensive : les soldats défendent en 1er, puis les
        // canons, puis les cavaliers.
        
        
        int maxUnittoDefend = 2;
        
        //TerritoryAssets.displayListUnit(unitDefenseur);
        
        Collections.sort(unitDefenseur, new Comparator<Unit>() {
            @Override
            public int compare(Unit lhs, Unit rhs) {
                if (lhs.getPriorityAttack() < rhs.getPriorityAttack()) {
                    return 1;
                } 
                else if (lhs.getPriorityAttack() > rhs.getPriorityAttack()) {
                    return -1;
                } 
                else {
                    return 0;
                }
            }
        });

        List<Unit> unitForDefend = new ArrayList<Unit>();
        
        size_max = unitDefenseur.size();
        
        if(size_max > maxUnittoDefend) {
            size_max = maxUnittoDefend;
        }
        
        for (int j = 0; j<size_max; j++) {
           unitForDefend.add(unitDefenseur.get(j));
        }

        //TerritoryAssets.displayListUnit(unitForDefend);
        
        //Un nombre aléatoire est généré pour chaque unité selon les intervalles indi-
        //qués dans la colonne puissance du Tableau 4.  
        //Les scores les plus élevés sont comparés pour chaque camp : plus élevé
        //attaquant VS plus élevé défenseur, et 2ème plus élevé vs 2ème plus élevé 
        //s'il y a 2 unités en défense. Si plusieurs unités ont le même score dans
        //un camps et seulement dans ce cas : c'est celle de priorité la plus basse
        //(Cf. Tableau 4) qui est prioritaire pour la comparaison la plus haute. On
        //notera que les priorité en défense et en attaque ne sont pas les mêmes !
                
        boolean attackeurWin = false;
        boolean conquisTerritoire = false;
        
        int length_def =  unitForDefend.size();
        int length_attack =  unitForTheAttack.size();
        int length_remenber = Math.min(length_attack,length_def);
        
        List<Unit> copyUnitForAttack = unitForTheAttack;
        List<Unit> copyUnitForDefense = unitForDefend;
        
        System.out.println(length_attack+ "  " +length_def+ "  " +length_remenber);
        
        for (int k=0; k<length_remenber; k++) {
            Unit unitNextAttack = copyUnitForAttack.iterator().next();
            Unit unitNextDefenseuh = copyUnitForDefense.iterator().next();
            //System.out.println("Unit to defend : " + unitNextDefense);
            //System.out.println("Unit to attack : " + unitNextAttack);
            
            /*
             * ICI tu avais fait une fonction qui etait en doublon, Tu generais un nouveau nombre aleatoire pour la force alors 
             * que la force est aleatoire a la creation de l'unite
             */
            int unitAtt = unitNextAttack.getStrength();
            int unitDef = unitNextDefenseuh.getStrength();
            //int unitAtt = unitNextAttack.getStrength();
            //int unitDef = unitNextDefenseuh.getStrength();
            // Pour chaque comparaison, l'unité ayant le score le plus élevé détruit 
            // celle avec le score le moins élevé. L'égalité béné􏰃cie au défenseur.
            if (unitAtt > unitDef) {
                System.out.println(unitAtt + " > " + unitDef + " => Unit Attack win");
                if (unitForDefend.isEmpty()) {
                    System.out.println("Le défenseur a perdu toutes ces unités");
                    attackeurWin = true;
                    conquisTerritoire = true;
                    break;
                } else {
                    System.out.println("Remove unit def, length : " + unitForDefend.size() +  " and : "+unitStayDefense.size());
                    if(unitForDefend.size() <= 1) {
                        attackeurWin = true;
                    }
                    if (unitForDefend.size() <= 1 && unitStayDefense.size() <= 1) {
                        System.out.println("Territoire conquis");
                        conquisTerritoire = true;
                    }
                    unitForDefend.remove(unitNextDefenseuh); 
                    unitStayDefense.remove(unitNextDefenseuh); 
                }      
            } else  {//if (unitAtt < unitDef) or if (unitAtt == unitDef)  
                System.out.println(unitAtt + " < ou == " + unitDef + " => Unit Def win");
                if (unitForTheAttack.isEmpty()) {
                    System.out.println("L'attaquant a perdu toutes ces unités");
                    break;
                } else {
                    System.out.println("Remove unit attack"+ unitForTheAttack.size());
                    unitForTheAttack.remove(unitNextAttack);
                }
                
            } 
        }
        
   
        //System.out.println("Unit after  bataille :");
        //TerritoryAssets.displayListUnit(unitForTheAttack);
        //TerritoryAssets.displayListUnit(unitForDefend);
        
        List<Unit> unitAfterAttack = new ArrayList<Unit>();
        List<Unit> unitAfterDefend = new ArrayList<Unit>();
        
        unitAfterAttack.addAll(unitForTheAttack);
        unitAfterDefend.addAll(unitForDefend);
        
        
        //System.out.println("List Unit after  bataille :");
        //TerritoryAssets.displayListUnit(unitAfterAttack);
        //TerritoryAssets.displayListUnit(unitAfterDefend);
        
        if (attackeurWin) {
            //Il aura 50% de chance d'avoir 1 renfort supplémentaire lors de son prochain
            //tour par territoire capturé.
            Random ran = new Random();
            int random = ran.nextInt(2);
            if (random == 0) {
                int rand2 =ran.nextInt(3);
                if (rand2 == 0) {
                     Unit unitRandom = new Unit(TypeUnit.SOLDIER);
                     System.out.println("Le joueur a gagné un renfort suplémentaire de type : "+ TypeUnit.SOLDIER);
                     unitAfterAttack.add(unitRandom);
                } else if (rand2 == 1) {
                    Unit unitRandom = new Unit(TypeUnit.HORSE_RIDER);
                    System.out.println("Le joueur a gagné un renfort suplémentaire de type : "+ TypeUnit.HORSE_RIDER);
                    unitAfterAttack.add(unitRandom);
                } else {
                    Unit unitRandom = new Unit(TypeUnit.CANNON);
                    System.out.println("Le joueur a gagné un renfort suplémentaire de type : "+ TypeUnit.CANNON);
                    unitAfterAttack.add(unitRandom);
                }

            } 
            // En cas de capture d'un territoire, l'attaquant y place toutes les unités ayant
            //participé et survécu à l'attaque.
            territoryA.setBatailleTerritoire(attackeur, unitStayAttack);
            if (conquisTerritoire) {
                System.out.println("L'attackeur a gagné");
                territoryB.setBatailleTerritoire(attackeur, unitAfterAttack);
            } else {
                territoryB.setBatailleTerritoire(defenseur, territoryB.getUnitList());
            }
            
        } else {
            territoryA.setBatailleTerritoire(attackeur, unitStayAttack);
            territoryB.setBatailleTerritoire(defenseur, territoryB.getUnitList()); 
        }        

    }
}
