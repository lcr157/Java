package Session2;

import java.util.Scanner;

public class _4_2�����迭�����Ҽ�ã�� {
	// arr�迭�� 2�����迭
	static int [][]arr;
	// X,Y�� �� ~ ������ �ð�������� 8���⿡ ���� ��ġ��ȭ �ε���
	static int []offsetX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int []offsetY = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	
	// �� ��ġ��
	static int value(int x, int y, int dir, int len) {
		// �� �ڸ� �� �����ͼ� ���� ��ģ��.
		int val = 0;
		for(int i=0; i<len; i++) {
			int res = getVal(x, y, dir, i);
			if(res == -1)
				return -1;
			val = val * 10 + res;
		}
		
		return val;
	}
	
	// �ڸ����� �������� -> �� �������� �ε��� �ʰ��Ǹ� -1�� ��ȯ�����ش�.
	static int getVal(int x, int y, int dir, int i) {
		int newX = x + i*offsetX[dir];
		int newY = y + i*offsetY[dir];
		
		if(newX < 0 || newX >= arr[0].length || newY < 0 || newY >= arr[0].length)
			return -1;
		else
			return arr[newX][newY];
	}
	
	// �Ҽ� ���ϱ�
	static boolean isPrime(int val) {
		if(val < 2) return false;
		for(int i=2; i*i<=val; i++)
			if(val%i == 0)
				return false;
		
		return true;
	}
	
	public static void main(String args[]) {
		// n*n 2���� �迭���� ����, ����, �밢���� 8�������� ���ӵ� ���ڵ��� �ϳ��� ���� ���� ���� �� �ִ� ��� �Ҽ� ã�Ƽ� �����ϴ� ���α׷� �ۼ��ϱ�(�ߺ��� �� ����ص� �������)
		// ������ 8����(��, ���, ��, ����, ��, ����, ��, �»�)������ ����Ұ���
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		sc.close();
		
		
		// ��� ����� ����� ���� ����ϱ�
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
