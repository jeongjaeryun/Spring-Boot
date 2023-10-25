package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@RestController // 페이지 반환 X 데이터를 반환하는 용도, Rest 특징 : 쿼리스트링을 사용하지 않음 
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	// 전체조회
	@GetMapping("emps") // Rest도 getMapping을 쓰는데 경로를 내가 가고자하는 대상 간단하게 표현하는 정도로 그침
	public List<EmpVO> selectEmpAll(){
		return empService.getEmpAll();
	}
	// 단건조회
	@GetMapping("emps/{eid}") // 조회하고자하는 대상을 경로에 붙여줌
	public EmpVO selectEmpInfo(@PathVariable Integer eid) { // @PathVariable은 객체가 필요함
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(eid);
		return empService.getEmpInfo(empVO);
	}
	// 등록
	@PostMapping("emps")
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO) { //
		Map<String, Object> map = new HashMap<>();
		
		int employeeId = empService.insertEmpInfo(empVO);
		String msg = null;
		if(employeeId > -1) {
			msg = "success";
			
		}else {
			msg = "fail";
		}
		map.put("result", msg);
		map.put("employee_id", employeeId);
		
		return map;
	}
	// 수정
	@PutMapping("emps/{eid}")
	public Map<String, Object> updateEmpInfo
	                        (@PathVariable("eid") Integer employeeId, 
			                 @RequestBody EmpVO empVO){
		empVO.setEmployeeId(employeeId);
		return empService.updateEmpInfo(empVO);
	}
	// 삭제
	@DeleteMapping("emps/{eid}")
	public Map<String, Object> deleteEmpInfo(@PathVariable("eid") Integer employeeId){
		Map<String, Object> map = new HashMap<>();
		map.put("result", empService.deleteEmpInfo(employeeId));
		map.put("target", employeeId);
		return map;
	}
}
