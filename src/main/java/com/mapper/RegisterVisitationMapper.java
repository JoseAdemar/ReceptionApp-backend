package com.mapper;

import com.dto.RegisterVisitationDTO;
import com.entity.RegisterVisitation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface RegisterVisitationMapper extends GenericMapper<RegisterVisitationDTO, RegisterVisitation> {

	
	@Mapping(target = "id", source = "id")
	@Mapping(target = "checkinTime", source = "checkinTime")
	@Mapping(target = "checkoutTime", source = "checkoutTime")
	@Mapping(target = "department", source = "department")
	@Mapping(target = "reasonForVisit", source = "reasonForVisit")
	@Mapping(target = "registerVisitor", source = "registerVisitor")
	public RegisterVisitationDTO toDto(RegisterVisitation registerVisitation);
	

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "checkinTime", source = "checkinTime")
	@Mapping(target = "checkoutTime", source = "checkoutTime")
	@Mapping(target = "department", source = "department")
	@Mapping(target = "reasonForVisit", source = "reasonForVisit")
	@Mapping(target = "registerVisitor", source = "registerVisitor")
	public RegisterVisitation toEntity(RegisterVisitationDTO visitationDTO);

}
