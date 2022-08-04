package Session8;

import Session7.MySingleLinkedList;
import Session7.Node;

public class Polynomial {
	// name : 함수이름, terms : 노드들의 집단가리킴
	public char name;
	public MySingleLinkedList<Term> terms;
	
	// 생성자
	public Polynomial( char name ) {
		this.name = name;
		terms = new MySingleLinkedList<>();
	}
	
	// 노드 추가(계수, 차수) - 차수는 오름차순으로 삽입
	public void addTerm( int val, int exp ) {
		// 계수가 0 -> 노드추가안함
		if(val == 0)
			return;
		
		// p는 노드시작점, q는 p의 이전노드
		Node<Term> p = terms.head, q= null;
		// p가 존재하고, p의 차수가 입력된 차수보다 크다면 -> p의 이전 차수를 q로 저장
		while(p != null && p.data.exp > exp) {
			q = p;
			p = p.next;
		}
		
		// p가 존재하고 p의 차수가 입력차수와 같다면
		if(p != null && p.data.exp == exp) {
			// -> 기존 계수에 입력된 계수를 더해준다.
			p.data.val += val;
			
			// 만약 그 결과가 0이라면 -> 노드를 삭제
			if(p.data.val == 0) {
				// 그런데 q가 null(p가 맨처음)이라면 -> 첫번째 노드를 삭제 
				if(q == null)
					terms.removeFirst();
				
				// p가 맨처음아니면 -> q(p 이전노드)의 다음노드를 삭제
				else
					terms.removeAfter(q);
			}
		}
		
		// 입력차수가 노드에 존재하지않는다면
		else {
			Term t = new Term(val, exp);
			// q가 null일때(맨 처음일때) -> addFirst()로 노드추가
			if(q == null)
				terms.addFirst(t);
			
			// q가 null아닐때(맨 처음일때) -> addAfter(q)로 노드추가
			else 
				terms.addAfter(q, t);
		}
		
	}
	
	
	// calc(x의 값) - 노드 처음부터 끝까지 x에 값넣어서 계산결과 반환 
	public int calc( int x ) {
		// result에는 결과값들을 계속해서 더해주는 변수
		int result = 0;
		
		// 노드 처음부터 끝까지 Term의 calc함수를 통해 계산결괄르 더해준다.
		Node<Term> p = terms.head;
		while(p != null) {
			result += p.data.calc( x );
			p = p.next;
		}
		
		return result;
	}
	
	
	// toString의 overRidding(String)
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
	// toString의 overRidding(StringBuilder)
	public String toString() {
		// StringBuilder로도 가능하다.
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
