package com.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.dto.RegisterVisitationDTO;
import com.entity.RegisterVisitation;
import com.exceptions.ReturnExceptionMessage;
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

	@Transactional
	public RegisterVisitationDTO uPDateRegisterVisitation(RegisterVisitationDTO dto) {

		Optional<RegisterVisitation> registerVisitation = registerVisitationRepository.findByIdOptional(dto.getId());

		if (registerVisitation.isEmpty()) {
			throw new ReturnExceptionMessage("it was not found register to  Id = " + dto.getId());
		}

		registerVisitationMapper.merge(dto, registerVisitation.get());

		dto.setId(dto.getId());
		dto.setCheckinTime(dto.getCheckinTime());
		dto.setCheckoutTime(dto.getCheckoutTime());
		dto.setDepartment(dto.getDepartment());
		dto.setReasonForVisit(dto.getReasonForVisit());
		dto.setRegisterVisitor(dto.getRegisterVisitor());

		registerVisitationRepository.persist(registerVisitation.get());

		RegisterVisitationDTO visitationDTO = registerVisitationMapper.toDto(registerVisitation.get());
		return visitationDTO;
	}

	@Transactional
	public void deleteRegisterVisitationById(Long id) {

		Optional<RegisterVisitation> visitation = Optional.of(registerVisitationRepository.findById(id));

		if (visitation.isEmpty()) {
			throw new NotFoundException(" Not Found this " + id);
		}

		registerVisitationRepository.deleteById(id);
	}

}
