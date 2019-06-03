package com.helpdesk.user_interface.windows;

import com.helpdesk.entity.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static com.helpdesk.service.employee.ReadEmployeeData.readEmployeeData;
import static com.helpdesk.service.ticket.CreateTicket.createNewTicket;

public class NewTicketWin {

    @FXML
    private ComboBox cb_ticketPrior;
    @FXML
    private ComboBox cb_ticketStatus;
    @FXML
    private ComboBox cb_ticketTechnician;

    @FXML
    private TextField tf_ticketCustId;
    @FXML
    private TextField tf_AssignedTo;

    @FXML
    private Button btn_NewTicketConfirm;

    @FXML
    private Button btn_NewTicketCancel;

    private ArrayList<Employee> employeeList = new ArrayList<>();

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

        employeeList = (ArrayList<Employee>) readEmployeeData();

        // Test Data
        //employeeList.add(new Employee(13, "Ruslan", "Hassonov", "00/00 00 00", "rhassonov@gmail.com"));
        //employeeList.add(new Employee(45, "Stas", "Roedko", "00/00 00 00", "rhassonov@gmail.com"));

        for (Employee e : employeeList) {
            cb_ticketTechnician.getItems().add(e.geteId() + " - " + e.geteFirstName() + " " + e.geteLastName());
        }

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
            int custId = Integer.parseInt(tf_ticketCustId.getText());
            String prior = cb_ticketPrior.getValue().toString();
            String status = cb_ticketStatus.getValue().toString();
            int assignedTo = Integer.parseInt(tf_AssignedTo.getText());

            createNewTicket(custId, status, prior, assignedTo);

            JOptionPane.showMessageDialog(new JFrame(), "New ticket succesfully created");
            clearInputFields();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
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
