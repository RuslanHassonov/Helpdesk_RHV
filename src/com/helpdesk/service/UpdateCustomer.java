package com.helpdesk.service;

import com.helpdesk.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateCustomer {
    public static void updateNewCustomer(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, 1111); //to adjust

        entityManager.close();
        emFactory.close();
    }
}
