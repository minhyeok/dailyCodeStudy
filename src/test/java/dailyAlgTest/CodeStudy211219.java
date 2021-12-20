package dailyAlgTest;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CodeStudy211219 {

	// 문제 https://programmers.co.kr/learn/courses/30/lessons/64065#
	@Test
	public void Test1() {
		//String problem = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String problem  = "{{20,111},{111}}";
		Set<Set<Integer>> tupleSet = tupleExtractor(problem);
		
		Set<Integer>[] tups = tupleSet.toArray(new Set[0]);
		
		System.out.println("tupleSet :" + tupleSet);
		
		
		int [] elems = new int[tupleSet.size()];
		// 가정 : 문제 정의상 첫 elem은 무조건 원소 한개, 이후 한개씩 선형적 증가
		elems[0] = tups[0].iterator().next();
		
		for(int i = 1; i < tupleSet.size(); i++) {
			elems[i] = getUnretainUnit(tups[i -1], tups[i]);
		}
		
		System.out.println("elems : " + elems[1]);
		
	}
	
	public int getUnretainUnit(Set<Integer> smaller, Set<Integer> bigger) {
		
		for(Integer unit : bigger) {
			if(smaller.contains(unit) == false ) {
				return unit;
			}
		}
		
		return 0;
	}
	
	
	public Set<Set<Integer>> tupleExtractor(String s){
		Set<Set<Integer>> tupleSet = new HashSet<>();
		
		String units = s.substring(1, s.length()-1);
		
		System.out.println("units:" + units);
		
		String nextTuple = units;
		while(true) {
			if(nextTuple.indexOf('}') == -1) break;
			
			String tuple = nextTuple.substring(nextTuple.indexOf('{') + 1, nextTuple.indexOf('}'));
			
			System.out.println("per tuple :"+ tuple);
			
			String[] tupleArray = tuple.split(",");
			
			Set<Integer> tupleunit = new HashSet<>();
			
			for(String tup : tupleArray) {
				tupleunit.add(Integer.valueOf(tup));
			}
			
			tupleSet.add(tupleunit);
			
			if(nextTuple.indexOf('}') + 2 > nextTuple.length()) break;
			nextTuple = nextTuple.substring(nextTuple.indexOf('}') + 2, nextTuple.length());
		}
		
		return tupleSet;
	}
}
