package com.helpdesk.user_interface.windows;

import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.List;


public class EmpTicketListDialog {

    @FXML
    private Label lbl_EmpFullName;
    @FXML
    private Button btn_EmpTicketListCancel;
    @FXML
    private Button btn_EmpTicketListConfirm;
    @FXML
    private ListView<Ticket> lv_EmpTicketList;

    @FXML
    private void initialize() {
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

    private void populateTicketListView(Employee e){
        try {
            ObservableList<Ticket> tickets = FXCollections.observableArrayList(e.geteTicketList());
            lv_EmpTicketList.setItems(tickets);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error during list display: " + ex.getMessage());
            ex.printStackTrace();
        }
    }



}
