package com.helpdesk.user_interface;

import com.helpdesk.entity.Customer;
import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Ticket;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
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

import javax.swing.*;
import java.io.IOException;

import static com.helpdesk.service.customer.DeleteCustomer.deleteExistingCustomer;
import static com.helpdesk.service.customer.FindCustomer.findExistingCustomer;
import static com.helpdesk.service.customer.ReadCustomerData.readCustomerData;
import static com.helpdesk.service.customer.UpdateCustomer.updateExistingCustomer;
import static com.helpdesk.service.employee.DeleteEmployee.deleteExistingEmployee;
import static com.helpdesk.service.employee.ReadEmployeeData.readEmployeeData;
import static com.helpdesk.service.ticket.ReadTicketData.readTicketData;

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
    @FXML
    private Button btn_CustEdit;
    @FXML
    private Button btn_CustEditOK;
    @FXML
    private Button btn_CustDelete;
    @FXML
    private Button btn_NewEmployee;
    @FXML
    private Button btn_EmpDelete;
    @FXML
    private Button btn_EmpEdit;
    @FXML
    private Button btn_NewTicket;
    //</editor-fold>

    @FXML
    private TextField tf_CustNumber;
    @FXML
    private TextField tf_CustFName;
    @FXML
    private TextField tf_CustLName;
    @FXML
    private TextField tf_CustStreet;
    @FXML
    private TextField tf_CustCity;
    @FXML
    private TextField tf_CustPostCode;
    @FXML
    private TextField tf_CustPhone;
    @FXML
    private TextField tf_CustEmail;

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
    @FXML
    private Label lbl_EmployeeFirstName;
    @FXML
    private Label lbl_EmployeeLastName;
    @FXML
    private Label lbl_EmployeePhone;
    @FXML
    private Label lbl_EmployeeEmail;
    @FXML
    private Label lbl_EmployeeRole;
    @FXML
    private Label lbl_TicketDescription;
    @FXML
    private Label lbl_TicketNr;
    @FXML
    private Label lbl_TicketStatus;
    @FXML
    private Label lbl_TicketPriority;
    @FXML
    private Label lbl_TicketAssigned;
    @FXML
    private Label lbl_TicketDate;
    //</editor-fold>

    //<editor-fold desc="anchor-pane definition">
    @FXML
    private AnchorPane ap_Customers;
    @FXML
    private AnchorPane ap_TicketList;
    @FXML
    private AnchorPane ap_Staff;
    @FXML
    private AnchorPane ap_Home;
    //</editor-fold>

    private double xOffset = 0;
    private double yOffset = 0;
    private Customer customer;
    private Employee employee;


    private ObservableList<Customer> customerData = FXCollections.observableArrayList();
    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
    private ObservableList<Ticket> ticketData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        screenInitialize();
        populateTableView();
        showCustomerDetails(null);
        showEmployeeDetails(null);
        showTicketDetails(null);

        tblV_Customer.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    showCustomerDetails(newValue);
                }
        );

        tblV_Employee.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    showEmployeeDetails(newValue);
                })
        );

        tblV_TicketListTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showTicketDetails(newValue);
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
    private void findCustomerButtonPressed() {
        Customer customer = findExistingCustomer(Integer.parseInt(tf_CustNumber.getText()));
        showCustomerDetails(customer);
    }

    @FXML
    private void newCustomerButtonPressed() {
        try {
            newButtonPressedHandling("newCustomer");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void editCustomerButtonPressed() {
        lbl_FirstName.setVisible(false);
        lbl_LastName.setVisible(false);
        lbl_Street.setVisible(false);
        lbl_City.setVisible(false);
        lbl_PostalCode.setVisible(false);
        lbl_Phone.setVisible(false);
        lbl_Email.setVisible(false);

        tf_CustFName.setVisible(true);
        tf_CustLName.setVisible(true);
        tf_CustStreet.setVisible(true);
        tf_CustCity.setVisible(true);
        tf_CustPostCode.setVisible(true);
        tf_CustPhone.setVisible(true);
        tf_CustEmail.setVisible(true);

        btn_CustEditOK.setVisible(true);
    }

    @FXML
    private void editCustomerOKButtonPressed() {
        try {
            int id = customer.getcId();
            String fName = tf_CustFName.getText();
            String lName = tf_CustLName.getText();
            String street = tf_CustStreet.getText();
            String city = tf_CustCity.getText();
            int postCode = Integer.parseInt(tf_CustPostCode.getText());
            String phone = tf_CustPhone.getText();
            String email = tf_CustEmail.getText();

            updateExistingCustomer(id, fName, lName, phone, email);
            JOptionPane.showMessageDialog(new JFrame(), "Customer succesfully updated");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Numerical value error during update", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error during update", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    private void deleteCustomerButtonPressed() {
        try {
            int id = customer.getcId();
            deleteExistingCustomer(id);
            JOptionPane.showMessageDialog(new JFrame(), "Customer succesfully deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error during deletion", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }


    @FXML
    private void newEmployeeButtonPressed() {
        try {
            newButtonPressedHandling("newEmployee");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteEmployeeButtonPressed() {
        try {
            int id = employee.geteId();
            deleteExistingEmployee(id);
            JOptionPane.showMessageDialog(new JFrame(), "Employee succesfully deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error during deletion", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    @FXML
    private void newTicketButtonPressed() {
        try {
            newButtonPressedHandling("newTicket");
        } catch (IOException e) {
            e.printStackTrace();
        }
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


    //<editor-fold desc="details">
    private void showCustomerDetails(Customer customer) {
        if (customer != null) {
            screenInitialize();
            this.customer = customer;
            lbl_FirstName.setText(customer.getcFirstName());
            lbl_LastName.setText(customer.getcLastName());
            lbl_Street.setText(customer.getcAddress().getaStreet() + " " + customer.getcAddress().getaHouseNumber());
            lbl_City.setText(customer.getcAddress().getaCity());
            lbl_PostalCode.setText(String.valueOf(customer.getcAddress().getaPostalCode()));
            lbl_Phone.setText(customer.getcPhoneNumber());
            lbl_Email.setText(customer.getcEmail());

            tf_CustFName.setText(customer.getcFirstName());
            tf_CustLName.setText(customer.getcLastName());
            tf_CustStreet.setText(customer.getcAddress().getaStreet());
            tf_CustCity.setText(customer.getcAddress().getaCity());
            tf_CustPostCode.setText(String.valueOf(customer.getcAddress().getaPostalCode()));
            tf_CustPhone.setText(customer.getcPhoneNumber());
            tf_CustEmail.setText(customer.getcEmail());

        } else {
            screenInitialize();
            lbl_FirstName.setText("");
            lbl_LastName.setText("");
            lbl_Street.setText("");
            lbl_City.setText("");
            lbl_PostalCode.setText("");
            lbl_Phone.setText("");
            lbl_Email.setText("");
        }
    }

    private void showTicketDetails(Ticket ticket) {
        if (ticket != null) {
            screenInitialize();
            lbl_TicketNr.setText(String.valueOf(ticket.gettId()));
            lbl_TicketPriority.setText(ticket.gettPriority());
            lbl_TicketStatus.setText(ticket.gettStatus());
            lbl_TicketAssigned.setText("text");
            lbl_TicketDate.setText("test");
            lbl_TicketDescription.setText("test");

        } else {

            lbl_TicketNr.setText("");
            lbl_TicketPriority.setText("");
            lbl_TicketStatus.setText("");
            lbl_TicketAssigned.setText("");
            lbl_TicketDate.setText("");
            lbl_TicketDescription.setText("");
        }
    }

    private void showEmployeeDetails(Employee employee) {
        if (employee != null) {
            screenInitialize();
            lbl_EmployeeFirstName.setText(employee.geteFirstName());
            lbl_EmployeeLastName.setText(employee.geteLastName());
            lbl_EmployeePhone.setText(employee.getePhoneNumber());
            lbl_EmployeeEmail.setText(employee.geteEmail());

            switch (employee.getClass().getSimpleName()) {
                case "Manager":
                    lbl_EmployeeRole.setText("Manager");
                    break;
                case "Technician":
                    lbl_EmployeeRole.setText("Technician");
                    break;
                case "Dispatcher":
                    lbl_EmployeeRole.setText("Dispatcher");
                    break;
                default:
                    lbl_EmployeeRole.setText("Employee");
                    break;
            }
        } else {
            lbl_EmployeeRole.setText("");
            lbl_EmployeeFirstName.setText("");
            lbl_EmployeeLastName.setText("");
            lbl_EmployeePhone.setText("");
            lbl_EmployeeEmail.setText("");
        }
    }
    //</editor-fold>

    private void screenInitialize() {
        ap_Home.setVisible(true);
        ap_Customers.setDisable(true);
        ap_TicketList.setDisable(true);
        ap_Staff.setDisable(true);
        ap_Customers.setVisible(false);
        ap_TicketList.setVisible(false);
        ap_Staff.setVisible(false);

        tf_CustFName.setVisible(false);
        tf_CustLName.setVisible(false);
        tf_CustStreet.setVisible(false);
        tf_CustCity.setVisible(false);
        tf_CustPostCode.setVisible(false);
        tf_CustPhone.setVisible(false);
        tf_CustEmail.setVisible(false);

        btn_CustEditOK.setVisible(false);
    }

    private void populateTableView() {
        try {
            customerData.addAll(readCustomerData());
            tblC_CustomerNr.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getcId())));
            tblC_CustFullName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getcFirstName() + " " + c.getValue().getcLastName()));
            tblV_Customer.setItems(customerData);

            employeeData.addAll(readEmployeeData());
            tblC_EmplNr.setCellValueFactory(e -> new SimpleStringProperty(String.valueOf(e.getValue().geteId())));
            tblC_EmplFullName.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().geteFirstName() + " " + e.getValue().geteLastName()));
            tblV_Employee.setItems(employeeData);

            ticketData.addAll(readTicketData());
            tblC_TicketNr.setCellValueFactory(t -> new SimpleStringProperty(String.valueOf(t.getValue().gettId())));
            tblC_TicketStatus.setCellValueFactory(t -> new SimpleStringProperty(t.getValue().gettStatus()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void undecoratedDraggableStage(Parent root, Stage s) {

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
                s.setX(event.getScreenX() - xOffset);
                s.setY(event.getScreenY() - yOffset);
            }
        });
    }

    private void newButtonPressedHandling(String window) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("windows/" + window + ".fxml"));
        Parent root = fxmlLoader.load();
        Stage s = new Stage();
        s.initStyle(StageStyle.UNDECORATED);

        undecoratedDraggableStage(root, s);

        s.setScene(new Scene(root));
        s.show();
    }


}
