import java.util.Scanner;

class A {
    int num1;
    int num2;

    // throws는 직접 예외를 처리하지 않고 메서드를 호출한 쪽에서
    // 예외를 처리하도록 예외를 전달(throws)
    int divide() throws ArithmeticException {
        return this.num1 / this.num2;
    }
}

public class ThrowTest {
    public static void main(String[] args) {
        A a = new A();
        Scanner s = new Scanner(System.in);
        
        System.out.print("분자 : ");
        a.num1 = s.nextInt();
        System.out.print("분모 : ");
        a.num2 = s.nextInt();
        
        try {
            System.out.println("결과: " + a.divide());
        } catch (ArithmeticException e) {
        	e.printStackTrace();
            System.out.println("오류: 0으로 나눌 수 없습니다."); // 예외 처리
        }

        s.close(); // Scanner 닫기
    }
}
