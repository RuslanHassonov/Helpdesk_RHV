package com.helpdesk.user_interface.windows;

import com.helpdesk.entity.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class EmpTicketListDialog {

    @FXML
    private Label lbl_EmpFullName;

    @FXML
    private void initialize(){}

    public void initData(Employee employee){
        //lbl_EmpFullName.setText(employee.geteFirstName() + " " + employee.geteLastName());
        lbl_EmpFullName.setText("Test test test");
    }
}
