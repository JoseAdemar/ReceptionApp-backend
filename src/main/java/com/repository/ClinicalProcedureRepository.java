package com.repository;

import javax.enterprise.context.ApplicationScoped;

import com.entity.ClinicalProcedure;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class ClinicalProcedureRepository implements PanacheRepositoryBase<ClinicalProcedure, Long> {

}
