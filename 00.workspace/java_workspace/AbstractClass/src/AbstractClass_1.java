abstract class A{
	 abstract void abc(); // 추상메서드
}
class B extends A{
	// 추상클래스의 자식클래스는 부모의 추상메서드를 반드시 override해야 함.
	@Override
	void abc() {
		System.out.println("부모의 abc() 오버라이딩");
	}
}
public class AbstractClass_1 {

	public static void main(String[] args) {
		// A a=new A(); // A로 인스턴스 생성 불가
		A b=new B(); // upcasting
		b.abc();
	}

}
