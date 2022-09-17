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

import com.dto.CustomerDTO;
import com.entity.Customer;
import com.exceptions.ReturnExceptionMessage;
import com.service.CustomerService;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/api/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@POST
	@Path("/save")
	public Response registerCustomer(@RequestBody Customer customer) {
		service.registerCustomer(customer);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("/find/{id}")
	public Response findCustomerById(@PathParam("id") Long id) {
		
		try {
		CustomerDTO dto = service.findCustomerById(id);

		return Response.status(Status.OK).entity(dto).build();
		
		}catch (ReturnExceptionMessage e) {
			return Response.status(Status.NOT_FOUND).entity(e.getLocalizedMessage()).build();
		}

	}

	@GET
	@Path("/all")
	public List<CustomerDTO> customerRegistrationDTOs() {
		return service.findAllCustomer();
	}

	@DELETE
	@Path("/delete/{id}")
	public void deleteVisitorById(@PathParam("id") Long id) {
		service.deleteCustomerById(id);

	}

	@PUT
	@Path("/update")
	public Response updateCustomer(@RequestBody Customer customer) {

		Customer customerRegistration = service.updateCustomer(customer);

		return Response.status(Status.OK).entity(customerRegistration).build();
	}

}
