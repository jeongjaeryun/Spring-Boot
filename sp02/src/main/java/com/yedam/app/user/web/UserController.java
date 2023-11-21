package com.yedam.app.user.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.user.service.UserService;
import com.yedam.app.user.service.UserVO;
import com.yedam.app.user.service.UserVOList;

@CrossOrigin("*") // 일시적으로 개발하는 동안 cors 무력화 시킬때 씀 배포할땐 제거해야함
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	//1) Ajax + get + QueryString
	@GetMapping("getAjax")
	@ResponseBody
	public UserVO insertGetAjax(UserVO userVO) {
		return userService.insertUserinfo(userVO);
	}
	
	//2) Ajax + post + QueryString
	@PostMapping("postAjax")
	@ResponseBody
	public UserVO insertPostAjax(UserVO userVO) {
		return userService.insertUserinfo(userVO);
	}
	
	//3)  Ajax + JSON(=> @RequestBody => @PostMapping) JSON을 스프링에서 처리할땐 리퀘스트바디를 쓰고 바디를 가지고 있는건 포스트 뿐이라 포스트를 꼭 같이 써야함
	// -> 단건
	@PostMapping("jsonAjax")
	@ResponseBody
	public UserVO insertJsonAjax(@RequestBody UserVO userVO) {
		return userService.insertUserinfo(userVO);
	}
	
	// -> 배열
	@PostMapping("jsonListAjax")
	@ResponseBody Map<String, Object> insertJsonListAjax(@RequestBody List<UserVO>list){
		return userService.insertUserList(list);
	}
	// 4) Ajax + QueryString(Array)
	@PostMapping("postListAjax")
	@ResponseBody
	public Map<String, Object> insertPostAjax(UserVOList userList){
		return userService.insertUserList(userList.getList());
	}
}
