package com.dto;

import java.time.LocalDateTime;

import com.entity.RegisterVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterVisitationDTO {

	private LocalDateTime checkinTime;

	private LocalDateTime checkoutTime;

	private String department;

	private String reasonForVisit;

	private RegisterVisitor registerVisitor;
}
