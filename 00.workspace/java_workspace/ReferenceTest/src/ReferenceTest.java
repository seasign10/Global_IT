class A{// 클래스(설계도/추상) 생성
	int m=3; // 멤버 변수. field
	// 멤버변수. method
	void print() {
		System.out.println("객체 생성 및 활용");
	}
}

public class ReferenceTest {
	public static void main(String[] args) {
		int[] a= {1,2,3};
		int[] b;
		b=a;
		
		for(int j:a) {
			System.out.println(j);
		}
		for(int k:b) {
			System.out.println(k);
		}
		System.out.println(a==b); // true
		
		a[0]=100;
		for(int l:a) {
			System.out.println(l);
		}
		for(int m:b) {
			System.out.println(m);
		}
		System.out.println(a==b); // true
		

		// 예시2		
		String str1=new String("안녕");
		String str2=str1;
		System.out.println(str1); // 안녕
		System.out.println(str2); // 안녕
		
		str2="감사"; //"감사"를 새로 만들고 str2가 "감사"를 가리킴
		System.out.println(str1); // 안녕
		System.out.println(str2); // 감사
		
		A a1=new A();
		A a2; // A타입 객체
		a2=a1;// a1의 레퍼런스 복제 
		System.out.println(a1.m); // 3
		System.out.println(a2.m); // 3
		System.out.println(a1.m==a2.m); // true
		a1.print();
		a2.print();
		
		a1.m=100;
		System.out.println(a1.m); // 100
		System.out.println(a2.m); // 100
		
		a2.m=200;
		System.out.println(a1.m); // 200
		System.out.println(a2.m); // 200

	}

}
