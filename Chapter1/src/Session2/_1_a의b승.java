package Session2;

import java.util.Scanner;

public class _1_a��b�� {
	public int power(int a, int b) {
		int c = 1;
		// a�� b�� ������
		for(int i=0; i<b; i++)
			c *= a;
		
		return c;
	}
	
	public static void main(String args[]) {
		
		// a�� b�� ��� -> �Լ��� ���� ���
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		_1_a��b�� o = new _1_a��b��();
		
		System.out.println(o.power(a, b));

		sc.close();
	}
	
	
}
