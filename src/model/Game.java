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
        for (Iterator<Pixel> it = maListeDePixel.iterator(); it.hasNext();) {
            Pixel pixel = it.next();
            //System.out.println(pixel.x + " - "+ pixel.y);
            //System.out.println(pixel.color);
            if (pixel.x == x && pixel.y == y) {
                Color col = pixel.color;
                find = true;
                System.out.println(col);    
            }
        }
        if (!find) {
            System.out.println("no_color");  
        }
        
    }
    
}
