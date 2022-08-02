package Session1;

import java.util.Scanner;

public class Class01 {
	// Scanner에 대한 설명
	
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
		
		
		String b = sc.next();	// scnaf("%s", b); -> 첫번째 공백에서 짤린다
		// String은 프리미티타입이 아니라 ==는 적용안됨 -> 같은지는 A.equals(B)를 통해서 판단 (참이면 true, 거짓이면 false)
		if(b.equals(b_r)) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
		
		
		sc.close();
	}
}
