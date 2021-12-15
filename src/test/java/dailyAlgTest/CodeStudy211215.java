package dailyAlgTest;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CodeStudy211215 {
	
	/* 문제 내용 : https://programmers.co.kr/learn/courses/30/lessons/77484*/
	@Test
	public void lottoTest() {
		
		int[] lottos1 = new int[]{44, 1, 0, 0, 31, 25};
		int[] wins1 = new int[]{31, 10, 45, 1, 6, 19};
		
		int[] lottos2 = new int[]{0, 0, 0, 0, 0, 0};
		int[] wins2 = new int[]{38, 19, 20, 40, 15, 25};
		
		int[] lottos3 = new int[]{45, 4, 35, 20, 3, 9};
		int[] wins3 = new int[]{20, 9, 3, 45, 4, 35};
		
		int[] answer1 = solution(lottos1, wins1);
		int[] answer2 = solution(lottos2, wins2);
		int[] answer3 = solution(lottos3, wins3);
		
		assertArrayEquals(answer1, new int[]{3, 5});
		assertArrayEquals(answer2, new int[]{1, 6});
		assertArrayEquals(answer3, new int[]{1, 1});
		
	}
	
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int maxCorrect = 0;
        int currentCorrect = 0;
        int zeroes = 0;
        
        /*count zeroes*/
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0) zeroes++;
        }
        
        for(int i = 0; i < 6; i++){
            for(int j=0; j< 6; j++){
                if(lottos[i] == win_nums[j]) 
                    currentCorrect++;
            }
        }
        maxCorrect = currentCorrect + zeroes;
        
        answer[0] = 6-maxCorrect + 1;
        answer[1] = 6-currentCorrect + 1;
        
        if(answer[0] > 6) answer[0] = 6;
        if(answer[1] > 6) answer[1] = 6;
                
        return answer;
    }

}
