package com.helpdesk.user_interface.windows;

import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;

import static com.helpdesk.service.ticketLine.CreateTicketLine.createNewTicketLine;


public class EmpTicketListDialog {

    @FXML
    private Label lbl_EmpFullName;
    @FXML
    private Label lbl_WrkStatus;

    @FXML
    private TextField tf_WrkDescription;

    @FXML
    private CheckBox chkb_WrkOrderClosed;

    @FXML
    private Button btn_EmpTicketListCancel;
    @FXML
    private Button btn_EmpTicketListConfirm;

    @FXML
    private ListView<Ticket> lv_EmpTicketList;

    private Ticket ticket;
    private boolean check = false;

    @FXML
    private void initialize() {
        lv_EmpTicketList.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> getTicketWorkDetails(newValue)
        );
    }

    @FXML
    private void confirmButtonPressed() {
        if (chkb_WrkOrderClosed.isSelected()) {
            check = true;
        }
        try {
            createNewTicketLine(ticket.gettId(), tf_WrkDescription.getText(), check);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error during ticket line creation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelButtonPressed() {
        btn_EmpTicketListCancel.cancelButtonProperty();
        Stage stage = (Stage) btn_EmpTicketListCancel.getScene().getWindow();
        stage.close();
    }

    public void initData(Employee employee) {
        if (employee != null) {
            lbl_EmpFullName.setText(employee.geteFirstName() + " " + employee.geteLastName());
            populateTicketListView(employee);
            //lbl_EmpFullName.setText("Test test test");
        } else {
            lbl_EmpFullName.setText("Employee");
        }
    }

    private void populateTicketListView(Employee e) {
        try {
            ObservableList<Ticket> tickets = FXCollections.observableArrayList(e.geteTicketList());
            lv_EmpTicketList.setItems(tickets);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error during list display: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void getTicketWorkDetails(Ticket ticket) {

        if (ticket != null) {
            this.ticket = ticket;
            lbl_WrkStatus.setText(ticket.gettStatus());
        } else {
            System.out.println("No ticket found.");
        }
    }


}
