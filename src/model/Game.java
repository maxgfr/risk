/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author golfier
 */
public class Game {
    
    private List<Player> list_player;
    private List<Color> maListeDeColor;
    private List<Pixel> maListeDePixel;
    private List<Territory> maListeDeTerritoire;
    private boolean finished;
    
    private static Game instance = null;
    

    public static Game getInstance() {
       if(instance == null) {
          instance = new Game();
       }
       return instance;
    }
    
    
    protected Game () {
        list_player = new ArrayList<Player>();
        maListeDeColor = new ArrayList<Color>();
        maListeDePixel = new ArrayList<Pixel>();
        maListeDeTerritoire = new ArrayList<Territory>();
        finished = false;
    }

    /**
     * @return the list_player
     */
    public List<Player> getList_player() {
        return list_player;
    }

    /**
     * @param list_player the list_player to set
     */
    public void setList_player(List<Player> list_player) {
        this.list_player = list_player;
    }

    /**
     * @return the maListeDeColor
     */
    public List<Color> getMaListeDeColor() {
        return maListeDeColor;
    }

    /**
     * @param maListeDeColor the maListeDeColor to set
     */
    public void setMaListeDeColor(List<Color> maListeDeColor) {
        this.maListeDeColor = maListeDeColor;
    }

    /**
     * @return the maListeDePixel
     */
    public List<Pixel> getMaListeDePixel() {
        return maListeDePixel;
    }

    /**
     * @param maListeDePixel the maListeDePixel to set
     */
    public void setMaListeDePixel(List<Pixel> maListeDePixel) {
        this.maListeDePixel = maListeDePixel;
    }

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    public void tellTerritory(int x, int y) {
        boolean find = false;
        for (Iterator<Territory> it = getMaListeDeTerritoire().iterator(); it.hasNext();) {
            Territory territory = it.next();
            List<Pixel> listPixel = territory.getListPixel();
            for (Pixel p : listPixel) {
                if (p.y == y && p.x == x) {
                    System.out.println("Territory founded");    
                    find = true;
                }
                
            }
        }
        if (!find) {
            System.out.println("Territory not founded");  
        }
        
    }

    /**
     * @return the maListeDeTerritoire
     */
    public List<Territory> getMaListeDeTerritoire() {
        return maListeDeTerritoire;
    }

    /**
     * @param maListeDeTerritoire the maListeDeTerritoire to set
     */
    public void setMaListeDeTerritoire(List<Territory> maListeDeTerritoire) {
        this.maListeDeTerritoire = maListeDeTerritoire;
    }

    
}
