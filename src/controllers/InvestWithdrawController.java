/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import utils.WindowHandler;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import utils.Transition;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class InvestWithdrawController implements Initializable {

     // Main Pane
    @FXML private Pane main_window;
    
     // Close and Minimize button
    @FXML private ImageView close_btn;
    
    //Labels
    // Balance Label
    @FXML private Label balance_val_label;
    // Date and time label
    @FXML private Label current_datetime_label;
    // Commission rate label
    @FXML private Label commissionRateLabel;
    
     // Header
    @FXML private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, help_btn_pane;
    @FXML private ImageView home_btn, profile_btn, settings_btn, help_btn;
    @FXML private Label home_btn_label, profile_btn_label, settings_btn_label, help_btn_label;
    
    
    // Area Chart
    @FXML private AreaChart<?, ?> areaChart;
    @FXML private NumberAxis yAxisVal;
    
    //Buttons
    @FXML private JFXButton buy_btn;
    
      @FXML
    private JFXButton takeProfit_btn;

    @FXML
    private JFXButton stopLoss_btn;
    
    //Textfields
    @FXML private JFXTextField amount_textfield;
    
    // Dropdown
    @FXML private JFXComboBox currency_dropdown;
    
    private int user_id;
    
    // Constants
    private final double PROFIT_PERCENTAGE = 0.7;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.fadeInTransition();     
        
        // Set the user ID
        try {
            user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InvestWithdrawController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Start currency graph
        startGraph();
       
        // Header effects
        applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);
        
        // Display current time
        displayCurrentTime();
        
        // Populate dropdowns
        populateDropdowns();
        
          // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
    }
       
    private void displayCurrentTime(){
        
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {            
            Calendar cal = Calendar.getInstance();

            // Specify Locale
            ZoneId zone = ZoneId.of("Asia/Dubai");
            
            // Format the time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

            // Get the current date
            LocalDate today = LocalDate.now();
            
            // Get the current time
            String now = LocalTime.now(zone).format(dtf);
            
            // Set date and time to the label
            current_datetime_label.setText(today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear() + "\n" + now);
        }),
            // Refresh every 1 second
            new KeyFrame(Duration.seconds(1))
        );
        
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    
    private void startGraph(){
        XYChart.Series series = new XYChart.Series();
        
        double currentPrice = getCurrentPrice("BTC", "USD");
        
        yAxisVal.setAutoRanging(false);
        yAxisVal.setLowerBound(currentPrice - 0.01);
        yAxisVal.setUpperBound(currentPrice + 0.01);
        yAxisVal.setTickUnit(0.1);
        
        Timeline tenSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {      
            int xVal = 0;
            double min = (currentPrice) - 0.1, max = (currentPrice) + 0.1;
            
            @Override
            public void handle(ActionEvent event) {
                
                Random rand = new Random();
                double generatedDecimal = -0.01 + (0.1 - (-0.01)) * rand.nextDouble();
                generatedDecimal = Math.round(generatedDecimal * 100.0) / 100.0;
                
                if(((currentPrice) - 0.1) < min){
                    min = (currentPrice) - 0.1;
                }
                
                if(((currentPrice) + 0.1) > max){
                    max = (currentPrice) + 0.1;
                }
                
                yAxisVal.setLowerBound(min);
                yAxisVal.setUpperBound(max);
                
                XYChart.Data data = new XYChart.Data("" + xVal++, currentPrice + generatedDecimal);
                
                Rectangle rect = new Rectangle(0, 0);
                rect.setVisible(false);
                data.setNode(rect);
                
                series.getData().add(data);
                
            }
        }));
        
        areaChart.getData().addAll(series);
        tenSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        tenSecondsWonder.play();
    }
    
    private void applyHeaderEffect(Pane btn_pane, ImageView btn, Label label){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), btn);
        FadeTransition fadeTransition = new FadeTransition();
        
        btn_pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn_pane.setCursor(Cursor.HAND);
                
                transition.setDelay(Duration.seconds(0.1));
                transition.setToY(-7);
                transition.setCycleCount(1);
                transition.play();
                
                fadeTransition.setDuration(Duration.millis(300));
                fadeTransition.setNode(label);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();
                
                label.setVisible(true);
            }
        });
        
        btn_pane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TranslateTransition transition = new TranslateTransition(Duration.seconds(0.2), btn);
                transition.setDelay(Duration.seconds(0.1));
                transition.setToY(0);
                transition.setCycleCount(1);
                transition.play();
                
                fadeTransition.setDuration(Duration.millis(300));
                fadeTransition.setNode(label);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.play();
                
                label.setVisible(false);
            }
        });
    }
    
    private void populateDropdowns(){
        List<String> currencies = getCurrencyList();
            
        currency_dropdown.getItems().addAll(currencies);
        
        // Default values
        currency_dropdown.setValue(currencies.get(0));
    }
    
    @FXML
    void buy_clicked(ActionEvent event) {
        
        double updatedBalance = getBalance(user_id);
        balance_val_label.setText("$" + updatedBalance);
        
        double currentPrice = getCurrentPrice("BTC", "USD");
        double range= PROFIT_PERCENTAGE * currentPrice;
        double lossVal= currentPrice - range;
        double profitVal= currentPrice + range;

        // Insert into DB
        Task<Void> task = new Task<Void>() {
            @Override 
            protected Void call() throws FileNotFoundException {
                int id = getIdFromFile();
                double amount = Double.parseDouble(amount_textfield.getText());
                
                insertIntoDB(id, amount, profitVal, lossVal);
                return null;
            }
        };
        
        new Thread(task).start();
       
    }
    
    @FXML
    void numberValidation(KeyEvent event) {
        if(!(event.getCharacter().matches("[0-9.]"))) {
            event.consume();
        }
    }
    
    @FXML
    void validateAmount(KeyEvent event) {
        String balance = balance_val_label.getText();
        balance = balance.substring(1, balance_val_label.getText().length());
        
        double LCdouble = 0;
        
        if(!amount_textfield.getText().equals("")){
            LCdouble = Double.parseDouble(amount_textfield.getText());
        }

        if(Double.parseDouble (balance) < LCdouble){
            buy_btn.setDisable(true);
        } else {
            commissionRateLabel.setText("" + (LCdouble * 0.02));
            buy_btn.setDisable(false);
        }
    }
    
    @FXML
    void stopLoss_clicked(ActionEvent event) {
        
    }

    @FXML
    void takeProfit_clicked(ActionEvent event) {
        try {
                int id = getIdFromFile();
                
               double invest_amount = getTransactionAmount(id);
               System.out.println("Investment amount :" +invest_amount);
               double profit_value = getProfitValue(id);
               System.out.println("profit value :" +profit_value);
                double currentPrice = getCurrentPrice("BTC", "USD");
                System.out.println("Current price : " +currentPrice);
               if(currentPrice > profit_value){
                     double profitAmount= 0.5 * invest_amount;
                     System.out.println("Profit Amount : " +profitAmount);
               }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InvestWithdrawController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int getIdFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("user_data.txt"));
        
        int user_id = 0;
        if(in.hasNext()) {
            user_id = in.nextInt();
        }
        
        in.close();
        
        return user_id;
    }
    
    /************* SERVER RETRIEVED FUNCTIONS *************/
    private static double getCurrentPrice(java.lang.String currency1, java.lang.String currency2) {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrentPrice(currency1, currency2);
    }

    private static double getBalance(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }

    private static void insertIntoDB(int userId, double transactionAmount, double profitValue, double lossValue) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        port.insertIntoDB(userId, transactionAmount, profitValue, lossValue);
    }

    private static void insertIntoDetails(int userId, double transactionResult, java.lang.String endMethod) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        port.insertIntoDetails(userId, transactionResult, endMethod);
    }

    private static double getTransactionAmount(int userId) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        return port.getTransactionAmount(userId);
    }

    private static double getProfitValue(int userId) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        return port.getProfitValue(userId);
    }

    private static double getLossValue(int userId) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        return port.getLossValue(userId);
    }

    private static java.util.List<java.lang.String> getCurrencyList() {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrencyList();
    }
}
