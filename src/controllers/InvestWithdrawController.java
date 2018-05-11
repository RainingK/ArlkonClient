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
import java.sql.SQLException;
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
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import utils.Transition;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class InvestWithdrawController implements Initializable {

    // Main Pane
    @FXML
    private Pane main_window;

    //Invest container
    @FXML
    private Pane invest_container;

    // Close and Minimize button
    @FXML
    private ImageView close_btn, minimize_btn;

    //Labels
    // Balance Label
    @FXML
    private Label balance_val_label;

    // Date and time label
    @FXML
    private Label current_datetime_label;

    // Commission rate label
    @FXML
    private Label commissionRateLabel;

    // amount container amount earned label
    @FXML
    private Label invest_val_label;
    
    // Label showing 'Invest at'
    @FXML
    private Label invest_at_left_label;
  
    @FXML
    private Label invest_at_val_label;

    // Header
    @FXML
    private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, help_btn_pane, logout_btn_pane;
    @FXML
    private ImageView home_btn, profile_btn, settings_btn, help_btn, logout_btn;
    @FXML
    private Label home_btn_label, profile_btn_label, settings_btn_label, help_btn_label, logout_btn_label;

    // Area Chart
    @FXML
    private AreaChart<?, ?> areaChart;
    @FXML
    private NumberAxis yAxisVal;

    //Containers
    @FXML
    private StackPane chartContainer;

    //Buttons
    @FXML
    private JFXButton buy_btn;

    @FXML
    private JFXButton invest_close_btn;

    @FXML
    private JFXButton takeProfit_btn;

    @FXML
    private JFXButton stopLoss_btn;

    @FXML
    private JFXButton view_graph_btn;

    //Textfields
    @FXML
    private JFXTextField amount_textfield;

    // Dropdown
    @FXML
    private JFXComboBox currency_dropdown;

    @FXML
    private Pane makeProfit_container;

    // Constants
    private final double PROFIT_PERCENTAGE = 0.0001;
    
    private double generatedDecimal = getRandomNumbers();
    private int user_id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.fadeInTransition();

        // Set the user ID
        try {
            user_id = getIdFromFile();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }
        
        // Populate dropdowns
        populateDropdowns();

        // Start currency graph
        startGraph();
        
        // Load any pending transaction
        loadPendingTransaction();

        // Header effects
        applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        applyHeaderEffect(logout_btn_pane, logout_btn, logout_btn_label);
        applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);

        // Display current time
        displayCurrentTime();

        // Show user's balance when page loads
        loadBalanceToLabel();
        
        // Add combobox event listener
        currencyDropdownListener();

        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn, main_window);
        wh.minimizeProgram(minimize_btn);
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

    private void startGraph() {
        XYChart.Series series = new XYChart.Series();
        
        String currency = currency_dropdown.getValue().toString();
        
        double currentPrice = getCurrentPrice("USD", currency);

        yAxisVal.setAutoRanging(false);
        yAxisVal.setLowerBound(currentPrice - 0.01);
        yAxisVal.setUpperBound(currentPrice + 0.01);
        yAxisVal.setTickUnit(0.1);

        double range = PROFIT_PERCENTAGE * (currentPrice + generatedDecimal);
        double lossVal = ((currentPrice + generatedDecimal) - range);
        double profitVal = Math.round(((currentPrice + generatedDecimal) + range) * 100.0) / 100.0;

        Timeline graphThread = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
            int xVal = 0;
            double min, max;

            @Override
            public void handle(ActionEvent event) {
                String currency = currency_dropdown.getValue().toString();
        
                double currentPrice = getCurrentPrice("USD", currency);
                generatedDecimal = getRandomNumbers();
                
                min = (currentPrice) - 0.1;
                max = (currentPrice) + 0.1;

                if (((currentPrice) - 0.9) < min) {
                    min = (currentPrice) - 0.9;
                }

                if (((currentPrice) + 0.9) > max) {
                    max = (currentPrice) + 0.9;
                }

                yAxisVal.setLowerBound(min);
                yAxisVal.setUpperBound(max);

                XYChart.Data data = new XYChart.Data("" + xVal++, currentPrice + generatedDecimal);

                Rectangle rect = new Rectangle(0, 0);
                rect.setVisible(false);
                data.setNode(rect);

                series.getData().add(data);

                if ((currentPrice + generatedDecimal) > profitVal) {
                    // Take profit

                    //Disabling all buttons except take profit 
                    invest_close_btn.setDisable(true);
                    takeProfit_btn.setDisable(false);
                    stopLoss_btn.setDisable(true);
                } else if ((currentPrice + generatedDecimal) < lossVal) {
                    // Stop loss 

                    //Disabling all buttons except stop loss
                    invest_close_btn.setDisable(true);
                    stopLoss_btn.setDisable(false);
                    takeProfit_btn.setDisable(true);
                } else if ((currentPrice + generatedDecimal) < profitVal && (currentPrice + generatedDecimal) > lossVal) {
                    // Close transaction
                    invest_close_btn.setDisable(false);
                    stopLoss_btn.setDisable(true);
                    takeProfit_btn.setDisable(true);
                }
            }
        }));

        //
        areaChart.getData().addAll(series);
        graphThread.setCycleCount(Timeline.INDEFINITE);
        graphThread.play();
    }

    private void applyHeaderEffect(Pane btn_pane, ImageView btn, Label label) {
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

    private void populateDropdowns() {
        List<String> currencies = getCurrencyList();
        currencies.remove(0);
        
        currency_dropdown.getItems().addAll(currencies);

        // Default values
        currency_dropdown.setValue(currencies.get(0));
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
        
        // Disallow button when a transaction is already running
        buy_btn.setDisable(true);
        
        double amount = getTransactionAmount(current_user_id);
        
        displayTransactionInfo(amount, 0);
        
    }
    
    private void displayTransactionInfo(double amount, double currentPrice){
        // Translate Graph to the right
        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.translate(-100, chartContainer);
        makeProfit_container.setVisible(true);

        //Setting the investment amount label in container
        invest_val_label.setVisible(true);
        invest_val_label.setText("$" + amount);

        //Setting the current price at investment label in container
        invest_at_val_label.setVisible(true);
        if(currentPrice != 0){
            invest_at_val_label.setText("$" + currentPrice);
            invest_at_left_label.setVisible(true);
        } else {
            invest_at_left_label.setVisible(false);
        }

        // Display controls
        takeProfit_btn.setVisible(true);
        stopLoss_btn.setVisible(true);
        invest_close_btn.setVisible(true);
    }
    
    private void currencyDropdownListener() {
        currency_dropdown.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.equals(oldValue)){
                    view_graph_btn.setDisable(true);
                    return;
                } else {
                    view_graph_btn.setDisable(false);
                }
            }
        });
        
    }
    
    // Display graph based on user selected currencies
    @FXML
    private void displayGraph() {
        System.out.println("DISPLAY GRAPH");
        
        // View Button is clicked
        Platform.runLater(() -> {
            view_graph_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    view_graph_btn.setDisable(true);

                    main_window.getChildren().remove(areaChart);
                    areaChart.getData().removeAll(areaChart.getData());
                    startGraph();
                }
            });
        });
    }
    
    @FXML
    void buy_clicked(ActionEvent event) throws FileNotFoundException {

        double currentBalance = getBalance(user_id);
        int id = getIdFromFile();
        double currentPrice = Math.round((getCurrentPrice("USD", "INR") + getRandomNumbers()) * 10000d) / 10000d;
       
        double range = PROFIT_PERCENTAGE * currentPrice;

        double lossVal = Math.round((currentPrice - range) * 10000d) / 10000d;
        double profitVal = Math.round((currentPrice + range) * 10000d) / 10000d;
        double amount = Double.parseDouble(amount_textfield.getText());
        // Insert into DB
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws FileNotFoundException {

                String currency = currency_dropdown.getValue().toString();
                insertInDb(id, amount, currency, profitVal, lossVal);
                setBalance(currentBalance - amount, user_id);

                return null;
            }
        };

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {

                setBalanceToLabel(getBalance(id));
                
                displayTransactionInfo(amount, currentPrice);
            }

        });

        new Thread(task).start();
    }

    @FXML
    void numberValidation(KeyEvent event) {
        if (!(event.getCharacter().matches("[0-9.]"))) {
            event.consume();
        }
    }

    @FXML
    void validateAmount(KeyEvent event) {
        String balance = balance_val_label.getText();
        balance = balance.substring(1, balance_val_label.getText().length());

        double LCdouble = 0;

        if (!amount_textfield.getText().equals("")) {
            LCdouble = Double.parseDouble(amount_textfield.getText());
        }

        if (Double.parseDouble(balance) < LCdouble || LCdouble < 1) {
            buy_btn.setDisable(true);
        } else {
            commissionRateLabel.setText("" + (LCdouble * 0.02));
            buy_btn.setDisable(false);
        }
    }

    @FXML
    void stopLoss_clicked(ActionEvent event) throws FileNotFoundException {
            int id = getIdFromFile();
             double invest_amount = getTransactionAmount(id);
             double lossAmount = 0.5 * invest_amount;
              double currentPrice = Math.round((getCurrentPrice("USD", "INR") + generatedDecimal) * 10000d) / 10000d;
              System.out.println("Current price at stop loss : " +currentPrice);
             String end_method = "stop_loss";
            Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws FileNotFoundException {
       
                insertIntoDetails(id, lossAmount, end_method);
                setBalance(getBalance(id) + (invest_amount - lossAmount), id);
                return null;
            }
        };
        
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                setBalanceToLabel(getBalance(id));
                popUp(end_method, lossAmount, currentPrice);
                
                takeProfit_btn.setVisible(false);
                stopLoss_btn.setVisible(false);
                invest_close_btn.setVisible(false);
                
                resetControlPositions();
            }

        });

        new Thread(task).start();
    }

    @FXML
    void takeProfit_clicked(ActionEvent event) throws FileNotFoundException {
        int id = getIdFromFile();
        double currentPrice = Math.round((getCurrentPrice("USD", "INR") + generatedDecimal) * 10000d) / 10000d;

        double invest_amount = getTransactionAmount(id);
        double profitAmount = 0.5 * invest_amount;
        String end_method = "take_profit";
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws FileNotFoundException {

                insertIntoDetails(id, profitAmount, end_method);

                setBalance(getBalance(id) + invest_amount + profitAmount, id);
                return null;
            }
        };
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                popUp(end_method, profitAmount, currentPrice);
                setBalanceToLabel(getBalance(id));
                
                takeProfit_btn.setVisible(false);
                stopLoss_btn.setVisible(false);
                invest_close_btn.setVisible(false);
                
                resetControlPositions();
            }

        });

        new Thread(task).start();
    }
        
    @FXML
    void close_btn_clicked(ActionEvent event) throws FileNotFoundException {
            String message="";
            int id = getIdFromFile();
            
            String end_method= getEndMethod(id);
            double currentPrice = Math.round((getCurrentPrice("USD", "INR") + generatedDecimal) * 10000d) / 10000d;
            if(end_method.equals("take_profit")){
                  message = "Your transaction has been closed with a profit earned of $ " +getTransactionResult(id) + " at price level $ " + currentPrice;
            }
            else if(end_method.equals("stop_loss")){
                message = "Your transaction has been closed with a loss of $ " +getTransactionResult(id) + " at price level $ " +currentPrice;
            }
            else
            {
                message = "Closed transaction ";
            }
         
            takeProfit_btn.setVisible(false);
            stopLoss_btn.setVisible(false);
            invest_close_btn.setVisible(false);
                
            final JFXSnackbar snackBar = new JFXSnackbar(main_window);

            EventHandler handler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    // Hide the snackbar
                    snackBar.unregisterSnackbarContainer(main_window);
                }
            };

            snackBar.show(message, "Close", 100000, handler);

    }

    void popUp(String end_method, double amount, double current_price) {
        if (end_method.equals("take_profit")) {
            String message = "Congratulations, you've earned a profit of $" + amount + " at current price level $" + current_price;

            final JFXSnackbar snackBar = new JFXSnackbar(main_window);

            EventHandler handler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    // Hide the snackbar
                    snackBar.unregisterSnackbarContainer(main_window);
                }
            };

            snackBar.show(message, "Close", 100000, handler);

        }else if(end_method.equals("stop_loss")){
            String message = "Oops, you've unfortunately incurred a loss of $ " + amount + " at price level $ " +current_price;
            
               final JFXSnackbar snackBar = new JFXSnackbar(main_window);

            EventHandler handler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    // Hide the snackbar
                    snackBar.unregisterSnackbarContainer(main_window);
                }
            };

            snackBar.show(message, "Close", 100000, handler);
        
        }

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

    private void setBalanceToLabel(double bal) {
        // Round balance to 2 decimal points
        bal = bal * 100;
        bal = Math.round(bal);
        bal = bal / 100;

        balance_val_label.setText("$" + bal);
    }

    int getIdFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("user_data.txt"));

        int user_id = 0;
        if (in.hasNext()) {
            user_id = in.nextInt();
        }

        in.close();

        return user_id;
    }

    private void resetControlPositions() {
        Transition trans = new Transition();
        trans.setWindow(main_window);
        trans.translate(0, chartContainer);
        makeProfit_container.setVisible(false);
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
    
    @FXML
    void view_graph_clicked(ActionEvent event) {

    }

    /**
     * *********** SERVER RETRIEVED FUNCTIONS ************
     */
    private static double getCurrentPrice(java.lang.String currency1, java.lang.String currency2) {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getCurrentPrice(currency1, currency2);
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

    private static void insertInDb(int userId, double transactionAmount, java.lang.String currency, double profitValue, double lossValue) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        port.insertInDb(userId, transactionAmount, currency, profitValue, lossValue);
    }

    private static double getBalance(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }

    private static void setBalance(double balance, int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        port.setBalance(balance, userId);
    }

    private static double getTransactionResult(int userId) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        return port.getTransactionResult(userId);
    }

    private static String getEndMethod(int userId) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        return port.getEndMethod(userId);
    }

    private static Boolean checkTransactionExists(int userId) {
        webservices.IWWS_Service service = new webservices.IWWS_Service();
        webservices.IWWS port = service.getIWWSPort();
        return port.checkTransactionExists(userId);
    }

    private static double getRandomNumbers() {
        webservices.CurrencyApiWS_Service service = new webservices.CurrencyApiWS_Service();
        webservices.CurrencyApiWS port = service.getCurrencyApiWSPort();
        return port.getRandomNumbers();
    }

    
}

// 1) Move graph back
// 2) Hide the investment details
// 3) Do the close button 
// 4) When investment starts, it should allow close but it allows take profit
// 5) Remove space between $ 56 -> amount in snackbar
// 6) Hide Take Profit, Stop Loss, Close button once one of these button's clicked

//it gives wrong current price even though its exact see