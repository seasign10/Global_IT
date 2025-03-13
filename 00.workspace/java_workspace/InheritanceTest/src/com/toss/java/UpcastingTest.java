package com.toss.java;

/**********************************************
 upcasting을 활용하는 예
**********************************************/

class Shape{
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape{
	@Override
	public void draw() {
		System.out.println("Line");		
	}
}
class Rectangle extends Shape{
	@Override
	public void draw() {
		System.out.println("Rectangle");	
	}
}
class Triangle extends Shape{
	@Override
	public void draw() {
		System.out.println("Triangle");	
	}
}

public class UpcastingTest {
	// paint 메서드에서 draw 메서드 호출(upscating 활용)
	// draw() 호출 가능
	// 자식 클래스가 새로 추가되어도 paint()는 변경없이 사용 가능. 확장성이 높다.
	static void paint(Shape p) {
		p.draw();
	}

	public static void main(String[] args) {
		Line line=new Line();
		paint(line); // upcasting. Line to Shape
		paint(new Rectangle()); // upcasting. Rect to Shape
		paint(new Shape());
		paint(new Triangle()); // upcasting. triangle to Shape
	}

}
