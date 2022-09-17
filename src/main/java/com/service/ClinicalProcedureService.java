package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.dto.ClinicalProcedureDTO;
import com.entity.ClinicalProcedure;
import com.exceptions.ReturnExceptionMessage;
import com.mapper.ClinicalProcedureMapper;
import com.repository.ClinicalProcedureRepository;

@ApplicationScoped
public class ClinicalProcedureService {

	private ClinicalProcedureRepository repository;

	private ClinicalProcedureMapper mapper;

	public ClinicalProcedureService(ClinicalProcedureRepository procedureRepository,
			ClinicalProcedureMapper procedureMapper) {
		this.repository = procedureRepository;
		this.mapper = procedureMapper;
	}

	@Transactional
	public ClinicalProcedureDTO persisteClinicalProcedure(ClinicalProcedureDTO procedureDTO) {

		ClinicalProcedure procedure = mapper.entityTo(procedureDTO);
		ClinicalProcedureDTO dto = mapper.dtoTo(procedure);

		repository.persist(procedure);

		return dto;

	}

	public ClinicalProcedureDTO listClinicalProcedureById(Long id) {
		Optional<ClinicalProcedure> procedure = repository.findByIdOptional(id);

		if (procedure.isEmpty()) {
			throw new ReturnExceptionMessage("ID = " + id + "Not Found");
		}

		ClinicalProcedureDTO dto = mapper.dtoTo(procedure.get());
		return dto;

	}

	public List<ClinicalProcedureDTO> listClinicalProcedure() {
		List<ClinicalProcedure> clinicalProcedure = repository.findAll().list();

		if (clinicalProcedure.isEmpty()) {
			throw new ReturnExceptionMessage(" Not found any clinical procedure");
		}

		return clinicalProcedure.stream().map(clinicalProcedureDTO -> mapper.dtoTo(clinicalProcedureDTO))
				.collect(Collectors.toList());

	}

	@Transactional
	public ClinicalProcedureDTO upDateClinicalProcedureDTO(ClinicalProcedureDTO dto) {

		Optional<ClinicalProcedure> clinicalProcedure = repository.findByIdOptional(dto.getId());

		if (clinicalProcedure.isEmpty()) {
			throw new ReturnExceptionMessage("it was not found register to  Id = " + dto.getId());
		}

		mapper.merge(dto, clinicalProcedure.get());

		dto.setId(dto.getId());
		dto.setClinicalProcedure(dto.getClinicalProcedure());

		repository.persist(clinicalProcedure.get());

		ClinicalProcedureDTO clinicalProcedureDTO = mapper.dtoTo(clinicalProcedure.get());
		return clinicalProcedureDTO;
	}

	@Transactional
	public void deleteClinicalProcedureById(Long id) {

		Optional<ClinicalProcedure> optional = Optional.of(repository.findById(id));

		if (optional.isEmpty()) {
			throw new ReturnExceptionMessage(" Not Found this " + id);
		}

		repository.deleteById(id);
	}

}
