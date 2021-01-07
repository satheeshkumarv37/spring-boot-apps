/**
 * 
 */
package com.employeeapp.exception;

/**
 * @author Satheeshkumar V
 *
 */
public class EmployeeServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8503373291157596996L;

	/**
	 * @param arg0
	 */
	public EmployeeServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public EmployeeServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public EmployeeServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
