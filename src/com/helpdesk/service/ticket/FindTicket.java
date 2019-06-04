package com.helpdesk.service.ticket;

import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindTicket {
    public static Ticket findExistingTicket(int tId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        return em.find(Ticket.class, tId);

    }
}
