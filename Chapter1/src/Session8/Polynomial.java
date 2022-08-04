package Session8;

import Session7.MySingleLinkedList;
import Session7.Node;

public class Polynomial {
	// name : �Լ��̸�, terms : ������ ���ܰ���Ŵ
	public char name;
	public MySingleLinkedList<Term> terms;
	
	// ������
	public Polynomial( char name ) {
		this.name = name;
		terms = new MySingleLinkedList<>();
	}
	
	// ��� �߰�(���, ����) - ������ ������������ ����
	public void addTerm( int val, int exp ) {
		// ����� 0 -> ����߰�����
		if(val == 0)
			return;
		
		// p�� ��������, q�� p�� �������
		Node<Term> p = terms.head, q= null;
		// p�� �����ϰ�, p�� ������ �Էµ� �������� ũ�ٸ� -> p�� ���� ������ q�� ����
		while(p != null && p.data.exp > exp) {
			q = p;
			p = p.next;
		}
		
		// p�� �����ϰ� p�� ������ �Է������� ���ٸ�
		if(p != null && p.data.exp == exp) {
			// -> ���� ����� �Էµ� ����� �����ش�.
			p.data.val += val;
			
			// ���� �� ����� 0�̶�� -> ��带 ����
			if(p.data.val == 0) {
				// �׷��� q�� null(p�� ��ó��)�̶�� -> ù��° ��带 ���� 
				if(q == null)
					terms.removeFirst();
				
				// p�� ��ó���ƴϸ� -> q(p �������)�� ������带 ����
				else
					terms.removeAfter(q);
			}
		}
		
		// �Է������� ��忡 ���������ʴ´ٸ�
		else {
			Term t = new Term(val, exp);
			// q�� null�϶�(�� ó���϶�) -> addFirst()�� ����߰�
			if(q == null)
				terms.addFirst(t);
			
			// q�� null�ƴҶ�(�� ó���϶�) -> addAfter(q)�� ����߰�
			else 
				terms.addAfter(q, t);
		}
		
	}
	
	
	// calc(x�� ��) - ��� ó������ ������ x�� ���־ ����� ��ȯ 
	public int calc( int x ) {
		// result���� ��������� ����ؼ� �����ִ� ����
		int result = 0;
		
		// ��� ó������ ������ Term�� calc�Լ��� ���� ������� �����ش�.
		Node<Term> p = terms.head;
		while(p != null) {
			result += p.data.calc( x );
			p = p.next;
		}
		
		return result;
	}
	
	
	// toString�� overRidding(String)
	public String toString() {
		String result = "";
		Node<Term> p = terms.head;
		while(p != null) {
			result += ("+" + p.data.toString());
			p=p.next;
		}
		
		return result;
	}
	
	/*
	// toString�� overRidding(StringBuilder)
	public String toString() {
		// StringBuilder�ε� �����ϴ�.
		StringBuilder result = new StringBuilder();
		
		Node<Term> p = terms.head;
		while(p != null) {
			result.append("+" + p.data.toString());
			p=p.next;
		}
		
		return result.toString();
	}
	*/
		
}
