class A{
	int m1,m2,m3,m4;
	// 생성자가 없으면 호출 시, 생성자 자동 생성
	
	// 생성자(기본값)
	A(){
		this.m1=1;
		this.m2=2;
		this.m3=3;
		this.m4=4;
	}
	
	// 생성자 오버로딩1
	A(int a){
		this(); // A()를 호출해서 변수 초기화(세팅)
		this.m1=a; // m1만 변경
	}
	
	// 생성자 오버로딩2
	A(int a, int b){
		this(a); // A(int a) 호출
		this.m2=b; // m2만 변경
	}
	
	void print() {
		System.out.print(m1+" ");
		System.out.print(m2+" ");
		System.out.print(m3+" ");
		System.out.print(m4);
		System.out.println();
	}
}
public class ThisMethod_2 {

	public static void main(String[] args) {
		A a=new A();
		a.m1=10;
		System.out.println(a.m1); // 10
		
		A a1=new A();
		A a2=new A(10);
		A a3=new A(10, 20);	
		a1.print(); // 1 2 3 4
		a2.print(); // 10 2 3 4
		a3.print(); // 10 20 3 4
	}

}
