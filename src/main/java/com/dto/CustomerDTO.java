package com.dto;

import javax.persistence.Embedded;

import com.entity.Address;
import com.entity.Customer;
import com.entity.PhoneNumber;

import lombok.Data;

@Data
public class CustomerDTO {

	private Long id;

	private String name;

	private String socialSecurityNumber;

	private String birthDate;

	@Embedded
	private PhoneNumber phoneNumber;

	@Embedded
	private Address address;

	private String email;

	public CustomerDTO(Customer customerRegistration) {
		this.id = customerRegistration.getId();
		this.name = customerRegistration.getName();
		this.socialSecurityNumber = customerRegistration.getSocialSecurityNumber();
		this.birthDate = customerRegistration.getBirthDate();
		this.phoneNumber = customerRegistration.getPhoneNumber();
		this.email = customerRegistration.getEmail();
		this.address = customerRegistration.getAddress();
	}

}
