package Session1;

import java.util.Scanner;

public class Class01 {
	// Scanner�� ���� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a_r = 10;
		String b_r = "good";
		
		int a = sc.nextInt();	// scanf("%d", &a);
		if(a == a_r) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		
		
		String b = sc.next();	// scnaf("%s", b); -> ù��° ���鿡�� ©����
		// String�� ������ƼŸ���� �ƴ϶� ==�� ����ȵ� -> �������� A.equals(B)�� ���ؼ� �Ǵ� (���̸� true, �����̸� false)
		if(b.equals(b_r)) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		
		
		sc.close();
	}
}
