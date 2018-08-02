package com.runsystem.datnt.database.service;

import java.util.List;

import com.runsystem.datnt.database.mapper.IFullStudentInfoMapper;
import com.runsystem.datnt.dto.FullStudentInfo;
import com.runsystem.datnt.dto.Pagenation;
import com.runsystem.datnt.dto.Student;

public class FullStudentInfoService implements IFullStudentInfoService {

	IFullStudentInfoMapper fullStudentInfoMapper;
	
	@Override
	public List<FullStudentInfo> search(Student param) {
		return fullStudentInfoMapper.search(param);
	}

	public IFullStudentInfoMapper getFullStudentInfoMapper() {
		return fullStudentInfoMapper;
	}

	public void setFullStudentInfoMapper(IFullStudentInfoMapper fullStudentInfoMapper) {
		this.fullStudentInfoMapper = fullStudentInfoMapper;
	}

	@Override
	public int count(Student param) {
		// TODO Auto-generated method stub
		return fullStudentInfoMapper.count(param);
	}

	@Override
	public List<FullStudentInfo> selectLimit(Pagenation param) {
		// TODO Auto-generated method stub
		return fullStudentInfoMapper.selectLimit(param);
	}
	
}
