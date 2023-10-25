package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller // 클래스 만들면 각 클래스에 맞는 어노테이션부터 붙이기
public class EmpController { //Controller를 중심으로 잡고 jsp를 만들어야함
	
	@Autowired
	EmpService empService;
	// Get : 조회, 페이지 호출
	// Post : 데이터 조작관련 기능(등록, 수정, 삭제) 
	
	// 전체조회
	@GetMapping("empList") // 경로
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList",list); 
		return "emp/empList"; //어떤 화면에 뿌려질지
	}
	
	// 사원 단건 조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo",findVO);
		return "emp/empInfo";
	}
	
	// 등록 - Form
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	// 등록 - Process
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		
		String path = null;
		if(empId > -1) {
			path = "redirect:empInfo?employeeId="+empId;
		}else {
			path = "redirect:empList"; 
		}
		return path;
		
	}
	// 수정 - 페이지없이 처리하는 단순 process => Ajax: @ResponseBody 
	// 	1)								 +QueryString => 커맨드 객체
	@PostMapping("empUpdate")
	@ResponseBody //돌아가는거는 response
	public Map<String, Object> empUpdateProcess(EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	// 2)								 + JSON => @RequestBody
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO){
		return empService.updateEmpInfo(empVO);
	}
	
	// 삭제
	@GetMapping("empDelete")
	public String empDeleteProcess(@RequestParam Integer employeeId, //컨트롤러를 구성하는 매개변수. requestParam()안에 name, value가 없으니 employeeId가 변수명. 기본타입쓰지말고 class타입 쓰기 ex) Integer 
									RedirectAttributes ratt) {
		boolean result = empService.deleteEmpInfo(employeeId);
		String msg = null;
		if(result) {
			msg = "정상적으로 삭제되었습니다. \n삭제대상 : "+ employeeId;
		}else {
			msg = "삭제 실패. \n정보를 확인해주시기 바랍니다.\n삭제요청 : "+ employeeId;
		}
		ratt.addFlashAttribute("result", msg);
		return "redirect:empList";
	}
}
