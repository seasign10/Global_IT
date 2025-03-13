package com.toss.java;

class C1{
	C1(){
		System.out.println("C1생성자");
	}
	C1(int a){
		System.out.println("C1생성자 - "+a);
	}
}
class C2 extends C1{
	C2(){
		super(10);
		System.out.println("C2생성자");
	}
}
class C3 extends C2{
	C3(){
		System.out.println("C3생성자");		
	}
}

public class SuperMethod_1 {

	public static void main(String[] args) {
//		C2 c2=new C2();
		C2 c3=new C3();
	}

}
