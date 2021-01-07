/**
 * 
 */
package com.employeeapp.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employeeapp.constants.RequestResponseConstants;
import com.employeeapp.model.DataAlreadyExistsException;
import com.employeeapp.model.DataNotFoundException;
import com.employeeapp.model.EmployeeResponse;

/**
 * @author Satheeshkumar V
 *
 */
@ControllerAdvice
public class EmployeeServiceExceptionHandler {

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<EmployeeResponse> exception(DataNotFoundException exception) {
		EmployeeResponse responseDto = new EmployeeResponse();
		responseDto.setCode(RequestResponseConstants.DATA_NOT_FOUND_CODE);
		responseDto.setMessage(RequestResponseConstants.DATA_NOT_FOUND_MESSAGE);
		responseDto.setAdditionDetails(exception.getMessage());
		return new ResponseEntity<EmployeeResponse>(responseDto, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DataAlreadyExistsException.class)
	public ResponseEntity<EmployeeResponse> exception(DataAlreadyExistsException exception) {
		EmployeeResponse responseDto = new EmployeeResponse();
		responseDto.setCode(RequestResponseConstants.DATA_ALREADY_EXISTS_CODE);
		responseDto.setMessage(RequestResponseConstants.DATA_ALREADY_EXISTS_MESSAGE);
		responseDto.setAdditionDetails(exception.getMessage());
		return new ResponseEntity<EmployeeResponse>(responseDto, HttpStatus.FORBIDDEN);
	}
}
