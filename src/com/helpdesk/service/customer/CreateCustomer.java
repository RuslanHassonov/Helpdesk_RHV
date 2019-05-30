package com.helpdesk.service.customer;

import com.helpdesk.entity.Address;
import com.helpdesk.entity.Customer;
import static com.helpdesk.service.address.CreateAddress.createNewAddress;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCustomer {
    public static void createNewCustomer(String fName, String lName, String street, int houseNr, int postCode, String city, String phone, String email){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Address address = createNewAddress(street, houseNr, city, postCode); //to be adjusted
        entityManager.persist(address);

        Customer customer = new Customer();
        //customer.setcId(createRandomCustomerId());
        customer.setcFirstName(fName);
        customer.setcLastName(lName);
        customer.setcAddress(address); //to be adjusted
        customer.setcPhoneNumber(phone);
        customer.setcEmail(email);

        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }

    public static void createNewCustomer(){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Address address = createNewAddress(); //to be adjusted
        entityManager.persist(address);

        Customer customer = new Customer();
        //customer.setcId(createRandomCustomerId());
        customer.setcFirstName("Ruslan");
        customer.setcLastName("Hassonov");
        customer.setcAddress(address); //to be adjusted
        customer.setcPhoneNumber("0473/61 19 54");
        customer.setcEmail("ruslan.hasanov1989@gmail.com");

        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
