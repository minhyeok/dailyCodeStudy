package dailyAlgTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodeStudy220101 {
	
	
	// https://programmers.co.kr/learn/courses/30/lessons/84512
	@Test
	public void Test01(){
		assertEquals(6, solution01("AAAAE"));
	}
	
	public int solution01(String s) {
		/*글자수는 5 미만. 사전순에 따라 글자열의 순서를 출력하자.*/
		
		char dics[] = new char[] {'A','E','I','O','U'}; // 만약 순서대로 1,2,3,4,5 라면.
		
		// A, AA , AAA, AAAA, AAAAA,
		// AAAAE, AAAAI, AAAAO, AAAAU, AAAE
		// AAAEA, AAAEE, AAAEI, AAAEO, AAAEU
		// AAAI
		// -> A00000, AA000, AAA00, AAAA0, AAAAA
		// 마치, 글자수 모자라는 다른 자릿수는 AEIOU 보다 작은 것으로 채우는 효과.
		// 즉, 9999 없이 10000 부터 시작하는 글자를 카운팅 하는것과도 같을 것이다... 라고 일단 생각.
		// 이러면 정렬은 가능할수 있다. 하지만 몇번째일까?
		// 10000 11000 11100 11110 11111, 11112(AAAAE). 이걸 6진법 적인 접근법으로 6이란걸 도출할 수있을까?
		// I -> 30000 -> 1563. 이건 어떻게?
		
		
		return 0;
	}
	
	// A -> 다음 글자 없음 : 경우의 수 1. 다음 수들이 모두 0이므로 단절됨.
	// AA -> 다음글자 있음 : 경우의 수 1 + 1.
	// AE -> AA~ AE 되기 전까지의 모든 경우의 수를 가져와야 한다:
	// 단적으로... AAAE는 10번째. AAAE는 AAAA(AEIOU)를 모두 겪어야 했던 것. 4 ㄷ()+1(가있는)*5 라는 효과.
	// 이 방법을 이용한다면...?
	// 예시는..?
	
	// 이 계산 법 대로라면, I는? 1563이 나오려면?
	// 2(AE) * 6(0AEIOU) * 5 * 6 * 6. 아이...씨팔!
	
	public int solution02(String s) {
		char dics[] = new char[] {'A','E','I','O','U'};
		
		
		// 
		
		return 0;
	}
	
	
	

}
