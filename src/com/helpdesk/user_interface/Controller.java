package com.helpdesk.user_interface;

import com.helpdesk.entity.Customer;
import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Ticket;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller {

    //<editor-fold desc="table-view definition">
    @FXML
    private TableView<Customer> tblV_Customer;
    @FXML
    private TableColumn<Customer, String> tblC_CustomerNr;
    @FXML
    private TableColumn<Customer, String> tblC_CustFullName;

    @FXML
    private TableView<Employee> tblV_Employee;
    @FXML
    private TableColumn<Employee, String> tblC_EmplNr;
    @FXML
    private TableColumn<Employee, String> tblC_EmplFullName;

    @FXML
    private TableView<Ticket> tblV_TicketListTable;
    @FXML
    private TableColumn<Ticket, String> tblC_TicketNr;
    @FXML
    private TableColumn<Ticket, String> tblC_TicketStatus;
    @FXML
    private TableColumn<Ticket, String> tblC_TicketDate;
    //</editor-fold>

    //<editor-fold desc="button definition">
    @FXML
    private Button btn_Minimize;
    @FXML
    private Button btn_Close;
    @FXML
    private Button btn_Home;
    @FXML
    private Button btn_Customers;
    @FXML
    private Button btn_TicketList;
    @FXML
    private Button btn_Staff;
    @FXML
    private Button btn_SearchCust;
    @FXML
    private Button btn_NewCustomer;
    //</editor-fold>

    @FXML
    private TextField tf_CustNumber;

    //<editor-fold desc="label definition">
    @FXML
    private Label lbl_FirstName;
    @FXML
    private Label lbl_LastName;
    @FXML
    private Label lbl_Street;
    @FXML
    private Label lbl_City;
    @FXML
    private Label lbl_PostalCode;
    @FXML
    private Label lbl_Phone;
    @FXML
    private Label lbl_Email;
    //</editor-fold>

    //<editor-fold desc="anchor-pane definition">
    @FXML
    private AnchorPane ap_Customers;
    @FXML
    private AnchorPane ap_TicketList;
    @FXML
    private AnchorPane ap_Staff;
    //</editor-fold>

    private double xOffset = 0;
    private double yOffset = 0;


    private ObservableList<Customer> customerDate = FXCollections.observableArrayList();

    private void showCustomerDetails(Customer customer) {
        if (customer != null) {
            lbl_FirstName.setText(customer.getcFirstName());
            lbl_LastName.setText(customer.getcLastName());
            //lbl_Street.setText(customer.getcAddress().getaStreet());
            //lbl_City.setText(customer.getcAddress().getaCity());
            //lbl_PostalCode.setText(String.valueOf(customer.getcAddress().getaPostalCode()));
            lbl_Phone.setText(customer.getcPhoneNumber());
            lbl_Email.setText(customer.getcEmail());
        } else {

            lbl_FirstName.setText("");
            lbl_LastName.setText("");
            lbl_Street.setText("");
            lbl_City.setText("");
            lbl_PostalCode.setText("");
            lbl_Phone.setText("");
            lbl_Email.setText("");

        }
    }

    private void screenInitialize() {
        ap_Customers.setDisable(true);
        ap_TicketList.setDisable(true);
        ap_Staff.setDisable(true);
        ap_Customers.setVisible(false);
        ap_TicketList.setVisible(false);
        ap_Staff.setVisible(false);
    }

    @FXML
    private void initialize() {
        screenInitialize();
        tblV_Customer.setItems(customerDate);

        showCustomerDetails(null);

        tblV_Customer.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    showCustomerDetails(newValue);
                }
        );

    }

    @FXML
    private void homeButtonPressed() {
        screenInitialize();
    }

    @FXML
    private void customersButtonPressed() {
        screenInitialize();
        ap_Customers.setDisable(false);
        ap_Customers.setVisible(true);
    }

    @FXML
    private void ticketsButtonPressed() {
        screenInitialize();
        ap_TicketList.setDisable(false);
        ap_TicketList.setVisible(true);
    }

    @FXML
    private void staffButtonPressed() {
        screenInitialize();
        ap_Staff.setDisable(false);
        ap_Staff.setVisible(true);
    }

    @FXML
    private void newCustomerButtonPressed() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newCustomer.fxml"));
            Parent root = fxmlLoader.load();
            Stage newCustWindow = new Stage();
            newCustWindow.initStyle(StageStyle.UNDECORATED);

            //Make undecorated window draggable/movable
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    newCustWindow.setX(event.getScreenX() - xOffset);
                    newCustWindow.setY(event.getScreenY() - yOffset);
                }
            });

            newCustWindow.setScene(new Scene(root));
            newCustWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelButtonPressed() {
        closeButtonPressed();
    }


    @FXML
    private void minimizeButtonPressed() {
        Stage stage = (Stage) btn_Minimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeButtonPressed() {
        Platform.exit();
    }

}
