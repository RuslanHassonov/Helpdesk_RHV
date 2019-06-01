package com.helpdesk.service.address;

import com.helpdesk.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReadAddressData {

    public static List<Customer> readAddressData() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Select a from Address a");

        @SuppressWarnings("unchecked")
        List<Customer> list = query.getResultList();

        entityManager.close();
        emFactory.close();

        return list;
    }

}
