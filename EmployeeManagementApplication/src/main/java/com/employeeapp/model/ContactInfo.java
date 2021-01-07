/**
 * 
 */
package com.employeeapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Satheeshkumar V
 *
 */
public class ContactInfo {

	@NotBlank(message = "Mobile Number is Mandatory")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid mobile number")
	private String mobileNumber;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
