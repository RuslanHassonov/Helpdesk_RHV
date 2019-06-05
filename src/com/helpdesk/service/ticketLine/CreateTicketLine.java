package com.helpdesk.service.ticketLine;

import com.helpdesk.entity.Ticket;
import com.helpdesk.entity.TicketLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.helpdesk.service.ticket.FindTicket.findExistingTicket;
import static com.helpdesk.service.ticket.UpdateTicket.updateExistingTicket;

public class CreateTicketLine {
    public static void createNewTicketLine(int tId, String tDescription, boolean statusDone) throws Exception {

        Ticket ticket = findExistingTicket(tId);

        if (ticket == null) {
            throw new IOException("Ticket not in DB, please create ticket first.");
        } else {

            ArrayList<TicketLine> ticketDetails = new ArrayList<TicketLine>();
            Date date = new Date();
            long time = date.getTime();

            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
            EntityManager entityManager = emFactory.createEntityManager();
            DateFormat df = new SimpleDateFormat("dd/MM/yyy");
            entityManager.getTransaction().begin();

            TicketLine ticketLine = new TicketLine();
            ticketLine.setTlDescription(tDescription);
            ticketLine.setTlDate(df.format(date));
            ticketLine.setTlTimestampFrom( new Timestamp(time).toString());

            if (statusDone){
                ticketLine.setTlTimestampTo(new Timestamp(time).toString());
                ticket.settStatus("Closed");
            } else {
                ticket.settStatus("WIP");
            }

            ticketDetails.add(ticketLine);
            ticket.settDetail(ticketDetails);

            entityManager.persist(ticketLine);
            entityManager.getTransaction().commit();

            updateExistingTicket(ticket.gettId(), ticketDetails, ticket.gettStatus());

            entityManager.close();
            emFactory.close();
        }
    }

}
