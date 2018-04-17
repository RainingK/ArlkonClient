/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
    @FXML TextField signup_username_input;
    @FXML TextField signup_email_input;
    @FXML JFXPasswordField signup_password_input;
    @FXML JFXPasswordField signup_confirm_password_input;
    @FXML JFXButton signup_btn;
    
    @FXML Label noAccountLabel;
    @FXML Label haveAccountLabel;
    
    @FXML Pane main_window;
    
    @FXML ImageView close_btn;
    @FXML ImageView minimize_btn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        final TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), right_signup_pane);
        signup_btn.setDisable(true);
        close_btn.setPickOnBounds(true);
        minimize_btn.setPickOnBounds(true);

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
                            // Send user to home page
                            fadeOutTransition("/views/binaryTrading.fxml");
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
        
        signup_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                
                // Get user inputs
                String username = signup_username_input.getText().trim();
                String email = signup_email_input.getText().trim();
                String password = signup_password_input.getText().trim();
                String Cpassword = signup_confirm_password_input.getText().trim();
                
                Thread SignUp_Thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Boolean signUp = signUp(username, email, password, Cpassword);
                        
                        if(signUp){
                            fadeOutTransition("/views/home.fxml");
                        } else {
                            System.out.println("Error");
                        }
                    }
                });
                
                SignUp_Thread.start();
            }
        });
        
        closeProgram(close_btn);
        minimizeProgram(minimize_btn);
    }
    
    private void fadeOutTransition(String sceneLoc){
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
    
    private void loadNextScene(String sceneLoc) throws IOException {
        Parent nextView;
        nextView = (Pane) FXMLLoader.load(getClass().getResource(sceneLoc));
        
        Scene nextScene = new Scene(nextView);
        Stage curStage = (Stage) main_window.getScene().getWindow();
        
        curStage.setScene(nextScene);
    }
    
    public void closeProgram(ImageView img){
            img.setOnMouseClicked((MouseEvent e) -> {
            Platform.exit();
        });
    }
    
    @FXML
    void allowSignup(KeyEvent event) {        
        if((signup_username_input.getText().trim().length() < 4) || (signup_email_input.getText().trim().length() < 7) ||
                (signup_password_input.getText().trim().length() < 6) || (signup_confirm_password_input.getText().trim().length() < 6)){
            signup_btn.setDisable(true);
        } else {
            signup_btn.setDisable(false);
        }
    }
    
    public void minimizeProgram(ImageView img){
        img.setOnMouseClicked((MouseEvent e) -> {
            Stage stage = null;
            stage = (Stage) ((ImageView) e.getSource()).getScene().getWindow();
            stage.setIconified(true);
        });
    }
    
    private static Boolean login(java.lang.String username, java.lang.String password) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.login(username, password);
    }

    private static Boolean signUp(java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String cpassword) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.signUp(username, email, password, cpassword);
    }    
}
