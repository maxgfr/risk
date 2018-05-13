/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        TextField textField[] = new TextField[15];
        for(int i = 0 ; i< res ; i++ ) {
            int val = i +1;
            myVBox.getChildren().add(new Text("Nom du Joueur "+val));
            myVBox.getChildren().add(new TextField());
        }
        Button b_final = new Button("Valider le nom des joueurs");
        b_final.setId("b_final");
        //b_final.setOnAction("b_final");
        myVBox.getChildren().add(b_final);
        myButton.setDisable(true);
        
        /*GridPane root = new GridPane();
    root.setHgap(10);
    root.setVgap(10);
    
    Button btn = new Button("Add TextField");
    root.add(btn, 0, 0);
    btn.setOnAction(e -> {
        textField[i] = new TextField();
        root.add(textField[i], 5, i);
        i = i + 1;

    });

    final Scene scene = new Scene(root, 500, 400);
    primaryStage.setScene(scene);
    primaryStage.show();*/
    }
    
}
