package com.crm.dao;

import com.crm.models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
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

    @Override
    public void saveCustomer(Customer customer) {
        // Get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        /*
        if (customer.getId() != 0)
            currentSession.update(customer);
        else
            currentSession.save(customer);
         */

        // Hibernate will do the magic :)
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        System.out.println("\n=======>> Inside com.crm.dao.CustomerDAOImpl.getCustomer");

        // Get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        // Get the customer from the session
        return currentSession.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();

        System.out.println("\n\n\n\n=======>> Executing deleteCustomer!!\n\n\n\n");
    }
}
