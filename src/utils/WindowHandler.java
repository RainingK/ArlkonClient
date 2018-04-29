/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ammar_98@live.com
 */
public class WindowHandler {
    public void closeProgram(ImageView img){
        img.setOnMouseClicked((MouseEvent e) -> {
            Platform.exit();
        });
    }
    
    public void closeProgram(ImageView img, Pane main_window){
        img.setOnMouseClicked((MouseEvent e) -> {
            File file = new File("user_data.txt");
        
            if(file.delete()) {
                Platform.exit();
            }
        });
    }
    
    public void minimizeProgram(ImageView img){
        img.setOnMouseClicked((MouseEvent e) -> {
            Stage stage = null;
            stage = (Stage) ((ImageView) e.getSource()).getScene().getWindow();
            stage.setIconified(true);
        });
    }
}
