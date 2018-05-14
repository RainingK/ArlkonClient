/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import utils.Transition;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class SettingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane main_window;
    @FXML
    private JFXPasswordField old_passfield;

    @FXML
    private Label old_passLabel;

    @FXML
    private Label new_passlabel;
    
    @FXML
    private Pane password_changed_pane, balance_reset_pane;

    @FXML
    private JFXPasswordField new_passfield;

    @FXML
    private JFXButton confirm_but;

    @FXML
    private int user_id;

    @FXML
    private JFXButton resetbal_btn;
    
    @FXML
    private Label balance_val_label;
    
    @FXML
    private Label username_label, email_label, date_label;
    
    @FXML
    private ImageView profile_pic_icon;
    
    // Header
    @FXML
    private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, help_btn_pane, logout_btn_pane;
    @FXML
    private ImageView home_btn, profile_btn, settings_btn, help_btn, logout_btn;
    @FXML
    private Label home_btn_label, profile_btn_label, settings_btn_label, help_btn_label, logout_btn_label;
    
    @FXML 
    private ImageView close_btn, minimize_btn;

    Transition trans = new Transition();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadBalanceToLabel();
        
        // Display user details
        displayInfo();
        
        // Header effects
        trans.applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        trans.applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        trans.applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        trans.applyHeaderEffect(logout_btn_pane, logout_btn, logout_btn_label);
        trans.applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);
        
        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn, main_window);
        wh.minimizeProgram(minimize_btn);
    }

    //checks if old password field is empty or not
    public void checkForEmptyField() {
        if (old_passfield.getText().trim().equals("")) {
            confirm_but.setDisable(true);
        } else {
            confirm_but.setDisable(false);
        }
    }
    
    private void loadBalanceToLabel() {
        double balance = 0;
        
        try {
            balance = getBalance(getIdFromFile());
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        
        setBalanceToLabel(balance);
    }

    private void setBalanceToLabel(double bal){
        // Round balance to 2 decimal points
        bal = bal * 100;
        bal = Math.round(bal);
        bal = bal / 100;
        
        balance_val_label.setText("$" + bal);
    }

    public int getIdFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("user_data.txt"));

        int user_id = 0;
        if (in.hasNext()) {
            user_id = in.nextInt();
        }

        in.close();

        return user_id;
    }
    
    public void displayInfo(){
        int user_id = 0;
        try {
            user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String username = firstLetterUpper(getUsername(user_id));
        
        username_label.setText(username);
        email_label.setText(getEmail(user_id));
        date_label.setText("Joined on " + getDateJoin(user_id).substring(0, 10));
        balance_val_label.setText("$" + getBalance(user_id));
        
        profile_pic_icon.setImage(new Image("/res/assets/icons/letters/letter-" + getUsername(user_id).toLowerCase().charAt(0) + ".png"));
        
    }
    
    private String firstLetterUpper(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    
    @FXML
    void disableSubmitIfShortCPassword(KeyEvent event) {
        password_changed_pane.setVisible(false);
        if ((new_passfield.getText().trim().length() < 6) || (old_passfield.getText().trim().equals(""))) {
            confirm_but.setDisable(true);
        } else {
            confirm_but.setDisable(false);
        }
    }
    
    @FXML
    void confirmPassword_clicked(MouseEvent event) {
        String error_message = "";
        String new_password = new_passfield.getText().trim(); //gets new password
        String old_password = old_passfield.getText().trim();
        // Set the user ID
        try {
            user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InvestWithdrawController.class.getName()).log(Level.SEVERE, null, ex);
        }

        MessageDigest md;
        StringBuffer old_buffer = new StringBuffer();
        StringBuffer new_buffer = new StringBuffer();

        try {
            md = MessageDigest.getInstance("MD5");
            md.update(new_password.getBytes());

            byte byteData[] = md.digest();

            for (int i = 0; i < byteData.length; i++) {
                new_buffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            md.update(old_password.getBytes());

            byte byteData1[] = md.digest();

            for (int i = 0; i < byteData1.length; i++) {
                old_buffer.append(Integer.toString((byteData1[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("NoSuchAlgorithmException: " + ex);
        }

        if (checkOldPassword(new_buffer.toString(), user_id)) {
            error_message = "Your new password cannot be the same as old password, try again!";

        } else if (!checkOldPassword(old_buffer.toString(), user_id)) {
            error_message = "Your old password is incorrect, try again!";
        } else {
            password_changed_pane.setVisible(true);
            confirm_but.setDisable(true);
            updatePassword(new_buffer.toString(), user_id);
            return;
        }

        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Oops!"));
        content.setBody(new Text(error_message));

        StackPane dialog_container = new StackPane();

        // Add stack pane to the main_window
        main_window.getChildren().add(dialog_container);

        // Center the dialog container
        dialog_container.layoutXProperty().bind(main_window.widthProperty().subtract(dialog_container.widthProperty()).divide(2));
        dialog_container.layoutYProperty().bind(main_window.heightProperty().subtract(dialog_container.heightProperty()).divide(2));

        JFXDialog dialog = new JFXDialog(dialog_container, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button = new JFXButton("Okay");

        button.setOnAction(new EventHandler< ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        content.setActions(button);
        dialog.show();
    }

    @FXML
    void resetbal_btn_clicked(MouseEvent event) {
        try {
            user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InvestWithdrawController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBalance(10000, user_id);
        setBalanceToLabel(getBalance(user_id));
        balance_reset_pane.setVisible(true);
    }
    
    @FXML
    void loadProfile(MouseEvent event) {
        trans.setWindow(main_window);
        try {
            trans.loadNextScene("/views/profile.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
    
    @FXML
    void loadHome(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/Home.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
    
    @FXML
    void loadHelp(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/help.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }
    }
    
    @FXML
    void logout(MouseEvent event){
        File file = new File("user_data.txt");
        
        if(file.delete()) {
            Transition trans = new Transition();
            
            trans.setWindow(main_window);
            try {
                trans.loadNextScene("/views/index.fxml");
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        } else {
            JFXDialogLayout content = new JFXDialogLayout();
            content.setHeading(new Text("Oops!"));
            content.setBody(new Text("There was a problem logging out, please try again!"));
            
            StackPane dialog_container = new StackPane();
            
            // Add stack pane to the main_window
            main_window.getChildren().add(dialog_container);
            
            // Center the dialog container
            dialog_container.layoutXProperty().bind(main_window.widthProperty().subtract(dialog_container.widthProperty()).divide(2));
            dialog_container.layoutYProperty().bind(main_window.heightProperty().subtract(dialog_container.heightProperty()).divide(2));
            
            JFXDialog dialog = new JFXDialog(dialog_container, content, JFXDialog.DialogTransition.CENTER);
            JFXButton button = new JFXButton("Okay");
            
            button.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                }
            });
            
            content.setActions(button);
            dialog.show();
        }
    }

    private static void updatePassword(java.lang.String password, int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        port.updatePassword(password, userId);
    }

    private static void setBalance(double balance, int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        port.setBalance(balance, userId);
    }

    private static String getUsername(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getUsername(userId);
    }

    private static String getEmail(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getEmail(userId);
    }

    private static Boolean checkOldPassword(java.lang.String password, int userId) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.checkOldPassword(password, userId);
    }

    private static double getBalance(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }

    private static String getDateJoin(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getDateJoin(userId);
    }

}
