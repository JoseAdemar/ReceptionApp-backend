package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.dto.RegisterVisitorDTO;
import com.entity.RegisterVisitor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
	
	public List<RegisterVisitorDTO>  findAll() {
		List<RegisterVisitor> registerVisitor = registerVisitorRepository.findAll().list();
		List<RegisterVisitorDTO> registerVisitorDTO = new ArrayList<>();
		for (RegisterVisitor visitor : registerVisitor) {
			RegisterVisitorDTO dto = new RegisterVisitorDTO(visitor);
			registerVisitorDTO.add(dto);
		}
		return registerVisitorDTO;
	}
}
