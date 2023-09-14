package com.task.employee.model;

public class HealthCheck {
	private	String healthComment;
	private	String codeStatus;
	private	String healthDescription;
	public HealthCheck() {
		super();
	}
	public HealthCheck(String healthComment, String codeStatus, String healthDescription) {
		super();
		this.healthComment = healthComment;
		this.codeStatus = codeStatus;
		this.healthDescription = healthDescription;
	}
	public String getHealthComment() {
		return healthComment;
	}
	public void setHealthComment(String healthComment) {
		this.healthComment = healthComment;
	}
	public String getCodeStatus() {
		return codeStatus;
	}
	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
	}
	public String getHealthDescription() {
		return healthDescription;
	}
	public void setHealthDescription(String healthDescription) {
		this.healthDescription = healthDescription;
	}
	
		
	
	
}
