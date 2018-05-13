/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controllers.ChatController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            System.exit(0);
        });
    }
    
    public void closeProgram(ImageView img, Pane main_window){
        img.setOnMouseClicked((MouseEvent e) -> {
            File file = new File("user_data.txt");
            
            if(!file.exists()){
                System.exit(0);
                Platform.exit();
            }
            
            if(file.delete()) {
                System.exit(0);
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
    
    private int getIdFromFile() {
        File file = new File("user_data.txt");
        
        if(!file.exists()){
            return -1;
        }
        
        Scanner in = null;
        try {
            in = new Scanner(new FileReader("user_data.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }

        int user_id = 0;
        if (in.hasNext()) {
            user_id = in.nextInt();
        }

        in.close();

        return user_id;
    }
}
