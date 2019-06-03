package com.helpdesk.service.employee;

import com.helpdesk.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FindEmployee {
    public static Employee findExistingEmployee(int empId) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        return entityManager.find(Employee.class, empId);
    }

    public static List<Employee> filterEmployeeByTicket(int tId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("Select et.Employee_EID from employee_ticket et where eTicketList_TID = ?", String.valueOf(tId));
        List<Employee> list = query.getResultList();

        return list;
    }
}
