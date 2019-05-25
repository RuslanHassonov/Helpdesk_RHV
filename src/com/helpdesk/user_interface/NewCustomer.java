package com.helpdesk.user_interface;

import com.helpdesk.entity.Address;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.helpdesk.service.address.CreateAddress.createNewAddress;
import static com.helpdesk.service.customer.CreateCustomer.createNewCustomer;

public class NewCustomer {

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
    private void cancelButtonPressed(){
        btn_NewCustCancel.cancelButtonProperty();
        Stage stage = (Stage) btn_NewCustCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmButtonPressed(){
        String fName = tf_NewCustFirstName.getText();
        String lName = tf_NewCustLastName.getText();
        Address address = createNewAddress(tf_NewCustStreet.getText(),
                                           Integer.getInteger(tf_NewCustHouseNr.getText()),
                                           tf_NewCustCity.getText(),
                                           Integer.getInteger(tf_NewCustPostCode.getText()));
        String phone = tf_NewCustPhone.getText();
        String email = tf_NewCustEmail.getText();

        createNewCustomer(fName, lName, address, phone, email);
    }



}
