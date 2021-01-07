/**
 * 
 */
package com.employeeapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.employeeapp.dao.entity.Address;
import com.employeeapp.dao.entity.Employee;
import com.employeeapp.dao.repository.AddressRepository;
import com.employeeapp.dao.repository.EmployeeRepository;
import com.employeeapp.model.DataAlreadyExistsException;
import com.employeeapp.model.DataNotFoundException;

/**
 * @author Satheeshkumar V
 *
 */
@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressRepository addressRepository;

	public Employee addEmployee(Employee employee) {
		if (findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName()).isPresent()) {
			throw new DataAlreadyExistsException("Employee " + employee.getFirstName() + ", " + employee.getLastName()
					+ " already exists in Database");
		}
		Address address = addressRepository.save(employee.getAddress());
		employee.setAddress(address);
		return employeeRepository.save(employee);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeDBDataOptional = findByFirstNameAndLastName(employee.getFirstName(),
				employee.getLastName());
		if (employeeDBDataOptional.isPresent()) {
			Employee employeeDBData = employeeDBDataOptional.get();
			employeeDBData.setEmailId(employee.getEmailId());
			employeeDBData.setMobileNumber(employee.getMobileNumber());
			return employeeRepository.save(employeeDBData);
		} else {
			throw new DataNotFoundException(
					"Employee " + employee.getFirstName() + ", " + employee.getLastName() + " not found Database");
		}
	}

	public void deleteEmployeeById(Long id) {
		if (findEmployeeById(id).isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new DataNotFoundException("Employee ID " + id + " not found in Database");
		}
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void updatePhoneNumberById(Long id, String mobileNumber) {
		employeeRepository.updatePhoneNumberById(id, mobileNumber);
	}

	public Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
		return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public Optional<Employee> findEmployeeById(final long id) {
		return employeeRepository.findById(id);
	}
}
