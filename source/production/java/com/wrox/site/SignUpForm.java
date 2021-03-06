package com.wrox.site;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

//@PasswordsNotEmpty(
//        passwordFieldName = "password",
//        passwordVerificationFieldName = "passwordVerification"
//)
//@PasswordsNotEqual(
//        passwordFieldName = "password",
//        passwordVerificationFieldName = "passwordVerification"
//)
public class SignUpForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String username;
	
	@NotEmpty
	@Size(max = 100)
	private String firstName;
	
	@NotEmpty
	@Size(max = 100)
	private String lastName;
	
	private String password;
	private String passwordVerification;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordVerification() {
		return passwordVerification;
	}
	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}
	
	
	
	
}
