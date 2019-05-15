package com.helpdesk.service.customer;

import com.helpdesk.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindCustomer {
    public static void findExistingCustomer(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        Customer customer = entityManager.find(Customer.class, 1000); //to be adjusted)

        //provide output, perhaps a toString override

    }
}
