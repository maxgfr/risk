/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import model.TypeUnit;
import model.Unit;

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
    ToggleGroup unitGroup;
    
    @FXML 
    ToggleButton btn_attack;
    
    @FXML
    ToggleButton btn_renfort;
    
    @FXML
    ToggleButton btn_deplacement;
    
    @FXML
    ToggleButton tgb_Cannon;
    
    @FXML
    ToggleButton tgb_Soldier;
    
    @FXML
    ToggleButton tgb_HorseRider;
    
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
        unitGroup.selectToggle(tgb_Soldier);
        
        game.setState(GameState.REINFORCEMENT);
        btn_renfort.setSelected(true);
        game.setSelectedUnitType(TypeUnit.SOLDIER);
        tgb_Soldier.setSelected(true);
        
        
        btn_renfort.selectedProperty().addListener((p, ov, nv) -> {
        	game.setState(GameState.REINFORCEMENT);
        	lb_nb_unit.setText("" +current_player.getUnitToDispatch());
        });
        btn_attack.selectedProperty().addListener((p, ov, nv) -> {
        	game.setState(GameState.ATTACK);
         	}
        );
        btn_deplacement.selectedProperty().addListener((p, ov, nv) -> {
        	game.setState(GameState.DEPLACEMENT);
         	}
        );
        
        tgb_Cannon.selectedProperty().addListener((p, ov, nv) -> {
        	game.setSelectedUnitType(TypeUnit.CANNON);
        }
        );
        tgb_Soldier.selectedProperty().addListener((p, ov, nv) -> {
        	game.setSelectedUnitType(TypeUnit.SOLDIER);
        });
        
        tgb_HorseRider.selectedProperty().addListener((p, ov, nv) -> {
        	game.setSelectedUnitType(TypeUnit.HORSE_RIDER);
        });


        for (Node node : GameAnchor.getChildren()){
        	if (node instanceof Label){
        		((Label)node).setText("0");
        	}
        }
            
        	
    }
   
    
    @FXML
    private void imagePaneMouseClicked(MouseEvent event){
    	Territory terr = game.tellTerritory((int) event.getX(), (int) event.getY());
    	
        if (terr != null){
        	setSelectedTerritory(terr);
        	update_Counters(terr);
        	switch(game.getState().toString()){
		    	case "ATTACK":
		    		System.out.println("Attaque : " + terr.name);
		    		break;
		    	case "REINFORCEMENT":
		    		if (game.getSelectedTerritory1() != null){
		    			Unit unitToDispatch = new Unit(game.getSelectedUnitType());
		    			if(current_player.getUnitToDispatch() >= unitToDispatch.getCost()){
		    				terr.getUnitList().add(unitToDispatch);
		    				update_Territory_Labels();
		    				current_player.setUnitToDispatch(current_player.getUnitToDispatch() - unitToDispatch.getCost());
		    				update_Counters(terr);
		    			}
	    				
		    		}
		    		break;
		    	case "DEPLACEMENT":
		    		break;
		    	default:
		    		System.out.println("Error in game state");
        	}
        	
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
    
    private void update_Map(Territory terr){
    	imageView.setImage(SwingFXUtils.toFXImage(ImageAssets.colorTerritoire(
    			SwingFXUtils.fromFXImage(imageView.getImage(), null),
    			terr, 
    			terr.player.getColor()), null) //TODO Change to match new player color 
    			);
    }
    
    private void setSelectedTerritory(Territory terr){
    	if (game.getSelectedTerritory1() == null)
    		game.setSelectedTerritory1(terr);
    	else if (game.getSelectedTerritory2() == null && !terr.equals(game.getSelectedTerritory1()))
    		game.setSelectedTerritory2(terr);
    	else if (terr.equals(game.getSelectedTerritory1())){
    		if (game.getState() != GameState.REINFORCEMENT)
    			game.setSelectedTerritory2(null);
    	}
    	else if (!terr.equals(game.getSelectedTerritory1()) && !terr.equals(game.getSelectedTerritory2())){
    		game.setSelectedTerritory1(terr);
    		game.setSelectedTerritory2(null);
    	}
    	System.out.println("Selected Territory 1 :" + game.getSelectedTerritory1());
    	System.out.println("Selected Territory 2 :" + game.getSelectedTerritory2());
    }
    
    private void update_Counters(Territory terr ){
    	lb_nb_unit.setText(""+current_player.getUnitToDispatch());
    	lb_nb_soldiers.setText(""+terr.getUnitNumberOfType(TypeUnit.SOLDIER));
    	lb_nb_cannons.setText(""+terr.getUnitNumberOfType(TypeUnit.CANNON));
    	lb_nb_horseRiders.setText(""+terr.getUnitNumberOfType(TypeUnit.HORSE_RIDER));
    }
    private void update_Territory_Labels(){
    	for (Node node : GameAnchor.getChildren()){
        	if (node instanceof Label){
        		String terr_name = ((Label)node).getId().replace("lb_", "");
        		for (Territory terr : game.getMaListeDeTerritoire()) {
    		        if (terr.name.equals(terr_name)) {
    		        	((Label)node).setText("" + terr.getUnitList().size());
    		        }
    		    }
        	}
    	}
    }
}
