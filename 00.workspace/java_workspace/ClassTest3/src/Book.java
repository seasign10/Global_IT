// 1. 클래스 생성
public class Book {
	String title;
	String author;
	int price;
	
	Book(){
		this.title="미정";
		this.author="미정";
		this.price=0;
	}
	
	// 생성자 오버로딩1
	Book(String title){
		this(); // Book()호출 기본값 세팅
		this.title=title; // 제목만 변경
	}
	
	// 생성자 오버로딩2
	Book(String title, String author, int price){
		this(title); // Book(String title)호출. 제목변경
		this.author=author; // 작성자 변경
		this.price=price; // 가격 변경
	}
	
	// return값이 없으면 void
	void showInfo() {
//		 System.out.println(title+", "+author+", "+price);
		// 위와 똑같음
		 System.out.println(this.title +", "+ this.author +", "+ this.price);
	}
}
