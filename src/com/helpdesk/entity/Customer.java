package com.helpdesk.entity;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String cFirstName;
    private String cLastName;
    private String cPhoneNumber;
    private String cEmail;
    @ManyToOne
    private Address cAddress;

    public Customer(int cId, String cFirstName, String cLastName, Address cAddress, String cPhoneNumber, String cEmail) {
        this.cId = cId;
        this.cFirstName = cFirstName;
        this.cLastName = cLastName;
        this.cAddress = cAddress;
        this.cPhoneNumber = cPhoneNumber;
        this.cEmail = cEmail;
    }

    public Customer() {
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcFirstName() {
        return cFirstName;
    }

    public void setcFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getcLastName() {
        return cLastName;
    }

    public void setcLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public Address getcAddress() {
        return cAddress;
    }

    public void setcAddress(Address cAddress) {
        this.cAddress = cAddress;
    }

    public String getcPhoneNumber() {
        return cPhoneNumber;
    }

    public void setcPhoneNumber(String cPhoneNumber) {
        this.cPhoneNumber = cPhoneNumber;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }
}
