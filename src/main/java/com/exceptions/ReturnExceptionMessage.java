package com.exceptions;

public class ReturnExceptionMessage extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ReturnExceptionMessage (String message) {
		super(message);
	}
}
