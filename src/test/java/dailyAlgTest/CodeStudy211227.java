package dailyAlgTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CodeStudy211227 {
	
	@Test
	public void Test1() {
		int [] progress = new int[] {93,30,55};
		int [] speeds = new int[] {1,30,5};
		
		int[] answer = solution(progress, speeds);
		int[] expects = new int[] {2,1};
		
		assertArrayEquals(expects,answer);
	}
	
	public int[] solution(int[] progress, int[] speeds) {
		int[] answer= {};
		
		
		
		return answer;
	}

}
