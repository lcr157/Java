package Session1;

import java.util.Scanner;

public class Class02 {
	// �迭�� ���� ����

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		// �迭���� -> �ѹ��� ���� �����ϴ�.
		int []array1;
		array1 = new int[5];

		int []array2 = new int[5];


		// �迭��� -> �迭���̴� A.length �� �̿��ؼ� ���� �� ����
		array1[0] = 10; array1[1] = 20; array1[2] = 30; array1[3] = 40; array1[4] = 50;
		for(int i=0; i<array1.length; i++) {
			System.out.println(i+1 + "��° = " + array1[i]);
		}System.out.println();


		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		// ���� -> n�� �Է¹޾� �ּҰ� ���ϱ�
		/*
		int num = sc.nextInt();
		int []arr = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();

		int min = arr[0];
		for(int i=1; i<arr.length; i++)
			if(min > arr[i])
				min = arr[i];


		System.out.printf("�ּҰ� = %d\n\n", min);
		 */


		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		/*
		// ���� -> �Ҽ� ���ϱ�
		// Ư�� ���� ����� n/2���� Ŭ���� ���⿡ n/2������ ������
		int num = 129;
		boolean isPrime = true;
		// �ڵ� ����ȭ
		// 1.break���
		for(int i=2; i<=num/2; i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}


		// 2. ���ǿ� �߰�
		//for(int i=2; i<=num/2 && isPrime; i++)
		//	if(num % i == 0)
		//		isPrime = false;


		if(isPrime)
			System.out.println("�Ҽ�����");
		else
			System.out.println("�Ҽ��ƴ�");
		 */


		////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		/*
		// ���� -> n�� ���� �迭�Է¹޾� 0�� �̻� ���ӵ� �������� ���� ���� �� �ִ� �ִ밪 ���ϱ�
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
		// ���� -> n�� ���� �迭�Է¹޾� 1�� �̻� ���ӵ� �������� �ϳ��� ������ �����ϰ� �� ����� �Ҽ��� ������ �ִ밪 ���ϱ�
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

				// value�� 1�̸� �Ҽ��� �ƴϱ⿡ 1���� ū��� üũ�Ѵ�.
				if(isPrime && value > 1 && max < value)
					max = value;

			}
		}
		if(max > 0)
			System.out.println(max);
		else
			System.out.println("������������");
		 */


		////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		// �������� -> �� �պ��� i-1���� �յ� ���� ���Ͽ� �ռ��ڰ� �� ũ�� �� ���� ��ȯ�Ѵ�. �� ���� �ݺ��ϸ� i�ڸ��� ���� ū ���ڰ� ���ĵȴ�.
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
