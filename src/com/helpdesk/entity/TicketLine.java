package com.helpdesk.entity;

public class TicketLine {
    private int tlId;
    private String tlDescription;
    private String tlDate;
    private String tlTimestampFrom;
    private String tlTimestampTo;

    public TicketLine(int tlId, String tlDescription, String tlDate, String tlTimestampFrom, String tlTimestampTo) {
        this.tlId = tlId;
        this.tlDescription = tlDescription;
        this.tlDate = tlDate;
        this.tlTimestampFrom = tlTimestampFrom;
        this.tlTimestampTo = tlTimestampTo;
    }

    public TicketLine() {
    }

    public int getTlId() {
        return tlId;
    }

    public void setTlId(int tlId) {
        this.tlId = tlId;
    }

    public String getTlDescription() {
        return tlDescription;
    }

    public void setTlDescription(String tlDescription) {
        this.tlDescription = tlDescription;
    }

    public String getTlDate() {
        return tlDate;
    }

    public void setTlDate(String tlDate) {
        this.tlDate = tlDate;
    }

    public String getTlTimestampFrom() {
        return tlTimestampFrom;
    }

    public void setTlTimestampFrom(String tlTimestampFrom) {
        this.tlTimestampFrom = tlTimestampFrom;
    }

    public String getTlTimestampTo() {
        return tlTimestampTo;
    }

    public void setTlTimestampTo(String tlTimestampTo) {
        this.tlTimestampTo = tlTimestampTo;
    }
}
