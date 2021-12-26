package dailyAlgTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodeStudy211221 {
/// 목표는 3진법을 1,2,4를 이용해 구현하기.
	// 문제 : https://programmers.co.kr/learn/courses/30/lessons/12899
	
	///3^0, 3^1, 3^2, ...
	
	@Test
	public void Test1() {
		
		//String digits = nDigitConverter(6 - 1);
		assertEquals("1", nDigitConverter(1));
		
		assertEquals("2", nDigitConverter(2));
		
		assertEquals("11", nDigitConverter(4));
		
		//assertEquals("4", nDigitConverter(2));
		//assertEquals("21", nDigitConverter(6));
		//assertEquals("14", nDigitConverter(5));
		
		//assertEquals("21", nDigitConverter(7));
		//assertEquals("22", nDigitConverter(8));
		//assertEquals("21", nDigitConverter(7));
		
	}
	
	public String nDigitConverter(int n) {
		
		int digitChar[] = new int[] {0, 1, 2, 4}; //각각 나머지 1일때 1, 2일때 0, 0일때 4.
		
		StringBuffer digits = new StringBuffer();
		
		int origin = n;
		int count = 0;
		int pownum = 0;
		int current = 0;
		int mod = 1;
		
		if(origin < 4 && origin >= 0)
			return Integer.toString(digitChar[origin]);
		
		for(int i = 1; origin > 0; i++) {
			mod = origin % 4;
			System.out.println("origin = " + origin + ", mod = " + mod );
			origin /= 4;
			
			digits.insert(0, Integer.toString(digitChar[mod]));
			//digits.append(Integer.toString(digitChar[mod]));
			System.out.println(" digit : " + digits.toString());
		}
		
		
		return digits.toString();
	}
	
	/// 31 을 2로 나누어 생각한다
	// LSB 부터.
	
	// 30 + 1, 28 + 2 + 1// 24 + 4 + 2+ 1
	//
	
	//6->
	
	//5-> 14
	// 몫 1, 나머지 .
	//6-> 21
	// 9
	// 몫 2, 나머지 0
	
	//몫 2, 나머지 0 그래서 14.
	//몫 2, 나머지 1
	
	
	
}
