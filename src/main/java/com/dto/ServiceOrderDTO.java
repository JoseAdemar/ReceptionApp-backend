package com.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.entity.ClinicalProcedure;
import com.entity.Customer;

import lombok.Data;

@Data
public class ServiceOrderDTO {

	private Long id;
	
	private LocalDateTime localDateTime;

	private String laboratory;

	private String description;

	private List<ClinicalProcedure> clinicalProcedure = new ArrayList<ClinicalProcedure>();

	private Customer customer;

	

}
