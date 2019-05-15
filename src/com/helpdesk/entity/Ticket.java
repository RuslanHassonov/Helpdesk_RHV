package com.helpdesk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tId;
    private String tStatus;
    private String tPriority;

    @OneToMany(targetEntity = TicketLine.class)
    private List tDetail;

    @OneToOne
    private Address tAddress;

    public Ticket(int tId, String tStatus, String tPriority) {
        super();
        this.tId = tId;
        this.tStatus = tStatus;
        this.tPriority = tPriority;
    }

    public Ticket() {
        super();
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettStatus() {
        return tStatus;
    }

    public void settStatus(String tStatus) {
        this.tStatus = tStatus;
    }

    public String gettPriority() {
        return tPriority;
    }

    public void settPriority(String tPriority) {
        this.tPriority = tPriority;
    }

    public List gettDetail() {
        return tDetail;
    }

    public void settDetail(List tDetail) {
        this.tDetail = tDetail;
    }

    public Address gettAddress() {
        return tAddress;
    }

    public void settAddress(Address tAddress) {
        this.tAddress = tAddress;
    }
}
