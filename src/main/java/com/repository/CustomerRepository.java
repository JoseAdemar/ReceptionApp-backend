package com.repository;

import javax.enterprise.context.ApplicationScoped;

import com.entity.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CustomerRepository implements PanacheRepositoryBase<Customer, Long> {

}
