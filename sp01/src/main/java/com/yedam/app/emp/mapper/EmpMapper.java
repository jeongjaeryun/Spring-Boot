package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

//경로 com.yedam.app.**.mapper

public interface EmpMapper {
	// 전체조회 (다건조회)
	public List<EmpVO> selectAllEmpInfo();
	
	// 사원조회 (단건조회)
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	// 등록
	public int insertEmpInfo(EmpVO empVO);
	
	// 수정
	public int updateEmpInfo(EmpVO empVO);
	
	// 수정 : Dynamic SQL 사용한 것
	public int updateEmpInfoDynamic(EmpVO empVO);
	
	// 삭제, @Param 매개변수로 두개 이상의 값을 넘길때 사용함 
	public int deleteEmpInfo(@Param("empid") int emplyeeId);
}
