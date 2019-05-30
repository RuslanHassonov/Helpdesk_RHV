package com.helpdesk.service.customer;

import com.helpdesk.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateCustomer {
    public static void updateExistingCustomer() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, 1111); //to adjust
        customer.setcFirstName("  ");
        customer.setcLastName("  ");
        customer.setcPhoneNumber("  ");
        customer.setcEmail("  ");
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();
    }
}
