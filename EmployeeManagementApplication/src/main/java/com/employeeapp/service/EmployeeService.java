/**
 * 
 */
package com.employeeapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.employeeapp.constants.EmployeeServiceConstants;
import com.employeeapp.dao.EmployeeDao;
import com.employeeapp.dao.entity.Employee;
import com.employeeapp.model.ContactInfo;
import com.employeeapp.model.DataNotFoundException;
import com.employeeapp.model.EmployeeResponse;

/**
 * @author Satheeshkumar V
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeResponse addEmployee(Employee employee) {
		employee = employeeDao.addEmployee(employee);
		EmployeeResponse response = new EmployeeResponse(employee.getId(), EmployeeServiceConstants.CREATE_ACTION,
				EmployeeServiceConstants.SUCCESS_STATUS);
		return response;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EmployeeResponse updateEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
		EmployeeResponse response = new EmployeeResponse(employee.getId(), EmployeeServiceConstants.UPDATE_ACTION,
				EmployeeServiceConstants.SUCCESS_STATUS);
		return response;
	}

	public EmployeeResponse deleteEmployeeById(Long id) {
		employeeDao.deleteEmployeeById(id);
		EmployeeResponse response = new EmployeeResponse(id, EmployeeServiceConstants.DELETE_ACTION,
				EmployeeServiceConstants.SUCCESS_STATUS);
		return response;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EmployeeResponse updatePhoneNumberById(Long id, ContactInfo contact) {
		employeeDao.updatePhoneNumberById(id, contact.getMobileNumber());
		EmployeeResponse response = new EmployeeResponse(id, EmployeeServiceConstants.UPDATE_ACTION,
				EmployeeServiceConstants.SUCCESS_STATUS);
		return response;
	}

	public Employee findEmployeeById(final long id) {
		Optional<Employee> employeeOptional = employeeDao.findEmployeeById(id);
		if (employeeOptional.isPresent()) {
			return employeeOptional.get();
		} else {
			throw new DataNotFoundException("Employee ID " + id + " not found in Database");
		}
	}
}
