/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Game;
import model.GameState;
import model.ImageAssets;
import model.Mission;
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

    @FXML
    Label lb_NamePlayer;
    @FXML
    Label lb_Mission;
    @FXML
    Label lb_nb_unit;
    @FXML
    Label lb_nb_cannons;
    @FXML
    Label lb_nb_soldiers;
    @FXML
    Label lb_nb_horseRiders;

    @FXML
    ToggleGroup tGroup;
    
    @FXML 
    ToggleButton btn_attack;
    
    @FXML
    ToggleButton btn_renfort;
    
    @FXML
    ToggleButton btn_deplacement;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        image = new Image("/ressources/image_fixed2.png");
        imageView.setImage(image);
        players = game.getList_player();
        
        game.setMaListeDeTerritoire(ImageAssets.imageProcess(SwingFXUtils.fromFXImage(image, null)));
        
        imageView.setImage(ImageAssets.colorTerritoireInit(imageView.getImage(), game.getList_player(), game.getMaListeDeTerritoire()));
        
        //Player 
        current_player = game.getList_player().get(0);
        lb_NamePlayer.setText(current_player.getName());
        lb_NamePlayer.setTextFill(javafx.scene.paint.Color.rgb(current_player.getColor().getRed(), current_player.getColor().getGreen(), current_player.getColor().getBlue(), current_player.getColor().getAlpha() / 255.0));
        
        //Mission Initialize
        Mission missions = Mission.getInstance();
        missions.initMission(game.getList_player());
        lb_Mission.setText(current_player.getMaMission());
        
        // Unit
        game.initTerritory();
        lb_nb_unit.setText("" +current_player.getUnitToDispatch());
        lb_nb_cannons.setText("0");
        lb_nb_soldiers.setText("0");
        lb_nb_horseRiders.setText("0");
       
        
        tGroup.selectToggle(btn_renfort);
        for (Node node : GameAnchor.getChildren()){
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
    	
    	lb_NamePlayer.setText(current_player.getName());
        lb_Mission.setText(current_player.getMaMission());
        lb_NamePlayer.setTextFill(javafx.scene.paint.Color.rgb(current_player.getColor().getRed(), current_player.getColor().getGreen(), current_player.getColor().getBlue(), current_player.getColor().getAlpha() / 255.0));
        lb_nb_unit.setText("" +current_player.getUnitToDispatch());
        lb_nb_cannons.setText("0");
        lb_nb_soldiers.setText("0");
        lb_nb_horseRiders.setText("0");
    }
    
    @FXML
    private void onChangeState(ActionEvent event){
    	
    
    	//ChangeState();
    	
    }
    
    private void ChangeState(){
    	if (game.getState().equals(GameState.REINFORCEMENT)){
    		lb_nb_unit.setText("" +current_player.getUnitToDispatch());
            lb_nb_cannons.setText("0");
            lb_nb_soldiers.setText("0");
            lb_nb_horseRiders.setText("0");
            btn_attack.setSelected(true);
            btn_renfort.setSelected(false);
            game.setState(GameState.ATTACK);
    	}
    	else{
    		game.setState(GameState.REINFORCEMENT);
    		btn_attack.setSelected(false);
            btn_renfort.setSelected(true);
    	}
    }
}
