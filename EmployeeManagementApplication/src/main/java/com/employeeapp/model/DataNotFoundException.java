package com.employeeapp.model;

/**
 * @author Satheeshkumar V
 *
 */
public class DataNotFoundException extends RuntimeException {

	public DataNotFoundException() {

	}

	public DataNotFoundException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = -8638410639613599292L;
}