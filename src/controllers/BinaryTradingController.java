/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fade in window
        main_window.setOpacity(0);
        fadeInTransition();
        
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1", 2));
        series.getData().add(new XYChart.Data("2", 3));
        series.getData().add(new XYChart.Data("3", 4));
        series.getData().add(new XYChart.Data("4", 5));
        series.getData().add(new XYChart.Data("5", 6));
        series.getData().add(new XYChart.Data("6", 7));
        
        lineChart.getData().addAll(series);
    }
    
    private void fadeInTransition(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(main_window);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        
        fadeTransition.play();
    }
    
}
