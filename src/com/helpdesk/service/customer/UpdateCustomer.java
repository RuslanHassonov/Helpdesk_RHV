package com.helpdesk.service.customer;

import com.helpdesk.entity.Customer;
import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UpdateCustomer {
    public static void updateExistingCustomer(int cId, String fName, String lName, String phoneNr, String email) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, cId);
        customer.setcFirstName(fName);
        customer.setcLastName(lName);
        customer.setcPhoneNumber(phoneNr);
        customer.setcEmail(email);
        //customer.setcAddress(address);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();
    }

    public static void updateCustomerTicketList(int cId, List<Ticket> ticketList){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, cId);

        customer.setcTicketList(ticketList);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();
    }
}
