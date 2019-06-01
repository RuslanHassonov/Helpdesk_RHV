package com.helpdesk.service.ticket;

import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateTicket {
    public static void createNewTicket(String status, String priority) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Ticket ticket = new Ticket();
        ticket.settStatus(status);
        ticket.settPriority(priority);

        entityManager.persist(ticket);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }


}
