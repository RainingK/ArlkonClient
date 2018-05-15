/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
public class HelpController implements Initializable {
    
    // Main Pane
    @FXML
    Pane main_window;

    // Header
    @FXML
    private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, logout_btn_pane;
    @FXML
    private ImageView home_btn, profile_btn, settings_btn, logout_btn;
    @FXML
    private Label home_btn_label, profile_btn_label, settings_btn_label, logout_btn_label;
    
    // Close and minimze buttons
    @FXML
    private ImageView close_btn, minimize_btn;
    
    Transition trans = new Transition();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Header effects
        trans.applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        trans.applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        trans.applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        trans.applyHeaderEffect(logout_btn_pane, logout_btn, logout_btn_label);
        
        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn, main_window);
        wh.minimizeProgram(minimize_btn);
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
    void loadProfile(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/profile.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
    
    @FXML
    void loadSettings(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/settings.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }
    }
    
    @FXML
    void logout(MouseEvent event){
        File file = new File("user_data.txt");
        
        if(file.delete()) {
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
    
}
