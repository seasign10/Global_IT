package lamdaTest;

interface A1{
	B1 abc();
}
class B1{
	B1(){
		System.out.println("첫 번째 생성자");
	}
	B1(int k){
		System.out.println("두 번째 생성자");
	}
}

public class RefOfClassConstructor_1 {

	public static void main(String[] args) {
		// 익명 클래스
		A1 a1=new A1() {
			@Override
			public B1 abc() {
				return new B1();
			}
		};
		
		// 람다식
		A1 a2=()->new B1();
		
		//클래스 생성자 참조
		A1 a3=B1::new;
		a1.abc();
		a2.abc();
		a3.abc();
	}

}
