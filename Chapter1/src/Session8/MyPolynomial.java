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

	// �Լ� ����
	public void handleCreate() {
		char name = sc.next().charAt(0);
		Polynomial p = new Polynomial(name);
		polys[n++] = p;
	}

	// ��� ����
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
	
	// �Լ� ���
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
	
	// �Լ� ȣ��
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
	// �����Լ�
	public static void main(String args[]) {
		// ���� - ���׽� ����� ����ϴ� ���α׷� 
		// create : �Լ� �����, add : �Լ��� ����߰�
		// print : �Լ� ���, calc : x������ ������, exit : ���α׷� ����
		MyPolynomial app = new MyPolynomial();
		app.processCommand();
	}
	
}
