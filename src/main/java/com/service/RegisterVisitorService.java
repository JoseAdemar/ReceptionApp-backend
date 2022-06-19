package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.dto.RegisterVisitorDTO;
import com.entity.RegisterVisitor;
import com.repository.RegisterVisitorRepository;

@ApplicationScoped
public class RegisterVisitorService {

	private RegisterVisitorRepository registerVisitorRepository;

	public RegisterVisitorService(RegisterVisitorRepository registerVisitorRepository) {
		this.registerVisitorRepository = registerVisitorRepository;
	}

	public Optional<RegisterVisitorDTO> findById(Long id) {
		Optional<RegisterVisitor> registerVisitor = registerVisitorRepository.findByIdOptional(id);
		Optional<RegisterVisitorDTO> dto = Optional.of(new RegisterVisitorDTO(registerVisitor.get()));

		if (registerVisitor.isEmpty() || dto.isEmpty()) {
			throw new NotFoundException("Visitor with the id " + id + "not found");
		}

		return dto;
	}

	public List<RegisterVisitorDTO> findAll() {

		List<RegisterVisitor> registerVisitor = registerVisitorRepository.findAll().list();
		List<RegisterVisitorDTO> dto = new ArrayList<RegisterVisitorDTO>();

		for (RegisterVisitor visitor : registerVisitor) {

			dto.add(new RegisterVisitorDTO(visitor));

		}

		return dto;
	}

	@Transactional
	public Optional<RegisterVisitorDTO> deleteById(Long id) {

		Optional<RegisterVisitor> visitor = Optional.of(registerVisitorRepository.findById(id));
		Optional<RegisterVisitorDTO> dto = Optional.of(new RegisterVisitorDTO(visitor.get()));
		if (visitor.isEmpty()) {
			throw new NotFoundException("Visitor with the " + id + "not found");
		} else {

			registerVisitorRepository.deleteById(id);
		}

		return dto;
	}
}
