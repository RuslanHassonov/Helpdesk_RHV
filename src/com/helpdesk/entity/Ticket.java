package com.helpdesk.entity;

public class Ticket {
    private int tId;
    private String tStatus;
    private String tPriority;
    private TicketLine tDetail;

    public Ticket(int tId, String tStatus, String tPriority, TicketLine tDetail) {
        this.tId = tId;
        this.tStatus = tStatus;
        this.tPriority = tPriority;
        this.tDetail = tDetail;
    }

    public Ticket() {
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

    public TicketLine gettDetail() {
        return tDetail;
    }

    public void settDetail(TicketLine tDetail) {
        this.tDetail = tDetail;
    }
}
