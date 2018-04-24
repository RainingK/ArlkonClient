package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import utils.Transition;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class HomeController implements Initializable {

     // Main Pane
    @FXML Pane main_window;
    
     @FXML
    private Button binaryTrade_but;
     
    @FXML
    private Button investTrade_but;
    
     // Transition
    Transition trans = new Transition();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         binaryTrade_but.setOnMouseClicked(new EventHandler<MouseEvent>(){            
            @Override
            public void handle(MouseEvent t){
                trans.setWindow(main_window);
                trans.fadeOutTransition("/views/binaryTrading.fxml");
            }
        });
         
            investTrade_but.setOnMouseClicked(new EventHandler<MouseEvent>(){            
            @Override
            public void handle(MouseEvent t){
                trans.setWindow(main_window);
                trans.fadeOutTransition("/views/InvestWithdraw.fxml");
            }
        });
         
        
    }    
    
}
