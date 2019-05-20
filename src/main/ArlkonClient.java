/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                        saveServerIpToFile("localhost");
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
    
    private static String getServerIp(){
        Scanner input = null;
        try {
            input = new Scanner(new FileReader("server_ip.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArlkonClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return input.next();
    }
    
    private void saveServerIpToFile(String ip) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("server_ip.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArlkonClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        writer.println(ip);
        writer.close();
    }
    
    private void logout(){
        File file = new File("user_data.txt");
        
        if(file.exists() && !file.isDirectory()){
            file.delete();
        }
    }

    private static String checkServer() {
        webservices.SessionWS_Service service = null;
        try {
            service = new webservices.SessionWS_Service(new URL("http://" + getServerIp() + ":8080/ArlkonServer/SessionWS?wsdl"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(ArlkonClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        webservices.SessionWS port = service.getSessionWSPort();
        return port.checkServer();
    }
}
