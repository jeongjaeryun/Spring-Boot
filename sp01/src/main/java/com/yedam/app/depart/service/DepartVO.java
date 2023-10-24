package com.yedam.app.depart.service;

import lombok.Data;

@Data
public class DepartVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
