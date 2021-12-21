package dailyAlgTest;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CodeStudy211219 {

	// 문제 https://programmers.co.kr/learn/courses/30/lessons/64065#
	
	public int[] solution(String s) {
		List<Set<Integer>> tupleSet = tupleExtractor(s);
        Collections.sort(tupleSet, new Comparator<Set<Integer>>() {

			@Override
			public int compare(Set<Integer> o1, Set<Integer> o2) {
				// TODO Auto-generated method stub
				Set<Integer> list1 = (Set<Integer>) o1;
				Set<Integer> list2 = (Set<Integer>) o2;
				if(list1.size() > list2.size()) {
					return 1;
				} else if(list1.size() < list2.size()) {
					return -1;
				} else {
					return 0;
				}
				
			}
		});
        
        Set<Integer>[] tups = tupleSet.toArray(new Set[0]);
        
        int [] elems = new int[tupleSet.size()];
		// 가정 : 문제 정의상 첫 elem은 무조건 원소 한개, 이후 한개씩 선형적 증가
		elems[0] = tups[0].iterator().next();
        
        for(int i = 1; i < tupleSet.size(); i++) {
			elems[i] = getUnretainUnit(tups[i -1], tups[i]);
		}
        
        return elems;
	}
	
	@Test
	public void Test1() {
		//String problem = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String problem  = "{{20,111},{111}}";
		int[] expect = new int[] {111, 20};
		int[] answer = solution(problem);
		
		assertArrayEquals(expect, answer);
	}
	
	@Test
	public void Test2() {
		String problem = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		int[] expect = new int[] {2, 1, 3, 4};
		int[] answer = solution(problem);
		
		assertArrayEquals(expect, answer);
	}
	
	@Test
	public void Test3() {
		String problem = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] expect = new int[] {3, 2, 4, 1};
		int[] answer = solution(problem);
		
		assertArrayEquals(expect, answer);
	}
	
	public int getUnretainUnit(Set<Integer> smaller, Set<Integer> bigger) {
		
		for(Integer unit : bigger) {
			if(smaller.contains(unit) == false ) {
				return unit;
			}
		}
		
		return 0;
	}
	
	
	public List<Set<Integer>> tupleExtractor(String s){
		List<Set<Integer>> tupleSet = new ArrayList<>();
		
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
