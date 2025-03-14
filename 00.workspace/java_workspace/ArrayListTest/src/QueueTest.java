import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// Queue는 자식 interface => 인스턴스 생성X
		// LinkedList는 부모 Class
		Queue<Integer> queue2=new LinkedList<Integer>(); // upcasting
		// enqueue
		queue2.offer(3); // 매개변수 item 추가
		queue2.offer(4);
		queue2.offer(5);
		for(int v:queue2) {
			System.out.println(v);
		}
		
		System.out.println(queue2.poll()); // 3 첫 번째부터 꺼냄
		System.out.println(queue2.poll()); // 4
		System.out.println(queue2.poll()); // 5
		System.out.println(queue2.poll()); // null
		// System.out.println(queue2.remove()); // error
	}

}
