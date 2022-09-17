package com.mapper;

import com.dto.ServiceOrderDTO;
import com.entity.ServiceOrder;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ServiceOrderMapper {

	@Mapping(target = "id", source = "id")
	@Mapping(target = "localDateTime", source = "localDateTime")
	@Mapping(target = "laboratory", source = "laboratory")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "clinicalProcedure", source = "clinicalProcedure")
	@Mapping(target = "customer", source = "customer")
	public ServiceOrderDTO dtoTo(ServiceOrder entity);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "localDateTime", source = "localDateTime")
	@Mapping(target = "laboratory", source = "laboratory")
	@Mapping(target = "description", source = "description")
	@Mapping(target = "clinicalProcedure", source = "clinicalProcedure")
	@Mapping(target = "customer", source = "customer")
	public ServiceOrder entityTo(ServiceOrderDTO dto);

	@Mapping(target = "id", source = "id")
	public void merge(ServiceOrderDTO dto, @MappingTarget ServiceOrder entity);
}
