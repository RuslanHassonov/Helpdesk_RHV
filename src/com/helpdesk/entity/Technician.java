package com.helpdesk.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TCH")
public class Technician extends Employee {

    public Technician(int eId, String eFirstName, String eLastName, String ePhoneNumber, String eEmail) {
        super(eId, eFirstName, eLastName, ePhoneNumber, eEmail);
    }

    public Technician() {
        super();
    }

}
