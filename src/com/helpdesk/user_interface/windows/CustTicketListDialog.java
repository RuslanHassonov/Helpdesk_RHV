package com.helpdesk.user_interface.windows;

import com.helpdesk.entity.Customer;
import com.helpdesk.entity.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;

public class CustTicketListDialog {


    @FXML
    private Label lbl_CustFullName;
    @FXML
    private Label lbl_WrkStatus;
    @FXML
    private Label lbl_TicketNr;

    @FXML
    private Button btn_CustTicketListOk;

    @FXML
    private ListView<Ticket> lv_CustTicketList;

    private Ticket ticket;
    private Customer customer;

    @FXML
    private void initialize() {

        lv_CustTicketList.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> getTicketWorkDetails(newValue)
        );
    }

    @FXML
    private void OkButtonPressed() {
        btn_CustTicketListOk.cancelButtonProperty();
        Stage stage = (Stage) btn_CustTicketListOk.getScene().getWindow();
        stage.close();
    }

    public void initData(Customer customer) {
        if (customer != null) {
            this.customer = customer;
            lbl_CustFullName.setText(customer.getcFirstName() + " " + customer.getcLastName());
            populateTicketListView(customer);
            //lbl_EmpFullName.setText("Test test test");
        } else {
            lbl_CustFullName.setText("Customer");
        }
    }

    private void populateTicketListView(Customer c) {
        try {
            ObservableList<Ticket> tickets = FXCollections.observableArrayList(c.getcTicketList());
            lv_CustTicketList.setItems(tickets);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error during list display: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void getTicketWorkDetails(Ticket ticket) {
        if (ticket != null) {
            this.ticket = ticket;
            lbl_WrkStatus.setText(ticket.gettStatus());
            lbl_TicketNr.setText(String.valueOf(ticket.gettId()));

        } else {
            System.out.println("No ticket found.");
        }
    }


}
