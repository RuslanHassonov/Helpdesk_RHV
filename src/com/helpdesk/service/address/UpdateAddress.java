package com.helpdesk.service.address;

import com.helpdesk.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateAddress {
    public static void updateExistingAddress() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, 1212); //to be adjusted
        address.setaStreet("  ");
        address.setaHouseNumber(123);
        address.setaCity("  ");
        address.setaPostalCode(4567);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();
    }
}
