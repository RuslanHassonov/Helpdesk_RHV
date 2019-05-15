package com.helpdesk.service.employee;

import com.helpdesk.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmployee {
    public static void findExistingEmployee(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 5000); //to be adjusted

        //output to be provided
    }
}
