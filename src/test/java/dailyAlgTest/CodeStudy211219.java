package dailyAlgTest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CodeStudy211219 {

	// 문제 https://programmers.co.kr/learn/courses/30/lessons/64065#
	@Test
	public void Test1() {
		String problem = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		Set<Set<Integer>> tupleSet = tupleExtractor(problem);
		
	}
	
	
	public Set<Set<Integer>> tupleExtractor(String s){
		Set<Set<Integer>> tupleSet = new HashSet<>();
		
		String units = s.substring(1, s.length()-1);
		
		System.out.println(units);
		while(true) {
			
			String tuple = units.substring(units.indexOf('{') + 1, units.indexOf('}'));
			System.out.println(tuple);
			
			String[] tupleArray = tuple.split(",");
			
			break;
		}
		
		return tupleSet;
	}
}
