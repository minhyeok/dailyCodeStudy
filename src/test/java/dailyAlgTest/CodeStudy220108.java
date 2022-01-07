package dailyAlgTest;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

public class CodeStudy220108 {
	
	@Test
	public void Test1() {
		
		String[]words = new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		assertArrayEquals(new int[] {3,3}, solution(3, words));
		
	}
	
	
	@Test
	public void Test2() {
		
		String[]words = new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		
		assertArrayEquals(new int[] {0,0}, solution(5, words));
		
	}
	
	
	
	public int[] solution(int n, String[] words) {
        
        ArrayList<String> answers = new ArrayList<>();
        
        int[] answer = new int[2];
        int wrong = 0;
        int attempt = 0;
        
        String lastWords = null;
        
        for(int i = 0; i < words.length; i++){
            
            if( answers.contains(words[i]) ){ /*answer is wrong*/
            	
                wrong = (i % n)  + 1;
                attempt = (i / n) + 1;
                break;
            } else if(answers.size() == 0){
                answers.add(words[i]);
                lastWords = words[i];
            } else {
            	
            	if( lastWords != null &&
                		words[i-1].charAt(words[i-1].length() -1) != 
                   words[i].charAt(0)
                  ){
                    wrong = (i % n)  + 1;
                    attempt = (i / n) + 1;
                    break;
                }
                lastWords = words[i];
                answers.add(words[i]);
            }
        }
        
        
        answer[0] = wrong;
        answer[1] = attempt;
        
        return answer;
    }

}
