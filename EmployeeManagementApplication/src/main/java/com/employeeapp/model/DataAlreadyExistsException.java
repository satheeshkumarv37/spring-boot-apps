package com.employeeapp.model;

/**
 * @author Satheeshkumar V
 *
 */
public class DataAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -8638410639613599292L;

	public DataAlreadyExistsException() {

	}

	public DataAlreadyExistsException(String msg) {
		super(msg);
	}
}