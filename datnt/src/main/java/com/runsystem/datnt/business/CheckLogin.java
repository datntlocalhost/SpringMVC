/**
 * CheckLogin class
 * 
 * Chứa các phương thức kiểm tra đăng nhập
 */
package com.runsystem.datnt.business;

import com.runsystem.datnt.database.service.UserService;
import com.runsystem.datnt.dto.User;
import com.runsystem.datnt.util.HashSHA1;

public class CheckLogin {

	/*
	 * Kiểm tra đăng nhập 
	 * 
	 * @param service   Thao tác với user database 
	 * @param user      Thông tin đăng nhập
	 * 
	 * @return boolean  true nếu thông tin có trong db, ngược lại false.
	 */
	public boolean canLogin(UserService service, User user) {
		//hash sha1 password 
		String hashPassword = HashSHA1.hashSHA1(user.getPassword());
		
		//Set lại password
		user.setPassword(hashPassword);
		
		//select từ database và gán vào user1 
		User user1 = service.selectOne(user);
		
		//return true nếu user1 != null, ngược lại false.
		return user1 != null;
	}
}
