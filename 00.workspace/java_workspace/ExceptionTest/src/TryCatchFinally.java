import java.util.Scanner;

public class TryCatchFinally {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try {
			System.out.println("분자 : ");
			int num1=s.nextInt();
			System.out.println("분모 : ");
			int num2=s.nextInt();
			System.out.println(num1/num2);		
		}catch(ArithmeticException e){ // 분모가 0일 경우 무한값이 나오기 때문에 오류
			e.printStackTrace(); // 디버깅용 에러 확인
			System.out.println(e.getMessage()); // 오류 메세지
			System.out.println("분모에는 0이 들어갈 수 없습니다.");			
		}finally {
			// 무조건 실행, 확실한 방법
			s.close();
		}
	}

}
