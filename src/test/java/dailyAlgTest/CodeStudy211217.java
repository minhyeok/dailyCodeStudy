package dailyAlgTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CodeStudy211217 {
	@Test
	public void Test1() {
		String factos = new String("20!!!!");
		
		String digits  = factos.substring(0, factos.indexOf('!'));
		String exmarks = factos.substring(factos.indexOf('!'), factos.length());
		
		System.out.println(digits);
		System.out.println(exmarks);
		System.out.println( Integer.valueOf(digits));
		System.out.println( exmarks.length());
	}
	
	
	public int mfactorial(int nums, int exmarks) {
		if(nums < 1) return 1;
		return nums * mfactorial(nums - exmarks, exmarks);
	}
	
	@Test
	public void Test2() {
		Set<Integer> answerPool = new HashSet<>();
		int attempt = 0;
		int target = 21;
		
		while(true) {
			attempt++;
			int[] digitArray = getDigitArray(target);
			int currAnswer = getDigitSquare(digitArray);
			if(currAnswer == 1) {
				System.out.println(" answer = " + attempt);
				break;
			}
			target = currAnswer;
			answerPool.add(target);
			if(answerPool.size() != attempt) {
				System.out.println(" loop! = " + -1);
				break;
			}
			
		}
		
		
	}
	
	public int [] getDigitArray(int n) {
		char [] digitByte = Integer.toString(n).toCharArray();
		int [] digitArray = new int[digitByte.length];
		
		for(int i = 0; i < digitByte.length; i++) {
			digitArray[i] = digitByte[i] - '0';
			
		}
		return digitArray;
	}
	
	public int getDigitSquare(int[] n) {
		int answer= 0 ;
		for(int digit : n) {
			answer += (digit * digit);
		}
		return answer;
	}
	
	@Test
	public void Test3() {
		int N = 3;
		int K = 2;
		
		int limit = (int) Math.pow(2, N) - 1;
		
		System.out.println("powed limit = "+ limit);
		
		for(int i = 3; i <= limit; i+=3) {
			String binString = Integer.toBinaryString(i);
			System.out.println(binString);
		}
		
		
		
		int count = 0;
	}
	
	public boolean isOneContain(String binString, int count) {
		int current = 0;
		for(char ch : binString.toCharArray()) {
			if(ch == '1') current ++;
			if(current > count) return false;
		}
		if(current == count) return true;
		return false;
	}
	
	@Test
	public void Test4() {
		int bit;
		int n, k;
		n = 6;
		k = 3;
		
	//	while(bit)
	}
	
	
	public int getZeros(int n) {
		int num = 0;
		while((n & 1) == 0) {
			num++;
			n = n >> 1;
		}
		return num;
	}
	
	public void func(int bit, int n) {
		int msb = 1 << (n - 1);
		while(msb != 0) {
			System.out.printf( "%s ", Integer.toBinaryString(msb & bit));
			msb = msb >> 1;
		}
		System.out.println("");
	}
	
	
	@Test
	public void Test5() {
		int[] arr = new int[] {0,1,2,3,4,5};
		
		ArrayList<List<Integer>> comb = nCkV2(arr, 3);
		
		System.out.println("comb :" +comb);
		
		ArrayList<Long> combs = nCkOne(6, 3);
		
		for(Long combone : combs) {
			System.out.println("combOne:" + Long.toBinaryString(combone));
		}
	}
	
	
	
	static ArrayList<List<Integer>> nCkV2(int[] arr,int k){
        ArrayList<List<Integer>> ret = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i < 1 <<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if((i & 1 << j )>0) cnt++;
            }
            if(cnt==k){
                List<Integer> tmp = new ArrayList<>();
                for(int j=0;j<n;j++){
                    if((i & 1<<j) > 0){
                        tmp.add(arr[j]);
                    }
                }
                ret.add(tmp);
            }
        }
        return ret;
    }
	
	static ArrayList<Long> nCkOne(int N,int k){
        ArrayList<Long> ret = new ArrayList<>();
        int n = N;
        for(int i=0;i < 1 <<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if((i & 1 << j )>0) cnt++;
            }
            if(cnt==k){
            	long tmp = 0;
//                List<Integer> tmp = new ArrayList<>();
            	/*
                for(int j=0;j<n;j++){
                    if((i & 1<<j) > 0){
                        //tmp.add(arr[j]);
                    	tmp += (long) Math.pow(2, j);
                    	
                    }
                }*/
                System.out.println("i =" + i);
                ret.add((long)i);
            }
        }
        return ret;
    }
	
	@Test
	public void Test6() {
		
		int n = 6;
		int k = 3;
		boolean [] visited = new boolean[n];
		
		ArrayList<Integer> integs = new ArrayList<>();
		
		//for (int i = 1; i <= n; i++) {
			combination(n, visited, 0, n, k, integs);
		//}
	}
	
	
	static void combination(int nums, boolean[] visited, int start, int n, int r, ArrayList<Integer> combs) {
	    if(r == 0) {
	        print(nums, visited, n, combs);
	    	
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(nums, visited, i + 1, n, r - 1, combs);
	        visited[i] = false;
	    }
	}
	
	static void print(int nums, boolean[] visited, int n, ArrayList<Integer> combs) {
		int temp = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
//                System.out.print(arr[i] + " ");
            	//combs.add(arr[i]);
            	temp += (int)Math.pow(2, i);
            }
        }
        combs.add(temp);
        System.out.println();
    }
	

	
	
	
}
