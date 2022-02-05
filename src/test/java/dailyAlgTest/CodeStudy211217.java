package dailyAlgTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

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
		
		// 2의 자릿수가. 
		
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
            	//long tmp = 0;
//                List<Integer> tmp = new ArrayList<>();
            	/*
                for(int j=0;j<n;j++){
                    if((i & 1<<j) > 0){
                        //tmp.add(arr[j]);
                    	tmp += (long) Math.pow(2, j);
                    	
                    }
                }*/
                //System.out.println("i =" + i);
                ret.add((long)i);
            }
        }
        return ret;
    }
	
	
	@Test
	public void Test5() {
		ArrayList<Long> combs = nCkOne(30, 3);
		
		for(Long combone : combs) {
			if(combone % 3 == 0)
			    System.out.println("combOne:[" + Long.toBinaryString(combone) +"],  [" + combone + "]");
		}
	}
	
	
	
	@Test
	public void Test6() {
		
		// 문제가 무엇이었나 ? : 이진법으로 표현된 숫자가 '1'이 3개인 것들 중에서, 3의 배수인 것들을 찾아라.
		
		int n = 30;
		int k = 3;
		boolean [] visited = new boolean[n];
		
		ArrayList<Integer> integs = new ArrayList<>();
		
		//for (int i = 1; i <= n; i++) {
			
		//}
		combination( visited, 0, n, k, integs);
		
		for(Integer combone : integs) {
			if(combone % 3 == 0)
			    System.out.println("combOne:[" + Long.toBinaryString(combone) +"],  [" + combone + "]");
		}
	}
	
	
	// 백트래킹 사용?  ;;; 속도가 "월등히" 빠르다.
	static void combination(//int[] arr, 
			boolean[] visited, int start, int n, int r, ArrayList<Integer> integs) {
        if (r == 0) {
            print(//arr, 
            		visited, n, integs);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(//arr,
            		visited, i + 1, n, r - 1, integs);
            visited[i] = false;
        }
    }
	
	static void print(//int[] arr, 
			boolean[] visited, int n, ArrayList<Integer> integs) {
		StringBuffer digits = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	digits.append("1");
            //	System.out.print("1");
                //System.out.print(arr[i] + " ");
            } else {
            	digits.append("0");
          //  	System.out.print("0");
            }
        }
        
        integs.add(Integer.parseInt(digits.toString(), 2));
        
        //System.out.println();
    }
	

	
	
	
}
