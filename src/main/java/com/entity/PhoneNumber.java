package com.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class PhoneNumber {

	private String cellPhone;
	private String telePhone;
}
