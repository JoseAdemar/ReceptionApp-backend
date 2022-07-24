package com.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.RegisterVisitationDTO;
import com.exceptions.ReturnExceptionMessage;
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

	@PUT
	@Path("/update")
	public Response uPDateRegisterVisitation(@RequestBody RegisterVisitationDTO dto) {

		try {
			RegisterVisitationDTO visitationDTO = registerVisitationService.uPDateRegisterVisitation(dto);

			return Response.status(Status.OK).entity(visitationDTO).build();
		} catch (ReturnExceptionMessage ex) {
			return Response.status(Status.NOT_FOUND).entity(ex).build();
		}

	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteRegisterVisitation(@PathParam("id") Long id) {

		try {
			registerVisitationService.deleteRegisterVisitationById(id);
			return Response.status(Status.NO_CONTENT).build();
		} catch (NotFoundException ex) {
			return Response.status(Status.NOT_FOUND).entity(ex).build();
		}
	}
}
