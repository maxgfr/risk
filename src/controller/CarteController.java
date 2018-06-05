/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import model.Bataille;
import model.Game;
import model.GameState;
import model.ImageAssets;
import model.Mission;
import model.Player;
import model.Territory;
import model.TypeUnit;
import model.Unit;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.AI;


/**
 *
 * @author golfier
 */
public class CarteController implements Initializable {
    
    
    private static Game game = Game.getInstance();
    private static Bataille bataille = Bataille.getInstance();
    Player current_player;
    List<Player> players;
    Mission mission = Mission.getInstance();
    
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
        
    	btn_attack.setDisable(true);
    	btn_deplacement.setDisable(true);
        
        btn_renfort.selectedProperty().addListener((p, ov, nv) -> {
        	game.setState(GameState.REINFORCEMENT);
        	lb_nb_unit.setText("" +current_player.getUnitToDispatch());
        	game.setSelectedTerritory1(null);
    		game.setSelectedTerritory2(null);
        });
        btn_attack.selectedProperty().addListener((p, ov, nv) -> {
        	game.setState(GameState.ATTACK);
        	game.setSelectedTerritory1(null);
    		game.setSelectedTerritory2(null);
	    	btn_deplacement.setDisable(true);
         	}
        );
        btn_deplacement.selectedProperty().addListener((p, ov, nv) -> {
        	game.setState(GameState.DEPLACEMENT);
        	game.setSelectedTerritory1(null);
    		game.setSelectedTerritory2(null);
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
            
        game.initTerritory();
        lb_nb_unit.setText(""+current_player.getUnitToDispatch());
        update_Territory_Labels();
    }
   
    
    @FXML
    private void imagePaneMouseClicked(MouseEvent event) throws IOException{
    	Territory terr = game.tellTerritory((int) event.getX(), (int) event.getY());
    	
        if (terr != null){
        	setSelectedTerritory(terr);
        	update_Counters(terr);
        	switch(game.getState().toString()){
		    	case "ATTACK":
		    		if (game.getSelectedTerritory1() != null && game.getSelectedTerritory2() != null){
		    			if (game.getSelectedTerritory1().terrAdjacent.contains(game.getSelectedTerritory2().name)){
			    			if (game.getSelectedTerritory1().player.equals(current_player) && !game.getSelectedTerritory2().player.equals(current_player))
			    				bataille.attackBetweenTerritory(game.getSelectedTerritory1(), game.getSelectedTerritory2());
                                                        update_Map(game.getSelectedTerritory1());
                                                        update_Map(game.getSelectedTerritory2());
			    				update_Territory_Labels();
			    		}
		    		}
		    		
		    		break;
		    	case "REINFORCEMENT":
		    		if (game.getSelectedTerritory1() != null){
		    			if (terr.player.equals(current_player)){
		    				Unit unitToDispatch = new Unit(game.getSelectedUnitType());
			    			if(current_player.getUnitToDispatch() >= unitToDispatch.getCost()){
			    				terr.getUnitList().add(unitToDispatch);
			    				update_Territory_Labels();
			    				current_player.setUnitToDispatch(current_player.getUnitToDispatch() - unitToDispatch.getCost());
			    				update_Counters(terr);
			    				if (current_player.getUnitToDispatch() < 1){
	    							btn_renfort.setDisable(true);
	    					    	btn_attack.setDisable(false);
	    					    	btn_deplacement.setDisable(false);
	    						}
			    			}
		    			}
		    		}
		    		break;
		    	case "DEPLACEMENT":
		    		if (game.getSelectedTerritory2() != null){
		    			if (game.getSelectedTerritory1() != null){
		    				if (terr.player.equals(current_player)){
		    					if (game.getSelectedTerritory1().terrAdjacent.contains(game.getSelectedTerritory2().name)){
		    						if (game.getSelectedTerritory1().getUnitNumberOfType(game.getSelectedUnitType()) > 1){
			    						Unit unitToMov = terr.getUnitByType(game.getSelectedUnitType());
			    						game.getSelectedTerritory2().getUnitList().add(unitToMov);
			    						game.getSelectedTerritory1().getUnitList().remove(unitToMov);
			    						update_Territory_Labels();
			    						update_Counters(terr);
			    					}
		    					}
		    					else{
		    						game.setSelectedTerritory1(null);
		    			    		game.setSelectedTerritory2(null);
		    					}
		    				}
		    			}
		    		}
		    		break;
		    	default:
		    		System.out.println("Error in game state");
        	}
        	
        }
        
        if(mission.hasWin(current_player)) {
            showMessage(Alert.AlertType.INFORMATION, "Fin de la partie", "Victoire du joueur " + current_player.getName());
            Platform.exit();
        }
    }
    
    @FXML
    private void onNextTurn(ActionEvent event){
    	
    	if (players.size() > current_player.getId() + 1){
    		current_player = players.get(current_player.getId() + 1);
    	}
    	else
    		current_player = players.get(0);
      
        if(current_player instanceof AI) { // si c'est une IA
            current_player.play();
        }
    	
    	System.out.println("Current player is : " + current_player.getName() );
    	game.getReinforcement(current_player);
    	
    	tGroup.selectToggle(btn_renfort);
    	btn_renfort.setDisable(false);
    	btn_attack.setDisable(true);
    	btn_deplacement.setDisable(true);
    	btn_renfort.setSelected(true);
    
    	
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
    		if (game.getState() == GameState.REINFORCEMENT)
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
    
    private Optional<ButtonType> showMessage(Alert.AlertType type,String header,String message,ButtonType... lesBoutonsDifferents){
        Alert laFenetre = new Alert(type);
        laFenetre.setHeaderText(header);
        laFenetre.setContentText(message);
        if (lesBoutonsDifferents.length > 0) {
            laFenetre.getButtonTypes().clear();
            laFenetre.getButtonTypes().addAll(lesBoutonsDifferents);
        }
        return laFenetre.showAndWait();
    }
}
