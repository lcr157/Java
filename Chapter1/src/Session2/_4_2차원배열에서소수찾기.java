package Session2;

import java.util.Scanner;

public class _4_2차원배열에서소수찾기 {
	// arr배열은 2차원배열
	static int [][]arr;
	// X,Y가 위 ~ 위까지 시계방향으로 8방향에 대한 위치변화 인덱스
	static int []offsetX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int []offsetY = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	
	// 값 합치기
	static int value(int x, int y, int dir, int len) {
		// 각 자리 수 가져와서 직접 합친다.
		int val = 0;
		for(int i=0; i<len; i++) {
			int res = getVal(x, y, dir, i);
			if(res == -1)
				return -1;
			val = val * 10 + res;
		}
		
		return val;
	}
	
	// 자릿수값 가져오기 -> 이 과정에서 인덱스 초과되면 -1로 반환시켜준다.
	static int getVal(int x, int y, int dir, int i) {
		int newX = x + i*offsetX[dir];
		int newY = y + i*offsetY[dir];
		
		if(newX < 0 || newX >= arr[0].length || newY < 0 || newY >= arr[0].length)
			return -1;
		else
			return arr[newX][newY];
	}
	
	// 소수 구하기
	static boolean isPrime(int val) {
		if(val < 2) return false;
		for(int i=2; i*i<=val; i++)
			if(val%i == 0)
				return false;
		
		return true;
	}
	
	public static void main(String args[]) {
		// n*n 2차원 배열에서 가로, 세로, 대각선의 8방향으로 연속된 숫자들을 하나의 수로 합쳐 만들 수 있는 모든 소수 찾아서 나열하는 프로그램 작성하기(중복된 수 출력해도 상관없음)
		// 방향은 8방향(상, 우상, 우, 우하, 하, 좌하, 좌, 좌상)순으로 계산할것임
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		sc.close();
		
		
		// 모든 경우의 방향과 길이 고려하기
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				for(int dir=0; dir<8; dir++) {
					for(int len=1; len<=n; len++) {
						int val = value(x, y, dir, len);
						if(val != -1 && isPrime(val))
							System.out.println(val);
					}
				}
			}
		}
		
		
	} 
}
