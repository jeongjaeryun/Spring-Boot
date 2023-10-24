package com.yedam.app.depart.service;

import java.util.List;

public interface DepartService {
	// 전체조회
	public List<DepartVO> getDepartAll();
	
	// 단건조회
	public DepartVO getDepartInfo(DepartVO departVO);
	
	// 등록
	public int insertDepartInfo(DepartVO departVO);
}
