package Session2;

public class _2_소수구하기 {
	static boolean Prime(int num) {
		// 소수는 2부터 시작하기에 이 조건 들어감
		if(num < 2) return false;
		
		// 제곱값기준으로 반복문 돌리는 이유는 어차피 제곱근 이전 이후는 1*2 이냐 2*1이냐고 a*b에서 a,b의 순서만 바뀐것이기에 중복연산임
		for(int i=2; i*i<=num; i++) {
			if(num%i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		// 소수 구하는 함수
		for(int i=1; i<=10000; i++) {
			if(Prime(i))
				System.out.println(i);
		}
	}
}
