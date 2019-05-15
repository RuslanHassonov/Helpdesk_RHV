package com.helpdesk.service.Address;

import com.helpdesk.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAddress {
    public static void findExistingAddress(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        Address address = entityManager.find(Address.class, 1234); //to be adjusted

        //output to be provided
    }
}
