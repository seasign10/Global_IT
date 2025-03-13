package com.naver.ex01;

// 서로 다른 패키지에 있는 ABCD 임포트
import abc.A;
import abc.B;
import bcd.C;
import bcd.D;

public class AccessModifierOfMember {

	public static void main(String[] args) {
		A a=new A();
		B b=new B();
		C c=new C();
		D d=new D();
		
		a.print();
		b.print();
		c.print();
		d.print();		
	}

}
