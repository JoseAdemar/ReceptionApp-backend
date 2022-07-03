package com.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.RegisterVisitorDTO;
import com.entity.RegisterVisitor;
import com.service.RegisterVisitorService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api/registerVisitor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterVistorController {

	private RegisterVisitorService registerVisitorService;

	public RegisterVistorController(RegisterVisitorService registerVisitorService) {
		this.registerVisitorService = registerVisitorService;
	}

	@POST
	@Path("/save")
	public void registerVisitor(@RequestBody RegisterVisitor visitor) {
		registerVisitorService.registerVisitor(visitor);
	}

	@GET
	@Path("/{id}")
	public Response findClientById(@PathParam("id") Long id) {
		RegisterVisitorDTO dto = registerVisitorService.findById(id);

		return Response.status(Status.OK).entity(dto).build();

	}

	@GET
	@Path("/all")
	public List<RegisterVisitorDTO> registerVisitorDTO() {
		return registerVisitorService.findAll();
	}

	@DELETE
	@Path("/{id}")
	public void deleteVisitorById(@PathParam("id") Long id) {
		registerVisitorService.deleteById(id);

	}

}
