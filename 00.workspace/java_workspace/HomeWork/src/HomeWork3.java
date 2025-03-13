import java.util.Scanner;

public class HomeWork3 {

	public static void main(String[] args) {
		// 01. 원의 면적 구하기 (반지름10)
		int radius=10;
		double extent = Math.ceil(radius*radius*3.14);
		System.out.println(extent+"(cm)");
		
		// 02. 01을 함수로 만들기
		getCircle(10);

		// 03. 02를 클래스로 만들기
		getCircle gc=new getCircle(10);
		gc.print();
		
		// 04. 학생의 이름, 국어,영어,수학 을 키보드 입력을 받아 평균 출력
		Scanner s=new Scanner(System.in);
		String name;
		String kor;
		String en;
		String math;
		while(true) {
			System.out.print("이름 : ");
			name=s.next();
			if(name.equals("quit")) {System.out.print("종료");break;};
			System.out.print("국어 점수 : ");
			kor=s.next();
			if(kor.equals("quit")) {System.out.print("종료");break;};
			System.out.print("영어 점수 : ");
			en=s.next();
			if(en.equals("quit")) {System.out.print("종료");break;};
			System.out.print("수학 점수 : ");
			math=s.next();
			if(math.equals("quit")) {System.out.print("종료");break;};
			
			double korScore = Double.parseDouble(kor);
            double enScore = Double.parseDouble(en);
            double mathScore = Double.parseDouble(math);
			Students getAvg=new Students(name, korScore, enScore, mathScore);
			getAvg.print();
		}
		
	}
	// 02.
	public static void getCircle(double radius){
		double extent = Math.ceil(radius*radius*3.14);
		System.out.println(extent+"(cm)");
	}

}
// 03.
class getCircle{
	double extent;
	getCircle(double radius){
		extent = Math.ceil(radius*radius*3.14);
	}
	void print(){
		System.out.println(extent+"(cm)");
	}
}

// 04.
class Students{
	String name;
    double grade;
  
    // print에서 각 점수 사용하지 않은 경우 필요 X
    double kor;
    double en;
    double math;
	
	Students(String name, double kor, double en, double math){
		this.name=name;
        // 각각의 점수 업데이트
		this.kor=kor;
		this.en=en;
		this.math=math;
      
		grade = Math.ceil((kor+en+math)/3);
	}
	
	void print() {
		System.out.println("[국어]"+kor);
		System.out.println("[영어]"+en);
		System.out.println("[수학]"+math);
		System.out.println(name+"의 평균은"+grade+"점 입니다.");
	}
}