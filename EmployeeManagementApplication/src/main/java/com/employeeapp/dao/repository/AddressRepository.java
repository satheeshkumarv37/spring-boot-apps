/**
 * 
 */
package com.employeeapp.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.dao.entity.Address;

/**
 * @author Satheeshkumar V
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
