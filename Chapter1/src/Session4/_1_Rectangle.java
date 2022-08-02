package Session4;

public class _1_Rectangle {
	public _1_Point dot;
	public int width;
	public int height;

	
	// 생성자
	public _1_Rectangle() {
	}

	// 생성자(매개변수있는것)
	public _1_Rectangle(int x, int y, int width, int height) {
		dot = new _1_Point();
		dot.x = x;
		dot.y = y;
		this.width = width;
		this.height = height;
	}


	// 객체명을 호출하면 출력되는 값들
	public String toString() {
		return("점 (" + this.dot.x + "," + this.dot.y + ") 가로세로 :  " + this.width + "," + this.height);
	}

	
	// 면적구하는 함수
	public int CalcArea() {
		return this.width * this.height;
	}
}
