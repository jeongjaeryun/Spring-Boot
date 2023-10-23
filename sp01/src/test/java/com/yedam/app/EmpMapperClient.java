package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper;
	
	//@Test
	public void getEmpAll() {
		List<EmpVO> list = empMapper.selectAllEmpInfo();
		assertFalse(list.isEmpty());
	}
	
	//@Test
	public void getEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(),"King");
	}
	
	//@Test
	public void insertEmpInfo() {
		//등록
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setFirstName("san-ha");
		empVO.setEmail("shKang@google.com");
		empVO.setJobId("IT_PROG");
		
		empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(), 0); //selectkey 돌고있으니 아이디가 최소한0은 아님
		
	}
	//@Test
	public void updateEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		
		findVO.setSalary(1000);
		int result = empMapper.updateEmpInfo(findVO);
		assertEquals(result, 1); //정상적으로 처리되면 리턴되는 값 1
	}
	
	//@Test
	public void updateDynamic() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		empVO.setFirstName("Hal-La");
		
		int result = empMapper.updateEmpInfoDynamic(empVO);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		
		int result = empMapper.deleteEmpInfo(207);
		assertEquals(result, 1);
	}
}
