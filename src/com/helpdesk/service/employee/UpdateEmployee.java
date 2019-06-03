package com.helpdesk.service.employee;

import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UpdateEmployee {
    public static void updateExistingEmployee() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, 5555); //to adjust

        entityManager.close();
        emFactory.close();
    }
    public static void updateEmployeeTicketList(int eId, List<Ticket> ticketList){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, eId);

        employee.seteTicketList(ticketList);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();
    }

}
