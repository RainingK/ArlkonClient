/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
public class ChatController implements Initializable {
    // Containers
    @FXML
    private Pane main_window;
    
    @FXML
    private ScrollPane chat_container, online_users_container;
    
    // Header
    @FXML
    private Pane home_btn_pane, profile_btn_pane, settings_btn_pane, help_btn_pane, logout_btn_pane;
    
    @FXML
    private ImageView home_btn, profile_btn, settings_btn, help_btn, logout_btn;
    
    @FXML
    private Label home_btn_label, profile_btn_label, settings_btn_label, help_btn_label, logout_btn_label;
    
    @FXML
    private Label balance_val_label;
    
    @FXML
    private JFXTextField chat_input;

    @FXML
    private Button send_btn;
    
    // Close and minimze buttons
    @FXML
    private ImageView close_btn, minimize_btn;
    
    Transition trans = new Transition();
    VBox chatMessageHolder = new VBox();
    VBox onlineUsersHolder = new VBox();
    
    int numberOfUsers = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fade in window
        trans.setWindow(main_window);
        trans.fadeInTransition();
        
        // Header effects
        trans.applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        trans.applyHeaderEffect(profile_btn_pane, profile_btn, profile_btn_label);
        trans.applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        trans.applyHeaderEffect(logout_btn_pane, logout_btn, logout_btn_label);
        trans.applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);
        
        // Load old messages when the page loads
        loadOldMessages();
        
        // Check database for any new messages and display them
        loadNewMessages();
        
        // Load user's balance to the label
        loadBalanceToLabel();
        
        // Set up close and minimize buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn, main_window);
        wh.minimizeProgram(minimize_btn);
    }
    
//    private void connectUserToChat(){
//        connectToChat(getIdFromFile());
//    }
//    
//    private void setOnlineUsers(){
//        
//        Timeline checkOnlineUsersThread = new Timeline(new KeyFrame(Duration.ZERO, e -> {
//            List<Integer> onlineUsers = onlineUsersList();
//            
//            if(numberOfUsers == onlineUsersList().size()){
//                return;
//            } else {
//                numberOfUsers = onlineUsersList().size();
//            }
//        
//            for(int i = 0; i < onlineUsers.size(); i++){
//                Pane pane =  new Pane();
//                String username = getUsername(onlineUsers.get(i));
//
//                if(username.equals(getUsername(getIdFromFile()))){
//                    username = "You";
//                }
//
//                // Create ImageView for green online icon
//                ImageView onlineIcon = new ImageView("/res/assets/icons/online.png");
//
//                for(int k = 0; k < i; k++){
//                    if(onlineUsers.get(k).equals("You")){
//                        return;
//                    }
//                }
//                
//                // Label containing username
//                Label usernameLabel = new Label(firstLetterUpper(username));
//
//                // Username label properties
//                usernameLabel.setTextFill(Color.WHITE);
//                trans.translate(40, usernameLabel);
//
//                // Add ImageView and label to the pane
//                pane.getChildren().addAll(onlineIcon, usernameLabel);
//                
//                pane.getStyleClass().add("online_users_pane");
//
//                // Add pane to the VBox
//                onlineUsersHolder.getChildren().add(pane);
//            }
//
//            online_users_container.setContent(onlineUsersHolder);
//        }),
//                // Refresh every 1 second
//                new KeyFrame(Duration.seconds(1))
//        );
//
//        checkOnlineUsersThread.setCycleCount(Animation.INDEFINITE);
//        checkOnlineUsersThread.play();
//    }
    
    private void loadOldMessages(){
        List<String> messages = getOldMessages();
        List<Integer> chatIds = getOldChatIds();
        List<String> datetimes = getOldDatetimes();
        
        if(messages.size() == 0 && chatIds.size() == 0 && datetimes.size() == 0){
            Label label = new Label("No chat messages found");
            label.getStyleClass().add("message_view_labels");
            
            chatMessageHolder.getChildren().add(label);
            chat_container.setContent(chatMessageHolder);
            
            return;
        }
        
        for(int i = 0; i < messages.size(); i++){
            int chat_id = chatIds.get(i);
            
            String username = getUsername(getUserIdFromChatId(chat_id));
            username = firstLetterUpper(username);
        
            generateMessageView(username, messages.get(i), datetimes.get(i));
        }
        
        chat_container.setContent(chatMessageHolder);
    }
    
    private void loadNewMessages(){
        
        int user_id = getIdFromFile();
        
        List<String> messages = getOldMessages();
        
        if(messages.size() == 0){
            return;
        }
        
        Timeline checkNewMessagesThread = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            String username = getUsername(getLastChatUserId());
            username = firstLetterUpper(username);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            
            Date currentDateTime = null;
            Date chatDateTime = null;
            
            try {
                currentDateTime = sdf.parse(getCurrentDateTime());
                chatDateTime = sdf.parse(getLastChatDateTime());
            } catch (ParseException ex) {
                System.out.println("ParseException: " + ex.getMessage());
            }
            
            chatDateTime = addSeconds(chatDateTime, 1);
            
            if(currentDateTime.equals(chatDateTime) && (getLastChatUserId() != user_id)){
                generateMessageView(username, getLastMessage(), getCurrentDateTime());
                chatMessageHolder.heightProperty().addListener(observable -> chat_container.setVvalue(1D));
            }
        }),
            // Refresh every 1 second
            new KeyFrame(Duration.seconds(1))
        );

        checkNewMessagesThread.setCycleCount(Animation.INDEFINITE);
        checkNewMessagesThread.play();
    }
    
    private void performSendMessage(){
        
        List<String> oldMessages = getOldMessages();
        String message = chat_input.getText().trim();
        int user_id = getIdFromFile();
        
        String username = getUsername(user_id);
        username = firstLetterUpper(username);
        
        if(oldMessages.size() == 0){
            chatMessageHolder.getChildren().remove(0);
        }
        
        if(message.length() != 0){
            if(saveMessage(user_id, message)){
                
                chat_input.setText("");
                chat_container.setVvalue(1.0);
            
                generateMessageView(username, message, getCurrentDateTime());
                
                chatMessageHolder.heightProperty().addListener(observable -> chat_container.setVvalue(1D));
            }
        }
    }
    
    private void generateMessageView(String username, String message, String datetime){
        
        Pane topInfoPane = new Pane();
        
        // Get time ago string
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = format.parse(datetime);
        } catch (ParseException ex) {
            System.out.println("ParseException: " + ex.getMessage());
        }
        String timeAgo = getTimeAgo(date);
        
        // Create label
        Label usernameLabel = new Label(username);
        Label messageLabel = new Label(message);
        Label datetimeLabel = new Label(timeAgo);
        
        // User picture
        char firstLetter = (char) (username.charAt(0) ^ 0x20);
        ImageView profilePicture = new ImageView("/res/assets/icons/letters/letter-" + firstLetter + ".png");
        
        // Set properties
        messageLabel.setWrapText(true);
        messageLabel.setMaxWidth(670);
        messageLabel.setTextAlignment(TextAlignment.JUSTIFY);
        
        usernameLabel.setTranslateX(50);
        datetimeLabel.setTranslateX(515);

        // Add stylesheets classes
        usernameLabel.getStyleClass().add("message_view_labels");
        messageLabel.getStyleClass().add("message_view_labels");
        datetimeLabel.getStyleClass().add("message_view_labels");
        
        usernameLabel.getStyleClass().add("username_label");
        messageLabel.getStyleClass().add("message_label");
        
        topInfoPane.getChildren().addAll(profilePicture, usernameLabel, datetimeLabel);
        
        // Add to VBox
        chatMessageHolder.getChildren().addAll(topInfoPane, messageLabel);
    }
    
    private void setBalanceToLabel(double bal){
        // Round balance to 2 decimal points
        bal = bal * 100;
        bal = Math.round(bal);
        bal = bal / 100;
        
        balance_val_label.setText("$" + bal);
    }
    
    private void loadBalanceToLabel() {     
        setBalanceToLabel(getBalance(getIdFromFile()));
    }
    
    public static Date addSeconds(Date date, Integer seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);
        
        return cal.getTime();
    }
    
    private String getCurrentDateTime(){
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
        String datetime = today.getYear() + "-" + today.getMonthValue() + "-" + today.getDayOfMonth() + " " + now;
        
        return datetime;

    }
    
    private int getIdFromFile() {
        Scanner in = null;
        try {
            in = new Scanner(new FileReader("user_data.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException in getIdFromFile(): " + ex);
        }

        int user_id = 0;
        if (in.hasNext()) {
            user_id = in.nextInt();
        }

        in.close();

        return user_id;
    }
    
    private String firstLetterUpper(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    
    public String getTimeAgo(Date startDate){
	
        Date endDate = new Date();
        
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;
        
        String seconds, minutes, hours, days;
        
        seconds = Long.toString(elapsedSeconds) + " seconds ago";
        minutes = Long.toString(elapsedMinutes) + " minutes, ";
        hours = Long.toString(elapsedHours) + " hours, ";
        days = Long.toString(elapsedDays) + " days, ";
        
        if(elapsedDays == 0){
            days = "";
        } else if(elapsedHours == 0){
            hours = "";
        } else if(elapsedMinutes == 0){
            minutes = "";
        }
        
        if(elapsedDays >= 1){
            String date = startDate.toString();
            return date.substring(0, date.length() - 8);
        }
        
        if(elapsedHours > 0 && elapsedDays < 1){
            return "few hours ago";
        }
        
        if(elapsedMinutes > 0 && elapsedHours < 1){
            return "few minutes ago";
        }
        
        if(elapsedDays == 0 && elapsedHours == 0 && elapsedMinutes == 0){
            return "few seconds ago";
        }
        
        return days + hours + minutes + seconds;
	
    }

    /*********************** FXML FUNCTIONS ***********************/
    
    @FXML
    void loadHome(MouseEvent event) {
        trans.setWindow(main_window);
        
        trans.fadeOutTransition("/views/Home.fxml");
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
    void logout(MouseEvent event){
        File file = new File("user_data.txt");
        
        if(file.delete()) {
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
    void sendMessage(ActionEvent event){
        performSendMessage();
    }
    
    @FXML
    void chatInputKeyTyped(KeyEvent event){
        String message = chat_input.getText().trim();
        
        if(message.length() == 0){
            send_btn.setDisable(true);
        } else {
            send_btn.setDisable(false);
        }
    }
    
    @FXML
    void chatInputKeyPressed(KeyEvent event){
        String message = chat_input.getText().trim();
        
        if (event.getCode().equals(KeyCode.ENTER)) {
            if(message.length() != 0){
                performSendMessage();
            }
        }
    }
    
    /*********************** SERVER FUNCTIONS ***********************/
    
    private static String getUsername(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getUsername(userId);
    }

    private static int getLastChatId() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getLastChatId();
    }

    private static int getLastChatUserId() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getLastChatUserId();
    }

    private static String getLastMessage() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getLastMessage();
    }
    
    private static String getLastChatDateTime() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getLastChatDateTime();
    }

    private static boolean saveMessage(int userId, java.lang.String message) {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.saveMessage(userId, message);
    }

    private static java.util.List<java.lang.String> getOldMessages() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getOldMessages();
    }

    private static java.util.List<java.lang.Integer> getOldChatIds() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getOldChatIds();
    }

    private static int getUserIdFromChatId(int chatId) {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getUserIdFromChatId(chatId);
    }

    private static double getBalance(int userId) {
        webservices.UserWS_Service service = new webservices.UserWS_Service();
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }

    private static java.util.List<java.lang.String> getOldDatetimes() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.getOldDatetimes();
    }

    private static void connectToChat(int arg0) {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        port.connectToChat(arg0);
    }

    private static void disconnectFromChat(int userId) {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        port.disconnectFromChat(userId);
    }

    private static java.util.List<java.lang.Integer> onlineUsersList() {
        webservices.ChatWS_Service service = new webservices.ChatWS_Service();
        webservices.ChatWS port = service.getChatWSPort();
        return port.onlineUsersList();
    }
}
