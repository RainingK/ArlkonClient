package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.Transition;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class IndexController implements Initializable {
    
    @FXML JFXTextField login_username_input;
    @FXML JFXPasswordField login_password_input;
    @FXML JFXButton login_btn;
    
    @FXML Label noAccountLabel;
    @FXML Label haveAccountLabel;
    
    @FXML Pane main_window;
    
    @FXML ImageView close_btn;
    @FXML ImageView minimize_btn;
    
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
                
//                transition.setDelay(Duration.seconds(0.2));
//                transition.setToX(-275);
//                transition.setCycleCount(1);
//                transition.play();
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
                            trans.setWindow(main_window);
                            trans.fadeOutTransition("/views/binaryTrading.fxml");
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
        
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
    }
    
    private static Boolean login(java.lang.String username, java.lang.String password) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.login(username, password);
    }    
}
