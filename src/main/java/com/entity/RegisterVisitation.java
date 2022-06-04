package com.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RegisterVisitation {

	 @Id
	 @EqualsAndHashCode.Include
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private RegisterVisitor registerVisitor;
	 
	 private LocalDateTime checkinTime;
	 
	 private LocalDateTime checkoutTime;
	 
	 private String department;
	 
	 private String reasonForVisit;

	 
}
