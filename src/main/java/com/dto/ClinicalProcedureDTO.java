package com.dto;

import com.entity.ServiceOrder;

import lombok.Data;

@Data
public class ClinicalProcedureDTO {

	private Long id;

	private String clinicalProcedure;

	private ServiceOrder serviceOrder;

}
