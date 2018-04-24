/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
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
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import utils.Transition;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class BinaryTradingController implements Initializable {

    // Containers
    @FXML private Pane main_window;
    @FXML private Pane calls_container;
    @FXML private StackPane chart_container;
    
    // Dropdowns
    @FXML private JFXComboBox time_min_dropdown, time_hour_dropdown;
    @FXML private JFXComboBox currency1_dropdown, currency2_dropdown;
    
    // Header
    @FXML private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, help_btn_pane;
    @FXML private ImageView home_btn, profile_btn, settings_btn, help_btn;
    @FXML private Label home_btn_label, profile_btn_label, settings_btn_label, help_btn_label;
    
    // Date and time label
    @FXML private Label current_datetime_label;
    
    // Commission fee label
    @FXML private Label commission_fee_label;
    
    // Balance label
    @FXML private Label balance_val_label;
    
    // Called amount and end time labels
    @FXML private Label called_amount_label, end_time_label;
    
    // Amount input field
    @FXML private JFXTextField amount_input;
    
    // Call and put button
    @FXML private JFXButton call_btn, put_btn;
    
    // Close and Minimize button
    @FXML private ImageView close_btn, minimize_btn;
    
    // Area Chart
    @FXML private AreaChart<?, ?> areaChart;
    @FXML private NumberAxis yAxisVal;
    
    // View Button
    @FXML private JFXButton view_btn;
    
    private final double COMMISSION_RATE = 0.02;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fade in window
        
        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.fadeInTransition();     
        
        // Populate all dropdowns
        populateDropdowns();
        
        // Load the default graph
        loadGraph("USD", "EUR");
        
        // Header effects
        applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);
        
        // Display current time
        displayCurrentTime();
        
        // Left align commission fee
        commission_fee_label.setTextAlignment(TextAlignment.RIGHT);
        
        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
    }
    
    private void populateDropdowns(){
        List<String> currencies = getCurrencyList();
            
        currency1_dropdown.getItems().addAll(currencies);
        currency2_dropdown.getItems().addAll(currencies);
        
        // Default values
        currency1_dropdown.setValue(currencies.get(0));
        currency2_dropdown.setValue(currencies.get(1));
        
        // Time - minutes dropdown
        for(int i = 1; i <= 59; i++){
            time_min_dropdown.getItems().add("" + i);
        }
        
        // Time - hour dropdown
        for(int i = 1; i <= 5; i++){
            time_hour_dropdown.getItems().add("" + i);
        }
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
    
    private void loadGraph(String currency1, String currency2){
        double currentPrice = getCurrentPrice(currency1, currency2);
        
        XYChart.Series series = new XYChart.Series();
        
        yAxisVal.setAutoRanging(false);
        yAxisVal.setLowerBound(currentPrice - 0.01);
        yAxisVal.setUpperBound(currentPrice + 0.01);
        yAxisVal.setTickUnit(0.1);
        
        Timeline tenSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {      
            int xVal = 0;
            double min = (currentPrice) - 0.1, max = (currentPrice) + 0.1;
            
            @Override
            public void handle(ActionEvent event) {
                double currentPrice = getCurrentPrice(currency1, currency2);
                
                // Generate random decimals
                Random rand = new Random();
                double generatedDecimal = -0.01 + (0.1 - (-0.01)) * rand.nextDouble();
                generatedDecimal = Math.round(generatedDecimal * 100.0) / 100.0;
                
                if(((currentPrice) - 0.1) < min){
                    min = (currentPrice) - 0.1;
                }
                
                if(((currentPrice) + 0.1) > max){
                    max = (currentPrice) + 0.1;
                }
                
                // Change upper and lower bound according to the currency price
                yAxisVal.setLowerBound(min);
                yAxisVal.setUpperBound(max);
                
                // Add 1 to the x-axis every iteration
                XYChart.Data data = new XYChart.Data("" + xVal++, currentPrice + generatedDecimal);
                
                // Remove the circle points from area chart
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
        
        // Mouse hover effect
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
        
        // Mouse exited effect
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
    
    public void startCallTimeCountdown(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, event -> {
                int seconds = Integer.parseInt(end_time_label.getText());
                seconds--;
                
                if(seconds < 1){
                    return;
                }
                end_time_label.setText("" + seconds);
            }),
            // Refresh every 1 second
            new KeyFrame(Duration.seconds(1))
        );

        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    
    @FXML
    private void validateAmount(KeyEvent event) {
        String balance = balance_val_label.getText().substring(1, balance_val_label.getText().length());
        String amountText = amount_input.getText();
        
        double amount = 0;
        
        if(!amountText.equals("")){
            amount = Double.parseDouble(amountText);
        }
        
        if(Double.parseDouble (balance) < amount){
            call_btn.setDisable(true);
            put_btn.setDisable(true);
        } else {
            commission_fee_label.setText("" + (amount * COMMISSION_RATE));
            call_btn.setDisable(false);
            put_btn.setDisable(false);
        }
    }
    
    // Display graph based on user selected currencies
    @FXML
    private void displayGraph(){
        final String currency1 = currency1_dropdown.getValue().toString();
        final String currency2 = currency2_dropdown.getValue().toString();

        // View Button is clicked
        view_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                view_btn.setDisable(true);
                
                if(!currency1.equals(currency2)){
                    main_window.getChildren().remove(areaChart);
                    areaChart.getData().removeAll(areaChart.getData());
                    loadGraph(currency1, currency2);
                }
            }
        });
    }
    
    @FXML
    private void currency1Listener(ActionEvent event) {
        String currency1 = currency1_dropdown.getValue().toString();
        String currency2 = currency2_dropdown.getValue().toString();
        
        if(!currency1.equals(currency2)){
            view_btn.setDisable(false);
        } else {
            view_btn.setDisable(true);
        }
    }
    
    @FXML
    private void currency2Listener(ActionEvent event){
        String currency1 = currency1_dropdown.getValue().toString();
        String currency2 = currency2_dropdown.getValue().toString();
        
        if(!currency2.equals(currency1)){
            view_btn.setDisable(false);
        } else {
            view_btn.setDisable(true);
        }
    }
    
    @FXML
    private void makeCallTransaction(MouseEvent e){
        
        String amount = amount_input.getText();
        String currency1 = currency1_dropdown.getValue().toString();
        String currency2 = currency2_dropdown.getValue().toString();
        
        int totalSeconds = 0;
        int minutes = 0;
        int hour = 0;
        
        // No time is selected
        if(time_min_dropdown.getSelectionModel().isEmpty() && time_hour_dropdown.getSelectionModel().isEmpty()){
            time_min_dropdown.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
            time_hour_dropdown.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
            return;
        }
        
        if(amount.equals("")){
            amount_input.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
            return;
        }
        
        if(time_hour_dropdown.getSelectionModel().isEmpty()){
            // Only minute is selected
            minutes = Integer.parseInt(time_min_dropdown.getValue().toString());
            totalSeconds = minutes * 60;
        } else if(time_min_dropdown.getSelectionModel().isEmpty()){
            // Only hour is selected
            hour = Integer.parseInt(time_hour_dropdown.getValue().toString());
            totalSeconds = hour * 60 * 60;
        } else if(!time_min_dropdown.getSelectionModel().isEmpty() && !time_hour_dropdown.getSelectionModel().isEmpty()){
            // Both are selected
            minutes = Integer.parseInt(time_min_dropdown.getValue().toString());
            hour = Integer.parseInt(time_hour_dropdown.getValue().toString());
            
            totalSeconds = (minutes * 60) + (hour * 60 * 60);
        }
        
        final int final_totalSeconds = totalSeconds;
        System.out.println("secs: " + final_totalSeconds);
        
        // Insert into DB
        Task<Boolean> task = new Task<Boolean>() {
            @Override 
            protected Boolean call() throws Exception {
                boolean insert = insertIntoDb(1, "call", currency1, currency2, Double.parseDouble(amount), final_totalSeconds);
                return insert;
            }
        };
        
        // Do the effect part here (translation); Also, user_id is hardcoded. Get it from file
        
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
           @Override
           public void handle(WorkerStateEvent event) {
               // Translate Graph to the right
                Transition trans = new Transition();
                trans.setWindow(main_window);

                trans.translate(-100, chart_container);

                trans.fadeInTransition(calls_container, 500);
                calls_container.setVisible(true);

                // Set amount to the label in calls_container
                called_amount_label.setText("$" + amount);

                end_time_label.setText("" + final_totalSeconds);
                
                startCallTimeCountdown();
           }
       
       });
        
        new Thread(task).start();
    }
    
    @FXML
    void numberValidation(KeyEvent event) {
        if(!(event.getCharacter().matches("[0-9.]"))) {
            event.consume();
        }
    }
    
    /************* SERVER RETRIEVED FUNCTIONS *************/
    private static double getCurrentPrice(java.lang.String currency1, java.lang.String currency2) {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrentPrice(currency1, currency2);
    }

    private static boolean insertIntoDb(int userId, java.lang.String type, java.lang.String currency1, java.lang.String currency2, double amount, int seconds) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.insertIntoDb(userId, type, currency1, currency2, amount, seconds);
    }

    private static java.util.List<java.lang.String> getCurrencyList() {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrencyList();
    }
    
}
