package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	
	@Autowired
	Chef chef; // @Autowired(스프링에게 제어권을 넘기는것)가 들어간 클래스는 bean이 되어야함 @Component
	
	public void open() {
		
		chef.cooking();
	}
}
