package com.exceptions;

import javax.ws.rs.NotFoundException;

public class ReturnExceptionMessage extends NotFoundException{
	private static final long serialVersionUID = 1L;

	public ReturnExceptionMessage (String message) {
          super(message);
	}
}
