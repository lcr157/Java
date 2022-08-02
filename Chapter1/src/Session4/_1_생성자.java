package Session4;

import java.io.File;
import java.util.Scanner;

public class _1_������ {

	static _1_Rectangle []rects = new _1_Rectangle[100];
	static int n = 0;

	public static void main(String args[]) {
		// ���� - ���� ��ǥ�࿡ ������ n���� ���簢���� ���� ������ �Է¹ް�
		// ������ ���� �ͺ��� ū �� ������ �����Ͽ� ����Ѵ� ���α׷� �ۼ�
		// ex) 0 1 2 4 -> (0,1)�� ������ ��������ġ, 2�� ���α���, 4�� ���α���

		// _4_pointŬ���� ������ ������ x,y��, _4_Rectangle�� ������ �������� ����, ���� ���̰� �����Ѵ�.
		// data.txt��� ���Ͽ� ����� ���� �������� ���α׷� �ۼ�
		try {

			Scanner in = new Scanner(new File("data.txt"));

			while(in.hasNext()) {
				rects[n] = new _1_Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
				
				n++;
			}

			in.close();
		} catch (Exception e) {
			System.out.println("No data File");
			System.exit(1);	// ���α׷� ���� �ڵ�
		}
		
		
		// ���� �����Ͱ� Ȯ��
		System.out.println("�Էµ� �� Ȯ��");
		for(int i=0; i<n; i++) {
			System.out.println(rects[i]);
		} System.out.println();
		
		// �����Ʈ(bubblesort)�� ������ ������������ ����
		bubbleSort();

		// ���ĵ� �� Ȯ��
		System.out.println("���ĵ� �� Ȯ��");
		for(int i=0; i<n; i++)
			System.out.println(rects[i]);
	}

	
	// bubbleSort
	private static void bubbleSort() {
		for(int i=n-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(rects[j].CalcArea() > rects[j+1].CalcArea() ) {
					_1_Rectangle res = new _1_Rectangle();
					res = rects[j];
					rects[j] = rects[j+1]; 
					rects[j+1] = res;
				}
			}
		}
	}
	
}	
