/**
 * CheckLogin class
 */
package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.UserService;
import com.runsystem.datnt.dto.User;
import com.runsystem.datnt.util.HashSHA1;

public class CheckLogin {

	/*
	 * Check info login
	 * 
	 * @param service   To interact with user table 
	 * @param user      User's info
	 * 
	 * @return boolean  true if user's info is exist, else return false.
	 */
	public boolean canLogin(UserService service, User user) {
		//hash sha1 password 
		String hashPassword = HashSHA1.hashSHA1(user.getPassword());
		
		//Set sha1 password for user 
		user.setPassword(hashPassword);
		
		//select user from user table and assign result to user1 
		User user1 = service.selectOne(user);
		
		//return true if user1 != null, else return false.
		return user1 != null;
	}
}
