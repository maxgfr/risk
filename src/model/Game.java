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
import java.util.Random;

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
    private int num_tours;
    private GameState state;
    
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
        num_tours = 0;
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
    
    public Territory tellTerritory(int x, int y) {
    	System.out.println("Ma liste de territoire :  " + getMaListeDeTerritoire().size());
        for (Iterator<Territory> it = getMaListeDeTerritoire().iterator(); it.hasNext();) {
            Territory territory = it.next();
            List<Pixel> listPixel = territory.getListPixel();
            for (Pixel p : listPixel) {
                if (p.y == y && p.x == x) {
                	return territory;
                }
                
            }
        }
		return null;
        
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
    
     /**
     * @return the num_tours
     */
    public int getNumTours() {
        return num_tours;
    }

    /**
     * @param num_tours the num_tours to set
     */
    public void setTours(int num_tours) {
        this.num_tours = num_tours;
    }
    
    
    public List<Color> getListColor (int nb_joueurs) {
        List<Color> maListe = new ArrayList<Color>();
        List<Color> final_list = new ArrayList<Color>();
        Color color1 = new Color (47,79,79); //darkslategrey
        Color color2 = new Color (128,0,128); //purple
        Color color3 = new Color (128,128,0); //olive
        Color color4 = new Color (0,100,0); //dark green
        Color color5 = new Color (128,0,0); //maroon
        Color color6 = new Color (0,0,128); //navy
        Random rand = new Random();
        
        maListe.add(color1);
        maListe.add(color2);
        maListe.add(color3);
        maListe.add(color4);
        maListe.add(color5);
        maListe.add(color6);
        
        for(int i=0; i<nb_joueurs; i++) {
            int randomIndex = rand.nextInt(maListe.size());
            final_list.add(maListe.get(randomIndex));
            maListe.remove(randomIndex);
        }
        
        System.out.println("List of Color for those players : "+final_list);
        
        
        return final_list;
    }
    
    public void initTerritory(){
    	
    	int nbUnitTodispatch = 0;
    	switch(list_player.size())
    	{
	    	case 2:
	    		nbUnitTodispatch = 40;
	    		break;
	    	case 3:
	    		nbUnitTodispatch = 35;
	    		break;
	    	case 4:
	    		nbUnitTodispatch = 30;
	    		break;
	    	case 5:
	    		nbUnitTodispatch = 25;
	    		break;
	    	case 6:
	    		nbUnitTodispatch = 20;
	    		break;
    	}
    	
    	for (Player player : list_player) {
    		player.setUnitToDispatch(nbUnitTodispatch);
	    }
    	
    }


	public GameState getState() {
		return state;
	}


	public void setState(GameState state) {
		this.state = state;
	}



    
}
