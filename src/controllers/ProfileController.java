package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.xml.ws.WebServiceException;
import utils.Transition;
import utils.WindowHandler;

public class ProfileController implements Initializable {
    @FXML private Pane main_window;
    
    @FXML private Label username_label, email_label, date_label, balance_val_label;
    @FXML private ImageView profile_pic_icon;
    
    // Header
    @FXML
    private Pane home_btn_pane, settings_btn_pane, help_btn_pane, logout_btn_pane;
    
    @FXML
    private ImageView home_btn, settings_btn, help_btn, logout_btn;
    
    @FXML
    private Label home_btn_label, settings_btn_label, help_btn_label, logout_btn_label;
    
    
    @FXML private ImageView close_btn;
    @FXML private ImageView minimize_btn;
    
    @FXML private TableView<List<String>> transaction_history;
    @FXML private TableView<List<String>> withdraw_transaction;
    
    Transition trans = new Transition();
    
    String Text = printData(getIdFromFile());
    String Text2 = printInvestData(getIdFromFile());
    
    static final String HOST_ADDR = "172.28.18.204";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        //Fadein transition
        trans.fadeInTransition();
        
        // Header effects
        trans.applyHeaderEffect(home_btn_pane, home_btn, home_btn_label);
        trans.applyHeaderEffect(settings_btn_pane, settings_btn, settings_btn_label);
        trans.applyHeaderEffect(logout_btn_pane, logout_btn, logout_btn_label);
        trans.applyHeaderEffect(help_btn_pane, help_btn, help_btn_label);
        
        //Creating Binary Columns
        createBinaryTable();
        
        //Create Investment Tables
        createInvestTables();
        
        // Load balance to label
        loadBalanceToLabel();
        
        // Display user info
        displayInfo();
        
        //Close and Minimize Buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn, main_window);
        wh.minimizeProgram(minimize_btn);
        
    }
    
    public void createBinaryTable(){
        TableColumn Col1 = new TableColumn("ID");
        Col1.setMinWidth(60);
        Col1.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Col1.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column1"));
        Col1.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(0));
            }
            
        });
        
        TableColumn Col2 = new TableColumn("Type");
        Col2.setMinWidth(80);
        Col2.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Col2.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column2"));
        Col2.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(1));
            }
            
        });
        
        TableColumn Col7 = new TableColumn("Currency");
        Col7.setMinWidth(75);
        Col7.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Col7.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column7"));
        Col7.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(2));
            }
            
        });
        
        TableColumn Col3 = new TableColumn("Amount");
        Col3.setMinWidth(100);
        Col3.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Col3.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column3"));
        Col3.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(3));
            }
            
        });
        
        TableColumn Col4 = new TableColumn("Result");
        Col4.setMinWidth(108);
        Col4.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Col4.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column4"));
        Col4.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                String val = data.getValue().get(4);
                
                if(val.equals("null")){
                    val = "-";
                }
                return new ReadOnlyStringWrapper(val);
            }
            
        });
        
        TableColumn Col5 = new TableColumn("Timeframe");
        Col5.setMinWidth(80);
        Col5.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Col5.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column5"));
        Col5.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                String val = data.getValue().get(5);
                
                if(val.equals("null")){
                    val = "-";
                }
                return new ReadOnlyStringWrapper(val);
            }
            
        });
        
        TableColumn Col6 = new TableColumn("Transaction Date");
        Col6.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Col6.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column6"));
        Col6.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(6));
            }
            
        });
        
        transaction_history.setItems(getData());
        transaction_history.getColumns().addAll(Col1, Col2, Col7, Col3, Col4, Col5, Col6);
    }
    
    public void createInvestTables(){
        TableColumn Colu1 = new TableColumn("ID");
        Colu1.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Colu1.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Co1"));
        Colu1.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(0));
            }
            
        });
        
        TableColumn Colu2 = new TableColumn("Amount");
        Colu2.setMinWidth(75);
        Colu2.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Colu2.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col2"));
        Colu2.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(1));
            }
            
        });
        
        TableColumn Colu6 = new TableColumn("Currency");
        Colu6.setMinWidth(75);
        Colu6.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Colu6.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col3"));
        Colu6.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(2));
            }
            
        });
        
        TableColumn Colu3 = new TableColumn("Profit");
        Colu3.setMinWidth(80);
        Colu3.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Colu3.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col3"));
        Colu3.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(3));
            }
            
        });
        
        TableColumn Colu4 = new TableColumn("Loss");
        Colu4.setMinWidth(80);
        Colu4.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Colu4.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col4"));
        Colu4.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(4));
            }
            
        });
        
        TableColumn Colu5 = new TableColumn("Transaction Date");
        Colu5.setMinWidth(130);
        Colu5.setStyle("-fx-text-fill: white;-fx-alignment: CENTER;");
        Colu5.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col5"));
        Colu5.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(5));
            }
        });
        
        withdraw_transaction.setItems(getInvestmentData());
        withdraw_transaction.getColumns().addAll(Colu1, Colu2, Colu6, Colu3, Colu4, Colu5);
    }
    
    public ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        try {
            String filepath = "..\\ArlkonClient\\src\\res\\txtFiles\\TransactionHistory.txt";
            System.out.println("Function Started");
            PrintWriter pw = new PrintWriter(filepath);
            pw.print(Text);
            pw.close();
            
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            Scanner input = new Scanner(bufferedReader);
            //input.useDelimiter(" ");
            
            while (input.hasNext()) {
                List<String> unit = new ArrayList<String>();

                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next() + " " + input.next());
                data.add(unit);
            }
            
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) { 
            System.out.println("FileNotFoundException: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        return data;
    }
    
    public ObservableList<List<String>> getInvestmentData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        try {
            System.out.println("Function Started");
            String filepath = "..\\ArlkonClient\\src\\res\\txtFiles\\Invest Transaction History.txt";
            PrintWriter pw = new PrintWriter(filepath);
            pw.print(Text2);
            pw.close();
            
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            Scanner input = new Scanner(bufferedReader);

            while (input.hasNext()) {
                List<String> unit = new ArrayList<String>();
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next());
                
                unit.add(input.next() + " " + input.next());
                data.add(unit);
            }
            
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) { 
            System.out.println("FileNotFoundException: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        
        return data;
    }

    public void displayInfo(){
        int user_id = getIdFromFile();
        String username = firstLetterUpper(getUsername(user_id));
        
        username_label.setText(username);
        email_label.setText(getEmail(user_id));
        date_label.setText("Joined on " + getDateJoin(user_id).substring(0, 10));
        balance_val_label.setText("$" + getBalance(user_id));
        
        profile_pic_icon.setImage(new Image("/res/assets/icons/letters/letter-" + getUsername(user_id).toLowerCase().charAt(0) + ".png"));
        
    }
    
    private String firstLetterUpper(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1);
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
    
    private static int getIdFromFile() {
        Scanner in = null;
        try {
            in = new Scanner(new FileReader("user_data.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + ex.getMessage());
        }

        int user_id = 0;
        if (in.hasNext()) {
            user_id = in.nextInt();
        }

        in.close();

        return user_id;
    }

    @FXML
    void loadHome(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/Home.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

    @FXML
    void loadSettings(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/settings.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }
    }
    
    @FXML
    void loadHelp(MouseEvent event) {
        trans.setWindow(main_window);
        
        try {
            trans.loadNextScene("/views/help.fxml");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
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
 

    private static String getUsername(int userId) {
        
        webservices.UserWS_Service service = null;
        try {
            try {
                service = new webservices.UserWS_Service(new URL("http://localhost:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.UserWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.UserWS port = service.getUserWSPort();
        return port.getUsername(userId);
    }

    private static double getBalance(int userId) {
        webservices.UserWS_Service service = null;
        try {
            try {
                service = new webservices.UserWS_Service(new URL("http://localhost:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.UserWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.UserWS port = service.getUserWSPort();
        return port.getBalance(userId);
    }

    private static String getEmail(int userId) {
        webservices.UserWS_Service service = null;
        try {
            try {
                service = new webservices.UserWS_Service(new URL("http://localhost:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.UserWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.UserWS port = service.getUserWSPort();
        return port.getEmail(userId);
    }

    private static String getDateJoin(int userId) {
       webservices.UserWS_Service service = null;
        try {
            try {
                service = new webservices.UserWS_Service(new URL("http://localhost:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.UserWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/UserWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.UserWS port = service.getUserWSPort();
        return port.getDateJoin(userId);
    }

    private static String printData(int userId) {
        webservices.ProfileWS_Service service = null;
        try {
            try {
                service = new webservices.ProfileWS_Service(new URL("http://localhost:8080/ArlkonServer/ProfileWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.ProfileWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/ProfileWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.ProfileWS port = service.getProfileWSPort();
        return port.printData(userId);
    }

    private static String printInvestData(int userId) {
        webservices.ProfileWS_Service service = null;
        try {
            try {
                service = new webservices.ProfileWS_Service(new URL("http://localhost:8080/ArlkonServer/ProfileWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(WebServiceException e){
            try {
                service = new webservices.ProfileWS_Service(new URL("http://172.28.22.4:8080/ArlkonServer/ProfileWS?wsdl"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        webservices.ProfileWS port = service.getProfileWSPort();
        return port.printInvestData(userId);
    }
    
}
