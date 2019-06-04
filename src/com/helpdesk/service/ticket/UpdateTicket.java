package com.helpdesk.service.ticket;

import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("Duplicates")
public class UpdateTicket {
     public static void updateExistingTicket(int tId) {
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
         EntityManager entityManagery = entityManagerFactory.createEntityManager();
         entityManagery.getTransaction().begin();

         Ticket ticket = entityManagery.find(Ticket.class, tId);

         ticket.settStatus("WIP");

         entityManagery.getTransaction().commit();
         entityManagery.close();
         entityManagerFactory.close();
     }
}
