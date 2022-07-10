package com.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public List<RegisterVisitationDTO> listVisitationDTO() {

		List<RegisterVisitation> visitation = registerVisitationRepository.findAll().list();

		if (visitation.isEmpty()) {
			return Collections.emptyList();
		}

		return visitation.stream().map(visitationDTO -> registerVisitationMapper.toDto(visitationDTO))
				.collect(Collectors.toList());

	}

	public Optional<RegisterVisitationDTO> findVisitationById(Long id) {

		RegisterVisitation visitation = registerVisitationRepository.findById(id);
		RegisterVisitationDTO dto = registerVisitationMapper.toDto(visitation);
		return Optional.of(dto);
	}

}
