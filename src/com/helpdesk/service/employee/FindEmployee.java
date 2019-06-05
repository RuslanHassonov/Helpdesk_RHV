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

    public static Employee filterEmployeeByTicketId(int tId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager em = emf.createEntityManager();
        Employee employee;

        Query query = em.createNativeQuery("Select e.*\n" +
                                                    "from employee e inner join employee_ticket et on et.Employee_EID = e.EID\n" +
                                                    "where et.eTicketList_TID = ?", Employee.class);
        query.setParameter(1, tId);
        List<Employee> list = query.getResultList();

        if (list.get(0) != null) {
               employee = findExistingEmployee(list.get(0).geteId());
               return employee;
        } else {
            return null;
        }
    }
}
