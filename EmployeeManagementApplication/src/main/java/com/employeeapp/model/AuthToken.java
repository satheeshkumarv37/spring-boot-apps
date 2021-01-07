/**
 * 
 */
package com.employeeapp.model;

/**
 * @author Satheeshkumar V
 *
 */
public class AuthToken {
	private String token;

	public AuthToken(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
