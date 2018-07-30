package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.dto.User;

public interface IUserService {
	public int insert(User user);
	public int update(User user);
	public int delete(User user);
	public List<User> selectAll();
	public User selectOne(User user);
}
