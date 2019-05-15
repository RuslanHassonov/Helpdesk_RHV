package com.helpdesk.service.Customer;

import com.helpdesk.entity.Address;
import com.helpdesk.entity.Customer;
import static com.helpdesk.service.Generator.createRandomCustomerId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCustomer {
    public static void createNewCustomer(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Address address = new Address(); //to be adjusted
        entityManager.persist(address);

        Customer customer = new Customer();
        customer.setcId(createRandomCustomerId());
        customer.setcFirstName("  ");
        customer.setcLastName("  ");
        customer.setcAddress(address); //to be adjusted
        customer.setcPhoneNumber("  ");
        customer.setcEmail("  ");

        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
