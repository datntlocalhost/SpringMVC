package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.database.mapper.IUserMapper;
import com.runsystem.datnt.dto.User;

public class UserService implements IUserService {
	
	IUserMapper userMapper;

	public int insert(User user) {
		return userMapper.insert(user);
	}

	public int update(User user) {
		return userMapper.update(user);
	}

	public int delete(User user) {
		return userMapper.delete(user);
	}

	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	public User selectOne(User user) {
		return userMapper.selectOne(user);
	}

	public IUserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(IUserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
