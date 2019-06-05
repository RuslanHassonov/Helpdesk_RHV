package com.helpdesk.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tId;
    private String tStatus;
    private String tPriority;
    private String creationDate;

    @OneToMany(targetEntity = TicketLine.class, cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    private List<TicketLine> tDetail;

    @OneToOne
    private Address tAddress;

    public Ticket(int tId, String tStatus, String tPriority) {
        super();
        this.tId = tId;
        this.tStatus = tStatus;
        this.tPriority = tPriority;
        this.tDetail = new ArrayList<TicketLine>();
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
        this.tDetail.addAll(tDetail);
    }

    public Address gettAddress() {
        return tAddress;
    }

    public void settAddress(Address tAddress) {
        this.tAddress = tAddress;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return String.format("Ticket %d : \n" +
                " - Priority:      %s \n" +
                " - Creation Date: %s \n" +
                " - Status:        %s \n", this.gettId(), this.gettPriority(),
                this.getCreationDate(), this.gettStatus());
    }
}
