package Session4;

public class _1_Rectangle {
	public _1_Point dot;
	public int width;
	public int height;

	
	// ������
	public _1_Rectangle() {
	}

	// ������(�Ű������ִ°�)
	public _1_Rectangle(int x, int y, int width, int height) {
		dot = new _1_Point();
		dot.x = x;
		dot.y = y;
		this.width = width;
		this.height = height;
	}


	// ��ü���� ȣ���ϸ� ��µǴ� ����
	public String toString() {
		return("�� (" + this.dot.x + "," + this.dot.y + ") ���μ��� :  " + this.width + "," + this.height);
	}

	
	// �������ϴ� �Լ�
	public int CalcArea() {
		return this.width * this.height;
	}
}
