package com.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dto.ServiceOrderDTO;
import com.service.ServiceOrderService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api/serviceOrder")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceOrderController {

	private ServiceOrderService service;
	
	public ServiceOrderController(ServiceOrderService service) {
		this.service = service;
	}
	
	@POST
	@Path("/save")
	public Response persistServiceOrder(@RequestBody ServiceOrderDTO dto) {
		ServiceOrderDTO serviceOrderDTO = service.persistOrderService(dto);
		return Response.status(Status.CREATED).entity(serviceOrderDTO).build();
	}
	
	@GET
	@Path("/all")
	public List<ServiceOrderDTO> listAllServiceOrder(){
		return service.listAllServiceOrder();
	}
}
