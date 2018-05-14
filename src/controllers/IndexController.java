package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
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
import javax.xml.ws.WebServiceException;
import utils.Transition;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class IndexController implements Initializable {

    String username;
    String password;

    // Main Pane
    @FXML
    Pane main_window;

    // Login inputs
    @FXML
    JFXTextField login_username_input;
    
    @FXML
    JFXPasswordField login_password_input;
    
    @FXML
    JFXButton login_btn;

    // Labels
    @FXML
    Label noAccountLabel;

    @FXML
    Label errors_label;

    @FXML
    Label forgotPasswordLabel;
    
    // Close and Minimize Buttons
    @FXML
    ImageView close_btn;
    
    @FXML
    ImageView minimize_btn;

    // Loading spinner
    @FXML
    JFXSpinner loading_spinner;

    // Transition
    Transition trans = new Transition();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        close_btn.setPickOnBounds(true);
        minimize_btn.setPickOnBounds(true);

        //Fade in Transition
        Thread fadein_transition = new Thread(new Runnable() {
            @Override
            public void run() {
                trans.setWindow(main_window);
                trans.fadeInTransition();
            }
        });

        fadein_transition.start();

        // Show Sign up form when 'Don't have an account?' label is clicked
        noAccountLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                trans.setWindow(main_window);
                trans.fadeOutTransition("/views/signUp.fxml");
            }
        });

        // Forgot password button clicked
        forgotPasswordLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                trans.setWindow(main_window);
                trans.fadeOutTransition("/views/forgotPassword.fxml");
            }
        });
        
        // Login on Enter in username field
        login_username_input.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    if (sessionExists()) {
                        loading_spinner.setVisible(false);
                        errors_label.setText("A session already exists, please exit the other session.");
                    } else {
                        loginThread();
                    }
                }
            }
        });

        // Login on Enter in password field
        login_password_input.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    if (sessionExists()) {
                        loading_spinner.setVisible(false);
                        errors_label.setText("A session already exists, please exit the other session.");
                    } else {
                        loginThread();
                    }
                }
            }
        });

        // Login on Button click
        login_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (sessionExists()) {
                    loading_spinner.setVisible(false);
                    errors_label.setText("A session already exists, please exit the other session.");
                } else {
                    errors_label.setText("");
                    loginThread();
                }
            }
        });
        
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
    }

    private void loginThread() {
        // Disable button when clicked once
        login_btn.setDisable(true);
        errors_label.setText("");

        // Get user inputs
        username = login_username_input.getText();
        password = login_password_input.getText();

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return login(username, password);
            }
        };

        task.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // Show loading spinner 
                loading_spinner.setVisible(true);
            }

        });
        
        task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // Hide loading spinner
                loading_spinner.setVisible(false);
                login_btn.setDisable(false);
                errors_label.setText("Could not connect to server :(\nTry again soon.");
            }
        });

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {

                Boolean login = task.getValue();

                if (login) {
                    trans.setWindow(main_window);

                    // Get user id from username
                    int user_id = getUserIdFromUsername(username);
                    try {
                        saveIdToFile(user_id);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        trans.loadNextScene("/views/Home.fxml");
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

    private void saveIdToFile(int user_id) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("user_data.txt");
        writer.println(user_id);
        writer.close();
    }

    // Checks if a user is already logged in
    private boolean sessionExists() {
        File f = new File("user_data.txt");

        if (f.exists() && !f.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    private static Boolean login(java.lang.String username, java.lang.String password) {
        webservices.SessionWS_Service service = null;
        try {
            try {
                service = new webservices.SessionWS_Service(new URL("http://localhost:8080/ArlkonServer/SessionWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.SessionWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/SessionWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.SessionWS port = service.getSessionWSPort();
        return port.login(username, password);
    }

    private static int getUserIdFromUsername(java.lang.String username) {
        
        webservices.UserWS_Service service = null;
        try {
            try {
                service = new webservices.UserWS_Service(new URL("http://localhost:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.UserWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.UserWS port = service.getUserWSPort();
        return port.getUserIdFromUsername(username);
    }
}
