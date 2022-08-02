package Session1;

import java.util.Scanner;

public class Class02 {
	// 배열에 관한 설명

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		// 배열선언 -> 한번에 선언도 가능하다.
		int []array1;
		array1 = new int[5];

		int []array2 = new int[5];


		// 배열출력 -> 배열길이는 A.length 를 이용해서 구할 수 있음
		array1[0] = 10; array1[1] = 20; array1[2] = 30; array1[3] = 40; array1[4] = 50;
		for(int i=0; i<array1.length; i++) {
			System.out.println(i+1 + "번째 = " + array1[i]);
		}System.out.println();


		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		// 문제 -> n개 입력받아 최소값 구하기
		/*
		int num = sc.nextInt();
		int []arr = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();

		int min = arr[0];
		for(int i=1; i<arr.length; i++)
			if(min > arr[i])
				min = arr[i];


		System.out.printf("최소값 = %d\n\n", min);
		 */


		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		/*
		// 문제 -> 소수 구하기
		// 특정 수의 약수는 n/2보다 클수가 없기에 n/2까지만 연산함
		int num = 129;
		boolean isPrime = true;
		// 코드 간소화
		// 1.break사용
		for(int i=2; i<=num/2; i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}


		// 2. 조건에 추가
		//for(int i=2; i<=num/2 && isPrime; i++)
		//	if(num % i == 0)
		//		isPrime = false;


		if(isPrime)
			System.out.println("소수맞음");
		else
			System.out.println("소수아님");
		 */


		////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		/*
		// 문제 -> n개 정수 배열입력받아 0개 이상 연속된 정수들을 더해 얻을 수 있는 최대값 구하기
		int num = sc.nextInt();
		int []arr = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();
		sc.close();

		int max=0;
		for(int i=0; i<num; i++) {
			int sum = 0;
			for(int j=i; j<num; j++) {
				sum += arr[j];
				if(sum > max)
					max = sum;
			}
		}

		System.out.println(max);
		 */


		////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		/*
		// 문제 -> n개 정수 배열입력받아 1개 이상 연속된 정수들을 하나의 정수로 통합하고 그 결과가 소수인 값들중 최대값 구하기
		int num = sc.nextInt();
		int []arr = new int[num];

		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();
		sc.close();

		int max=0;
		for(int i=0; i<num; i++) {
			for(int j=i; j<num; j++) {
				int value=0;
				for(int k=i; k<=j; k++) {
					value = value * 10 + arr[k];
				}

				// 
				boolean isPrime = true;
				for(int l=2; l<value/2 && isPrime; l++)
					if(value % l == 0)
						isPrime = false;

				// value가 1이면 소수가 아니기에 1보다 큰경우 체크한다.
				if(isPrime && value > 1 && max < value)
					max = value;

			}
		}
		if(max > 0)
			System.out.println(max);
		else
			System.out.println("존재하지않음");
		 */


		////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		// 버블정렬 -> 맨 앞부터 i-1까지 앞뒤 숫자 비교하여 앞숫자가 더 크면 두 수를 교환한다. 이 과정 반복하면 i자리에 가장 큰 숫자가 정렬된다.
		int num = sc.nextInt();
		int []arr = new int[num];

		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();
		sc.close();

		for(int i=num-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					int res = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = res;
				}
			}
		}

		for(int i=0; i<num; i++)
			System.out.println(arr[i] + " ");
			
		
		
	}

}
