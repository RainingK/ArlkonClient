/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controllers.IndexController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author ammar_98@live.com
 */
public class Transition {
    @FXML Pane main_window;
    
    public void setWindow(Pane window){
        main_window = window;
    }
    
    public void fadeOutTransition(String sceneLoc){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(main_window);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        
        fadeTransition.setOnFinished((ActionEvent event) -> {
            try {
                loadNextScene(sceneLoc);
            } catch (IOException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        fadeTransition.play();
    }
    
    public void fadeInTransition(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(main_window);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        
        fadeTransition.play();
    }
    
    public void loadNextScene(String sceneLoc) throws IOException {
        Parent nextView;
        nextView = (Pane) FXMLLoader.load(getClass().getResource(sceneLoc));
        
        Scene nextScene = new Scene(nextView);
        Stage curStage = (Stage) main_window.getScene().getWindow();
        
        curStage.setScene(nextScene);
    }
}
