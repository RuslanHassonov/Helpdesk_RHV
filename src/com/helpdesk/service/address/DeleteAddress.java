package com.helpdesk.service.address;

import com.helpdesk.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteAddress {
    @SuppressWarnings("Duplicates")
    public static void deleteExistingAddress(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, 1234); //to be adjusted
        entityManager.remove(address);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();
    }

}
