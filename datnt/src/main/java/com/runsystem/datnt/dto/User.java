/*
 * Class User 
 * 
 * Định nghĩa các thuộc tính và phương thức
 * cho đối tượng User 
 */
package com.runsystem.datnt.dto;

import com.runsystem.datnt.validation.PasswordConstraint;
import com.runsystem.datnt.validation.UsernameConstraint;

public class User {
	
	@UsernameConstraint
	private String username;
	
	@PasswordConstraint
	private String password;
	
	public User() {}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
