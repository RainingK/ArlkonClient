/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class IndexController implements Initializable {
    
    @FXML JFXTextField username_input;
    @FXML JFXButton login_btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        login_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            login();
        }
    });
    }

    private void login(){
        String username = username_input.getText();
        String output = hello(username);
        System.out.println(output);
    }

    private static String hello(java.lang.String name) {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.hello(name);
    }
    
}
