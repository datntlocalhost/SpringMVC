package com.runsystem.datnt.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.runsystem.datnt.dto.User;

public interface UserMapper {
	
	@Insert("INSERT INTO user(username, password) "
			+ "VALUES(#{username}, #{password})")
	public int insert(User user);
	
	@Update("UPDATE user "
		+ "SET username = #{username}, password = #{password} " 
		+ "WHERE username = #{username}")
	public int update(User user);
	
	@Delete("DELETE FROM user "
			+ "WHERE username = ${username}")
	public int delete(User user);
	
	@Select("SELECT * "
			+ "FROM user "
			+ "WHERE username = #{username} AND password = #{password}")
	public User selectOne(User user);
	
	@Select("SELECT * FROM user")
	public List<User> selectAll();

}
