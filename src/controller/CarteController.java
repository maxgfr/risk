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

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

import model.ColorUtils;
import model.Game;
import model.ImageAssets;
import model.Player;
import model.Territory;

/**
 *
 * @author golfier
 */
public class CarteController implements Initializable {
    
    
    private static Game game = Game.getInstance();
    Player current_player;
    List<Player> players;
    
    @FXML
    ImageView imageView;
    
    @FXML
    Image image;
    
    @FXML
    Button btn_newPlayer;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        image = new Image("/ressources/image_fixed2.png");
        imageView.setImage(image);
        
        
        List<Territory> territories = ImageAssets.imageProcess(SwingFXUtils.fromFXImage(image, null));
        game.setMaListeDeTerritoire(territories);
        players = game.getList_player();
        current_player = players.get(0);
        
        this.imageView.setOnMouseMoved(event -> {
        		//changeImageOnmouse(event);
            
        });
        this.imageView.setOnMouseClicked(event -> {
        	changeImageOnmouseClick(event);
        });
        
        
        final long startNanoTime = System.nanoTime();
        
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
                
            }
        }.start();
    }
    
    public void changeImageOnmouse(MouseEvent event){
    	
    	Territory terr = game.tellTerritory((int) event.getX(), (int) event.getY());
        if (terr != null){
        	imageView.setImage(SwingFXUtils.toFXImage(ImageAssets.colorTerritoire(SwingFXUtils.fromFXImage(imageView.getImage(), null), terr, Color.BLUE), null));
        }

    }

    public void changeImageOnmouseClick(MouseEvent event){
    	
    	Territory terr = game.tellTerritory((int) event.getX(), (int) event.getY());
        if (terr != null){
        	imageView.setImage(SwingFXUtils.toFXImage(ImageAssets.colorTerritoire(SwingFXUtils.fromFXImage(imageView.getImage(), null), terr, current_player.color), null));
        }

    }
    
    public void onNextPlayer(ActionEvent event){
    	current_player = players.get(current_player.getId() + 1);
    }

}
