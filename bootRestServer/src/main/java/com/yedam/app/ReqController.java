package com.yedam.app;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpListVO;
import com.yedam.app.emp.service.EmpVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ReqController {

	@RequestMapping("reqStr")
	@ResponseBody
	public Map<String, Object> reqStr(String firstName) {
		log.info(firstName);
		return Collections.singletonMap("firstName", firstName);
	}
	
	
	@PostMapping("reqVO")
	@ResponseBody
	public EmpVO reqVO(EmpVO vo) {
		log.info(vo);
		return vo;
	}
	
	
	@PostMapping("reqMap")
	@ResponseBody
	public Map<String, Object> reqMap(@RequestParam Map<String,Object> map) {
		log.info(map);
		return Collections.singletonMap("result", "true");
	}
	
	
	@PostMapping("reqVOJson")
	@ResponseBody
	public EmpVO reqVOJson(@RequestBody EmpVO vo) { //JSON으로 보내면 RequestBody가 필수 그래서 파싱해서 vo에 담아줌
		log.info(vo);
		return vo;
	}	

	
	@PostMapping("reqList")
	@ResponseBody
	public EmpListVO reqList(EmpListVO empListvo) { //String, vo, map만 올수있음
		log.info(empListvo);
		return empListvo;
	}

	
	@PostMapping("reqListJson")
	@ResponseBody
	public List<EmpVO> reqListJson(@RequestBody List<EmpVO> list) { //list vo에 담아주고 싶을때 json으로 보내주면 편함, html에서 보낸 배열을 list로 받는다
		log.info(list);
		return list;
	}	
}
