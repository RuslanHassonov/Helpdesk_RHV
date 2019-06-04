package com.helpdesk.service.ticket;

import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("Duplicates")
public class DeleteTicket {
    public static void deleteExistingTicket(int tId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Ticket ticket = entityManager.find(Ticket.class, tId);
        entityManager.remove(ticket);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

}
