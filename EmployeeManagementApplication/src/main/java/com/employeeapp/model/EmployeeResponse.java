/**
 * 
 */
package com.employeeapp.model;

/**
 * @author Satheeshkumar V
 *
 */
public class EmployeeResponse {

	private Long employeeId;
	private String action;
	private String status;
	private String code;
	private String message;
	private String additionDetails;

	public EmployeeResponse() {

	}

	public EmployeeResponse(Long employeeId, String action, String status) {
		super();
		this.employeeId = employeeId;
		this.action = action;
		this.status = status;
	}

	public EmployeeResponse(Long employeeId, String action, String status, String additionDetails) {
		super();
		this.employeeId = employeeId;
		this.action = action;
		this.status = status;
		this.additionDetails = additionDetails;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAdditionDetails() {
		return additionDetails;
	}

	public void setAdditionDetails(String additionDetails) {
		this.additionDetails = additionDetails;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [employeeId=" + employeeId + ", action=" + action + ", status=" + status
				+ ", additionDetails=" + additionDetails + "]";
	}

}
