package com.helpdesk.service.address;

import com.helpdesk.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateAddress {
    public static Address createNewAddress(String street, int houseNr, String city, int postCode){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Address address = new Address();
        address.setaStreet("  ");
        address.setaHouseNumber(10);
        address.setaCity("  ");
        address.setaPostalCode(1000);
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();

        return address;

    }
}
