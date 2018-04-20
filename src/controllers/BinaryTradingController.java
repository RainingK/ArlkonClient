/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import utils.WindowHandler;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class BinaryTradingController implements Initializable {

    // Main Pane
    @FXML private Pane main_window;
    
    // Dropdowns
    @FXML private JFXComboBox time_min_dropdown, time_hour_dropdown;
    
    // Header
    @FXML private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, help_btn_pane;
    @FXML private ImageView home_btn, profile_btn, settings_btn, help_btn;
    @FXML private Label home_btn_label, profile_btn_label, settings_btn_label, help_btn_label;
    
    // Date and time label
    @FXML private Label current_datetime_label;
    
    // Close and Minimize button
    @FXML private ImageView close_btn, minimize_btn;
    
    // Area Chart
    @FXML private AreaChart<?, ?> areaChart;
    @FXML private NumberAxis yAxisVal;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fade in window
        //main_window.setOpacity(0);
        fadeInTransition();     
        
        // Start currency graph
        startGraph();
        
        // Populate all dropdowns
        populateDropdowns();
        
        // Header effects
        applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);
        
        // Display current time
        displayCurrentTime();
        
        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
        
    }
    
    private void populateDropdowns(){
        for(int i = 1; i <= 59; i++){
            time_min_dropdown.getItems().add(new Label("" + i));
        }
        
        for(int i = 1; i <= 5; i++){
            time_hour_dropdown.getItems().add(new Label("" + i));
        }
    }
    
    private void displayCurrentTime(){
//        ScheduledService<Void> service = new ScheduledService<Void>() {
//        protected Task<Void> createTask() {
//            return new Task<Void>() {
//                protected Void call() {
//                    
//                }
//            };
//        }
//        service.setPeriod(Duration.seconds(1));
        
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
                System.out.println("Thread Running");
                System.out.println("PRICE: " + currentPrice);
                
                Random rand = new Random();
                double generatedDecimal = -0.01 + (0.1 - (-0.01)) * rand.nextDouble();
                generatedDecimal = Math.round(generatedDecimal * 100.0) / 100.0;
                
                System.out.println("RAND VAL: " + generatedDecimal);
                System.out.println("Random Currency: " + (currentPrice + generatedDecimal));
                
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
    
    private void fadeInTransition(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(100));
        fadeTransition.setNode(main_window);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        
        fadeTransition.play();
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
    
    /************* SERVER RETRIEVED FUNCTIONS *************/
    private static double getCurrentPrice(java.lang.String currency1, java.lang.String currency2) {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrentPrice(currency1, currency2);
    }
    
}
