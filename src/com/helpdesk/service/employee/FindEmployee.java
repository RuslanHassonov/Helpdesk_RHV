package com.helpdesk.service.employee;

import com.helpdesk.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmployee {
    public static Employee findExistingEmployee(int empId) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        return entityManager.find(Employee.class, empId);
    }
}
