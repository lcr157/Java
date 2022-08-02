package Session2;

public class _2_�Ҽ����ϱ� {
	static boolean Prime(int num) {
		// �Ҽ��� 2���� �����ϱ⿡ �� ���� ��
		if(num < 2) return false;
		
		// �������������� �ݺ��� ������ ������ ������ ������ ���� ���Ĵ� 1*2 �̳� 2*1�̳İ� a*b���� a,b�� ������ �ٲ���̱⿡ �ߺ�������
		for(int i=2; i*i<=num; i++) {
			if(num%i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		// �Ҽ� ���ϴ� �Լ�
		for(int i=1; i<=10000; i++) {
			if(Prime(i))
				System.out.println(i);
		}
	}
}
