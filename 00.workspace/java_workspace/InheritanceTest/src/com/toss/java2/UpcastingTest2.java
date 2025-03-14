package com.toss.java2;

/**********************************************
 upcasting을 활용하는 예
**********************************************/

interface Shape{ // 인터페이스
	public void draw();
}

class Line implements Shape{
	// 반드시 오버라이딩 해야함
	@Override
	public void draw() {
		System.out.println("Line");		
	}
}
class Rectangle implements Shape{
	@Override
	public void draw() {
		System.out.println("Rectangle");	
	}
}
class Triangle implements Shape{
	@Override
	public void draw() {
		System.out.println("Triangle");	
	}
}

public class UpcastingTest2 {
	public static void main(String[] args) {
		// Shape shape=new Shape(); // 인터페이스는 객체생성을 할 수 없다.
		
		// upcasting (확장이 용이) 자식클래스를 계속 추가해도 코드의 변화가 적다.
		Line line=new Line();
		line.draw();
		Shape rectangle=new Rectangle();
		rectangle.draw();
		Shape triangle=new Triangle();
		triangle.draw();
	}

}
