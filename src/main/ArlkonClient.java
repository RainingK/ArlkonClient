/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author DELL
 */
public class ArlkonClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/views/index.fxml"));
        Scene scene = new Scene(root, 1024, 537);
        
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        
        Thread test = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    // Check if server is running    
                    try {
                        if(checkServer().equals("alive")){
                            System.out.println("works");
                        } else {
                            System.out.println("Dead");
                        }
                    } catch(WebServiceException e){
                        System.out.println("fixed");
                    }
                }
            }
        });
        
        test.start();
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                
                logout();
                
                Platform.exit();
                System.exit(0);
            }
        });
    }
    
    private void logout(){
        File file = new File("user_data.txt");
        
        if(file.exists() && !file.isDirectory()){
            file.delete();
        }
    }

    private static String checkServer() {
        webservices.SessionWS_Service service = new webservices.SessionWS_Service();
        webservices.SessionWS port = service.getSessionWSPort();
        return port.checkServer();
    }
}
