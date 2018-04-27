package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utils.Transition;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class HomeController implements Initializable {

    // Main Pane
    @FXML
    Pane main_window;

    // Header
    @FXML
    private Pane profile_btn_pane, settings_btn_pane, help_btn_pane, logout_btn_pane;
    @FXML
    private ImageView profile_btn, settings_btn, help_btn, logout_btn;
    @FXML
    private Label profile_btn_label, settings_btn_label, help_btn_label, logout_btn_label;

    // Rectangles
    @FXML
    private Rectangle binaryTradingRectangle, investmentsRectangle;
    
    // Labels
    @FXML
    private Label balance_val_label;
    
     @FXML
    private Pane recent_activities_container;

    // Recent activities
    @FXML
    private ImageView first_activity_icon, second_activity_icon, third_activity_icon;
    
    @FXML
    private Pane first_activity, second_activity, third_activity;

    @FXML
    private Label first_title_label, first_subtitle_label, third_title_label;

    @FXML
    private Label second_title_label, second_subtitle_label, third_subtitle_label;
    
    @FXML
    private Label noRecentActivity_label;

    // Close and minimze buttons
    @FXML
    private ImageView close_btn, minimize_btn;
    
    // Transition
    Transition trans = new Transition();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Load recent activities
        loadRecentActivities();
        
        // Header effects
        trans.applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        trans.applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        trans.applyHeaderEffect(logout_btn_pane, logout_btn, logout_btn_label);
        trans.applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);
        
        // Set user's balance on load
        loadBalanceToLabel();
        
        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
    }
    
    private int getIdFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("user_data.txt"));

        int user_id = 0;
        if (in.hasNext()) {
            user_id = in.nextInt();
        }

        in.close();

        return user_id;
    }
    
    private void loadRecentActivities(){
        int user_id = 0;
        
        try {
            user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        
        ArrayList<String> activities = (ArrayList<String>) getRecentActivities(user_id);
        
        if(activities == null){
            first_activity.setVisible(false);
            second_activity.setVisible(false);
            third_activity.setVisible(false);
            
            noRecentActivity_label.setVisible(true);
            return;
        }
        
        switch(activities.size()){
            case 6: first_title_label.setText(activities.get(0));
                    first_subtitle_label.setText(activities.get(1));
                    first_activity_icon.setImage(new Image(getRecentActivityIcon(activities.get(0))));
                    
            case 4: second_title_label.setText(activities.get(2));
                    second_subtitle_label.setText(activities.get(3));
                    second_activity_icon.setImage(new Image(getRecentActivityIcon(activities.get(2))));
                    
            case 2: third_title_label.setText(activities.get(4));
                    third_subtitle_label.setText(activities.get(5));
                    third_activity_icon.setImage(new Image(getRecentActivityIcon(activities.get(4))));
        }
    }
    
    private String getRecentActivityIcon(String message){
        System.out.println("---->" + message.substring(0, message.indexOf(' ')));
        if(message.substring(0, message.indexOf(' ')).equals("Called")){
            return "res/assets/icons/updown.png";
        } else if(message.substring(0, message.indexOf(' ')).equals("Put")){
            return "res/assets/icons/updown.png";
        } else { //else if(message.substring(0, message.indexOf(' ')).equals("Invested")){
            return "res/assets/icons/investment_home.png";
        }
        
        //return null;
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
    void loadBinaryTrading(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/binaryTrading.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

    @FXML
    void loadInvestments(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/InvestWithdraw.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
    
    @FXML
    void logout(MouseEvent event){
        File file = new File("user_data.txt");
        
        if(file.delete()) {
            trans.setWindow(main_window);
            try {
                trans.loadNextScene("/view/index.fxml");
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
    
    /************* HOVER OVER ITEMS START *************/
    @FXML
    void binaryTradingHoverIn(MouseEvent event) {
        binaryTradingRectangle.setStyle("-fx-fill: #213435;");
    }

    @FXML
    void binaryTradingHoverOut(MouseEvent event) {
        binaryTradingRectangle.setStyle("-fx-fill: #1a2a2b;");
    }

    @FXML
    void investmentsHoverIn(MouseEvent event) {
        investmentsRectangle.setStyle("-fx-fill: #213435");
    }

    @FXML
    void investmentsHoverOut(MouseEvent event) {
        investmentsRectangle.setStyle("-fx-fill: #1a2a2b");
    }
    
    /************* HOVER OVER ITEMS END *************/
    
    private static double getBalance(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }
    
    private static java.util.List<java.lang.String> getRecentActivities(int arg0) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getRecentActivities(arg0);
    }
}
