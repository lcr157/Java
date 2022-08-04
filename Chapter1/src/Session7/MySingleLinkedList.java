package Session7;

public class MySingleLinkedList<T> {

	public Node<T> head;
	public int size;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////

	// addFirst (저장할 데이터) - 맨 처음에 노드 추가
	public void addFirst( T item ) {

		// 1. 새로운 노드 생성 
		// T타입의 변수 생성은 가능
		Node<T> newNode = new Node<>(item);
		// T타입의 배열 생성은 불가능!!
		// Node<T> []arr = new Node<>[100];

		// 2. 새로운 node의 next는 현재 head노드를 가리키게 설정
		newNode.next = head;

		// 3. head노드를 새로운 node로 설정
		head = newNode;

		// 4. size를 증가시킴
		size++;
	}


	// addAfter (특정노드, 저장할 데이터) - 특정노드 다음에 새로운 노드를 추가한다.
	public void addAfter( Node<T> before, T item ) {
		// 1. 새로운 node생성
		Node<T> newNode = new Node<>(item);

		// 2. 새로운 노드 다음는 특정노드의 다음노드를 가리킨다.
		newNode.next = before.next;

		// 3. 이전노드의 다음이 새로운 노드를 가리켜서 이전노드 -> 새로운노드 -> 이전다음노드 형태로 만들어준다.
		before.next = newNode;

		// 4. size를 증가시킴
		size++;
	}

	
	// insert (삽입할 인덱스, 데이터)
	public void add( int index, T item ) {
		// 1. index가 0보다작거나 size넘어가면 -> 종료
		if(index < 0 || index > size )
			return;

		// 2. index = 0 -> addFirst로 노드추가
		if(index == 0) {
			addFirst(item);
		}

		// 3. index가 [0,size)면 -> getNode(index-1)로 노드찾고 addAfter(찾은노드, data)로 바로 뒤에 노드추가
		else {
			Node<T> findNode = getNode(index-1);
			addAfter(findNode, item);
		}
		
	}

	
	// removeFirst() - 첫번쨰 노드 삭제 후 값 반환
	public T removeFirst() {
		// 노드가 하나도 없는상태라면 -> 그대로 종료
		if(head == null)
			return null;

		// 그렇지않으면 -> 
		// 1. head의 데이터 따로 저장
		T data = head.data;

		// 2. head를 두 번째 노드 가리키게 변경 
		head = head.next;

		// 3. size 감소
		size--;

		return data;
	}


	// removeAfter(이전 노드) - 이전노드의 다음노드를 삭제 후 데이터 반환하고, [이전노드 -> 삭제노드 다음노드] 형태로 바꿔줌
	public T removeAfter(Node<T> before) {
		// 1. 이전노드의 다음노드가 null이라면(마지막 노드라면) -> null로 반환
		if(before.next == null) {
			return null;
		}

		// 2. 삭제할 노드의 데이터값 저장
		T data = before.next.data;

		// 3. 이전노드의 다음노드를 삭제 다음노드로 설정
		size--;
		before.next = before.next.next;

		return data;
	}


	// indexOf( 찾을 데이터 ) - 노드 순회하면서 데이터값을 찾아 해당 노드의 인덱스를 반환한다.
	public int indexOf( T item ) {
		// 1. p에는 head값부터 시작하고, index = 0으로 시작
		Node<T> p = head;
		int index = 0;

		// 2. 노드 순회하면서 p의 데이터가 찾으려는 데이터와 같으면 해당 인덱스값 반환
		while (p != null) {
			if( p.data.equals(item) )
				return index;

			// p는 다음노드로 이동하면서 index를 증가시킴
			p = p.next;
			index++;
		}

		// 3. 노드에 데이터가 없다면 -> -1반환
		return -1;
	}


	// getNode (인덱스 번호) - 인덱스번째 노드 가져오기
	public Node<T> getNode(int index) {
		// 인덱스가 0이거나 size넘어가면 -> 종료
		if(index < 0 || index >= size)
			return null;
		
		// 2. p에 head를 넣고 다음노드로 index번만큼 이동한다.
		Node<T> p = head;
		for(int i=0; i<index; i++)
			p = p.next;
		
		// 3. p의 값을 반환
		return p;
	}
	
	
	// getData (인덱스 번호) - 인덱스번째 노드의 데이터 가져오기
	public T getData(int index) {
		// 1. index가 0보다 작거나 노드갯수보다 크면 -> 종료
		if(index < 0 || index >= size)
			return null;
		
		// 2. 해당 노드
		return getNode(index).data;
	}
	

	// delete (삭제할 인덱스)
	public T remove( int index ) {
		// 1. index < 0 이거나 size보다 크거나같으면 -> 종료
		if(index <0 || index >= size)
			return null;
		
		// 2. index = 0 -> 첫번째 노드삭제 
		if(index == 0) {
			return removeFirst();
		}
		
		// 3. 그 외의경우 -> getNode(index-1)로 삭제할 인덱스 바로전 노드 찾고, removeAfter()로 다음노드 삭제 
		else {
			Node<T> findNode = getNode(index-1);
			return removeAfter(findNode);
		}
	}
	
	
	// remove(찾을 데이터) - 데이터에 해당하는 노드를 삭제 후 데이터반환
	public T remove( T item ) {
		// p는 head, q는 p의 이전노드
		Node<T> p = head, q = null;
		// p가 노드내에있으면서 p의 데이터가 찾는데이터와 같지않으면 -> q는 p의 이전값으로 저장
		while(p != null && ! p.data.equals(item) ) {
			q = p;
			p = p.next;
		}
		
		// 만약 p가 null이면(마지막까지 데이터가 존재하지않거나 노드가 존재하지않으면) -> 종료
		if( p == null ) {
			return null;
		}
		// q가 null이면(p는 존재하나 q가 null이면) -> 맨 처음값이 찾는 노드임을 뜻한다.
		if( q == null ) {
			return removeFirst();
		}
		// 그렇지않으면 -> q는 삭제해야될 이전노드이기에 removeAfter()로 다음노드 삭제
		else {
			return removeAfter(q);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	// 메인함수 
	public static void main(String args[]) {
		MySingleLinkedList<String> list = new MySingleLinkedList<>();
		list.add(0, "Thursday");			// T
		
		list.add(1, "Saturday");			// T S
		
		list.add(0, "Wendsday");			// W T S
		
		list.add(2, "Friday");				// W T F S
		
		Node<String> str = list.getNode(2);	// Friday
		
		list.remove(2);						// W T S
		
		int pos = list.indexOf("Saturday");	// 2
		
	}
}
