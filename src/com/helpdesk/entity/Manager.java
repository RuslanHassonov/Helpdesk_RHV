package com.helpdesk.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MNG")
public class Manager extends Employee {

    public Manager(int eId, String eFirstName, String eLastName, String ePhoneNumber, String eEmail) {
        super(eId, eFirstName, eLastName, ePhoneNumber, eEmail);

    }

    public Manager() {
        super();
    }

}
