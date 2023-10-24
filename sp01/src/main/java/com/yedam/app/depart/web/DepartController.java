package com.yedam.app.depart.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.depart.service.DepartService;
import com.yedam.app.depart.service.DepartVO;

@Controller
public class DepartController {
	
	@Autowired
	DepartService departService;
	
	// 전체조회
	@GetMapping("departList")
	public String getDepartList(Model model) {
		List<DepartVO> list = departService.getDepartAll();
		model.addAttribute("departList", list);
		return "depart/departList";
	}
	
	// 단건 부서 조회
	@GetMapping("departInfo")
	public String getDepartInfo(DepartVO departVO, Model model) {
		DepartVO findVO = departService.getDepartInfo(departVO);
		model.addAttribute("departInfo", findVO);
		return "depart/departInfo";
	}
	
	// 등록 - Form
	@GetMapping("departInsert")
	public String insertDepartInfoForm() {
		return "depart/departInsert";
	}
	
	// 등록 - process
	@PostMapping("departInsert")
	public String insertDepartInfoProcess(DepartVO departVO) {
		int depId = departService.insertDepartInfo(departVO);
		
		String path = null;
		if(depId > -1) {
			path = "redirect:departInfo?departmentId="+depId;
		}else {
			path = "redirect:departList";
		}
		return path;
	}
}
