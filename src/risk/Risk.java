package risk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author golfier
 */
public class Risk extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Carte.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        iteratePixels();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public static void iteratePixels() throws IOException {
        File file = new File("/assets/image_fixed.png");
        BufferedImage image = ImageIO.read(file);
        int lastNotBlack = -1;
        int actualColour = 0;
        
        System.out.println("KKK");

        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {

                int black = -16777216;

                try {
                    actualColour = image.getRGB(x, y);

                } catch (Exception e) {
                    continue;
                }
                if(image.getRGB(x, y)==black){
                    image.setRGB(x, y, lastNotBlack);

                    System.out.println("black pixel at: " +x +" "+y);
                }
                if (actualColour != black){
                    lastNotBlack= actualColour;
                }

            }
        }
    }
    
}
