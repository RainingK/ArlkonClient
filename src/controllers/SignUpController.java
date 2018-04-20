package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import utils.Transition;
import utils.WindowHandler;

public class SignUpController implements Initializable {
    @FXML Pane main_window;
    @FXML ImageView close_btn;
    @FXML ImageView minimize_btn;
    
    @FXML Label details_label;
    @FXML Label TC_label;
    @FXML Label SignUp_label;
    
    @FXML Pane rightPane1;
    @FXML TextField signup_username_input;
    @FXML TextField signup_email_input;
    @FXML JFXPasswordField signup_password_input;
    @FXML JFXPasswordField signup_confirm_password_input;
    @FXML JFXButton signup_next1_btn;
    @FXML JFXButton signup_back1_btn;
    @FXML Label username_label;
    @FXML Label email_label;
    @FXML Label password_label;
    @FXML Label cpassword_label;
    @FXML Label have_account;
    
    @FXML Pane rightPane2;
    @FXML RadioButton TCRadioBtn;
    @FXML JFXButton signup_next2_btn;
    
    @FXML Pane home_btn_pane;
    
    @FXML Pane rightPane3;
    
    private boolean usernameNext = false;
    private boolean emailNext = false;
    private boolean passwordNext = false;
    private boolean CPasswordNext = false;
    private boolean finalNext = false;
    
    String username;
    String email;
    String password;
    String Cpassword;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        details_label.setFont(Font.font("System", FontWeight.BOLD, 14));

        // Fade in window
        main_window.setOpacity(0);

        //Disable Next Button
        signup_next1_btn.setDisable(true);
        signup_next2_btn.setDisable(true);

        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.fadeInTransition();


        have_account.setOnMouseClicked(new EventHandler<MouseEvent>(){            
            @Override
            public void handle(MouseEvent t){
                trans.setWindow(main_window);
                trans.fadeOutTransition("/views/index.fxml");
            }
        });

        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), rightPane2);

        signup_next1_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                details_label.setFont(Font.font("System", FontWeight.NORMAL, 14));
                TC_label.setFont(Font.font("System", FontWeight.BOLD, 14));

                // Get user inputs
                username = signup_username_input.getText().trim();
                email = signup_email_input.getText().trim();
                password = signup_password_input.getText().trim();
                Cpassword = signup_confirm_password_input.getText().trim();

                transition.setDelay(Duration.seconds(0.2));
                transition.setToX(-731);
                transition.setCycleCount(1);
                transition.play();
            }
        });

        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
}
    
    @FXML
    void openHomeScene(MouseEvent event){
        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.fadeOutTransition("/views/index.fxml");
    }
    
    //Controls the Terms and Condition Radio Button
    @FXML
    void selected(ActionEvent event) {
        if(TCRadioBtn.isSelected()){
            signup_next2_btn.setDisable(false);
        }
    }
    
    //Controls the Terms and Condition next button
    @FXML
    void nextPane(MouseEvent event) {
        SignUp_label.setFont(Font.font("System", FontWeight.BOLD, 14));
        TC_label.setFont(Font.font("System", FontWeight.NORMAL, 14));
        
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), rightPane3);
        transition.setDelay(Duration.seconds(0.2));
        transition.setToX(-731);
        transition.setCycleCount(1);
        transition.play();
    }
    
    //Controls the Terms and Condition back button
    @FXML
    void backPane1(ActionEvent event) {
        TC_label.setFont(Font.font("System", FontWeight.NORMAL, 14));
        details_label.setFont(Font.font("System", FontWeight.BOLD, 14));
        
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), rightPane2);
        transition.setDelay(Duration.seconds(0.2));
        transition.setToX(+731);
        transition.setCycleCount(1);
        transition.play();
    }
    
    //Final Sign Up Button
    @FXML
    void SignUpFinal(ActionEvent event) {
        Thread SignUp_Thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean signUp = signUp(username, email, password, Cpassword);

                if(signUp){
                    //trans.setWindow(main_window);
                    //trans.fadeOutTransition("/views/home.fxml");
                } else {
                    System.out.println("Error");
                }
            }
        });

        SignUp_Thread.start();
    }
    
    //Final Back Button
    @FXML
    void backPane2(ActionEvent event) {
        SignUp_label.setFont(Font.font("System", FontWeight.NORMAL, 14));
        TC_label.setFont(Font.font("System", FontWeight.BOLD, 14));
        
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), rightPane3);
        transition.setDelay(Duration.seconds(0.2));
        transition.setToX(+731);
        transition.setCycleCount(1);
        transition.play();
    }
    
    @FXML
    void disableSubmitIfShortUsername(KeyEvent event) {        
        if((signup_username_input.getText().trim().length() < 4) ){
            username_label.setTextFill(Color.web("#ea0e3d"));
            signup_next1_btn.setDisable(true);
            usernameNext = false;
        } else {
            username_label.setTextFill(Color.web("#009e3c"));
            usernameNext = true;
        }
        
        if(usernameNext && emailNext && passwordNext && CPasswordNext){
            signup_next1_btn.setDisable(false);
        }
    }
    
    @FXML
    void disableSubmitIfShortEmail(KeyEvent event) {
        if((signup_email_input.getText().trim().length() < 7)){
            email_label.setTextFill(Color.web("#ea0e3d"));
            signup_next1_btn.setDisable(true);
            emailNext = false;
            
        } else {
            email_label.setTextFill(Color.web("#009e3c"));
            emailNext = true;
        }
        
        if(usernameNext && emailNext && passwordNext && CPasswordNext){
            signup_next1_btn.setDisable(false);
        }
    }
    
    @FXML
    void disableSubmitIfShortPassword(KeyEvent event) {
        if((signup_password_input.getText().trim().length() < 6)){
            signup_next1_btn.setDisable(true);
            password_label.setTextFill(Color.web("#ea0e3d"));
            passwordNext = false;
        } else {
            password_label.setTextFill(Color.web("#009e3c"));
            passwordNext = true;
        }
        
        if(usernameNext && emailNext && passwordNext && CPasswordNext){
            signup_next1_btn.setDisable(false);
        }
    }
    
    @FXML
    void disableSubmitIfShortCPassword(KeyEvent event) {        
        if(!signup_password_input.getText().trim().matches(signup_confirm_password_input.getText().trim())){
            signup_next1_btn.setDisable(true);
            cpassword_label.setTextFill(Color.web("#ea0e3d"));
            CPasswordNext = false;
        } else {
            cpassword_label.setTextFill(Color.web("#009e3c"));
            CPasswordNext = true;
        }
        
        if(usernameNext && emailNext && passwordNext && CPasswordNext){
            signup_next1_btn.setDisable(false);
        }
    }

    private static Boolean signUp(java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String cpassword) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.signUp(username, email, password, cpassword);
    }
    
    
}
