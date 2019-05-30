package com.helpdesk.service.customer;

import com.helpdesk.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindCustomer {
    public static Customer findExistingCustomer(int custNumber) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        Customer customer = entityManager.find(Customer.class, custNumber); //to be adjusted)

        return customer;
        //provide output, perhaps a toString override

    }
}
