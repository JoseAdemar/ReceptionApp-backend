package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "TBL_REGISTER_VISITOR")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RegisterVisitor {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String birthDate;

	private String phone;

	private String email;

}
