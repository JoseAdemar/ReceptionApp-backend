package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.dto.CustomerDTO;
import com.entity.Customer;
import com.exceptions.ReturnExceptionMessage;
import com.repository.CustomerRepository;

@ApplicationScoped
public class CustomerService {

	private CustomerRepository repository;

	public CustomerService(CustomerRepository registerVisitorRepository) {
		this.repository = registerVisitorRepository;

	}

	@Transactional
	public CustomerDTO registerCustomer(Customer customer) {
		Customer customerRegistration = customer;
		CustomerDTO dto = new CustomerDTO(customerRegistration);
		repository.persist(customerRegistration);

		return dto;

	}

	public CustomerDTO findCustomerById(Long id) {
		Optional<Customer> customer = Optional.of(repository.findByIdOptional(id)
				.orElseThrow(() -> new ReturnExceptionMessage("Customer Id = " + id + " not found")));
		Optional<CustomerDTO> dto = Optional.of(new CustomerDTO(customer.get()));

		return dto.get();
	}

	public List<CustomerDTO> findAllCustomer() {

		List<Customer> customer = repository.findAll().list();
		List<CustomerDTO> dto = new ArrayList<CustomerDTO>();

		for (Customer customerRegistration : customer) {

			dto.add(new CustomerDTO(customerRegistration));

		}

		return dto;
	}

	@Transactional
	public CustomerDTO deleteCustomerById(Long id) {

		Optional<Customer> customer = Optional.of(repository.findByIdOptional(id)
				.orElseThrow(() -> new NotFoundException("Customer Id = " + id + " not found")));
		Optional<CustomerDTO> dto = Optional.of(new CustomerDTO(customer.get()));

		if (dto.isPresent()) {
			repository.deleteById(id);
		}
		return dto.get();

	}

	@Transactional
	public Customer updateCustomer(Customer customerRegistration) {

		Optional<Customer> customer = Optional
				.of(repository.findByIdOptional(customerRegistration.getId()).get());

		if (customer.isEmpty()) {
			throw new ReturnExceptionMessage(" Customer Id = " + customerRegistration.getId() + " Not Found");
		}

		Customer updatingCustomer = customer.get();

		updatingCustomer.setId(customerRegistration.getId());
		updatingCustomer.setName(customerRegistration.getName());
		updatingCustomer.setSocialSecurityNumber(customerRegistration.getSocialSecurityNumber());
		updatingCustomer.setBirthDate(customerRegistration.getBirthDate());
		updatingCustomer.setPhoneNumber(customerRegistration.getPhoneNumber());
		updatingCustomer.setEmail(customerRegistration.getEmail());
		updatingCustomer.setAddress(customerRegistration.getAddress());

		repository.persist(updatingCustomer);

		return updatingCustomer;

	}
}
