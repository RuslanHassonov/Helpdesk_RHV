package com.helpdesk.service.customer;

import com.helpdesk.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReadCustomerData {

    public static List<Customer> readCustomerData(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Select c.cFirstName, c.cLastName, c.cAddress, c.cEmail, c.cPhoneNumber, c.cId from Customer c");

        List<Customer> list = query.getResultList();

        entityManager.close();
        emFactory.close();

        return list;
    }

}
