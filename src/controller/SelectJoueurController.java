/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Game;
import model.Player;

/**
 * FXML Controller class
 *
 * @author golfier
 */
public class SelectJoueurController implements Initializable {
    
    @FXML 
    Button myButton;
    
    @FXML
    Slider mySlider;
    
    @FXML
    VBox myVBox;
    
    List<TextField> listTextField;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void onValidateButton (ActionEvent event) {
        double value = mySlider.getValue();
        Double d = new Double(value);
        Integer res = d.intValue();
        System.out.println(res);
        listTextField = new ArrayList<TextField>();
        for(int i = 0 ; i< res ; i++ ) {
            int val = i +1;
            myVBox.getChildren().add(new Text("Nom du Joueur "+val));
            TextField tf = new TextField();
            listTextField.add(tf);
            myVBox.getChildren().add(listTextField.get(listTextField.size()-1));
        }
        Button b_final = new Button("Valider le nom des joueurs");
        b_final.setId("b_final");
        b_final.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               CarteView();
            }
        });
        myVBox.getChildren().add(b_final);
        myButton.setDisable(true);
       
    }
    
     public void CarteView() {
    	 
        try {
            Game game = Game.getInstance();
            List<Player> list_player = new ArrayList<Player>();
            System.out.println("Number of players in SelectJoueurController : "+listTextField.size());
            List<Color> listColor = game.getListColor(listTextField.size());
            for (int i = 0; i<listTextField.size() ; i++) {
                String value = listTextField.get(i).getText();
                Player p = new Player(i, value, listColor.get(i));
                list_player.add(p);
            }
            game.setList_player(list_player);
            System.out.println("List of players in SelectViewController: "+ list_player);
            Stage stg = (Stage) myButton.getScene().getWindow();
            stg.close();  
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/Carte.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					
				}
            });
            Stage stage = new Stage();
            stage.setTitle("Risk");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     
     
    
    
}
