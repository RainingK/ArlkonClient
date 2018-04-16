/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class IndexController implements Initializable {
    
    @FXML JFXTextField login_username_input;
    @FXML JFXPasswordField login_password_input;
    @FXML JFXButton login_btn;
    
    @FXML Pane right_signup_pane;
    @FXML Label noAccountLabel;
    @FXML Label haveAccountLabel;
    
    //@FXML ImageView close_btn;
    //@FXML ImageView minimize_btn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        final TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), right_signup_pane);

        // Show Sign up form when 'Don't have an account?' label is clicked
        noAccountLabel.setOnMouseClicked(new EventHandler<MouseEvent>(){            
            @Override
            public void handle(MouseEvent t){
                transition.setDelay(Duration.seconds(0.2));
                transition.setToX(-275);
                transition.setCycleCount(1);
                transition.play();
            }
        });
        
        // Hide Sign up form when 'Already have an account?' label is clicked
        haveAccountLabel.setOnMouseClicked(new EventHandler<MouseEvent>(){            
            @Override
            public void handle(MouseEvent t){
                transition.setDelay(Duration.seconds(0.2));
                transition.setToX(0);
                transition.setCycleCount(1);
                transition.play();
            }
        });
        
        login_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                // Disable button when clicked once
                login_btn.setDisable(true);
                
                // Get user inputs
                String username = login_username_input.getText();
                String password = login_password_input.getText();
                
                Thread login_thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Boolean login = login(username, password);
                        
                        if(login){
                            System.out.println("Logged in!");
                        } else {
                            // Change text field border bottom color to red to indicate error
                            login_username_input.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
                            login_password_input.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
                            login_btn.setDisable(false);
                        }
                    }
                });
                
                login_thread.start();
            }
        });
        
    }
    
    private static Boolean login(java.lang.String username, java.lang.String password) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.login(username, password);
    }
    
}
