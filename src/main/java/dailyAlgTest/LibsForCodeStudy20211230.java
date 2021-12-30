package dailyAlgTest;

import java.util.ArrayList;

public class LibsForCodeStudy20211230 {
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
}
