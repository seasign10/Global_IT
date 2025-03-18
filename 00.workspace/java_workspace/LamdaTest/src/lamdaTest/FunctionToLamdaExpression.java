package lamdaTest;

interface A{
	void method1();
}
interface B{
	void method2(int a);
}
interface C{
	int method3();
}
interface D{
	double method4(int a, double b);
}

class AChild implements A{
	@Override // 필수
	public void method1() {
		System.out.println("method1() 오버라이딩");
		
	}
	
}
public class FunctionToLamdaExpression {

	public static void main(String[] args) {
		A a=new AChild();
		a.method1();
		
		// Anonymous Class
		A a1=new A() {
			@Override
			public void method1() {
				System.out.println("method1() 오버라이딩 (anonymous class)");
			}
		};
		a1.method1();
		
		// lamda expression
		A a2=()->System.out.println("method1() 오버라이딩 (lamda)");
//		A a2=()->{System.out.println("method1() 오버라이딩 (lamda)");};
		a2.method1();

	}

}
