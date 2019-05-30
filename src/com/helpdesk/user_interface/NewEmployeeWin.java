package com.helpdesk.user_interface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

import static com.helpdesk.service.employee.CreateEmployee.createNewEmployee;

public class NewEmployeeWin {
    @FXML
    private TextField tf_NewEmpFirstName;

    @FXML
    private TextField tf_NewEmpLastName;

    @FXML
    private TextField tf_NewEmpPhone;

    @FXML
    private TextField tf_NewEmpEmail;

    @FXML
    private Button btn_NewEmpConfirm;

    @FXML
    private Button btn_NewEmpCancel;


    @FXML
    private void cancelButtonPressed() {
        btn_NewEmpCancel.cancelButtonProperty();
        Stage stage = (Stage) btn_NewEmpCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmButtonPressed() {

        try {
            validateTextField();
            String fName = tf_NewEmpFirstName.getText();
            String lName = tf_NewEmpLastName.getText();
           String phone = tf_NewEmpPhone.getText();
            String email = tf_NewEmpEmail.getText();

            createNewEmployee(fName, lName, phone, email);
            //createNewCustomer();

            JOptionPane.showMessageDialog(new JFrame(), "New employee succesfully created");
            clearInputFields();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void validateTextField() {
        if ((tf_NewEmpFirstName.getText() == null) ||
                (tf_NewEmpLastName.getText() == null) ||
                (tf_NewEmpPhone.getText() == null) ||
                (tf_NewEmpEmail.getText() == null)) {
            throw new IllegalArgumentException("All fields must be filled in correctly.");
        }
    }

    @FXML
    private void clearInputFields(){
        tf_NewEmpEmail.clear();
        tf_NewEmpPhone.clear();
        tf_NewEmpLastName.clear();
        tf_NewEmpFirstName.clear();
    }
}
