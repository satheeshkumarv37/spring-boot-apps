/**
 * 
 */
package com.employeeapp.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.employeeapp.constants.ValidationConstants;

/**
 * @author Satheeshkumar V
 *
 */
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	@NotBlank(message = ValidationConstants.FIRST_NAME_MANDATORY_MESSAGE)
	private String firstName;

	@Column
	@NotBlank(message = ValidationConstants.LAST_NAME_MANDATORY_MESSAGE)
	private String lastName;

	@Column
	@NotBlank(message = ValidationConstants.MOBILE_NO_MANDATORY_MESSAGE)
	@Pattern(regexp = "(^$|[0-9]{10})", message = ValidationConstants.MOBILE_NO_INVALID_MESSAGE)
	private String mobileNumber;

	@Column
	@Email(message = ValidationConstants.EMAIL_ID_INVALID_MESSAGE)
	@NotBlank(message = ValidationConstants.EMAIL_MANDATORY_MESSAGE)
	private String emailId;

	@Column
	@NotBlank(message = ValidationConstants.DESIGNATION_MANDATORY_MESSAGE)
	private String designation;

	@Column
	private long salary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", designation=" + designation + ", salary=" + salary
				+ ", address=" + address + "]";
	}

}
