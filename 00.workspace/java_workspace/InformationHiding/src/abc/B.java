package abc;

public class B {
	public void print() {
		// 객체 생성
		A a=new A();
		
		//멤버 활용
		System.out.print(a.a+" "); // 클래스 A는 같은 패키지에 있으므로 public, protected, default 접근 지정자로 지정된 필드는 접근 가능
		System.out.print(a.b+" ");
		System.out.print(a.c+" ");
		// System.out.print(a.d+" "); // private 접근지정자로 지정된 필드는 접근 불가
		System.out.println();
	}
}
