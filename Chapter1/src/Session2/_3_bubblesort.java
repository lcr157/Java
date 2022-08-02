package Session2;

import java.util.Arrays;
import java.util.Scanner;

public class _3_bubblesort {
	// 앞 인덱스값이 더 크면 뒤 인덱스값과 값을 변경해줌
	static void swap(int[] arr, int a, int b) {
		int res = 0;
		res = arr[a];
		arr[a] = arr[b];
		arr[b] = res;
	}
	
	// 버블소트를 위한 함수(여기 안에 swap()함수를 또 사용함)
	static void bubbleSort(int n, int []arr) {
		for(int i=n; i>=0; i--) {
			for(int j=0; j<i; j++)
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
		}
	}
	
	public static void main(String args[]) {
		// bubblesort를 함수로 뺴서 구현
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int []arr = new int[num];
		int n = arr.length-1;
		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();
		sc.close();
		
		// 처음 배열
		System.out.println("처음배열 : " + Arrays.toString(arr));
		
		// 버블소트 후 배열
		bubbleSort(n, arr);
		System.out.println("정렬된 배열 : " + Arrays.toString(arr));
		
	}
}
