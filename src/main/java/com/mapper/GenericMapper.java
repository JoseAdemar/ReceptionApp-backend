package com.mapper;

import java.util.List;


public interface GenericMapper<D, E> {
	
	D toDto(E entity);

	List<D> toDto(List<E> entityList);

	E toEntity(D dto);

	List<E> toEntity(List<D> dtoList);
}
