package com.helpdesk.service.employee;

import com.helpdesk.entity.Customer;
import com.helpdesk.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReadEmployeeData {

    public static List<Employee> readEmployeeData(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Select e from Employee e");

        @SuppressWarnings("unchecked")
        List<Employee> list = query.getResultList();

        entityManager.close();
        emFactory.close();

        return list;
    }

}
