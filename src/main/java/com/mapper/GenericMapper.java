package com.mapper;

public interface GenericMapper<D, E> {

	D dtoTo(E entity);

	E entityTo(D dto);
}
