// 사용자정의 Exception
class MinusException extends Exception{
	//생성자 오버로딩
	public MinusException() {
		super(); // 부모클래스의 생성자 호출
	}
	public MinusException(String message) {
		super(message); // 부모클래스의 생성자 호출
	}
}
class OverException extends Exception{
	//생성자 오버로딩
	public OverException() {
		super(); // 부모클래스의 생성자 호출
	}
	public OverException(String message) {
		super(message); // 부모클래스의 생성자 호출
	}
}

class GrageCalc{
	void checkScore(int score) throws MinusException,OverException{
		if(score<0) {
			throw new MinusException("예외 발생 : 음수값 입력");
		}else if(score>100) {
			throw new OverException("예외 발생 : 100점 초과");
		}
	}
}

public class UserExceptionExample {

	public static void main(String[] args) {
		GrageCalc a=new GrageCalc();
		try {
			a.checkScore(0);
			a.checkScore(150);
		}catch(MinusException | OverException e) {
			System.out.println(e.getMessage());
		}
	}

}
