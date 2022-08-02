package Session2;

import java.util.Arrays;
import java.util.Scanner;

public class _3_bubblesort {
	// �� �ε������� �� ũ�� �� �ε������� ���� ��������
	static void swap(int[] arr, int a, int b) {
		int res = 0;
		res = arr[a];
		arr[a] = arr[b];
		arr[b] = res;
	}
	
	// �����Ʈ�� ���� �Լ�(���� �ȿ� swap()�Լ��� �� �����)
	static void bubbleSort(int n, int []arr) {
		for(int i=n; i>=0; i--) {
			for(int j=0; j<i; j++)
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
		}
	}
	
	public static void main(String args[]) {
		// bubblesort�� �Լ��� ���� ����
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int []arr = new int[num];
		int n = arr.length-1;
		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();
		sc.close();
		
		// ó�� �迭
		System.out.println("ó���迭 : " + Arrays.toString(arr));
		
		// �����Ʈ �� �迭
		bubbleSort(n, arr);
		System.out.println("���ĵ� �迭 : " + Arrays.toString(arr));
		
	}
}
