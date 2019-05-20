package com.helpdesk.user_interface;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
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
    private TextField tf_CustNumber;

    @FXML
    private void minimizeButtonPressed(){
        Stage stage =(Stage) btn_Minimize.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeButtonPressed(){
        Platform.exit();
    }

}
