package com.helpdesk.entity;

import javax.persistence.*;

@Entity
@Table
public class Address {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int aId;
    private String aStreet;
    private String aCity;
    private int aHouseNumber;
    private int aPostalCode;

    public Address(int aId, String aStreet, String aCity, int aHouseNumber, int aPostalCode) {
        super();
        this.aId = aId;
        this.aStreet = aStreet;
        this.aCity = aCity;
        this.aHouseNumber = aHouseNumber;
        this.aPostalCode = aPostalCode;
    }

    public Address() {
        super();
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaStreet() {
        return aStreet;
    }

    public void setaStreet(String aStreet) {
        this.aStreet = aStreet;
    }

    public String getaCity() {
        return aCity;
    }

    public void setaCity(String aCity) {
        this.aCity = aCity;
    }

    public int getaHouseNumber() {
        return aHouseNumber;
    }

    public void setaHouseNumber(int aHouseNumber) {
        this.aHouseNumber = aHouseNumber;
    }

    public int getaPostalCode() {
        return aPostalCode;
    }

    public void setaPostalCode(int aPostalCode) {
        this.aPostalCode = aPostalCode;
    }

    @Override
    public String toString() {
        return String.format("%s %d, %d %s", aStreet, aHouseNumber, aPostalCode, aCity.toUpperCase());
    }
}
