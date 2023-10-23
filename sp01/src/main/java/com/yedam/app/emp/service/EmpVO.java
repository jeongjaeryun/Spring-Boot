package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	// 1. 컬럼따라 타입을 구분 or 실제 타입 대신 String
	// 2. 기본타입(int, double 등) 사용 or Wrap 클래스(Integer, Double) 사용
	// 2-1. db에 null이 허용돼있는 것들은 Wrap클래스 써주는게 좋음
	private int employeeId; 
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;
	
//	private String employee_id;
//	private String first_name;
//	private String last_name;
//	private String email;
//	private String hire_date;
//	private String job_id;
//	private String department_id;
//	private String salary;
}
