/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author golfier
 */
public class Territory {
	
	    public Color color;
	    public List<Pixel> pixelList;
	    
	    public Territory (Color color) {
	        this.color = color;
	        this.pixelList = new ArrayList<Pixel>();
	    }
	    
	    public void addPixel(Pixel pixel){
	    	pixelList.add(pixel);
	    }
	    
	    public List<Pixel> getListPixel(){
	    	return pixelList;
	    }

	    public string Name {





	}
}
