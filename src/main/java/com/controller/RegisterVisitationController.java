package com.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dto.RegisterVisitationDTO;
import com.service.RegisterVisitationService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api/registerVisitation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterVisitationController {

	private RegisterVisitationService registerVisitationService;

	public RegisterVisitationController(RegisterVisitationService registerVisitationService) {
		this.registerVisitationService = registerVisitationService;
	}

	@POST
	public RegisterVisitationDTO createVisitationDTO(@RequestBody RegisterVisitationDTO dto) {
		return registerVisitationService.persisteDTO(dto);

	}

	@Path("/all")
	@GET
	public List<RegisterVisitationDTO> listVisitaionDTO() {
		return registerVisitationService.listVisitationDTO();
	}

	@Path("/{id}")
	@GET
	public Optional<RegisterVisitationDTO> listVisitationById(@PathParam("id") Long id) {
		return registerVisitationService.findVisitationById(id);

	}
}
