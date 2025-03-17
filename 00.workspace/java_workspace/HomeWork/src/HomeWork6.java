import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 01. class 4개 상속이용해서 만들기
class Human{
	String name;
	int age;
	String gander;
	
	Human(){}
	
	Human(String n, int a, String g){
		this.name=n;
		this.age=a;
		this.gander=g;
	}
	
	void talk() {System.out.println("말하기");}
	void eat() {System.out.println("먹기");}
	void walk() {System.out.println("걷기");}
	void sleep() {System.out.println("잠자기");}
}

class Student extends Human{
	Student(String s1, int i, String s2) {
		super(s1,i,s2);
	}

	void study() {System.out.println("공부하기");}
}
class StudentWorker extends Student{
	public StudentWorker(String s1, int i, String s2) {
		super(s1,i,s2);
	}

	void work() {System.out.println("일하기");}
}
class Researcher extends Human{
	public Researcher(String s1, int i, String s2) {
		super(s1,i,s2);
	}
	
	void research() {System.out.println("연구하기");}
}
class Professor extends Researcher{
	public Professor(String s1, int i, String s2) {
		super(s1,i,s2);
	}

	void teach() {System.out.println("가르치기");}	
}

public class HomeWork6 {

	public static void main(String[] args) {
		// 02. ArrayList에 Student객체 3개 넣기
		ArrayList<Student> studentArray=new ArrayList<Student>();
		studentArray.add(new Student("이순신", 22, "남"));
		studentArray.add(new Student("장보고", 26, "남")); // 2번
		studentArray.add(new Student("신사임당", 23, "여"));
		
		// 03. HashMap에 2번 ArrayList 넣기
		// key값은 "컴퓨터공학과"
		Map<String, Student> hashStudent=new HashMap<String, Student>();
		hashStudent.put("컴퓨터공학과", studentArray.get(1));
		
		Set<String> keySet=hashStudent.keySet();
		for(String k:keySet) {
			System.out.println("["+k+"]");
			Student v=hashStudent.get(k);
			System.out.println(v.name);
			System.out.println(v.age);
			System.out.println(v.gander);
		}
	}

}
