package com.dto;

import com.entity.RegisterVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterVisitorDTO {

	private Long id;

	private String name;

	private String phone;

	private String email;

	public RegisterVisitorDTO(RegisterVisitor registerVisitor) {
		this.id = registerVisitor.getId();
		this.name = registerVisitor.getName();
		this.phone = registerVisitor.getPhone();
		this.email = registerVisitor.getEmail();
	}

}
