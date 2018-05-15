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

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

import model.ColorUtils;
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
        
         try {
            BufferedImage image = ImageIO.read(this.getClass().getResource("/ressources/image_fixed2.png"));
            List<Territory> territories = ImageAssets.imageProcess(image);
            game.setMaListeDeTerritoire(territories);
            
        	
        } catch (IOException e) {
          System.err.println(e.getMessage());
        }
        
        this.imageView.setOnMouseMoved(event -> { try {

            Territory terr = game.tellTerritory((int) event.getX(), (int) event.getY());
            if (terr != null){
                imageView.setImage(SwingFXUtils.toFXImage(ImageAssets.colorTerritoire(SwingFXUtils.fromFXImage(image, null), terr, Color.BLUE), null));
            }
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        });

    }

}
