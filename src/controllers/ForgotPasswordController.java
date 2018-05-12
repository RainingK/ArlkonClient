/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
    private JFXButton submit_btn;
    
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
        
        Platform.runLater(() -> {
            if(!checkEmailExists(email)){
                // Email doesn't exist
                error_icon.setVisible(true);

                error_label.setText("The e-mail does not exist");
                error_label.setVisible(true);
            } else {
                // Email exists
                error_icon.setVisible(false);
                error_label.setVisible(false);
                
                submit_btn.setDisable(true);

                int atPos = email.indexOf('@') + 1;
                String domain = email.substring(atPos, email.length());

                int user_id = getUserIdFromEmail(email);
                String username = getUsername(user_id);
                
                String newPassword = processforgotPassword(user_id);
                String salt = getRandomString(8);
                
                newPassword = salt + newPassword;
                
                try {
                    java.awt.Desktop.getDesktop().browse(new URI("https://www.shahlin.com/arlkon/forgot_password.php?domain=" + domain + "&email=" + email + "&username=" + username + "&password=" + newPassword));
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private String getRandomString(int length){
       char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z' };
    
        char[] c = new char[length];
        
        Random random=new Random();
        for (int i = 0; i < length; i++) {
          c[i]=ch[random.nextInt(ch.length)];
        }

        return new String(c);
    }

    private static Boolean checkEmailExists(java.lang.String email) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.checkEmailExists(email);
    }

    private static String getUsername(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getUsername(userId);
    }

    private static int getUserIdFromEmail(java.lang.String email) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getUserIdFromEmail(email);
    }

    private static String processforgotPassword(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.processforgotPassword(userId);
    }

}
