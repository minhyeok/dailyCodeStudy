package dailyAlgTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CodeStudy211230 {
	
	
	//https://programmers.co.kr/learn/courses/30/lessons/87946

	@Test
	public void Test1() {
		
		int solved = solution2(80, new int[][]{{80,20},{50,40},{30,10}});
		
		assertEquals(3, solved);
	}
	
	
	public int solution(int k, int[][] dungeons) {
		// k = 내 피로도. 
		// dungeons는 각 요소마다, 0 : 최소 피로필요도, 1 : 소모피로도.
		// 리턴값 : 사용자가 탐험 가능한 최대 던전 수.
		ArrayList<int[]> challenge = new ArrayList<>();
		int stamina = k;
		
		for(int[] dgs : dungeons) {
			challenge.add(dgs);
		}
		/// 효율적인 던전 선택 전략.
		/// 1. 현재 탐험 가능한 던전 후보를 추리고,
		/// 2. 그중에 가장 체력소모가 적은 던전을 선택... 하면, 
		/// 첫케이스에서 다른 던전을 탐험할 수 없게 되어버림. (3번을 먼저 선택한 경우)
		/// 그렇다고, 현재 체력과 가장 격차가 적은 피로도의 던전을 선택하게 되면
		/// 체력 소모량으로 인해 다른 던전을 선택할 수 없는 사태가 생김.(1번 이후 2번을 선택한 경우).
		/// 고로 전략은 다음과 같다.
		/// 1. 첫 던전을 선택 했을 때, 다음 던전을 선택이 가능 한지 아닌지 판단해야 한다....고 해도, 3번 후 2번이라는 선택지가 있으므로 어폐있음.
		/// 
		
		
		return 3;
	}
	
	public int solution2(int k, int[][] dungeons) {
		/*brute force!*/
		int max = 0;
		
		ArrayList<int[]> challenge = new ArrayList<>();
		int stamina = k;
		
		for(int[] dgs : dungeons) {
			challenge.add(dgs);
		}
		
		max = dungeonTraverse(stamina, challenge, 0);
		
		return max;
	}
	/// 뭐야... 이게 끝이야? // 결국 이게 dfs였다.
	public int dungeonTraverse(int stamina, ArrayList<int[]> dungeons, int count) {
		
		int maxed = count;
		int temp = 0;
		for(int i = 0; i < dungeons.size(); i++) {
			ArrayList<int[]> subList = (ArrayList<int[]>) dungeons.clone();
			
			int[] selected = subList.remove(i);
			if(selected[0] > stamina) continue; /* not applicable dungeon*/
			//if(selected[1] > stamina) continue;
			
			temp = dungeonTraverse(stamina - selected[1], subList, count+1);
			if(temp > maxed ) maxed = temp;
		}
		return maxed;
	}
	
	/// 끝이야...?
}
