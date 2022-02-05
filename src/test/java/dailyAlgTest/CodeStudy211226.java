package dailyAlgTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CodeStudy211226 {
	
	// https://programmers.co.kr/learn/courses/30/lessons/12973
	
	@Test
	public void Test1() {
		String s = "baabaa";
		assertEquals(1, Solution2(s));
		
	}
	
	
	@Test
	public void Test2() {
		String s = "cdcd";
		assertEquals(0, Solution1(s));
	}
	
	
	public int Solution2(String s) {
		
		String result = "";
		
		result = returnStrs(s);
		
		if(result.length() == 0) return 1;
		
		return 0;
	}
	
	public String returnStrs(String s) {
		
		System.out.println("string s = " + s);
		int j = 0;
		
		for(int i = 0; i< s.length() -1; i++) {
			
			if(s.charAt(i) == s.charAt(i+1)){

				int found = 0;
				for(j = 0; j <= i && i + j + 1 < s.length(); j++) {
					if(s.charAt(i - j) == s.charAt(i + 1 + j)) {
						// 대칭성 검사를 하면 좀 나아지지 않을까?
						found = 1;
						continue;
					}
					
					
				}
				if(j != 0 && found != 0 && i > j) {
					return returnStrs(  returnStrs(s.substring(0, i - j) ) + returnStrs(s.substring(i+ 2 + j, s.length())) );
				}
				System.out.println("i = "+ i);
				System.out.println("ret substring : ["+ s.substring(0, i) + "], [" +s.substring(i+2, s.length())+"]" );
				return  returnStrs(  s.substring(0, i) + s.substring(i+2, s.length()) );
				//return  returnStrs(  returnStrs(s.substring(0, i) ) + returnStrs(s.substring(i+2, s.length())) );
			}
			
		}
		return s;
	}
	
	 
	
	public int Solution1(String s) {
		
		StringBuffer buf = new StringBuffer(s);
		int i = 0;
		
		String before = s;
		String after = "";
		
		while(!before.contentEquals(after)) {
			before = buf.toString();
			
			i = 0;
			while(i < buf.length() - 1) {
				System.out.println(" parsing "+ buf.toString() + ",i ="+ i);
				if (buf.charAt(i) == buf.charAt(i + 1)) {
					System.out.println("before del : " + buf.toString() + ",length = " + buf.length());
					buf.deleteCharAt(i+1);
					buf.deleteCharAt(i);
					System.out.println("after del : " + buf.toString() + ",length = " + buf.length());
					//continue;
				}
				i++;
			}
			after = buf.toString();
		}
		
		if (buf.toString().length() == 0) return 1;
		
		return 0;
	}

}
