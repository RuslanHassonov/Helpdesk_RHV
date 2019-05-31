package com.helpdesk.user_interface.windows;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

import static com.helpdesk.service.customer.CreateCustomer.createNewCustomer;

public class NewCustomerWin {

    @FXML
    private TextField tf_NewCustFirstName;

    @FXML
    private TextField tf_NewCustLastName;

    @FXML
    private TextField tf_NewCustPostCode;

    @FXML
    private TextField tf_NewCustStreet;

    @FXML
    private TextField tf_NewCustHouseNr;

    @FXML
    private TextField tf_NewCustPhone;

    @FXML
    private TextField tf_NewCustCity;

    @FXML
    private TextField tf_NewCustEmail;

    @FXML
    private Button btn_NewCustConfirm;

    @FXML
    private Button btn_NewCustCancel;


    @FXML
    private void cancelButtonPressed() {
        btn_NewCustCancel.cancelButtonProperty();
        Stage stage = (Stage) btn_NewCustCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmButtonPressed() {

        try {
            validateTextField();
            String fName = tf_NewCustFirstName.getText();
            String lName = tf_NewCustLastName.getText();
            String street = tf_NewCustStreet.getText();
            int houseNr = Integer.parseInt(tf_NewCustHouseNr.getText());
            int postCode = Integer.parseInt(tf_NewCustPostCode.getText());
            String city = tf_NewCustCity.getText();
            String phone = tf_NewCustPhone.getText();
            String email = tf_NewCustEmail.getText();

            createNewCustomer(fName, lName, street, houseNr, postCode, city, phone, email);
            //createNewCustomer();

            JOptionPane.showMessageDialog(new JFrame(), "New customer succesfully created");
            clearInputFields();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void validateTextField() {
        if ((tf_NewCustFirstName.getText() == null) ||
                (tf_NewCustLastName.getText() == null) ||
                (tf_NewCustStreet.getText() == null) ||
                (tf_NewCustHouseNr.getText() == null) ||
                (tf_NewCustPostCode.getText() == null) ||
                (tf_NewCustCity.getText() == null) ||
                (tf_NewCustPhone.getText() == null) ||
                (tf_NewCustEmail.getText() == null)) {
            throw new IllegalArgumentException("All fields must be filled in correctly.");
        }
    }

    @FXML
    private void clearInputFields(){
        tf_NewCustEmail.clear();
        tf_NewCustPhone.clear();
        tf_NewCustCity.clear();
        tf_NewCustPostCode.clear();
        tf_NewCustHouseNr.clear();
        tf_NewCustStreet.clear();
        tf_NewCustLastName.clear();
        tf_NewCustFirstName.clear();
    }


}
