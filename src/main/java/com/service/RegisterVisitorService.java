package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.dto.RegisterVisitorDTO;
import com.entity.RegisterVisitor;
import com.exceptions.ReturnExceptionMessage;
import com.repository.RegisterVisitorRepository;

@ApplicationScoped
public class RegisterVisitorService {

	private RegisterVisitorRepository registerVisitorRepository;

	public RegisterVisitorService(RegisterVisitorRepository registerVisitorRepository) {
		this.registerVisitorRepository = registerVisitorRepository;

	}

	@Transactional
	public void registerVisitor(RegisterVisitor visitor) {
		registerVisitorRepository.persist(visitor);

	}

	public RegisterVisitorDTO findById(Long id) {
		Optional<RegisterVisitor> registerVisitor = Optional.of(registerVisitorRepository.findByIdOptional(id)
				.orElseThrow(() -> new NotFoundException("Visitor " + id + " not found")));
		Optional<RegisterVisitorDTO> dto = Optional.of(new RegisterVisitorDTO(registerVisitor.get()));

		return dto.get();
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
	public RegisterVisitorDTO deleteById(Long id) {

		Optional<RegisterVisitor> registerVisitor = Optional.of(registerVisitorRepository.findByIdOptional(id)
				.orElseThrow(() -> new NotFoundException("Visitor " + id + " not found")));
		Optional<RegisterVisitorDTO> dto = Optional.of(new RegisterVisitorDTO(registerVisitor.get()));

		if (dto.isPresent()) {
			registerVisitorRepository.deleteById(id);
		}
		return dto.get();

	}

	@Transactional
	public RegisterVisitor updateRegisterVisitor(Long id, RegisterVisitor registerVisitor) {

		Optional<RegisterVisitor> visitor = Optional.of(registerVisitorRepository.findByIdOptional(id).get());

		if (visitor.isEmpty()) {
			throw new ReturnExceptionMessage(" Not Found Id = " + registerVisitor.getId());
		}
		
		RegisterVisitor updatingRegisterVisitor = visitor.get();

		updatingRegisterVisitor.setId(registerVisitor.getId());
		updatingRegisterVisitor.setName(registerVisitor.getName());
		updatingRegisterVisitor.setEmail(registerVisitor.getEmail());
		updatingRegisterVisitor.setPhone(registerVisitor.getPhone());

		registerVisitorRepository.persist(updatingRegisterVisitor);
		
		return updatingRegisterVisitor;

	}
}
