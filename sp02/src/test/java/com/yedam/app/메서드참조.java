package com.yedam.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 메서드참조 {
	public static void main(String[] args) {
		List<Member> memberList = Arrays.asList(new Member("A"), 
												new Member("B"), 
												new Member("C"));
		String collect = memberList.stream()
				.map(element -> element.getName())
				.collect(Collectors.joining());
		
		memberList.stream()
		.forEach(System.out::println);
	}

	public static class Member {
		private String name;

		public Member(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		public String toString(){
			return name;
		}
	}
}
