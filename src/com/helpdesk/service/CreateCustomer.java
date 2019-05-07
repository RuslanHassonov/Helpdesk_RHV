package com.helpdesk.service;

import com.helpdesk.entity.Address;
import com.helpdesk.entity.Customer;
import static com.helpdesk.service.Randomizer.createRandomCustomerId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCustomer {
    public static void createNewCustomer(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Customer customer = new Customer();
        customer.setcId(createRandomCustomerId());
        customer.setcFirstName("  ");
        customer.setcLastName("  ");
        customer.setcAddress("  ");
        customer.setcPhoneNumber("  ");
        customer.setcEmail("  ");

        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
