/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author golfier
 */
public class Pixel {
    
    public int x;
    public int y;
    public Color color;
          
    public Pixel (int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
}
