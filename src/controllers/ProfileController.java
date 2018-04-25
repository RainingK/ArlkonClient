package controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import utils.Transition;
import utils.WindowHandler;

public class ProfileController implements Initializable {
    @FXML private Pane main_window;
    
    @FXML private ImageView close_btn;
    @FXML private ImageView minimize_btn;
    
    @FXML private TableView<List<String>> transaction_history;
    @FXML private TableView<List<String>> withdraw_transaction;
    
    static String Text = printData(), Text2 = printInvestData();;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        //Fadein transition
        Transition tr = new Transition();
        tr.fadeInTransition();
        
        //Creating Binary Columns
        createBinaryTable();
        
        //Create Investment Tables
        createInvestTables();
        
        //Close and Minimize Buttons
        WindowHandler wh = new WindowHandler();
        wh.closeProgram(close_btn);
        wh.minimizeProgram(minimize_btn);
        
    }
    
    public void createBinaryTable(){
        TableColumn Col1 = new TableColumn("ID");
        Col1.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column1"));
        Col1.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(0));
            }
            
        });
        
        TableColumn Col2 = new TableColumn("Type");
        Col2.setMinWidth(75);
        Col2.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column2"));
        Col2.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(1));
            }
            
        });
        
        TableColumn Col3 = new TableColumn("Amount");
        Col3.setMinWidth(75);
        Col3.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column3"));
        Col3.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(2));
            }
            
        });
        
        TableColumn Col4 = new TableColumn("Result");
        Col4.setMinWidth(75);
        Col4.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column4"));
        Col4.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(3));
            }
            
        });
        
        TableColumn Col5 = new TableColumn("TimeFrame");
        Col5.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column5"));
        Col5.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(4));
            }
            
        });
        
        TableColumn Col6 = new TableColumn("Transaction Date");
        Col6.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Column6"));
        Col6.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(5));
            }
            
        });
        
        transaction_history.setItems(getData());
        transaction_history.getColumns().addAll(Col1, Col2, Col3, Col4, Col5, Col6);
    }
    
    public void createInvestTables(){
        TableColumn Colu1 = new TableColumn("ID");
        Colu1.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Co1"));
        Colu1.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(0));
            }
            
        });
        
        TableColumn Colu2 = new TableColumn("Amount");
        Colu2.setMinWidth(75);
        Colu2.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col2"));
        Colu2.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(1));
            }
            
        });
        
        TableColumn Colu3 = new TableColumn("Profit");
        Colu3.setMinWidth(75);
        Colu3.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col3"));
        Colu3.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(2));
            }
            
        });
        
        TableColumn Colu4 = new TableColumn("Loss");
        Colu4.setMinWidth(75);
        Colu4.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col4"));
        Colu4.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(3));
            }
            
        });
        
        TableColumn Colu5 = new TableColumn("Transaction Date");
        Colu5.setCellValueFactory(new PropertyValueFactory<List<String>,String>("Col5"));
        Colu5.setCellValueFactory(new Callback<CellDataFeatures<List<String>, String>, ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyStringWrapper(data.getValue().get(4));
            }
        });
        
        withdraw_transaction.setItems(getInvestmentData());
        withdraw_transaction.getColumns().addAll(Colu1, Colu2, Colu3, Colu4, Colu5);
    }
    
    public static ObservableList<List<String>> getData() {
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
    
    public static ObservableList<List<String>> getInvestmentData() {
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
            System.out.println("Read Complete");
        } catch (FileNotFoundException ex) { 
            System.out.println("FileNotFoundException: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        
        return data;
    }

    private static String printData() {
        webservices.ProfileWS_Service service = new webservices.ProfileWS_Service();
        webservices.ProfileWS port = service.getProfileWSPort();
        return port.printData();
    }

    private static String printInvestData() {
        webservices.ProfileWS_Service service = new webservices.ProfileWS_Service();
        webservices.ProfileWS port = service.getProfileWSPort();
        return port.printInvestData();
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
    
}
