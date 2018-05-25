/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
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
    Button btn_NextTurn;
    
    @FXML
    AnchorPane GameAnchor;
    
    @FXML
    AnchorPane imagePane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        image = new Image("/ressources/image_fixed2.png");
        imageView.setImage(image);
        players = game.getList_player();
        
        game.setMaListeDeTerritoire(ImageAssets.imageProcess(SwingFXUtils.fromFXImage(image, null)));
        current_player = game.getList_player().get(0);
        imageView.setImage(ImageAssets.colorTerritoireInit(imageView.getImage(), game.getList_player(), game.getMaListeDeTerritoire()));
        
        for (Node node : GameAnchor.getChildren()){
        	System.out.println("Id: " + node.getId());
        	
        	if (node instanceof Label){
        		((Label)node).setText("0");
        		// TODO 
        		// Generate random unit and put the value to label
        	}
        }
            
        	
    }
   
    
    @FXML
    private void imagePaneMouseClicked(MouseEvent event){
    	Territory terr = game.tellTerritory((int) event.getX(), (int) event.getY());
    	System.out.println("Mouse X : " + event.getX());
    	System.out.println("Mouse Y : " + event.getY());
    	if (terr !=null)
    		System.out.println(terr.name);
    
        if (terr != null){
        	imageView.setImage(SwingFXUtils.toFXImage(ImageAssets.colorTerritoire(SwingFXUtils.fromFXImage(imageView.getImage(), null), terr, current_player.getColor()), null));
        }
    }
    
    @FXML
    private void onNextTurn(ActionEvent event){
    	
    	if (players.size() > current_player.getId() + 1)
    		current_player = players.get(current_player.getId() + 1);
    	else
    		current_player = players.get(0);
    	
    	System.out.println("Current player is : " + current_player.getName() );
    	
    }
}
