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
public class AI extends Player {
    
    public AI(int id, String name, Color color) {
        super(id, name, color);
    }
    
    public void play () {
        System.out.println("let's algo");
    }
    
}
