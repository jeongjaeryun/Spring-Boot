package com.yedam.app.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String password;
	private String gender;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 통신통해 받아야 하는 날짜들은 DateTimeFormat 사용해 -으로 통일하는게 더 나음 교수님이 권장하는 방법
	//@JsonFormat(pattern = "yyyy/MM/dd") // json 날짜 포맷은 - 하이픈 입력이라 오류안나게하려고 쿼리스트링 형태로 바꿔줌
	private Date joinDate;

}
