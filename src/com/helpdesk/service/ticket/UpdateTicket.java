package com.helpdesk.service.ticket;

import com.helpdesk.entity.Ticket;
import com.helpdesk.entity.TicketLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@SuppressWarnings("Duplicates")
public class UpdateTicket {
     public static void updateExistingTicket(int tId, List<TicketLine> ticketLine, String status) {
         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
         EntityManager entityManagery = entityManagerFactory.createEntityManager();
         entityManagery.getTransaction().begin();

         Ticket ticket = entityManagery.find(Ticket.class, tId);

         ticket.settStatus(status);
         ticket.settDetail(ticketLine);

         entityManagery.getTransaction().commit();
         entityManagery.close();
         entityManagerFactory.close();
     }
}
