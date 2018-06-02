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
        
        // L'attaquant attaque avec au maximum 3 unités à la fois. Il doit toujours
        // rester au moins 1 unité sur le territoire de départ qui ne participe pas au
        // combat.
        int maxUnittoAttack = 3;
        int minToStay = 1;
        
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
        
        for (int i = 0; i<maxUnittoAttack; i++) {
            if (i < size_max) {
                unitForTheAttack.add(unitAttackeur.get(i));
            } 
        }
        
        
        // Le défenseur défend avec au maximum 2 unités qui sont sélectionnés selon
        // leur niveau de priorité défensive : les soldats défendent en 1er, puis les
        // canons, puis les cavaliers.
        
        
        int maxUnittoDefend = 2;
        
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
        
        size_max = unitDefenseur.size() - minToStay;
        
        for (int j = 0; j<maxUnittoAttack; j++) {
            if (j < size_max) {
                unitForDefend.add(unitDefenseur.get(j));
            } 
        }
        
        //Un nombre aléatoire est généré pour chaque unité selon les intervalles indi-
        //qués dans la colonne puissance du Tableau 4.
        
        //Random rdm = new Random(); // Le random a déjà été effectué dans Unit
        List<Integer> scoreAttacker = new ArrayList<Integer>();
        List<Integer> scoreDefenser = new ArrayList<Integer>();
        
        for (Unit unit : unitForDefend) {
            scoreDefenser.add(unit.getStrength());
        }
        
        for (Unit unit : unitForTheAttack) {
            scoreAttacker.add(unit.getStrength());
        }
        
        //Les scores les plus élevés sont comparés pour chaque camp : plus élevé
        //attaquant VS plus élevé défenseur, et 2ème plus élevé vs 2ème plus élevé 
        //s'il y a 2 unités en défense. Si plusieurs unités ont le même score dans
        //un camps et seulement dans ce cas : c'est celle de priorité la plus basse
        //(Cf. Tableau 4) qui est prioritaire pour la comparaison la plus haute. On
        //notera que les priorité en défense et en attaque ne sont pas les mêmes !
        
        Iterator<Integer> iterAtt = scoreAttacker.iterator();
        Iterator<Integer> iterDef = scoreDefenser.iterator();
        
        int i=0;
        boolean attackeurWin = false;
        
        // Le combat n'est gagné que lorsque le défenseur n'a plus aucune unité
        while(iterDef.hasNext()) {
            if (unitForTheAttack.size() == 0) {
                System.out.println("L'attaquant a perdu toutes ces unités");
            }
            if (unitForDefend.size() == 0) {
                System.out.println("Le défenseur a perdu toutes ces unités");
                attackeurWin = true;
            }
            Integer unitAtt = iterAtt.next();
            Integer unitDef = iterDef.next();
            // Pour chaque comparaison, l'unité ayant le score le plus élevé détruit 
            // celle avec le score le moins élevé. L'égalité béné􏰃cie au défenseur.
            if (unitAtt > unitDef) {
                unitForDefend.remove(i);
            } else  {//if (unitAtt < unitDef) or if (unitAtt == unitDef)  
                unitForTheAttack.remove(i);
            } 
            i++;
        }
       
        
        List<Unit> unitAfterAttack = new ArrayList<Unit>();
        List<Unit> unitAfterDefend = new ArrayList<Unit>();
        
        if (attackeurWin) {
            unitAfterAttack = unitForTheAttack;
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
            territoryB.setBatailleTerritoire(attackeur, unitAfterAttack);
        } else {
            unitAfterDefend = unitForDefend;
            territoryB.setBatailleTerritoire(defenseur, unitAfterDefend);
            territoryA.setBatailleTerritoire(attackeur, unitAfterAttack);
        }        

    }
}
