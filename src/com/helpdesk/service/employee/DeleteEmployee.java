package com.helpdesk.service.employee;

import com.helpdesk.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteEmployee {
    @SuppressWarnings("Duplicates")
    public static void deleteExistingEmployee(int eId) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, eId);
        entityManager.remove(employee);
        entityManager.getTransaction().commit();

        entityManager.close();
        emFactory.close();

    }
}
