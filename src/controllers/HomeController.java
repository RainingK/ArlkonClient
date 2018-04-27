package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
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
    private Pane profile_btn_pane, settings_btn_pane, help_btn_pane;
    @FXML
    private ImageView profile_btn, settings_btn, help_btn;
    @FXML
    private Label profile_btn_label, settings_btn_label, help_btn_label;

    // Rectangles
    @FXML
    private Rectangle binaryTradingRectangle, investmentsRectangle;
    
    // Labels
    @FXML
    private Label balance_val_label;

    // Close and minimze buttons
    @FXML
    private ImageView close_btn, minimize_btn;
    
    // Transition
    Transition trans = new Transition();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Header effects
        trans.applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        trans.applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
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
    
    /************* HOVER OVER ITEMS *************/
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

    private static double getBalance(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }
}
