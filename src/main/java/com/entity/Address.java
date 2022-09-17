package com.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {

	private String country;
	private String city;
	private String zipCode;
	private String road;
	private String district;

}
