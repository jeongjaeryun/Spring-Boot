package com.yedam.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
//		SamsungTV tv = (SamsungTV)ctx.getBean("tv"); 클래스
		TV tv = (TV)ctx.getBean("tv"); //인터페이스
		tv.on();
		
	}
}
