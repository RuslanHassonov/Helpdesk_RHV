package com.helpdesk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Inheritance
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eId;
    private String eFirstName;
    private String eLastName;
    private String ePhoneNumber;
    private String eEmail;
    @OneToMany(targetEntity = Ticket.class)
    private List eTicketList;
    @OneToMany(targetEntity = TicketLine.class)
    private List eTicketLineList;

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

    public List geteTicketList() {
        return eTicketList;
    }

    public void seteTicketList(List eTicketList) {
        this.eTicketList = eTicketList;
    }

    public List geteTicketLineList() {
        return eTicketLineList;
    }

    public void seteTicketLineList(List eTicketLineList) {
        this.eTicketLineList = eTicketLineList;
    }
}
