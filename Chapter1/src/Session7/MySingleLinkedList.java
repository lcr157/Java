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

	// addFirst (������ ������) - �� ó���� ��� �߰�
	public void addFirst( T item ) {

		// 1. ���ο� ��� ���� 
		// TŸ���� ���� ������ ����
		Node<T> newNode = new Node<>(item);
		// TŸ���� �迭 ������ �Ұ���!!
		// Node<T> []arr = new Node<>[100];

		// 2. ���ο� node�� next�� ���� head��带 ����Ű�� ����
		newNode.next = head;

		// 3. head��带 ���ο� node�� ����
		head = newNode;

		// 4. size�� ������Ŵ
		size++;
	}


	// addAfter (Ư�����, ������ ������) - Ư����� ������ ���ο� ��带 �߰��Ѵ�.
	public void addAfter( Node<T> before, T item ) {
		// 1. ���ο� node����
		Node<T> newNode = new Node<>(item);

		// 2. ���ο� ��� ������ Ư������� ������带 ����Ų��.
		newNode.next = before.next;

		// 3. ��������� ������ ���ο� ��带 �����Ѽ� ������� -> ���ο��� -> ����������� ���·� ������ش�.
		before.next = newNode;

		// 4. size�� ������Ŵ
		size++;
	}

	
	// insert (������ �ε���, ������)
	public void add( int index, T item ) {
		// 1. index�� 0�����۰ų� size�Ѿ�� -> ����
		if(index < 0 || index > size )
			return;

		// 2. index = 0 -> addFirst�� ����߰�
		if(index == 0) {
			addFirst(item);
		}

		// 3. index�� [0,size)�� -> getNode(index-1)�� ���ã�� addAfter(ã�����, data)�� �ٷ� �ڿ� ����߰�
		else {
			Node<T> findNode = getNode(index-1);
			addAfter(findNode, item);
		}
		
	}

	
	// removeFirst() - ù���� ��� ���� �� �� ��ȯ
	public T removeFirst() {
		// ��尡 �ϳ��� ���»��¶�� -> �״�� ����
		if(head == null)
			return null;

		// �׷��������� -> 
		// 1. head�� ������ ���� ����
		T data = head.data;

		// 2. head�� �� ��° ��� ����Ű�� ���� 
		head = head.next;

		// 3. size ����
		size--;

		return data;
	}


	// removeAfter(���� ���) - ��������� ������带 ���� �� ������ ��ȯ�ϰ�, [������� -> ������� �������] ���·� �ٲ���
	public T removeAfter(Node<T> before) {
		// 1. ��������� ������尡 null�̶��(������ �����) -> null�� ��ȯ
		if(before.next == null) {
			return null;
		}

		// 2. ������ ����� �����Ͱ� ����
		T data = before.next.data;

		// 3. ��������� ������带 ���� �������� ����
		size--;
		before.next = before.next.next;

		return data;
	}


	// indexOf( ã�� ������ ) - ��� ��ȸ�ϸ鼭 �����Ͱ��� ã�� �ش� ����� �ε����� ��ȯ�Ѵ�.
	public int indexOf( T item ) {
		// 1. p���� head������ �����ϰ�, index = 0���� ����
		Node<T> p = head;
		int index = 0;

		// 2. ��� ��ȸ�ϸ鼭 p�� �����Ͱ� ã������ �����Ϳ� ������ �ش� �ε����� ��ȯ
		while (p != null) {
			if( p.data.equals(item) )
				return index;

			// p�� �������� �̵��ϸ鼭 index�� ������Ŵ
			p = p.next;
			index++;
		}

		// 3. ��忡 �����Ͱ� ���ٸ� -> -1��ȯ
		return -1;
	}


	// getNode (�ε��� ��ȣ) - �ε�����° ��� ��������
	public Node<T> getNode(int index) {
		// �ε����� 0�̰ų� size�Ѿ�� -> ����
		if(index < 0 || index >= size)
			return null;
		
		// 2. p�� head�� �ְ� �������� index����ŭ �̵��Ѵ�.
		Node<T> p = head;
		for(int i=0; i<index; i++)
			p = p.next;
		
		// 3. p�� ���� ��ȯ
		return p;
	}
	
	
	// getData (�ε��� ��ȣ) - �ε�����° ����� ������ ��������
	public T getData(int index) {
		// 1. index�� 0���� �۰ų� ��尹������ ũ�� -> ����
		if(index < 0 || index >= size)
			return null;
		
		// 2. �ش� ���
		return getNode(index).data;
	}
	

	// delete (������ �ε���)
	public T remove( int index ) {
		// 1. index < 0 �̰ų� size���� ũ�ų������� -> ����
		if(index <0 || index >= size)
			return null;
		
		// 2. index = 0 -> ù��° ������ 
		if(index == 0) {
			return removeFirst();
		}
		
		// 3. �� ���ǰ�� -> getNode(index-1)�� ������ �ε��� �ٷ��� ��� ã��, removeAfter()�� ������� ���� 
		else {
			Node<T> findNode = getNode(index-1);
			return removeAfter(findNode);
		}
	}
	
	
	// remove(ã�� ������) - �����Ϳ� �ش��ϴ� ��带 ���� �� �����͹�ȯ
	public T remove( T item ) {
		// p�� head, q�� p�� �������
		Node<T> p = head, q = null;
		// p�� ��峻�������鼭 p�� �����Ͱ� ã�µ����Ϳ� ���������� -> q�� p�� ���������� ����
		while(p != null && ! p.data.equals(item) ) {
			q = p;
			p = p.next;
		}
		
		// ���� p�� null�̸�(���������� �����Ͱ� ���������ʰų� ��尡 ��������������) -> ����
		if( p == null ) {
			return null;
		}
		// q�� null�̸�(p�� �����ϳ� q�� null�̸�) -> �� ó������ ã�� ������� ���Ѵ�.
		if( q == null ) {
			return removeFirst();
		}
		// �׷��������� -> q�� �����ؾߵ� ��������̱⿡ removeAfter()�� ������� ����
		else {
			return removeAfter(q);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	// �����Լ� 
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
