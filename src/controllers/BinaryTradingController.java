/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.scene.text.Text;
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
    @FXML
    private Pane main_window;
    @FXML
    private Pane calls_container, put_container;
    @FXML
    private StackPane chart_container;

    // Dropdowns
    @FXML
    private JFXComboBox time_min_dropdown, time_hour_dropdown;
    @FXML
    private JFXComboBox currency1_dropdown, currency2_dropdown;

    // Header
    @FXML
    private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, help_btn_pane, logout_btn_pane;
    @FXML
    private ImageView home_btn, profile_btn, settings_btn, help_btn, logout_btn;
    @FXML
    private Label home_btn_label, profile_btn_label, settings_btn_label, help_btn_label, logout_btn_label;

    // Date and time label
    @FXML
    private Label current_datetime_label;

    // Commission fee label
    @FXML
    private Label commission_fee_label;

    // Profit rate label
    @FXML
    private Label profit_rate_label;

    // Balance label
    @FXML
    private Label balance_val_label;

    //Tip Label
    @FXML
    private Label tip_content_label;
    
    // Called amount and end time labels
    @FXML
    private Label called_amount_label, end_time_label, called_at_val_label, put_amount_label, put_end_time_label, put_at_val_label;

    // Amount input field
    @FXML
    private JFXTextField amount_input;

    // Call and put button
    @FXML
    private JFXButton call_btn, put_btn;

    // Close and Minimize button
    @FXML
    private ImageView close_btn, minimize_btn;

    // Area Chart
    @FXML
    private AreaChart<?, ?> areaChart;
    @FXML
    private NumberAxis yAxisVal;

    // View Button
    @FXML
    private JFXButton view_btn;

    // Random value added to the currencies
    private double generatedDecimal;

    private int remaining_seconds;

    private final double COMMISSION_RATE = 0.02;
    private final double PROFIT_PERCENTAGE = 0.86;

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
        
        // Load pending transaction if any
        loadPendingTransaction();

        // Header effects
        trans.applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        trans.applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        trans.applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        trans.applyHeaderEffect(logout_btn_pane, logout_btn, logout_btn_label);
        trans.applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);

        // Set profit percentage
        setProfitPercentage();

        // Display current time
        displayCurrentTime();

        // Set user's balance on load
        loadBalanceToLabel();

        // Left align commission fee
        commission_fee_label.setTextAlignment(TextAlignment.RIGHT);

        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn, main_window);
        wh.minimizeProgram(minimize_btn);
    }

    private void populateDropdowns() {
        List<String> currencies = getCurrencyList();

        currency1_dropdown.getItems().addAll(currencies);
        currency2_dropdown.getItems().addAll(currencies);

        // Default values
        currency1_dropdown.setValue(currencies.get(0));
        currency2_dropdown.setValue(currencies.get(1));

        // Time - minutes dropdown
        for (int i = 1; i <= 59; i++) {
            time_min_dropdown.getItems().add("" + i);
        }

        // Time - hour dropdown
        for (int i = 1; i <= 5; i++) {
            time_hour_dropdown.getItems().add("" + i);
        }
    }

    private void displayCurrentTime() {

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

    private void loadGraph(String currency1, String currency2) {
        double currentPrice = getCurrentPrice(currency1, currency2);
        
        Task<String> showTipTask = new Task<String>() {
            @Override
            protected String call() throws Exception {
                String avg = getAverage();
                
                if(avg.equals("")){
                    call();
                }
                return avg;
            }
        };
        
        showTipTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                String averageCurrency = showTipTask.getValue();
                
                if(averageCurrency.equals("")){
                    tip_content_label.setText("Historical data is unavailable");
                } else {
                    if(returnCurrency() < 0) {
                        tip_content_label.setText("How about a PUT on " + averageCurrency + "?");
                    } else {
                        tip_content_label.setText("How about a CALL on " + averageCurrency + "?");
                    }
                }
            }
        });
        
        new Thread(showTipTask).start();

        XYChart.Series series = new XYChart.Series();

        yAxisVal.setAutoRanging(false);
        yAxisVal.setLowerBound(currentPrice - 0.01);
        yAxisVal.setUpperBound(currentPrice + 0.01);
        yAxisVal.setTickUnit(0.1);

        Timeline graphThread = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            int xVal = 0;
            double min, max;

            @Override
            public void handle(ActionEvent event) {
                String currency1 = currency1_dropdown.getSelectionModel().getSelectedItem().toString();
                String currency2 = currency2_dropdown.getSelectionModel().getSelectedItem().toString();
                
                double currentPrice = 0.0;
                
                if(currency1.equals(currency2)){
                    currency1_dropdown.getSelectionModel().select(0);
                    currency2_dropdown.getSelectionModel().select(1);
                    currentPrice = getCurrentPrice("USD", "EUR");
                } else {
                    currentPrice = getCurrentPrice(currency1, currency2);
                }
                
                min = (currentPrice) - 0.1;
                max = (currentPrice) + 0.1;
                
                // Generate random decimals
                Random rand = new Random();
                generatedDecimal = -0.01 + (0.1 - (-0.01)) * rand.nextDouble();
                generatedDecimal = Math.round(generatedDecimal * 100.0) / 100.0;

                if ((currentPrice - 0.1) < min) {
                    min = (currentPrice) - 0.1;
                }

                if ((currentPrice + 0.1) > max) {
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
        graphThread.setCycleCount(Timeline.INDEFINITE);
        graphThread.play();
    }

    private void setProfitPercentage() {
        profit_rate_label.setText("" + (PROFIT_PERCENTAGE * 100) + "%");
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
    
    private void loadPendingTransaction(){
        
        int current_user_id = 0;
        
        try {
            current_user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        
        // No pending transaction
        if(checkTransactionExists(current_user_id) == false){
            return;
        }
     
        String expiryDateString = getExpiryDateTime(current_user_id);
        
        Date expiryDate = null;
        Date nowDate = null;
        
        // Get the current date and time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime ldt = LocalDateTime.now();
        String now = dtf.format(ldt);
        
        try {
            expiryDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expiryDateString);
            nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(now);
        } catch (ParseException ex) {
            System.out.println("ParseException: " + ex.getMessage());
        }
        
        // Transaction Expired
        if(nowDate.after(expiryDate)){
            return;
        }
        
        String pendingType = getPendingTransactionType(current_user_id);
        
        // Disallow buttons when a transaction is already running
        call_btn.setDisable(true);
        put_btn.setDisable(true);
        
        // Get transaction seconds
        int final_totalSeconds = 0;
        
        String amount = Double.toString(getAmount(current_user_id));
        
        displayTransactionInfo(amount, getCurrency1(current_user_id), getCurrency2(current_user_id), final_totalSeconds, pendingType);
                
        if(pendingType.equals("call")){
            startCallTimeCountdown();
        } else if(pendingType.equals("put")){
            startPutTimeCountdown();
        }
        
    }
    
    public int getRemainingSeconds(Date expiryDate){
        // Get the current date and time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime ldt = LocalDateTime.now();
        String now = dtf.format(ldt);
        
        Date nowDate = null;
        long seconds = 0;
        
        try {
            nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(now);
        } catch (ParseException ex) {
            System.out.println("ParseException: " + ex.getMessage());
        }
        
        if(nowDate.before(expiryDate)){
            // Get seconds differences between the time
            seconds = (expiryDate.getTime() - nowDate.getTime()) / 1000;
        } else {
            return -1;
        }
        
        return (int) seconds;
    }
    
    /***************** START TRANSACTIONS *****************/
    
    private int getTransactionSeconds(){
        
        int minutes = 0, hour = 0, totalSeconds = 0;

        if (time_hour_dropdown.getSelectionModel().isEmpty()) {
            // Only minute is selected
            minutes = Integer.parseInt(time_min_dropdown.getValue().toString());
            totalSeconds = minutes * 60;
        } else if (time_min_dropdown.getSelectionModel().isEmpty()) {
            // Only hour is selected
            hour = Integer.parseInt(time_hour_dropdown.getValue().toString());
            totalSeconds = hour * 60 * 60;
        } else if (!time_min_dropdown.getSelectionModel().isEmpty() && !time_hour_dropdown.getSelectionModel().isEmpty()) {
            // Both are selected
            minutes = Integer.parseInt(time_min_dropdown.getValue().toString());
            hour = Integer.parseInt(time_hour_dropdown.getValue().toString());

            totalSeconds = (minutes * 60) + (hour * 60 * 60);
        }
        
        return totalSeconds;
    }
    
    // Start transaction -> Validate, Insert
    private void makeTransaction(String type) {
        String amount = amount_input.getText();
        String currency1 = currency1_dropdown.getValue().toString();
        String currency2 = currency2_dropdown.getValue().toString();

        // No time is selected
        if (time_min_dropdown.getSelectionModel().isEmpty() && time_hour_dropdown.getSelectionModel().isEmpty()) {
            time_min_dropdown.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
            time_hour_dropdown.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
            return;
        }

        if (amount.equals("")) {
            amount_input.setStyle("-jfx-focus-color: #be222c; -jfx-unfocus-color: #be222c;");
            return;
        }
        
        // Validation passed
        try {
            setBalanceToLabel(getBalance(getIdFromFile()) - Double.parseDouble(amount));
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        
        time_min_dropdown.setStyle("-jfx-focus-color: #202f32; -jfx-unfocus-color: #202f32;");
        time_hour_dropdown.setStyle("-jfx-focus-color: #202f32; -jfx-unfocus-color: #202f32;");

        // Disallow buttons when a transaction is already running
        call_btn.setDisable(true);
        put_btn.setDisable(true);

        // Get transaction seconds
        int final_totalSeconds = getTransactionSeconds();
        
        // Insert into DB
        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                // Insert to DB
                boolean insert = insertIntoDb(getIdFromFile(), type, currency1, currency2, Double.parseDouble(amount), (getCurrentPrice(currency1, currency2) + generatedDecimal), final_totalSeconds);

                int user_id = getIdFromFile();

                // Get the current balance of the user from database
                double currentAmount = getBalance(user_id);

                // Set new balance for the user
                setBalance((currentAmount - Double.parseDouble(amount)), user_id);

                return insert;
            }
        };

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                // Translate Graph to the right
                
                displayTransactionInfo(amount, currency1, currency2, final_totalSeconds, type);
                
                if(type.equals("call")){
                    startCallTimeCountdown();
                } else if(type.equals("put")){
                    startPutTimeCountdown();
                }
            }
        });

        new Thread(task).start();
    }
    
    // Start time left countdown
    public void startCallTimeCountdown() {
        int current_user_id = 0;
        
        try {
            current_user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        
        String expiryDateString = getExpiryDateTime(current_user_id);
        Date expiryDate = null;
        
        // Get the expiry date of a transaction and the current date
        try {
            expiryDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expiryDateString);
        } catch (ParseException ex) {
            System.out.println("ParseException: " + ex.getMessage());
        }
        
        //remaining_seconds = getTimeFrame(current_user_id);
        remaining_seconds = getRemainingSeconds(expiryDate);
        
        Timeline call_thread = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                remaining_seconds--;

                end_time_label.setText("" + remaining_seconds);
            }
        }));

        // Run the timeline for the remaining seconds
        call_thread.setCycleCount(remaining_seconds - 1);
        call_thread.play();

        // When the countdown is over, show a message with the result
        call_thread.setOnFinished(e -> {
            processCompletedTransaction("call");
            call_btn.setDisable(false);
            put_btn.setDisable(false);
        });
    }
    
    public void startPutTimeCountdown() {
        int current_user_id = 0;
        
        try {
            current_user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        
        String expiryDateString = getExpiryDateTime(current_user_id);
        Date expiryDate = null;
        
        // Get the expiry date of a transaction and the current date
        try {
            expiryDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(expiryDateString);
        } catch (ParseException ex) {
            System.out.println("ParseException: " + ex.getMessage());
        }
        
        remaining_seconds = getRemainingSeconds(expiryDate);
        System.out.println("SECS: " + remaining_seconds);

        Timeline put_thread = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                remaining_seconds--;

                put_end_time_label.setText("" + remaining_seconds);
            }
        }));

        // Run the timeline for the remaining seconds
        put_thread.setCycleCount(remaining_seconds - 1);
        put_thread.play();

        // When the countdown is over, show a message with the result
        put_thread.setOnFinished(e -> {
            processCompletedTransaction("put");
            
            call_btn.setDisable(false);
            put_btn.setDisable(false);
        });
    }

    // When call is completed, process the results
    private void processCompletedTransaction(String type) {

        int current_user_id = 0;
        try {
            current_user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex);
        }

        String message = "";
        // Price at which the user's transaction ended
        double endPrice = getCurrentPrice(getCurrency1(current_user_id), getCurrency2(current_user_id)) + generatedDecimal;

        // The amount entered by the user
        double amount = getAmount(current_user_id);
        double result = 0;
        
        if (endPrice > getStartPrice(current_user_id)) {
            
            if(type.equals("call")){
                // Won call
                result = (amount + (amount * PROFIT_PERCENTAGE));
                
                message = "Congratulations! You have earned " + result + "!";

                // Insert into db
                setResult(result, current_user_id);
            } else if(type.equals("put")){
                // Lost put
                message = "Oops! Unfortunately you have lost " + amount + " this time, try again soon!";
            }
            
            setEndPrice(endPrice, current_user_id);
            
        } else if (getStartPrice(current_user_id) > endPrice) {
            
            if(type.equals("call")){
                // Lost call
                // Do not insert any result into DB because the user's balance is already deducted when call button is pressed
                message = "Oops! Unfortunately you have lost " + amount + " this time, try again soon!";
            } else if(type.equals("put")){
                // Won put
                result = (amount + (amount * PROFIT_PERCENTAGE));
                
                message = "Congratulations! You have earned " + result + "!";

                // Insert into db
                setResult(result, current_user_id);
            }
            
            setEndPrice(endPrice, current_user_id);
            
            /**
             * ************** Insert into sales db ****************
             */
        } else {
            // Start price level and end price level is equal
            result = -(amount * COMMISSION_RATE);

            message = "Well, it seems like your price level has remained the same";
            setResult(result, current_user_id);
        }

        // Deduct result from balance
        double currentBalance = getBalance(current_user_id);
        double final_balance = currentBalance + result;

        // Store the new balance in the database
        setBalance(final_balance, current_user_id);

        // Show the latest balance in the label
        setBalanceToLabel(final_balance);

        final JFXSnackbar snackBar = new JFXSnackbar(main_window);

        EventHandler handler = new EventHandler() {
            @Override
            public void handle(Event event) {
                // Hide the snackbar
                snackBar.unregisterSnackbarContainer(main_window);
            }
        };

        snackBar.show(message, "Close", 100000, handler);

        // Set the graph back to its position
        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.translate(10, chart_container);

        calls_container.setVisible(false);
        put_container.setVisible(false);
    }
    
    private void displayTransactionInfo(String amount, String currency1, String currency2, int final_totalSeconds, String type){
        // Translate Graph to the right
        Transition trans = new Transition();
        trans.setWindow(main_window);

        trans.translate(-100, chart_container);

        if(type.equals("call")){
            trans.fadeInTransition(calls_container, 500);
            calls_container.setVisible(true);

            // Set amount to the label in calls_container
            called_amount_label.setText("$" + amount);

            // Set the price level at which user called
            double called_at = (getCurrentPrice(currency1, currency2) + generatedDecimal);
            
            // Round to 3 decimals
            called_at = called_at * 1000;
            called_at = Math.round(called_at);
            called_at = called_at /1000;
            
            called_at_val_label.setText("" + called_at);

            // Set the max time remaining
            end_time_label.setText("" + final_totalSeconds);
        } else if(type.equals("put")){
            trans.fadeInTransition(put_container, 500);
            put_container.setVisible(true);

            // Set amount to the label in calls_container
            put_amount_label.setText("$" + amount);

            // Set the price level at which user called
            put_at_val_label.setText("" + (getCurrentPrice(currency1, currency2) + generatedDecimal));

            // Set the max time remaining
            put_end_time_label.setText("" + final_totalSeconds);
        }
    }
    
    /***************** END TRANSACTIONS *****************/
    
    @FXML
    private void validateAmount(KeyEvent event) {
        double balance = 0;
        
        try {
            balance = getBalance(getIdFromFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BinaryTradingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String amountText = amount_input.getText();

        double amount = 0;

        if (!amountText.equals("")) {
            amount = Double.parseDouble(amountText);
        }

        if (balance < amount || amount < 1) {
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
    private void displayGraph() {
        // View Button is clicked
        Platform.runLater(() -> {
            view_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    String currency1 = currency1_dropdown.getValue().toString();
                    String currency2 = currency2_dropdown.getValue().toString();

                    view_btn.setDisable(true);

                    if (!currency1.equals(currency2)) {
                        main_window.getChildren().remove(areaChart);
                        areaChart.getData().removeAll(areaChart.getData());
                        loadGraph(currency1, currency2);
                    }
                }
            });
        });
    }

    @FXML
    private void currency1Listener(ActionEvent event) {
        String currency1 = currency1_dropdown.getValue().toString();
        String currency2 = currency2_dropdown.getValue().toString();

        if (!currency1.equals(currency2)) {
            view_btn.setDisable(false);
        } else {
            view_btn.setDisable(true);
        }
    }

    @FXML
    private void currency2Listener(ActionEvent event) {
        String currency1 = currency1_dropdown.getValue().toString();
        String currency2 = currency2_dropdown.getValue().toString();

        if (!currency2.equals(currency1)) {
            view_btn.setDisable(false);
        } else {
            view_btn.setDisable(true);
        }
    }

    @FXML
    private void makeCallTransaction(MouseEvent e){
        makeTransaction("call");
    }
    
    @FXML
    private void makePutTransaction(MouseEvent e){
        makeTransaction("put");
    }
    
    @FXML
    void numberValidation(KeyEvent event) {
        if (!(event.getCharacter().matches("[0-9.]"))) {
            event.consume();
        }
    }

    @FXML
    void loadProfile(MouseEvent event) {
        Transition trans = new Transition();
        trans.setWindow(main_window);
        
        trans.fadeOutTransition("/views/profile.fxml");
    }

    @FXML
    void loadHome(MouseEvent event) {
        Transition trans = new Transition();
        trans.setWindow(main_window);
        
        trans.fadeOutTransition("/views/Home.fxml");
    }
    
    @FXML
    void logout(MouseEvent event){
        File file = new File("user_data.txt");
        
        if(file.delete()) {
            Transition trans = new Transition();
            
            trans.setWindow(main_window);
            try {
                trans.loadNextScene("/views/index.fxml");
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
    
    /**
     * *********** SERVER RETRIEVED FUNCTIONS ************
     */
    private static double getCurrentPrice(java.lang.String currency1, java.lang.String currency2) {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrentPrice(currency1, currency2);
    }

    private static boolean insertIntoDb(int userId, java.lang.String type, java.lang.String currency1, java.lang.String currency2, double amount, double priceLevel, int seconds) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.insertIntoDb(userId, type, currency1, currency2, amount, priceLevel, seconds);
    }

    private static java.util.List<java.lang.String> getCurrencyList() {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrencyList();
    }

    private static void setResult(double result, int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        port.setResult(result, userId);
    }

    private static void setBalance(double balance, int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        port.setBalance(balance, userId);
    }

    private static void setEndPrice(double price, int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        port.setEndPrice(price, userId);
    }
    
    private static double getBalance(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }
    
    private static double getStartPrice(int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.getStartPrice(userId);
    }
    
    private static double getAmount(int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.getAmount(userId);
    }

    private static String getCurrency1(int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.getCurrency1(userId);
    }

    private static String getCurrency2(int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.getCurrency2(userId);
    }
    
    private static String getPendingTransactionType(int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.getPendingTransactionType(userId);
    }
    
    private static boolean checkTransactionExists(int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.checkTransactionExists(userId);
    }

    private static String getExpiryDateTime(int userId) {
        webservices.BinaryTransactionsWS_Service service = new webservices.BinaryTransactionsWS_Service();
        webservices.BinaryTransactionsWS port = service.getBinaryTransactionsWSPort();
        return port.getExpiryDateTime(userId);
    }

    private static String getAverage() {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getAverage();
    }

    private static double returnCurrency() {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.returnCurrency();
    }
}

/* Todo: 
 * add called amount to the Calls pane -- DONE
 * Add method to update end_price_level in DB -- DONE
 * end time in hours and minutes
 * enable call button when minutes is not entered -- DONE
 * have database values instead of dropdown.getText() -- DONE
 * round the balance -- DONE
 * if any call already exists when the page loads, show it (remaining seconds should be calculated accordingly) -- DONE
*/

/*  user logged in:
    * In client -> If countdown hits < 1, show dialog "Call completed", calculate amount and set it to balance (show notification if possible) -- DONE
     
    * user not logged in:
    * In server, run a thread that's always checking if the seconds == 0; (should run every second and decrement seconds)
    * Make sure this is not only for a single user. 
    * In server check if the user's log in time is past their "Call completed" time. If yes, then show completed message,
       else start the client's timer from how much is left. (Add transaction_timeframe to the transaction_datetime to get the final datetime
    
*/

/* FLOW for call
 * makeCallTransaction() -> makeTransaction() -> displayTransactionInfo() -> startCallTimeCountdown() -> processCompletedTransaction()
*/