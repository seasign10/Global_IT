interface A{
	static final int a=3; // 상수
	void abc(); // 추상 메서드
	void efg();
}

class B implements A{
	@Override
	public void abc() {
		System.out.println("abc()오버라이딩");
	}
	@Override
	public void efg() {
		System.out.println("efg()오버라이딩");
	}
}

public class CreateObjectOfInterface_1 {

	public static void main(String[] args) {
		A b1=new B(); // upcasting
		B b2=new B();
		
		b1.abc();
		b2.abc();

	}

}
