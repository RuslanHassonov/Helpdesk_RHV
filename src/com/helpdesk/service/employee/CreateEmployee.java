package com.helpdesk.service.employee;

import com.helpdesk.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static com.helpdesk.service.Generator.createRandomEmployeeId;

public class CreateEmployee {
    public static void createNewEmployee(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employee = new Employee();
        employee.seteId(createRandomEmployeeId());
        employee.seteFirstName("  ");
        employee.seteLastName("  ");
        employee.setePhoneNumber("  ");
        employee.seteEmail("  ");

        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
