/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travelgame;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import travel.game.ui.TravelGameUI;

/**
 *
 * @author zzxx
 */
public class TravelGame extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        TravelGameUI ui = new TravelGameUI();

        BorderPane mainPane = ui.getMainPane();
        //mainPane.SetStage(primaryStage);

        Scene scene = new Scene(mainPane, mainPane.getWidth(), mainPane.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
