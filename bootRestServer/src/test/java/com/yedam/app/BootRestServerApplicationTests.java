package com.yedam.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.app.emp.service.GreetingVO;
import com.yedam.app.emp.service.MemberVO;

@SpringBootTest
class BootRestServerApplicationTests {

	//@Test
	void jacksonTest() throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		GreetingVO vo = new GreetingVO("hello","철수"); // vo 객체 만듦
		String str = om.writeValueAsString(vo); //vo를 스트링으로 바꿔줌 이 스트링형식이 json스트링 형식
		System.out.println(str);
		assertThat(str.startsWith("{"));
		//@ResponseBody : 모든 자바 객체(vo, Map(vo랑 map은 똑같음), List) => json String으로 바꿔줌
		
	}
	//@Test
	void mapTest() throws JsonProcessingException { //<key, value>
		HashMap<String, Object> map = new HashMap<>();
		map.put("firstName", "길동"); // map.put("key", value);
		map.put("dept", 10);
		map.put("hobby", new String[] {"독서","게임"});
		ObjectMapper om = new ObjectMapper();
		String str = om.writeValueAsString(map);
		System.out.println(str);

		// {firstName : "길동", dept : 10, hobby:["독서","게임"]}
	}
	
	//@Test
	void jacksonReadTest() throws JsonMappingException, JsonProcessingException {
		String str = "{\"msg\":\"hello\",\"name\":\"철수\"}";
		ObjectMapper om = new ObjectMapper();
		GreetingVO vo = om.readValue(str, GreetingVO.class); // vo 타입으로 파싱해서 vo에 담아줌
		System.out.println(vo);
		assertThat(vo.getMsg().equals("hello"));
		//@RequestBody : json String ==> 객체({}=> vo, map)
		//									  [] => list(배열)
	}
	
	@Test
	void readTest() throws JsonMappingException, JsonProcessingException {
		String str = "{\"firstName\":\"길동\",\"dept\":10,\"hobby\":[\"독서\",\"게임\"]}";
		ObjectMapper om = new ObjectMapper();
		//HashMap<String, Object> map = om.readValue(str, HashMap.class);
		MemberVO vo = om.readValue(str, MemberVO.class);
		System.out.println(vo);

		
	}

}
