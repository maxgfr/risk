/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
            for (int i = 0; i<listTextField.size() ; i++) {
                String value = listTextField.get(i).getText();
                if (value.isEmpty()) {
                    value = randomString();
                }
                System.out.println(value);
                Player p = new Player(value,i);
                list_player.add(p);
            }
            game.setList_player(list_player);
            Stage stg = (Stage) myButton.getScene().getWindow();
            stg.close();  
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/Carte.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Carte");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    private String randomString() {
        Random r = new Random();
        String value="";
        char random_Char ;
        for(int i=0; i<10;i++) { 
            random_Char = (char) (48 + r.nextInt(74));
            value=value+random_Char;
        }
        return value;
    }
    
}
