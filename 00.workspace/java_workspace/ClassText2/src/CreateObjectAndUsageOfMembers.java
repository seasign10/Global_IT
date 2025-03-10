class A{// 클래스(설게도/추상) 생성
	int m=3; // 멤버 변수. field
	// 멤버변수. method
	void print() {
		System.out.println("객체 생성 및 활용");
	}
}

public class CreateObjectAndUsageOfMembers {
	public static void main(String[] args) {
		// 인스턴스(instance/실체) 생성
		// a는 레퍼런스 변수. a가 가리키는 곳에는 A타입의 인스턴스가 존재.
		// A타입(사용할 클래스의 이름을 타입으로 지정)의 a변수에, A클래스를 호출해서 변수 할당
		A a=new A();
		
		// a의 m에 접근
		System.out.println(a.m); // 3
		
		a.m=5;
		System.out.println(a.m); // 5
		
		a.print(); // a의 print()호출
		
		A b=new A();
		System.out.println(b.m); // 3
	}
}
