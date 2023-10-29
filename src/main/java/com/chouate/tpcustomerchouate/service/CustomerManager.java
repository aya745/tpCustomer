/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chouate.tpcustomerchouate.service;

import com.chouate.tpcustomerchouate.entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Classe pour gérer la persistance des Customers.
 * <p>
 * Cette classe fournit des méthodes pour effectuer des opérations CRUD sur des
 * instances de Customer.
 * </p>
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();

    }

    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
}
