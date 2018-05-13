package risk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import model.Game;
import model.ImageAssets;

/**
 *
 * @author golfier
 */
public class Risk extends Application {
    
    public static Game game;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Launch.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        try {
            BufferedImage image = ImageIO.read(this.getClass().getResource("/ressources/image_fixed2.png"));
            ImageAssets.imageProcess(image);
        } catch (IOException e) {
          System.err.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
 
}
