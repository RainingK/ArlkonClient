package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import utils.Transition;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class IndexController implements Initializable {
    
    // Main Pane
    @FXML Pane main_window;
    
    // Login inputs
    @FXML JFXTextField login_username_input;
    @FXML JFXPasswordField login_password_input;
    @FXML JFXButton login_btn;
    
    // Labels
    @FXML Label noAccountLabel;
    
    // Close and Minimize Buttons
    @FXML ImageView close_btn;
    @FXML ImageView minimize_btn;
    
    // Loading spinner
    @FXML JFXSpinner loading_spinner;
    
    // Transition
    Transition trans = new Transition();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        close_btn.setPickOnBounds(true);
        minimize_btn.setPickOnBounds(true);
        
        //Fade in Transition
        Thread fadein_transition = new Thread(new Runnable(){
            @Override
            public void run(){
                trans.setWindow(main_window);
                trans.fadeInTransition();
            }
        });
        
        fadein_transition.start();

        // Show Sign up form when 'Don't have an account?' label is clicked
        noAccountLabel.setOnMouseClicked(new EventHandler<MouseEvent>(){            
            @Override
            public void handle(MouseEvent t){
                trans.setWindow(main_window);
                trans.fadeOutTransition("/views/signUp.fxml");
            }
        });
        
        // Login on Enter in username field
        login_username_input.setOnKeyPressed(new EventHandler<KeyEvent>() {
 
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) {
                     loginThread();
                }
            }
        });
        
        // Login on Enter in password field
        login_password_input.setOnKeyPressed(new EventHandler<KeyEvent>() {
 
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) {
                     loginThread();
                }
            }
        });
        
        // Login on Button click
        login_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                loginThread();
            }
        });
        
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
    }
    
    private void loginThread(){
       // Show loading spinner 
       loading_spinner.setVisible(true);
        
       // Disable button when clicked once
       login_btn.setDisable(true);

       // Get user inputs
       String username = login_username_input.getText();
       String password = login_password_input.getText();
       
       Task<Boolean> task = new Task<Boolean>() {
            @Override 
            protected Boolean call() throws Exception {
                return login(username, password);
            }
        };
       
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                
                Boolean login = task.getValue();
                
                if(login){
                    trans.setWindow(main_window);
                    try {
                        trans.loadNextScene("/views/binaryTrading.fxml");
                    } catch (IOException ex) {
                        Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    // Change text field border bottom color to red to indicate error
                    login_username_input.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
                    login_password_input.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
                    login_btn.setDisable(false);
                    loading_spinner.setVisible(false);
                }
            }
        });
       
        new Thread(task).start();
    }
    
    private static Boolean login(java.lang.String username, java.lang.String password) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.login(username, password);
    }    
}
