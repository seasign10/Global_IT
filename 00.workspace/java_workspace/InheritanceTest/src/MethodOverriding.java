class Animal{
	void cry() {}
}
class Bird extends Animal{
	@Override
	void cry() {
		System.out.println("짹짹");
	}
}
class Cat extends Animal{
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Dog extends Animal{
	@Override
	void cry() {
		System.out.println("멍멍");
	}
}
public class MethodOverriding {

	public static void main(String[] args) {
		// 각각의 타입으로 선언 + 각각의 타입으로 생성
		Animal aa=new Animal();
		Bird bb=new Bird();
		Cat cc=new Cat();
		Dog dd=new Dog();
		aa.cry();
		bb.cry();
		cc.cry();
		dd.cry();
		System.out.println();
		

////		 클래스의 배열
//		Animal[] animals = new Animal[3];
////		 자식을 넣으려면 자식을 생성 해야함 (upcasting)
//		animals[0]=new Bird(); 
//		animals[1]=new Cat();
//		animals[2]=new Dog();
//		for (Animal animal : animals) {
//		    animal.cry();
//		}
		
		// 아래와 같이 작성 가능
		Animal[ ] animals = new Animal [ ] {new Bird( ), new Cat( ), new Dog( )};
		   for(Animal animal : animals) {
		       animal.cry( );
		  } //짹짹,야옹,멍멍
	}

}
