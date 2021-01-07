/**
 * 
 */
package com.employeeapp.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapp.dao.entity.Employee;

/**
 * @author Satheeshkumar V
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Modifying
	@Query("UPDATE Employee e SET e.mobileNumber = ?2 WHERE e.id = ?1")
	void updatePhoneNumberById(Long id, String mobileNumber);

	@Query("SELECT e from Employee e WHERE e.firstName = ?1 AND e.lastName = ?2")
	Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
