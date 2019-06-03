package com.helpdesk.entity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(targetEntity = Ticket.class)
    private List cTicketList;

    public Customer(int cId, String cFirstName, String cLastName, String cPhoneNumber, String cEmail) {
        super();
        this.cId = cId;
        this.cFirstName = cFirstName;
        this.cLastName = cLastName;
        this.cPhoneNumber = cPhoneNumber;
        this.cEmail = cEmail;
    }

    public Customer() {
        super();
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

    public List getcTicketList() {
        return cTicketList;
    }

    public void setcTicketList(List cTicketList) {
        this.cTicketList = cTicketList;
    }
}
