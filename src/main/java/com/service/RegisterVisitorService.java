package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

import com.dto.RegisterVisitorDTO;
import com.entity.RegisterVisitor;
import com.repository.RegisterVisitorRepository;

@ApplicationScoped
public class RegisterVisitorService {

	private RegisterVisitorRepository registerVisitorRepository;

	public RegisterVisitorService(RegisterVisitorRepository registerVisitorRepository) {
		this.registerVisitorRepository = registerVisitorRepository;
	}

	// This method it's working
	public RegisterVisitorDTO findById(Long id) {
		RegisterVisitor registerVisitor = registerVisitorRepository.findById(id);
		RegisterVisitorDTO dto = new RegisterVisitorDTO(registerVisitor);

		return dto;
	}

	// This method is to return the entire list, but it's not working
	public List<RegisterVisitorDTO> registerVisitorDTO() {

		List<RegisterVisitor> registerVisitor = new ArrayList<>();
		List<RegisterVisitorDTO> dto = new ArrayList<>();

		for (RegisterVisitor register : registerVisitor) {

			dto.add(register.getId());
			dto.add(register.getName());
			dto.add(register.getPhone());
			dto.add(register.getEmail());

		}

		return dto = registerVisitorRepository.findAll();

	}
}