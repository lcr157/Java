package Session4;

public class _2_Ŭ���� {

	public static void main(String args[]) {
		// �ϳ��� ��ü �����ؼ� �� �ֱ� -> �̻� ����
		_2_person first = new _2_person();
		first.name = "Lim";
		first.number = "01010101010";
		System.out.println(first.name + " : " + first.number);
		
		// Ŭ���� �迭 ����
		// �迭�� �����ؼ� ���� �� ������ �����߻� -> �ϳ��ϳ��� �迭������ ���������� �ּҰ� ����ȴ�.
		// ���� �ְ������ newŰ����� ��ü�� ������ ���� ���� �־���ߵȴ�.
		_2_person []arr = new _2_person[100];
		//arr[0].name = "Kim";
		//arr[0].number = "010101010";
		//System.out.println(arr[0].name + " : " + arr[0].number);	// �̷��� �ȵȴ�.
		
		arr[0] = new _2_person();
		arr[0].name = "Kim";
		arr[0].number = "010101010";
		System.out.println(arr[0].name + " : " + arr[0].number);	// �迭��ü -> �迭�ε����� ��ü ���� �� �� �־��ֱ�
		
		
		
		
	}
}
