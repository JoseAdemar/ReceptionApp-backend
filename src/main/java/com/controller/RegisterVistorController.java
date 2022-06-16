package com.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dto.RegisterVisitorDTO;
import com.entity.RegisterVisitor;
import com.service.RegisterVisitorService;

@Path("/api/registerVisitor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterVistorController {

	private RegisterVisitorService registerVisitorService;

	public RegisterVistorController(RegisterVisitorService registerVisitorService) {
		this.registerVisitorService = registerVisitorService;
	}

	@GET
	@Path("/{id}")
	public RegisterVisitorDTO findClientById(@PathParam("id") Long id) {
		return registerVisitorService.findById(id);

	}

	@GET
	@Path("/all")
	public void findAllRegisterVisitor(List<RegisterVisitorDTO> visitorDTO, List<RegisterVisitor> visitor) {

		registerVisitorService.findAll(visitorDTO, visitor);
	}

}
