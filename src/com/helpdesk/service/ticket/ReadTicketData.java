package com.helpdesk.service.ticket;

import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReadTicketData {

    public static List<Ticket> readTicketData() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Select t from Ticket t");

        @SuppressWarnings("unchecked")
        List<Ticket> list = query.getResultList();

        entityManager.close();
        emFactory.close();

        return list;
    }

}
