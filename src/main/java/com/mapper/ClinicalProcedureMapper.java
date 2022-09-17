package com.mapper;

import com.dto.ClinicalProcedureDTO;
import com.entity.ClinicalProcedure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClinicalProcedureMapper extends GenericMapper<ClinicalProcedureDTO, ClinicalProcedure> {

	@Mapping(target = "id", source = "id",ignore = false)
	@Mapping(target = "clinicalProcedure", source = "clinicalProcedure")
	@Mapping(target = "serviceOrder", source = "serviceOrder")
	public ClinicalProcedureDTO dtoTo(ClinicalProcedure entity);

	@Mapping(target = "id", source = "id",ignore = false)
	@Mapping(target = "clinicalProcedure", source = "clinicalProcedure")
	@Mapping(target = "serviceOrder", source = "serviceOrder")
	public ClinicalProcedure entityTo(ClinicalProcedureDTO dto);

	@Mapping(target = "id",source = "id",ignore = false)
	public void merge(ClinicalProcedureDTO dto, @MappingTarget ClinicalProcedure entity);

}
