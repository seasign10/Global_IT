public class ExternalCallMethods {

	public static void main(String[] args) {
		// 객체 생성 / A클래스 사용 > instance 생성
		B a=new B(); // a : reference 변수, a에 들어있는 참조 값을 사용해서 A의 인스턴스를 찾을 수 있음
		B b; // b : reference 변수, b는 A의 인스턴스를 가리킬 예정, 아직은 reference(참조)가 없음
		
		// 메서드 호출
		a.print();
		int k=a.data();
		a.data();
		System.out.println(k);
		double result=a.sum(3,5.2);
		System.out.println(result);
		a.printMonth(5);
		a.printMonth(15);

	}

}
//클래스 정의
class B {
	// return type : void, 입력매개변수X
	void print() {
		System.out.println("안녕");
	}
	
	// return type : int, 입력매개변수X
	int data() {
		return 3;
	}
	
	// return type : double, 입력매개변수 2개
	double sum(int a, double b) {
		return a+b;
	}
	
	// return type : void, 내부에 리턴 포함(함수 종료)
	void printMonth(int m) {
		if(m<0 || m>12) {
			System.out.println("잘못된 입력");
			return;
		}
		System.out.println(m+"월 입니다.");
	}
	
}
