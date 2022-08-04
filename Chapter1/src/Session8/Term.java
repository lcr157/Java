package Session8;

public class Term {
	// val�� ���, exp�� ����
	public int val;
	public int exp;
	
	// ������
	public Term(int v, int e) {
		this.val = v;
		this.exp = e;
	}
	
	// calc�� x���� �־ ����� �����ȯ
	public int calc(int x) {
		return val * (int)Math.pow(x, exp);
	}
	
	// toString()�� overRidding�Ͽ� ��������
	public String toString() {
		return val + "x^" + exp ;
	}
	
}
