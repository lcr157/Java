package Session8;

public class Term {
	// val은 계수, exp는 차수
	public int val;
	public int exp;
	
	// 생성자
	public Term(int v, int e) {
		this.val = v;
		this.exp = e;
	}
	
	// calc는 x값을 넣어서 계산한 결과반환
	public int calc(int x) {
		return val * (int)Math.pow(x, exp);
	}
	
	// toString()을 overRidding하여 재정의함
	public String toString() {
		return val + "x^" + exp ;
	}
	
}
