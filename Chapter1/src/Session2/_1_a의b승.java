package Session2;

import java.util.Scanner;

public class _1_aÀÇb½Â {
	public int power(int a, int b) {
		int c = 1;
		// a¸¦ b¹ø °öÇØÁÜ
		for(int i=0; i<b; i++)
			c *= a;
		
		return c;
	}
	
	public static void main(String args[]) {
		
		// aÀÇ b½Â °è»ê -> ÇÔ¼ö·Î •û¼­ °è»ê
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		_1_aÀÇb½Â o = new _1_aÀÇb½Â();
		
		System.out.println(o.power(a, b));

		sc.close();
	}
	
	
}
