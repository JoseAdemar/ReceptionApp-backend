package com.service;

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
	
	public void findAll(List<RegisterVisitorDTO> registerVisitorDTO, List<RegisterVisitor> registerVisitor) {

		registerVisitor = registerVisitorRepository.findAll().list();

		for (RegisterVisitor visitor : registerVisitor) {

			visitor.getId();
			visitor.getName();
			visitor.getPhone();
			visitor.getEmail();

			for (RegisterVisitorDTO dto : registerVisitorDTO) {
            
				dto.setId(visitor.getId());
				dto.getId();
				dto.setName(visitor.getName());
				dto.getName();
				dto.setPhone(visitor.getPhone());
				dto.getPhone();
				dto.setEmail(visitor.getEmail());
				dto.getEmail();
			}
		}

	}
}
