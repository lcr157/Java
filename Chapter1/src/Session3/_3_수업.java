package Session3;

import java.io.File;
import java.util.Scanner;

public class _3_수업 {
	static _2_person []members = new _2_person[100];
	static int n = 0;
	
	public static void main(String args[]) {
		// 문제 : input.txt라는 파일의 내용을 읽어와 사전순으로 정렬
		try {
			// new File(파일명)을 통해서 파일을 가져올 수 있다.
			Scanner in = new Scanner(new File("input.txt"));
			// in.hasNext()는 읽어온 파일의 내용이 존재할때까지 반복
			while(in.hasNext()) {
				// 첫번째 단어는 nm에, 다음 단어는 nb로 저장 후 members배열에 name과 number로 저장한다.
				String nm = in.next();
				String nb = in.next();
				
				members[n] = new _2_person();
				members[n].name = nm;
				members[n].number = nb;
				n++;
			}
			in.close();
			
		} catch (Exception e) {
			System.out.println("No data file");
			System.exit(1);
		}
		
		bubbleSort();
		
		for(int i=0; i<n; i++)
			System.out.println(members[i].name + " : " + members[i].number);
	}

	// 버블정렬로 정렬하기
	private static void bubbleSort() {
		for(int i=n-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				// 
				if(members[j].name.compareTo(members[j+1].name) < 0) {
					
				}
			}
		}
		
	}

}
