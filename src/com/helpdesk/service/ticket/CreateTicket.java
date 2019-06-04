package com.helpdesk.service.ticket;

import com.helpdesk.entity.Customer;
import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.helpdesk.service.customer.FindCustomer.findExistingCustomer;
import static com.helpdesk.service.customer.UpdateCustomer.updateCustomerTicketList;
import static com.helpdesk.service.employee.FindEmployee.findExistingEmployee;
import static com.helpdesk.service.employee.UpdateEmployee.updateEmployeeTicketList;

public class CreateTicket {
    public static void createNewTicket(int custId, String status, String priority, int empId) throws IOException {

        Customer customer = findExistingCustomer(custId);
        Employee employee = findExistingEmployee(empId);

        if (customer == null) {
            throw new IOException("Customer not in DB, please register customer first.");
        } else if (employee == null) {
            throw new IOException("Employee not in DB, please register employee first.");
        } else {

            ArrayList<Ticket> custTicketList = new ArrayList<Ticket>();
            ArrayList<Ticket> empTicketList = new ArrayList<Ticket>();

            EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
            EntityManager entityManager = emFactory.createEntityManager();
            DateFormat df = new SimpleDateFormat("dd/MM/yyy");
            entityManager.getTransaction().begin();

            Ticket ticket = new Ticket();
            ticket.settStatus(status);
            ticket.settPriority(priority);
            ticket.setCreationDate(df.format(new Date()));
            ticket.settAddress(customer.getcAddress());

            custTicketList.add(ticket);
            customer.setcTicketList(custTicketList);
            empTicketList.add(ticket);
            employee.seteTicketList(empTicketList);

            entityManager.persist(ticket);
            entityManager.getTransaction().commit();
            updateCustomerTicketList(customer.getcId(), custTicketList);
            updateEmployeeTicketList(employee.geteId(), empTicketList);

            entityManager.close();
            emFactory.close();
        }
    }

}
