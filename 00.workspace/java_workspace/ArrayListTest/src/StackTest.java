import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		for(int a:stack) {
			System.out.println(a);
		}
		
		
		for(int i=0;i<3;i++) {
			 // 마지막 요소를 꺼냄
			System.out.println(stack.pop()); // 3 2 1
		}
	}

}
