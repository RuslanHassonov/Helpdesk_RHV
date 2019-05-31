package com.helpdesk.service.employee;

import com.helpdesk.entity.Dispatcher;
import com.helpdesk.entity.Employee;
import com.helpdesk.entity.Manager;
import com.helpdesk.entity.Technician;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static com.helpdesk.service.Generator.createRandomEmployeeId;

public class CreateEmployee {
    public static void createNewEmployee(String fName, String lName, String phoneNr, String email, String role) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        switch (role) {
            case "Manager":
                Manager manager = new Manager();
                manager.seteFirstName(fName);
                manager.seteLastName(lName);
                manager.setePhoneNumber(phoneNr);
                manager.seteEmail(email);
                entityManager.persist(manager);
                entityManager.getTransaction().commit();
                break;

            case "Technician":
                Technician technician = new Technician();
                technician.seteFirstName(fName);
                technician.seteLastName(lName);
                technician.setePhoneNumber(phoneNr);
                technician.seteEmail(email);
                entityManager.persist(technician);
                entityManager.getTransaction().commit();
                break;

            case "Dispatcher":
                Dispatcher dispatcher = new Dispatcher();
                dispatcher.seteFirstName(fName);
                dispatcher.seteLastName(lName);
                dispatcher.setePhoneNumber(phoneNr);
                dispatcher.seteEmail(email);
                entityManager.persist(dispatcher);
                entityManager.getTransaction().commit();
                break;

            default:
                Employee employee = new Employee();
                employee.seteFirstName(fName);
                employee.seteLastName(lName);
                employee.setePhoneNumber(phoneNr);
                employee.seteEmail(email);
                entityManager.persist(employee);
                entityManager.getTransaction().commit();
                break;
        }

        entityManager.close();
        emFactory.close();
    }


    // Test method

    /*public static void createNewEmployee() {
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
    }*/
}
