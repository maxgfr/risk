/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import model.Game;
import model.ImageAssets;
import model.Territory;

/**
 *
 * @author golfier
 */
public class CarteController implements Initializable {
    
    
    private static Game game = Game.getInstance();
    
    @FXML
    ImageView imageView;
    
    @FXML
    Image image;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize");
        
         try {
            BufferedImage image = ImageIO.read(this.getClass().getResource("/ressources/image_fixed2.png"));
            List<Territory> territories = ImageAssets.imageProcess(image);
        } catch (IOException e) {
          System.err.println(e.getMessage());
        }
        
        this.imageView.setOnMouseMoved(event -> { try {

            // AWT Robot and Color to trace pixel information
            Robot robot = new Robot();
            Color color = robot.getPixelColor((int) event.getScreenX(), (int) event.getScreenY());
            
            System.out.println(color);
            
            game.tellTerritory(color);

            // Initializing pixel info
            String xPos = Integer.toString((int) event.getX());
            String yPos = Integer.toString((int) event.getY());
            String colorRed = Integer.toString(color.getRed());
            String colorBlue = Integer.toString(color.getBlue());
            String colorGreen = Integer.toString(color.getGreen());
            String hexColor = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
            
            // Unify and format the information
            String pixelInfo = "X: " + xPos + " Y: " + yPos + " | "
                    + "r: " + colorRed + " g: " + colorGreen +
                    " b: " + colorBlue + " | " + hexColor;
            //System.out.println(pixelInfo);

            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        });

    }    
    
}
