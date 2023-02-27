package com.crm.dao;

import com.crm.models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*
* Added to DAO implementations;
* since it's a subclass and inherits the annotation @Component, that means
  your DAO impl. will be available for auto-scanning or component-scanning.
* Will translate any JDBC exceptions to unchecked exceptions.
*
* i.e. Is specific for code that is going to talk to a backend datasource or backend repository.
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // Get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        //currentSession.get(Customer.class, 1);
        Query<Customer> myQuery = currentSession.createQuery("from Customer", Customer.class);

        return myQuery.getResultList();
    }
}
