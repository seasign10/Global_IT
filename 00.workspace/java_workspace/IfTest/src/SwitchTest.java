import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int value1=s.nextInt(); // 정수를 받아서 변수에 저장
		switch(value1/10) {
			case 10:
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			default:
				System.out.println("D");
		}
	}
}
