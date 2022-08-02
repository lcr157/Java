package Session4;

import java.io.File;
import java.util.Scanner;

public class _1_생성자 {

	static _1_Rectangle []rects = new _1_Rectangle[100];
	static int n = 0;

	public static void main(String args[]) {
		// 문제 - 평면상 좌표축에 평행한 n개의 직사각형에 대한 데이터 입력받고
		// 면적이 작은 것부터 큰 것 순으로 정렬하여 출력한느 프로그램 작성
		// ex) 0 1 2 4 -> (0,1)이 왼쪽위 꼭지점위치, 2가 가로길이, 4가 세로길이

		// _4_point클래는 왼쪽위 꼭지점 x,y값, _4_Rectangle은 왼쪽위 꼭지점과 가로, 세로 길이값 저장한다.
		// data.txt라는 파일에 저장된 값을 기준으로 프로그램 작성
		try {

			Scanner in = new Scanner(new File("data.txt"));

			while(in.hasNext()) {
				rects[n] = new _1_Rectangle(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
				
				n++;
			}

			in.close();
		} catch (Exception e) {
			System.out.println("No data File");
			System.exit(1);	// 프로그램 종료 코드
		}
		
		
		// 넣은 데이터값 확인
		System.out.println("입력된 값 확인");
		for(int i=0; i<n; i++) {
			System.out.println(rects[i]);
		} System.out.println();
		
		// 버블소트(bubblesort)로 면적을 오름차순으로 정렬
		bubbleSort();

		// 정렬된 값 확인
		System.out.println("정렬된 값 확인");
		for(int i=0; i<n; i++)
			System.out.println(rects[i]);
	}

	
	// bubbleSort
	private static void bubbleSort() {
		for(int i=n-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(rects[j].CalcArea() > rects[j+1].CalcArea() ) {
					_1_Rectangle res = new _1_Rectangle();
					res = rects[j];
					rects[j] = rects[j+1]; 
					rects[j+1] = res;
				}
			}
		}
	}
	
}	
