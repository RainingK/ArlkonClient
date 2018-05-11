/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import utils.Transition;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ForgotPasswordController implements Initializable {

    @FXML
    private Pane main_window;
    
    @FXML
    private JFXTextField email_input;
    
    @FXML
    private ImageView error_icon;
    
    @FXML
    private Label error_label;

    @FXML
    private ImageView close_btn;

    @FXML
    private ImageView minimize_btn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Close and Minimize button handler
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn, main_window);
        wh.minimizeProgram(minimize_btn);
    }        

    @FXML
    void loadIndex(MouseEvent event) {
        Transition trans = new Transition();
        trans.setWindow(main_window);
        
        trans.fadeOutTransition("/views/index.fxml");
    }
    
    @FXML
    void formSubmitted(ActionEvent event){
        String email = email_input.getText();
        
        if(!checkEmailExists(email)){
            // Email doesn't exist
            error_icon.setVisible(true);
            
            error_label.setText("The e-mail does not exist");
            error_label.setVisible(true);
        } else {
            // Email exists
            error_icon.setVisible(false);
            error_label.setVisible(false);
            
            int atPos = email.indexOf('@');
            String domain = email.substring(atPos, email.length());
            
        }
    }

    private static Boolean checkEmailExists(java.lang.String email) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.checkEmailExists(email);
    }
}
