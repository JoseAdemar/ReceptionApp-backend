package com.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "TBL_CUSTOMER")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String socialSecurityNumber;

	private String birthDate;

	@Embedded
	private PhoneNumber phoneNumber;
	
	@Embedded
	private Address address;

	private String email;

}
