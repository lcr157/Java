package Session4;

public class _2_클래스 {

	public static void main(String args[]) {
		// 하나의 객체 생성해서 값 넣기 -> 이상 없음
		_2_person first = new _2_person();
		first.name = "Lim";
		first.number = "01010101010";
		System.out.println(first.name + " : " + first.number);
		
		// 클래스 배열 생성
		// 배열만 생성해서 직접 값 넣으면 에러발생 -> 하나하나의 배열공간은 참조변수라 주소가 저장된다.
		// 값을 넣고싶으면 new키워드로 객체를 생성한 다음 값을 넣어줘야된다.
		_2_person []arr = new _2_person[100];
		//arr[0].name = "Kim";
		//arr[0].number = "010101010";
		//System.out.println(arr[0].name + " : " + arr[0].number);	// 이러면 안된다.
		
		arr[0] = new _2_person();
		arr[0].name = "Kim";
		arr[0].number = "010101010";
		System.out.println(arr[0].name + " : " + arr[0].number);	// 배열객체 -> 배열인덱스의 객체 생성 후 값 넣어주기
		
		
		
		
	}
}
