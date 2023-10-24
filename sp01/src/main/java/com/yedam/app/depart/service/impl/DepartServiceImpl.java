package com.yedam.app.depart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.depart.mapper.DepartMapper;
import com.yedam.app.depart.service.DepartService;
import com.yedam.app.depart.service.DepartVO;

@Service
public class DepartServiceImpl implements DepartService {
	
	@Autowired
	DepartMapper departMapper;
	
	@Override
	public List<DepartVO> getDepartAll() {
		return departMapper.selectAllDepartInfo();
	}

	@Override
	public DepartVO getDepartInfo(DepartVO departVO) {
		return departMapper.selectDepartInfo(departVO);
	}

	@Override
	public int insertDepartInfo(DepartVO departVO) {
		int result = departMapper.insertDepartInfo(departVO);
		
		if(result == 1) {
			return departVO.getDepartmentId();
		}else {
			
			return -1;
		}
	}

}
