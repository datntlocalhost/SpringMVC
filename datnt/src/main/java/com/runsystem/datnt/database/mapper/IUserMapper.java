package com.runsystem.datnt.database.mapper;

import java.util.List;

import com.runsystem.datnt.dto.User;

public interface IUserMapper {

	public int insert(User user);
	
	
	public int update(User user);
	
	
	public int delete(User user);
	
	
	public User selectOne(User user);
	

	public List<User> selectAll();

}
