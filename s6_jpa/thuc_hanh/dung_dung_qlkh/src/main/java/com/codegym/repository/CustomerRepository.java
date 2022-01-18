package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer as c", Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer as c where c.id = :id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Modifying
    @Transactional
    @Override
    public void edit(Customer customer) {
        System.out.println("test");
        Query query = entityManager
                .createQuery("UPDATE Customer as c SET c.firstName = :firstName, c.lastName = :lastName WHERE c.id = :id");
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());
        query.setParameter("id",customer.getId());
        query.executeUpdate();
    }

    @Override
    public void delete(Long id) {
       Customer customer = findById(id);
       if (customer != null){
           entityManager.remove(customer);
       }
    }
}
