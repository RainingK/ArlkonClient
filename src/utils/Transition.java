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
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    
    public void fadeInTransition(Node node, int duration){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(duration));
        fadeTransition.setNode(node);
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
    
    public void translate(int val, Node node){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.5), node);
        translateTransition.setToX(val);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);     
        translateTransition.play();
    }
    
    public void applyHeaderEffect(Pane btn_pane, ImageView btn, Label label) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), btn);
        FadeTransition fadeTransition = new FadeTransition();

        // Mouse hover effect
        btn_pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn_pane.setCursor(Cursor.HAND);

                transition.setDelay(Duration.seconds(0.1));
                transition.setToY(-7);
                transition.setCycleCount(1);
                transition.play();

                fadeTransition.setDuration(Duration.millis(300));
                fadeTransition.setNode(label);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();

                label.setVisible(true);
            }
        });

        // Mouse exited effect
        btn_pane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), btn);
                transition.setDelay(Duration.seconds(0.1));
                transition.setToY(0);
                transition.setCycleCount(1);
                transition.play();

                fadeTransition.setDuration(Duration.millis(300));
                fadeTransition.setNode(label);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.play();

                label.setVisible(false);
            }
        });
    }
}
