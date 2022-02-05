package dailyAlgTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibsForSpecialCase20220205 {
	
	public class Equation {
		public Equation(String key, String value1, String op, String value2) {
			super();
			this.key = key;
			this.value1 = value1;
			this.op = op;
			this.value2 = value2;
		}

		private String key; // 좌변 변수명
		private String value1; // 우변의 value1
		private String op; // 우변의 연산자
		private String value2; // 우변의 value2
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue1() {
			return value1;
		}
		public void setValue1(String value1) {
			this.value1 = value1;
		}
		public String getOp() {
			return op;
		}
		public void setOp(String op) {
			this.op = op;
		}
		public String getValue2() {
			return value2;
		}
		public void setValue2(String value2) {
			this.value2 = value2;
		}
		
		public String toString() { // 갖고 있는 것으로 String으로 변환시킨다. 주요 메서드 중 하나.
			StringBuffer buf = new StringBuffer();
			buf.append("(");
			buf.append(value1);
			
			if(op.contentEquals("OR")) {
				buf.append(" + ");
			} else if(op.contentEquals("AND")) {
				buf.append(" * ");
			} else if(op.contentEquals("INTERACT")) {
				buf.append(" & ");
			} else if(op.contentEquals("NOT")) {
				buf.append(" - ");
			}
			
			buf.append(value2);
			buf.append(")");
			
			return buf.toString();
			
		}

	}

	public void solution(File inFile, File outFile) {
		Scanner scanner; // 파일을 읽게 하는 객체.
		FileWriter writer; // 파일 쓰기 객체.
		
		
		ArrayList<Equation> equationList = new ArrayList<>();// 과거 레코드를 저장할 빈 리스트 생성
		
		try { // try/catch 문법은 오류처리를 위한 문법이므로 무시해도 무방.
			
			scanner = new Scanner(inFile);   // 파일 객체로 scanner 새로 생성.
			writer = new FileWriter(outFile); // 파일 객체로 writer 새로 생성.
			
			while(scanner.hasNextLine()) {  // 레코드를 한줄 씩 읽음.
				String[] strs = scanner.nextLine().split(" ");  // 한줄의 레코드를 space 를 가지고 나눈 다음에 배열로 만든다.
				
				if(strs.length != 5) { // 갯수가 5개가 아니면 오류 판정
					System.out.println("wrong Equation input.");
					continue;
				}
				// 한 줄에 들어온 레코드가 tmp0 = RX INTERACT PC 라고 하면
				// strs[0] = tmp0
				// strs[1] = =
				// strs[2] = RX
				// strs[3] = INTERACT
				// strs[4] = PC
				// 가 된다.
				
				for(Equation unitEq : equationList) { // 과거 내가 저장했던 레코드 중에
					
					if(unitEq.getKey().contentEquals(strs[2])) {
						strs[2] = unitEq.toString(); // 만약 우변의 좌측변수가 과거 저장했던 레코드에 존재하면 String 치환하여 strs[2]에 저장한다.
						
					}
					
					if(unitEq.getKey().contentEquals(strs[4])) {
						strs[4] = unitEq.toString(); // 만약 우변의 우측변수가 과거 저장했던 레코드에 존재하면 String 치환하여 strs[4]에 저장한다.
					}
				}
				
				Equation eq = new Equation(strs[0], strs[2], strs[3], strs[4]); // stirng 변환시킨 결과를 Equation 객체로 감싼다.
				
				equationList.add(eq);// 레코드 저장.
						
			}
			
			String finalString = equationList.get(equationList.size()-1).toString();  // 마지막 레코드를 빼온다.
			
			writer.write(finalString); // 파일에 write 한다.
			
			writer.close();
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
