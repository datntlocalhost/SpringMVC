package com.runsystem.datnt.network;

public class LoginPackage {

	private boolean state;
	private String  username;
	
	public LoginPackage() {}
	
	public LoginPackage(boolean state, String username) {
		super();
		this.state = state;
		this.username = username;
	}

	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
