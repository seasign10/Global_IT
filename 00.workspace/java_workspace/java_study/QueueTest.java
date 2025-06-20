import java.util.ArrayList;

class Queue{

	private ArrayList<String> arrayQueue = new ArrayList<String>();
	public void enqueue(String data) {
		arrayQueue.add(data);
	}
    
	public String dequeue() {
            if(arrayQueue.size()==0) {
                System.out.println("데이터가 존재 하지 않습니다.");
                return null;
            }
	    return arrayQueue.remove(0);
	}
}

public class QueueTest {
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
	
}
출처: https://junghn.tistory.com/entry/JAVA-arrayList를-이용하여-Stack-Queue-구현하기 [코딩 시그널:티스토리]