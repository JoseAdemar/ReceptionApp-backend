package com.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.ClinicalProcedureDTO;
import com.exceptions.ReturnExceptionMessage;
import com.service.ClinicalProcedureService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api/procedure")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClinicalProcedureController {

	private ClinicalProcedureService service;

	public ClinicalProcedureController(ClinicalProcedureService service) {
		this.service = service;
	}

	@POST
	@Path("/save")
	public Response clinicalProcedureRegistration(@RequestBody ClinicalProcedureDTO procedureDTO) {

		service.persisteClinicalProcedure(procedureDTO);
		return Response.status(Status.CREATED).entity(procedureDTO).build();
	}

	@GET
	@Path("/{id}")
	public Response listClinicalProcedureById(@PathParam("id") Long id) {
		ClinicalProcedureDTO dto = service.listClinicalProcedureById(id);

		return Response.status(Status.CREATED).entity(dto).build();
	}

	@GET
	@Path("/list")
	public Response listAllClinicalProcedure() {
		List<ClinicalProcedureDTO> dto = service.listClinicalProcedure();

		return Response.status(Status.CREATED).entity(dto).build();
	}

	@PUT
	@Path("/update")
	public Response updateClinicalProcedure(@RequestBody ClinicalProcedureDTO dto) {

		ClinicalProcedureDTO clinicalProcedureDTO = service.upDateClinicalProcedureDTO(dto);

		return Response.status(Status.OK).entity(clinicalProcedureDTO).build();
	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteClinicalProcedureById(@PathParam("id") Long id) {
		try {
			service.deleteClinicalProcedureById(id);
			return Response.status(Status.NO_CONTENT).build();
		} catch (ReturnExceptionMessage ex) {
			return Response.status(Status.NOT_FOUND).entity(ex).build();
		}
	}
}
