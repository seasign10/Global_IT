import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// Set<Integer> treeSet=new TreeSet<>(); // upcasting
		TreeSet<Integer> treeSet=new TreeSet<>();
		for(int i=50;i>0;i-=2) {
			treeSet.add(i);
		}
		for(int j:treeSet) { // 50부터가 아닌, 2부터 출력
			System.out.println(j);
		}
		
		System.out.println(treeSet.first()); // 2
		System.out.println(treeSet.last()); // 50
		System.out.println(treeSet.lower(26)); // 24
		System.out.println(treeSet.higher(26)); // 28

		NavigableSet<Integer> descendingSet=treeSet.descendingSet();
		for(int k:descendingSet) {
			System.out.println(k);
		}
		
		TreeSet<Integer> treeSet2=new TreeSet<>();
		// 무작위 입력
		treeSet2.add(20);
		treeSet2.add(12);
		treeSet2.add(48);
		treeSet2.add(71);
		treeSet2.add(24);
		treeSet2.add(35);
		treeSet2.add(19);
		for(int l:treeSet2) { // 크기 순서대로 출력
			System.out.println(l);
		}
	}

}
