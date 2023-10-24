package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpTestController {
	
	@GetMapping("parameterTest")
	public String getMethodTest(EmpVO empVO) {
		System.out.println("get: ");
		System.out.println(empVO);
		return "";
	}
	
	@PostMapping("parameterTest")
	public String postMethodTest(EmpVO empVO) {
		System.out.println("post: ");
		System.out.println(empVO);
		return "";
	}
	
	@GetMapping("reqParamTest")
	public String reqParamGet(String employeeId, String lastName) {
		System.out.println("get: ");
		System.out.printf("%s, %s\n", employeeId, lastName);
		return "";
		
	}
	@PostMapping("reqParamTest")
	public String reqParamPost(@RequestParam String employeeId, @RequestParam(defaultValue="guest") String lastName) {
		System.out.println("post: ");
		System.out.printf("%s, %s\n", employeeId, lastName);
		return "";
		
	}
	
	@GetMapping("pathGet/{employeeId}")
	public String pathGet(@PathVariable String employeeId) {
		System.out.println("get : ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	
	@GetMapping("pathPost/{id}")
	public String pathPost(@PathVariable(name="id")String employeeId) {
		System.out.println("post : ");
		System.out.printf("%s\n", employeeId);
		return "";
	}
	
	@PostMapping("ajaxJson") 
	@ResponseBody  //post방식을 써야함
	public EmpVO ajaxJson(@RequestBody EmpVO empVO) { // RequestBody를 쓰는건 json을 받겠다는거임 viewresolve가 돌지 않음 데이터만 쏙 전달!
		return empVO;
	}
	
	
	
}
