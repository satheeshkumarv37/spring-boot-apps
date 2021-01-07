/**
 * 
 */
package com.employeeapp.controller;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapp.constants.SecurityConstants;
import com.employeeapp.dao.entity.Employee;
import com.employeeapp.model.ContactInfo;
import com.employeeapp.model.EmployeeResponse;
import com.employeeapp.service.EmployeeService;

/**
 * @author Satheeshkumar V
 *
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PreAuthorize("hasRole('" + SecurityConstants.ROLE_ADMIN + "')")
	@PostMapping(value = "/add")
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody @Valid Employee employee) {
		EmployeeResponse responseDto = employeeService.addEmployee(employee);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('" + SecurityConstants.ROLE_ADMIN + "')")
	@PutMapping(value = "/update")
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody @Valid Employee employee) {
		EmployeeResponse responseDto = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('" + SecurityConstants.ROLE_ADMIN + "')")
	@DeleteMapping(value = "/deleteById")
	public ResponseEntity<EmployeeResponse> deleteEmployeeById(@RequestParam @Positive Long id) {
		EmployeeResponse responseDto = employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('" + SecurityConstants.ROLE_USER + "')" + " || hasRole('" + SecurityConstants.ROLE_ADMIN
			+ "')")
	@GetMapping(value = "/findById")
	public ResponseEntity<Employee> findEmployeeById(@RequestParam @Positive Long id) {
		Employee responseDto = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('" + SecurityConstants.ROLE_ADMIN + "')")
	@PatchMapping(value = "/{id}/updatePhoneNumberById")
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<EmployeeResponse> updatePhoneNumberById(@PathVariable("id") @Positive Long id,
			@RequestBody @Valid ContactInfo contact) {
		EmployeeResponse responseDto = employeeService.updatePhoneNumberById(id, contact);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
