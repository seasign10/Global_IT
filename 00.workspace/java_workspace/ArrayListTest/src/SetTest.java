import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> hSet1=new HashSet<>(); // upcasting
		hSet1.add("가");
		hSet1.add("나");
		hSet1.add("가");
		for(String s:hSet1) { // 가, 나
			System.out.println(s);
		}
		hSet1.add("다");
		for(String s:hSet1) { // 가, 다, 나
			System.out.println(s); // 입력된 순서대로 출력되지 않음
		}
		
		// set은 순서보다 종류가 중복되지 않게 하는 것을 중요하게 생각하는 자료구조

	}

}
