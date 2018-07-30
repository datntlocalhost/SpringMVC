package com.runsystem.datnt.database.service;

import java.util.List;
import com.runsystem.datnt.database.mapper.UserMapper;
import com.runsystem.datnt.dto.User;

public class UserService implements IUserService {
	
	UserMapper userMapper;

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public int delete(User user) {
		return userMapper.delete(user);
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public User selectOne(User user) {
		return userMapper.selectOne(user);
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
