package com.service;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.dto.RegisterVisitationDTO;
import com.entity.RegisterVisitation;
import com.mapper.RegisterVisitationMapper;
import com.repository.RegisterVisitationRepository;

@ApplicationScoped
public class RegisterVisitationService {

	private RegisterVisitationRepository registerVisitationRepository;

	private RegisterVisitationMapper registerVisitationMapper;

	public RegisterVisitationService(RegisterVisitationRepository registerVisitationRepository,
			RegisterVisitationMapper registerVisitationMapper) {
		this.registerVisitationRepository = registerVisitationRepository;
		this.registerVisitationMapper = registerVisitationMapper;
	}

	@Transactional
	public RegisterVisitationDTO persisteDTO(RegisterVisitationDTO dto) {

		RegisterVisitation visitation = registerVisitationMapper.toEntity(dto);
		registerVisitationRepository.persist(visitation);
		RegisterVisitationDTO result = registerVisitationMapper.toDto(visitation);

		return result;

	}

}
