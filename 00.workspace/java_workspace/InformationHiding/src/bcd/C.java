package bcd;

import abc.A;

public class C {
	public void print() {
		// 객체 생성
		A a=new A();
		
		// 멤버 활용
		System.out.print(a.a+" ");
		// 다른 패키지 내의 클래스에서는 자식 클래스가 아닐 때는 public 접근 지정자만 사용 가능
		// System.out.print(a.b+" ");
		// System.out.print(a.c+" ");
		// System.out.print(a.d+" "); 
		System.out.println();
	}
}
