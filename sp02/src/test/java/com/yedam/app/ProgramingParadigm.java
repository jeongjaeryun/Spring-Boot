package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/*
1. 단어의 크기가 2 이상인 경우를 필터링한다.
2. 모든 단어를 대문자로 변환한다.
3. 모든 단어를 앞글자만 잘라내어 변환한다.
4. 모든 단어를 스페이스로 구분한 하나의 문자열로 합친다.
 */
public class ProgramingParadigm {

	private final List<String> words = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    @Test
    public void wordProcessTest() {
    	//words.sort((Object o1, Object o2) -> 0);
    	//Comparator 구현 클래스 -> new
    	//->  클래스 선언과 생성
    	Function<String, String> function = word -> word.toUpperCase();
    	
    	//words.stream().forEach(s -> System.out.println(s));
    	words.stream().forEach(System.out::println); // 위에거랑 같은거임 인수받는게 같아서 빼도 됨
    	//out::println ===>> out 객체에서 println을 부를거다
    	
        String result = words.stream()
                .filter(w -> w.length() > 1)
                .map(s -> s.toUpperCase() )
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));

        assertEquals(result,"T H A N K");
    }
    
    @Test
    public void 메서드레퍼런수() {
    	//words.stream().
    }
}
