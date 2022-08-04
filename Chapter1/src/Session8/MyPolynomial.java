package Session8;

import java.util.Scanner;

public class MyPolynomial {
	private Polynomial []polys = new Polynomial[100];
	private int n = 0;
	Scanner sc = new Scanner(System.in);

	public MyPolynomial() {
	}

	public void processCommand() {

		while(true) {
			System.out.print("$ ");
			String command = sc.next();
			
			if(command.equalsIgnoreCase("create"))
				handleCreate();
			else if(command.equalsIgnoreCase("add"))
				handleAdd();
			else if(command.equalsIgnoreCase("calc"))
				handleCalc();
			else if(command.equalsIgnoreCase("print"))
				handlePrint();
			else if(command.equalsIgnoreCase("exit"))
				break;
		}
		sc.close();

	}

	// 함수 생성
	public void handleCreate() {
		char name = sc.next().charAt(0);
		Polynomial p = new Polynomial(name);
		polys[n++] = p;
	}

	// 노드 생성
	public void handleAdd() {
		char name = sc.next().charAt(0);
		int val = sc.nextInt();
		int exp = sc.nextInt();
		
		int index = find(name);
		if(index < 0) {
			System.out.println("No such polynomial");
			return;
		}
		
		polys[index].addTerm(val, exp);
	}
	
	public int find(char name) {
		for(int i=0; i<n; i++)
			if(polys[i].name == name)
				return i;
		return -1;
	}
	
	// 함수 계산
	public void handleCalc() {
		char name = sc.next().charAt(0);
		int x = sc.nextInt();
		
		int index = find(name);
		if(index < 0) {
			System.out.println("No such polynomial");
			return;
		}
		
		System.out.println( polys[index].calc(x) );
	}
	
	// 함수 호출
	public void handlePrint() {
		char name = sc.next().charAt(0);
		int index = find(name);
		
		if(index < 0) {
			System.out.println("No such polynomial");
			return;
		}
		
		System.out.println( polys[index].toString() );
	}


	////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	// 메인함수
	public static void main(String args[]) {
		// 문제 - 다항식 만들고 계산하는 프로그램 
		// create : 함수 만들기, add : 함수에 노드추가
		// print : 함수 출력, calc : x값넣은 결과출력, exit : 프로그램 종료
		MyPolynomial app = new MyPolynomial();
		app.processCommand();
	}
	
}
