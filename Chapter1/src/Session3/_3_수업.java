package Session3;

import java.io.File;
import java.util.Scanner;

public class _3_���� {
	static _2_person []members = new _2_person[100];
	static int n = 0;
	
	public static void main(String args[]) {
		// ���� : input.txt��� ������ ������ �о�� ���������� ����
		try {
			// new File(���ϸ�)�� ���ؼ� ������ ������ �� �ִ�.
			Scanner in = new Scanner(new File("input.txt"));
			// in.hasNext()�� �о�� ������ ������ �����Ҷ����� �ݺ�
			while(in.hasNext()) {
				// ù��° �ܾ�� nm��, ���� �ܾ�� nb�� ���� �� members�迭�� name�� number�� �����Ѵ�.
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

	// �������ķ� �����ϱ�
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
