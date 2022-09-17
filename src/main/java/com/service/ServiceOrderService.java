package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.dto.ServiceOrderDTO;
import com.entity.ServiceOrder;
import com.mapper.ServiceOrderMapper;
import com.repository.ServiceOrderRepository;

@ApplicationScoped
public class ServiceOrderService {

	private ServiceOrderRepository repository;

	private ServiceOrderMapper mapper;

	public ServiceOrderService(ServiceOrderRepository repository, ServiceOrderMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Transactional
	public ServiceOrderDTO persistOrderService(ServiceOrderDTO serviceOrderDTO) {

		ServiceOrder serviceOrder = mapper.entityTo(serviceOrderDTO);
		ServiceOrderDTO dto = mapper.dtoTo(serviceOrder);
	
		repository.persist(serviceOrder);
		return dto;

	}

	public List<ServiceOrderDTO> listAllServiceOrder() {

		List<ServiceOrder> order = repository.findAll().list();
		List<ServiceOrderDTO> dto = new ArrayList<ServiceOrderDTO>();

		for (ServiceOrder serviceOrder : order) {

			mapper.dtoTo(serviceOrder);
		}

		return dto;

	}
}
