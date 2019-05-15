package com.helpdesk.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DSP")
public class Dispatcher extends Employee {

    public Dispatcher(int eId, String eFirstName, String eLastName, String ePhoneNumber, String eEmail) {
        super(eId, eFirstName, eLastName, ePhoneNumber, eEmail);
    }

    public Dispatcher() {
        super();
    }
}
