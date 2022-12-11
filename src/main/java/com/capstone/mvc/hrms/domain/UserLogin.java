package com.capstone.mvc.hrms.domain;

public class UserLogin {
	private String user_name;
	private String password;
	private int role_id;
	private String role_name;
	private int totalAttempts ;
	private String Status_Message;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int i) {
		this.role_id = i;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public int getTotalAttempts() {
		return totalAttempts;
	}
	public void setTotalAttempts(int totalAttempts) {
		this.totalAttempts = totalAttempts;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the status_Message
	 */
	public String getStatus_Message() {
		return Status_Message;
	}
	/**
	 * @param status_Message the status_Message to set
	 */
	public void setStatus_Message(String status_Message) {
		Status_Message = status_Message;
	}

}
