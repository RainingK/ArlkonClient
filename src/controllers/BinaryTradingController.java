/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class BinaryTradingController implements Initializable {

    @FXML
    private Pane main_window;
    
    @FXML
    private AreaChart<?, ?> areaChart;

    @FXML
    private NumberAxis yAxisVal;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fade in window
        main_window.setOpacity(0);
        fadeInTransition();
        
        XYChart.Series series = new XYChart.Series();

        Timeline tenSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
                
            int xVal = 0;
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("this is called every 10 seconds on UI thread");
                
                series.getData().add(new XYChart.Data("" + xVal++, getCurrentPrice("BTC", "USD")));
                
                System.out.println("PRICE: " + getCurrentPrice("BTC", "USD"));
                
                yAxisVal.setAutoRanging(false);
                yAxisVal.setLowerBound(getCurrentPrice("BTC", "USD") - 0.5);
                yAxisVal.setUpperBound(getCurrentPrice("BTC", "USD") + 0.5);
                yAxisVal.setTickUnit(1);
                
                System.out.println("X");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BinaryTradingController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));
        areaChart.getData().addAll(series);
        tenSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        tenSecondsWonder.play();
    }
    
    private void fadeInTransition(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(main_window);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        
        fadeTransition.play();
    }

    private static double getCurrentPrice(java.lang.String currency1, java.lang.String currency2) {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrentPrice(currency1, currency2);
    }
    
}
