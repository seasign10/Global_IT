import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Student{
	String name;
	String department;
	
	Student(){}
	Student(String name, String department){
		this.name=name;
		this.department=department;
	}
}
public class CollectionTest {

	public static void main(String[] args) {
		// ArrayList에 Student클래스 사용 (타입: Student 클래스)
		ArrayList<Student> list=new ArrayList<Student>();
		list.add(new Student("홍길동", "컴퓨터공학")); // 인스턴스 생성
		list.add(new Student("심청", "법률"));
		list.add(new Student("심봉사", "사회봉사"));
		list.add(new Student("점순이", "유아교육"));
		list.add(new Student("이순신", "조선공업"));
		list.add(new Student("장보고", "무역학"));
		list.add(new Student("세종대왕", "국어국문"));

		for(Student s:list) {
			System.out.print("이름 : "+s.name+", ");
			System.out.println("학과 : "+s.department);
		}
		
		// HashMap에 Student클래스 사용
		Map<String,Student> students=new HashMap<String,Student>(); // upcasting
		students.put("jwr", new Student("자우림","실용음악"));
		students.put("ssid", new Student("신사임당","순수회화미술"));
		Set<String> keySet=students.keySet();
		for(String s:keySet) {
			System.out.println(s); // 키
			System.out.println(students.get(s).name); // 값
			System.out.println(students.get(s).department); // 값
		}
	}

}
