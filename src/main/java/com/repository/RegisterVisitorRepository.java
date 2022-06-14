package com.repository;

import javax.enterprise.context.ApplicationScoped;

import com.entity.RegisterVisitor;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class RegisterVisitorRepository implements PanacheRepositoryBase<RegisterVisitor, Long> {

}
