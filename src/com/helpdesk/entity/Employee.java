package com.helpdesk.entity;

public class Employee {
    private int eId;
    private String eFirstName;
    private String eLastName;
    private String ePhoneNumber;
    private String eEmail;

    public Employee(int eId, String eFirstName, String eLastName, String ePhoneNumber, String eEmail) {
        this.eId = eId;
        this.eFirstName = eFirstName;
        this.eLastName = eLastName;
        this.ePhoneNumber = ePhoneNumber;
        this.eEmail = eEmail;
    }

    public Employee() {
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteFirstName() {
        return eFirstName;
    }

    public void seteFirstName(String eFirstName) {
        this.eFirstName = eFirstName;
    }

    public String geteLastName() {
        return eLastName;
    }

    public void seteLastName(String eLastName) {
        this.eLastName = eLastName;
    }

    public String getePhoneNumber() {
        return ePhoneNumber;
    }

    public void setePhoneNumber(String ePhoneNumber) {
        this.ePhoneNumber = ePhoneNumber;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }
}
