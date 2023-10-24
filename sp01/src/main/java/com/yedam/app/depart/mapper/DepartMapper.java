package com.yedam.app.depart.mapper;

import java.util.List;

import com.yedam.app.depart.service.DepartVO;

public interface DepartMapper {
	// 전체조회
	public List<DepartVO> selectAllDepartInfo();
	
	// 부서조회(단건조회)
	public DepartVO selectDepartInfo(DepartVO departVO);
	
	// 등록
	public int insertDepartInfo(DepartVO departVO);
}
