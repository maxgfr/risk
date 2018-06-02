package main;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Territory;
import model.TerritoryAssets;
import model.Unit;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author golfier
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Launch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        /*Territory tester = new Territory(new Color(255,128,128));
        Territory tester2 = new Territory(new Color(128,0,0));
        Territory tester3 = new Territory(new Color(128,64,64));
        Territory tester4 = new Territory(new Color(255,0,0));
        ArrayList<Territory> territories = new ArrayList<Territory>();
        territories.add(tester);
        territories.add(tester2);
        territories.add(tester3);
        territories.add(tester4);

        TerritoryAssets.countRegions(territories);*/

    }
    
 
}
