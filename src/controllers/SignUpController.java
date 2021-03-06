package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSpinner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
    // Main Pane
    @FXML Pane main_window;
    
    // Close and Minimize Buttons
    @FXML ImageView close_btn;
    @FXML ImageView minimize_btn;
    
    // General Labels
    @FXML Label details_label;
    @FXML Label TC_label;
    @FXML Label SignUp_label;
    
    // Signup input fields
    @FXML TextField signup_username_input;
    @FXML TextField signup_email_input;
    @FXML JFXPasswordField signup_password_input;
    @FXML JFXPasswordField signup_confirm_password_input;
    
    // Signup buttons
    @FXML JFXButton signup_next1_btn;
    @FXML JFXButton signup_next2_btn;
    
    @FXML JFXButton signup_back1_btn;
    
    // Loading spinner
    @FXML JFXSpinner loading_spinner;
    
    // Signup constraints labels
    @FXML Label username_label;
    @FXML Label email_label;
    @FXML Label password_label;
    @FXML Label cpassword_label;
    
    // Errors label and icon
    @FXML Label errors_label;
    @FXML ImageView error_icon;
    
    // Signup Panes
    @FXML Pane rightPane1;
    @FXML Pane rightPane2;
    @FXML Pane rightPane3;
    
    // Terms and Conditions - accept radio button
    @FXML RadioButton TCRadioBtn;
    
    // Home button pane
    @FXML Pane home_btn_pane;
    
    private boolean usernameNext = false;
    private boolean emailNext = false;
    private boolean passwordNext = false;
    private boolean CPasswordNext = false;
    private boolean finalNext = false;
    
    // Inputs
    String username;
    String email;
    String password;
    String Cpassword;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Set the first step label to bold
        details_label.setFont(Font.font("System", FontWeight.BOLD, 14));

        // Fade in window
        main_window.setOpacity(0);

        //Disable Next Button
        signup_next1_btn.setDisable(true);
        signup_next2_btn.setDisable(true);

        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.fadeInTransition();

        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
    }
    
    private static String getServerIp() {
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("server_ip.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return input.next();
    }
    
    @FXML
    void validateDetailsAndTranslate(MouseEvent event){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), rightPane2);
        details_label.setFont(Font.font("System", FontWeight.NORMAL, 14));
        TC_label.setFont(Font.font("System", FontWeight.BOLD, 14));

        // Get user inputs
        username = signup_username_input.getText().trim();
        email = signup_email_input.getText().trim();
        password = signup_password_input.getText().trim();
        Cpassword = signup_confirm_password_input.getText().trim();
        
        if(checkUsernameExists(username)){
            error_icon.setVisible(true);
            errors_label.setText("Username already exists, please try a different one!");
            signup_next1_btn.setDisable(true);
            
            return;
        } else if(checkEmailExists(email)){
            error_icon.setVisible(true);
            errors_label.setText("E-mail already exists, please try a different one!");
            signup_next1_btn.setDisable(true);
            
            return;
        }

        transition.setDelay(Duration.seconds(0.2));
        transition.setToX(-731);
        transition.setCycleCount(1);
        transition.play();
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
        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                // Insert to DB
                return signUp(username, email, password, Cpassword);
            }
        };
        
        task.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                loading_spinner.setVisible(true);
            }
            
        });

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                Boolean signUp = task.getValue();
                
                if(signUp){
                    Transition trans = new Transition();
                    trans.setWindow(main_window);
                    
                    // Set logged in
                    int user_id = getUserIdFromUsername(username);
                    
                    try {
                        saveIdToFile(user_id);
                    } catch (FileNotFoundException ex) {
                        System.out.println("FileNotFoundException: " + ex.getMessage());
                    }
                    
                    try {
                        trans.loadNextScene("/views/Home.fxml");
                    } catch (IOException ex) {
                        System.out.println("IOException: " + ex.getMessage());
                    }
                } else {
                    loading_spinner.setVisible(false);
                    
                    final JFXSnackbar snackBar = new JFXSnackbar(main_window);

                    EventHandler handler = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            // Hide the snackbar
                            snackBar.unregisterSnackbarContainer(main_window);
                        }
                    };

                    snackBar.show("There was an error while signing up", "Close", 10000, handler);
                }
            }
        });

        new Thread(task).start();
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
    void disableSubmitIfInvalidUsername(KeyEvent event) {        
        if((signup_username_input.getText().trim().length() < 4) ){
            username_label.setTextFill(Color.web("#ea0e3d"));
            signup_next1_btn.setDisable(true);
            usernameNext = false;
        } else {
            username_label.setTextFill(Color.web("#009e3c"));
            
            if(checkUsernameExists(signup_username_input.getText().trim())){
                error_icon.setVisible(true);
                errors_label.setText("Username already exists, please try a different one!");
                usernameNext = false;
                signup_next1_btn.setDisable(true);
            } else {
                error_icon.setVisible(false);
                errors_label.setText("");
                usernameNext = true;

                if(usernameNext && emailNext && passwordNext && CPasswordNext){
                   signup_next1_btn.setDisable(false);
                }
            }
        }
    }
    
    @FXML
    void disableSubmitIfInvalidEmail(KeyEvent event) {
        if((signup_email_input.getText().trim().length() < 7)){
            email_label.setTextFill(Color.web("#ea0e3d"));
            signup_next1_btn.setDisable(true);
            emailNext = false;
            
        } else {
            email_label.setTextFill(Color.web("#009e3c"));
            
            // Validate email
            Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(signup_email_input.getText().trim());

            if(matcher.find()) {
                if(checkEmailExists(signup_email_input.getText().trim())){
                    error_icon.setVisible(true);
                    errors_label.setText("E-mail already exists, please try a different one!");
                    signup_next1_btn.setDisable(true);
                } else {
                    error_icon.setVisible(false);
                    errors_label.setText("");
                    
                    emailNext = true;

                    if(usernameNext && emailNext && passwordNext && CPasswordNext){
                        signup_next1_btn.setDisable(false);
                        
                    }
                }
            } else {
                error_icon.setVisible(true);
                errors_label.setText("The given e-mail address is invalid");

                signup_next1_btn.setDisable(true);
            }
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
    
    private void saveIdToFile(int user_id) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("user_data.txt");
        writer.println(user_id);
        writer.close();
    }

    private static Boolean signUp(java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String cpassword) {
        webservices.SessionWS_Service service = null;
        try {
            service = new webservices.SessionWS_Service(new URL("http://" + getServerIp() + ":8080/ArlkonServer/SessionWS?wsdl"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        webservices.SessionWS port = service.getSessionWSPort();
        return port.signUp(username, email, password, cpassword);
    }

    private static Boolean checkUsernameExists(java.lang.String username) {
        webservices.SessionWS_Service service = null;
        try {
            service = new webservices.SessionWS_Service(new URL("http://" + getServerIp() + ":8080/ArlkonServer/SessionWS?wsdl"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        webservices.SessionWS port = service.getSessionWSPort();
        return port.checkUsernameExists(username);
    }

    private static Boolean checkEmailExists(java.lang.String email) {
        webservices.SessionWS_Service service = null;
        try {
            service = new webservices.SessionWS_Service(new URL("http://" + getServerIp() + ":8080/ArlkonServer/SessionWS?wsdl"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        webservices.SessionWS port = service.getSessionWSPort();
        return port.checkEmailExists(email);
    }

    private static int getUserIdFromUsername(java.lang.String username) {
        webservices.UserWS_Service service = null;
        try {
            service = new webservices.UserWS_Service(new URL("http://" + getServerIp() + ":8080/ArlkonServer/UserWS?wsdl"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        webservices.UserWS port = service.getUserWSPort();
        return port.getUserIdFromUsername(username);
    }
}
