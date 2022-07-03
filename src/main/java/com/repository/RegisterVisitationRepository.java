package com.repository;

import javax.enterprise.context.ApplicationScoped;

import com.entity.RegisterVisitation;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class RegisterVisitationRepository implements PanacheRepositoryBase<RegisterVisitation, Long>{

	
}
