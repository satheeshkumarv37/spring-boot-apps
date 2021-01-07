package com.employeeapp.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.dao.entity.User;

/**
 * @author Satheeshkumar V
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}