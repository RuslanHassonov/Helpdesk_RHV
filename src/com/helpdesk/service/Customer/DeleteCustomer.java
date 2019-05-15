package com.helpdesk.service.Customer;

import com.helpdesk.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteCustomer {
    public static void deleteExistingCustomer(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, 1200); //to be adjusted
        entityManager.remove(customer);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();
    }
}
