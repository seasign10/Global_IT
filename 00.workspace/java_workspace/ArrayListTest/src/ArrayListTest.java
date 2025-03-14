import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> aList=new ArrayList<String>(); // upcasting
		System.out.println(aList.size()); // arrayList의 크기
		aList.add("가");
		aList.add("나");
		aList.add("다");
		aList.add("라");
		System.out.println(aList.size()); // arrayList의 크기
		aList.remove("다");
		aList.remove("라");
		System.out.println(aList.size()); // arrayList의 크기
		System.out.println(aList.get(0)); // 가
		
		for(String s:aList) {
			System.out.println(s);
		}
		
		aList.clear(); // 모든 요소 삭제
		for(String s:aList) {
			System.out.println(s);
		}
		
		System.out.println(aList.isEmpty());
	}
}
