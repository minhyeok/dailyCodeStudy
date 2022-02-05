package dailyAlgTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CodeStudy220109 {

	
	// https://programmers.co.kr/learn/courses/30/lessons/62048
	@Test
	public void Test1() {
		
		long result = solution(8, 12); // 3, 4 비율이라면 12에서 최소적 공배 결정됨.
		
		//96개 중 16개 손실 총 80. 기울기 1일때 증가 라면 8 정사각형 대비 8+8개. 12개 정사각형 대비 4개 증가.
		
		assertEquals(80, result);
		
	}
	
	@Test
	public void Test2() {
		assertEquals(12, solution(4,4));
	}
	
	public long solution(int w, int h) {
		// w, h : 1억 이하 자연수. 어쩌면 이것은, 최소공배수 구하기.
		long full = w * h;
		int unusable = 0;
		int discr = 0;
		double delta = 0;
		if(w < h)
		    delta = (double)w/(double)h;  //8 / 12 였으므로 0.6667. // 12/8은 1.5.
		else
			delta = (double)h/(double)w;
		
		double comb = 0;
		
		for(int i = 0 ; i < Math.max(w,h); i++) {
			comb += delta; // 그래프 증가. 이론적으로는 맞아보이지만...
			
			discr = (int)comb;
			if(comb == (double) 1) discr = 0;
			unusable += discr + 1;
			
			comb -= discr;
			
			if(comb > (double) 0.999999999995) comb = 0;
			
		}// 사례로 보면, 1개 2개 1개, 1개 2개 1개 로 반복되어야 함.
		
		// double로 인해 태생적으로 정확도가 떨어진다.
		
		return full - unusable;
	}
	
	public long solution2(int w, int h) {
		
		
		
		return 0;
	}
}
