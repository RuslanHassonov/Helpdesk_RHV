package com.helpdesk.user_interface.windows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

import static com.helpdesk.service.employee.CreateEmployee.createNewEmployee;

public class NewTicketWin {
    @FXML
    private TextField tf_ticketCustId;

    @FXML
    private ComboBox cb_ticketPrior;

    @FXML
    private ComboBox cb_ticketStatus;

    @FXML
    private TextField tf_AssignedTo;


    @FXML
    private Button btn_NewTicketConfirm;

    @FXML
    private Button btn_NewTicketCancel;


    @FXML
    private void initialize() {
        cb_ticketPrior.getItems().addAll(
                "Highest",
                "High",
                "Medium",
                "Low"
        );

        cb_ticketStatus.getItems().addAll(
                "Open",
                "WIP",
                "Closed"
        );
        cb_ticketStatus.getSelectionModel().selectFirst();

    }


    @FXML
    private void cancelButtonPressed() {
        btn_NewTicketCancel.cancelButtonProperty();
        Stage stage = (Stage) btn_NewTicketCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmButtonPressed() {

        try {
            validateInputField();
            String custId = tf_ticketCustId.getText();
            String prior = cb_ticketPrior.getValue().toString();
            String status = cb_ticketStatus.getValue().toString();
            String assignedTo = tf_AssignedTo.getText();

            //createNewTicket(fName, lName, phone, email, role);

            JOptionPane.showMessageDialog(new JFrame(), "New ticket succesfully created");
            clearInputFields();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void validateInputField() {
        if ((tf_ticketCustId.getText() == null) ||
                (tf_AssignedTo.getText() == null)) {
            throw new IllegalArgumentException("All fields must be filled in correctly.");
        }

        if (cb_ticketPrior.getValue().toString().isEmpty()) {
            throw new IllegalArgumentException("Please choose a priority.");
        }
    }

    @FXML
    private void clearInputFields() {
        tf_ticketCustId.clear();
        tf_AssignedTo.clear();
        cb_ticketPrior.setValue(null);
        cb_ticketStatus.getSelectionModel().selectFirst();
    }
}
