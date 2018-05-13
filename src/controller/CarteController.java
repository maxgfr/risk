/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.imageio.ImageIO;
import model.Game;
import model.ImageAssets;

/**
 *
 * @author golfier
 */
public class CarteController implements Initializable {
    
    
    private static Game game;
    
    @FXML
    public void on_mouse_moved() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
        System.out.println("Position x : " + x + "\nPosition y : "+ y+ "\n\n");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Game game = Game.getInstance();
        try {
            BufferedImage image = ImageIO.read(this.getClass().getResource("/ressources/image_fixed2.png"));
            ImageAssets.imageProcess(image, game.getMaListeDeColor(), game.getMaListeDePixel());
        } catch (IOException e) {
          System.err.println(e.getMessage());
        }
    }    
    
}
